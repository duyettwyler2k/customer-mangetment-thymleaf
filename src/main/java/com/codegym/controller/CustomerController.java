package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/customer/list")
    public ModelAndView showListCustomer(){
        List<Customer> customers=customerService.findAll();
        ModelAndView modelAndView=new ModelAndView("/layout");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
    @GetMapping("/customer/create")
    public ModelAndView createCustomerForm(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }
    @PostMapping("/customer/save")
    public ModelAndView saveCustomer(@ModelAttribute(name = "customer")Customer customer){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("customer",new Customer());
        customerService.create(customer);
        return modelAndView;
    }
    @GetMapping("/customer/{id}/view")
    public ModelAndView getCustomer(@PathVariable int id){
        Customer customer=customerService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/view");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }
    @GetMapping("/customer/{id}/delete")
    public String removeCustomer(@PathVariable int id){
        customerService.remove(id);
        return "redirect:/customer/list";
    }
    @GetMapping("/customer/{id}/edit")
    public ModelAndView editCustomer(@PathVariable int id){
      ModelAndView modelAndView=new ModelAndView("/edit");
      modelAndView.addObject("customer",customerService.findById(id));
      return modelAndView;
    }
    @PostMapping("/customer/update")
    public ModelAndView updateCustomer(Customer customer){
        ModelAndView modelAndView=new ModelAndView("/edit");
        modelAndView.addObject("customer",customerService.update(customer.getId(),customer));
        return modelAndView;
    }
}
