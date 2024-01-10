
================================== every screen shot contains ghailenebm replace it by ghailenem : its fixed in the code , it was a mistake in the screen shot =================
To authenticate Docker Hub in a GitHub Actions workflow using an access token, you can follow these steps:

    Generate a Docker Hub access token:
        Go to the Docker Hub website and log in to your Docker Hub account.
        Click on your profile picture in the upper right corner and go to "Account Settings."
        On the left sidebar, click "Security."
        Under "Access Tokens," click the "Create Access Token" button.
        Provide a name and description for your access token, and configure the desired permissions.
        Click the "Create" button.
        Copy the access token value that is generated.

    Add the Docker Hub access token as a secret in your GitHub repository:
        Go to your GitHub repository.
        Click on the "Settings" tab.
        In the left sidebar, click on "Secrets."
        Click the "New repository secret" button.
        Set the name for your secret (e.g., DOCKERHUB_PASSWORD).
        Paste the Docker Hub access token value in the "Value" field.
        Click the "Add secret" button.
got to the : 
https://hub.docker.com/settings/security
then :
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/0dddc980-0d1c-4c61-ae2c-992e40782f35)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/3688e804-66fe-49f3-94c3-50de76e2ae62)


![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/54163f1c-3dc4-4f3b-a39e-51616c2a66cd)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/27d6b86f-dc7c-463e-9017-f1690665d100)



![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/434991db-413e-44ce-8294-abb40e81e763)


let s create a dokcerfile for each microservice, here for the currency-microservice:



building a local image:
there is two ways:
the first way is to pass throught the maven plugin dependancy in spring project:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/88d1ef7e-2be5-4700-bed5-6cde03d71a22)

then you need to run this command : 
spring-boot:build-image -DskipTests
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/3914cdbb-6640-439d-b1fa-d7a55b4094d1)

the name in our local in docker will be like that: 
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/4f0fd9ad-21f8-4960-a999-2889de4732ac)
Here we have a problem when we need to push the local image to hub because in my account the username is ghailenem not ghailene, so when pushing we gonna get an error message: access denied
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/45aa844f-9eb8-4be4-bc50-488e85959afe)

so to correct that we need to make the file name like that:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/da9f9a40-58e1-404e-8e07-050ca5ea53f4)
which is exist here in the docker hub:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/30d85d31-39fc-4e16-b7f8-3be468500079)


================
the second case to build an image in loca is to create a docker file:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/780a251d-0a97-45ed-b93f-320842ef4051)

the point to the path where is the docker file and run: docker build -t ghailene .
ghailene is the name of image
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/abeb3719-1a38-437a-8222-802769c7c72a)

![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/f50c12c3-b695-47bb-b363-401cc079a432)

=========================
Now we create a github action worflow to automate the build of the image and push it in docker hub, so we need to use the user name ghailenem in our case , after running the job we will find the image in the hub
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/67f97b29-3c27-49d3-bd1c-588321492f99)

and in the hub the image is pushed:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/3836f384-8a25-4298-abff-b2b6af8d2c4a)

now the target now is to generate for each microservice a docker file to build it, and rename in all the pom file maven plugin ghailene by ghailenem to facilitate after the push of the local image , or the pull from the hub to the log to run the image locally.

now we generated here new local himages for all microservcies:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/3b8f6374-2f95-433a-b81c-47ab1c82f864)

lets delete the old local image which begin with ghailene/
and change ghailene by ghailenem in the docker compose file:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/08ac1bad-ebc4-4650-84e0-1e42a710e762)

let s run with : docker-compose up 
and check all the urls : of microservices and rabitmq, zipkin and eureka

now for each job i will create a workflow (job file)
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/dab975d1-d55b-492b-9df4-2f396add4bf6)

and every push or pull request in a module or microservice the concerned job will be triggred.
here i pushed in every microservice a code, so 4 jobs are triggred.
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/e6aec7b5-fb52-4e81-b38a-3ab14b6295ab)
and a new image foreach module touched is created and pushed to the hub:
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/55eebc78-8f6f-46bc-ad2e-5fb05066f87a)


===========================
Now lets pull the new images using the "docker-compose pull" command 
![image](https://github.com/ghailen/microservice-example-cloud-gateway/assets/36199753/fb702656-fe0b-4582-8e8d-038276b9d71f)

after updating the last images , let s run them with "docker-compose up" command



