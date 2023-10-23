
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
