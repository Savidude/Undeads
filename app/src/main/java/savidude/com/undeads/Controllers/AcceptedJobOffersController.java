package savidude.com.undeads.Controllers;

/**
 * Created by Imaadh Rizni on 5/28/2016.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import savidude.com.undeads.Models.AcceptedJobOffer;

public class AcceptedJobOffersController extends AsyncTask<String, Void, String> {

    private Context context;
    private AlertDialog alertDialog;

    public AcceptedJobOffersController(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        ArrayList<AcceptedJobOffer> jobOffers;

        if (params[0].equals("create")) {
            String url_String = "http://undeads.net23.net/api/create_product.php";

            try {
                String name = params[1];
                String price = params[2];
                String description = params[3];

                URL url = new URL(url_String);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("price", "UTF-8") + "=" + URLEncoder.encode(price, "UTF-8") + "&" +
                        URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(description, "UTF-8");
                bufferedWriter.write(postData);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line + "\n";
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (params[0].equals("view")) {
            String url_String = "http://undeads.net23.net/api/getAcceptedJobOffers.php/960093356V";

            try {
                URL url = new URL(url_String);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = null;
                bufferedWriter.write("");
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line + "\n";
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                String[] resultParts = result.split("<");

                JSONArray jsonArray = new JSONArray(resultParts[0]);

                jobOffers = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonData = jsonArray.getJSONObject(i);

                    AcceptedJobOffer jobOffer = new AcceptedJobOffer();
                    jobOffer.setJobDescription(jsonData.getString("Job_Title_Description"));
                    jobOffer.setPending(Integer.valueOf(jsonData.getString("Pending")));

                    jobOffers.add(jobOffer);
                }

                String desc = "";

                for (AcceptedJobOffer jobOffer : jobOffers) {
                    desc += jobOffer.getJobDescription() + "\t" + jobOffer.getPending() + "\n";
                }

                return desc;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Add Job Offer status");
    }

    @Override
    protected void onPostExecute(String s) {
        alertDialog.setMessage(s);
        alertDialog.show();
    }

}
