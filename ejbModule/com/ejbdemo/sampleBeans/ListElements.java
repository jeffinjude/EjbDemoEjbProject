package com.ejbdemo.sampleBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class ListElements
 */
@Stateful
public class ListElements implements ListElementsRemote{

    List<Integer> listValues = new ArrayList<>();
    
    public void addElement(int e)
    {
    	listValues.add(e);
    }
    
    public void removeElement(int e)
    {
    	listValues.remove(new Integer(e));
    }
    
    public List<Integer> getElements()
    {
    	return listValues;
    }
}
