# Writing a @RestController

### Register a Student

1. Add a new ```registerStudent()``` method to the ```RegistrationsController``` class:
    - It should match ```PUT /registrations/{email}``` requests.
    - It should return an HTTP ```204 No Content``` status on success.
    - The registration data should be obtained from the body of the request.
    - Does the body need to contain the email address?
    - Why did we use ```PUT``` to create a new object? I thought that was only for updates.
    
### Get a Registration

1. Add a new ```getRegistration()``` method to the ```RegistrationController``` class:
    - It should match ```GET /registrations/{email}``` requests.
    - The response should contain the registration data for the specified email address.
    
### Unregistering a Student

1. Add a new ```unregisterStudent``` method to the ```RegistrationsController``` class:
    - It should match ```DELETE /registrations/{email}``` requests.
    - It should return an HTTP ```204 No Content``` status on success.
    - Does it need a request body?
    - What should happen if it is called more than once? 
    
### Error Handling (Optional)

1. Open the ```ErrorHandlerAdvice``` class.
2. Change the ```onRegistrationNotFound()``` method to return an HTTP ```404 Not Found``` status.
3. Verify your work using Swagger.  