package com.example.Company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.example.Company.Models.Employee;
import com.example.Company.Repositories.EmployeeRepository;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Obtener todos los empleados
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    // obtener un empleado
    @GetMapping("/employees/{id_employee}")
    public Optional<Employee> getOneEmployees (@PathVariable long id_employee) {
        return employeeRepository.findById(id_employee);
    }

    // Crear un nuevo empleado
   @PostMapping("/employees")
public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    Employee savedEmployee = employeeRepository.save(employee); // Guarda el empleado
    return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee); // Retorna el empleado guardado con un estado 201 Created
}

@PutMapping("/employees/{id_employee}")
public ResponseEntity<Employee> updateEmployee(@PathVariable Long id_employee, @RequestBody Employee employeeDetails) {
    Optional<Employee> employeeOptional = employeeRepository.findById(id_employee);

    if (employeeOptional.isPresent()) {
        Employee employee = employeeOptional.get();
        employee.setName(employeeDetails.getName());
        employee.setLast_name(employeeDetails.getLast_name());
        employee.setEmail(employeeDetails.getEmail());
        employee.setEmploymentdate(employeeDetails.getEmploymentdate());
        
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee); // Devuelve el empleado actualizado con un 200 OK
    } else {
        return ResponseEntity.notFound().build(); // Devuelve un 404 Not Found si el empleado no existe
    }
}

    // Eliminar un empleado
   @DeleteMapping("/employees/{id_employee}")
public ResponseEntity<Void> deleteEmployee(@PathVariable Long id_employee) {
    if (!employeeRepository.existsById(id_employee)) {
        return ResponseEntity.notFound().build(); // Retorna 404 si no se encuentra el empleado
    }
    
    employeeRepository.deleteById(id_employee);
    return ResponseEntity.noContent().build(); // Retorna 204 No Content si se elimina exitosamente
}
}
