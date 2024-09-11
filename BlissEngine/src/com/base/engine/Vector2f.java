package com.base.engine;

public class Vector2f {
    // Private member variables for the x and y components of the vector
    private float x;
    private float y;
    
    // Constructor to initialize the vector with x and y components
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    // Method to calculate the length (magnitude) of the vector
    public float length() {
        return (float) Math.sqrt(x * x + y * y); // Using Pythagoras theorem
    }
    
    // Method to calculate the dot product between this vector and another vector
    public float dot(Vector2f r) {
        return x * r.getX() + y * r.getY(); // Dot product formula: x1 * x2 + y1 * y2
    }
    
    // Method to normalize the vector (convert it to a unit vector)
    public Vector2f normalize() {
        float length = length(); // Get the length of the vector
        
        x /= length;  // Divide x by the length to normalize
        y /= length;  // Divide y by the length to normalize
        
        return this;  // Return the normalized vector
    }
    
    // Method to rotate the vector by a given angle (in degrees)
    public Vector2f rotate(float angle) {
        double rad = Math.toRadians(angle);  // Convert the angle to radians
        double cos = Math.cos(rad);  // Calculate cosine of the angle
        double sin = Math.sin(rad);  // Calculate sine of the angle
        
        // Apply rotation matrix and return the rotated vector
        return new Vector2f((float)(x * cos - y * sin), (float)(x * sin + y * cos));
    }
    
    // Method to add this vector to another vector
    public Vector2f add(Vector2f r) {
        return new Vector2f(x + r.getX(), y + r.getY()); // Add corresponding components
    }
    
    // Method to add a scalar to both components of the vector
    public Vector2f add(float r) {
        return new Vector2f(x + r, y + r); // Add scalar to both x and y
    }
    
    // Method to subtract another vector from this vector
    public Vector2f sub(Vector2f r) {
        return new Vector2f(x - r.getX(), y - r.getY()); // Subtract corresponding components
    }
    
    // Method to subtract a scalar from both components of the vector
    public Vector2f sub(float r) {
        return new Vector2f(x - r, y - r); // Subtract scalar from both x and y
    }
    
    // Method to multiply this vector by another vector (component-wise multiplication)
    public Vector2f mul(Vector2f r) {
        return new Vector2f(x * r.getX(), y * r.getY()); // Multiply corresponding components
    }
    
    // Method to multiply both components of the vector by a scalar
    public Vector2f mul(float r) {
        return new Vector2f(x * r, y * r); // Multiply both x and y by scalar
    }
    
    // Method to divide this vector by another vector (component-wise division)
    public Vector2f div(Vector2f r) {
        return new Vector2f(x / r.getX(), y / r.getY()); // Divide corresponding components
    }
    
    // Method to divide both components of the vector by a scalar
    public Vector2f div(float r) {
        return new Vector2f(x / r, y / r); // Divide both x and y by scalar
    }
    
    // Method to return the string representation of the vector (for easy display)
    public String toString() {
        return "(" + x + " " + y + ")";  // Format: (x y)
    }
    
    // Getter for the x component of the vector
    public float getX() {
        return x;
    }

    // Setter for the x component of the vector
    public void setX(float x) {
        this.x = x;
    }

    // Getter for the y component of the vector
    public float getY() {
        return y;
    }

    // Setter for the y component of the vector
    public void setY(float y) {
        this.y = y;
    }
}
