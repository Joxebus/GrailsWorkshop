package io.github.joxebus

class Person {

    String name
    String lastName
    int age
    String email
    String phone

    static constraints = {
        name maxSize: 30
        lastName maxSize: 30
        age min:18, max:87
        email email:true
        phone matches: /(\d{3})-(\d{3})-(\d{4})/
    }
}
