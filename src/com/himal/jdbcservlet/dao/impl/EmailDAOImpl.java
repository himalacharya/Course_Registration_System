package com.himal.jdbcservlet.dao.impl;

import com.himal.jdbcservlet.dao.EmailDAO;
import com.himal.jdbcservlet.entity.Email;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Himal Acharya on 2016-09-15.
 */
public class EmailDAOImpl implements EmailDAO {


    @Override
    public boolean send( Email email) {



        boolean status=false;

        //Get System preperties
        Properties properties=System.getProperties();

        //Getting the session object
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        //Get the default session object

        try{

          Session session=Session.getDefaultInstance(properties,new GMailAuthenticator("Put your gmail id ","type password"));
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            System.out.println("Inside emailDaoImpl "+email.getFrom());
            message.setFrom(new InternetAddress(email.getFrom()));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));

            System.out.println("inside email dao "+email.getTo());

            System.out.println("Inside Email dao "+email.getSubject());

            // Set Subject: header field
            message.setSubject(email.getSubject());

            // Send the actual HTML message, as big as you like
            message.setText(email.getBody());

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");

            status=true;
        }catch (AuthenticationFailedException e ){

            status=false;
        } catch (AddressException e) {

        } catch (MessagingException e) {

        }
        return status;

    }
}
