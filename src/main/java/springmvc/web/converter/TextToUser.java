package springmvc.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import springmvc.model.User;
import springmvc.model.dao.UserDao;

public class TextToUser implements Converter<String, User> {

    @Autowired
    private UserDao userDao;

    @Override
    public User convert( String text )
    {
        return userDao.getUser( Integer.valueOf( text ) );
    }

}
