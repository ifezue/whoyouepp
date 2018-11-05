package com.ifezue.whoyouepp.service;

import com.ifezue.whoyouepp.dao.StudentDao;
import com.ifezue.whoyouepp.model.Student;
import com.ifezue.whoyouepp.service.contract.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceConcrete implements StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceConcrete(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student create(Student student) {
        return studentDao.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.findAll();
    }
}
