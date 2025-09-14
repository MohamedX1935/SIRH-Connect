FROM node:18-alpine AS build
WORKDIR /app
COPY package.json angular.json tsconfig*.json tailwind.config.js ./
COPY src ./src
RUN npm install && npm run build

FROM nginx:alpine
COPY --from=build /app/dist/sirh-connect /usr/share/nginx/html
EXPOSE 80
