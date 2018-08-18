FROM maven:3.5-jdk-8
RUN mkdir /code
WORKDIR /code
ADD pom.xml /code
RUN mvn verify clean --fail-never
ADD . /code
RUN mvn package
RUN bash ./scripts/download-treetagger.sh
RUN sed -i 's/treetagger-macos/treetagger-linux/g' src/main/resources/config.props
CMD ['mvn', 'spring-boot:run']
