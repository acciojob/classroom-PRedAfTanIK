package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentMap = new HashMap<>();
    HashMap<String,Teacher> teacherMap = new HashMap<>();
    HashMap<String, Set<String>> classMap = new HashMap<>();

    public void addStudent(Student student){
        studentMap.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }
    public void addStudentToTeacher(String studentName,String teacherName){
        classMap.putIfAbsent(teacherName,new HashSet<>());
        classMap.get(teacherName).add(studentName);
    }
    public Student getStudent(String studentName){
        return studentMap.getOrDefault(studentName,new Student());
    }
    public Teacher getTeacher(String teacherName){
        return teacherMap.getOrDefault(teacherName,new Teacher());
    }
    public List<String> getStudentsOfTeacher(String teacherName){
        List<String> list = new ArrayList<>();
        if(!classMap.containsKey(teacherName)) return list;

        for(String studentName:classMap.get(teacherName))
            list.add(studentName);

        return list;
    }

    public List<String> getAllStudents(){
        List<String> list = new ArrayList<>();
        for(String studentName:studentMap.keySet())
            list.add(studentName);
        return list;
    }
    public List<String> getAllTeachers(){
        List<String> list = new ArrayList<>();
        for(String teacherName:teacherMap.keySet())
            list.add(teacherName);

        return list;
    }
    public void deleteTeacher(String teacherName){
        teacherMap.remove(teacherName);
        for(String studentName:classMap.get(teacherName))
            studentMap.remove(studentName);
        classMap.remove(teacherName);
    }

}
