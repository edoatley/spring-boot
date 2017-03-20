// refresh code on AWS and rebuild and deploy
git pull origin master && ./gradlew clean build && java -jar build/libs/messaging-and-rest-0.1.0.jar