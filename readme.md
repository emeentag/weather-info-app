# About Project
This project contains a weather app. You can query any weather app and can see the results. Results are getting from `http://openweathermap.org/` api. You can use your own api. In order to use it, it is enough to update API key in the `application.properties` file. 

## Technology Used
* Java 8
* Springboot(Backend)
* JPA(ORM)
* JUnit(Testing)
* H2(In memory DB)
* Gradle(Build)
* React(Frontend)
* NodeJs
* BabelJs
* Webpack

## How to Test
Please note that you have to install node and gradle for testing.

### Unit Testing
For testing you can run unit test with command `gradle test`.

## How to Use
If you want to run the application in development mode first you need to go into `src/main/resources/client` directory. Then run `npm install`. This will install frontend dependencies from npm.

After that you can run `npm run client:development` command. This will initialize the webpack dev server. This server will proxy all requests to your backend. So you have to run your backend too. In order to do that go to project root directory and in a new terminal session and run `gradle bootRun`.

Now goto browser and visit `http://localhost:8088`. Then you can start to use app from UI.

# Thanks.