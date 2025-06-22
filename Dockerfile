# Usa uma imagem base com Java (por exemplo, OpenJDK)
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /opt/h2-database

# Define a versão do H2 que você quer usar
ENV H2_VERSION 2.2.224

# URL para baixar o H2 JAR (você pode verificar a versão mais recente em https://www.h2database.com/html/download.html)
ENV H2_URL https://repo1.maven.org/maven2/com/h2database/h2/${H2_VERSION}/h2-${H2_VERSION}.jar

# Baixa o arquivo JAR do H2
RUN apt-get update && \
    apt-get install -y wget && \
    wget -O h2.jar ${H2_URL} && \
    apt-get remove -y wget && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Expõe a porta padrão do H2 Console (8082) e a porta TCP (9092)
EXPOSE 8082
EXPOSE 9092

# Comando para iniciar o servidor H2
# -web permite o acesso ao H2 Console
# -tcp permite conexões TCP
# -webAllowOthers e -tcpAllowOthers permitem conexões de outros hosts
CMD ["java", "-jar", "h2.jar", "-web", "-webAllowOthers", "-tcp", "-tcpAllowOthers"]