import java.util.Scanner;

// Definição da classe Modalidade
class Modalidade {
    private int codigo;
    private String modalidade;
    private int genero; // 0 para unisex, 1 para masc e 2 para feminino
    
    // Construtor
    public Modalidade(int codigo, String modalidade, int genero) {
        this.codigo = codigo;
        this.modalidade = modalidade;
        this.genero = genero;
    }
    
    // Métodos getters e setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
}

// Definição da classe Atleta
class Atleta {
    private String cpf;
    private String nome;
    private int genero; // 1 para masc e 2 para feminino
    private int idade;
    
    // Construtor
    public Atleta(String cpf, String nome, int genero, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
    }
    
    // Métodos getters e setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Inserir informações das modalidades
        System.out.println("Inserir informações das modalidades:");
        Modalidade[] modalidades = new Modalidade[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("Modalidade " + (i + 1) + ":");
            System.out.print("Código: ");
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Gênero (0 para unisex, 1 para masculino, 2 para feminino): ");
            int genero = scanner.nextInt();
            
            modalidades[i] = new Modalidade(codigo, nome, genero);
        }
        
        // Inserir informações dos atletas
        System.out.println("\nInserir informações dos atletas:");
        Atleta[] atletas = new Atleta[6]; // 3 atletas para cada modalidade
        for (int i = 0; i < 6; i++) {
            System.out.println("Atleta " + (i + 1) + ":");
            System.out.print("CPF: ");
            String cpf = scanner.next();
            scanner.nextLine(); // Limpar o buffer do teclado
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Gênero (1 para masculino, 2 para feminino): ");
            int genero = scanner.nextInt();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            
            // Verificar se a idade está dentro do intervalo permitido (7 a 21 anos)
            if (idade < 7 || idade > 21) {
                System.out.println("Idade inválida. O atleta deve ter entre 7 e 21 anos.");
                i--; // Para repetir a inserção dos dados do atleta
                continue;
            }
            
            atletas[i] = new Atleta(cpf, nome, genero, idade);
        }
        
        // Exibir informações das modalidades
        System.out.println("\nInformações das modalidades:");
        for (Modalidade modalidade : modalidades) {
            System.out.println("Código: " + modalidade.getCodigo());
            System.out.println("Nome: " + modalidade.getModalidade());
            String genero;
            switch (modalidade.getGenero()) {
                case 0:
                    genero = "Unissex";
                    break;
                case 1:
                    genero = "Masculino";
                    break;
                case 2:
                    genero = "Feminino";
                    break;
                default:
                    genero = "Desconhecido";
                    break;
            }
            System.out.println("Gênero: " + genero);
        }
        
        // Exibir informações dos atletas
        System.out.println("\nInformações dos atletas:");
        for (Atleta atleta : atletas) {
            if (atleta != null) {
                System.out.println("CPF: " + atleta.getCpf());
                System.out.println("Nome: " + atleta.getNome());
                String genero;
                switch (atleta.getGenero()) {
                    case 1:
                        genero = "Masculino";
                        break;
                    case 2:
                        genero = "Feminino";
                        break;
                    default:
                        genero = "Desconhecido";
                        break;
                }
                System.out.println("Gênero: " + genero);
                System.out.println("Idade: " + atleta.getIdade());
            }
        }
        
        scanner.close();
    }
}
