import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PlainTextDemo {
	public static void main(String[] args) throws AddressException, MessagingException {
		// step-1
		Properties properties = new Properties();
		// FileInputStream fileInputStream=new FileInputStream(new File(pathname))
		try {
			properties.load(PlainTextDemo.class.getResourceAsStream("mail.properties"));
		} catch (IOException e) {
			System.out.println("Problem in loading properties file");
			e.printStackTrace();
		}
		System.out.println("properties " + properties);
		
		// step-2

		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("javaemailapitesting@gmail.com", "Javamail123");
			}
		});
		
		//step3
		Message message=new MimeMessage(session);
		
		message.setFrom(new InternetAddress("javaemailapitesting@gmail.com"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("jbmca2011@gmail.com"));
		message.addRecipient(Message.RecipientType.CC, new InternetAddress("msdhoni1105@gmail.com"));
		message.addRecipient(Message.RecipientType.BCC, new InternetAddress("sangrampradhan0001@gmail.com"));
		message.setSubject("Mail Alert from sreenutechnologies");
		message.setText("Greetings from sreenutech");

        // step -4
		
		Transport.send(message);
		
		System.out.println("Mail sent successfully");

	}
}
