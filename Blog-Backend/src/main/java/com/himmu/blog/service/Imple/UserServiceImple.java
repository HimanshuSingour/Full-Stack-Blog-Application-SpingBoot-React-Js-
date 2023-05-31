package com.himmu.blog.service.Imple;

import java.util.List;
import java.util.stream.Collectors;

import com.himmu.blog.Expections.ResourseNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himmu.blog.Repositories.UserRepository;
import com.himmu.blog.dto.UserDTO;
import com.himmu.blog.entities.Users;
import com.himmu.blog.service.UserService;

@Service
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO createUser(UserDTO userdto) {
		
		Users user = DtoToUser(userdto);
		Users saveuser = userRepository.save(user);
		return usersToDTO(saveuser);

	}

	@Override
	public UserDTO updateUser(UserDTO userdto, Integer userId) {
		
		Users finduser = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourseNotFoundExceptions("Users" , "id" , userId));
		
		finduser.setName(userdto.getName());
		finduser.setEmail(userdto.getEmail());
		finduser.setPassword(userdto.getPassword());
		finduser.setAbout(userdto.getAbout());
		
		Users updatedUser = userRepository.save(finduser);
		UserDTO userDTO1 = usersToDTO(updatedUser);
		return userDTO1;
			
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		
		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("Users" , "id" , userId));
		return usersToDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		
		List<Users> users = userRepository.findAll();
		List<UserDTO> userdto = users.stream().map(e -> usersToDTO(e)).collect(Collectors.toList());
		return userdto;
	}

	@Override
	public void deletUser(Integer userId) {
		
		Users users = userRepository.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("Users" , "id" , userId));
		
		userRepository.delete(users);

	}
	
	
	// Conversion DTO to user or vice versa
	
	private Users DtoToUser(UserDTO userdto) {
		
		Users user = new Users();
		user.setName(userdto.getName());
		user.setPassword(userdto.getPassword());
		user.setEmail(userdto.getEmail());
		user.setAbout(userdto.getAbout());
		return user;
	
	}
	
	private UserDTO usersToDTO(Users users) {
			
		UserDTO userDTO = new UserDTO();
	
			userDTO.setName(users.getName());
			userDTO.setPassword(users.getPassword());
			userDTO.setEmail(users.getEmail());
			userDTO.setAbout(users.getAbout());
			
			return userDTO;
		
	}
	

}
