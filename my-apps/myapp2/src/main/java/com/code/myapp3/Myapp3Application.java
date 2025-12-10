package com.code.myapp3;

import com.code.myapp3.dao.UserDao;
import com.code.myapp3.entity.UserDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Myapp3Application {

	public static void main(String[] args) {
		SpringApplication.run(Myapp3Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDao userDao) {
		return runner -> {
			//createUserDetail(userDao);
			createMultipleUserDetails(userDao);
			//readUserDetail(userDao);
			//queryForUserDetails(userDao);
			//updateUserDetail(userDao);
		};
	}

	private void updateUserDetail(UserDao userDao) {

		int theId = 4;

		System.out.println(theId);

		UserDetail myUserDetail = userDao.findById(theId);

		myUserDetail.setFirstname("mary");

		userDao.update(myUserDetail);

		System.out.println(myUserDetail);
	}

	private void queryForUserDetails(UserDao userDao) {

		List<UserDetail> theUserDetails = userDao.findAll();

		for (UserDetail tempUserDetail : theUserDetails) {
			System.out.println(tempUserDetail);
		}
	}

	private void readUserDetail(UserDao userDao) {

		System.out.println("Creating new user detail . . .");
		UserDetail tempUserDetail = new UserDetail("monday112", "monday", "sunday", "10 zoo estate", "monday@gmail.com");

		System.out.println("Saving the user detail . . .");
		userDao.save(tempUserDetail);

		int theId = tempUserDetail.getUser_id();
		String username = tempUserDetail.getUsername();
		System.out.println("Save user detail and id. Generate username: " + theId + "  " + username);

		System.out.println("Retrieving user detail with id and username: " + theId + "  " + username);
		UserDetail myUserDetail = userDao.findById(theId);

		System.out.println("Found the user detail: " + myUserDetail);

	}

	private void createMultipleUserDetails(UserDao userDao) {

		System.out.println("Creating 3 user details object . . .");
		UserDetail tempUserDetail1 = new UserDetail("kate122", "kate", "solomon", "number 30 quarters", "kate@gmail.com");
		UserDetail tempUserDetail2 = new UserDetail("john134", "john", "doe", "number 80 quarters", "john@gmail.com");
		UserDetail tempUserDetail3 = new UserDetail("mary442", "mary", "bonita", "number 5 quarters", "mary@gmail.com");

		System.out.println("Saving the user details . . .");
		userDao.save(tempUserDetail1);
		userDao.save(tempUserDetail2);
		userDao.save(tempUserDetail3);


	}

	private void createUserDetail(UserDao userDao) {
		System.out.println("Creating new user detail object . . .");
		UserDetail tempUserDetail = new UserDetail("paul124", "paul", "saul", "number 24 estate", "paul@gmail.com");

		System.out.println("Saving the user detail . . .");
		userDao.save(tempUserDetail);

		System.out.println("Save user detail. Generate username: " + tempUserDetail.getUsername());
	}

}

	//userDetailMap.put("pauling", new UserDetail("paul124", "paul", "saul", "number 24 estate", "paul@gmail.com"));
	//userDetailMap.put("katering", new UserDetail("kate122", "kate", "solomon", "number 30 quarters", "kate@gmail.com"));