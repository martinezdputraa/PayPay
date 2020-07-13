# PayPay
The project is using these following libraries:
1. RxJava2
2. Retrofit
3. Android Architecture Components
4. Room
5. Dagger 2

There were some limitations due to free account restriction:
1. Only http calls are supported
2. The only supported currency is USD

<b>Local caching with Room.<b>
Different data has different caching behavior:

List of Currencies: will be persisted forever once a set of data has been successfully fetched unless local storage gets destroyed by the user(uninstall, clear cache, etc)

List of Conversion Rates: Will be persisted for 30 minutes for the selected currency.
ex case:
<ol>
  <li>User selects USD, succssfully fetched rate data, save to cache</li>
  <li>User selects another currency, fetch failed</li>
  <li>User selects USD again, check whether it has been 30 minutes since the last fetch for USD. if no, then get the local cache, otherwise fetch and update cache</li>
</ol>
