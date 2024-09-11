package com.base.engine;

/**
 * This class represents a Quaternion, used for rotations in 3D space.
 * It consists of four components: x, y, z (the vector part), and w (the scalar part).
 */
public class Quaternion {
    
    // Quaternion components: x, y, z (vector part) and w (scalar part).
    private float x;
    private float y;
    private float z;
    private float w;

    /**
     * Constructor to create a new Quaternion with specified components.
     *
     * @param x The x-component of the quaternion.
     * @param y The y-component of the quaternion.
     * @param z The z-component of the quaternion.
     * @param w The w-component (scalar part) of the quaternion.
     */
    public Quaternion(float x, float y, float z, float w) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
        this.setW(w);
    }

    /**
     * Calculates the length (or magnitude) of the quaternion.
     *
     * @return The length of the quaternion as a float.
     */
    public float length() {
        // Length is the square root of the sum of the squares of all components.
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    /**
     * Normalizes the quaternion so its length becomes 1, transforming it into a unit quaternion.
     *
     * @return The normalized quaternion (this).
     */
    public Quaternion normalize() {
        // Divide each component by the length of the quaternion.
        float length = length();
        x /= length;
        y /= length;
        z /= length;
        w /= length;

        return this; // Return the normalized quaternion.
    }

    /**
     * Calculates the conjugate of this quaternion.
     * The conjugate is obtained by negating the vector part (x, y, z) while keeping the scalar part (w) unchanged.
     *
     * @return The conjugate quaternion.
     */
    public Quaternion conjugate() {
        // Conjugate quaternion has negated x, y, z but the same w.
        return new Quaternion(-x, -y, -z, w);
    }

    /**
     * Multiplies this quaternion by another quaternion.
     * This operation combines two rotations represented by quaternions.
     *
     * @param r The quaternion to multiply with.
     * @return A new quaternion representing the result of the multiplication.
     */
    public Quaternion mul(Quaternion r) {
        // Perform quaternion multiplication based on the Hamilton product.
        float w_ = w * r.getW() - x * r.getX() - y * r.getY() - z * r.getZ();
        float x_ = x * r.getW() + w * r.getX() + y * r.getZ() - z * r.getY();
        float y_ = y * r.getW() + w * r.getY() + z * r.getX() - x * r.getZ();
        float z_ = z * r.getW() + w * r.getZ() + x * r.getY() - y * r.getX();

        // Return a new quaternion with the result.
        return new Quaternion(x_, y_, z_, w_);
    }

    /**
     * Multiplies this quaternion by a 3D vector, using quaternion-vector multiplication.
     *
     * @param r The 3D vector to multiply with (as a Vector3f).
     * @return A new quaternion representing the result of the multiplication.
     */
    public Quaternion mul(Vector3f r) {
        // Perform multiplication between the quaternion and the vector.
        float w_ = -x * r.getX() - y * r.getY() - z * r.getZ();
        float x_ = w * r.getX() + y * r.getZ() - z * r.getY();
        float y_ = w * r.getY() + z * r.getX() - x * r.getZ();
        float z_ = w * r.getZ() + x * r.getY() - y * r.getX();

        // Return a new quaternion with the result.
        return new Quaternion(x_, y_, z_, w_);
    }

    // Getters and setters for the quaternion components.

    /**
     * Gets the x-component of the quaternion.
     *
     * @return The x-component as a float.
     */
    public float getX() {
        return x;
    }

    /**
     * Sets the x-component of the quaternion.
     *
     * @param x The x-component to set.
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Gets the y-component of the quaternion.
     *
     * @return The y-component as a float.
     */
    public float getY() {
        return y;
    }

    /**
     * Sets the y-component of the quaternion.
     *
     * @param y The y-component to set.
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Gets the z-component of the quaternion.
     *
     * @return The z-component as a float.
     */
    public float getZ() {
        return z;
    }

    /**
     * Sets the z-component of the quaternion.
     *
     * @param z The z-component to set.
     */
    public void setZ(float z) {
        this.z = z;
    }

    /**
     * Gets the w-component (scalar part) of the quaternion.
     *
     * @return The w-component as a float.
     */
    public float getW() {
        return w;
    }

    /**
     * Sets the w-component (scalar part) of the quaternion.
     *
     * @param w The w-component to set.
     */
    public void setW(float w) {
        this.w = w;
    }
}
