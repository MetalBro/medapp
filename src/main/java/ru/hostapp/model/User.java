package ru.hostapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends AbstractNamedEntity{

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 64)
    private String password;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "registered", columnDefinition = "timestamp default now()")
    @NotNull
    private Date registered = new Date();

    @Column(name = "role", nullable = false)
    private String role = String.valueOf(Role.ROLE_USER);

    public User(){

    }

    public User(User u){
        this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.getRegistered(), u.getRole());
    }

    public User(Integer id, String name, String email, String password, String role) {
        this(id, name, email, password, new Date(), role);
    }

    public User(Integer id, String name, String email, String password, Date registered, String role) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.registered = registered;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email=" + email +
                ", name=" + name +
                ", password=" + password +
                ", registered=" + registered +
                ", role=" + role +
                '}';
    }
}
