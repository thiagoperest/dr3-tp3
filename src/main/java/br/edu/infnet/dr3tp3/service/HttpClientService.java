package br.edu.infnet.dr3tp3.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class HttpClientService {

    public String sendGetRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");

        int statusCode = connection.getResponseCode();
        System.out.println("Status Code: " + statusCode);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(statusCode >= 200 && statusCode < 300
                        ? connection.getInputStream()
                        : connection.getErrorStream())
        );

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        String responseBody = response.toString();
        System.out.println("Response: " + responseBody);

        connection.disconnect();
        return responseBody;
    }

    public String sendPostRequest(String urlString, String jsonData) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(jsonData);
        outputStream.flush();
        outputStream.close();

        int statusCode = connection.getResponseCode();
        System.out.println("Status Code: " + statusCode);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(statusCode >= 200 && statusCode < 300
                        ? connection.getInputStream()
                        : connection.getErrorStream())
        );

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        String responseBody = response.toString();
        System.out.println("Response: " + responseBody);

        connection.disconnect();
        return responseBody;
    }

    public String sendPutRequest(String urlString, String jsonData) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(jsonData);
        outputStream.flush();
        outputStream.close();

        int statusCode = connection.getResponseCode();
        System.out.println("Status Code: " + statusCode);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(statusCode >= 200 && statusCode < 300
                        ? connection.getInputStream()
                        : connection.getErrorStream())
        );

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        String responseBody = response.toString();
        System.out.println("Response: " + responseBody);

        connection.disconnect();
        return responseBody;
    }

    public String sendDeleteRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Accept", "application/json");

        int statusCode = connection.getResponseCode();
        System.out.println("Status Code: " + statusCode);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(statusCode >= 200 && statusCode < 300
                        ? connection.getInputStream()
                        : connection.getErrorStream())
        );

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        String responseBody = response.toString();
        System.out.println("Response: " + responseBody);

        connection.disconnect();
        return responseBody;
    }

    public String sendOptionsRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("OPTIONS");
        connection.setRequestProperty("Accept", "application/json");

        int statusCode = connection.getResponseCode();
        System.out.println("Status Code: " + statusCode);
        System.out.println("Allow Header: " + connection.getHeaderField("Allow"));

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(statusCode >= 200 && statusCode < 300
                        ? connection.getInputStream()
                        : connection.getErrorStream())
        );

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        String responseBody = response.toString();
        System.out.println("Response: " + responseBody);

        connection.disconnect();
        return responseBody;
    }
}
