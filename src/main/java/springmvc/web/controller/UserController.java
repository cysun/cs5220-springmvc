package springmvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import springmvc.model.User;
import springmvc.model.dao.UserDao;

@Controller
@SessionAttributes({ "user", "users" })
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/user/list.html")
    public String list( ModelMap models )
    {
        models.put( "users", userDao.getUsers() );
        return "user/list";
    }

    @RequestMapping("/user/view.html")
    public String view1( @RequestParam Integer id, ModelMap models )
    {
        models.put( "user", userDao.getUser( id ) );
        return "user/view";
    }

    @RequestMapping("/user/{id}.html")
    public String view2( @PathVariable Integer id, ModelMap models )
    {
        models.put( "user", userDao.getUser( id ) );
        return "user/view";
    }

    @RequestMapping(value = "/user/add.html", method = RequestMethod.GET)
    public String add( ModelMap models )
    {
        models.put( "user", new User() );
        models.put( "users", userDao.getUsers() );
        return "user/add";
    }

    @RequestMapping(value = "/user/add.html", method = RequestMethod.POST)
    public String add( @ModelAttribute User user )
    {
        user = userDao.saveUser( user );
        return "redirect:list.html";
    }

    @RequestMapping(value = "/user/edit.html", method = RequestMethod.GET)
    public String edit( @RequestParam Integer id, ModelMap models )
    {
        models.put( "user", userDao.getUser( id ) );
        models.put( "users", userDao.getUsers() );
        return "user/edit";
    }

    @RequestMapping(value = "/user/edit.html", method = RequestMethod.POST)
    public String edit( @ModelAttribute User user, SessionStatus sessionStatus )
    {
        user = userDao.saveUser( user );
        sessionStatus.setComplete();
        return "redirect:list.html";
    }

}
