package api.chat.root.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@AllArgsConstructor
@Getter
public class User {
	private final UserId id;
	private String nickname;
	private String profileImageUrl;
	private String phoneNumber;
	private String emailAddress;
	private final String username;
	private String password;
}
