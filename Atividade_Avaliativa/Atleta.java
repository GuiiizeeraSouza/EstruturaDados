package Atividade_Avaliativa;

import java.util.Objects;

public class Atleta {
    String fone;
    String nome;
    String apelido;
    String dataNascimento;
    int pontuacaoAcumulada;

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDataNasci() {
        return dataNascimento;
    }

    public void setDataNasci(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getPontucao() {
        return pontuacaoAcumulada;
    }

    public void setPontucao(int pontuacaoAcumulada) {
        this.pontuacaoAcumulada = pontuacaoAcumulada;
    }

    public Atleta(String fone, String nome, String apelido, String dataNascimento, int pontuacaoAcumulada) {
        super();
        this.fone = fone;
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.pontuacaoAcumulada = pontuacaoAcumulada;
    }

    public String toCSV() {
        return fone + ";" + nome + ";" + apelido + ";" + dataNascimento + ";" + pontuacaoAcumulada;
    }

    @Override
	public String toString() {
		return "Aluno [fone: " + fone + ", nome: " + nome + ", apelido: " + apelido + ", Data-Nascimento: " + dataNascimento +", Pontos: " + pontuacaoAcumulada +"]";
	}

    @Override
    public int hashCode() {
        return Objects.hash(fone);
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		return fone == other.fone;
	}
}
