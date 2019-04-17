package br.edu.utfpr.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import br.edu.utfpr.dto.ClienteDTO;
import lombok.extern.java.Log;

@Log
public class ClienteDAO {

    // Responsável por criar a tabela Cliente no banco.
    public ClienteDAO() {

        private static Statement stmt = null;
        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            log.info("Criando tabela cliente ...");
            conn.createStatement().executeUpdate(
            "CREATE TABLE cliente (" +
						"id int NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT id_cliente_pk PRIMARY KEY," +
						"nome varchar(255)," +
						"telefone varchar(30)," + 
						"idade int," + 
                        "limiteCredito double," +
                        "id_pais int)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateCliente(ClienteDTO cliente){
        try{
            stmt = conn.createStatement();
            stmt.execute("insert into cliente values(" + cliente.getId +
                                                    ",'" + cliente.getNome +
                                                    "'," + cliente.getIdade +
                                                    ",'" + cliente.getTelefone +
                                                    "'," + cliente.getLimitecredito +
                                                    ","  + cliente.getPais.getId + ")");
            stmt.close();

        }
        catch(SQLException sqlException)
            sqlExcept.printStackTrace();
    }

    public void selectClienteById(int id){
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from cliente where id = " + id);
            system.out.println(results.getInt(1) + "\n" +
                    results.getString(2) + "\n" +
                    results.getString(3) + "\n" +
                    results.getInt(4) + "\n" +
                    results.getDouble(5) + "\n" +
                    results.getInt(6) + "\n");
            result.close();
            stmt.close();
            //Poderia retornar o resultset com o cliente inteiro tbm, mas ai não seria void
        }
        catch(SQLException sqlException)
            sqlExcept.printStackTrace();
    }

    public void deleteClienteByID(int id){
        try {
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM cliente WHERE id = " + id);
            system.out.println("Cliente apagado com sucesso");
            stmt.close();
        }
        catch(SQLException sqlException)
            sqlExcept.printStackTrace();
    }

    public void updateClienteById(int id, String coluna, String valornovo){
        try {
            stmt = conn.createStatement();
            stmt.execute("UPDATE cliente SET " + coluna + " = " + valornovo + " WHERE id =" +id);
            system.out.println("Cliente atualizado com sucesso");
            stmt.close();
        }
        catch(SQLException sqlException)
            sqlExcept.printStackTrace();
    }




}