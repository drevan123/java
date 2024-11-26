// Arquivo: TesteEmpregado.java
public class TesteEmpregado {
    public static void main(String[] args) {
        Empregado empregado = new Empregado("João", 2000.0f);
        Gerente gerente = new Gerente("Maria", 3000.0f, "RH");
        Vendedor vendedor = new Vendedor("Carlos", 1500.0f, 5.0f);

        System.out.println(empregado);
        System.out.println(gerente);
        System.out.println(vendedor);
    }
}
