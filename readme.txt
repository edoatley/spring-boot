// refresh code on AWS and rebuild and deploy
git pull origin master && ./gradlew clean build && java -jar build/libs/messaging-and-rest-0.1.0.jar

// POST example
curl -X POST -H 'Content-Type: application/json' -d '{"date": "2017-03-20", "payee": "Alison", "amount": 342.00}'  localhost:8080/payments