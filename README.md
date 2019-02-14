# Spring Core

### Dependency Injection

1. Find the ```RegistrationsControllerTest``` class found in the ```src/test/java``` directory.

2. Right click on the class and select ```Run RegistrationsControllerTest```.
    - The test should fail, but why did it fail?
   
3. Find the ```RegistrationsController``` class in the ```src/main/java``` directory.

4. Refactor the ```getRegistrations()``` method to delegate to a ```RegistrationService``` object's ```getAllRegistrations()``` method.
    - How will the ```RegistrationsController``` object obtain a reference to a ```RegistrationService``` object?
    
5. Run the ```RegistrationsControllerTest``` again and make sure the test is "green."

### Declaring a Spring Bean

1. Find the ```TecholympicsApplicationTest``` class found in the ```src/test/java/``` directory.

2. Right click on the class and select ```Run TecholympicsApplicationTest```.

3. The test should fail with a message similar to the following:

    ```text
    ***************************
    APPLICATION FAILED TO START
    ***************************
    
    Description:
    
    Parameter 0 of constructor in org.techolympics.web.RegistrationsController required a bean of type 'org.techolympics.domain.service.RegistrationService' that could not be found.
    
    
    Action:
    
    Consider defining a bean of type 'org.techolympics.domain.service.RegistrationService' in your configuration.
    ```
    
4. Follow the instructions in the error message to fix the issue and make sure the test is "green."
    - How do we define a new "bean"?
    - What (stereo) type of bean is it?
    - _Hint: there's already a ```RegistrationServiceImpl``` class available which implements ```RegistrationService```._
    
### Get Your Swagger On!

1. Find the ```TecholympicsApplication``` class found in the ```src/main/java``` directory.
2. Right click on the class and select ```Run TechnolymipcsApplication```.
3. Open up the following URL in your browser:

    http://localhost:8080/swagger-ui.html
4. Locate the ```/registrations``` endpoint and "Try it out"

### Registering Some Students (Optional)
 
1. Find the ```TecholympicsConfiguration``` class in the ```src/main/java``` directory.
2. The ```CommandLineRunner``` will be called on application startup, so let's use this to register some students
3. Use the injected ```RegistrationService``` object to register some students.
4. Open up Swagger again and see the students you registered.