package dev.wdrap.restclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class RestclientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestclientAppApplication.class, args);
	}

	@Bean
	RestClient restClient(RestClient.Builder builder) {
		return builder
				.baseUrl("https://jsonplaceholder.typicode.com")
				.build();
	}

	@Bean
	ApplicationRunner applicationRunner(RestClient restClient) {
		return args -> {
			var todo = restClient.get()
					.uri("/todos/{id}", "a")
					.retrieve()
					.onStatus(HttpStatusCode::is4xxClientError,  (request, response) -> {
						throw new RuntimeException(response.getStatusCode() + " " + response.getStatusText()); 
					})
					.toEntity(Todo.class);
		
					// .body(Todo.class);
			// .subscribe(System.out::println);

			System.out.println(todo);
		};
	}

	public record Todo(
			long id,
			long userId,
			String title,
			boolean completed) {

	}


}
