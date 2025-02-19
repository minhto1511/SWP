/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Heizxje
 */
public class resetService {
    private final int LIMIT_MINUS = 10;
    static final String from = "work.levuhai@gmail.com";
    static final String password = "zhao zxbc qrow xlzd";
    
    public String generateToken() {
        return UUID.randomUUID().toString();
    }
    
    public LocalDateTime expireDateTime() {
        return LocalDateTime.now().plusMinutes(LIMIT_MINUS);
    }
    
    public boolean isExpireTime(LocalDateTime time) {
        return LocalDateTime.now().isAfter(time);
    }
    
    
    public boolean sendEmail(String to, String link, String name) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        
        Session session = Session.getInstance(props, auth);
        
        MimeMessage msg = new MimeMessage(session);
        
        try {
    msg.addHeader("Content-type", "text/html; charset=UTF-8");
    msg.setFrom(from);
    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
    msg.setSubject("Đặt Lại Mật Khẩu - Hệ Thống Quản Lý Gia Sư", "UTF-8");

    String content = "<h3>Xin chào " + name + ",</h3>"
            + "<p>Chúng tôi đã nhận được yêu cầu đặt lại mật khẩu cho tài khoản Hệ Thống Quản Lý Gia Sư của bạn. "
            + "Nếu bạn đã gửi yêu cầu này, vui lòng nhấn vào liên kết dưới đây để thiết lập mật khẩu mới:</p>"
            + "<p><a href='" + link + "' style='color: blue; text-decoration: underline;'>Đặt Lại Mật Khẩu</a></p>"
            + "<p>Nếu nút trên không hoạt động, bạn có thể sao chép và dán liên kết này vào trình duyệt:</p>"
            + "<p><a href='" + link + "'>" + link + "</a></p>"
            + "<p>Liên kết này sẽ hết hạn sau 10 phút vì lý do bảo mật. Nếu bạn không yêu cầu đặt lại mật khẩu, vui lòng bỏ qua email này.</p>"
            + "<p>Nếu bạn cần hỗ trợ, vui lòng liên hệ với chúng tôi qua Work.levuhai@gmail.com .</p>"
            + "<p>Trân trọng,<br>Đội Ngũ Hệ Thống Quản Lý Gia Sư</p>";

    msg.setContent(content, "text/html; charset=UTF-8");
    Transport.send(msg);
    System.out.println("Send successfully");
    return true;
} catch (Exception e) {
            System.out.println("Send error");
            System.out.println(e);
            return false;
        }
    }
}
