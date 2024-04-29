package com.example.hotelmanagementsy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.hotelmanagementsy.repository.EmployeeRepository;
import com.example.hotelmanagementsy.model.Employee;

import org.springframework.ui.Model;

@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/addEmployee")
    public String showEmployeePage() {
        return "addEmployee"; // Assuming there's an employee.html template for the employee page
    }

    @PostMapping("/addEmployee")
    public String addEmployee(
            @RequestParam("employeeType") String employee_type,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("age") int age,
            @RequestParam("gender") String gender,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("address") String address,
            RedirectAttributes redirectAttributes,
            Model model) {

        // Create an Employee object
        Employee employee = new Employee();
        employee.setEmployee_type(employee_type);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setGender(gender);
        employee.setPhoneNumber(phoneNumber);
        employee.setAddress(address);

        // Save the employee to the database using the repository interface
        employeeRepository.save(employee);

        // Add a flash attribute to display success message
        redirectAttributes.addFlashAttribute("successMessage", "Employee added successfully");

        return "redirect:/dashboard";
    }


    @GetMapping("/employeeDetails")
    public String showEmployeeDetails(@RequestParam("employeeId") Long employeeId, Model model) {
        // Retrieve employee details from the database based on ID
        Employee employee = employeeRepository.findById(employeeId);



        // Pass the retrieved employee object to the HTML template
        model.addAttribute("employee", employee);

        // Return the HTML template to display employee details
        return "EmployeeDetails";
    }

    // Add other CRUD operations (update, delete, view) as needed
}
