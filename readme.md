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
Please note that you have to install node and gradle for testing in development mode.

### Unit Testing
For testing you can run unit test with command `gradle test`.

## How to Use
### Development Mode
If you want to run the application in development mode first you need to go into `src/main/resources/client` directory. Then run `npm install`. This will install frontend dependencies from npm.

After that you can run `npm run client:development` command. This will initialize the webpack dev server. This server will proxy all requests to your backend. So you have to run your backend too. In order to do that go to project root directory and in a new terminal session and run `gradle bootRun`.

Now goto browser and visit `http://localhost:8088`. Then you can start to use app from UI.

### Production Mode
Again if you do not install npm dependencies or do not want to install node, i put all resources to the repository which are builded with `npm run build`. This command will build the frontend sources and put them into static folder. So for quick testing you have these resources so go to your project root and run `gradle bootRun`. It is enough to run your backend only in prod mode. Then visit `http://localhost:8080`.

# Thanks.