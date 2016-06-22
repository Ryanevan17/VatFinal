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
public class Cilinder extends Shape{
    
    private int radius;
    private int height;
    
    /**
     * @param radius
     * @param height 
     */
    public Cilinder(int radius, int height)
    {
        super(ShapeType.CILINDER, Math.PI * Math.pow(radius, 2) * height);
        this.radius = radius;
        this.height = height;
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
     * override standard method
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