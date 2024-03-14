package tryxe.co.Streaming.website.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(nullable = false)
    private String country;
    private LocalDate registrationDate;
    @Column(nullable = false)
    private Long prefix;
    @Column(nullable = false, unique = true)
    private BigInteger phoneNumber;
    private Long membershipId;
}
