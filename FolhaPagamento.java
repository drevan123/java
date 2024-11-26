import java.util.ArrayList;
import java.util.List;

abstract class Funcionario {
    private String nome;
    private int numeroRegistro;

    public Funcionario(String nome, int numeroRegistro) {
        this.nome = nome;
        this.numeroRegistro = numeroRegistro;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public abstract float calcularSalario();
}

class Chefe extends Funcionario {
    private float salarioBase;
    private float adicionalFuncao;
    private float beneficioTerno;

    public Chefe(String nome, int numeroRegistro, float salarioBase, float adicionalFuncao, float beneficioTerno) {
        super(nome, numeroRegistro);
        this.salarioBase = salarioBase;
        this.adicionalFuncao = adicionalFuncao;
        this.beneficioTerno = beneficioTerno;
    }

    public float calcularSalario() {
        return salarioBase + (salarioBase * adicionalFuncao / 100) + beneficioTerno;
    }
}

class Comissionado extends Funcionario {
    private float salarioBase;
    private float comissao;

    public Comissionado(String nome, int numeroRegistro, float salarioBase, float comissao) {
        super(nome, numeroRegistro);
        this.salarioBase = salarioBase;
        this.comissao = comissao;
    }

    public float calcularSalario() {
        return salarioBase + (salarioBase * comissao / 100);
    }
}

class Horista extends Funcionario {
    private float valorHora;
    private int numeroHoras;

    public Horista(String nome, int numeroRegistro, float valorHora, int numeroHoras) {
        super(nome, numeroRegistro);
        this.valorHora = valorHora;
        this.numeroHoras = numeroHoras;
    }

    public float calcularSalario() {
        return valorHora * numeroHoras;
    }
}

class Empreiteiro extends Funcionario {
    private float valorEmpreita;

    public Empreiteiro(String nome, int numeroRegistro, float valorEmpreita) {
        super(nome, numeroRegistro);
        this.valorEmpreita = valorEmpreita;
    }

    public float calcularSalario() {
        return valorEmpreita;
    }
}

public class FolhaPagamento {
    public static void main(String[] args) {
        // Criando uma lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Chefe("João", 1, 5000, 10, 500));
        funcionarios.add(new Comissionado("Maria", 2, 3000, 5));
        funcionarios.add(new Horista("Pedro", 3, 20, 80));
        funcionarios.add(new Empreiteiro("Carlos", 4, 2000));

        // Gerando os recibos de pagamento
        System.out.println("Recibos de Pagamento:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Número de Registro: " + funcionario.getNumeroRegistro());
            System.out.println("Salário: " + funcionario.calcularSalario());
            System.out.println("-----------------------------------------");
        }
    }
}
