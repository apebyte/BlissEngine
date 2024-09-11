package com.base.engine;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 * The Input class handles the current state of keyboard and mouse input.
 * It tracks which keys and mouse buttons are currently pressed, just pressed, or just released.
 */
public class Input {
    // Constants representing the number of key codes and mouse buttons to track.
    public static final int NUM_KEYCODES = 256; // Total number of keys supported.
    public static final int NUM_MOUSEBUTTONS = 5; // Total number of mouse buttons supported.

    // Lists to track the current, down, and up states of keys and mouse buttons.
    private static ArrayList<Integer> currentKeys = new ArrayList<Integer>(); // Currently pressed keys.
    private static ArrayList<Integer> downKeys = new ArrayList<Integer>(); // Keys that were just pressed.
    private static ArrayList<Integer> upKeys = new ArrayList<Integer>(); // Keys that were just released.

    private static ArrayList<Integer> currentMouse = new ArrayList<Integer>(); // Currently pressed mouse buttons.
    private static ArrayList<Integer> downMouse = new ArrayList<Integer>(); // Mouse buttons that were just pressed.
    private static ArrayList<Integer> upMouse = new ArrayList<Integer>(); // Mouse buttons that were just released.

    /**
     * Updates the state of the input (keyboard and mouse). 
     * It checks which keys and mouse buttons are currently pressed, were just pressed, or were just released.
     */
    public static void update() {
        // Clear the list of mouse buttons that were released and update it.
        upMouse.clear();
        for (int i = 0; i < NUM_MOUSEBUTTONS; i++) {
            if (!getMouse(i) && currentMouse.contains(i)) {
                upMouse.add(i); // Mouse button was just released.
            }
        }

        // Clear the list of mouse buttons that were pressed and update it.
        downMouse.clear();
        for (int i = 0; i < NUM_MOUSEBUTTONS; i++) {
            if (getMouse(i) && !currentMouse.contains(i)) {
                downMouse.add(i); // Mouse button was just pressed.
            }
        }

        // Clear the list of keys that were released and update it.
        upKeys.clear();
        for (int i = 0; i < NUM_KEYCODES; i++) {
            if (!getKey(i) && currentKeys.contains(i)) {
                upKeys.add(i); // Key was just released.
            }
        }

        // Clear the list of keys that were pressed and update it.
        downKeys.clear();
        for (int i = 0; i < NUM_KEYCODES; i++) {
            if (getKey(i) && !currentKeys.contains(i)) {
                downKeys.add(i); // Key was just pressed.
            }
        }

        // Update the list of currently pressed keys.
        currentKeys.clear();
        for (int i = 0; i < NUM_KEYCODES; i++) {
            if (getKey(i)) {
                currentKeys.add(i); // Key is currently pressed.
            }
        }

        // Update the list of currently pressed mouse buttons.
        currentMouse.clear();
        for (int i = 0; i < NUM_MOUSEBUTTONS; i++) {
            if (getMouse(i)) {
                currentMouse.add(i); // Mouse button is currently pressed.
            }
        }
    }

    /**
     * Checks if a specific key is currently pressed.
     *
     * @param keyCode The key code of the key to check.
     * @return True if the key is pressed, false otherwise.
     */
    public static boolean getKey(int keyCode) {
        return Keyboard.isKeyDown(keyCode);
    }

    /**
     * Checks if a specific key was just pressed down (not held).
     *
     * @param keyCode The key code of the key to check.
     * @return True if the key was just pressed, false otherwise.
     */
    public static boolean getKeyDown(int keyCode) {
        return downKeys.contains(keyCode);
    }

    /**
     * Checks if a specific key was just released.
     *
     * @param keyCode The key code of the key to check.
     * @return True if the key was just released, false otherwise.
     */
    public static boolean getKeyUp(int keyCode) {
        return upKeys.contains(keyCode);
    }

    /**
     * Checks if a specific mouse button is currently pressed.
     *
     * @param mouseButton The mouse button to check.
     * @return True if the mouse button is pressed, false otherwise.
     */
    public static boolean getMouse(int mouseButton) {
        return Mouse.isButtonDown(mouseButton);
    }

    /**
     * Checks if a specific mouse button was just pressed down (not held).
     *
     * @param mouseButton The mouse button to check.
     * @return True if the mouse button was just pressed, false otherwise.
     */
    public static boolean getMouseDown(int mouseButton) {
        return downMouse.contains(mouseButton);
    }

    /**
     * Checks if a specific mouse button was just released.
     *
     * @param mouseButton The mouse button to check.
     * @return True if the mouse button was just released, false otherwise.
     */
    public static boolean getMouseUp(int mouseButton) {
        return upMouse.contains(mouseButton);
    }

    /**
     * Returns the current position of the mouse cursor as a Vector2f object.
     *
     * @return A Vector2f object representing the current X and Y coordinates of the mouse.
     */
    public static Vector2f getMousePosition() {
        return new Vector2f(Mouse.getX(), Mouse.getY()); // Return the current mouse X and Y coordinates.
    }
}
