package exercicioTelas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Animal {
	protected String nome;
	protected String raca;
	protected String cor;
	protected String endereco;
	protected String telefone;
	protected Calendar dateOfBirth = new GregorianCalendar();
	protected Date dataNasc;
	protected Calendar today = Calendar.getInstance();
	protected int idade;
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
	protected String tutor;
	protected String senha;
	protected String foto;
	
	public Animal(String nome, String raca, String cor, String endereco, String telefone, String dataNasc, String tutor, String senha, String foto) {
		this.nome = nome;
		this.raca = raca;
		this.cor = cor;
		this.endereco = endereco;
		this.telefone = telefone;
		try {
			this.dataNasc = formato.parse(dataNasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dateOfBirth.setTime(this.dataNasc);
		this.idade = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		dateOfBirth.add(Calendar.YEAR, idade);
        // se a data de hoje é antes da data de Nascimento, então diminui 1.
        if (today.before(dateOfBirth)) {
            idade--;
        }
        
        this.tutor = tutor;
        this.senha = senha;
        this.foto = foto;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public int getIdade() {
		return idade;
	}
	public String getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	protected String sangue;
	protected String avaliacao;
}
