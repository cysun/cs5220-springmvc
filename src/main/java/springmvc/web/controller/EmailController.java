package springmvc.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

    @Autowired
    private MailSender mailSender;

    private static final Logger logger = LoggerFactory
        .getLogger( EmailController.class );

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

        String username = ((UserDetails) SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal()).getUsername();
        logger.info( username + " sent an email." );

        return "redirect:email.html";
    }

}
