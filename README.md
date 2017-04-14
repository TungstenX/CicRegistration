
[![Build Status](https://travis-ci.org/TungstenX/CicRegistration.svg?branch=master)](https://travis-ci.org/TungstenX/CicRegistration)

Find me on [stackoverflow](http://stackoverflow.com/users/537566/tungstenx)

# CicRegistration
Proof of skills for 8 BIT PLATOON

# Introduction
This is a web service to demonstrate my skills as a back-end developer

The specific technologies involved are:
- Git (ver 2.7.4.)
- Apache Maven (ver 3.9.9. - not the sucky one shipped with Netbeans &#245;.&#212;)
- Java Persistence API (JPA)
- JBoss / WildFly Application Server (ver 10.1.0 - Final)
- EJB Session Beans
- JAX-WS
- Passion with a sprinkling of unicorn horn

# Development
I use my trusty Netbeans 8.2 on Ubuntu 16.04. I developed the solution against Wildfly 10.1.0. 

## Assumptions
(Actaully only one)
- Only one email per email address will be loaded, e.g. one invoice for a specific person. Thus no bulk emails to be loaded.

## Time allocation
The following is my time allocated to this procject:
- 10 minutes: Download and install Wildfly 10.1.0 on Ubuntu 16.04 (64 bit) 
- 2.5 hours: Coding the solution
- 1 hour: Fighting with Netbeans, Wildfly and H2 to get solution to run - [Machine 0 : Rage Against 3]
- 10 minutes: Download and install Ready! API 1.9.0 (Yip, you guess it, on Ubuntu 16.04 (64 bit))
- 1 minute: Test web services
- 2.5 hours: Fighting JUnit to run in a test conainer - [Machine 1 : Rage Against 0] (Left my futile efforts in the files as comments)
- 30 mintues: Packaging and prettying up everything

# WSDL
After deploying the wsdl can be found at http://localhost:8080/CicRegistration-0.0.0/CicRegistrationEngine/CicRegistrationEngine?wsdl

(Port depending on your Wildfly set up)

## Thanks
It is an honour to have build this demonstration for you to evaluate

### Powered by
This README.md was made using VIM

[![Andr&#233; Labuschagn&#233](http://gravatar.com/avatar/88ebc726d33c8ddba2534d1d6f93e638?s=144)](https://www.ParanoidAndroid.co.za) 
