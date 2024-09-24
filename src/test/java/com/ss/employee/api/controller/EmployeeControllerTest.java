package com.ss.employee.api.controller;

import com.ss.employee.api.entity.Employee;
import com.ss.employee.api.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureWebTestClient
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddEmployeeDetails_Success() throws Exception {

        Employee expectedResult=Employee.builder()
                .id(10)
                .name("Basant")
                .dept("Travel and Track")
                .designation("Sales and Marketing")
                .build();
        when(employeeService.createEmployee(any())).thenReturn(expectedResult);

        mockMvc.perform(post("http://localhost:8080/employee/v1/employees/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(expectedResult)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$id").value(10))
                .andExpect(jsonPath("$name").value("Basant"))
                .andExpect(jsonPath("$dept").value("Travel and Track"))
                .andExpect(jsonPath("$designation").value("Sales and Marketing"));



    }
}
