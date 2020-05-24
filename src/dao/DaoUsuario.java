package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean ValidarNovoUsuario(String login) throws Exception{
		
		String sql = "select * from usuarios where login='"+login+"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			return true;
		}else {
			return false;
		}
		
		
	}
	public void salvar(BeanCursoJsp usuario){
		
		try {
		String sql = "insert into usuarios(login,senha) values (?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, usuario.getLogin());
		insert.setString(2, usuario.getSenha());
		insert.execute();
		connection.commit();
		
		}catch(Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		}
	public java.util.List<BeanCursoJsp> listar() throws Exception{
		java.util.List<BeanCursoJsp> listar = new ArrayList<BeanCursoJsp> ();
		String sql="Select * from usuarios";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
			beanCursoJsp.setId(resultSet.getInt("id"));
			
			listar.add(beanCursoJsp);
		}
		
		return listar;
	}
	
	public void delete(String login) {
		
		try {
		String sql = "delete from usuarios where login='"+login+"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.execute();
		connection.commit();
		
	}catch(Exception e) {
		e.printStackTrace();
		try {
			connection.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
		}

	public BeanCursoJsp consultar(String login) throws Exception {
		
		String sql = "select * from usuarios where login='"+login+"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			beanCursoJsp.setId(resultSet.getLong("id"));
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
			
			return beanCursoJsp;
		}else {}
		
		return null;
		
	}

	public void atualizar(BeanCursoJsp usuario) {
		try {
		String sql = "update usuarios set login = ?, senha= ? where id = '"+usuario.getId()+"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, usuario.getLogin());
		preparedStatement.setString(2, usuario.getSenha());
		preparedStatement.executeUpdate();
		connection.commit();
	}catch (Exception e){
		e.printStackTrace();
		try {
			connection.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}	
	}

}
