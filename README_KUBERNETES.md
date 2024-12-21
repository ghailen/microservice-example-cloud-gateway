![image](https://github.com/user-attachments/assets/44ce6731-2dc2-4f50-b79c-7b232534f702)
in this course we will use GKE Gooogle Kubernetes Engine and we will create a free google account , becaue azure and aws are not free

![image](https://github.com/user-attachments/assets/7f979604-ea7d-4249-9f10-907bbc267a6b)

![image](https://github.com/user-attachments/assets/9f26ab51-51e3-41d5-b02e-73d6f6d34cc0)

you need to create a free trial google account in cloud.google.com

 ![image](https://github.com/user-attachments/assets/3f28a8ce-1ad9-4f0e-8c48-7773b2542593)

kuernates is resource manaher, and the resources are servers, and this servers are in the cloud (virtual servers in cloud) . 
the different cloud privders have different names for these virtual servers.
Amazon calls them EC2 (Elastic comptute cloud)
azure calls them virtual machines 
and Google cloud calls them compute engines 
and kubernetes call them ? kubentaes uses a very generic terminology and calls them nodes.
kubernetes can manage thousands of nodes 
and how to manage them ? use managers , 
to manage too many nodes you need a  master node.
typically uou ll have one maste rnode ,but when you need high avaliablity , you go for multiple master nodes.
so what is a cluster ? a cluster is nothing but a combination of nodes and the master node. The nodes that do the work are called the worker nodes or simply nodes. the nodes that do the management work are called master nodes.
![image](https://github.com/user-attachments/assets/065bae77-319d-44fb-aaa7-759d6cff20a9)
![image](https://github.com/user-attachments/assets/30705a74-bf80-43aa-9de6-7f422354c320)
master nodes ensure that the nodes are avalaible and are doing some useful work.
How to create a cluster ?:
![image](https://github.com/user-attachments/assets/af00aad6-f5f9-45db-bf61-24e5a10cef47)
![image](https://github.com/user-attachments/assets/1f5d6819-7412-4ec5-abad-4250177da02a)
![image](https://github.com/user-attachments/assets/fad4488c-85fe-4724-b24a-fa17516cc0cf)

if you want to create a cluster you will need to choose the type of nodes you want, the number of nodes you want and their location.
![image](https://github.com/user-attachments/assets/dd86163d-7c0b-4b7a-b25f-5ffcbbd5284e)
![image](https://github.com/user-attachments/assets/393e172e-b0cd-4e7a-a2ac-3e287a847751)

![image](https://github.com/user-attachments/assets/6a4c8d97-642b-4857-baab-fcd6a21de8ad)

kubernates cluster is running ![image](https://github.com/user-attachments/assets/7f487def-d480-4d4a-96ca-e2cbd459a1f7)

node cluster details and nodes:
![image](https://github.com/user-attachments/assets/f4017442-bf67-444b-86fe-fa0da0cf2344)

kubernates have something installed for each node to manage them .

==============================
now let s connect our application to kubernates cluster, to use that we need to install too many things, but google cloud give as a tool to use the command line to do the connection, the name of tool is : Google Cloud Shell 
![image](https://github.com/user-attachments/assets/945abed5-4133-44e7-8623-cb073f7fea45)

![image](https://github.com/user-attachments/assets/050c5003-90d3-4125-8bcb-07fc5ffb85bf)

now what is the connect to the cluster command: 
click on connect then copu the command in shell console
![image](https://github.com/user-attachments/assets/2ee374a1-d278-4bba-a85f-736e2fcad803)

![image](https://github.com/user-attachments/assets/e594eec4-c64f-4120-8dec-b7a0ea109b02)

![image](https://github.com/user-attachments/assets/3236a07d-739e-4ad5-b1c1-383e31fea305)

to run command inside ths cluser you need to ise command : kubectl (kube controller)   it used to interact with cluster
its is automaticcaly installed in shell console 

![image](https://github.com/user-attachments/assets/f72209a4-3467-4cb1-bbd7-6dd9beb67292)

to deploy application: you need to use kubectl create deployment ... :
![image](https://github.com/user-attachments/assets/ae04c17e-9290-4441-bc5b-d6473895541b)

where image is the image of application in docker

![image](https://github.com/user-attachments/assets/f7d53a76-866a-4f2b-b678-c77a62240484)
![image](https://github.com/user-attachments/assets/6d3df507-590f-4323-93a6-e1e7d58056ac)

![image](https://github.com/user-attachments/assets/2e665dfa-b122-4f70-8b3b-b47370eacfbf)
![image](https://github.com/user-attachments/assets/85dc274d-a113-4df4-9de8-39104f85d32c)

![image](https://github.com/user-attachments/assets/5723de3e-5fb5-41db-b46f-4943165760f1)

now to expose the deployment to the world :
exposed to port 8080 
![image](https://github.com/user-attachments/assets/bc454eee-2d61-4bb6-876e-67c9b463172e)

to check if the service is exposed well , you go to the interface then Services & ingress you will find the service:
![image](https://github.com/user-attachments/assets/d1fcecf1-8277-4f8a-b86a-a67e9f931405)

![image](https://github.com/user-attachments/assets/b5789cd5-4827-4250-873d-ffc12a50299f)

if we enter to the endpoint:
![image](https://github.com/user-attachments/assets/35205016-2dd1-40a9-be36-7f3456a3f6e3)

![image](https://github.com/user-attachments/assets/ea269064-4204-424b-a038-acb21d94ef29)
![image](https://github.com/user-attachments/assets/f66c92a0-b040-48ad-acb9-d63bb088194c)


now let s see the detail how it is done : 

![image](https://github.com/user-attachments/assets/f0a98cb6-db74-404f-bd63-a4e009ccb46c)
let see the event happened:
![image](https://github.com/user-attachments/assets/68834091-aa94-4031-8761-34acd0d0422d)

pod is created, replicatSet , depmyment ,service.
![image](https://github.com/user-attachments/assets/5ac14ee1-e2e4-4b8d-9e64-3e9ecf62767e)

![image](https://github.com/user-attachments/assets/000fec43-6ca6-425f-b706-4b648d82af2d)

![image](https://github.com/user-attachments/assets/f6a9d643-e3a0-4d31-8eea-05854082d7de)

![image](https://github.com/user-attachments/assets/c650a734-2611-4bd9-b042-413563d1254b)

kubernetes use signle responsiblityh principle , one concept one responsiblity 
![image](https://github.com/user-attachments/assets/0e07c28a-f7fb-40e7-b510-4819acdf3db8)

  ![image](https://github.com/user-attachments/assets/b9d198cc-5c57-4b35-9680-5ab29223182d)

 ================understanding PODS====================
![image](https://github.com/user-attachments/assets/c38bb152-f570-464c-9cc3-1e71265329b1)
![image](https://github.com/user-attachments/assets/398c8908-5e92-4fc7-bd1b-f8d0d3f93fa3)
we cannot create a container without pods , container lives inside a pod 

![image](https://github.com/user-attachments/assets/3836cf44-ceee-4dac-91a0-f59ee884d1d6)
each pod have a unique ip adress 
a pod can actually contain multiple containers
All the containers which are present in a  pod share resources. within the same pod 
the containes can talk to each other using localhost.
![image](https://github.com/user-attachments/assets/913af893-4688-4df7-865c-f12712a13fa3)
![image](https://github.com/user-attachments/assets/31234717-3ed3-4777-bb44-0e555409bd15)
a kubernates node can contain multiple pods and each of these prod can contain multiple containers  .
There pods can be from different applications or these pords can be related to the same application.

how to get description of a pod:
![image](https://github.com/user-attachments/assets/a2dd347f-5220-4da8-a673-fa347be8fe3b)

![image](https://github.com/user-attachments/assets/e15c4472-d225-4f95-abda-1e0c1686177e)

a pod is runed in a namespace , these one is default : 
![image](https://github.com/user-attachments/assets/38a2ba8a-3847-4548-9f70-8c8e71bb8cf0)
how to separate the resources of DEV from the resources of QA?

![image](https://github.com/user-attachments/assets/88e00d7e-cb08-42cc-9669-a7b380458244)

![image](https://github.com/user-attachments/assets/49bc5aeb-664f-486b-a891-ecd36016e0e7)


=====================understanding ReplicaSets================
![image](https://github.com/user-attachments/assets/0b3563d7-6fb5-4fbf-a8e9-3bbec8f0b4c4)

A replica sets ensure that a specific number of pods are running at all times.

![image](https://github.com/user-attachments/assets/656f2951-0f65-4171-91fc-e2dc85093676)

![image](https://github.com/user-attachments/assets/e456e770-432c-471d-bf6d-3ec75b23b0b9)

 ![image](https://github.com/user-attachments/assets/ff34ffb2-c21f-431d-b2af-3834569a583d)

 to delete the pod :
 
![image](https://github.com/user-attachments/assets/e01c585d-e347-47bc-8053-cc667b9ab11b)

when deleting the pord and wirte kuberctl get pods -o wide 
we find that the pod is deleted , but there is another one appeared with another id 
![image](https://github.com/user-attachments/assets/76eae5ef-e4b6-4852-bc58-59aef4c28d05)
![image](https://github.com/user-attachments/assets/b38e3933-aceb-442f-9d94-5b98c66a1246)

also the url is continue to work :
![image](https://github.com/user-attachments/assets/4e647c7e-449c-4f22-b376-cc2191c62afa)

![image](https://github.com/user-attachments/assets/d45a3c94-dfc9-4f03-804c-5333753e16c2)
![image](https://github.com/user-attachments/assets/a834b402-6de8-45ec-9fe3-211601122c11)
![image](https://github.com/user-attachments/assets/b94883d9-0574-456f-b4e1-b84a5a887309)

![image](https://github.com/user-attachments/assets/3eadd688-f5b4-4154-b5fa-97af07593be4)

![image](https://github.com/user-attachments/assets/d71c3f30-f714-4564-b47b-75b26568234d)

![image](https://github.com/user-attachments/assets/fc2f15b0-9cb8-466d-8a31-1a3b2124e105)

![image](https://github.com/user-attachments/assets/17a4b0bd-329c-42c2-8058-433a26147eeb)
![image](https://github.com/user-attachments/assets/6fee8c64-5f89-4c47-9f29-7bd73ae7d973)
![image](https://github.com/user-attachments/assets/ed89c06f-7b6e-4ad7-92b7-360fa4450ea4)
![image](https://github.com/user-attachments/assets/a09f5f46-b83b-40e5-9f76-c2d4ab114c07)
![image](https://github.com/user-attachments/assets/30c4d231-7481-4e64-8e1d-013c6b58fa7e)

![image](https://github.com/user-attachments/assets/2516bc4e-8a3b-42f7-bf6f-7578c2be1c00)


![image](https://github.com/user-attachments/assets/0b964173-efa5-470c-8aa6-86731c9ff2ce)

![image](https://github.com/user-attachments/assets/c3dd0013-2ba1-4440-95fd-849229ef02eb)


![image](https://github.com/user-attachments/assets/2d9dbcd6-212c-43c5-836e-799e5841c9f4)
![image](https://github.com/user-attachments/assets/f5ea49a9-c1ad-425a-a1bb-c911a7d42711)

![image](https://github.com/user-attachments/assets/20393efc-decb-4eb0-8b38-9f435a7ace76)

![image](https://github.com/user-attachments/assets/8c444d5b-598d-4ea6-9c5a-73c15fc3d236)



![image](https://github.com/user-attachments/assets/f211a052-3173-42ed-916a-411a44a9dfb6)


![image](https://github.com/user-attachments/assets/a6c197f0-54ce-42bb-b86d-79f620096490)

![image](https://github.com/user-attachments/assets/f1199aea-b093-47d7-b8f7-bc471c5ce7f9)

![image](https://github.com/user-attachments/assets/4e485b36-349d-4a72-a1a0-577220ceb95a)

we will see how it happes in background:

![image](https://github.com/user-attachments/assets/7368430f-9516-4f94-b9f7-977bd160407a)

we can see 3 replicat set in history (the first one is old 38 min ago and it was deleted in the example but the event command return all info)
![image](https://github.com/user-attachments/assets/d9162aeb-764d-4783-a6c4-a4fc476ed8f4)

![image](https://github.com/user-attachments/assets/44789ae6-52d3-47b2-ab61-74613ddf5b1b)


![image](https://github.com/user-attachments/assets/83c89c4c-91d1-49b6-8e78-85849850d01a)

explain command : 

![image](https://github.com/user-attachments/assets/87f4477e-7f9d-4bc8-9c45-4a94a46ed8ee)

![image](https://github.com/user-attachments/assets/45ff7ee6-611c-417d-b146-86bc18acec93)
=> maintining the number of pods

=========================Understanding deployment==============================








































