package springmvc.web.converter;

import org.springframework.core.convert.converter.Converter;

import springmvc.model.User;

public class UserToText implements Converter<User, String> {

    @Override
    public String convert( User user )
    {
        return user.getId().toString();
    }

}
