FROM node as builder

WORKDIR /app

COPY package.json yarn.lock ./

RUN yarn install --frozen-lockfile

# Copy the rest of the application code
COPY . .

RUN yarn build

FROM nginx

COPY --from=builder /app/dist /usr/share/nginx/www/

COPY nginx.conf /etc/nginx/nginx.conf
