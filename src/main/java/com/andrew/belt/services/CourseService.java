package com.andrew.belt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrew.belt.models.Course;
import com.andrew.belt.repositories.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	
	// CREATE / UPDATE A RECIPE
	public Course save(Course courseObj) {
		return courseRepo.save(courseObj);
	}
	
	// GET ALL RECIPE
	public List<Course> getAllCourses(){
		return courseRepo.findAll();
	}
	
	// GET ONE RECIPE
	public Course getOneCourse(Long id) {
		return courseRepo.findById(id).orElse(null);
	}
	
	// DELETE ONE RECIPE
	public void deleteOneCourse(Long id) {
		courseRepo.deleteById(id);
	}
}