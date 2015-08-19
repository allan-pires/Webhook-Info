/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developertask.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author doisl_000
 */
public class ContainerTest {

    /**
     * Tests of GetText method, of class Container.
     */
    @Test
    public void test_GetText_RunsNormally_When_Called() {
        System.out.println("GetText");
        Container instance = new Container();
        String expResult = "";
        String result = instance.GetText();
        assertEquals(expResult, result);
    }
    
    @Test
    public void test_GetText_RunsNormally_When_Called2() {
        System.out.println("GetText");
        Container instance = new Container("lorem ipsum", 2);
        String expResult = "lorem ipsum";
        String result = instance.GetText();
        assertEquals(expResult, result);
    }


    /**
     * Tests of SetText method, of class Container.
     */
    @Test
    public void test_SetText_RunsNormally_When_Called() {
        System.out.println("SetText");
        String text = "";
        Container instance = new Container();
        instance.SetText(text);
    }
    
    @Test
    public void test_SetText_RunsNormally_When_Called2() {
        System.out.println("SetText");
        String text = "lorem ipsum";
        Container instance = new Container("lorem ipsum", 2);
        instance.SetText(text);
    }

    /**
     * Tests of GetValue method, of class Container.
     */
    @Test
    public void test_GetValue_RunsNormally_When_Called() {
        System.out.println("GetValue");
        Container instance = new Container();
        int expResult = 0;
        int result = instance.GetValue();
        assertEquals(expResult, result);
    }
    
    public void test_GetValue_RunsNormally_When_Called2() {
        System.out.println("GetValue");
        Container instance = new Container("lorem ipsum", 1234);
        int expResult = 1234;
        int result = instance.GetValue();
        assertEquals(expResult, result);
    }

    /**
     * Tests of SetValue method, of class Container.
     */
    @Test
    public void test_SetValue_RunsNormally_When_Called() {
        System.out.println("SetValue");
        int _Value2 = 0;
        Container instance = new Container();
        instance.SetValue(_Value2);
    }
    
    @Test
    public void test_SetValue_RunsNormally_When_Called2() {
        System.out.println("SetValue");
        int _Value2 = 1234;
        Container instance = new Container("lorem ipsum", 1234);
        instance.SetValue(_Value2);
    }

    /**
     * Tests of compareTo method, of class Container.
     */
    @Test
    public void test_CompareTo_RunsNormally_When_Called() {
        System.out.println("compareTo");
        Container t = new Container("ABC", 123);
        Container instance = new Container();
        int expResult = -3;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
    }
    
    @Test
    public void test_CompareTo_RunsNormally_When_Called2() {
        System.out.println("compareTo");
        Container t = new Container("ABC", 123);
        Container instance = new Container("ABC", 121233);
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
    }

    /**
     * Test of compare method, of class Container.
     */
    @Test
    public void test_Compare_RunsNormally_When_Called() {
        System.out.println("compare");
        Container c1 = new Container("ABCD", 123);
        Container c2 = new Container("ABC", 123);
        Container instance = new Container();
        int expResult = 0;
        int result = instance.compare(c1, c2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void test_Compare_RunsNormally_When_Called2() {
        System.out.println("compare");
        Container c1 = new Container("ABC", 123);
        Container c2 = new Container("ABC", 122);
        Container instance = new Container();
        int expResult = 1;
        int result = instance.compare(c1, c2);
        assertEquals(expResult, result);
    }
    
}
