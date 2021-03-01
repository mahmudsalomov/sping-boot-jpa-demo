package uz.pdp.springbootjpademo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends AbsNameEntity{



    @Email
    @Column(nullable = false)
    private String email;

    @Size(min = 13, max = 13)
    @Pattern(regexp = "^[+][9][9][8][0-9]$", message = "Phone number must be 13 digits.")
    private String phoneNumber;

    @ManyToMany
    private List<Course> courses;



}
