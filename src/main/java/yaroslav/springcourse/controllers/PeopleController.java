package yaroslav.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yaroslav.springcourse.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(Model model) {
        //Get all people from DAO and put to present
        model.addAttribute("people", personDAO.index());
        return "people/index ";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //get 1 people by id and put in present
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
}
