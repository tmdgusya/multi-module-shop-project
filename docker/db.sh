#!/bin/zsh

docker run -d --rm --name shop-db \
  -e MYSQL_ROOT_PASSWORD=1234 \
  -e MYSQL_ROOT_HOST='%' \
  -e MYSQL_DATABASE=shop \
  -e TZ=Asia/Seoul \
  -p 3306:3306 --platform linux/amd64 mysql:latest --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci --sql_mode=""