package appimagensdospersonagens.lucasramalho.com.imagensdospersonagens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int[] listaIcones = {R.drawable.felpudo,R.drawable.fofura,R.drawable.lesmo,R.drawable.bugado,
            R.drawable.uruca,R.drawable.carrinho,R.drawable.ios,R.drawable.android,R.drawable.realidade_aumentada,
            R.drawable.sound_fx,R.drawable.max,R.drawable.games};

    String[] listaNomes = {"Felpudo", "Fofura", "Lesmo",
            "Bugado", "Uruca", "Racing", "iOS", "Android",
            "RealidadeAumentada", "Sound FX", "3D Studio Max", "Games"};

    String[] listaDescricoes = {"Este é o protagonista dos cursos de iOS e Android",
            "Este é o protagonista dos cursos de iOS e Android", "Este é o protagonista dos cursos de iOS e Android",
            "Este é o protagonista dos cursos de iOS e Android", "Este é o protagonista dos cursos de iOS e Android",
            "Este é o protagonista dos cursos de iOS e Android", "Este é o protagonista dos cursos de iOS e Android",
            "Este é o protagonista dos cursos de iOS e Android", "Este é o protagonista dos cursos de iOS e Android",
            "Este é o protagonista dos cursos de iOS e Android",
            "Este é o protagonista dos cursos de iOS e Android", "Este é o protagonista dos cursos de iOS e Android"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView minhaLista = findViewById(R.id.minhaLista);
        final MeuAdaptador meuAdaptador = new MeuAdaptador(getApplicationContext(), R.layout.minha_celula);

        int i = 0;
        for (String nomes : listaNomes) {
            DadosPersonagem dadosPersonagem;
            dadosPersonagem = new DadosPersonagem(listaIcones[i], nomes, listaDescricoes[i]);
            meuAdaptador.add(dadosPersonagem);
            i++;
        }
        minhaLista.setAdapter(meuAdaptador);

        minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Clicou", Toast.LENGTH_SHORT).show();
                DadosPersonagem dadosPersonagem;
                dadosPersonagem = (DadosPersonagem) meuAdaptador.getItem(i);

                Intent chamarTela = new Intent(MainActivity.this, TelaDescricao.class);
                chamarTela.putExtra("nome", dadosPersonagem.getNome());
                chamarTela.putExtra("icone", dadosPersonagem.getIcone());
                chamarTela.putExtra("descricao", dadosPersonagem.getDescricao());
                //As variáveis nome, icone e descrição estão recebendo o nome, ícone e descrição do item da lista clicado
                //Estas variáveis serão passadas para a tela desccrição, onde setaremos estes dados lá.
                startActivity(chamarTela);
            }
        });

    }
}

class ViewPersonagem {
    ImageView icone;
    TextView nome;
    TextView descricao;
}

class DadosPersonagem {
    private int icone;
    private String nome;
    private String descricao;

    public DadosPersonagem(int icone, String nome, String descricao) {
        this.icone = icone;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getIcone() {
        return icone;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}

class MeuAdaptador extends ArrayAdapter {
    public MeuAdaptador(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View minhaView;
        minhaView = convertView;
        ViewPersonagem viewPersonagem;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            minhaView = inflater.inflate(R.layout.minha_celula, parent,false);

            viewPersonagem = new ViewPersonagem();
            viewPersonagem.icone = (ImageView) minhaView.findViewById(R.id.imgIconePersonagem);
            viewPersonagem.nome = (TextView) minhaView.findViewById(R.id.txtNomePersonagem);
           // viewPersonagem.descricao = (TextView) minhaView.findViewById(R.id.descricaoPersonagem);

            minhaView.setTag(viewPersonagem);
        } else {
            viewPersonagem = (ViewPersonagem) minhaView.getTag();
        }

        DadosPersonagem dadosPersonagem = (DadosPersonagem)this.getItem(position);

        viewPersonagem.icone.setImageResource(dadosPersonagem.getIcone());
        viewPersonagem.nome.setText(dadosPersonagem.getNome());
        //viewPersonagem.descricao.setText(dadosPersonagem.getDescricao());

        return minhaView;
    }
}
