package az.hakaton.karbon.service.inter;

import az.hakaton.karbon.model.User;

public interface OTPService {

    String generateAndSendOTP(User user);


}
