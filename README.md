# Persisting Data With JPA

### Create the Entity

1. Open the ```Registration``` class.

2. Add an ```@Entity``` annotation to the class.

3. Add the appropriate ```@Id``` annotation

    - What property should be our identifier?
    
### Create the Repository

1. Create a ```RegistrationRepository```interface that supports entity type ```Registration``` with identifier type ```String```.

    - How do we register this with Spring?
        
### Using the Repository

1. Convert the ```RegistrationService``` to use the ```RegistrationRepository``` rather than using the in-memory map we have been using thus far.