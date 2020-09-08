## GrailsWorkshop Project

This project it's aimed for those people that wants to learn how to create an app with Grails 4.x

It will be divided on different branches to learn about different things

If you are using IntelliJIDEa open the project and select the options:

- Use auto-import
- Create directories for empty content roots automatically
- Create separate module per source set

and finally

- Use default gradle wrapper

### Technologies

- Grails 4.0.4
- Gradle 5.6.4

### Structure of the project

```
.
├── README.md
├── build.gradle
├── grails-wrapper.jar
├── gradle.properties
├── gradlew
├── gradlew.bat
├── grailsw
├── grailsw.bat
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── grails-app
│   ├── assets
│   │   ├── images
│   │   ├── javascripts
│   │   └── stylesheets
│   ├── conf
│   │   ├── application.yml
│   │   ├── logback.groovy
│   │   └── spring
│   │       └── resources.groovy
│   ├── controllers
│   │   └── grailsworkshop
│   │       └── UrlMappings.groovy
│   ├── domain
│   ├── i18n
│   ├── init
│   │   └── grailsworkshop
│   │       ├── Application.groovy
│   │       └── BootStrap.groovy
│   ├── services
│   ├── taglib
│   ├── utils
│   └── views
│       ├── error.gsp
│       ├── index.gsp
│       ├── layouts
│       │   └── main.gsp
│       └── notFound.gsp
└── src
    ├── integration-test
    │   ├── groovy
    │   └── resources
    │       └── GebConfig.groovy
    ├── main
    │   ├── groovy
    │   └── webapp
    └── test
        └── groovy
```
