package com.example.xx2.model.accounts;

import com.example.xx2.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@SQLDelete(sql = "update users set deleted = true where id =?")
@SQLRestriction("deleted = false")
public class User extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String email;
    private String username;
    private String password;

    private long balance;

    private boolean deleted = Boolean.FALSE;

//    private boolean active = Boolean.FALSE;
//
//    private String otp; //simpan yang sudah di hash
//    private LocalDateTime expiredTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
