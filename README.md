# 🚀 Uniguaçu Application

Este repositório contém a aplicação Uniguaçu, desenvolvida em **Java 21** e **Spring Boot**. Siga as instruções abaixo para configurar o seu ambiente de desenvolvimento.

---

## 🛠️ Configuração do Banco de Dados (PostgreSQL)

O projeto utiliza o PostgreSQL para persistência de dados.

1. **Criar a Base de Dados**:
   - Abra o **pgAdmin**.
   - Crie um novo banco de dados com o nome: `db_uniguacu`.

2. **Configurar Credenciais**:
   - Navegue até o ficheiro: `src/main/resources/application.properties`.
   - Preencha as propriedades com as suas credenciais locais:
     ```properties
     spring.datasource.username=seu_usuario
     spring.datasource.password=sua_senha
     ```

---

## ☕ Configuração do Ambiente (SDK)

É obrigatório o uso do **Java 21**. Para configurar no IntelliJ IDEA:

1. Abra a estrutura do projeto: `Ctrl + Alt + Shift + S` (ou **File > Project Structure**).
2. No menu **Project**, verifique o campo **SDK**:
   - Se não tiver o Java 21: Clique em **Add SDK** > **Download JDK**.
   - Escolha a versão **21** (Recomendado: *Eclipse Temurin* ou *Oracle*).
3. Certifique-se de que o **Language level** está definido como **21**.

### 🐘 Sincronização do Gradle
Caso encontre problemas de compilação, valide a Toolchain do Gradle:
1. Vá a **File > Settings** (`Ctrl + Alt + S`).
2. Navegue até: `Build, Execution, Deployment > Build Tools > Gradle`.
3. No campo **Gradle JVM**, selecione o **Project SDK (21)**.

---

## 🏃 Como Executar

1. Localize a classe principal:  
   `src/main/java/com/uniguacu/UniguacuApplication.java`.
2. Clique com o botão direito e selecione **Run 'UniguacuApplication'**.
3. **Validar Execução**:
   Abra o navegador e aceda a: [http://localhost:8080/api/test](http://localhost:8080/api/test)

---

## 📖 Documentação da API

A documentação interativa (Swagger/OpenAPI) está disponível para facilitar o teste dos endpoints:

🔗 **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

> [!IMPORTANT]
> Certifique-se de que o serviço do PostgreSQL está ativo antes de iniciar a aplicação Spring Boot.
