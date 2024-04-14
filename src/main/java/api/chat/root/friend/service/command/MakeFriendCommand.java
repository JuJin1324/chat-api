package api.chat.root.friend.service.command;

import java.util.UUID;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public record MakeFriendCommand(
	UUID userId,
	UUID actor
) {
}
