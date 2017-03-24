// refresh code on AWS and rebuild and deploy
git pull origin master && ./gradlew clean build && java -jar build/libs/messaging-and-rest-0.1.0.jar

// POST example
curl -X POST -H 'Content-Type: application/json' -d '{"date": "2017-03-20", "payee": "Alison", "amount": 342.00}'  localhost:8080/payments

curl -X POST -H 'Content-Type: application/json' -d @/home/ec2-user/projects/gradle/spring/messaging-and-rest/src/test/resources/payments-small.json localhost:8080/asyncAddPayments

// rename a directory 
find . -name '*-GHBAG-*' -exec bash -c 'mv $0 ${0/GHBAG/stream-agg}' {} \;