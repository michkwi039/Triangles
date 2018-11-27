package pl.polsl.triangles.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import pl.polsl.triangles.controller.ArgsHandler;
import pl.polsl.triangles.model.WrongSidesLengthException;
import pl.polsl.triangles.model.FieldCalculator;
import pl.polsl.triangles.model.Sorter;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import java.util.*;
import java.io.FileNotFoundException;

/**
 * Class that checks every public method from the model
 *
 * @author Anggmar
 * @version 1.2
 */
public class TrianglesTests {

    /**
     * Test that checks if FieldCalculator works right
     */
    @Test
    public void calculateTest() {
        FieldCalculator calculator = new FieldCalculator();
        try {
            Double expected = new Double(6);
            Assert.assertEquals(expected, calculator.calculate(3.0, 4.0, 5.0));
        } catch (WrongSidesLengthException e) {
            fail("Wrong lengths");
        }
    }

    /**
     * Test that checks if FieldCalculator works when lengths of sides makes it
     * impossible to create triangle
     *
     * @throws WrongSidesLengthException
     */
    @Test(expected = WrongSidesLengthException.class)
    public void calculateTestWrongLength() throws WrongSidesLengthException {
        FieldCalculator calculator = new FieldCalculator();

        calculator.calculate(1.0, 1.0, 5.0);

    }

    /**
     * Test that checks if FieldCalculator works for surplus values
     *
     * @throws WrongSidesLengthException
     */
    @Test(expected = WrongSidesLengthException.class)
    public void calculateTestSurplusLength() throws WrongSidesLengthException {
        FieldCalculator calculator = new FieldCalculator();

        calculator.calculate(-4.0, -3.0, -5.0);

    }

    /**
     * Test that checks if Sorter works properly
     */
    @Test
    public void sorterTest() {
        Sorter sorter = new Sorter();
        ArrayList<Double> fields = new ArrayList<Double>();
        fields.add(5.0);
        fields.add(3.0);
        fields.add(4.0);
        sorter.sortFromLowest(fields);
        Double expected = new Double(3.0);
        for (Double a : fields) {
            Assert.assertEquals(expected, a);
            expected++;
        }
    }

    /**
     * Test that checks what happens if Sorter gets empty list to sort
     */
    @Test
    public void sorterTestEmpty() {
        Sorter sorter = new Sorter();
        ArrayList<Double> fields = new ArrayList<Double>();
        sorter.sortFromLowest(fields);
        Assert.assertTrue(fields.isEmpty());
    }

    /**
     * Test that checks if ArgsHandler works properly
     */
    @Test
    public void argsHandlerTest() {
        ArgsHandler argsHandler = new ArgsHandler();
        String[] args = new String[6];
        ArrayList<Double> fields = new ArrayList<Double>();
        args[0] = "3";
        args[1] = "4";
        args[2] = "5";
        args[3] = "3";
        args[4] = "4";
        args[5] = "5";
        try {
            fields = argsHandler.handleArgs(args);
        } catch (WrongSidesLengthException e) {
            fail("Wrong sides length");
        }
        for (Double a : fields) {
            Double expected = new Double(6.0);
            Assert.assertEquals(expected, a);
        }
    }

    /**
     * Test that checks what happens if ArgsHandler gets empty list
     */
    @Test
    public void argsHandlerEmptyTest() {
        ArgsHandler argsHandler = new ArgsHandler();
        String[] args = new String[0];
        ArrayList<Double> fields = new ArrayList<Double>();
        try {
            fields = argsHandler.handleArgs(args);
        } catch (WrongSidesLengthException e) {
            fail("Wrong sides length");
        }
        Assert.assertTrue(fields.isEmpty());
    }

}
