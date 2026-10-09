package com.Fawadkhan.hms.Service;

import com.Fawadkhan.hms.Entity.Student;
import com.Fawadkhan.hms.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // GET ALL
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET BY ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // UPDATE
    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setGender(student.getGender());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setSemester(student.getSemester());
        existingStudent.setStatus(student.getStatus());
        existingStudent.setUser(student.getUser());

        return studentRepository.save(existingStudent);
    }

    // DELETE
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // FIND BY EMAIL
    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}