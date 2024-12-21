package ma.formations.msa.webclientfrontend.controller;

import lombok.AllArgsConstructor;
import ma.formations.msa.webclientfrontend.domaine.EmpVo;
import ma.formations.msa.webclientfrontend.service.IService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;

@Controller
@AllArgsConstructor
public class EmpController {
    private final IService service;

    @RequestMapping(value = "/")
    public String showWelcomeFile(Model m) {
        // Load and display employees in data-driven mode
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(service.getAllEmployees(), 1);
        m.addAttribute("employees", reactiveDataDrivenMode);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model m) {
        m.addAttribute("emp", new EmpVo());
        return "add";
    }

    @PostMapping("/create")
    public String addEmployee(EmpVo emp) {
        service.createEmployee(emp).subscribe();
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public Mono<String> showUpdateForm(@PathVariable("id") long id, Model m) {
        return service.getEmployeeById(id)
                .doOnNext(employee -> m.addAttribute("emp", employee))
                .then(Mono.just("edit")); // Return the view name
    }

    @PostMapping("/update")
    public String updateEmp(EmpVo emp) {
        service.updateEmployee(emp.getId(), emp).subscribe();
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id") long id) {
        service.deleteEmployee(id).subscribe();
        return "redirect:/";
    }
}