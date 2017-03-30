package fiap.com.br.votacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener{

    private RadioGroup rgVotos;
    private Spinner spLista;
    private Button btnVotar;
    private RadioButton rbVeredor;
    private RadioButton rbPrefeito;

    private List<VotacaoBean> prefeitos;
    private List<VotacaoBean> vereadores;

    private ArrayAdapter<VotacaoBean> adpPrefeitos;
    private ArrayAdapter<VotacaoBean> adpVereadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgVotos = (RadioGroup) findViewById(R.id.rgRadio);
        spLista = (Spinner) findViewById(R.id.spLista);
        btnVotar = (Button) findViewById(R.id.btnVotar);
        rbVeredor = (RadioButton) findViewById(R.id.rbVereador);
        rbPrefeito = (RadioButton) findViewById(R.id.rbPrefeito);

        criarVereadores();
        criarPrefeitos();

        adpVereadores = new ArrayAdapter<VotacaoBean>(this, android.R.layout.simple_spinner_item, this.vereadores);
        adpPrefeitos = new ArrayAdapter<VotacaoBean>(this, android.R.layout.simple_spinner_item, this.prefeitos);



    }

    public void criarVereadores(){
        vereadores = new ArrayList();
        vereadores.add(new VotacaoBean("Raphael", "ABC"));
        vereadores.add(new VotacaoBean("Vitor", "DEF"));
        vereadores.add(new VotacaoBean("Jheyjhey", "ASD"));
        vereadores.add(new VotacaoBean("Merbert", "AWEW"));
    }

    public void criarPrefeitos(){
        prefeitos = new ArrayList();
        prefeitos.add(new VotacaoBean("ET DA BRISA", "ABC"));
        prefeitos.add(new VotacaoBean("Relampago Marquinhos", "DEF"));
        prefeitos.add(new VotacaoBean("Irineu", "ASD"));
        prefeitos.add(new VotacaoBean("Sua mae", "AWEW"));

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
}
