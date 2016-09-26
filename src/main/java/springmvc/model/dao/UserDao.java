package springmvc.model.dao;

import java.util.List;

import springmvc.model.User;

public interface UserDao {

    User getUser( Integer id );

    List<User> getUsers();

}
