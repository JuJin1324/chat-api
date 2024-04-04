package api.chat.root.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import api.chat.root.user.application.port.in.EmailVerificationUseCase;
import api.chat.root.user.application.port.in.LoginByPhoneUseCase;
import api.chat.root.user.application.port.in.LoginByUsernameUseCase;
import api.chat.root.user.application.port.in.PhoneVerificationUseCase;
import api.chat.root.user.application.service.EmailVerificationService;
import api.chat.root.user.application.service.LoginByPhoneService;
import api.chat.root.user.application.service.LoginByUsernameService;
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
	public LoginByPhoneUseCase loginUseCase() {
		return new LoginByPhoneService(null, null, null, null);
	}

	@Bean
	public EmailVerificationUseCase emailVerificationUseCase() {
		return new EmailVerificationService(null, null);
	}

	@Bean
	public PhoneVerificationUseCase phoneVerificationUseCase() {
		return new PhoneVerificationService(null, null);
	}

	@Bean
	public LoginByUsernameUseCase loginByUsernameUseCase() {
		return new LoginByUsernameService(null, null, null, null);
	}
}
