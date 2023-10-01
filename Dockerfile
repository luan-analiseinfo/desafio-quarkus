# Use a imagem GraalVM para construir a aplicação Quarkus
FROM ghcr.io/graalvm/graalvm-ce:latest

# Diretório de trabalho
WORKDIR /app

# Copie o projeto para o diretório de trabalho
COPY . /app

# Configuração do Maven
ENV PATH="$PATH:/usr/local/maven/bin"
ENV MAVEN_OPTS="-Dmaven.repo.local=/usr/local/maven/.m2/repository"

# Instale o Maven
RUN curl -fsSL -o maven.tar.gz https://downloads.apache.org/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.tar.gz \
    && tar -xzf maven.tar.gz -C /usr/local \
    && ln -s /usr/local/apache-maven-3.8.4 /usr/local/maven \
    && rm maven.tar.gz

# Build da aplicação Quarkus nativa
RUN mvn clean package -Pnative -Dquarkus.native.container-build=true

# Comando para iniciar a aplicação
CMD ["./target/app-runner"]
