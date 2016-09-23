package com.ejbdemo.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SampleBizRules
 */
@Stateless
@LocalBean
public class SampleBizRules {
	
	/**
	 * Function that performs a sample business rule to append 91 to the phone number
	 */
	public String applyPhoneNumberBizRules(String phoneNumber)
	{
		return "91" + phoneNumber;
	}

}
