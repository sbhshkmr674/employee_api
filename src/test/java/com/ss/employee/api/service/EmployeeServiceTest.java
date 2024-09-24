package com.ss.employee.api.service;

import com.ss.employee.api.entity.Employee;
import com.ss.employee.api.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {


    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testSaveEmployee_Success(){
        //Data Configuration
        Employee expectedResult=Employee.builder()
                .id(8)
                .name("Basant")
                .dept("Travel and Track")
                .designation("Sales and Marketing")
                .build();
        //When
        when(employeeRepository.save(any())).thenReturn(expectedResult);

        //Calling method
       Employee actualResult = employeeService.createEmployee(expectedResult);
        //Assert
        assertNotNull(actualResult);
        assertEquals(expectedResult.getDept(),actualResult.getDept());
    }
    @Test
    public void testGetEmployeeById_Success(){
        //Data Configuration
        Employee expectedResult=Employee.builder()
                .id(10)
                .name("Basant")
                .dept("Travel and Track")
                .designation("Sales and Marketing")
                .build();
        //When
        when(employeeRepository.findById(anyInt())).thenReturn(Optional.of(expectedResult));

       Employee actualResult =employeeService.getEmployeeDetails(20);

       //Assert
        assertNotNull(actualResult);
        assertEquals(expectedResult,actualResult);

    }

    @Test
    public void testGetEmployeeByIdNotFound_Exception(){

        RuntimeException rex = assertThrows(RuntimeException.class,()->{
         employeeService.getEmployeeDetails(20);
     });


     String expectedMessage ="Error fecting Employee Id : 20";
     String actualMessage =rex.getMessage();

     assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetAllEmployee(){

        //Data Configuration
        Employee emp1=Employee.builder()
                .id(1)
                .name("Subhash")
                .dept("IT & Technology")
                .designation("SSE")
                .build();
        Employee emp2=Employee.builder()
                .id(5)
                .name("Shahin")
                .dept("IT & Technology")
                .designation("SE")
                .build();
        //When
        when(employeeRepository.findAll()).thenReturn(List.of(emp1,emp2));

        //Acting method
        List<Employee> employees=  employeeService.getAllEmployees();

        //Assert
        assertNotNull(employees);
        assertEquals(List.of(emp1,emp2),employees);
    }
}
