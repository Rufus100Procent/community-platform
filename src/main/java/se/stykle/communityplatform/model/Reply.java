package se.stykle.communityplatform.model;

import se.stykle.communityplatform.security.model.Users;

import java.time.OffsetDateTime;

public class Reply {
    private Long id;
    private Users author;
    private Post post;
    private String replyContent;
    private boolean modified;
    private OffsetDateTime replyDate;

}
