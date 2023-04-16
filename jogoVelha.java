import java.util.Scanner;
import java.util.Random;
public class jogoVelha {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String jogador1=null, jogador2=null;
    int vitoriasJog1 = 0, vitoriasJog2 = 0, empates = 0;
    boolean jogarNovamente = true;
    boolean jogadaValida = true;
    String Jogador = null;
    System.out.println("---- JOGO DA VELHA ----");
    System.out.println();
    System.out.println("Digite o nome do jogador 1: ");
    jogador1 = scanner.nextLine();
    System.out.println("Digite o nome do jogador 2: ");
    jogador2 = scanner.nextLine();
    Random rand = new Random();


    while (jogarNovamente) {
    char[][] tabuleiro = new char[3][3]; // matriz que representa o tabuleiro
    char jogadorAtual = rand.nextInt(2) == 0 ? 'X': 'O'; // jogador que começa o jogo
    boolean jogoAcabou = false; // variável para verificar se o jogo acabou
    int jogadas = 0;
   
    
    // preenche o tabuleiro com espaços vazios
    for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
    tabuleiro[i][j] = ' ';
    }
    }
    
    while (!jogoAcabou) {
    imprimeTabuleiro(tabuleiro);
    if(jogadorAtual == 'X'){
        Jogador = jogador1;
    }else{
        Jogador = jogador2;
    }
    
    System.out.println(jogadorAtual + " é a sua vez " + Jogador + " . Insira as coordenadas da jogada (linha coluna): ");
    int linha = scanner.nextInt();
    int coluna = scanner.nextInt();
    
    // realiza a jogada caso a posição esteja vazia e dentro dos limites do tabuleiro
    while (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != ' ') {
        System.out.println("Posição inválida, tente novamente.");
        System.out.println("Insira as coordenadas da jogada (linha coluna): ");
        jogadaValida = true;
        linha = scanner.nextInt();
        coluna = scanner.nextInt();
        
    }
    tabuleiro[linha][coluna] = jogadorAtual;
    jogadas++;
    
    // verifica se o jogador atual ganhou
    if (verificaGanhador(tabuleiro, jogadorAtual)) {
    System.out.println(jogadorAtual +", " + Jogador + " venceu!");
    jogoAcabou = true;
    
    // conta a vitória do jogador e atualiza o jogador atual
    if (jogadorAtual == 'X') {
    vitoriasJog1++;
    jogadorAtual = 'O';
    } else {
    vitoriasJog2++;
    jogadorAtual = 'X';
    }
    } else if (jogadas == 9) {
    // verifica se o jogo já acabou com empate
    System.out.println("Empate!");
    jogoAcabou = true;
    empates++;
    } else {
    // troca o jogador atual
    if (jogadorAtual == 'X') {
    jogadorAtual = 'O';
    } else  {
    jogadorAtual = 'X';
    }
    
    }
    }
    
    // pergunta se quer jogar novamente
    System.out.println("Deseja jogar novamente? (S/N)");
    String resposta = scanner.next();
    
    if (resposta.equalsIgnoreCase("N")) {
    jogarNovamente = false;
    scanner.close();
    if (resposta.equalsIgnoreCase("S"))
    jogarNovamente = true;
    scanner.close();
    }
    
    
    // exibe o placar final
    System.out.println("--- PLACAR FINAL ---");
    System.out.println(jogador1 + ": " + vitoriasJog1 + " vitórias");
    System.out.println(jogador2 + ": " + vitoriasJog2 + " vitórias");
    System.out.println("Empates: " + empates);
        }
    }
    
    
    public static boolean verificaGanhador(char[][] tabuleiro, char jogador) {
    // verifica linhas e colunas
    for (int i = 0; i < 3; i++) {
    if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador)
    return true;
    if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)
    return true;
    }
    
    // verifica diagonais
    if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador)
    return true;
    if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)
    return true;

    return false;
    
}
    
        public static void imprimeTabuleiro(char[][] tabuleiro) {
            System.out.println("   0   1   2");
            System.out.println("0  " + tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
            System.out.println("  ---+---+---");
            System.out.println("1  " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
            System.out.println("  ---+---+---");
            System.out.println("2  " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);
        }
        
        
    
}
    

    


    
