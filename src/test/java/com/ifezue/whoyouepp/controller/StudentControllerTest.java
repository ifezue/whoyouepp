package com.ifezue.whoyouepp.controller;

import com.ifezue.whoyouepp.model.Student;
import com.ifezue.whoyouepp.service.contract.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_ShouldReturnOk() throws Exception {
        mockMvc
                .perform(get("/api/students"))
                .andExpect(status().isOk());
    }

    //@Test
    public void test_ShouldReturnOkForPostCall() throws Exception {
        Student student = new Student();
        student.setName("MJ");

        when(studentService.create(any())).thenReturn(student);

        mockMvc
                .perform(post("/api/students", student))
                .andExpect(status().isOk());
    }
}
