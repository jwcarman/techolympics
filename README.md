# Persisting Data With Spring Data JPA

### Create the Entity

1. Add an ```@Entity``` annotation to the ```Registration``` class.

2. Add an ```@Id``` annotation to the ```email``` field of the ```Registration``` class.
    
### Create the Repository

1. Modify the ```RegistrationRepository``` interface to make it extend ```CrudRepository```:

    ```java
    public interface RegistrationRepository extends CrudRepository<Registration,String> {
    }
    ```
        
### Use the Repository

1. Modify the ```RegistrationServiceImpl``` class to use the newly-created ```RegistrationRepository```:

    ```java
    @Service
    public class RegistrationServiceImpl implements RegistrationService {
    
        private final RegistrationRepository repository;
    
    
        public RegistrationServiceImpl(RegistrationRepository repository) {
            this.repository = repository;
        }
    
        @Override
        public List<Registration> getAllRegistrations() {
            return Lists.newArrayList(repository.findAll());
        }
    
        @Override
        public Registration getStudentRegistration(String email) {
            return repository.findById(email).orElseThrow(() -> new RegistrationNotFoundException(email));
        }
    
        @Override
        public void registerStudent(Registration registration) {
            repository.save(registration);
        }
    
        @Override
        public void unregisterStudent(String email) {
            if(!repository.existsById(email)) {
                throw new RegistrationNotFoundException(email);
            }
            repository.deleteById(email);
        }
    }
    ```

2. Try registering a new student in the browser. Do they show up in the list of registrations?
    
3. Restart your application and list the registrations again.

    - Is your new student still listed?
    
### Creating a Custom Finder Method

1. Add the following method to the ```RegistrationRepository``` interface:

    ```java
    Iterable<Registration> findBySchool(String school);
    ```

2. Add the following method to the ```RegistrationServiceImpl``` class:

    ```java
    public List<Registration> getRegistrationsBySchool(String school) {
        return Lists.newArrayList(repository.findBySchool(school));
    }
    ```

2. Right click on the new ```getRegistrationsBySchool``` method in ```RegistrationServiceImpl``` and select ```Refactor -> Pull Members Up```.

3. Click ```Refactor```.

4. Add the following method to the ```RegistrationsController``` class:

    ```java
    @GetMapping("/schools/{school}")
    public List<Registration> getRegistrationsBySchool(@PathVariable("school") String school) {
        return registrationService.getRegistrationsBySchool(school);
    }
    ```
    
5. Try our the new endpoint in your browser.
    
    - Are you able to find registrations by school?