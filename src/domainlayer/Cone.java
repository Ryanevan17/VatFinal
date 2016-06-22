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

public class Cone extends Shape {
    
    private int height;
    private int radius;
    
    /**
     * @param height
     * @param radius 
     */
    public Cone(int height, int radius) {
        super(ShapeType.CONE, (((double) 1 / (double) 3) * Math.PI * Math.pow(radius, 2) * height));
        this.height = height;
        this.radius = radius;
    }
    
    /**
     * height
     * 
     * @return height 
     */
    @Override
    public int getHeight()
    {
        return height;
    }
    
    /**
     * radius
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
     * @return text string 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getType());
        sb.append(": (");
        sb.append(" r: ");
        sb.append(getRadius());
        sb.append(", h: ");
        sb.append(getHeight());
        sb.append(" )");

        return sb.toString();
    }
    
    
}
