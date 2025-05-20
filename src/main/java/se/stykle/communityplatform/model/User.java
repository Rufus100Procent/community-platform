package se.stykle.communityplatform.model;

import se.stykle.communityplatform.utils.Role;

import java.time.OffsetDateTime;

public class User {
    private Long Id;
    private String emailAddress;
    private String userName;
    private Role role;
    private OffsetDateTime registerDate;

}
