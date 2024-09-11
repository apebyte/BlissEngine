package com.base.engine;

public class Vector3f {
    // Private member variables for the x, y, and z components of the vector
    private float x;
    private float y;
    private float z;
    
    // Constructor to initialize the vector with x, y, and z components
    public Vector3f(float x, float y, float z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }
    
    // Method to calculate the length (magnitude) of the vector
    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z); // Using Pythagoras theorem in 3D
    }
    
    // Method to calculate the dot product between this vector and another vector
    public float dot(Vector3f r) {
        return x * r.getX() + y * r.getY() * r.getZ(); // Dot product formula: x1 * x2 + y1 * y2 + z1 * z2
    }
    
    // Method to normalize the vector (convert it to a unit vector)
    public Vector3f normalize() {
        float length = length(); // Get the length of the vector
                
        x /= length;  // Divide x by the length to normalize
        y /= length;  // Divide y by the length to normalize
        z /= length;  // Divide z by the length to normalize
        
        return this;  // Return the normalized vector
    }
    
    // Placeholder method for vector rotation (not implemented)
    public Vector3f rotate() {
        return null;  // Rotation logic can be implemented as needed
    }
    
    // Method to add this vector to another vector
    public Vector3f add(Vector3f r) {
        return new Vector3f(x + r.getX(), y + r.getY(), z + r.getZ()); // Add corresponding components
    }
    
    // Method to add a scalar to all components of the vector
    public Vector3f add(float r) {
        return new Vector3f(x + r, y + r, z + r); // Add scalar to x, y, and z
    }
    
    // Method to subtract another vector from this vector
    public Vector3f sub(Vector3f r) {
        return new Vector3f(x - r.getX(), y - r.getY(), z - r.getZ()); // Subtract corresponding components
    }
    
    // Method to subtract a scalar from all components of the vector
    public Vector3f sub(float r) {
        return new Vector3f(x - r, y - r, z - r); // Subtract scalar from x, y, and z
    }
    
    // Method to multiply this vector by another vector (component-wise multiplication)
    public Vector3f mul(Vector3f r) {
        return new Vector3f(x * r.getX(), y * r.getY(), z * r.getZ()); // Multiply corresponding components
    }
    
    // Method to calculate the cross product of this vector with another vector
    public Vector3f cross(Vector3f r) {
        float x_ = y * r.getZ() - z * r.getY(); // Cross product formula for the x component
        float y_ = z * r.getX() - x * r.getZ(); // Cross product formula for the y component
        float z_ = x * r.getY() - y * r.getX(); // Cross product formula for the z component
        
        return new Vector3f(x_, y_, z_); // Return the new vector resulting from the cross product
    }
    
    // Method to multiply all components of the vector by a scalar
    public Vector3f mul(float r) {
        return new Vector3f(x * r, y * r, z * r); // Multiply x, y, and z by the scalar
    }
    
    // Method to divide this vector by another vector (component-wise division)
    public Vector3f div(Vector3f r) {
        return new Vector3f(x / r.getX(), y / r.getY(), z / r.getZ()); // Divide corresponding components
    }
    
    // Method to divide all components of the vector by a scalar
    public Vector3f div(float r) {
        return new Vector3f(x / r, y / r, z / r); // Divide x, y, and z by the scalar
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

    // Getter for the z component of the vector
    public float getZ() {
        return z;
    }

    // Setter for the z component of the vector
    public void setZ(float z) {
        this.z = z;
    }
}
