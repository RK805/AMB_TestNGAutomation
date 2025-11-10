package Utility;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.FlagTerm;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Session;

public class EmailUtils {

    // 👉 Replace with your Gmail address and App Password
    private static final String GMAIL_ADDRESS = "your_email@gmail.com";
    private static final String APP_PASSWORD = "your_app_password"; // Must be Google App Password

    /**
     * Sends a booking ID email to your Gmail inbox.
     */
    public static void sendBookingIdMail(int bookingId) {
        String subject = "New Booking Created";
        String messageText = "Booking ID: " + bookingId;

        // Standard SMTP Gmail config
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(GMAIL_ADDRESS, APP_PASSWORD);
            }
        });

        session.setDebug(true); // ✅ optional debug logs

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(GMAIL_ADDRESS));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(GMAIL_ADDRESS));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);
            System.out.println("✅ Email sent successfully: " + subject);
        } catch (MessagingException e) {
            System.err.println("❌ Failed to send email via STARTTLS, retrying with SSL...");

            // Retry with SSL port 465
            try {
                Properties sslProps = new Properties();
                sslProps.put("mail.smtp.host", "smtp.gmail.com");
                sslProps.put("mail.smtp.socketFactory.port", "465");
                sslProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                sslProps.put("mail.smtp.auth", "true");
                sslProps.put("mail.smtp.port", "465");

                Session sslSession = Session.getInstance(sslProps, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(GMAIL_ADDRESS, APP_PASSWORD);
                    }
                });

                Message sslMessage = new MimeMessage(sslSession);
                sslMessage.setFrom(new InternetAddress(GMAIL_ADDRESS));
                sslMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(GMAIL_ADDRESS));
                sslMessage.setSubject(subject);
                sslMessage.setText(messageText);

                Transport.send(sslMessage);
                System.out.println("✅ Email sent successfully via SSL fallback.");
            } catch (MessagingException ex) {
                ex.printStackTrace();
                throw new RuntimeException("❌ Failed to send email via Gmail SMTP", ex);
            }
        }
    }

    /**
     * Reads the latest unread email with subject "New Booking Created"
     * and extracts the numeric booking ID.
     */
    public static int readBookingIdFromEmail() {
        int bookingId = -1;
        try {
            Properties props = new Properties();
            props.put("mail.imap.ssl.enable", "true");
            props.put("mail.imap.host", "imap.gmail.com");
            props.put("mail.imap.port", "993");

            Session session = Session.getInstance(props);
            Store store = session.getStore("imap");
            store.connect("imap.gmail.com", GMAIL_ADDRESS, APP_PASSWORD);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            // Loop through latest messages
            for (int i = messages.length - 1; i >= 0; i--) {
                Message message = messages[i];
                String subject = message.getSubject();

                if (subject != null && subject.contains("New Booking Created")) {
                    String content = message.getContent().toString();
                    System.out.println("📩 Found email content: " + content);

                    Matcher matcher = Pattern.compile("Booking ID: (\\d+)").matcher(content);
                    if (matcher.find()) {
                        bookingId = Integer.parseInt(matcher.group(1));
                        System.out.println("✅ Extracted Booking ID: " + bookingId);
                        break;
                    }
                }
            }

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (bookingId == -1) {
            System.out.println("⚠️ No unread email with booking ID found.");
        }
        return bookingId;
    }

    // Quick standalone test
    public static void main(String[] args) {
        sendBookingIdMail(12345); // send test mail
        try { Thread.sleep(10000); } catch (InterruptedException ignored) {}
        readBookingIdFromEmail(); // read back
    }
}
