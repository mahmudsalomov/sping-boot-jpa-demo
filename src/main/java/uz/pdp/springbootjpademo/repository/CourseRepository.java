package uz.pdp.springbootjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpademo.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
