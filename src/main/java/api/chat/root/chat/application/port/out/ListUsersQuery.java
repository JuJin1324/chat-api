package api.chat.root.chat.application.port.out;

import java.util.List;
import java.util.UUID;

import api.chat.root.chat.domain.User;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public interface ListUsersQuery {
	List<User> getList(List<UUID> userIds);
}
