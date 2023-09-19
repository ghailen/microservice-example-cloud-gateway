# microservice-example-cloud-gateway

Port to use:

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/4998230a-ad39-4847-beb2-4cb205f554bd)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/a601986a-4bd4-446a-be13-3855eca9bad0)


-The limit microservice:

Here we created a microservice limit: 
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/3457f3fc-7458-42db-861b-3051b7f25796)

which connect to a configuration microservice to get the propertie limits-service.minmum and  limits-service.maximum
we created a configuration class to read the two property: the way we used is to pass by @ConfigurationProperties("limits-service") annotation , then put the minimum and maxiumum as attribute in class to access directely to limits-service.minmum and  limits-service.maximum
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/aa381a9a-c14d-441c-967f-a6a16b79a658)
 and we created a contrtoller to read them:
 ![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/16eb3f65-ca58-4e6d-a13c-c1f372c9d32a)

api: http://localhost:8080/limits 
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/f1a67218-e8c6-4d1b-8b70-c619ce4c7ab4)


-The configuration microservice:
we will create the microservice which contains the confguration
we need to add the annotation : @EnableConfigServer
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/d914181f-2cbf-49aa-b1d7-17e136c9c067)

here we putted in the screen shot below: spring.cloud.config.server.git.uri=file:///F:/projectsmicroservice2023/git-localconfig-repo  which is a local repo that contains the properties files.
we need to create it by : 
git init
git add.
git commit -m "first commit"
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/7e8f37a3-382e-4303-960d-572a37810f3d)

now let s use multiple environnement configuration dev,qa,prod,
add file for each environnement:

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/9a9f8a16-73e9-4f81-8ea3-bbd22629791e)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/bfcedf00-8c2d-4753-babf-2bd397773ac1)

check it from configuration service:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/9466460f-db3b-45e5-90ce-d69952a635e5)

api to check with:
http://localhost:8888/limits-service/qa
http://localhost:8888/limits-service/dev
http://localhost:8888/limits-service/default

now lets create two new microservices: 

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/a1edb3e2-934f-4c6f-ba28-0182831f9dc4)


The first one: Currency Exchange Microservice:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/fe3f1fe4-4fdb-43ef-857c-de70e6b7ba9c)

will expose a simple url, conveert from .. to ..

The second one : Currrency conversion microservice
Convert 10 usd to INR for example:

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/674ec6e4-4e91-4706-95d1-837341cde430)



=> the Currency Exchange Microservice will call the Currrency conversion microservice and ask what is the value of USD in INR today for example.


microService Currency Exchange
Lets create the api for the exchange micro services:
localhost:8000/currency-exchange/from/USD/to/INR

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/a2d7f4ed-373e-49f9-9483-56aecaf553c0)

now we need to know which instance will be loading when calling the currency exchange microservice:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/eb85a81e-7a15-4a21-bbce-a39855f27a31)

so we will add to CurrencyExchange class a new field named environnement with it we can know which environement we are called
we can use the Environnement class to access to the environement variable like the port of the application:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/f0b7672b-538b-44d9-95fe-576ae7ca8e00)

here we can see that the new variable that contains the port: (port 8000)
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/a65e59cf-6790-4499-8103-716993574e03)

lets lanch new instance of project with port :8001
we need to create new configuration and add arguments : -Dserver.port=8001 (will override which exist in environnement properties)
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/f86ce3a8-a187-4816-9aa2-d8ab31311d1b)

let s check the API:  
http://localhost:8001/currency-exchange/from/USD/to/INR
here we can see that the environement is with port 8001
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/6edb0ff8-fc61-4029-b921-c38588934bb9)

=> now we can know which instance of application is called







