// Arquivo: IngressoVIP.java
public class IngressoVIP extends Ingresso {
    private float valorAdicional;

    public IngressoVIP(float valor, float valorAdicional) {
        super(valor);
        this.valorAdicional = valorAdicional;
    }

    public float getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(float valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    @Override
    public String toString() {
        return "Valor do ingresso VIP: " + (getValor() + valorAdicional);
    }
}
