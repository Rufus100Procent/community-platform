package se.stykle.communityplatform;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Post {
    private Long id;
    private String content;
    private User author;
    private Role visibleTo;
    private boolean modified;
    private OffsetDateTime createdAt;

}
