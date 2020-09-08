# Creating Domain Classes

A domain class is a GORM entity class, is directly related to a DB Table, 
Grails use convention-over-configuration to create and link the resources.

To create a domain class Grails provide a command named `create-domain-class`
the sample of this branch has a domain class called `Person`, to create the class
you can specify not only then name of the class but the name of the package also.

```
❯ grails create-domain-class io.github.joxebus.Person 
```

Now, we can open the class generated at `domains` folder specifically at 
`grails-app/domain/io/github/joxebus/Person.groovy` and then we can add the properties
or columns.

For my sample I have the following 

```java
class Person {

    String name
    String lastName
    int age
    String email

    static constraints = {
        name maxSize: 30
        lastName size: 30
        age min:18, max:87
        email email:true
    }
}
```

The content of the `constraints` closure it's used to validate the input to be saved.

Grails also provide a mechanism to generate the `Views` and `Controllers` for a specific
`Domain` just need to run the following command  

```
❯ grails generate-all io.github.joxebus.Person
```

This will generate the following sources:

```shell script
| Rendered template Controller.groovy to destination grails-app/controllers/io/github/joxebus/PersonController.groovy
| Rendered template Service.groovy to destination grails-app/services/io/github/joxebus/PersonService.groovy
| Rendered template Spec.groovy to destination src/test/groovy/io/github/joxebus/PersonControllerSpec.groovy
| Rendered template ServiceSpec.groovy to destination src/integration-test/groovy/io/github/joxebus/PersonServiceSpec.groovy
| Scaffolding completed for grails-app/domain/io/github/joxebus/Person.groovy
| Rendered template show.gsp to destination grails-app/views/person/show.gsp
| Rendered template index.gsp to destination grails-app/views/person/index.gsp
| Rendered template create.gsp to destination grails-app/views/person/create.gsp
| Rendered template edit.gsp to destination grails-app/views/person/edit.gsp
| Views generated for grails-app/domain/io/github/joxebus/Person.groovy
```

Those are all the sources generated to `create/edit/delete/list` objects from `Person` also
it already setup the classes to add tests for the components generated.

Now we just need to run the app with `❯ grails dev run`

**Note:** Grails 4.0.4 has a problem and cannot find the Service created, you need to update manually the `gradle.properties` to use the GORM `7.0.7.RELEASE` 