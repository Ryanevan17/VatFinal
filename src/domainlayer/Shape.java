/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainlayer;

import java.io.Serializable;

/**
 *
 * @author jnmkimpton
 */

public class Shape implements Serializable {
    
    private ShapeType type;
    private double volume;
    
    /**
     * @param type
     * @param volume 
     */
    public Shape(ShapeType type, double volume)
    {
        this.type = type;
        this.volume = volume;
    }

    public Shape(String Shape, String Property) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * type of Shape
     * 
     * @return type of Shape
     */
    public ShapeType getType()
    {
        return type;
    }
    
    /**
     *  volume of Shape
     * 
     * @return the volume of the Shape
     */
    public double getVolume()
    {
        return volume;
    }
    
    /**
     *  Get length of Shape
     * 
     * @return length 
     */
    public int getLength()
    {
        return 0;
    }
    
    /**
     *  Get width ofShape
     * 
     * @return width 
     */
    public int getWidth()
    {
        return 0;
    }
    
    /**
     *  Get height of Shape
     * 
     * @return heigth
     */
    public int getHeight()
    {
        return 0;
    }
    
    /**
     *  Get radius of Shape
     * 
     * @return radius 
     */
    public int getRadius()
    {
        return 0;
    }
    
    @Override
    public String toString() {
        return getType() + " | " + getVolume();
    }
    
    
}