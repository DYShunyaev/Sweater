package com.DYShunyaev.Project.controller;

import com.DYShunyaev.Project.models.Client;
import com.DYShunyaev.Project.models.Employee;
import com.DYShunyaev.Project.service.ClientService;
import com.DYShunyaev.Project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ClientService clientService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ClientService clientService) {
        this.employeeService = employeeService;
        this.clientService = clientService;
    }

    @RequestMapping("/mainPage")
    public String mainPage() {
        return "mainPage";
    }

    @RequestMapping("/mainView")
    public String mainView(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "mainView";
    }

    @RequestMapping("/search")
    public String searchClient(@RequestParam(name = "name") String name, Model model) {
        List<Client> client = clientService.getByName(name);
        model.addAttribute("clientList", client);

        return "search";
    }

    @RequestMapping("/registration")
    public String registration(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "registration";
    }

    @PostMapping("/registration")
    public String saveNewClient(@RequestParam(name = "name", required = false) String name,
                                @RequestParam(name = "surname", required = false) String surname,
                                @RequestParam(name = "email", required = false) String email,
                                @RequestParam(name = "password", required = false) String password,
                                @RequestParam(name = "birthday", required = false)Date birthday,
                                @RequestParam(name = "address", required = false) String address) {
        Client client = new Client(name, surname, email, password, birthday, address);
        clientService.saveClient(client);
        return "redirect:/mainView";
    }

    @RequestMapping("/getAllClients")
    public String showAllClients(Model model) {
        List<Client> clientList = clientService.showAllClients();
        model.addAttribute("getAllClients", clientList);
        return "getAllClients";
    }

    @RequestMapping("/getAllEmployees")
    public String showAllEmployees(Model model) {
        List<Employee> employeeList = employeeService.showAllEmployees();
        model.addAttribute("getAllEmployees", employeeList);
        return "getAllEmployees";
    }
}
