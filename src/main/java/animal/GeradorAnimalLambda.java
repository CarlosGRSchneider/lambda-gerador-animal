package animal;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GeradorAnimalLambda implements RequestHandler<Void, String> {

    private final GeradorAnimal geradorAnimal = new GeradorAnimal();
    private final double taxaDeErro;

    public GeradorAnimalLambda() {
        String taxaDeErroEnv = System.getenv("TAXA_DE_ERRO");
        this.taxaDeErro = taxaDeErroEnv != null ? Double.parseDouble(taxaDeErroEnv) : 0.0;
    }

    @Override
    public String handleRequest(Void input, Context context) {
        context.getLogger().log("TAXA_DE_ERRO: " + taxaDeErro);

        if (Math.random() < taxaDeErro) {
            context.getLogger().log("Gerando erro na função.");
            throw new RuntimeException("Erro simulado.");
        }

        String combinacao = geradorAnimal.geraCombinacao();
        context.getLogger().log("Combinação animal gerada: " + combinacao);
        return combinacao;
    }
}
