
import java.security.KeyStore.TrustedCertificateEntry
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    print("Digite uma palavra: ")
    var palavra = readLine()!!
    print("Digite a dica da palavra: ")
    var dica = readLine()!!

    var forca = JogoDaForca(palavra, dica)
    forca.start()

    while (true) {
        print("Digite uma letra: ")
        var letra = readLine()!!

        try {
            forca.Adivinhar(letra)
            println("Dica: " + forca.getDica())
            println(forca.getPalavra())
            println(" Quantidade de letras: " + forca.getTamanho() + " Quantidade de letras distintas: " + forca.LetrasDistintas())
            println(" Quantidade de Acertos: " + forca.getAcertos() + " Quantidade de tentativas: " + forca.getTentativas())
            println("Letras já usadas: " + forca.getLetrasUsadas())

            if (forca.terminou()) {
                if (forca.getAcertos() == forca.getTamanho()) {
                    print("Ganhou!")
                    break
                } else if (forca.getTentativas() == 0) {
                    print("Perdeu, poxa vida")
                    break
                }
            }
        }
        catch (e: Throwable) {
            print(e.message)
        }
    }
}