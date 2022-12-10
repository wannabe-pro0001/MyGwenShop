package GwenShop.com.DAO;

import GwenShop.com.entity.Users;

import java.util.List;

public interface IUserDAO {
    public void createAccount(Users user);

    public void update(Users user);
    public Users findByEmail(String email);
    public List<Users> findUsersByName(String searchString);
    public Users findById(int userid);
}
