package com.server.pickplace.mailling.service;

import com.server.pickplace.mailling.dto.EmailMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;


@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

//    private final UserService userService;

    public String sendMail(EmailMessage emailMessage, String type) {
        String authNum = createCode();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        System.out.println(emailMessage.getTo());

        System.out.println(emailMessage.getTo());
        System.out.println(emailMessage.getSubject());
        //        if (type.equals("password")) userService.SetTempPassword(emailMessage.getTo(), authNum);

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            mimeMessageHelper.setTo(emailMessage.getTo()); // 메일 수신자
            mimeMessageHelper.setSubject(emailMessage.getSubject()); // 메일 제목
            mimeMessageHelper.setText("test",false); // 메일 본문 내용, HTML 여부
            javaMailSender.send(mimeMessage);

            log.info("Success");

            return authNum;

        } catch (MessagingException e) {
            log.info("fail");
            throw new RuntimeException(e);
        }
    }

    // 인증번호 및 임시 비밀번호 생성 메서드
    public String createCode() {
        Random random = new Random();
        StringBuffer key = new StringBuffer();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(4);

            switch (index) {
                case 0: key.append((char) ((int) random.nextInt(26) + 97)); break;
                case 1: key.append((char) ((int) random.nextInt(26) + 65)); break;
                default: key.append(random.nextInt(9));
            }
        }
        return key.toString();
    }

    // thymeleaf를 통한 html 적용
//    public String setContext(String code, String type) {
//        Context context = new Context();
//        context.setVariable("code", code);
//        return templateEngine.process(type, context);
}

