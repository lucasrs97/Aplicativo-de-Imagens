package appimagensdospersonagens.lucasramalho.com.imagensdospersonagens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TelaDescricao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_descricao);

        ImageView icone = findViewById(R.id.iconePersonagem);
        TextView nome = findViewById(R.id.nomePersonagem);
        TextView descricao = findViewById(R.id.descricaoPersonagem);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            int i = extras.getInt("icone");
            String n = extras.getString("nome");
            String d = extras.getString("descricao");
            //i, n e d estão recebendo o conteúdo das variáveis icone, nome e parâmetro, respectivamente

            icone.setImageResource(i);
            nome.setText(n);
            descricao.setText(d);
        }

    }
}
