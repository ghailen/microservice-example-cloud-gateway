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

lets make the data stored in a h2 in memory database:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/4c20d2ba-b2e2-48ca-8935-a7fe8b96526c)

the url : http://localhost:8000/h2-console/
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/157d6405-7ffd-4bb2-b0cf-e33961bbe3eb)

in order to create the table in the db , we need to add the annotation @Entity and @Id to the entity 
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/6ced933c-f911-435d-aa12-5786959b4908)

in database the camel case will be with format x_y for example: CurrencyExchange will be currency_exchange ,  conversionMultiple will be conversion_multiple

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/26edc493-69a4-4753-8fbf-157cd87de2cc)

let s insert some data, so we create an sql file named data.sql in resources folder:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/e83ccfab-22ce-46ee-9080-134f57df363d)

each time the application executed, the data.sql file will be exxecuted and the data will be inserted in the databse
in the database:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/f0d209e3-0300-4dd1-9bee-938ae0457d9d)


Lets create now the Currency conversion microservice:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/ac7a1b2d-45c2-42ce-90a9-75019f17f7bf)

the created api : 
http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/548e825d-7077-42aa-8d75-6af356cb60b7)

now let s see how to call currency exchange microserice from currency conversion microservice:

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/f68b2143-39d4-48e8-8747-2f8e49f4481d)


image now if we have multiple micorservice which communicates with each other so we need to create each time a rest template call, the solution is that spring cloud offer framework named Feinwhich can facilitate the communication betwee microservces.

so you need to add foein dependancies:
<dependency>
		 <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>

  then we need to create a proxy interface to allow the communication:
and add new annotation in interface named @FeignClietns and put two parameters name and host:
this is the name of the micorservice currency exchange which exist in spring.application.name and the url of the microservice (only the host) as second parameter
  
  ![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/3773ce73-bddc-47dc-a5b9-a155ae51cc57)

  -in the main class a new annotation miust be added:
  @EnableFeignClients
  ![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/e225db1c-b96c-4554-8683-a9ca55eefde6)

  now lets create new api for the fein (we kept the example of the rest template)
  api feign example : http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10
  ![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/1719231c-dd6d-492b-9945-3985da162e9d)

  ![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/55020007-7230-43cb-994a-3400ea92a0e9)

now the url in the proxy config is hard coded so we need to find a solution to make it dynamcally (use the instance dynamically) : => use the naming server or the registration service
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/eb4ce5ab-f50a-4a0c-8132-07d9f0e78224)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/d86191d5-9024-4708-ba46-19f48f31120b)

we will use eureka: 
so we created a new microservice named naming-server
and we add the dependalcy eureka netflix,
and in class main we added the annotation @EnableEurekaServer
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/322980cf-4ef7-47cd-8536-710e22df2226)

now we need to not register the microservice eureka to it self so we need to add a property in the application.properties:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/1c1af787-2096-4650-8826-c8380789341f)


let s run it : in port : 8761 and as we can see here there is no instance running
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/b6625ea2-9ed7-4a68-baf0-f375da19808c)

  
now let s connect the miroservice to the naming server:
what we need to do is to add dependancy: 

in the pom files of the microservice:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/5e84843f-94ad-4517-82f6-73ad96e282df)
and add in application.prop in the two microservices: 
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/fab6a2f6-7685-45fe-97c3-444e4de80264)

=> after rerunning the both microservices: we see the two instance created and up
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/1c96a9ca-ce87-44a3-80ed-9bd7467d233b)

and next we need to make the currency conversion talk to currency exchange through the naming server


now we gonna do the load balancing:
// this is the name of the micorservice currency exchange which exist in spring.application.name and the url of the microservice (only the host) as second parameter
//@FeignClient(name="currency-exchange",url="localhost:8000")  // by deleting the url , the loadbalancing will work (no specific url for exchange)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/4fb5d88c-aabf-463c-a760-49e7cf3e4aeb)

we need to delete the url, so now after api rest call the request will be balanced by the loadbalancer based on naming-server

if we call now the api from currency conversion, and we lanch two instance of applciation on port 8100 and 8101 every time we call the api the load balancer will work and move betweent the two instance

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/916997b5-2024-476c-a56d-d1ad5acce7b3)

Now let s create the spring cloud gateway:
this dependancies is needed:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/67164d9e-b32c-4312-b171-bcfdcbe06371)

application.properties file: the project will run in port 8765
and lets connect the api gateway to eurika
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/466312e2-2579-4c5f-b00d-91cd74ad2aac)

and as we can see the api gateway is up:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/802e6a70-2232-49d3-9d28-790d80403cd2)

once the api gatway is up in port 8765 and registed in eureka, what we can do is to acces to the url of currecncy exchange (http://localhost:8000/currency-exchange/from/USD/to/INR) passing by api gateway (using the applicatin name):
this is an example :
we need first to enable the discovery
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/ff136ca2-1352-4cd7-9be0-ec235868c826)
then we can use the uul : {api-gateway-url}/{name-of-Service}/{url-of-the-service}
=> http://localhost:8765/CURRENCY-EXCHANGE/currency-exchange/from/USD/to/INR
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/05fedfa2-8c9d-4faf-8bbd-36416d580fdf)

the url for currency conversion:
http://localhost:8765/CURRENCY-CONVERSION/currency-conversion-feign/from/USD/to/INR/quantity/10
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/b1ed4bc7-8af9-44e5-bd3d-3faffca220db)

the url works but only with service name upper case, we can fix that to support lower case bu aded 
spring.cloud.gateway.discovery.locator.lowerCaseServiceId=true
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/58b357bb-0aee-4f93-afe3-00c231c573b7)
so this url now worj:
http://localhost:8765/currency-conversion/currency-conversion-feign/from/USD/to/INR/quantity/10


Now let s build custom routes:
an example , we are creating the redirection when we call the path /get to a specific url: (we create a custom route using a configuration class )
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/37f250f3-546c-4137-923b-976ab1b8e93d)

now if we call 
http://localhost:8765/get
the returned information about the new url: (the header, the path...)
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/10263e5b-ce28-4b05-bd22-7c47aaa0311c)  

now we added some header using filters:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/420c17c7-e6af-40e7-bf80-97bd1f2fb74b)

The headers is added here:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/29ea68ec-e1ac-4bcb-9b9e-a70b2a4343fd)









