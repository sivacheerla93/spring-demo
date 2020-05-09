package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Catalog implements CommandLineRunner {
	@Autowired
	private Books books;

	@Autowired
	private Books books2;

	public Catalog() {
		System.out.println("Catalog()");
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Scope: " + books);
		System.out.println("Scope: " + books2);

		for (String b : books.getBooks())
			System.out.println(b);
	}
}