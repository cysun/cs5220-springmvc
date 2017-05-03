package springmvc.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import freemarker.template.Configuration;
import springmvc.model.User;

@Controller
public class EmailController {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private Configuration freemarkerConfiguration;

    private static final Logger logger = LoggerFactory
        .getLogger( EmailController.class );

    @RequestMapping(value = "/email.html", method = RequestMethod.GET)
    public String email( ModelMap models ) throws Exception
    {
        Map<String, Object> fmodels = new HashMap<String, Object>();
        fmodels.put( "user", new User( "A Good Guy" ) );
        fmodels.put( "recipient", "John" );
        fmodels.put( "date", new Date() );
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(
            freemarkerConfiguration.getTemplate( "notification.txt" ),
            fmodels );

        SimpleMailMessage message = new SimpleMailMessage();
        message.setText( text );
        models.put( "message", message );
        return "email";
    }

    @RequestMapping(value = "/email.html", method = RequestMethod.POST)
    public String email(
        @ModelAttribute(name = "message") SimpleMailMessage message )
    {
        mailSender.send( message );

        String username = ((UserDetails) SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal()).getUsername();
        logger.info( username + " sent an email." );

        return "redirect:email.html";
    }

}
