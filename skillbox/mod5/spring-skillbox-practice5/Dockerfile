# Используем официальный образ OpenJDK для сборки и запуска приложения
FROM openjdk:17-jdk-slim

# Указываем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем jar-файл приложения в контейнер
COPY target/*.jar app.jar

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]
