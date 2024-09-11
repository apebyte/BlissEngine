package com.base.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {
    // Creates a window with the specified width, height, and title
    public static void createWindow(int width, int height, String title) {
        Display.setTitle(title);  // Set the title of the window
        try {
            // Set the display mode with the specified width and height
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();  // Create the window with the current display settings
            Keyboard.create();
            Mouse.create();
        } catch (LWJGLException e) {
            e.printStackTrace();  // Print the stack trace if there's an issue creating the window
        }
    }

    // Updates the display; this should be called each frame to render the window's contents
    public static void render() {
        Display.update();  // Update the window with the latest rendered content
    }

    // Cleans up resources and destroys the window
    public static void dispose() {
        Display.destroy();  // Close the window and release resources
        Keyboard.destroy();
        Mouse.destroy();
    }

    // Checks if the window close button has been pressed
    public static boolean isCloseRequested() {
        return Display.isCloseRequested();  // Return true if the user has requested to close the window
    }

    // Returns the current width of the window
    public static int getWidth() {
        return Display.getDisplayMode().getWidth();  // Get the width of the current display mode
    }

    // Returns the current height of the window
    public static int getHeight() {
        return Display.getDisplayMode().getHeight();  // Get the height of the current display mode
    }

    // Returns the current title of the window
    public static String getTitle() {
        return Display.getTitle();  // Get the title of the window
    }
}
