package io.github.joxebus

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PersonServiceSpec extends Specification {

    PersonService personService
    SessionFactory sessionFactory

    def setup() {
        List names = ['Omar', 'Diego', 'Diana', 'Mary', 'Julio']
        List lastNames = ['Bautista', 'Ventura', 'Ramirez', 'Ojeda', 'Chavez']
        List ages = [28,40,19,35,43]
        List phones = ['432-763-8764', '763-763-8754', '456-763-8754', '763-234-8754', '763-763-9351']
        List emails = ['email1@test.com','email2@test.com','email3@test.com','email4@test.com','email5@test.com',]


        names.eachWithIndex { String n, int index ->
            new Person(
                    name: n,
                    lastName: lastNames[index],
                    age: ages[index],
                    phone: phones[index],
                    email: emails[index]

            ).save(flush: true, failOnError: true)
        }
    }

    def cleanup() {
        personService.list()*.delete(flush: true)
    }

    void "test get"() {
        expect:
        personService.get(1) != null
    }

    void "test list"() {

        when:
        List<Person> personList = personService.list(max: 2, offset: 2)

        then:
        personList.size() == 2
    }

    void "test count"() {

        expect:
        personService.count() == 5
    }

    void "test delete"() {
        setup:
        def people = personService.list()
        Long peopleSize = people.size()
        Long personId = people.last().id

        expect:
        personService.count() == peopleSize

        when:
        personService.delete(personId)
        sessionFactory.currentSession.flush()

        then:
        personService.count() == (peopleSize-1)
    }

    void "test save"() {
        when:
        Person person = new Person(
                name: 'Krista',
                lastName: 'Bautista',
                age: 19,
                email: 'krista@email.com',
                phone: '675-763-8734'
        )
        personService.save(person)

        then:
        person.id != null
    }
}
