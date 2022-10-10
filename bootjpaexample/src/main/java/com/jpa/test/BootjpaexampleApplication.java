package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepositary = context.getBean(UserRepository.class);

		// save single data

		/*
		 * User user = new User(); user.setUserName("vikash"); user.setCity("Ranchi");
		 * user.setStatus("i am programmer"); User save = userRepositary.save(user);
		 * System.out.println(save);
		 */
		// save multiple data

		/*
		 * User user1 = new User(); user1.setUserName("Vivek"); user1.setCity("Delhi");
		 * user1.setStatus(".net Programmer");
		 * 
		 * User user2 = new User(); user2.setUserName("deepak");
		 * user2.setCity("Banglore"); user2.setStatus("java Programmer");
		 * 
		 * User user3 = new User(); user3.setUserName("Tuna");
		 * user3.setCity("Banglore"); user3.setStatus("VXI Programmer");
		 * 
		 * List<User> userlist = List.of(user1, user2, user3); Iterable<User> saveAll =
		 * userRepositary.saveAll(userlist); saveAll.forEach(test -> {
		 * System.out.println(test); }); System.out.println("done");
		 */

		// update data

		/*
		 * Optional<User> optional = userRepositary.findById(4); User user =
		 * optional.get(); System.out.println("Before updating: " + user);
		 * 
		 * user.setUserName("chhotu"); User save = userRepositary.save(user);
		 * System.out.println("After updating: " + save); System.out.println("Done");
		 */
		// find all data

		/*
		 * Iterable<User> findAll = userRepositary.findAll(); int counter = 0; for
		 * (Object i : findAll) { counter++; } if (counter == 0.) {
		 * System.out.println("No Data"); } else { findAll.forEach(user -> {
		 * System.out.println(user); }); }
		 */

		// delete element
		/*
		 * userRepositary.deleteById(7); System.out.println("Deleated!!");
		 */

		// delete all element
		/*
		 * Iterable<User> findAll = userRepositary.findAll(); findAll.forEach(user -> {
		 * System.out.println(user); }); userRepositary.deleteAll(findAll);
		 * System.out.println("done!, deleated all");
		 * 
		 * Iterable<User> all = userRepositary.findAll(); all.forEach(userAll -> {
		 * System.out.println(userAll); }); System.out.println("done!!");
		 */

		// customized Finder Method

		/*
		 * List<User> findName = userRepositary.findByuserName("vivek");
		 * findName.forEach(e -> System.out.println(e));
		 */
		/*
		 * List<User> findByuserNameAndCity =
		 * userRepositary.findByuserNameAndCity("vikash", "Ranchi");
		 * findByuserNameAndCity.forEach(e -> System.out.println(e));
		 */

		/*
		 * List<User> allUser = userRepositary.getAllUser(); allUser.forEach(e->{
		 * System.out.println(e); });
		 */

		/*
		 * List<User> userByuserName = userRepositary.getUserByuserName("vikash",
		 * "Ranchi"); userByuserName.forEach(e -> { System.out.println(e); });
		 */
		
		List<User> userNativeQuery = userRepositary.getUserNativeQuery();
		userNativeQuery.forEach(e->System.out.println(e));

	}
}
