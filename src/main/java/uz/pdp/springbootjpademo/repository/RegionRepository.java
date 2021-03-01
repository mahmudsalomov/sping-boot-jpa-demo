package uz.pdp.springbootjpademo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.springbootjpademo.entity.Region;


public interface RegionRepository extends JpaRepository<Region,Integer> {
}
