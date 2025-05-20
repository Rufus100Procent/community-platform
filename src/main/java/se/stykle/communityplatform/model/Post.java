package se.stykle.communityplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import se.stykle.communityplatform.utils.Role;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Long id;
    private String content;
    private String author;
    private Role visibleTo;
    private boolean modified;
    private OffsetDateTime createdAt;

}
