# 
## 1.EventStorming Model : Design Level
![image](https://github.com/ohmyztech/ztbaemin/assets/130043253/53f72439-c340-4cd2-aebe-053f65d076b1)


## 2.Saga (Pub / Sub)
## 2-1. Order.java
![image](https://github.com/ohmyztech/ztbaemin/assets/130043253/4f00187d-2e0a-4630-a39a-009321ac7375)

## 2-2. Payment.java
![image](https://github.com/ohmyztech/ztbaemin/assets/130043253/51cf5d03-c86d-4179-afc2-5891444d2af3)

## 2-3. Cooking.java
![image](https://github.com/ohmyztech/ztbaemin/assets/130043253/54bd7d1b-d946-489c-9569-34da9af4fda9)


## 3.CQRS
![image](https://github.com/ohmyztech/ztbaemin/assets/130043253/206f9834-38bb-4dd6-9b7f-f1415eb60be5)
![image](https://github.com/ohmyztech/ztbaemin/assets/130043253/e5f91596-b2b3-4481-aed7-f8c039ea6147)
![image](https://github.com/ohmyztech/ztbaemin/assets/130043253/1999e7d6-f303-4ed3-84c4-7fd6b673fb66)


## 4.Compensation / Correlation
## 4-1.주문
![image](https://github.com/ohmyztech/ztbaemin/assets/130043253/99d15a3b-3726-4a22-a4f6-7900c1fb584d)

## 4-2.주문수락
![image](https://github.com/ohmyztech/ztbaemin/assets/130043253/4f3b085f-6767-44a0-ae59-55acceaf6821)

## 4-3.카프카
![image](https://github.com/ohmyztech/ztbaemin/assets/130043253/cb2261f9-914c-4099-b4ab-f79253d02f73)


## Model
www.msaez.io/#/storming/ztbaemin

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- front
- store
- rider
- customer center


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- front
```
 http :8088/orders id="id" userId="userId" userAddr="userAddr" userTel="userTel" menuId="menuId" menuQty="menuQty" orderStatus="orderStatus" 
 http :8088/payments id="id" orderStatus="orderStatus" orderId="orderId" 
```
- store
```
 http :8088/cookings id="id" customerId="customerId" customerAddr="customerAddr" customerTel="customerTel" menuId="menuId" orderStat="orderStat" menuQty="menuQty" orderId="orderId" 
```
- rider
```
 http :8088/deliveries id="id" customerId="customerId" customerAddr="customerAddr" customerTel="customerTel" deliveryStatus="deliveryStatus" orderId="orderId" 
```
- customer center
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

