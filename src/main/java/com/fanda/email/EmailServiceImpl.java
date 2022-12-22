package com.fanda.email;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
 
@Service
public class EmailServiceImpl implements EmailService {
 
    @Autowired private JavaMailSender javaMailSender;
 
    @Value("${spring.mail.username}") private String sender;
 
    public String sendSimpleMail(EmailDetail details)
    {
 
        try {


            SimpleMailMessage mailMessage
                = new SimpleMailMessage();
 
            mailMessage.setFrom("FANDAFOOD <tinhntpc02175>");
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
 
            javaMailSender.send(mailMessage);
            return "Gửi thành công";
        }
 
        catch (Exception e) {
            System.out.println(e);
            return "Gửi thất bại";
        }
    }
 
    public String
    sendMailWithAttachment(EmailDetail details)
    {
        MimeMessage mimeMessage
            = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("FANDAFOOD <tinhntpc02175>");
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                details.getSubject());
 
            FileSystemResource file
                = new FileSystemResource(
                    new File(details.getAttachment()));
 
            mimeMessageHelper.addAttachment(
                file.getFilename(), file);
 
            javaMailSender.send(mimeMessage);
            return "Gửi thành công";
        }
 
        catch (MessagingException e) {
 
            return "Gửi thất bại";
        }
    }
	public String Hihi(String to, String subject, String body) {
		   try {

	
	            SimpleMailMessage mailMessage
	                = new SimpleMailMessage();
	 
	            mailMessage.setFrom("FANDAFOOD <tinhntpc02175>");
	            mailMessage.setTo(to);
	            mailMessage.setText(subject);
	            mailMessage.setSubject(body);
	 
	            javaMailSender.send(mailMessage);
	            return "Gửi thành công";
	        }
	 
	        catch (Exception e) {
	            System.out.println(e);
	            return "Gửi thất bại";
	        }
	}
}