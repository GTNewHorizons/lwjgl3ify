/*
 * Copyright (c) 2002-2008 LWJGL Project
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * * Neither the name of 'LWJGL' nor the names of
 * its contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjglx.util.jinput;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import net.java.games.input.AbstractComponent;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Event;
import net.java.games.input.Keyboard;
import net.java.games.input.Rumbler;

/**
 * @author elias
 */
final class LWJGLKeyboard extends Keyboard {

    LWJGLKeyboard() {
        super("LWJGLKeyboard", createComponents(), new Controller[] {}, new Rumbler[] {});
    }

    private static Component[] createComponents() {
        List<Key> components = new ArrayList<Key>();
        Field[] vkey_fields = org.lwjglx.input.Keyboard.class.getFields();
        for (Field vkey_field : vkey_fields) {
            try {
                if (Modifier.isStatic(vkey_field.getModifiers()) && vkey_field.getType() == int.class
                    && vkey_field.getName()
                        .startsWith("KEY_")) {
                    int vkey_code = vkey_field.getInt(null);
                    Component.Identifier.Key key_id = KeyMap.map(vkey_code);
                    if (key_id != Component.Identifier.Key.UNKNOWN) components.add(new Key(key_id, vkey_code));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return components.toArray(new Component[components.size()]);
    }

    public synchronized void pollDevice() throws IOException {
        if (!org.lwjglx.input.Keyboard.isCreated()) return;
        org.lwjglx.input.Keyboard.poll();
        for (Component component : getComponents()) {
            Key key = (Key) component;
            key.update();
        }
    }

    protected synchronized boolean getNextDeviceEvent(Event event) throws IOException {
        if (!org.lwjglx.input.Keyboard.isCreated()) return false;
        if (!org.lwjglx.input.Keyboard.next()) return false;
        int lwjgl_key = org.lwjglx.input.Keyboard.getEventKey();
        if (lwjgl_key == org.lwjglx.input.Keyboard.KEY_NONE) return false;
        Component.Identifier.Key key_id = KeyMap.map(lwjgl_key);
        if (key_id == null) return false;
        Component key = getComponent(key_id);
        if (key == null) return false;
        float value = org.lwjglx.input.Keyboard.getEventKeyState() ? 1 : 0;
        event.set(key, value, org.lwjglx.input.Keyboard.getEventNanoseconds());
        return true;
    }

    private static final class Key extends AbstractComponent {

        private final int lwjgl_key;
        private float value;

        Key(Identifier.Key key_id, int lwjgl_key) {
            super(key_id.getName(), key_id);
            this.lwjgl_key = lwjgl_key;
        }

        public void update() {
            this.value = org.lwjglx.input.Keyboard.isKeyDown(lwjgl_key) ? 1 : 0;
        }

        protected float poll() {
            return value;
        }

        public boolean isRelative() {
            return false;
        }

        public boolean isAnalog() {
            return false;
        }
    }
}
