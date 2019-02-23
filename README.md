# Spring Core

1. Add the following field to the ```RegistrationsController``` class:

    ```java
    private final RegistrationService registrationService;
    ```
    
2. Since this field is final, we need to add a constructor which initializes this field:

    ```java
    public RegistrationsController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    ```

3. Refactor the ```getRegistrations()``` method to delegate to the injected ```RegistrationService```:

    ```java
    @GetMapping
    public List<Registration> getRegistrations() {
        return registrationService.getAllRegistrations();
    }
    ```
    
4. Right click the ```TecholympicsApplication``` class and select "Run TecholympicsApplication". The application should fail to start with the following message:

    ```text
    ***************************
    APPLICATION FAILED TO START
    ***************************
    
    Description:
    
    Parameter 0 of constructor in org.techolympics.web.RegistrationsController required a bean of type 'org.techolympics.domain.service.RegistrationService' that could not be found.
    
    
    Action:
    
    Consider defining a bean of type 'org.techolympics.domain.service.RegistrationService' in your configuration.
    ```

5. Spring doesn't have any beans of type ```RegistrationService```. Add the ```@Service``` stereotype annotation to the ```RegistrationServiceImpl``` class. 

6. Now, right click the ```TecholympicsApplication``` class and select "Run TecholympicsApplication" again.  The application should start successfully.
 
7. Open up the following URL in your browser:

    http://localhost:8080/swagger-ui.html
 
8. Locate the ```/registrations``` endpoint and "Try it out"
    
9. Currently, there are no registered students.  Modify the ```TecholympicsConfiguration``` class by adding the following method:

    ```java
    @Bean
    public CommandLineRunner dataLoader(RegistrationService service) {
        return args -> {
            final Registration johnDoe = new Registration();
            johnDoe.setEmail("john@doe.com");
            johnDoe.setFirstName("Joe");
            johnDoe.setLastName("Doe");
            johnDoe.setSchool("Mason");
    
            service.registerStudent(johnDoe);
    
            final Registration janeDoe = new Registration();
            janeDoe.setEmail("jane@doe.com");
            janeDoe.setFirstName("Jane");
            janeDoe.setLastName("Doe");
            janeDoe.setSchool("Sycamore");
    
            service.registerStudent(janeDoe);
        };
    }
    ```
10. Build the project (Ctrl-F9).  The Spring Boot Devtools should reload your application.

11. Go back to your browser and try the ```/registrations``` endpoint again.  You should see some student data!  