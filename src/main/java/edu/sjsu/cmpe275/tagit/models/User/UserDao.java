package edu.sjsu.cmpe275.tagit.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {

}