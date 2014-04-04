Service Registry for integration platforms
================================================

[![Build Status](https://travis-ci.org/denschu/service-registry.png?branch=master)](https://travis-ci.org/denschu/service-registry)

# Installation

	cd service-registry
	mvn clean install

# Run

	java -Dserver.port=8080 -jar target/*.jar
	
# Features

* REST-API to lookup services
* Activate/Deactivate endpoint with optional message and HTTP-Status 401
* Basic-Authentification
* Mule Connector for Service Lookup

* Throttling
* Oracle-DB as backend