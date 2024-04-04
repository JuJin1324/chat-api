package api.chat.root.user.application.port.out;

import api.chat.root.user.domain.User;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */
public interface LoadUserByPhonePort {
	User load(String phoneNumber);
}
