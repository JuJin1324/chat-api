package api.chat.root.chat.application.port.in.command;

import java.util.List;
import java.util.UUID;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public record CreateChatRoomCommand(
	UUID actor,
	List<UUID> userIds
) {
}
