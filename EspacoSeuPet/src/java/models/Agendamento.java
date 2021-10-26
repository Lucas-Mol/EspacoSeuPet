/*
 * Classe Agendamento
 * Função: classe designada para a criação dos atributos de agendamentos em geral
 *
 */
package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 *
 * @author Lucas Mol
 */
public class Agendamento {
    
    //Declaração dos dados utilizados para gerenciar o Agendamento
    private int id_tb_agendamento;
    private String dataAgendamento;
    //variável para formatar a data vinda do DataBase no localização Brasileira
    private DateFormat dataAgendamentoFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    //varíavel para receber a String de data para filtragem em acréscimo e decréscimo
    private String dataAgendamentoStringOrdenada;
    //variável para formatar a data vinda do DataBase na ordem para listagem
    private DateFormat dataAgendamentoDFormatOrdenada = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    private String nomeAnimal;
    private String tipoAnimal;
    private String nomeDono;
    private String telefone;
    private String observacoes;
    

//Getter e Setters
    public int getId_tb_agendamento() {
        return id_tb_agendamento;
    }

    public void setId_tb_agendamento(int id_tb_agendamento) {
        this.id_tb_agendamento = id_tb_agendamento;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
    
    public String getDataAgendamentoStringOrdenada() {
        return dataAgendamentoStringOrdenada;
    }

    public void setDataAgendamentoStringOrdenada(String dataAgendamentoStringOrdenada) {
        this.dataAgendamentoStringOrdenada = dataAgendamentoStringOrdenada;
    }

    public DateFormat getDataAgendamentoDFormatOrdenada() {
        return dataAgendamentoDFormatOrdenada;
    }

    public void setDataAgendamentoDFormatOrdenada(DateFormat dataAgendamentoDFormatOrdenada) {
        this.dataAgendamentoDFormatOrdenada = dataAgendamentoDFormatOrdenada;
    }
 
    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
    
    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public DateFormat getDataAgendamentoFormatada() {
        return dataAgendamentoFormatada;
    }

    public void setDataAgendamentoFormatada(DateFormat dataAgendamentoFormatada) {
        this.dataAgendamentoFormatada = dataAgendamentoFormatada;
    }

    
    
    
}
