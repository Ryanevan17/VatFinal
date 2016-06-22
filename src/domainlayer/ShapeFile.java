/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainlayer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jnmkimpton
 */

public class ShapeFile {
    
    private String path;
    private final Charset ENCODING = StandardCharsets.UTF_8; //most complete Charset
    
    public ShapeFile(String path) {
        this.path = path;
    }
    
    public boolean exists() {
        return new File(path).exists();
    }
    
    public ShapeCollection ReadTextFile() throws IOException {
        ArrayList<Shape> shapes = new ArrayList<>();
        ShapeCollection sc = new ShapeCollection();
        Path p = Paths.get(path);
        try (Scanner scanner = new Scanner(p, ENCODING.name())) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String[] shapearray = s.split(";");
                String[] shapeproperty = shapearray[1].split(",");

                switch (shapearray[0]) { //check which shape currently is being read
                    case "Block":
                        shapes.add(new Block(Integer.parseInt(shapeproperty[0]),
                                Integer.parseInt(shapeproperty[1]),
                                Integer.parseInt(shapeproperty[2])));
                        break;
                    case "Cilinder":
                        shapes.add(new Cilinder(Integer.parseInt(shapeproperty[0]),
                                Integer.parseInt(shapeproperty[1])));
                        break;
                    case "Sphere":
                        shapes.add(new Sphere(Integer.parseInt(shapeproperty[0])));
                        break;
                    case "Cone":
                        shapes.add(new Cone(Integer.parseInt(shapeproperty[0]),
                                Integer.parseInt(shapeproperty[1])));
                        break;
                    
                }
            }
        }

        sc.addShape(shapes.toArray(new Shape[shapes.size()])); //convert to array and add to ShapeCollection
        return sc;
    }
    
    /**
     * Write ShapeCollection totextfile
     *
     * @param collection
     * @throws IOException When an error occured during writing to the file
     */
    public void WriteTextFile(ShapeCollection collection) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        for (Shape s : collection.getShapes()) { //add all items to the list     
            // Block l,b,h
            // Cilinder r,h
            // Sphere r
            // Cone r,h
            // Hemi Sphere r
            switch(s.getType().toString()) {
                case "Block":
                    lines.add("Block;" + s.getLength() + "," + s.getWidth() + "," + s.getHeight());
                    break;
                case "Cilinder":
                    lines.add("Cilinder;" + s.getRadius() + "," + s.getHeight());
                    break;
                case "Sphere":
                    lines.add("Sphere;" + s.getRadius());
                    break;    
                case "Cone":
                    lines.add("Cone;" + s.getRadius() + "," + s.getHeight());
                    break;
                 }
        }
        Path p = Paths.get(path);
        try (BufferedWriter writer = Files.newBufferedWriter(p, ENCODING)) {
            for (String line : lines) { //write all lines
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
