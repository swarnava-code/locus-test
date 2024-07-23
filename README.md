# locus-test

# Web Automation - Flipkart
- Search
- Apply Filters
- Product Detail Page

## To run all web tests
- Run [FlipkartTestRunner.java](src/test/java/sh/locus/test/web/FlipkartTestRunner.java)

# API Automation
- [Get books data](src/test/java/sh/locus/test/api/BookApiTest.java)
- [Negative case for getting movies](src/test/java/sh/locus/test/api/MovieApiNegativeTest.java)
- [Positive case for getting movies](src/test/java/sh/locus/test/api/MovieApiPositiveTest.java)
- [Two-step-case](src/test/java/sh/locus/test/api/MovieApiTwoStepCaseTest.java)

## To run all api tests
- Run [testng.xml](src/test/resources/testng.xml)

## Setup credentials
[api.properties](/Users/swarnavachakraborty/Downloads/Flipkart Web Automation/src/test/resources/api.properties)
```properties
token=your-api-key-123
```
