# Используем OpenJDK образ
FROM openjdk:latest

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /usr/src/app

# Копируем исходные файлы проекта в контейнер
COPY . .

# Сборка проекта с помощью Maven
RUN ./mvnw clean package -DskipTests

# Копируем собранный JAR файл вашего приложения в контейнер
RUN cp target/server-0.0.1-SNAPSHOT.jar app.jar

# По умолчанию приложение будет запущено на порту 8080
EXPOSE 8088

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "app.jar"]
