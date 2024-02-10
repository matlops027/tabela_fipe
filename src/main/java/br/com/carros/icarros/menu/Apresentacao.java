package br.com.carros.icarros.menu;

import br.com.carros.icarros.exceptions.NotFoundException;
import br.com.carros.icarros.models.Especificacoes;
import br.com.carros.icarros.models.Veiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Apresentacao {

    private String tipoVeiculo;
    private String codigoMarca;
    private String nomeVeiculo;
    private String codigoModelo;
    private final Scanner leitura = new Scanner(System.in);

    public void exibeMenuTipoVeiculo() {
        String menu = """
                    **** OPÇÕES ****
                    
                    - Carros
                    - Motos
                    - Caminhoes

                """;
        System.out.println(menu);
        System.out.println("Digite uma das opções para consultar os valores: ");
        String opcao = leitura.next();
        if(this.validaTipoVeiculo(opcao)) {
            setTipoVeiculo(opcao);
        }else {
            throw new NotFoundException("A opção informada é invalida!");
        }
    }

    public void exibeMenuMarcas(List<Especificacoes> marcas) {
        System.out.println(marcas);
        System.out.println("Informe o código da marca para consulta: ");
        setCodigoMarca(leitura.next());
    }

    public void exibeMenuNomeVeiculo(List<Especificacoes> modelos) {
        System.out.println(modelos);
        System.out.println("Digite um trecho do nome do veículo para consulta: ");
        setNomeVeiculo(leitura.next());
    }

    public void exibeMenuModeloVeiculo(List<Especificacoes> modelos) {
        System.out.println(modelos);
        System.out.println("Digite o código do modelo para consultar valores: ");
        setCodigoModelo(leitura.next());
    }

    public void exibeVeiculos(List<Veiculos> veiculos) {
        System.out.println(veiculos);
    }

    private boolean validaTipoVeiculo(String opcao) {
        List<String> opcoes = new ArrayList<>();
        opcoes.add("Carros");
        opcoes.add("Motos");
        opcoes.add("Caminhoes");

        return opcoes.stream().anyMatch(o -> o.toLowerCase().equals(opcao.toLowerCase()));
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    private void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getCodigoMarca() {
        return codigoMarca;
    }

    private void setCodigoMarca(String codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    private void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public String getCodigoModelo() {
        return codigoModelo;
    }

    private void setCodigoModelo(String codigoModelo) {
        this.codigoModelo = codigoModelo;
    }
}
