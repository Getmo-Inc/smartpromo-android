# SmartPromo Android
O SmartPromo é uma SDK para envio de notas em campanhas promocionais, compatível com Android API 21+

## Instalação
### Gradle
SmartPromo pode ser adicionado no seu projeto `Android` utilizando o `Gradle`, para isto adicione a dependência abaixo ao arquivo `build.gradle` a nível de `módulo`:

    implementation 'br.com.getmo:smartpromo:2.6.4'
    
Verifique se está usando a versão 1.9 ou superior do Google Material Design:
    
    implementation com.google.android.material:material:1.9.0
    
Para finalizar, você precisa adicionar a compatibilidade com o Java 8 no `build.gradle` no seu modulo:

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

## Utilização
### Basico
Para começar a utilizar o SmartPromo, você precisa configurar as suas `chaves de acesso`:

    val smartPromo = SmartPromo()
    smartPromo.setupAccessKeyAndSecretKey("{accessKey}", "{secretKey}")
    
#### Iniciando a SDK no modo campanha única:
    smartPromo.go("{campaignID}", {activity})

    
#### Iniciando a SDK no modo de múltiplas campanhas:
    smartPromo.goMulti(
        headnote = "{Headnote}",
        title = "{Title}",
        message = "{Message}",
        above = {activity}
    )


#### Iniciando a SDK no modo Scanner de notas:
    smartPromo.scan(campaignID = "{campaignID}", consumerID = "{consumerID}", {activity})


### Configurações Extas
É necessário realizar todas as configurações antes de iniciar a SDK.


#### Homologação
Caso queira, você pode utilizar o ambiente de homologação para realizar seus testes. Para isso basta utilizar a função:

    smartPromo.setIsHomolog(true)
    
    
#### Cor da campanha
Você pode definir qual cor utilizar na interface da campanha. Para isto basta utilizar a função `setColor(Int)`:

    val color = ContextCompat.getColor({context}, R.color.colorPrimary)
    smartPromo.setColor(color)
  
#### Passando um consumidor
O SmartPromo gerencia o cadastro do consumidor por você, mas caso queira otimizar a experiência de uso, você pode informar para o SmartPromo o consumidor que está utilizando o aplicativo, através da função `setConsumer(FSConsumer)`: 

    smartPromo.setConsumer({FSPConsumer})  

#### Metadata
O SmartPromo também oferece a capacidade de inserir informações em um campo genérico que pode ser utilizado para diversos fins. Para fazer isso, utilizamos a seguinte função:
    
    smartPromo.setMetadata("Qualquer coisa como String")


  
    
Bom era isso! Esperamos que o tutorial seja útil e se tiver qualquer dúvida ou dica envie um email a nossa equipe developer@getmo.com.br, teremos o maior prazer em te auxiliar.

## Possíveis Problemas 
### Não funciona em Release - Proguard
Dependendo da configuração do seu projeto, o Android pode ofuscar alguns arquivos, o que pode gerar um problema para a nossa SDK. 
Caso você esteja com problemas apenas quando compila como release ou quando gera o .apk de produção, você pode estar tendo este problema.
Para resolver siga esses passos:
1. Adicione essa linha no seu arquivo `proguard-rules.pro` que fica a nível de módulo:
```
-keep class br.com.getmo.smartpromo.** { *; }
```
2. Caso não tenha este arquivo, basta criá-lo dentro do módulo do app.
3. Confira se esse arquivo está sendo utilizado dentro do build.gradle do módulo:
```
    buildTypes {
        release {
            ...
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
```
