package com.andrew.belt.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.andrew.belt.models.Course;
import com.andrew.belt.models.User;
import com.andrew.belt.services.CourseService;
import com.andrew.belt.services.UserService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseServ;
	
	@Autowired
	private UserService userServ;
	
	
	// ---------------- CREATE ------------------//
	@GetMapping("/courses/new")
	public String newCourse(
			HttpSession session,
			@ModelAttribute("courseObj") Course emptyCourse
			
	) {
	
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		return "new.jsp";
	}
	
	@PostMapping("/courses/new")
	public String createCourse(
			@Valid @ModelAttribute("courseObj") Course filledCourse,
			BindingResult results
	) {
	
		if(results.hasErrors()) {
			
			return "new.jsp";
		}
		else {
		
			courseServ.save(filledCourse);
			return "redirect:/dashboard";
		}
	}
	
	// ---------------- CREATE ------------------//
	
	
	
	// ---------------- READ --------------------//
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
	
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		Long user_id = (Long) session.getAttribute("user_id");
		User loggedUser = userServ.getOneUser(user_id);
		
		
		List<Course> allCourses = courseServ.getAllCourses();
		
		model.addAttribute("user", loggedUser);
		model.addAttribute("courses", allCourses);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/courses/{id}")
	public String oneCourse(@PathVariable("id") Long id, Model model, HttpSession session) {
	
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		
		
		Course oneCourse = courseServ.getOneCourse(id);
		
		model.addAttribute("course", oneCourse);
		
		return "oneCourse.jsp";
	}
	
	// ---------------- READ --------------------//
	
	// ---------------- UPDATE --------------------//
	@GetMapping("/courses/edit/{id}")
	public String editCourse(@PathVariable("id")Long id, Model model, HttpSession session) {
		
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
	
		Course oneCourse = courseServ.getOneCourse(id);
		
		model.addAttribute("courseObj", oneCourse);
		
		return "editCourse.jsp";
	}
	
	@PutMapping("/courses/edit/{id}")
	public String updateCourse(
			@Valid @ModelAttribute("courseObj") Course filledCourse,
			BindingResult results
	) {
	
		if(results.hasErrors()) {
		
			return "editCourse.jsp";
		}
		else {
			
			courseServ.save(filledCourse);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/courses/delete/{id}")
	public String deleteCourse(@PathVariable("id")Long id) {
		courseServ.deleteOneCourse(id);
		return "redirect:/dashboard";
	}

	
}
