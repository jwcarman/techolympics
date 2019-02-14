# Persisting Data With Spring Data JPA

### Create the Entity

1. Open the ```Registration``` class.

2. Add an ```@Entity``` annotation to the class.

3. Add an ```@Id``` annotation to the appropriate field.

    - What field should be the identifier?
    
### Create the Repository

1. Open the ```RegistrationRepository```interface.

2. Using Spring Data, modify ```RegistrationRepository``` so that it supports simple create, retrieve, update, and delete (CRUD)

    - How do we register an instance with Spring?
        
### Use the Repository

1. Convert the ```RegistrationService``` to use the ```RegistrationRepository``` rather than using the in-memory map we have been using thus far.

    - The ```Lists``` from the Google Guava library which might be useful.

### Creating a Custom Finder (Optional)

1. Add a new method to the ```RegistrationRepository``` which allows you to find a ```List<Registration>``` by school name.

2. Add a new method to the ```RegistrationService``` which uses this new method.

2. Add a new endpoint to the ```RegistrationsController``` which allows you to retrieve registrations by school name. 