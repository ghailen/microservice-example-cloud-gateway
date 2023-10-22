Docker:

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/7a4c843e-987c-48ff-b3b9-916ad9ed6476)

after installing docker:
docker --version

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/a734fc06-d257-4143-8c1b-62f528f87f13)

when we run docker run :
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/18f7b0a4-4749-4fa6-8a1c-519cead93fde)

and image will be downloaded from hub.docker.com (docker registry) which contains a lost of repositories of different versions of different applications

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/95bbb2fb-fdaa-48cb-a7fb-ff1097b4b92b)

in tags here we can found the versions of applications:

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/776fc183-a413-4516-a923-72ff5d1380cf)

those are images, the image contains all the things that your application needs to run
an image is a set of bytes and when it s running , it s called a container.
=> Image is a static version and container is a running version.
and for the same image, we can have multiple containers running.

by defaut, any container that you run is part of something called a bridge in docker. (like an internal docker network)
nobody will be able to access it,unless you specifically expose it onto the host, onto the system,where your container is running.
so we need to specify the port to be accessible using -p option when running docker run. so we can access the application using for example the port 5000
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/bfd6dff3-b4c7-4439-8efe-2b545e7c8ccd)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/214483ea-1e45-463f-8866-f44261cb2d79)


to run the container in background (even when we press in CNTR + C ) it will still work
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/aae925e8-6700-421b-ad55-bd5b84cec813)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/b99de4a8-7fa9-4f2d-a2bf-9cd5ff3c297f)


to tail the log we add -f after docker mpgs command (in run time) after writing logs it will displayed in the cmd, to stop it press CNTR+c
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/48b606e7-3fd7-49b9-95e0-77f7ff4ed725)

to see the container information use the command :  docker container ls
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/a8e43c89-9375-4027-86dd-4a9f1b153f40)

we can run multiple container for the same image.
we can use the 5 or 4 (to check) first digit of the container Id to work with it

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/205b5759-396c-44d0-949d-54ba0e4e033e)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/cf7d10ea-acb0-42ec-a0fc-186e4ab330e8)

here we see two containers running:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/5897cd2d-a502-4ea0-baf4-95588a1fa1ce)

when we add -a to the docker container ls command, we will see more details about the status (Exited, Up)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/9981ff06-686b-4e2f-855a-31b5216fffb2)

to stop the container : we use docker container stop "the id of container"
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/14eec955-86f5-456e-b23d-7c29e245012b)

to recheck the status: (every container is exited)
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/93946093-3156-4853-b433-edc19796a9dd)

now lets see the image in my machine (the pulled one):
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/c566ab56-369f-4a8c-9c33-ffd86920c3bb)

===========================================
docker architecture

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/e38046c4-4442-4379-b632-0cbd3a0b220f)

the docker client is just responsible ofr sending the commands to the docker daemon
all the conainter are managed by the docker daomon
if an image is already downloaded, every time we run it with docker un it will be downloaded again , it will exist locally
the docker daemon will check if the images exist locally
docker daemon pull image from image resigtryl
docker daemon can process intructions to create images as well
docker daemon also can push the images to the image registry to be usable by someone else

========================================


![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/f00b1c05-0f7f-4f3c-bec3-31cfb2f69d36)

Hypervisor manage the virutal machine

in this example is to heavy for each applciation we need to have a machine to run on it.

the solution is using docker: one OS which is the host os
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/91419c5f-f509-4929-90ed-2a0eb9447efa)


docker images command will show:

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/7822732d-4a5e-482c-a0ee-6a4b6b3958c0)

we can give one tag ,multiple tag to one image :
using to add new tag : docker tag  ....

 ![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/c9ce9890-8033-457e-abd4-337ad6761b65)

now if we see docker images: another tag latest is added with the same image id

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/0809eaf7-7a91-442d-ae5e-9c7b10f05832)
=> it s not an automatically things , its manually 

if we run command docker pull mysql for example without specifying the version it will download the latest tag:

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/a424257e-33e6-4887-bb51-6afe6548aef5)

ps :latest tag could not be the latest

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/56201a7c-2090-4fef-bba5-607d96b644f1)

docker pull will download the image from the registry to your local, it does not run it, if you want to run it use docker run
docker run will run the image , if the image does not exist in local, it will download it to local and create a container/

mysql image consider like an official image, to know that you can use the command : docker search mysql

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/3ff49072-5359-4e22-b711-7e68c5f0dd42)
[OK]it means that its official

we can also check a history of an image: using docker image history {image id}

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/951e7430-92db-4571-b267-7effa50a2251)

 ![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/90a103cb-fa4f-4d30-866f-198072b01ea1)

here we can see the steps involved in creating that specific image, for examle we can see 99.4MB it s concern the layer added of  java JDK
========================================

docker image inspect [image id} command 

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/591325e2-6c17-4b30-9824-1ec3ee8ee720)

you can see the tags, date of creation, comment,digests,the config,the exposed ports, environnement variables...
===========================================
 the command docker image remove {image id} 
 will remove the image from your local:

 ![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/93ae499c-dd8a-47d3-bc78-adda832ff064)

===========================================================================================================================================
Now let s talk about commands related to containers:
the docker run is a shortcut for docker container run


![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/8f4e4022-3227-49f1-bafb-175d2eb8ddf3)

you can pause or unpause a container:
docker container pause {id of container}

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/c0c7e69a-aed0-4dab-9aa7-a87b7dd988f1)

=> its paused,so we can t get the response back

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/edce476d-a5c4-4657-88bf-8263afc8a146)

docker container unpause {id of container}

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/0e8d9d9b-102e-4052-b9ab-2311c32b74d6)

=> it s unpaused, we get the response back
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/b3b5f499-958e-432c-b3c3-315d0c17c5fd)

docker container inspect : to get all informations and configs and details about the container (states,volumes...)
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/110c617b-0de2-428a-9422-69e4f16a5a5e)

docker contaner ls -a will show the status of images and images
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/d4c3ad9b-ca86-4147-aea0-52f61ec3ab2c)

docker container prune : will remove all stopped containes.
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/5db16a1b-38cf-4450-a609-0ec2a0170d84)

docker container stop {id}
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/b6eced02-4ca0-4e6e-95f1-a67ec830bf5d)

it will stop the container , and the container will be shutdown gatefully, it will close znd stop resource one by one, close the connecion to database
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/34e81d68-fe43-485d-9d91-5a0d3de1b35d)

docker container kill {id}
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/2dd78e29-bc5d-4a54-86c9-06e337cf5f3d)

this will imediattly stops the container, it will not shutdown one by one/
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/1d655c1c-330a-4755-a902-93d1782b1ae5)

Note: for Stopping -> SIGTERM
      For killing -> SIGKILL
      ![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/ef506d74-3006-445c-87fa-c5f6fb1064e5)

=> use docker container stop

======================
now let s come back to todo-rest-api-h2 application , and add to the parameters --restart=always , its called a restart policy
There is restart=no (the default one) and restart=always
 every time we restart the docker dekstop the container will be started
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/2a25b4c8-595b-4117-b580-1917327c7800)

=> that s mean when we restart the docker desktop , the container will be automatically starter 

to stop the container, juste put : docker container stop {id}
and docker container prune to delete stopped container.
if the docker desktop is restard , the container will be started


docker events :
for example if we execute docker events , then in another tab we do docker container ls -a , then docker container stop {id}
and we back to the tab of the command  docker events we will see many events:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/ea49d12f-5790-41e3-84e0-e13581eacc31)


docker top {id}
what is the top process running in the container

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/3df62c4d-ee6f-435c-b1d9-20d62ab1e288)

docker stats : will show all the stats regarding the containers which are running:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/fd7d55ed-1283-4e59-8e7e-1f210ea6d518)


docker un -p 5001:5000 -m 512 --cpu-quota -d ...
will make the container use at a maximum 512 meg of memory
and cpu 5000 thats mean 5% of cpu
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/ac523711-c6aa-43f7-9ad4-29bd9e6a507f)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/0eea096b-3c7c-4b73-846b-4487b7a715ae)

docker system df : it helps us to look at all the different things that your Docker daemon manages

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/5bc6a1ce-60c2-4f93-92a4-8b4658c3d432)


![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/86eea7b4-8dca-4b0b-ba56-1f6aa9ed2c61)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/d27d663b-8db0-4e33-b849-9c3e7d245ec1)


========================================================================================
Distributed Tracing
=========================================================================================

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/c8270046-4be3-4ac3-b802-e23bdb2f5119)

All the mircoservices will write and connect to a single distributed tracing server and this distributed tracing server would store everything to a database
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/408cfe42-280f-410b-b0c7-453cebab2b5f)

=> Zipkin is a distributed tracing server , we will be launcching it as a docker container and we will be connecting all our microservices to this specific  zipkin server


======================Launching Zipkin Container using Docker=====================
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/778358b9-1d59-4f8a-b840-02c108bf4e5a)

let s run it as a container, we will pull it from the hub docker  :
docker run -p 9411:9411 openzipkin/zipkin:2.23
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/475ddbaa-b190-438f-8f83-add51023e570)

and now it is running in : 
http://127.0.0.1:9411/zipkin/
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/650924df-66ca-4f52-a85f-d81e0bee3aeb)


now let s connect Currency Exchange Microservice with Zipkin:

first we need to add a dependancy called :
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-sleuth</artifactId>
		</dependency>

sleuth provide the possibility to send a request using a specific id, it will sent to the tracing server, give as the possiblity to trace request of multiple microservices

also we need to add sleuth zipkin
	<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-sleuth-zipkin</artifactId>
		</dependency>

  this depenancy we will add it later
		<dependency>
			<groupId>org.springframework.amqp</groupId>
			<artifactId>spring-rabbit</artifactId>
		</dependency>

this is the schema of applications
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/427ec231-46dc-4b38-b8c5-49b3ada058ff)
let s suppose that the tracing server is down , what we can do ? we will lost the logs
the solution is to use a queue manager (rabbit mq)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/d595668d-80db-45f0-a1d0-503bbe923bf6)

so all microservices will send informations to Rabbit MQ and the distributed tracing server will pick up the information from the rabbit mq.

The rabbit mq part will be later.

let s now work with the old example:
let s configure the sampler which help us to make a percentage of request to trace.

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/a90ea25a-671d-4f26-b735-471da560dd41)

now let s run the project : 
and call the api of currency excnahge :
http://localhost:8000/currency-exchange/from/USD/to/INR
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/ee3fb887-03a6-403e-be9c-e6b2990f4562)

then we open zipkin interface to find the trace (query):
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/e619dd75-1c4a-4bd8-b530-d302ea854ef7)

let s add logs to the controller:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/26399758-bbac-4bbf-a173-309a82ca46be)

we call tha api again multiple time:
and we will see this : 
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/eaf0fa28-9e0a-48ee-b48b-8615d6786ea4)

there is a unique Id per request

now let s add sleuth rabit mq and sleuth zipkin dependancys into the other microserfice, currency conversion and api gateway:
an call too many time url of thoses microservices

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/3597f206-a3e1-44d1-98bf-da73489cb471)

if we open a query for api gateway, we can found the full hiearchie of the calls: it calls currency conversoion and currency exchange
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/41c2f243-fce6-430a-a5d7-b62b22f452de)

we can specify in microservie the url of zipkin : 
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/e3287284-3d30-4311-9f83-9b2db72c3617)

=========================================================Creating container image for microservices=============================================
now we need need to add a configuration in maven pluging in the pom file:
the dockerId: ghailene is not necessary to found it in docker , you can put any value
the we add the name ...
pullPolicy is by defaut ALL, for our case we will add IF_NOT_PRESENT: thats mean only if the images are not present locally, go and pull them,otherwise use the image which are present locally.
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/c40be192-4c95-408c-8cef-3b51e85e5c1e)

now let s build the docker image: using this command : spring-boot:build-image -DskipTests
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/bce04127-d209-4baf-bd6c-ca835856d8db)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/46088e66-7f9a-427b-8285-6d7b68c9dfbd)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/597624f4-bde7-48d7-b92c-4314750fc464)

=> Successfully built image 'docker.io/ghailene/mmv2-currency-exchange-service:0.0.1-SNAPSHOT'
now the image is created
let s run it : docker run -p 8000:8000 ghailene/mmv2-currency-exchange-service:0.0.1-SNAPSHOT
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/513269cf-9cfe-4e9e-9eac-bf4a6360b8ef)


![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/9283a065-363d-4079-926d-bb5d446dcb09)

we will get too manny errors in log because ereuka and zipkin are down

lets test the api now :  http://localhost:8000/currency-exchange/from/USD/to/INR
=> the image is up and we can call the api

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/75e16ac4-a6f4-40cc-9621-1d2951f63384)

so it will take some time to do the same work to all the instructions for each microservice (api gateway,eureka...)
so that why there is a too lcalled Docker compose, you will ned to configure a YAML file and with a single command , you can lanch up all the services which are defined inside the YAML file.
The docker compose is already included as part of those dekspot installs ,so you don t need to install it in our case.
to know the version : docker-compose --version
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/4dfcb8b0-7357-42c7-b893-15c8e8faf696)

now let s create in the microservices folder a new docker-compose.YAML file 
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/cd31cf8e-0fd3-4e45-9b0c-2177e2b6c116)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/155f91ab-5833-42fb-ad76-580c916709b2)

you must point to the path where the docker-compose.yaml exist then use : "docker-compose up" command
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/2f3fa1c6-450d-4f84-b5d1-a14346001457)

now the application is up we need to re call the api to check:
 http://localhost:8000/currency-exchange/from/USD/to/INR
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/9b24d2b7-4ffe-4274-886c-2f2e9ab3385e)

 now it s better to create a network, (not use the defaut network) the associate the service to the network
 ![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/1a11e5e3-c924-4846-b08f-97c5dfdba114)

and rerun "docker-compose up"
as we can see the network is created
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/af170744-1d62-453a-991d-5cf291e4fe62)

now let s do the same things to all the microservices:

Eureka-server: docker.io/ghailene/mmv2-naming-server:0.0.1-SNAPSHOT
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/9d21a240-a594-4824-b6da-1e3eb089a9d0)


here we added the naming-server configuration in yaml file: and we added the attribute depends_on , in the currency-exchange because it depends on the eureka naming server
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/afd08480-9a6b-40ea-aeb7-ac718a0295fc)


when we make the eureka server (naming-server up) when the microservice currency exchange try to connect to eureka server , we will get an error, because we can t call localhost:
even if the eureka is up in localhost:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/68c92f90-bcc8-454a-9280-b9775a67d9bf)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/8712ff64-b5e2-4b1a-a6f6-3cfc10088703)

the solution is to add an environnement variable to the yaml file in the currency exchange conf:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/e63c2ced-c1ee-432d-be18-82c52942c65b)

put it in the conf (uppercase): 
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/d08361f6-db69-4d24-9014-6825930d308b)
and now as you can see the currency exchange microservices is registred to the eureka:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/78239727-5d45-441d-9559-57936db98a72)

we can check it in eureka server:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/3463c84d-ee08-412b-8743-291066628ab1)



API-gateway: ghailene/mmv2-api-gatway:0.0.1-SNAPSHOT
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/ad7317f6-06c7-497f-bbec-c60171dadb74)


Currency-conversion: ghailene/mmv2-currency-conversion-service:0.0.1-SNAPSHOT
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/257dcb0f-0527-4ae2-99d7-b045bec54d70)

lets add the microservice to the yaml file config:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/98fc7f7e-867c-4ec8-9372-20a71f775663)

then in the console run , docker-compose up , again
adn as we can see in eureka server, the currency conversion is up and registred in eureka:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/5ee568cd-812d-4e10-b562-7227cf1fd478)

then this url will work: http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/c793bc56-85ac-4fd9-87af-7797e6f448b6)

but this one will not work: http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10  because it use a hardcoded url of localhost:8000 , so we need to use variable in conf yaml if we want to resolver that.   for example it will be http://currency-exchange/....
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/32b2cea5-ae7b-4856-9633-b1120c0d6dce)


