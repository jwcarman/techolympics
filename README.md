# Writing a @RestController

### Register a Student

1. Add a new ```registerStudent()``` method to the ```RegistrationsController``` class:

    ```java
    @PutMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void registerStudent(@PathVariable("email") String email, @RequestBody RegisterStudentRequest request) {
    
        final Registration registration = new Registration();
        registration.setEmail(email);
        registration.setFirstName(request.getFirstName());
        registration.setLastName(request.getLastName());
        registration.setSchool(request.getSchool());
    
        registrationService.registerStudent(registration);
    }
    ```
    
2. In your browser, try out this new endpoint.
 
    - Can you register new students?
      
    - What happens if you execute the same request twice?  
    
### Get a Registration

1. Add a new ```getRegistration()``` method to the ```RegistrationController``` class:

    ```java
    @GetMapping("/{email}")
    public Registration getRegistration(@PathVariable("email") String email) {
        return registrationService.getStudentRegistration(email);
    }
    ```
2. In your browser, try out this new endpoint.
 
    - Are you able to retrieve registrations?
    
    - What happens if you enter an email address that doesn't exist?

### Unregistering a Student

1. Add a new ```unregisterStudent()``` method to the ```RegistrationsController``` class:

    ```java
    @DeleteMapping("/{email}")
    public void unregisterStudent(@PathVariable("email") String email) {
        registrationService.unregisterStudent(email);
    }
    ```
    
2. In your browser, try out this new endpoint.
  
    - Are you able to unregister a student?
    
    - What happens if you execute the same request twice? 
    
### Exception Handling

1. Add the following method to the ```ErrorHandlerAdvice``` class:

    ```java
    @ExceptionHandler(RegistrationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String onRegistrationNotFound(RegistrationNotFoundException e) {
        return e.getMessage();
    }
    ```
    
2. In your browser, try to get a registration using an email address that doesn't exist.
    - What changed?