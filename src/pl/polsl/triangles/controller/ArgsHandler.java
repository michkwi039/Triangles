/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.triangles.controller;

import java.util.ArrayList;
import pl.polsl.triangles.model.FieldCalculator;
import pl.polsl.triangles.model.WrongSidesLengthException;

/**
 * Class that deals with args given by the user
 *
 * @author Anggmar
 * @version 1.1
 */
public class ArgsHandler {

    /**
     * Method that deals with args given by the user
     *
     * @param args list of sides of triangles
     * @return list of triangles fields in extracted from args
     * @throws WrongSidesLengthException thrown when it is impossible to make
     * triangle from given sides
     * @throws ArrayIndexOutOfBoundsException if list has wrong number of params
     */
    public ArrayList<Double> handleArgs(String[] args) throws WrongSidesLengthException, ArrayIndexOutOfBoundsException {
        ArrayList<Double> fTriangles = new ArrayList<Double>();
        Double a, b, c;
        FieldCalculator fieldCalculator = new FieldCalculator();
        for (int i = 0; i < args.length; i++) {
            a = Double.parseDouble(args[i]);//rewriting side as string to double
            b = Double.parseDouble(args[i + 1]);
            c = Double.parseDouble(args[i + 2]);
            i += 2;
            fTriangles.add(fieldCalculator.calculate(a, b, c));   //adding triangle field to list 
        }
        return fTriangles;
    }
}
