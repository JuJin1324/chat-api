package api.chat.root.user.application.port.in;

import api.chat.root.user.domain.UserId;
import api.chat.root.user.domain.UserView;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public interface RetrieveUserQuery {
	UserView retrieve(UserId id);
}
