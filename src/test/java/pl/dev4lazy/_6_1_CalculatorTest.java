package pl.dev4lazy;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

/*

Metody testowe mają za zadanie przetestować działanie metody add(). Lista przypadków testowych do pokrycia:
	1. Dodawanie dwóch liczb całkowitych z wykorzystaniem metody assertTrue()
	2. Dodawanie dwóch liczb całkowitych z wykorzystaniem metody assertFalse()
	3. Dodawanie dwóch liczb całkowitych z wykorzystaniem metody assertEquals()

 */
public class _6_1_CalculatorTest {
    private Calculator calculator;
    @BeforeMethod
    public void prepareCalculator() {
        calculator = new Calculator();
    };

    @Test
    public void add__should_return_7__if_3_and_4_are_given() {
        assertTrue( calculator.add( 3, 4)==7 );
    }

    @Test
    public void add__should_not_return_7__if_3_and_5_are_given() {
        assertFalse( calculator.add( 3, 5)==7 );
    }

    @Test
    public void add__should_return_7__if_3_and_4_are_given__2() {
        assertEquals( calculator.add( 3, 4), 7 );
    }

}
