![Apache Groovy](https://img.shields.io/badge/Apache%20Groovy-4298B8.svg?style=for-the-badge&logo=Apache+Groovy&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Intellij Idea](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
# ZG-HERO Project trilha (K1—T11): Web Crawler

Projeto de um bot (robô)/Web Crawler para coletar dados do site do Governo na página da Agência Nacional de Saúde (ANS).

## Configuração do Projeto

Certifique-se de ter o JDK 17, Groovy 2.4.21+ e Gradle instalado em sua máquina. Você também precisará do Gradle para compilar e executar o projeto.

## Executando o Projeto

Para executar o projeto, use o seguinte comando:

```bash
./gradlew run --console plain
```

Certifique-se de ter todas as dependências corretamente configuradas no seu ambiente. O projeto depende das seguintes bibliotecas:

- Groovy All: 3.0.21
- HTTP Builder NG Core: 1.0.4
- SLF4J Simple Provider: 1.7.32
- Jsoup: 1.15.3
- Junit-jupiter-api: 5.9.0
- Junit-jupiter-engine: 5.9.0

Certifique-se de que essas dependências estejam disponíveis no classpath ao executar o projeto.

## Funcionalidades


- Baixar os aquivos da documentação do padrão TISS (Troca de Informações na Saúde Suplementar), na versão mais recente.
  Esses arquivos estão disponíveis no site do Governo no campo "Espaço do Prestador de Serviços de Saúde", baixe o componente de comunicação.
- Acessar o campo "Histórico das versões dos Componentes do Padrão TISS" e Coletar, na tabela, os dados de competência, publicação e início de vigência a partir da competência de data jan/2016; 
- Acessar o campo "Tabelas relacionadas" e baixar a "Tabela de erros no envio para a ANS".

---
## Autor
Álvaro Martinez Ferreira

## Licença
Este projeto está licenciado sob a Licença MIT.