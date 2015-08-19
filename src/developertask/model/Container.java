/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developertask.model;

import java.util.Comparator;

/**
 *
 * @author doisl_000
 */
public class Container implements Comparator<Container>, Comparable<Container> {
    
    // Description
    private String _text;
    
    // Value
    private int _value;
    
    // Constructor without parameters
    public Container()
    {
        this._text = "";
        this._value = 0;
    }
    
    // Construtor with parameters
    public Container(String _Value1, int _Value2) 
    {
        this._text = _Value1;
        this._value = _Value2;
    }
    
    // Default get for _text
    public String GetText() 
    {
        return this._text;
    }
    
    // Default set for _text
    public void SetText(String _Value1) 
    {
        this._text = _Value1;
    }
    
    // Default get for _value
    public int GetValue() 
    {
        return this._value;
    }
    
    // Default set for _value
    public void SetValue(int _Value2) 
    {
        this._value = _Value2;
    }
    
    // Prints the attributes of the container in the screen. 
    public void print()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this._text);
        sb.append(" - ");
        sb.append(this._value);
        
        System.out.println(sb.toString());
    }
    
    // Comparator override
    @Override
    public int compareTo(Container t) 
    {
        return (this._text).compareTo(t._text);
    }
    
    // Comparator override
    @Override
    public int compare(Container c1, Container c2) 
    {
        return c1._value - c2._value;
    }
    
    // Equals override
    @Override
    public boolean equals(Object o) 
    {
        if (o instanceof Container) 
        {
            Container toCompare = (Container) o;
            return this._text.equals(toCompare._text) && this._value == toCompare._value;
        }
        return false;
    }

    // Equals override
    @Override
    public int hashCode() 
    {
        return this._text.hashCode();
    }
}
