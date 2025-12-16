package dao;

import java.util.List;

import entity.User;

public interface UserDAO {
	void create(User user);

	void update(User user);

	void delete(String id);

	User findById(String id);

	List<User> findAll();

	List<User> findByFullname(String fullname);
}
