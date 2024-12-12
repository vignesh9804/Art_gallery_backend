package com.example.demo.Handlers.CommadHandlers.User;

import com.example.demo.Emails.EmailService;
import com.example.demo.Exceptions.SimpleResponse;
import com.example.demo.Exceptions.User.EmailExists;
import com.example.demo.Exceptions.User.IncorrectOTP;
import com.example.demo.Handlers.CommadHandlers.CommandHandler;
import com.example.demo.Models.User;
import com.example.demo.Models.Verification;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class VerifyUser implements CommandHandler<Verification, SimpleResponse> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public ResponseEntity<SimpleResponse> execute(Verification verification) {

        User user1 = userRepository.findByEmail(verification.getEmail());

        if (user1 != null && !user1.getId().equals(verification.getId()))
            throw new EmailExists();

        User user = userRepository.findById(verification.getId()).get();

        if (verification.getOtp() != null && !verification.getOtp().isEmpty()){
            if (user.getOtp().toString().equals(verification.getOtp().toString())) {
                System.out.println("user =" + user.getOtp());
                System.out.println("verfi=" + verification.getOtp());
                user.setVerified(true);
                userRepository.save(user);
                return ResponseEntity.ok(new SimpleResponse("verified"));
            }
            throw new IncorrectOTP();
    }

        user.setEmail(verification.getEmail());
        String otp = generateOtp();
        user.setEmail(verification.getEmail());
        user.setOtp(otp);
        userRepository.save(user);
        sendEmail(verification.getEmail(), otp);

        return ResponseEntity.ok(new SimpleResponse("otp sent"));
    }

    private String generateOtp(){
        Random random = new Random();
        int otpvalue = random.nextInt(9000000) + 1000000;
        return  String.valueOf(otpvalue);
    }

    private void sendEmail(String email , String otp){
        String subject = "OTP VERIFICATION";
        String body = "your verification otp is :" + otp;
        emailService.sendEmail(email, subject, body);
    }
}
