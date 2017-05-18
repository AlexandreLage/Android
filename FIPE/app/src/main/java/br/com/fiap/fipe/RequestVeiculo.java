package br.com.fiap.fipe;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by logonrm on 18/05/2017.
 */

public class RequestVeiculo implements Response.Listener<JSONArray> {

    private Spinner spVeiculo;
    private ArrayAdapter<Veiculo> adpVeiculo;
    private Context ctx;

    public RequestVeiculo() {

    }

    public RequestVeiculo(Spinner spVeiculo, ArrayAdapter<Veiculo> adpVeiculo, Context ctx) {
        this.spVeiculo = spVeiculo;
        this.adpVeiculo = adpVeiculo;
        this.ctx = ctx;
    }

    public void onResponse(JSONArray response) {

        List<Veiculo> veiculos = new ArrayList<Veiculo>();

        for(int i=0; i<response.length();i++){
            try {
                JSONObject obj =  response.getJSONObject(i);
                veiculos.add(new Veiculo(obj.getInt("id"), obj.getString("name")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        adpVeiculo = new ArrayAdapter<Veiculo>(ctx, android.R.layout.simple_spinner_item, veiculos);
        spVeiculo.setAdapter(adpVeiculo);

        Log.i("FIPE", response.toString());
    }
}
