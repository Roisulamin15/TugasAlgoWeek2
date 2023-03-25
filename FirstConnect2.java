package Model;
import Oop.ResponseModel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect2 {
    public static void main(String[] args) throws IOException {
        ConnectURI koneksiSaya = new ConnectURI();
        URL myAddres = koneksiSaya.buildURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = koneksiSaya.getResponseFromHttpUrl(myAddres);
//        System.out.println(response);

        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ResponseModel> responseModel =
                new ArrayList<>();
        int count = 0;
        for (int i = 0; i < responseJSON.length(); i++) {
            ResponseModel resModel = new ResponseModel();
            JSONObject myJSONObject =
                    responseJSON.getJSONObject(i);
            String price = myJSONObject.
                    getString("i_sell");
            resModel.setI_sell(price);
            responseModel.add(resModel);

            int priceInt = Integer.parseInt(price);
            if (priceInt < 2000) {
                count++;
            }
        }

//        System.out.println("Jumlah Obat Dengan Harga 2000 = " + count);
        for (int index = 0; index < responseModel.size(); index++) {
            int price = Integer.parseInt(responseModel.get(index).getI_sell());
            if (price < 2000) {
                System.out.println("price : " + price);
            }

        }
        System.out.println("obat diharga 2000 = " + count);
    }
}
