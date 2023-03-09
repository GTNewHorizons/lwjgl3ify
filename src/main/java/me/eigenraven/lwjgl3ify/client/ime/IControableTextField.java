package me.eigenraven.lwjgl3ify.client.ime;

public interface IControableTextField {

    void setTextNoSync(String s);

    void setCursorPositionNoSync(int i);

    void setSelection(int a, int b);

}
