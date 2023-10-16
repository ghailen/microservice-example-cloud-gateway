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

