# SmartPromo
O SmartPromo é uma SDK para envio de notas em campanhas promocionais. 

## Instalação
### Gradle
SmartPromo pode ser adicionado no seu projeto `Android` utilizando o `Gradle`, para isto adicione o repositório do `jitpack.io` ao seu arquivo `build.gradle` a nível de `projeto`, dentro de `allprojects` e `repositories`:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Agora adicione a dependência abaixo ao arquivo `build.gradle` a nível de `módulo`:

    implementation 'org.bitbucket.getmo:android-smartpromo:1.8'
    
Para finalizar, você precisa adicionar a compatibilidade com o Java 8 no `build.gradle` no seu modulo:

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

## Utilização
### Basico
Para começar a utilizar o SmartPromo, você precisa inicializar com o `id` da campanha e configurar as suas `chaves de acesso`:

    val smartPromo = SmartPromo("{campaignID}")
    smartPromo.setupAccessKeyAndSecretKey("{accessKey}", "{secretKey}")
    
#### Iniciando a SDK no modo campanha:
    smartPromo.go({activity})
    
#### Iniciando a SDK no modo Scanner de notas:
    smartPromo.scan({consumerID}, {activity})
    
### Cor da campanha
Você pode definir qual cor utilizar na interface da campanha. Para isto basta utilizar a função `setColor(Int)`:

    val color = ContextCompat.getColor({context}, R.color.colorPrimary)
    smartPromo.setColor(color)
  
### Passando um consumidor
O SmartPromo gerencia o cadastro do consumidor por você, mas caso queira otimizar a experiência de uso, você pode informar para o SmartPromo o consumidor que está utilizando o aplicativo, através da função `setConsumer(FSConsumer)`: 

    smartPromo.setConsumer({FSPConsumer})  
  
Bom era isso! Esperamos que o tutorial seja útil e se tiver qualquer dúvida ou dica envie um email a nossa equipe developer@getmo.com.br, teremos o maior prazer em te auxiliar.
