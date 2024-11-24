package az.hakaton.karbon.service.impl;

import az.hakaton.karbon.model.User;
import az.hakaton.karbon.repository.UserRepository;
import az.hakaton.karbon.service.inter.OTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OTPServiceImpl implements OTPService {

    private final JavaMailSender mailSender;
    private final UserRepository repository;

    public String generateAndSendOTP(User user) {
        String otp = UUID.randomUUID().toString();

        user.setOtp(otp);
        user.setOtpExpiry(LocalDateTime.now().plusMinutes(10)); // 10 minutes expiry
        repository.save(user);

            sendVerificationEmail(user.getEmail(), otp);

        return otp;
    }

    private void sendVerificationEmail(String email, String otp) {
        String verificationLink = "http://10.10.0.29:8083/api/v1/auth/verify?otp=" + otp;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Verify Your Account");
        message.setText("Click the link to verify your account: " + verificationLink);
        mailSender.send(message);
    }
}
