package uz.pdp.springbootjpademo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Integer id;

    private String name;

    private String email;

    private String phoneNumber;
}
