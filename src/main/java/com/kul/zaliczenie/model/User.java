package com.kul.zaliczenie.model;

import com.kul.zaliczenie.entity.UserEntity;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public static User from(UserEntity userEntity){
        return new User(userEntity.getId(),
                        userEntity.getFirstName(),
                        userEntity.getLastName(),
                        userEntity.getEmail());
    }
}
