package com.ss.employee.api.repository;

import com.ss.employee.api.entity.Employee;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Transactional
public class EmployeeRepositoryTest
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
  public void runTest()
  {
      System.out.println("Hi Ullu");
  }

  @Test
  public  void saveEmployeeTest()
  {
      Employee emp = Employee.builder()
              .id(8)
              .name("ULLU Das")
              .dept("HRS")
              .designation("SSC")
              .build();

    Employee emp1=employeeRepository.save(emp) ;
    assertNotNull(emp1);
    assertEquals(emp.getName(),emp1.getName(),"both Name are equal");
    assertEquals(emp.getDept(),emp1.getDept(),"both Department are equal");
    assertEquals(emp.getDesignation(),emp1.getDesignation(),"Both Designation are equal");
  }
}
