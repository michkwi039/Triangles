/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.triangles.view;

import pl.polsl.triangles.model.WrongSidesLengthException;
import pl.polsl.triangles.model.FieldCalculator;
import java.util.*;

/**
 * Class that contains every method that displays something on the screen
 *
 * @author Anggmar
 * @version 1.1
 */
public class MenuView {

    /**
     * Displays main menu of program
     *
     */
    public void mainMenu() {
        System.out.println("Welcome to triangles program choose what you want to do:");
        System.out.println("1.Add new triangle");
        System.out.println("2.Show fields of existing triangle");
        System.out.println("3.Exit");
    }

    /**
     * Asks user about triangle and returns field of this triangle
     *
     * @return returns field of that was got from user
     * @exception WrongSidesLengthException if from given sides it is impossible
     * to make triangle
     */
    public Double getTriangle() throws WrongSidesLengthException {
        Double a, b, c;//wariables that will contain lenght of each side of triangle
        System.out.println("Write length of first side:");
        Scanner s = new Scanner(System.in);
        a = s.nextDouble();
        System.out.println("Write length of second side:");
        s = new Scanner(System.in);
        b = s.nextDouble();
        System.out.println("Write length of third side:");
        s = new Scanner(System.in);
        c = s.nextDouble();
        FieldCalculator fieldCalculator = new FieldCalculator();

        return fieldCalculator.calculate(a, b, c);
    }

    /**
     * Displays all triangles fields that were added to program
     *
     * @param tList a list of all triangles field in database
     *
     */
    public void displayTrianglesField(ArrayList<Double> tList) {
        System.out.println("Triangles sorted by their field:");
        int triangleNr = 1;//number of triangle
        for (Double i : tList) {//loop that displays fields of all triangles in database
            System.out.println("Triangle number " + triangleNr + ": field = " + i);
            triangleNr++;
        }

    }

}
