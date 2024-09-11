package com.base.engine;

/**
 * This class represents a 4x4 matrix, commonly used in 3D graphics.
 */
public class Matrix4f {

    // The 4x4 matrix represented as a 2D array of floats.
    private float[][] m;

    /**
     * Default constructor that initializes the matrix.
     */
    public Matrix4f() {
        // Initializes the matrix as a 4x4 array.
        setM(new float[4][4]);
    }

    /**
     * Initializes the matrix to the identity matrix, where all diagonal elements
     * are 1, and all other elements are 0.
     * 
     * @return This Matrix4f object, initialized to the identity matrix.
     */
    public Matrix4f initIdentity() {
        m[0][0] = 1; m[0][1] = 0; m[0][2] = 0; m[0][3] = 0;
        m[1][0] = 0; m[1][1] = 1; m[1][2] = 0; m[1][3] = 0;
        m[2][0] = 0; m[2][1] = 0; m[2][2] = 1; m[2][3] = 0;
        m[3][0] = 0; m[3][1] = 0; m[3][2] = 0; m[3][3] = 1;

        return this;
    }

    /**
     * Multiplies this matrix by another matrix and returns the result as a new matrix.
     * 
     * @param r The right-hand side matrix to multiply by.
     * @return The result of the matrix multiplication as a new Matrix4f object.
     */
    public Matrix4f mul(Matrix4f r) {
        Matrix4f res = new Matrix4f(); // Resultant matrix after multiplication.

        // Perform matrix multiplication by summing the products of row and column elements.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                float sum = 0;
                for (int k = 0; k < 4; k++) {
                    sum += m[i][k] * r.get(k, j); // Multiply row elements of this matrix by column elements of r.
                }
                res.set(i, j, sum); // Set the resulting value in the corresponding position in the result matrix.
            }
        }
        return res; // Return the resultant matrix.
    }

    /**
     * Getter for the matrix.
     * 
     * @return The 4x4 matrix as a 2D float array.
     */
    public float[][] getM() {
        return m;
    }

    /**
     * Retrieves the element at position (x, y) in the matrix.
     * 
     * @param x The row index (0-3).
     * @param y The column index (0-3).
     * @return The float value at position (x, y).
     */
    public float get(int x, int y) {
        return m[x][y];
    }

    /**
     * Setter for the entire matrix.
     * 
     * @param m The new 4x4 matrix to set.
     */
    public void setM(float[][] m) {
        this.m = m;
    }

    /**
     * Sets the value at position (x, y) in the matrix.
     * 
     * @param x     The row index (0-3).
     * @param y     The column index (0-3).
     * @param value The value to set at the specified position.
     */
    public void set(int x, int y, float value) {
        m[x][y] = value;
    }
}
