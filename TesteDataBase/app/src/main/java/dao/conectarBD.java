package dao;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.teste;

public class conectarBD extends AsyncTask<Integer, Object, Boolean> {

    Connection conexao;

    ProgressDialog dialogo;

    Context tela;

    int op;

    private teste testeClasse = new teste();

    public teste getTesteClasse() {
        return testeClasse;
    }

    public void setTesteClasse(teste testeClasse) {
        this.testeClasse = testeClasse;
    }

    public conectarBD(Context tela) {
        super();
        this.tela = tela;
    }
    ///////////////////////////////////////

    // MÉTODO DE CONEXAO
    public Boolean connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://192.168.0.18:3306/bd", "root", "lucas4max");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    ///////////////////////////////////////////////////////

    // MÉTODO DE DESCONECTAR
    public void disconnect() {
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /////////////////////////////////////////////////////


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        dialogo = new ProgressDialog(tela);
        dialogo.setMessage("Aguarde ...");
        dialogo.show();
    }


    @Override
    protected Boolean doInBackground(Integer... integers) {
        Boolean resp = null;

        op = integers[0];

        connect();

        switch (op) {
            case 0:
                resp = inserir();
                break;
        }

        return resp;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

        switch (op) {
            case 0:
                if (aBoolean == true) {
                    Toast.makeText(tela, "CADASTRO OK!!!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(tela, "ERRO - VERIFIQUE AS INFORMAÇÕES !!!!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        dialogo.dismiss();

        disconnect();
    }

    private Boolean inserir() {

        try {
            String sql = "insert into teste values (0,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, testeClasse.getNome());
            comando.setString(2, testeClasse.getSenha());
            comando.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}