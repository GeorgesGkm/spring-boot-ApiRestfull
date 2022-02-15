package com.demo.apiRestFull.service;
import com.demo.apiRestFull.Exception.StudentNotFountException;
import com.demo.apiRestFull.model.Student;
import com.demo.apiRestFull.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
//create new student
    public Student saveStudent ( Student student)  {
        return this.studentRepository.save(student);
    }

// list of student
    public List<Student> getAllStudent(){
        return this.studentRepository.findAll();
    }

    public Optional<Student> getOneStudent(Long id){
        Optional<Student> student = this.studentRepository.findById(id);
        if(!student.isPresent()){
            throw new StudentNotFountException(String.format("Student with is not found" + id));
        }
        return this.studentRepository.findById(id);
    }

    public Student updateStudent(Student student, Long id){
        Optional<Student> studentExist = this.studentRepository.findById(id);
        if(!studentExist.isPresent()){
            throw new StudentNotFountException(String.format("Student with is not found" + id));
        }

        return  this.studentRepository.save(student);
    }

    public void removeStudent(Long id){
        Optional<Student> student = this.studentRepository.findById(id);
        if(!student.isPresent()){
            throw new StudentNotFountException(String.format("Student with is not found" + id));
        }

         this.studentRepository.delete(student.get());
    }
}
