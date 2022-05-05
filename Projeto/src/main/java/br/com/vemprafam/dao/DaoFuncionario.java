package br.com.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vemprafam.pojo.Funcionario;

public class DaoFuncionario {
	private Connection conn;
	private String url="jdbc:hsqldb:hsql://localhost/";
	public DaoFuncionario() {
		super();
		try {
			conn = DriverManager.getConnection(url,"SA","");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Funcionario> getFuncionarios() {
		List<Funcionario> result = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT re,nome,salario,datanascimento,email FROM funcionarios");
			ResultSet rs = pstmt.executeQuery();
			while( rs.next() ) {
				result.add(new Funcionario(rs.getInt(1),rs.getString(2),rs.getDouble(3),
						rs.getDate(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	public void inserirFuncionario(Funcionario funcionario) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO Funcionarios values (?,?,?,?,?)");
			pstmt.setInt(1, funcionario.getRe());
			pstmt.setString(2, funcionario.getNome());
			pstmt.setDouble(3, funcionario.getSalario());
			pstmt.setDate(4, new java.sql.Date(funcionario.getDataNascimento().getTime()));
			pstmt.setString(5, funcionario.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public boolean excluirFuncionario(int re) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"DELETE FROM Funcionarios WHERE re=?");
			pstmt.setInt(1, re);
			return pstmt.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Funcionario buscarPeloRe(int re) {
		Funcionario result = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(
				"SELECT re,nome,salario,datanascimento,email FROM funcionarios WHERE re=?");
			pstmt.setInt(1, re);
			ResultSet rs = pstmt.executeQuery();
			if ( rs.next() ) {
				result = new Funcionario(rs.getInt(1),rs.getString(2),rs.getDouble(3),
					rs.getDate(4),rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	public void alterarFuncionario(Funcionario funcionario) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(
				"UPDATE Funcionarios SET nome=?, salario=?, dataNascimento=?, email=? "
				+ " WHERE re=?");
			pstmt.setString(1,funcionario.getNome());
			pstmt.setDouble(2, funcionario.getSalario());
			pstmt.setDate(3, 
					new java.sql.Date(funcionario.getDataNascimento().getTime()));
			pstmt.setString(4, funcionario.getEmail());
			pstmt.setInt(5, funcionario.getRe());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
