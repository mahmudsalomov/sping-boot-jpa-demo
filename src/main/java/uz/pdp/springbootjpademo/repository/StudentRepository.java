package uz.pdp.springbootjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.springbootjpademo.entity.Student;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByNameContaining(String name);



    @Query(value = "select * from student where name like :name", nativeQuery = true)
    List<Student> searchByName(@Param(value = "name") String name);
}
