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

public class Block extends Shape {
    
    
    private int length;
    private int width;
    private int height;
    
    /**
     * @param length
     * @param width
     * @param height 
     */
    public Block(int length, int width, int height)
    {
        super(ShapeType.BLOCK, length * width * height);
        this.length = length;
        this.width = width;
        this.height = height;  
    }
    
    /**
     * length
     * 
     * @return length
     */
    @Override
    public int getLength()
    {
        return length;
    }
    
    /**
     * width
     * 
     * @return width
     */
    @Override
    public int getWidth()
    {
        return width;
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
     * Override standard methode
     * 
     * @return text string 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getType());
        sb.append(": (");
        sb.append(" l: ");
        sb.append(getLength());
        sb.append(", b: ");
        sb.append(getWidth());
        sb.append(", h: ");
        sb.append(getHeight());
        sb.append(" )");

        return sb.toString();
    }
    
}
