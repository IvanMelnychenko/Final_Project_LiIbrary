package ua.testing.entity;

import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;
  @Column(name = "username",unique = true,nullable = false)
  private String username;
  @Column(name = "email",unique = true)
private String email;
  @Column(name = "telephone")
  private Long tel;
  @Column(name = "password", nullable = false)
  private String password;
  @Column(name = "role")
  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @Enumerated(value = EnumType.STRING)
  private Set<Role> role;
}
