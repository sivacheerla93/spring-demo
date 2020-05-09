package ioc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CatalogScope implements CommandLineRunner {
	@Autowired
	@Qualifier("java")
	private Books javaBooks;

	@Autowired
	@Qualifier("spring")
	private Books springBooks;

	public CatalogScope() {
		System.out.println("CatalogScope()");
		System.out.println(javaBooks);
		System.out.println(springBooks);
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("PostConstruct() in CatalogScope");
		System.out.println(javaBooks);
		System.out.println(springBooks);
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("PreDestory() in CatalogScope");
	}

	@Override
	public void run(String... args) throws Exception {
		for (String b : javaBooks.getBooks())
			System.out.println(b);
	}
}