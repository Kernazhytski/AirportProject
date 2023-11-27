# Используем Node.js образ
FROM node:latest

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /usr/src/app

# Копируем зависимости package.json и package-lock.json
COPY package*.json ./

# Устанавливаем зависимости
RUN npm install

# Копируем все файлы проекта внутрь контейнера
COPY . .

# Команда для запуска приложения при старте контейнера
CMD ["npm", "start"]
