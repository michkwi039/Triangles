/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.triangles.controller;

import pl.polsl.triangles.model.WrongSidesLengthException;
import java.util.ArrayList;

/**
 * Class that contains the most important controller of program
 *
 * @author Anggmar
 * @version 1.1
 */
public class ArgsController {

    /**
     * A method that begins the execution of program
     *
     * @param args contains a path to file that you want to read triangles from
     * @return list of fields of all triangles from args
     */
    public ArrayList<Double> execution(String[] args) {
        ArrayList<Double> fTriangles = new ArrayList<Double>();//list that contains
        //field of every triangle in database
        if (0 == args.length) {//read without parameters
            System.out.println("Beggining program without a file");
        } else if (0 == args.length % 3) {//read with parameter
            ArgsHandler argsHandler = new ArgsHandler();
            try {
                fTriangles = argsHandler.handleArgs(args);
            } catch (WrongSidesLengthException ex) {
                return fTriangles;
            }
            //field of every triangle in database
        } else {//wrong number of parameters
            System.out.println("Invalid parameters, closing program");
            return fTriangles;
        }
        return fTriangles;
    }
}
