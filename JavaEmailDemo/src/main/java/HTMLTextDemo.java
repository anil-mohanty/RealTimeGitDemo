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

public class HTMLTextDemo {
	public static void main(String[] args) throws AddressException, MessagingException {
		// step-1
		Properties properties = new Properties();
		// FileInputStream fileInputStream=new FileInputStream(new File(pathname))
		try {
			properties.load(HTMLTextDemo.class.getResourceAsStream("mail.properties"));
		} catch (IOException e) {
			System.out.println("Problem in loading properties file");
			e.printStackTrace();
		}
		System.out.println("properties " + properties);

		// step-2

		Session session = Session.getDefaultInstance(properties, new MyAuthenticator("javaemailapitesting@gmail.com","Javamail123"));

		// step3
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress("javaemailapitesting@gmail.com"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("jbmca2011@gmail.com"));
		message.addRecipient(Message.RecipientType.CC, new InternetAddress("msdhoni1105@gmail.com"));
		message.addRecipient(Message.RecipientType.BCC, new InternetAddress("sangrampradhan0001@gmail.com"));
		message.setSubject("Mail Alert from sreenutechnologies");
		String name="Sreenu";
		// message.setText("Greetings from sreenutech");
		String body = "<center>\r\n" + 
				"<h1 style=\"color:red\">Sreenu Technologies</h1>\r\n" + 
				"  <img src=\"http://www.sreenutech.com/assets/img/logo.png\"></img>\r\n" + 
				"<br/>\r\n" + 
				"<h5>\r\n" + 
				"  At Sreenu Technologies, we strive every day to offer a different kind of learning one that is focused on the student. Sreenu Technologies offers a uniquely corporate approach to career training, with programs and services that help you achieve the career you want.\r\n" + 
				"</h5>\r\n" + 
				"<br/>\r\n" + 
				"<h1>\r\n" + 
				"  Happy Birthday to \r\n" + name+
				"</h1>\r\n" + 
				"  </center>";
		message.setContent(body, "text/html");
		// step -4

		Transport.send(message);

		System.out.println("Mail sent successfully");

	}
}
