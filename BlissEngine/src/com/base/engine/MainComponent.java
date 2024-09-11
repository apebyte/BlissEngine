package com.base.engine;

public class MainComponent {
    // Constants for window width, height, title, and frame cap
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "Bliss Engine";
    public static final double FRAME_CAP = 5000.0;

    // Instance variables to track game state
    private boolean isRunning;
    private Game game;

    // Constructor initializes the game and sets isRunning to false
    public MainComponent() {
        isRunning = false;
        game = new Game();
    }

    // Method to start the game loop if it isn't already running
    public void start() {
        if (isRunning) {
            return;  // If the game is already running, do nothing
        }
        run();  // Otherwise, start the game loop
    }

    // Method to stop the game loop
    public void stop() {
        if (!isRunning) {
            return;  // If the game isn't running, do nothing
        }
        isRunning = false;  // Otherwise, stop the game loop
    }

    // Main game loop, handles updating and rendering the game
    private void run() {
        isRunning = true;

        int frames = 0;  // Counts frames per second
        long frameCounter = 0;  // Tracks time to calculate FPS

        final double frameTime = 1.0 / FRAME_CAP;  // Time per frame based on FRAME_CAP

        long lastTime = Time.getTime();  // Gets the current time
        double unprocessedTime = 0;  // Accumulates time for processing

        while (isRunning) {
            boolean render = false;  // Flag to indicate if the game should render

            long startTime = Time.getTime();  // Get the current time at the start of the loop
            long passedTime = startTime - lastTime;  // Calculate time passed since last frame
            lastTime = startTime;  // Update lastTime

            unprocessedTime += passedTime / (double) Time.SECOND;  // Convert passed time to seconds
            frameCounter += passedTime;  // Accumulate passed time to track FPS

            // Process game logic while unprocessed time exceeds frame time
            while (unprocessedTime > frameTime) {
                render = true;  // Game should render this frame

                unprocessedTime -= frameTime;  // Decrease unprocessed time by frame time

                if (Window.isCloseRequested()) {  // Check if the window should be closed
                    stop();  // Stop the game loop if close is requested
                }

                Time.setDelta(frameTime);  // Update the delta time
                Input.update();

                game.input();  // Handle game input
                game.update();  // Update game state

                // Print and reset the frame counter every second
                if (frameCounter >= Time.SECOND) {
                    System.out.println(frames);
                    frames = 0;
                    frameCounter = 0;
                }
            }

            // If rendering is needed, call the render method
            if (render) {
                render();
                frames++;
            }

            // If no rendering is needed, sleep for a short time to save CPU
            else {
                try {
                    Thread.sleep(1);  // Sleep for 1 millisecond
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        cleanUp();  // Clean up resources after the game loop ends
    }

    // Method to render the game and the window
    private void render() {
        game.render();
        Window.render();
    }

    // Method to clean up resources, like disposing of the window
    private void cleanUp() {
        Window.dispose();
    }

    // Main method, entry point of the application
    public static void main(String[] args) {
        Window.createWindow(WIDTH, HEIGHT, TITLE);  // Create the game window
        MainComponent game = new MainComponent();  // Create an instance of MainComponent
        game.start();  // Start the game loop
    }
}
