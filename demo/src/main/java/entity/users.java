package entity;
import javax.persistence.*;

@Entity
@Table(name = "Users")
public class users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

//getters and setters
}
