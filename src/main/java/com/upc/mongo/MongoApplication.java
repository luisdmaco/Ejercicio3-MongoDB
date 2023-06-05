package com.upc.mongo;

import com.upc.mongo.model.Address;
import com.upc.mongo.model.Students;
import com.upc.mongo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

	@Autowired
	ItemRepository studentsItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

	//METHOD: Create student
	void createItems() {
		System.out.println("Creating items - Students");
		studentsItemRepository.save(new Students("Nicolas Haro", 2020,
				new Address("Av. Tomas Marsano 2645", "Lima"),
				List.of("SI729")));
	}

	//METHOD: Read students
	void showAllItems(int year) {
		System.out.println("Reading items - Students");
		List<Students> students = studentsItemRepository.findAllBy(year);
		students.forEach(System.out::println);
	}

	//METHOD: Update students
	//METHOD: Delete students
	public void deleteItem(String id) {
		System.out.println("Deleting item - Students");
		studentsItemRepository.deleteById(id);
		System.out.println("Item deleted");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running MongoApplication");
		createItems();
		showAllItems(2020);
	}
}
