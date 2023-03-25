package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository = new StudentRepository();

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }
    public void addStudentToTeacher(String studentName,String teacherName){
        studentRepository.addStudentToTeacher(studentName,teacherName);
    }
    public Student getStudent(String studentName){
        return studentRepository.getStudent(studentName);
    }
    public Teacher getTeacher(String teacherName){
        return studentRepository.getTeacher(teacherName);
    }
    public List<String> getStudentsOfTeacher(String teacherName){
        return studentRepository.getStudentsOfTeacher(teacherName);
    }
    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    public List<String> getAllTeachers(){
        return studentRepository.getAllTeachers();
    }
    public void deleteTeacher(String teacherName){
        studentRepository.deleteTeacher(teacherName);
    }
    public void deleteAllTeachers(){
        List<String> teachersList = getAllTeachers();
        for(String teacherName:teachersList)
            studentRepository.deleteTeacher(teacherName);
    }

}
