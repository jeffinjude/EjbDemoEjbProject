package com.ejbdemo.sampleBeans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.json.JSONException;
import org.json.JSONObject;

import com.ejbdemo.dao.EjbJpaDao;



/**
 * Message-Driven Bean implementation class for: UserDetailsMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jmsDemo/sampleQueue"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jmsDemo/sampleQueue")
public class UserDetailsMDB implements MessageListener {
	
	@EJB
	EjbJpaDao ejbJpaDao;
	
    /**
     * Default constructor. 
     */
    public UserDetailsMDB() {
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	TextMessage msg = (TextMessage) message;
    	
    	JSONObject obj;
		try {
			obj = new JSONObject(msg.getText());
			
			System.out.println("User Name : " + obj.getString("userName"));
			System.out.println("Phone Number : " + obj.getString("phoneNumber"));
			
			//Fetch the data from queue and insert into database
			ejbJpaDao.insertData(obj.getString("userName"), obj.getString("phoneNumber"));
			
		} catch (JSONException | JMSException e) {
			e.printStackTrace();
		}
		
    }

}
