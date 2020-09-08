package io.github.joxebus

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class HelloControllerSpec extends Specification implements ControllerUnitTest<HelloController> {

    void "Test controller returns hello sample"() {
        when:
        controller.index()

        then:
        response.text == "Hello from Grails 4"
    }
}
