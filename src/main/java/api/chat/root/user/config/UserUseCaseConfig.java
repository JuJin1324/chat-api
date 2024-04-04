package api.chat.root.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import api.chat.root.user.application.port.in.EmailVerificationUseCase;
import api.chat.root.user.application.port.in.LoginUseCase;
import api.chat.root.user.application.port.in.PhoneVerificationUseCase;
import api.chat.root.user.application.service.EmailVerificationService;
import api.chat.root.user.application.service.LoginService;
import api.chat.root.user.application.service.PhoneVerificationService;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@Configuration
@RequiredArgsConstructor
public class UserUseCaseConfig {

	@Bean
	public LoginUseCase loginUseCase() {
		return new LoginService(null, null);
	}

	@Bean
	public EmailVerificationUseCase emailVerificationUseCase() {
		return new EmailVerificationService(null);
	}

	@Bean
	public PhoneVerificationUseCase phoneVerificationUseCase() {
		return new PhoneVerificationService(null);
	}
}
