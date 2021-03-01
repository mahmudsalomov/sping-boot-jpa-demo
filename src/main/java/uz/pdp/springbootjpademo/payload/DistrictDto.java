package uz.pdp.springbootjpademo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDto {
    private Integer id;
    private String name;
    private Integer regionId;
}
