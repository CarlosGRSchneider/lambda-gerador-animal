package animal;

import java.util.List;
import java.util.Random;

public class GeradorAnimal {

    private Random random = new Random();
    private final List<String> adjetivos = List.of(
            """
                    alegre curioso tranquilo rápido brincalhão atento inteligente gentil elegante perplexo sonolento fiel astuto amigável paciente educado corajoso campeiro ambicioso ninja
                    """.strip().replace("\n", " ").split("\\s+")
    );
    private final List<String> animais = List.of(
            """
                    Caranguejo Quati Suricato Elefante Leão Tigre Urso Lobo Panda Canguru Golfinho Ratão-do-banhado Pica-pau Gavião Coala Quero-quero Sapo Cachorro Gato Grilo
                    """.strip().replace("\n", " ").split("\\s+")
    );

    public String geraCombinacao() {

        String animal = animais.get(random.nextInt(animais.size()));
        String adjetivo = adjetivos.get(random.nextInt(adjetivos.size()));
        return animal + " " + adjetivo;
    }
}
