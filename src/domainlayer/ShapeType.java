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

public enum ShapeType {
    
    BLOCK("Block"),
    CILINDER("Cilinder"),
    SPHERE("Sphere"),
    CONE("Cone");
    
    private String type;
    
    private ShapeType(String type)
    {
            this.type = type;
    }
    
    @Override
    public String toString()
    {
        return type;
    }
}