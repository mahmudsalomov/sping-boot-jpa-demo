package uz.pdp.springbootjpademo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.springbootjpademo.entity.District;


public interface DistrictRepository extends JpaRepository<District,Integer> {
}
