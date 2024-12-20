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




