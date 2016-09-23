package com.ejbdemo.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SampleSessionBean
 */
@Stateless
@LocalBean
public class SampleSessionBean {

   public String sampleMethod()
   {
	   return "Inside Session Bean";
   }

}
