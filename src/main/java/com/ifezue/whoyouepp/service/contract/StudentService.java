package com.ifezue.whoyouepp.service.contract;

import com.ifezue.whoyouepp.model.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);

    List<Student> getAll();
}
