// Arquivo: TesteIngresso.java
public class TesteIngresso {
    public static void main(String[] args) {
        Ingresso ingresso = new Ingresso(50.0f);
        IngressoVIP ingressoVIP = new IngressoVIP(50.0f, 20.0f);

        System.out.println(ingresso);
        System.out.println(ingressoVIP);
    }
}
