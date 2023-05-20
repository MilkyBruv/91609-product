package awtgl.window;

import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class KeyHandler {

    private static final Map<Integer, Boolean> pressedKeysCodesMap = new HashMap<>();
    private static final Map<Character, Boolean> pressedKeysCharsMap = new HashMap<>();

    static {

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(event -> {

            synchronized (KeyHandler.class) {

                if (event.getID() == KeyEvent.KEY_PRESSED) { 
                    
                    pressedKeysCodesMap.put(event.getKeyCode(), true);
                    pressedKeysCharsMap.put(event.getKeyChar(), true);
                
                }

                else if (event.getID() == KeyEvent.KEY_RELEASED) {

                    pressedKeysCodesMap.put(event.getKeyCode(), false);
                    pressedKeysCharsMap.put(event.getKeyChar(), false);

                }

                return false;

            }

        });

    }

    

    public static boolean isKeyPressed(int keyCode) {
        
        return pressedKeysCodesMap.getOrDefault(keyCode, false);

    }



    public static boolean isKeyPressed(char keyChar) {

        return pressedKeysCharsMap.getOrDefault(keyChar, false);

    }



    public static int[] getPressedKeyCodes() {

        List<Integer> keyCodes = new ArrayList<Integer>() {};

        for (Integer code : pressedKeysCodesMap.keySet()) {
            
            if (pressedKeysCodesMap.getOrDefault(code, false)) {

                keyCodes.add(code);

            }

        }

        return keyCodes.stream().mapToInt(Integer::intValue).toArray();

    } 



    public static char[] getPressedKeyChars() {

        List<Character> keyChars = new ArrayList<Character>() {};

        for (Character code : pressedKeysCharsMap.keySet()) {
            
            if (pressedKeysCharsMap.getOrDefault(code, false)) {

                keyChars.add(code);

            }

        }

        return keyChars.stream().map(String::valueOf).collect(Collectors.joining()).toCharArray();

    } 

}