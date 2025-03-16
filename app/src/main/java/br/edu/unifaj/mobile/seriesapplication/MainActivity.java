package br.edu.unifaj.mobile.seriesapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    } //fim do metodo

    public void validar(View v) {
        EditText titulo = findViewById(R.id.main_edittext_titulo);
        EditText genero = findViewById(R.id.main_edittext_genero);
        EditText protagonista = findViewById(R.id.main_edittext_protagonista);
        EditText anoLancamento = findViewById(R.id.main_edittext_ano);
        EditText temporadas = findViewById(R.id.main_edittext_temporadas);

        if (titulo.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Erro: Insira um texto", Toast.LENGTH_SHORT).show();
        } else if (genero.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Erro: Insira um genero", Toast.LENGTH_SHORT).show();
        } else if (protagonista.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Erro: Insira um protagonista", Toast.LENGTH_SHORT).show();
        } else if (anoLancamento.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Erro: Insira um ano", Toast.LENGTH_SHORT).show();
        } else {
            try {
                String valorTexto = anoLancamento.getText().toString().trim();
                int valor = Integer.parseInt(valorTexto);

                if (valor > 2025) {
                    Toast.makeText(this, "Não permitido ano acima do atual", Toast.LENGTH_SHORT).show();
                } else if (temporadas.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "Erro: Insira um numero de temporadas", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Todos os dados estão válidos!", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Erro: Ano inválido", Toast.LENGTH_SHORT).show();
            }
        }
}

        public void exibir (View v){
            Toast.makeText(this, "Nome: Yuri Chrystian de Oliveira", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "RA: 12427365", Toast.LENGTH_SHORT).show();
        }
    }//fim da classe