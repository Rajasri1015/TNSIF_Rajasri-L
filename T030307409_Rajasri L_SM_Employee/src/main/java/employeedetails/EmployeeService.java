package employeedetails;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> listAll() {
        return repo.findAll();
    }

    public void save(Employee employee) {
        repo.save(employee);
    }

    public Employee get(Integer id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
