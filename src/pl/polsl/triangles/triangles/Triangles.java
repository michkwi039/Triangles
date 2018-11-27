/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.triangles.triangles;

import java.util.ArrayList;
import pl.polsl.triangles.controller.ArgsController;
import pl.polsl.triangles.controller.MenuController;

/**
 * Project that calculates fields of given triangles and can later display them
 * as list of fields from lowest to highest field
 *
 * @author Anggmar
 * @version 1.2
 */
public class Triangles {

    /**
     * @param args contains length of sides of triangles
     */
    public static void main(String[] args) {
        ArgsController aController = new ArgsController();
        MenuController mController = new MenuController();
        ArrayList<Double> fTriangles =new ArrayList<Double>();
        fTriangles = aController.execution(args);
        mController.menuControll(fTriangles);
    }

}
