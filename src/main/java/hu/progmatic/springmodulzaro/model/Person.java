package hu.progmatic.springmodulzaro.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String birthPlace;
    private LocalDate birthDate;
    private String email;

//    @OneToMany(mappedBy = "person")
//    @JsonManagedReference
//    private List<Preorder> orders;

}
