package currancyCounter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {
    private static final String API_KEY = "YOUR_API_KEY"; // Replace with your actual API key

    public static void main(String[] args) {
        try {
            // Get currency exchange rates from the API
            JSONObject exchangeRates = getExchangeRates();
            if (exchangeRates == null) {
                System.out.println("Failed to fetch exchange rates. Exiting.");
                System.exit(1);
            }

            // Display available currencies
            System.out.println("Available currencies:");
            System.out.println(exchangeRates.getJSONObject("rates").keySet());

            // Get user input for base and target currencies
            System.out.print("Enter base currency: ");
            String baseCurrency = new BufferedReader(new InputStreamReader(System.in)).readLine().toUpperCase();
            System.out.print("Enter target currency: ");
            String targetCurrency = new BufferedReader(new InputStreamReader(System.in)).readLine().toUpperCase();

            // Get user input for the amount to convert
            System.out.print("Enter the amount to convert: ");
            double amountToConvert = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());

            // Perform currency conversion
            double exchangeRate = exchangeRates.getJSONObject("rates").getDouble(targetCurrency) /
                                  exchangeRates.getJSONObject("rates").getDouble(baseCurrency);
            double convertedAmount = amountToConvert * exchangeRate;

            // Display the result
            System.out.printf("%.2f %s = %.2f %s%n", amountToConvert, baseCurrency, convertedAmount, targetCurrency);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getExchangeRates() throws Exception {
        String apiUrl = "https://open.er-api.com/v6/latest/" + API_KEY;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            return new JSONObject(response.toString());
        } else {
            return null;
        }
    }
}

