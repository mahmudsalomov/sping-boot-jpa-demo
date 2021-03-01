package uz.pdp.springbootjpademo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Region extends AbsNameEntity{
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "region",cascade = CascadeType.ALL)
    private List<District> districts;
}
