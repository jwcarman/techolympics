# Validating Data With the Bean Validation API (JSR-380)

### Validate Registrations

1. Add a ```@Validated``` annotation to the ```RegistrationService``` interface.

2. Add ```@NotNull``` and ```@Valid``` annotations to the ```Registration``` parameter of the ```registerStudent()``` method in the ```RegistrationService``` interface.

3. Add an ```@Email``` annotation to the ```email``` field in the ```Registration``` class.
    
4. Add ```@NotEmpty``` constraints to the rest of the fields in the ```Registration``` class.

5. In your browser, try to register a student with a invalid data.
       
    - What happens?
   

### Validate Email Parameters

1. Add an ```@Email``` annotation to the ```email``` parameter of the ```getStudentRegistration()``` and ```unregisterStudent()``` methods in the ```RegistrationService``` interface.

2. In your browser, try to pass an invalid email address to either of these methods.

    - What happens?

### Handle ConstraintViolationExceptions

1. Add the following method to the ```ErrorHandlerAdvice``` class:

    ```java
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> onConstraintViolation(ConstraintViolationException e) {
        return e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }
    ```

2. In your browser, perform an operation that violates a validation constraint.

    - What happens now?
           
### Custom Error Messages

1. Modify the ```@Email``` constraint on the ```email``` field in the ```Registration``` class:

    ```java
    @Email(message = "{registration.email.invalid}")
    ```
2. Add the following line to the ```ValidationMessages.properties``` file:

    ```properties
    registration.email.invalid=Registration email value "${validatedValue}" is invalid.
    ```

2. Try to register a student with an invalid email address.

    - Do you see your custom message?