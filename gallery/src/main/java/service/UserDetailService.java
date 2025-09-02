package service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import entity.CustomUser;
import enums.ErrorType;
import exception.BaseException;
import exception.ErrorMessage;
import repository.CustomUserRepository;
@Service
public class UserDetailService implements UserDetailsService {
	CustomUserRepository customUserRepository;

	public UserDetailService(CustomUserRepository customUserRepository) {
		super();
		this.customUserRepository = customUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<CustomUser> byUserName = customUserRepository.findByUserName(username);

		if (byUserName.isPresent())
			return byUserName.get();
		
		
		throw new BaseException(new ErrorMessage(ErrorType.USERNAME_NOT_FOUND, username));
	}

}
