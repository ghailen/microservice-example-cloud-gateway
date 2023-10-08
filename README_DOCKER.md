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



