package br.com.carros.icarros;

import br.com.carros.icarros.exceptions.NotFoundException;
import br.com.carros.icarros.interfaces.Conversor;
import br.com.carros.icarros.menu.Apresentacao;
import br.com.carros.icarros.models.Especificacoes;
import br.com.carros.icarros.models.Veiculos;
import br.com.carros.icarros.services.ConsultaFIPE;
import br.com.carros.icarros.services.Serializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class IcarrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IcarrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			Apresentacao apresentacao = new Apresentacao();
			ConsultaFIPE service = new ConsultaFIPE();
			Conversor conversor = new Serializer();

			apresentacao.exibeMenuTipoVeiculo();

			String marcasJson = service.getMarcas(apresentacao.getTipoVeiculo());
			List<Especificacoes> marcas = conversor.desserializarLista(marcasJson, Especificacoes.class);

			apresentacao.exibeMenuMarcas(marcas);
			String modelosJson = service.getModelos(apresentacao.getCodigoMarca(), apresentacao.getTipoVeiculo());
			List<Especificacoes> modelos = conversor.desserializarLista(modelosJson, Especificacoes.class, "modelos");

			apresentacao.exibeMenuNomeVeiculo(modelos);
			List<Especificacoes> modelosFiltrados = modelos.stream().filter(m -> m.nome().toLowerCase().contains(apresentacao.getNomeVeiculo().toLowerCase())).collect(Collectors.toList());

			apresentacao.exibeMenuModeloVeiculo(modelosFiltrados);
			String anosModelosJson = service.getAnosModelo(apresentacao.getCodigoMarca(), apresentacao.getTipoVeiculo(), apresentacao.getCodigoModelo());
			List<Especificacoes> anosModelos = conversor.desserializarLista(anosModelosJson, Especificacoes.class);

			List<Veiculos> veiculos = new ArrayList<>();

            for (Especificacoes anosModelo : anosModelos) {
                String veiculoJson = service.getInformacoesAnoModelo(apresentacao.getCodigoMarca(), apresentacao.getTipoVeiculo(), apresentacao.getCodigoModelo(), anosModelo.codigo());
                Veiculos veiculo = conversor.desserializarObjeto(veiculoJson, Veiculos.class);
				veiculos.add(veiculo);
            }

			apresentacao.exibeVeiculos(veiculos);

        }
		catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Algo deu errado!");
		}
	}
}
