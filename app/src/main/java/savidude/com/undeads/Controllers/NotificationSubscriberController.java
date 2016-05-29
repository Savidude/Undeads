package savidude.com.undeads.Controllers;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

import savidude.com.undeads.Models.Subscription;
import savidude.com.undeads.Models.getAllJobOffers;

/**
 * Created by FathimaShakoora on 29-May-16.
 */
public class NotificationSubscriberController extends AsyncTask<String, Void, ArrayList<Subscription>> {

    private Context context;
    private AlertDialog alertDialog;
    ArrayList<Subscription> subscript;

    public NotificationSubscriberController(Context context) {
        this.context = context;
    }

    @Override
    protected ArrayList<Subscription> doInBackground(String... params) {


        if (params[0].equals("create")) {
            String url_String = "http://undeads.net23.net/api/InsertAcceptedJobOffers.php";
            System.out.println("Entered Try - Catch");
            try {
                System.out.println("Entered Try - Catch ( if)");
                String job_offer_id = params[1];

                URL url = new URL(url_String);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = URLEncoder.encode("nic", "UTF-8") + "=" + URLEncoder.encode("960093356V", "UTF-8") + "&" +
                        URLEncoder.encode("job_offer_id", "UTF-8") + "=" + URLEncoder.encode(job_offer_id, "UTF-8");
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
            String url_String = "http://undeads.net23.net/api/getSubcriJobOffers.php";
            System.out.println("before try catch (else-if)");

            try {
                System.out.println("1");
                URL url = new URL(url_String);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                System.out.println("2");
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = URLEncoder.encode("nic", "UTF-8") + "=" + URLEncoder.encode("960093356V", "UTF-8");
                bufferedWriter.write(postData);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                System.out.println("3");
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                System.out.println("4");
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
                System.out.println(resultParts[0]);
                subscript = new ArrayList<>();
                System.out.println("8");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONArray innerArray = jsonArray.getJSONArray(i);
                    for (int j = 0; j < innerArray.length(); j++) {
                        JSONObject jsonData = innerArray.getJSONObject(j);

                        Subscription sub = new Subscription();
                        sub.setLast_Updated_Date(jsonData.getString("Last_Updated_Date"));
                        sub.setOrganization_Name(jsonData.getString("Organization_Name"));
                        sub.setJob_Offer_Added_Time(jsonData.getString("Job_Offer_Added_Time"));
                        sub.setStart_Tme(jsonData.getString("Start_Time"));
                        sub.setEnd_Time(jsonData.getString("End_Time"));
                        sub.setQuantity(Integer.valueOf(jsonData.getString("Quantity")));
                        sub.setJob_Title_Description(jsonData.getString("Job_Title_Description"));
                        sub.setJobOfferId(jsonData.getString("Job_Offer_ID"));
                        subscript.add(sub);
                    }
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

        return subscript;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(ArrayList<Subscription> jobOffers) {
        //return jobOffers;
    }
}
