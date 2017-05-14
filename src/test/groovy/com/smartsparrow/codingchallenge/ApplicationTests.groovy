package com.smartsparrow.codingchallenge

import com.smartsparrow.codingchallenge.resolution.TimeConfusion
import spock.lang.Specification


class ApplicationTests extends Specification {

    Application application

    def setup() {
        application = new Application()
    }

    def "Should throw InterruptedException when EXIT in upper is issued"() {
        when:
        application.execute("EXIT")

        then:
        thrown InterruptedException
    }

    def "Should throw InterruptedException when exit in upper is issued"() {
        when:
        application.execute("exit")

        then:
        thrown InterruptedException
    }

    def "Should throw IllegalArgumentException when nothing entered"() {
        when:
        application.execute(" ")

        then:
        thrown IllegalArgumentException
    }
}
