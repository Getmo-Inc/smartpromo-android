# SmartPromo
O SmartPromo é uma SDK para envio de notas em campanhas promocionais. 

## Instalação
### Gradle
SmartPromo pode ser adicionado no seu projeto `Android` utilizando o `Gradle`, para isto basta adicionar a linha a seguir no seu arquivo `build.gradle`:

    implementation 'org.bitbucket.getmo:android-smartpromo:1.1.0'
    
   
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
    
Depois é só disparar a função `go` passando uma `Activity` que tudo começa:

    smartPromo.go({activity})
    
### Cor da campanha
Você pode definir qual cor utilizar na interface da campanha. Para isto basta utilizar a função `setColor(Int)`:

    smartPromo.setColor({Int})
  
### Passando um consumidor
O SmartPromo gerencia o cadastro do consumidor por você, mas caso queira otimizar a experiência de uso, você pode informar para o SmartPromo o consumidor que está utilizando o aplicativo, através da função `setConsumer(FSConsumer)`: 

    smartPromo.setConsumer({FSPConsumer})

  
  
Bom era isso! Esperamos que o tutorial seja útil e se tiver qualquer dúvida ou dica envie um email a nossa equipe developer@getmo.com.br, teremos o maior prazer em te auxiliar.
