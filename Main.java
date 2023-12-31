import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.nio.file.Path;

import java.util.List;

public class Main {
    
    public static void main(String args[])
        throws IOException {
            Path path = Paths.get("br-utf8.txt");
            List<String> lista = Files.readAllLines(path);
            List<String> palavrasValidas = new ArrayList<>();
            for(var linha: lista){
                if(linha.length() == 5){
                    String palavrasSemAcento = removerAcentos(linha);
                    palavrasValidas.add(palavrasSemAcento);
                }
            }
            Random random = new Random();
            int numeroAleatorio = random.nextInt(palavrasValidas.size() + 1);

            String palavraAleatoria = palavrasValidas.get(numeroAleatorio);

            char[] arrayDeLetras = new char[palavraAleatoria.length()];

            for (int i = 0; i < palavraAleatoria.length(); i++) {
                arrayDeLetras[i] = palavraAleatoria.charAt(i);
            }

            for (char letra : arrayDeLetras) {
                System.out.println(letra);
            }

            System.out.println(arrayDeLetras[0]);
    }
    public static String removerAcentos(String texto) {
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern padrao = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return padrao.matcher(textoNormalizado).replaceAll("");
    }
}