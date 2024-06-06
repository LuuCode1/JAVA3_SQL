package com.example.tk.controller;

import com.example.tk.entities.Customer;
import com.example.tk.entities.Order;
import com.example.tk.repository.CustomerRepo;
import com.example.tk.repository.OrderRepo;
import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ControllerOrder {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    CustomerRepo customerRepo;
    @ModelAttribute("customer")
    public List<Customer> customer() {
        return customerRepo.findAll();
    }
    @GetMapping("/home")
    public String index(Model model) {
        List<Order> order =orderRepo.findAll();
        model.addAttribute("order", order);
        return "index";
    }
    @GetMapping("delete")
    public String delete(Model model, @RequestParam("id") Integer id) {
        orderRepo.deleteById(id);
        return "redirect:/home";
    }
    @GetMapping("create")
    public String createOrUpdate(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "create";
    }
    @GetMapping("update")
    public String update(Model model,@RequestParam("id") Integer id){
        Order order = orderRepo.getReferenceById(id);
        model.addAttribute("order", order);
        return "create";
    }
    @PostMapping("create")
    public String save(Model model, @Valid @ModelAttribute("order") Order order, BindingResult result,@RequestParam("id") Integer id){
        if (result.hasErrors()) {
            return "create";
        }
        if(id == null){
            order = new Order();
        }else{
            Order existingOrder = orderRepo.getReferenceById(id);
            existingOrder.setNameorder(order.getNameorder());
            existingOrder.setPrice(order.getPrice());
            existingOrder.setQuantity(order.getQuantity());
            existingOrder.setCustomer(order.getCustomer());
        }
        orderRepo.save(order);
        return "redirect:/home";
    }
    @PostMapping("seach")
    public String seach(Model model, @RequestParam(value = "name",required = false) String name){
        List<Order> order = orderRepo.order(name);
        model.addAttribute("order", order);
        return "index";
    }
    @PostMapping("sorts")
    public String sort(Model model, @RequestParam(value = "name",required = false) String name){
        List<Order> order = orderRepo.findAll(Sort.by("nameorder"));
        model.addAttribute("order", order);
        return "index";
    }

}
