package com.tango.metallica.notifications;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class SendTradeMessages 
{
	//URL of the JMS server. DEFAULT_BROKER_URL will just mean that JMS server is on localhost
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
  
 // default broker URL is : tcp://localhost:61616"
    private static String subject; // Queue Name.You can create any/many queue names as per your requirement.
    
    public void sendCreateMessage(int info)
    {
    	subject = "Create_Trade";
    	// Getting JMS connection from the server and starting it
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection=null;
		try {
			connection = connectionFactory.createConnection();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			connection.start();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        //Creating a non transactional session to send/receive JMS message.
        Session session=null;
		try {
			session = connection.createSession(false,
			        Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
         
        //Destination represents here our queue 'JCG_QUEUE' on the JMS server. 
        //The queue will be created automatically on the server.
        Destination destination=null;
		try {
			destination = session.createQueue(subject);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
         
        // MessageProducer is used for sending messages to the queue.
        MessageProducer producer=null;
		try {
			producer = session.createProducer(destination);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        // We will send a small text message saying 'Hello World!!!' 
        TextMessage message=null;
		try {
			message = session
			        .createTextMessage("New Trade Created with following id "+info);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        // Here we are sending our message!
        try {
			producer.send(message);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        //System.out.println("JCG printing@@ '" + message.getText() + "'");
        try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void sendUpdateMessage(int info)
    {
    	subject = "Update_Trade";
    	// Getting JMS connection from the server and starting it
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection=null;
		try {
			connection = connectionFactory.createConnection();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			connection.start();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        //Creating a non transactional session to send/receive JMS message.
        Session session=null;
		try {
			session = connection.createSession(false,
			        Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
         
        //Destination represents here our queue 'JCG_QUEUE' on the JMS server. 
        //The queue will be created automatically on the server.
        Destination destination=null;
		try {
			destination = session.createQueue(subject);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
         
        // MessageProducer is used for sending messages to the queue.
        MessageProducer producer=null;
		try {
			producer = session.createProducer(destination);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        // We will send a small text message saying 'Hello World!!!' 
        TextMessage message=null;
		try {
			message = session
			        .createTextMessage("Trade Updated with following id "+info);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        // Here we are sending our message!
        try {
			producer.send(message);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
       // System.out.println("JCG printing@@ '" + message.getText() + "'");
        try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void sendDeleteMessage(int info)
    {
    	subject = "Delete_Trade";
    	// Getting JMS connection from the server and starting it
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection=null;
		try {
			connection = connectionFactory.createConnection();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			connection.start();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        //Creating a non transactional session to send/receive JMS message.
        Session session=null;
		try {
			session = connection.createSession(false,
			        Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
         
        //Destination represents here our queue 'JCG_QUEUE' on the JMS server. 
        //The queue will be created automatically on the server.
        Destination destination=null;
		try {
			destination = session.createQueue(subject);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
         
        // MessageProducer is used for sending messages to the queue.
        MessageProducer producer=null;
		try {
			producer = session.createProducer(destination);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        // We will send a small text message saying 'Hello World!!!' 
        TextMessage message=null;
		try {
			message = session
			        .createTextMessage("Trade with following id "+info+" deleted");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        // Here we are sending our message!
        try {
			producer.send(message);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        //System.out.println("JCG printing@@ '" + message.getText() + "'");
        try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
