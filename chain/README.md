## Chain of responsability

### Categoria
* Comportamental

### Explicação

É um padrão de projetos que define uma cadeia de processamentos, onde cada objeto de processamento
contém lógica que define o que ele pode manipular,  o restante é passado para o próximo objeto
de processamento.

É uma versão orientada a objeto do if...else...if....else

### Exemplo

Imaginando um sistema de compras, temos uma classe onde são criadas solicitações de compras:

```java
package com.felipedsr.chain;
 
 public class RequisicaoCompra {
 
     private final long valor;
     private final String descricao;
 
     public RequisicaoCompra(long valor, String descricao) {
         this.valor = valor;
         this.descricao = descricao;
     }
 
     public long getValor() {
         return valor;
     }
 
     public String getDescricao() {
         return descricao;
     }
 
 }
```

Em seguida temos a classe gestor, responsável por processar a análise de solicitação de compra:

```java
package com.felipedsr.chain;

public abstract class Gestor {

    private final long limite;
    private final Gestor sucessor;
    private final String cargo;

    public Gestor(long limite, Gestor sucessor, String cargo) {
        this.limite = limite;
        this.sucessor = sucessor;
        this.cargo = cargo;
    }

    public void processar(RequisicaoCompra compra) {
        if (compra.getValor() <= limite) {
            System.out.println(String.format("%s aprovou a compra no valor de %d", cargo, compra.getValor()));
        } else if (sucessor != null) {
            sucessor.processar(compra);
        } else {
            throw new CompraNaoAprovadaException("Compra não aprovada");
        }
    }
}
```

Os cargos a seguir extendem da classe gestor, onde informam o limite que pode conceder, o superior imediato e o cargo:

```java
package com.felipedsr.chain;

public class Diretor extends Gestor {
    public Diretor(long limite, Gestor sucessor, String cargo) {
        super(limite, sucessor, cargo);
    }
}
```

```java
package com.felipedsr.chain;

public class Presidente extends Gestor {
    public Presidente(long limite, Gestor sucessor, String cargo) {
        super(limite, sucessor, cargo);
    }
}
```

```java
package com.felipedsr.chain;

public class VicePresidente extends Gestor {

    public VicePresidente(long limite, Gestor sucessor, String cargo) {
        super(limite, sucessor, cargo);
    }
}
```

Para executar:

```java
package com.felipedsr.chain;

public class Program {

    public static void main(String[] args) {
        Presidente presidente = new Presidente(300, null, "Presidente");
        VicePresidente vicePresidente = new VicePresidente(200, presidente, "Vice Presidente");
        Diretor diretor = new Diretor(100, vicePresidente, "Diretor");
        RequisicaoCompra compra = new RequisicaoCompra(350, "Computador");
        diretor.processar(compra);
    }
}
```