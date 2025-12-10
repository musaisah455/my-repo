package my_apps.employee.service;

import my_apps.employee.entity.EmployeeEntity;
import my_apps.employee.model.EmployeeRequest;
import my_apps.employee.exceptions.ResourceNotFoundException;
import my_apps.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<EmployeeEntity> getAllEmployees() {
        return repository.findAll();
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public EmployeeEntity createEmployee(EmployeeRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(request.getFirstName());
        employeeEntity.setLastName(request.getLastName());
        employeeEntity.setEmail(request.getEmail());
        employeeEntity.setDepartment(request.getDepartment());
        employeeEntity.setPosition(request.getPosition());
        employeeEntity.setSalary(request.getSalary());

        return repository.save(employeeEntity);
    }

    public EmployeeEntity updateEmployee(Long id, EmployeeRequest request) {
        EmployeeEntity employeeEntity = getEmployeeById(id);

        if (!employeeEntity.getEmail().equals(request.getEmail()) && repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        employeeEntity.setFirstName(request.getFirstName());
        employeeEntity.setLastName(request.getLastName());
        employeeEntity.setEmail(request.getEmail());
        employeeEntity.setDepartment(request.getDepartment());
        employeeEntity.setPosition(request.getPosition());
        employeeEntity.setSalary(request.getSalary());

        return repository.save(employeeEntity);
    }

    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}