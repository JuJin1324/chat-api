package api.chat.root.chat.domain;

import java.util.UUID;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public record ChatRoomId(
    UUID value
) {
    public static ChatRoomId generate() {
        return new ChatRoomId(UUID.randomUUID());
    }
}
