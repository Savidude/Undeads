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

public class AcceptedJobOffersController extends AsyncTask<String, Void, ArrayList<AcceptedJobOffer>> {

    private Context context;
    private AlertDialog alertDialog;
    ArrayList<AcceptedJobOffer> jobOffers;

    public AcceptedJobOffersController(Context context) {
        this.context = context;
    }

    @Override
    protected ArrayList<AcceptedJobOffer> doInBackground(String... params) {



        if (params[0].equals("create")) {
            String url_String = "http://undeads.net23.net/api/create_product.php";
            System.out.println("Entered Try - Catch");
            try {
                System.out.println("Entered Try - Catch ( if)");
                String nic = params[1];
                String job_offer_id = params[2];
                String pendingStatus = params[3];

                URL url = new URL(url_String);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = URLEncoder.encode("National_ID", "UTF-8") + "=" + URLEncoder.encode(nic, "UTF-8") + "&" +
                        URLEncoder.encode("Job_Offer_ID", "UTF-8") + "=" + URLEncoder.encode(job_offer_id, "UTF-8") + "&" +
                        URLEncoder.encode("Pending", "UTF-8") + "=" + URLEncoder.encode(pendingStatus, "UTF-8");
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

                //return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (params[0].equals("view")) {
            String url_String = "http://undeads.net23.net/api/getAcceptedJobOffers.php";
            try {
                URL url = new URL(url_String);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = URLEncoder.encode("nic","UTF-8")+"="+URLEncoder.encode("960093356V","UTF-8");
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
                System.out.println("8");
                String[] resultParts = result.split("<");
                System.out.println("PART1: "+ resultParts[0].trim());
                System.out.println("PART2: "+ resultParts[1]);

                JSONArray jsonArray = new JSONArray(resultParts[0]);

                jobOffers = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonData = jsonArray.getJSONObject(i);
                    System.out.println("ENTERED FOR LOOP");
                    AcceptedJobOffer jobOffer = new AcceptedJobOffer();
                    jobOffer.setJobDescription(jsonData.getString("Job_Title_Description"));
                    jobOffer.setPending(Integer.valueOf(jsonData.getString("Pending")));
                    jobOffer.setOrganizationName(jsonData.getString("Organization_Name"));
                    jobOffer.setStartTime(jsonData.getString("Start_Time"));
                    jobOffer.setEndTime(jsonData.getString("End_Time"));

                    jobOffers.add(jobOffer);
                }

                //return jobOffers;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return jobOffers;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(ArrayList<AcceptedJobOffer> jobOffers) {
        //return jobOffers;
    }
}
