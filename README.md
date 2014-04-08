Service Registry for integration platforms
================================================

[![Build Status](https://travis-ci.org/denschu/service-registry.png?branch=master)](https://travis-ci.org/denschu/service-registry)

# Installation

	cd service-registry
	mvn clean install

# Run

	java -Dserver.port=8080 -jar target/*.jar --spring.profiles.active=security
	
# GUI

Open this URL in the browser
	
	http://localhost:8080/
	
# REST-API

	curl http://localhost:8080/api/services/service1/versions/1.0.0 -u user:password
	
# RPM 

## Creation

	mvn rpm:rpm

## Environment configuration file

	/etc/service-registry/environment.properties
	
# Features

* REST-API to lookup services
* Activate/Deactivate endpoint with optional message and HTTP-Status 401
* Basic-Authentification
* Mule Connector for Service Lookup
* Oracle-DB as backend