# price

[microservices-sample](https://github.com/n-ono/microservices-sample) の料金を計算するサービス

## ドメインモデル

![料金計算](https://user-images.githubusercontent.com/58995947/99875492-73a3c900-2c33-11eb-85fb-de0351111785.png)

## 各種コマンド

下記コマンドは全てプロジェクトのルートディレクトリで実行する

### ビルド

```
$ ./gradlew clean build
```

### Docker イメージ生成

```
$ docker build -t <image-name>:<tag> -f docs/docker/Dockerfile . 
```

`<image-name>` と `<tag>` は任意の値を指定する
