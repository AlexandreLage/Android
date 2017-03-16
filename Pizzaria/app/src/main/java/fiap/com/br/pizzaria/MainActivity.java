package fiap.com.br.pizzaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
                                            implements AdapterView.OnItemSelectedListener{

    private Spinner spSabor;
    private ArrayAdapter<PizzaBean> adpSabor;
    private List<PizzaBean> pizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spSabor = (Spinner) findViewById(R.id.spSabor);
        obterPizzas();
        exibeSabores();
        spSabor.setOnItemSelectedListener(this);
    }

    private void exibeSabores(){
        adpSabor = new ArrayAdapter<PizzaBean>(this,
                android.R.layout.simple_spinner_item, pizzas);
        spSabor.setAdapter(adpSabor);
    }

    private void obterPizzas(){
        pizzas = new ArrayList<PizzaBean>();
        pizzas.add(new PizzaBean("Bacon", 31.0, R.drawable.pizzabacon));
        pizzas.add(new PizzaBean("Carbonara", 30.0, R.drawable.pizzacarbonara));
        pizzas.add(new PizzaBean("Pancia del Nono", 40.0, R.drawable.pizzapancianono));
        pizzas.add(new PizzaBean("Queijo", 26.0, R.drawable.pizzaqueijo));
        pizzas.add(new PizzaBean("Rúcula", 30.0, R.drawable.pizzarucula));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(view.getId() == R.id.spFormPagamento){

        }else if(view.getId() == R.id.spSabor) {
            PizzaBean sel = (PizzaBean) parent.getItemAtPosition(position);
            Toast.makeText(this, sel.getSabor(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
