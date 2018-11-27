/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.triangles.model;

import java.util.*;

/**
 * Class that contains method that sorts lists of given fields
 *
 * @author Anggmar
 * @version 1.1
 */
public class Sorter {

    /**
     * Sorts list of fields from lowest field to highest
     *
     * @param toSort A list that you want to be sorted
     * @return sorted list
     */
    public ArrayList<Double> sortFromLowest(ArrayList<Double> toSort) {

        Collections.sort(toSort);
        return toSort;

    }
}
