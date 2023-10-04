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









