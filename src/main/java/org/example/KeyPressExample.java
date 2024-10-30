package org.example;



import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.GlobalScreen;

import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyPressExample implements NativeKeyListener {

    public static void main(String[] args) {
        // Disable logging to avoid clutter in the console
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);

        try {
            // Register the native hook
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            System.err.println("There was a problem registering the native hook.");
            e.printStackTrace();
            System.exit(1);
        }

        // Create an instance of the key press listener
        KeyPressExample example = new KeyPressExample();
        GlobalScreen.addNativeKeyListener(example);
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            // Unregister and exit on ESC key press
            try {
                GlobalScreen.unregisterNativeHook();
                System.out.println("Exiting...");
                System.exit(0);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }
}
