package com.ifezue.whoyouepp.service;

import com.ifezue.whoyouepp.dao.StudentDao;
import com.ifezue.whoyouepp.model.Student;
import com.ifezue.whoyouepp.service.contract.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.NONE)
public class StudentServiceTest {

    @Mock
    StudentService studentService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_ShouldReturnCreatedStudent(){
        Student expectedStudent = new Student();
        expectedStudent.setId(1L);
        expectedStudent.setName("MJ");

        Student student = new Student();
        student.setName("MJ");

        when(studentService.create(student)).thenReturn(expectedStudent);

        Assert.assertEquals((studentService.create(student)).getId(), expectedStudent.getId());
    }
}
