/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainlayer;

/**
 *
 * @author jnmkimpton
 */

public class Sphere extends Shape{
    
    private int radius;
    
    /**
     * @param radius 
     */
    
    public Sphere(int radius) {
        super(ShapeType.SPHERE, (((double) 4 / (double) 3) * Math.PI * Math.pow(radius, 3)));
        this.radius = radius;
    }
    
    /**
     * Get radius
     * 
     * @return radius
     */
    @Override
    public int getRadius()
    {
        return radius;
    }
    
    /**
     * Overrides standard methode
     * 
     * @return textstring 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getType());
        sb.append(": (");
        sb.append(" r: ");
        sb.append(getRadius());
        sb.append(" )");

        return sb.toString();
    }
}