package az.hakaton.karbon.sheduler;

import az.hakaton.karbon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OTPCleanupTask {

    private final UserRepository repository;

    @Scheduled(cron = "0 0 * * * *") // Run hourly
    public void cleanExpiredOTPs() {
        var now = LocalDateTime.now();
        var expiredUsers = repository.findAll().stream()
                .filter(user -> !user.isVerified() && user.getOtpExpiry().isBefore(now))
                .collect(Collectors.toList());

        repository.deleteAll(expiredUsers);
    }
}

