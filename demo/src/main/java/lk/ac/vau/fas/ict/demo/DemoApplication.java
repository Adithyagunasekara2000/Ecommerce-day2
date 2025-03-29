package lk.ac.vau.fas.ict.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;


@SpringBootApplication
public class DemoApplication {
	 public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
@RestController
@RequestMapping("/app")
class StudentController {

	Student obj=new Student("IT1","Adithya",21,"ict",3.0);
	Student obj2=new Student("IT2","Malithi",22,"ict",3.2);
	Student obj3=new Student("IT3","achala",25,"ict",3.3);
	List<Student> students=new ArrayList <Student>();
	
	public StudentController() {
		students.add(obj);
		students.add(obj2);
		students.add(obj3);
	}
	@GetMapping("/msg")
	public String myMessage() {
		return "Hello SpringBoot";
	}
	@GetMapping("/name")
	public String mymessage() {
		return "My name is Adithya";
	}
	@GetMapping("/age/{ag}")
	public String MyAge(@PathVariable("ag") int age) {
		return "My age is "+age;
	}
	@GetMapping("/student")
	public Student getStudent() {
		return obj;
	}
	@GetMapping("/students")
	public List<Student> getStudents() {
		students.add(obj);
		students.add(obj2);
		students.add(obj3);
		return students;
	}
	//find a student from the list by regNo
	@GetMapping("/student/{id}")
	public Student getStudentID(@PathVariable("id") String regno){
		for(Student student:students) {
			if(student.getRegNo().equals(regno)) {
				return student;
			}
		}
		return null;
	}

	@GetMapping("/age-range")
    public List<Student> getStudentsByAgeRange() {
        return students.stream()
                .filter(s -> s.getAge() >= 20 && s.getAge() <= 23)
                .collect(Collectors.toList());
    }
	@GetMapping("/sorted-by-gpa")
    public List<Student> getSortedByGpa() {
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }
	@GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") String regNo) {
        return students.stream()
                .filter(s -> s.getRegNo().equals(regNo))
                .findFirst()
                .orElse(null);
    }

   
    @PostMapping
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student added successfully!";
    }

    
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable("id") String regNo, @RequestBody Student updatedStudent) {
        for (Student student : students) {
            if (student.getRegNo().equals(regNo)) {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                student.setGpa(updatedStudent.getGpa());
                return "Student updated successfully!";
            }
        }
        return "Student not found!";
    }

  
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") String regNo) {
        return students.removeIf(student -> student.getRegNo().equals(regNo)) 
                ? "Student deleted successfully!" 
                : "Student not found!";
    }
}
	

	


