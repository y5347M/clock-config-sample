# clock-config-sample

こちらに詳細を記載しています。
https://qiita.com/y5347M/items/5c679fa1d351fc8ef02b

#### 日時を指定しない場合
applicaiton.ymlには以下の設定を追加します。
```yml:application.yml
time-travel:
  specified-time: 
```

アプリケーションを起動します。
ログにはデフォルトのClockを使用するという内容が表示されます。
```console:log
2023-03-05 11:34:07.851  INFO 9299 --- [           main] c.e.c.config.ClockConfig                 : Using default clock
```

`http://localhost:8080/api/datetime`にアクセスします。
レスポンスには現在日時が表示されます。
```console:レスポンス
{"localDateTime":"2023-03-05T11:35:16.674985","localDate":"2023-03-05","localTime":"11:35:16.675263"}
```

#### 日時を指定する場合
applicaiton.ymlには以下の設定を追加します。
```yml:application.yml
time-travel:
  specified-time: 2025-01-01T12:00:00.000Z
```

アプリケーションを起動します。
ログには指定された日時のClockを使用するという内容が表示されます。
```console:log
2023-03-05 11:38:07.522  INFO 9373 --- [           main] c.e.c.config.ClockConfig                 : Using custom clock: 2025-01-01T12:00:00.000Z
```

`http://localhost:8080/api/datetime`にアクセスします。
レスポンスには指定された日時が表示されます。
注意が必要なのは、指定した時間はUTCで表示されるのはJSTとなる点です。こちらは各プロジェクト内で統一してください。
```console:レスポンス
{"localDateTime":"2025-01-01T21:00:00","localDate":"2025-01-01","localTime":"21:00:00"}
```
