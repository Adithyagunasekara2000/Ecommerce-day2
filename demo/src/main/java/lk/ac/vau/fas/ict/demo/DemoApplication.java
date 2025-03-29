package lk.ac.vau.fas.ict.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")
@SpringBootApplication
public class DemoApplication {
	 public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
class StudentController {

	Student obj=new Student("IT1","Adithya",24,"ict",3.0);
	Student obj2=new Student("IT2","Malithi",24,"ict",3.2);
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
	

	}


