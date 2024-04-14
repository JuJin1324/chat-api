package api.chat.root.chat.application.port.in.command;

import java.util.UUID;

import api.chat.root.chat.domain.ChatRoomId;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public record SendTextMessageCommand(
	ChatRoomId chatRoomId,
	String content,
	UUID actor
) {
}
