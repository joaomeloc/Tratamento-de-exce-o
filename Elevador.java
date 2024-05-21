public class Elevador {
    int capacidade;
    int totalAndares;
    int andarAtual;
    int numPessoas;

    public Elevador(int capacidade, int totalAndares) {
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0;
        this.numPessoas = 0;
    }

    public void entrar() {
        try {
            if (numPessoas < capacidade) {
                numPessoas++;
                System.out.println("Uma pessoa entrou no elevador.");
            } else {
                throw new IllegalStateException("O elevador está lotado.");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sair() {
        try {
            if (numPessoas > 0) {
                numPessoas--;
                System.out.println("Uma pessoa saiu do elevador.");
            } else {
                throw new IllegalStateException("O elevador está vazio.");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void subir() {
        try {
            if (andarAtual < totalAndares) {
                andarAtual++;
                System.out.println("Elevador subiu para o andar " + andarAtual);
            } else {
                throw new IllegalStateException("O elevador está no último andar.");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void descer() {
        try {
            if (andarAtual > 0) {
                andarAtual--;
                System.out.println("Elevador desceu para o andar " + andarAtual);
            } else {
                throw new IllegalStateException("O elevador está no térreo.");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}