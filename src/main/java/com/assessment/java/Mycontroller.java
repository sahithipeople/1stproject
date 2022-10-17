package com.assessment.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Product;

@Controller
public class Mycontroller {
 @Autowired
 Service service;
 @RequestMapping("/")
 public String showhomepage(Model model) {
	
	 System.out.println("----------display data-----------");
	  List<Employee> list=service.display();
	 
	 
	 for(Employee p:list) {
		 
	 System.out.println(p.getId()+" "+p.getName()+" "+p.getAddress());
 }
	 model.addAttribute("xyz",list);
	 return "show11";
}
 @RequestMapping("/add-data")
 public String newemployee(Model model) {
Employee employee=new Employee();
	 model.addAttribute("Employee",employee);
	return "add-emp";
	 
 }
 @RequestMapping(value="/save",method = RequestMethod.POST)
 public String saveAfter(@ModelAttribute("Employee") Employee employee)
 {
     service.saveEmployee(employee);
     return "redirect:/";
 }
 @RequestMapping("/edit/{id}")
 public ModelAndView editEmployee(@PathVariable(name = "id")int id)
 {
     ModelAndView modelAndView=new ModelAndView("edit_emp");
     Employee employee=service.getEmployee(id);
     modelAndView.addObject("Employee",employee);
     return modelAndView;
 }
 @RequestMapping("/delete/{id}")
 public String deleteEmployee(@PathVariable(name= "id") int id)
{
 service.deleteEmployee(id);
 return "redirect:/";
 }

}
