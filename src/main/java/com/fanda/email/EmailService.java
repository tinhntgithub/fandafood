package com.fanda.email;
 

public interface EmailService {
 
    String sendSimpleMail(EmailDetail details);
    String sendMailWithAttachment(EmailDetail details);
    
    String Hihi(String to, String subject, String body);
}