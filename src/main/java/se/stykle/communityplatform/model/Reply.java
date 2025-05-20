package se.stykle.communityplatform.model;

import java.time.OffsetDateTime;

public class Reply {
    private Long id;
    private User author;
    private Post post;
    private String replyContent;
    private boolean modified;
    private OffsetDateTime replyDate;

}
