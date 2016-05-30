package it.polito.tdp.dizionario.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.dizionario.model.Model;



public class DizionarioDAO {

	private Model m=new Model();
	
	
	
	public Model getM() {
		return m;
	}



	public void setM(Model m) {
		this.m = m;
	}



	public void readWordWithLengthX(int x){
		
		Connection conn = DBConnection.getConnection() ;

			String sql = "SELECT nome FROM parola WHERE LENGTH(nome) = ? ;";

			PreparedStatement st;
			
			try {


			    st = conn.prepareStatement(sql) ;
				
				st.setInt(1, x);
			
				ResultSet res = st.executeQuery() ;

			
			    while(res.next()){
			    	
			    	String nome=res.getString("nome");
			    	
			    	m.word.add(nome);
			}
			
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
