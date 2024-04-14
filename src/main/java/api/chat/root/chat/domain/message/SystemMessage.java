package api.chat.root.chat.domain.message;

import api.chat.root.chat.domain.ChatRoomId;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public record SystemMessage(
	ChatRoomId chatRoomId,
	String content
) {
}
