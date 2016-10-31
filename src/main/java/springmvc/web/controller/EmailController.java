package springmvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

    @Autowired
    private MailSender mailSender;

    @RequestMapping(value = "/email.html", method = RequestMethod.GET)
    public String email()
    {
        return "email";
    }

    @RequestMapping(value = "/email.html", method = RequestMethod.POST)
    public String email( @RequestParam String from, @RequestParam String to,
        @RequestParam String subject, @RequestParam String content )
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom( from );
        message.setTo( to );
        message.setSubject( subject );
        message.setText( content );

        mailSender.send( message );

        return "redirect:email.html";
    }

}
