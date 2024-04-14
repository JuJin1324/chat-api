package api.chat.root.chat.application.port.out;

import api.chat.root.chat.domain.ChatRoom;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public interface PersistChatRoomPort {
	void persist(ChatRoom chatRoom);
}
