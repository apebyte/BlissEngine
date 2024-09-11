package com.base.engine;

public class Time {
    // Constant representing one second in nanoseconds
    public static final long SECOND = 1000000000L;

    // Variable to store the delta time (time between frames)
    private static double delta;

    // Returns the current time in nanoseconds
    public static long getTime() {
        return System.nanoTime();
    }

    // Returns the delta time (time passed between frames)
    public static double getDelta() {
        return delta;
    }

    // Sets the delta time (used to update the game logic with time between frames)
    public static void setDelta(double delta) {
        Time.delta = delta;
    }
}
