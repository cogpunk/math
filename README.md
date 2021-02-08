# Cogpunk Math

Cogpunk Math is a set of mathematical utilities for general use

[![Build Status](https://travis-ci.com/cogpunk/math.svg?branch=main)](https://travis-ci.com/cogpunk/math)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=cogpunk_math&metric=alert_status)](https://sonarcloud.io/dashboard?id=cogpunk_math)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=cogpunk_math&metric=coverage)](https://sonarcloud.io/dashboard?id=cogpunk_math)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=cogpunk_math&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=cogpunk_math)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=cogpunk_math&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=cogpunk_math)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=cogpunk_math&metric=security_rating)](https://sonarcloud.io/dashboard?id=cogpunk_math)
[![Apache License, Version 2.0](https://img.shields.io/github/license/cogpunk/math)](https://opensource.org/licenses/Apache-2.0)
[![Cogpunk Math](https://maven-badges.herokuapp.com/maven-central/com.cogpunk/cogpunk-math/badge.svg)](https://search.maven.org/artifact/com.cogpunk/cogpunk-math/)

## Building from source

The build requires a Java 6 JDK (or higher) and uses [Maven](https://maven.apache.org)
```bash
mvn install
```
## Adding as a dependency
```xml
<dependency>
	<groupId>com.cogpunk</groupId>
	<artifactId>cogpunk-math</artifactId>
	<version>1.0.3</version>
</dependency>
```
## License

Code is under the [Apache Licence v2](https://www.apache.org/licenses/LICENSE-2.0.txt).

## Example

Determine the probability profile of adding 3 six-sided dice together
```java
// Create a profile for a 6-sided dice

Fraction prob = new Fraction(1, 6);

Map<Integer, Fraction> map = new TreeMap<Integer, Fraction>();

for (int n = 1; n <= 6; n++) {
	map.put(n, prob);
}

ComparableEventProbabilityProfileImpl<Integer, Fraction> dice 
	= new ComparableEventProbabilityProfileImpl<Integer, Fraction>(
		map, new FractionOperator());

// Determine the probabilities of all possible results of adding the dice values together 
// using the EventProbabilityProfileAdditionAggregationStrategy

EventProbabilityProfileAggregator<Integer, Integer, Fraction> aggregator 
	= new EventProbabilityProfileAggregator<Integer, Integer, Fraction>(
		new EventProbabilityProfileAdditionAggregationStrategy<Integer>(
			new IntegerOperator()), new FractionOperator(), dice, dice, dice);

// Print out the results to the console

System.out.println(aggregator);
```	
	

