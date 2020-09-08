package io.github.joxebus

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {

    void "Validate person with valid info"() {
        given: 'A person with valid data'

        when: 'Validate'

        then: 'The person should be valid'
    }

    void "Validate person with invalid info"() {
        given: 'A person with invalid data'

        when: 'Validate'

        then: 'The person should be invalid'
    }
}
