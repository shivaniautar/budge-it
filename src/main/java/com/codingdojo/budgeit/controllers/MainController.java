package com.codingdojo.budgeit.controllers;


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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.budgeit.models.Budget;
import com.codingdojo.budgeit.models.User;
import com.codingdojo.budgeit.services.BudgetService;
import com.codingdojo.budgeit.services.ExpenseService;
import com.codingdojo.budgeit.services.UserService;
import com.codingdojo.budgeit.validators.UserValidator;




@Controller
public class MainController {
	@Autowired
	UserService userService;
	@Autowired
    BudgetService budgetService;
	@Autowired
    ExpenseService expenseService;
	@Autowired
	UserValidator userValidator;
	
	@RequestMapping("")
    public String loginReg(@ModelAttribute("user") User user) {
        return "loginReg.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
    	if(result.hasErrors()){
    		return "loginReg.jsp";
        }
        else {
        	User newUser=userService.registerUser(user);
        	session.setAttribute("userId", newUser.getId());
        	session.setAttribute("user", newUser);
        	return "redirect:/budge-it";
        }
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, @ModelAttribute("user") User user) {
    	if(userService.authenticateUser(email, password)) {
    		// successful
    		User thisUser = userService.findByEmail(email);
    		session.setAttribute("userId", thisUser.getId());
    		session.setAttribute("user", thisUser);
    		
    	  	Long u_id= (Long)session.getAttribute("userId");
    	  	Long id = (Long)(userService.findUserById(u_id)).getBudget().getId();
    	  	System.out.println(id);
    	  	return "redirect:/budge-it/"+ id +"/home";
    	}
        // failure
    	model.addAttribute("error", "Invalid login");
    	return "loginReg.jsp";
    	
    }
    @GetMapping("/budge-it")
	public String showDashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId") != null) {
	    	session.getAttribute("user");
//	    	User cUser = session.getAttribute("userId");	
//			model.addAttribute("budgeet", userService.findUserById(Id).getBudget();
//			model.addAttribute("ideas", ideas);
//			User cUser = session.getAttribute("userId");
//			if(ideaService.ideaLikedByUser(ideas, cUser); {
//				model.addAttribute("liked", "true");
//			}
			return "Index.jsp";
		}
		return "redirect:/";
		
	}
    
    @GetMapping("/budget-it/newbudget")
    public String newBudget(@ModelAttribute("budget") Budget budget, Model model, HttpSession session) {
		Long id= (Long)session.getAttribute("userId");//get logged in user in session based on ID in session
		User user =userService.findUserById(id);
	return "NewBudgetPage.jsp";
    }
       
	@RequestMapping("/budget-it/{id}/home")
	public String budgetHome(@PathVariable("id") Long id, Model model, HttpSession session,BindingResult result) {
		if(session.getAttribute("userId") != null) {
	    	session.getAttribute("user");
	    	
			if(result.hasErrors()) {
			return "redirect:/budget-it/" + id +"/home";
			}
	    	
	    	model.addAttribute("user", session.getAttribute("user"));
	    	model.addAttribute("budget", budgetService.findById(id));
			return "BudgetHome.jsp";
		}
		return "redirect:/";
	}
    
    @PostMapping("/newbudget")
	public String submitBudget(@Valid @ModelAttribute("budget") Budget budget, BindingResult result, HttpSession session, Model model) {
	  	if(result.hasErrors()) {
			if(budget.getBudgetAmount() == 0.0) {
			model.addAttribute("error", "You must enter a budget amount!!!");
	  		return "NewBudgetPage.jsp";
			}
	  	}
	  	
	  	Long u_id= (Long)session.getAttribute("userId");
	  	User user =userService.findUserById(u_id);
	  	budget.setUser(user);
	  	budgetService.save(budget);
	  	Long id = (Long)userService.findUserById(u_id).getBudget().getId();
	  	return "redirect:/budge-it/"+ id +"/home";
	}
    
    
//    @PostMapping("/ideas/newidea")
//    public String submitIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session) {
//    	if(result.hasErrors()) {
//    		return "new.jsp";
//    	}
//    	Long id= (Long)session.getAttribute("userId");
//    	User user =userService.findUserById(id);
//    	idea.setCreator(user);
//    	ideaService.save(idea);
//    	return "redirect:/ideas";
//    	
//    }
//    
//    //DISPLAYING PAGE
//    
//    @GetMapping("/ideas/{id}")
//	public String show(@PathVariable("id") Long id, Model model) {
//    	model.addAttribute("idea", ideaService.findIdea(id));
//		model.addAttribute("creator", ideaService.findIdea(id).getCreator());
//		model.addAttribute("idea_likers", ideaService.findById(id).getUsers());
//		return "show.jsp";
//	}
//    //DISPLAY EDIT PAGE
//	@RequestMapping("/ideas/{id}/edit")
//	public String editPage(@PathVariable("id") Long id, Model model) {
//    	model.addAttribute("idea", ideaService.findIdea(id));
//		return "edit.jsp";
//	}
//	@PostMapping("/ideas/{id}/edit")
//	public String edit(@PathVariable("id") Long id, @Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model model) {
////		if(result.hasErrors()) {
////			return "redirect:/ideas/" + id +"/edit";
////		}
//		if(result.hasErrors()) {
//			if(idea.getIdeaName().length()< 1) {
//				model.addAttribute("nameError", "You must enter a task name!!!");
//				return "edit.jsp";
//			}
//			return "edit.jsp";	
//		}
//		model.addAttribute("idea", ideaService.findIdea(id));
//		idea.setCreator(ideaService.findIdea(id).getCreator());
//		ideaService.save(idea);
//		return "redirect:/ideas";
//	}
//    
//	//DELETE IDEA -PROCESS 
//	
////	@PostMapping("/ideas/delete/{id}")
////	public String delete(@PathVariable("id") Long id) {
////		ideaService.deleteIdea(id);
////		return "redirect:/ideas";
////	}
//	
//	@RequestMapping(value="/ideas/delete/{id}", method=RequestMethod.DELETE)
//	   public String destroy(@PathVariable("id") Long id) {
//	       ideaService.deleteIdea(id);
//	       return "redirect:/ideas";
//	   }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
	}
//    
//    @RequestMapping(value="/ideas/like/{id}", method=RequestMethod.POST)
//	public String like(@PathVariable("id") Long id, @ModelAttribute("idea") Idea idea, BindingResult result, Model model, HttpSession session) {
//    		Idea likedIdea = ideaService.findIdea(id);
//    		Long userId = (Long) session.getAttribute("userId");
//    		User thisUser = userService.findUserById(userId);
//    		likedIdea.addUser(thisUser);
//    		ideaService.save(likedIdea);
//		return "redirect:/ideas";
//	}
//    
//    @RequestMapping(value="/ideas/unlike/{id}", method=RequestMethod.POST)
//	public String unlike(@PathVariable("id") Long id, @ModelAttribute("idea") Idea idea, BindingResult result, Model model, HttpSession session) {
//
//		Idea unlikedIdea = ideaService.findIdea(id);
//		Long userId = (Long) session.getAttribute("userId");
//		User thisUser = userService.findUserById(userId);
//		unlikedIdea.getUsers().remove(thisUser);
//		ideaService.save(unlikedIdea);
//		return "redirect:/ideas";
//	}
}
//		model.addAttribute("idea", ideaService.findIdea(id));
//		model.addAttribute("user", session.getAttribute("userId"));
//		User user = userService.findUserById(id);
//		idea.getUsers().add(user);
//		ideaService.save(idea);
//		idea.setCreator(ideaService.findIdea(id).getCreator());
//		ideaService.save(idea);
//		return "redirect:/ideas";
//	}


