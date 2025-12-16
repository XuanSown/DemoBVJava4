package dao;

import entity.User;

public interface UserDAO {
	void create(User user);

	void update(User user);

	void delete(User user);
}
