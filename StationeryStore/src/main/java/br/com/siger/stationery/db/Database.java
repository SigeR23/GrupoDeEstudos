package br.com.siger.stationery.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.siger.stationery.model.Produto;
import br.com.siger.stationery.model.Setor;

public class Database {
	private List<Produto> produtos;
	private List<Setor> setores;
	private static Database instance = null;
	private Connection con = null;
	private static String sql1 = "select id, descricao, id_setor, fabricante, complemento, preco, oferta from produtos";
	private static String sql2 = "selet id, descricao from setores";

	private Database() {
		produtos = new ArrayList<>();
		setores = new ArrayList<>();
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:file:c:/Database/db/stationery", "sa", "");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("[Database] connection error");
			throw new RuntimeException(e);
		}
	}

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	public void disconnect() {
		
		try {
			if (con != null) 
				con.close();
			instance  = null;
			System.out.println("[Database] connection closed");
		} catch (SQLException e) {
			System.out.println("[Database] connection close error");
		}
		con = null;
		
	}
	public Produto getProdutoPorId (String id) {
		Produto p = null;
		
		try {
			System.out.println("[Database.getProdutorPorId] produto retrieve");
			String query = sql1 + " where ID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				p = new Produto(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getBoolean(7));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("[Database.getProdutoPorId] SQL error");
		}
		return p;
	}
	
	public List<Produto> getProdutos(int idSetor) {
		try {
			System.out.println("[Database.getProdutorPorId] produto retrieve");
			produtos.clear();
			String query = null;
			PreparedStatement stmt = null;
			switch (idSetor) {
			case -1:
				query = sql1 + " order by descricao";
				stmt = con.prepareStatement(query);
				break;
			case 0:
				query = sql1 + " where oferta = true order by descricao";
				stmt = con.prepareStatement(query);
				break;
			default:
				query = sql1 + " where id_setor = ? order by descricao";
				stmt = con.prepareStatement(query);
				stmt.setInt(1, idSetor);
			}
			ResultSet rs = stmt.executeQuery();
			Produto p = null;
			while (rs.next()) {
				p = new Produto(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getBoolean(7));
				produtos.add(p);
			}
			rs.close();
			stmt.close();
			
		} catch(SQLException e) {
			System.out.println("[Database.getProdutos] SQL error");
		}
		return produtos;
	}
	
	public List<Produto> getProdutos() {
		return getProdutos(-1);
		
	}
	
	public Setor getSetorPorDescricao(String descricao) {
		Setor s = setores.get(0);
		if (descricao == null)
			return s;
		for (Setor ss : setores) {
			if (ss.getDescricao().equals(descricao))
				return ss;
		}
		return s;
	}
	
	public Setor getSetorPorId(int id) {
		Setor s = null;
		try {
			System.out.println("[Database.getSetorPorId] produto retrieve");
			String query = sql2 + " where ID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				s = new Setor(rs.getInt(1), rs.getString(2));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("[Database.getSetorPorId] SQL error");
		}
		
		return s;
	}
	
	public List<Setor> getSetores() {
		try {
			System.out.println("[Database.getSetores] produto retrieve");
			setores.clear();
			String query = sql2 + " order by id";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			Setor s = null;
			while (rs.next()) {
				s = new Setor(rs.getInt(1), rs.getString(2));
				setores.add(s);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("[Database.getSetores] SQL error");
		}
		return setores;
		
	}
}
