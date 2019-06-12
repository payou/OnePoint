package test.point.business;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import point.business.Compute;

import static org.testng.Assert.*;

public class ComputeTest {

    private Compute computer;

    @BeforeMethod
    public void setUp() throws Exception {

        computer = new Compute();
    }

    @Test
    public void testCompute() throws Exception {

        assertEquals(computer.compute("1"), "1");
        assertEquals(computer.compute("2"), "2");
        assertEquals(computer.compute("3"), "FooFoo");
        assertEquals(computer.compute("4"), "4");
        assertEquals(computer.compute("5"), "BarBar");
        assertEquals(computer.compute("6"), "Foo");
        assertEquals(computer.compute("7"), "QixQix");
        assertEquals(computer.compute("8"), "8");
        assertEquals(computer.compute("9"), "Foo");
        assertEquals(computer.compute("10"), "Bar");
        assertEquals(computer.compute("13"), "Foo");
        assertEquals(computer.compute("15"), "FooBarBar");
        assertEquals(computer.compute("21"), "FooQix");
        assertEquals(computer.compute("33"), "FooFooFoo");
        assertEquals(computer.compute("51"), "FooBar");
        assertEquals(computer.compute("53"), "BarFoo");
        assertEquals(computer.compute("101"), "1*1");
        assertEquals(computer.compute("303", true), "FooFoo*Foo");
        assertEquals(computer.compute("105", true), "FooBarQix*Bar");
        assertEquals(computer.compute("10101", true), "FooQix**");
    }

    @AfterMethod
    public void tearDown() throws Exception {

        computer = null;
    }
}