package uz.pdp.springbootjpademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import uz.pdp.springbootjpademo.entity.Student;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.StudentDto;
import uz.pdp.springbootjpademo.repository.StudentRepository;
import uz.pdp.springbootjpademo.utils.CommonUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public ApiResponse saveOrEditStudent(StudentDto dto){
        try {
            Student student=new Student();

            if (dto.getId()!=null){
                student=studentRepository.findById(dto.getId()).orElseThrow(()->new IllegalArgumentException("Student with this id not found"));
            }

            student.setName(dto.getName());
            student.setEmail(dto.getEmail());
            student.setPhoneNumber(dto.getPhoneNumber());
            studentRepository.save(student);
            return new ApiResponse(dto.getId()!=null?"Edited":"Saved",true);
        } catch (Exception e){
            return new ApiResponse("Error",false);
        }

    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student getOne(Integer id){
        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Integer.toString(Math.toIntExact(id))));
    }

    public ApiResponse getAllStudents(Integer page,Integer size){
        Page<Student> studentPage = studentRepository.findAll(CommonUtils.simplePageable(page,size));
        return new ApiResponse("Success",true,studentPage.getTotalElements(),
                studentPage.getTotalPages(),
                studentPage.getContent().stream().map(this::getStudentDtoFromStudent).collect(Collectors.toList()));
    }


    public StudentDto getStudentDtoFromStudent(Student student){
        StudentDto dto=new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setPhoneNumber(student.getPhoneNumber());
        return dto;
    }

    public ApiResponse getOneStudentById(Integer id) {
        try {
            Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
            return new ApiResponse("Student found",true,getStudentDtoFromStudent(student));
        } catch (Exception e){
            return new ApiResponse("Student not found",false);
        }
    }

    public ApiResponse removeById(Integer id) {
        try {
            studentRepository.deleteById(id);
            return new ApiResponse("Deleted",true);
        } catch (Exception e){
            return new ApiResponse("Error in deleting. . . ",false);
        }
    }
}
