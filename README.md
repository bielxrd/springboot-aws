# AWS S3 Service Application

Esta aplicação Spring Boot interage com o serviço AWS S3 para criar buckets, fazer upload de arquivos e definir políticas de bucket.

## Configuração

### application.properties

Antes de iniciar a aplicação, você precisa configurar suas credenciais AWS no arquivo `application.properties`.

```properties
spring.application.name=Studying-AWS-Services

# AWS credentials
aws.accessKeyId=YOUR_ACCESS_KEY_ID
aws.secretKey=YOUR_SECRET_ACCESS_KEY

```

Substitua YOUR_ACCESS_KEY_ID e YOUR_SECRET_ACCESS_KEY com suas próprias credenciais da AWS.

# Endpoints

### 1 - Criar um Bucket
Endpoint: POST /s3/create

Request Body: Nome do bucket em formato de string.

Exemplo de Requisição:

```json
2024-10-11-testecomspringboot
```

### 2 - Fazer Upload de um Arquivo
Endpoint: POST /s3/upload

Request Body: Nome do bucket, chave do objeto (nome do arquivo) e caminho do arquivo.

Exemplo de Requisição:

```json
2024-10-11-testecomspringboot
```

Deve informar no código, no metódo putObjects as chaves, os nomes que os arquivos terão e o caminho do arquivo no seu pc.

### 3 - Definir Política de Bucket
Endpoint: POST /s3/policy

Request Body: Nome do bucket e a política em formato JSON.

Exemplo de Requisição:
```json
{
    "bucketName": "nome-do-seu-bucket",
    "policy": {
        "Version": "2012-10-17",
        "Statement": [{
            "Sid": "PublicReadGetObject",
            "Effect": "Allow",
            "Principal": "*",
            "Action": ["s3:GetObject"],
            "Resource": ["arn:aws:s3:::nome-do-seu-bucket/*"]
        }]
    }
}

```


# Executando a Aplicação
### Clone o repositório:
```
git clone https://github.com/bielxrd/springboot-aws.git
cd springboot-aws
```

Compile e execute a aplicação:
```
./mvnw spring-boot:run
```
