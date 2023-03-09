package me.eigenraven.lwjgl3ify.mixins.game.ime;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import me.eigenraven.lwjgl3ify.client.ime.ICursorProvider;

import net.minecraft.client.gui.FontRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.ibm.icu.text.BreakIterator;

@Mixin(FontRenderer.class)
public class MixinFontRenderer implements ICursorProvider {

    private final BreakIterator BREAK_ITERATOR = BreakIterator.getLineInstance();
    public int lastX, lastY;
    @Shadow
    public int FONT_HEIGHT;

    @Shadow
    public int getCharWidth(char p_78263_1_) {
        return 0;
    }

    @Shadow
    private static boolean isFormatColor(char colorChar) {
        return false;
    }

    @Inject(method = "listFormattedStringToWidth", at = @At("HEAD"), cancellable = true)
    private void ICU4JLineBreaking(String str, int wrapWidth, CallbackInfoReturnable<List> cir) {
        // They don't render and should not be feed into iterator
        String cleanStr = str.replaceAll("§.", "").replaceAll("§", "");
        BREAK_ITERATOR.setText(cleanStr);
        List<String> list = new ArrayList<>();
        String format = ""; // For last line's format since it should use format of previous line
        StringBuilder nextFormat = new StringBuilder();
        int i = 0, j = 0, k, l;

        Stack<Integer> lastReseti = new Stack<>();
        Stack<Integer> lastResetRi = new Stack<>();
        lastReseti.push(0);
        lastResetRi.push(0);
        int strWidth = 0;
        int prevBreak = 0;
        boolean bold = false;
        char c, f, back;
        int prevCandidate;
        do {
            switch (c = str.charAt(i)) {
                case '\n' -> {
                    list.add(nextFormat.substring(lastResetRi.peek()) + str.substring(prevBreak, i));
                    format = nextFormat.toString();
                    prevBreak = i + 1;
                    strWidth = 0;
                }
                case '§' -> { // format start
                    if (i + 1 < str.length()) { // Prevent out of bound
                        f = str.charAt(++i);
                        nextFormat.append('§').append(f); // Add to current format code
                        if (f != 'l' && f != 'L') { // Check start of bold style
                            if (f == 'r' || f == 'R' || isFormatColor(f)) { // Not Bold, check end of style
                                bold = false;
                                lastReseti.push(i - 1); // push reset location in str and format to stack
                                lastResetRi.push(nextFormat.length());
                            }
                        } else {
                            bold = true;
                        }
                    }
                }
                default -> {
                    strWidth += getCharWidth(c);
                    if (bold) {
                        // Bold style is fat
                        strWidth += 1;
                    }
                }
            }
            if (strWidth > wrapWidth) {
                BREAK_ITERATOR.following(j); // The legal break right after j
                prevCandidate = BREAK_ITERATOR.previous(); // Find the nearest legit break
                k = i;
                l = j;
                if (prevCandidate > -1) {
                    while (l > prevCandidate && k > 0) { // Backward searching to get actual format at break
                        k--;
                        l--;
                        back = str.charAt(k);
                        if (back == '§') {
                            if (k == lastReseti.peek()) {
                                lastReseti.pop(); // Remove reset
                                lastResetRi.pop();
                            }
                            nextFormat.delete(nextFormat.length() - 2, nextFormat.length()); // Remove format
                            l++;
                        }
                    }
                }
                if (k <= prevBreak) {
                    k = i; // Break in previous line, not usable, set it to current i
                }
                if (str.charAt(k - 1) == '§') {
                    k--; // Make sure not to break in format code. Can't figure out how to put it in while(), so
                }
                list.add(nextFormat.substring(lastResetRi.peek()) + str.substring(prevBreak, k));
                format = nextFormat.toString();
                if (k != i) {
                    j = prevCandidate; // k!=i means usable break point found, j should back to corresponding location
                }
                prevBreak = k;
                i = k;
                strWidth = getCharWidth(c); // Width of first char of new line.
            }
            i++;
            j++;
        } while (i < str.length());
        list.add(format + str.substring(prevBreak));
        lastX = strWidth;
        lastY = FONT_HEIGHT * list.size();
        cir.setReturnValue(list);
    }

    @Override
    public int getLastX() {
        return lastX;
    }

    @Override
    public int getLastY() {
        return lastY;
    }
}
