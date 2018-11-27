/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.triangles.controller;

import java.util.ArrayList;
import java.util.Scanner;
import pl.polsl.triangles.model.Sorter;
import pl.polsl.triangles.model.WrongSidesLengthException;
import pl.polsl.triangles.view.MenuView;

/**
 * Controller that handles user interaction for main menu
 *
 * @author Anggmar
 * @version 1.1
 */
public class MenuController {

    /**
     * Method that handles user interaction for main menu
     *
     * @param fTriangles list of triangles fields already in database
     */
    public void menuControll(ArrayList<Double> fTriangles) {
        boolean close = false;//boolean if true it means that project will close
        MenuView menuGenerator;//class used to display messages to user
        Sorter sorter = new Sorter();//sorter that will be used to sort fields
        //of triangles
        menuGenerator = new MenuView();
        while (!close) {//loop that displays main menu until user decides what do
            //or closes the Project
            menuGenerator.mainMenu();
            Scanner s = new Scanner(System.in);
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    try {//tries to add new triangle
                        fTriangles.add(menuGenerator.getTriangle());
                        sorter.sortFromLowest(fTriangles);
                    } catch (WrongSidesLengthException e)//couldn't add a triangle
                    {
                        System.out.println("Impossible to create triangle wrong sides length");
                    }
                    break;
                case 2:
                    menuGenerator.displayTrianglesField(fTriangles);
                    break;
                case 3:
                    close = true;
                    break;
                default:
                    System.out.println("Choose valid option");
                    break;

            }

        }
    }
}
