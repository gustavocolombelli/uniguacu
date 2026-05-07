Para configurar a conexão com o banco de dados PostgreSQL

1. Crie um banco de dados utilizando Pgadmin chamado db_uniguacu
2. No arquivo src/main/resources/application.properties dete projeto
   2.1 Preencha username do seu banco de dados
   2.2 Preencha password do seu banco de dados
3. Configurar o SDK do Projeto: Garanta que o IntelliJ saiba que o projeto deve usar o Java 21.
    3.1. Pressione Ctrl + Alt + Shift + S (ou vá em File > Project Structure).
    3.2. Na aba Project, procure por SDK.
    3.3. Se o Java 21 não estiver na lista:•Clique em Add SDK > Download JDK.•Selecione a versão 21 (recomendo a Vendor Oracle ou Eclipse Temurin).
    3.4. Certifique-se de que o Language level também esteja definido como 21.
4. Verificar as configurações do IntelliJ
   Às vezes, o IntelliJ não sincroniza corretamente as configurações de Toolchain do Gradle. 
   Siga os seguintes passos:
     3.1. Vá em File > Settings (ou Ctrl+Alt+S).
     3.2. Navegue até Build, Execution, Deployment > Build Tools > Gradle.
     3.3. Verifique o campo Gradle JVM. Certifique-se de que ele está apontando para um JDK válido (preferencialmente o JDK 21 ou o "Project SDK").
     3.4. Vá em File > Project Structure (ou Ctrl+Alt+Shift+S). 
     3.5. Em Project, verifique se o SDK está definido como Java 21.
5. Executando o projeto
    No arquivo src/main/java/com/uniguacu/UniguacuApplication.java clique com o botão direito sobre o arquivo
    e execute "Run"
    Abra seu navegador e coloque a url: http://localhost:8080/api/test

6. Acessando a documentação Swagger da API
   Para acessar as informações da API do sistema sendo desenvolvido, você pode acessar a documentação
   gerada automaticamente pela springdoc-openapi, acesse a url: http://localhost:8080/swagger-ui.html