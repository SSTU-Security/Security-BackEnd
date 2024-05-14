package ru.bebriki.sstusecurity.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastname;
    String patronymic;
    @Column(unique = true)
    String email;
    String image;
    Double totalHours;
    Boolean isActivated;

    public String getFullName() {
        return lastname + " " + name + " " + patronymic;
    }
}
