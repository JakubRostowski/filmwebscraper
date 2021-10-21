package pl.jrostowski.filmwebscraper.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long userId;

    @NonNull private String username;
    @NonNull private String email;
    @NonNull private String password;
    @NonNull private int enabled = 1;
    @NonNull private String role = "ROLE_USER";
    private Timestamp timeOfCreation = new Timestamp(System.currentTimeMillis());
    private Timestamp timeOfModification = new Timestamp(System.currentTimeMillis());

}
