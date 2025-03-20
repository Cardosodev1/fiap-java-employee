# Projeto de Gerenciamento de Funcionários

Este projeto implementa um sistema de gerenciamento de funcionários utilizando Java e JPA (Java Persistence API). Ele permite registrar, atualizar, remover e buscar informações de funcionários, além de calcular seus salários com bônus baseados em suas categorias (Junior, Pleno, Senior).

## Integrantes do Grupo

* Guilherme Cardoso dos Santos - RM555178
* João Pedro Motta - RM556557

## Estrutura do Projeto

O projeto é organizado nos seguintes pacotes:

* **br.com.fiap.dao:** Contém as classes de acesso a dados (DAOs) para a entidade `Employee`.
* **br.com.fiap.entity:** Contém as classes de entidade que representam os funcionários e suas categorias.
* **br.com.fiap.exception:** Contém as classes de exceção personalizadas.
* **br.com.fiap.view:** Contém a classe principal `EmployeeView` que demonstra o uso do sistema.

## Classes Principais

### `Employee`

* Classe base para todos os funcionários.
* Contém atributos como `id`, `firstName`, `lastName`, `hoursWorked` e `paidByHours`.
* Possui o método `calculateSalary()` para calcular o salário base.
* `printInformation()` imprime as informações do funcionario.

### `JuniorEmployee`, `PlenoEmployee`, `SeniorEmployee`

* Subclasses de `Employee` que representam diferentes categorias de funcionários.
* Cada categoria possui um bônus diferente por 15 horas trabalhadas.
* Sobrescrevem o método `calculateSalary()` para incluir o bônus.
* Sobrescrevem o método `printInformation()` para imprimir as informações do funcionario e o bonus.

### `EmployeeDao` e `IEmployeeDao`

* `EmployeeDao` implementa a interface `IEmployeeDao` e fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade `Employee`.
* `IEmployeeDao` é uma interface que declara os métodos para manipulação dos dados de funcionarios.

### `EmployeeView`

* Classe principal que demonstra o uso do sistema.
* Realiza operações de registro, busca, atualização e remoção de funcionários.
* Demonstra o uso das classes de exceção personalizadas.

## Simulações

### `Registro de Funcionario`
![image](https://github.com/user-attachments/assets/1d8caa06-8d1c-4211-88a0-95c41d5190bf)

### `Busca de Funcionário`
![image](https://github.com/user-attachments/assets/b35bf258-85e2-43ef-9d7b-884c80f7d2f0)

### `Atualização de Funcionário`
![image](https://github.com/user-attachments/assets/68b78260-420e-43d4-b330-e6d23578862b)

### `Remoção de Funcionário`
![image](https://github.com/user-attachments/assets/d14f8cbb-3631-4838-a5b6-440977e425df)

