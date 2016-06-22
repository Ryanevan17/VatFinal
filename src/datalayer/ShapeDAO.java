/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;

import domainlayer.Shape;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jnmkimpton
 */
public class ShapeDAO {
    
    public ShapeDAO() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    /**
     * Tries to find the shapes for the given in the persistent data
     * store, in this case a MySQL database. The foreign keys relating to other
     * tables are not added, simply because they are not used 
     * in the application as of yet.
     */
    
    public List<Shape> findShapes() {
        List<Shape> shapes = new ArrayList<>();

        if (true) {
            // First open a database connnection
            DatabaseConnection connection = new DatabaseConnection();
            if (connection.openConnection()) {
                // If a connection was successfully setup, execute the SELECT statement.
                 ResultSet resultset = connection.executeSQLSelectStatement(
                        "SELECT * FROM vat");

                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            // The value for the BookISBN in the row is ignored
                            // for this POC: no Book objects are loaded. Having the
                            // Reservation objects without the Book objects will do fine
                            // to determine whether the owning Member can be removed.
                            String Shape = resultset.getString("Shape");
                            String Property = resultset.getString("Property");
                            

                            Shape newShape = new Shape(Shape, Property);
                            Shape newShapes = null;
                            shapes.add(newShapes);
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                        shapes.clear();
                    }
                }
                // else an error occurred leave array list empty.

                // We had a database connection opened. Since we're finished,
                // we need to close it.
                connection.close();
            }
        }

        return shapes;
    }
    
    
}
