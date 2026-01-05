package com.example.soap;

import com.example.soap.dao.UserDAO;
import com.example.soap.dto.UserDTO;
import com.example.soap.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@WebService
public class UserService {
    private final UserDAO userDAO = new UserDAO();

    @WebMethod
    public List<UserDTO> getAllUsers() {
        return userDAO.getAllUsers().stream()
                .map(u -> new UserDTO(u.getId(), u.getName(), u.getEmail(), u.getAge()))
                .collect(Collectors.toList());
    }

    @WebMethod
    public UserDTO getUser(int id) {
        User u = userDAO.getUserById(id);
        if(u == null) return null;
        return new UserDTO(u.getId(), u.getName(), u.getEmail(), u.getAge());
    }

    @WebMethod
    public void createUser(UserDTO dto) {
        User u = new User();
        u.setName(dto.getName());
        u.setEmail(dto.getEmail());
        u.setAge(dto.getAge());
        userDAO.createUser(u);
    }

    @WebMethod
    public void updateUser(UserDTO dto) {
        User u = new User();
        u.setId(dto.getId());
        u.setName(dto.getName());
        u.setEmail(dto.getEmail());
        u.setAge(dto.getAge());
        userDAO.updateUser(u);
    }

    @WebMethod
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
