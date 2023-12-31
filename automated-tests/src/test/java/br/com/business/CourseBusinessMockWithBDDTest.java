package br.com.business;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import br.com.service.CourseService;

class CourseBusinessMockWithBDDTest {

	CourseService mockService;
	CourseBusiness business;
	List<String> courses;
	
	@BeforeEach
	void setup() {
		// Given / Arrange
		mockService = mock(CourseService.class);
		business = new CourseBusiness(mockService);
		
		courses = Arrays.asList(
	        "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
	        "Agile Desmistificado com Scrum, XP, Kanban e Trello",
	        "Spotify Engineering Culture Desmistificado",
	        "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
	        "Docker do Zero à Maestria - Contêinerização Desmistificada",
	        "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
	        "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
	        "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
	        "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
	        "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
	        "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
	    );
	}
	
	@Test
	void testCoursesRelatedToSpring_When_usingAStub() {
		// Given / Arrange
		given(mockService.retrieveCourse("Leandro")).willReturn(courses);
		
		// When / Act
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");
		
		// Then / Assert
		assertThat(filteredCourses.size(), is(4));
	}
	
	@Test
	@DisplayName("Delete courses not releted to spring using mockito sould call method")
	void testDeleteCoursesNotReletedToSpring_Using_mockito_verified() {
		// Given / Arrange
		given(mockService.retrieveCourse("Leandro")).willReturn(courses);
		// When / Act
		business.deleteCoursesNotRelatedToSpring("Leandro");
		
		// Then / Assert
		verify(mockService, times(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		verify(mockService, never()).deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");
	}
	
	@Test
	@DisplayName("Delete courses not releted to spring using arguments captors sould call method V2")
	void testDeleteCoursesNotReletedToSpring_Using_mockito_verifiedV2() {
		// Given / Arrange
		courses = Arrays.asList(
		        "Agile Desmistificado com Scrum, XP, Kanban e Trello",
		        "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker"
		);
		
		given(mockService.retrieveCourse("Leandro")).willReturn(courses);

		ArgumentCaptor<String> argumentsCaptor = ArgumentCaptor.forClass(String.class);
		
		String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

		// When / Act
		business.deleteCoursesNotRelatedToSpring("Leandro");
		
		// Then / Assert
		
		then(mockService).should().deleteCourse(argumentsCaptor.capture());
		assertThat(argumentsCaptor.getValue(), is(agileCourse));
	}

}
