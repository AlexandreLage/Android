package br.com.fiap.fipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Spinner spMarca;
    private ArrayAdapter<Marca> adpMarca;
    private List<Marca> marcas;

    private Spinner spVeiculos;
    private ArrayAdapter<Veiculo> adpVeiculo;
    private List<Veiculo> veiculos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spMarca = (Spinner) findViewById(R.id.spMarca);
        adpMarca = new ArrayAdapter<Marca>(this, android.R.layout.simple_spinner_dropdown_item, marcas);
        spMarca.setAdapter(adpMarca);
        spMarca.setOnItemSelectedListener(this);
        carregarMarca();


        spVeiculos = (Spinner) findViewById(R.id.spVeiculo);
        adpVeiculo = new ArrayAdapter<Veiculo>(this, android.R.layout.simple_spinner_dropdown_item, veiculos);
        spVeiculos.setAdapter(adpMarca);
        spVeiculos.setOnItemSelectedListener(this);
    }

    private void carregarMarca() {
        String urlTXT = "http://fipeapi.appspot.com/api/1/carros/marcas.json";
        JsonArrayRequest req = new JsonArrayRequest(urlTXT, new RequestMarca(spMarca, adpMarca,getApplicationContext()),
                                                                        new RequestError());
        RequestQueue q = Volley.newRequestQueue(this);
        q.add(req);

        spMarca.setAdapter(adpMarca);
    }

    private void carregarVeiculos(int id){
        String urlTXT = "http://fipeapi.appspot.com/api/1/carros/veiculos/" + id + ".json";
        JsonArrayRequest req = new JsonArrayRequest(urlTXT, new RequestVeiculo(spVeiculos, adpVeiculo,
                            getApplicationContext()), new RequestError());

        RequestQueue q = Volley.newRequestQueue(this);
        spVeiculos.setAdapter(adpVeiculo);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Object sel = parent.getItemAtPosition(position);

        if(sel instanceof Marca){
            adpVeiculo.clear();
            int idMarca = ((Marca) sel).getId();
            carregarVeiculos(idMarca);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}