# Validating Data With the Bean Validation (JSR-380)

### Validate Registrations

1. Open the ```Registration``` class.

2. Add validation constraints to the fields.
    - Is it okay for the ```lastName``` to be null?
    - Is it okay for the ```lastName``` to be empty?
   
3. Open the ```RegistrationService``` interface.

4. Modify the ```registerStudent``` method to ensure that the ```Registration``` objects are valid.

5. Test it out using Swagger

    - What HTTP status did you receive when your request was invalid?

### Handle ConstraintViolationExceptions

1. Open the ```ErrorHandlerAdvice```class.

2. Add a method to handle the ```ConstraintViolationException``` exception type.

    - What HTTP status should be returned?
        
### Validate Emails

1. Modify the ```getStudentRegistration()``` and ```unregisterStudent()``` methods to validate that the ```email``` parameter passed in is a valid email address.
   
### Custom Error Messages

1. The ```ValidationMessages.properties``` file already contains some custom error messages.  Modify your annotations to use them.