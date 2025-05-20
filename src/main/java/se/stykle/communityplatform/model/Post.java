package se.stykle.communityplatform.model;

import se.stykle.communityplatform.utils.Role;

import java.time.OffsetDateTime;

public class Post {
    private Long id;
    private String content;
    private User author;
    private Role visibleTo;
    private boolean modified;
    private OffsetDateTime createdAt;

}
