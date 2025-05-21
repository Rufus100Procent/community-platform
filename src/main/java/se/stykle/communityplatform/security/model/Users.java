package se.stykle.communityplatform.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Table(name = "users")
@Entity
public class Users {
    @Id
    private Integer Id;
    private String userName;
    private String password;
}
