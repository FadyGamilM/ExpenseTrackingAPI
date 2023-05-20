package com.backend.expensetrackerapi.domain;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// map the table with this class
@Table(name = "et_users", uniqueConstraints = @UniqueConstraint(columnNames = "email", name = "unique_email_constraint"))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    // specify the db column name to be mapped to this class-attr
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "et_users_seq", sequenceName = "et_users_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "et_users_seq")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    // // @JsonIgnore // TO AVOID THE PROBLEM OF INFINITE LOOP ..
    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "user_id", referencedColumnName = "id") // the
    // referencedColumnName is the name of the PK of
    // // the current class and its the name of the attr not
    // // the db column
    // private Set<Category> categories;

    @Override
    public String toString() {
        return getId() + " ➜ " + getUsername() + ", " + getEmail();
    }

}