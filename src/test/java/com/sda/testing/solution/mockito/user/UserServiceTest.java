package com.sda.testing.solution.mockito.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserValidator userValidator;

	@InjectMocks
	private UserService userService;


	@Test
	void shouldReturnProperUser() {
		User savedUser = new User(4L, "Tomek", "Woźniak");
		when(userRepository.findById(savedUser.getId())).thenReturn(Optional.of(savedUser));

		User user = userService.getUserById(4L);

		assertEquals(savedUser, user);
	}

	@Test
	void shouldThrowExceptionWhenUserNotExists() {
		Long notExistingId = 878L;
		when(userRepository.findById(notExistingId)).thenReturn(Optional.empty());
		assertThrows(Exception.class, () -> userService.getUserById(notExistingId));
	}
}