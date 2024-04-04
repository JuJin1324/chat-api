package api.chat.root.user.domain.verification;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

public record VerifiedUser(
	String nickname,
	String profileImageUrl,
	VerificationToken verificationToken
) {
}
