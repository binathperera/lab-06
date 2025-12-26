package com.example.library.model;

import java.time.LocalDateTime;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String name;

    private String password;

    private Set<String> roles;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
