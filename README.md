# Sistema de hierarquias de classes - Veículos

|           NOME           |  RM   |
| :----------------------: | :---: |
| Kaiky Alvaro de Miranda  | 98118 |

---

# Desafio 

- O objetivo é criar um sistema de gerenciamento de veículos em Java, com uma classe base chamada Veiculo e subclasses para diferentes tipos de veículos, como Carro, Moto e Caminhão.
  
### Classe Base Veiculo:
- Deve conter atributos como marca, modelo, ano, velocidade máxima e velocidade atual.
- Implementa métodos para acelerar, reduzir a velocidade e obter o status do veículo.

### Subclasses:

#### Carro:
- Além dos atributos da classe base, inclui funcionalidade para controle do ar-condicionado.

#### Moto:
- Implementa a funcionalidade de empinar a moto em determinadas condições de velocidade.

#### Caminhão:
- Permite o transporte de cargas, verificando a capacidade de carga do veículo.

#### Classe Principal:
- Demonstração do uso do sistema.
- Instancia objetos de cada tipo de veículo.
- Demonstração das funcionalidades, como acelerar, reduzir velocidade e exibir status.

# Funcionamento do projeto

O sistema se baseia em exibir informações de veículos como carro, moto e caminhão. Dessa forma, o usuário coloca as informações necessárias e elas são exibidas no terminal. 

Além disso, existe algumas restrições, como métodos de aceleração e desasceleração, permitindo com que o veículo acelere até a sua velocidade máxima. Caso seja a velocidade máxima seja ultrapassada, o método desacelerar é chamado e ele permite que o veículo não ultrapasse a velocidade. 

Outro ponto, é que para cada veículo existe um tipo de método específico para ela. No carro, existe os métodos de ligar e desligar o ar-condicionado, na moto, temos o método de empinar a moto quando a velocidade estiver entre 20 km/h e 50 km/h, já no caminhão, existe o método que verifica o peso da carga e se está pesado ou não. 

## Desvendando o código passo a passo

### Main.java

```Java
import br.fiap.turmaw.domain.vehicle.MenuVehicle;

public class Main {
    public static void main(String[] args) {
        MenuVehicle.menuVehicles();
    }
}
```

- No arquivo de Main.java, não colocamos nenhuma lógica complexa, apenas estamos o utilizando como inicializador.
  
## VehicleAtribute.java

- Primeiro, iremos criar uma classe como os atributos em comum com os veículos em geral, de modo que possamos passar esses atributos como herança.
```Java
package br.fiap.turmaw.domain.vehicle.vehicles;

public class VehicleAtribute {
    private String brand;
    private String model;
    private int year;
    private int maxSpeed;
    private int currentSpeed;

    public VehicleAtribute(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    //Methods
    public int accelerate(int increment) {
        if (currentSpeed + increment > maxSpeed) {
            currentSpeed = maxSpeed;
        } else {
            currentSpeed += increment;
        }
        return increment;
    }

    public int reduceSpeed(int decrement) {
        if (currentSpeed - decrement < 0) {
            currentSpeed = 0;
        } else {
            currentSpeed -= decrement;
        }
        return decrement;
    }

    public void getStatus() {
        System.out.println("Marca: " + brand);
        System.out.println("Modelo: " + model);
        System.out.println("Ano: " + year);
        System.out.println("Velocidade Máxima: " + maxSpeed + " km/h");
        System.out.println("Velocidade Atual: " + currentSpeed + " km/h");
    }

    //Getters and Setters
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
```
### Atributos:
- brand: Uma string que armazena a marca do veículo.
- model: Uma string que armazena o modelo do veículo.
- year: Um inteiro que armazena o ano de fabricação do veículo.
- maxSpeed: Um inteiro que representa a velocidade máxima do veículo.
- currentSpeed: Um inteiro que representa a velocidade atual do veículo.

### Construtor:
- O construtor VehicleAtributes recebe os parâmetros brand, model e year para inicializar os atributos correspondentes.

### Métodos:
- accelerate(int increment): Aumenta a velocidade atual do veículo em um valor especificado (increment), garantindo que não ultrapasse a velocidade máxima definida.
- reduceSpeed(int decrement): Reduz a velocidade atual do veículo em um valor especificado (decrement), garantindo que não seja inferior a zero.
- getStatus(): Imprime na saída padrão os atributos do veículo, incluindo marca, modelo, ano, velocidade máxima e velocidade atual.
- Getters e Setters:
- getMaxSpeed(): Retorna a velocidade máxima do veículo.
- setMaxSpeed(int maxSpeed): Define a velocidade máxima do veículo.
- getCurrentSpeed(): Retorna a velocidade atual do veículo.
- setCurrentSpeed(int currentSpeed): Define a velocidade atual do veículo.

## Car.java

- Com os atributos dos veículos feito, podemos utilizar para o carro agora. Além de criar os métodos necessários específicos do carro.

```Java
package br.fiap.turmaw.domain.vehicle.vehicles;

public class Car extends VehicleAtribute {
    private boolean airConditioningOn;
    private boolean carOn;

    public Car(String brand, String model, int year){
        super(brand, model, year);
        setMaxSpeed(180);
        setCurrentSpeed(100);
    }
    public boolean isCarOn () {
        if (getCurrentSpeed() == 0 ){
            System.out.println("Ar Condicionado e o carro estão desligados");
            return carOn == false && airConditioningOn == false;
        }
        System.out.println("Ar Condicionado: ligado");
        return true;
    }
}

```

### Atributos:
- airConditioningOn: Um booleano que indica se o carro possui ar-condicionado ou não.
- carON: Um booleano que indica se o carro está ligado ou não.

### Construtor:
- O construtor Car recebe os parâmetros brand, model e year para inicializar os atributos correspondentes da classe pai VehicleAtributes. Ele também define a velocidade máxima como 180 km/h e a velocidade atual como 100 km/h, além de inicializar o ar-condicionado como desligado.

### Métodos:
- isCarOn: método que verifica se o carro está ligado ou não. Se o carro estiver desligado, isto é, velocidade igual a 0, o carro e nem o ar-condicionado estará ligado. Caso contrário, ou seja, em movimento,  o carro e o ar-condicionado estará ligado
  
### Uso:
- Para utilizar a classe Car, é necessário instanciar um objeto Car com os valores específicos de marca, modelo e ano do carro. Em seguida, o método de verificar se o carro está ligado ou não deve ser chamado.

## Motorcycle.java

- O mesmo arquivo que criamos para carro, agora faremos com o da moto.

```Java
package br.fiap.turmaw.domain.vehicle.vehicles;

public class Motorcycle extends VehicleAtribute {
    public Motorcycle(String brand, String model, int year) {
        super(brand, model, year);
        setMaxSpeed(120);
        setCurrentSpeed(40);
    }

    public void wheelie() {
        if (getCurrentSpeed() > 20 && getCurrentSpeed() < 50) {
            System.out.println("Moto empinada!");
        } else {
            System.out.println("Não é possível empinar a moto nesta velocidade.");
        }
    }
}
```
### Construtor:
- O construtor Motorcycle recebe os parâmetros brand, model e year para inicializar os atributos correspondentes da classe pai VehicleAtributes. Ele também define a velocidade máxima como 120 km/h e a velocidade atual como 40 km/h.

### Métodos:
- wheelie(): Verifica se a velocidade atual da motocicleta está dentro de um intervalo específico (entre 20 e 50 km/h). Se estiver, imprime a mensagem "Moto empinada!". Caso contrário, imprime "Não é possível empinar a moto nesta velocidade.".

### Uso:
- Para utilizar a classe Motorcycle, é necessário instanciar um objeto Motorcycle com os valores específicos de marca, modelo e ano da motocicleta. Em seguida, o método wheelie() pode ser chamado para tentar fazer um "empinada" (wheelie) na motocicleta, dependendo da velocidade atual.

## Truck.java

- O mesmo arquivo que criamos para carro e moto, agora faremos com o do caminhão.

```Java
package br.fiap.turmaw.domain.vehicle.vehicles;

public class Truck extends VehicleAtribute {
    public Truck(String brand, String model, int year) {
        super(brand, model, year);
        setMaxSpeed(100);
        setCurrentSpeed(70);
    }

    public void transportCargo(double cargo) {
        if (cargo <= 1.0) {
            System.out.println("Carga de " + cargo + " toneladas transportada.");
        } else {
            System.out.println("Carga muito pesada para este caminhão.");
        }
    }
}
```
### Construtor:
- O construtor Truck recebe os parâmetros brand, model e year para inicializar os atributos correspondentes da classe pai VehicleAtributes. Ele também define a velocidade máxima como 100 km/h e a velocidade atual como 70 km/h.

### Métodos:
-transportCargo(double cargo): Verifica se o peso da carga especificada (cargo) é menor ou igual a 1.0 toneladas. Se for, imprime a mensagem indicando a carga transportada. Caso contrário, imprime "Carga muito pesada para este caminhão".

### Uso:
Para utilizar a classe Truck, é necessário instanciar um objeto Truck com os valores específicos de marca, modelo e ano do caminhão. Em seguida, o método transportCargo(double cargo) pode ser chamado para transportar uma carga, passando o peso da carga como parâmetro. Ele informará se a carga foi transportada com sucesso ou se é muito pesada para o caminhão.


## MenuVehicle.java

- Agora que definimos os atributos e passa-los como herança, podemos agora usar os veículos e integrá-los em um menu que será chamado na Main, como mostrado no início. 
```Java
package br.fiap.turmaw.domain.vehicle;

import br.fiap.turmaw.domain.vehicle.vehicles.Car;
import br.fiap.turmaw.domain.vehicle.vehicles.Motorcycle;
import br.fiap.turmaw.domain.vehicle.vehicles.Truck;

public class MenuVehicle {
    public static void menuVehicles() {
        int speed;

        System.out.println("""
                --------------------
                Informações do carro:
                """);
        Car car = new Car("Ford", "Focus", 2020);
        car.getStatus();
        System.out.println("""
                ----------------------------------
                Status do carro depois de acelerar ou
                desacelerar e ligar o ar-condicionado:
                ----------------------------------""");
        speed = 100; //valor de aceleração ou desaceleração
        //car.accelerate(speed);
        car.reduceSpeed(speed);
        car.isCarOn();
        car.getStatus();

        //#######################################################################//

        System.out.println("""
                --------------------
                Informações da moto:
                """);
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR 1000", 2022);
        motorcycle.getStatus();
        System.out.println("""
                ----------------------------------
                Status da moto depois de acelerar e 
                verificar se é possível empinar ou não:
                ----------------------------------""");
        speed = 9;
        motorcycle.accelerate(speed);
        //motorcycle.reduceSpeed(speed);
        motorcycle.wheelie();
        motorcycle.getStatus();

        //#######################################################################//

        System.out.println("""
                ------------------------
                Informações do caminhão: 
                """);

        Truck truck = new Truck("Scania", "R500", 2019);
        truck.getStatus();
        System.out.println("""
                ----------------------------------
                Status do caminhão depois de acelerar
                e verificar o tamanho da carga:
                ----------------------------------""");
        speed = 10;
        truck.accelerate(speed);
        //truck.reduceSpeed(speed);
        truck.transportCargo(0.5);
        truck.getStatus();
    }
}
```
- A classe MenuVehicles contém um método estático menuVehicles() que demonstra o uso das classes de veículos: Car, Motorcycle e Truck, simulando diferentes interações com cada tipo de veículo.

### Método menuVehicles():
- Este método inicia a execução do programa e demonstra interações com os diferentes tipos de veículos.

### Interagindo com o carro:
- Um objeto da classe Car é criado representando um carro da marca Ford, modelo Focus, fabricado em 2020.
- O status do carro é exibido.
- O carro é acelerado ou desacelerado em 100 km/h, dependendo da escolha do usuário. 
- O novo status do carro, incluindo o estado do ar-condicionado, é exibido.

### Interagindo com a moto:
- Um objeto da classe Motorcycle é criado representando uma moto da marca Honda, modelo CBR 1000, fabricada em 2022.
- O status da moto é exibido.
- A moto é acelerada em 9 km/h e é verificado se é possível empinar.
- O novo status da moto é exibido.

### Interagindo com o caminhão:
- Um objeto da classe Truck é criado representando um caminhão da marca Scania, modelo R500, fabricado em 2019.
- O status do caminhão é exibido.
- O caminhão é acelerado em 10 km/h e é verificado o tamanho da carga a ser transportada (1.5 toneladas).
- O novo status do caminhão é exibido.

### Uso:
- Para utilizar a classe MenuVehicles, basta chamar o método estático menuVehicles(), que executa as interações com os diferentes tipos de veículos e exibe os resultados.

# Resultado:

-Desse modo, podemos rodar a Main e as informações irão ser exibidas no terminal.

### Carro
![image](https://github.com/kaikyalvaro1708/vehicle_hierarchy/assets/126626704/7686b267-3d3e-4e7d-a8ad-91c11c060843)

### Moto
![image](https://github.com/kaikyalvaro1708/vehicle_hierarchy/assets/126626704/15d0751b-bc1b-46f8-b539-3ab178687e8c)

### Caminhão
![image](https://github.com/kaikyalvaro1708/vehicle_hierarchy/assets/126626704/c2711cfb-7a3b-412a-8a2d-5062dace9c16)

