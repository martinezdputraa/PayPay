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

### Local caching with Room

Different data has different caching behavior

List of Currencies: will be persisted forever once a set of data has been successfully fetched unless local storage gets destroyed by the user(uninstall, clear cache, etc)

List of Conversion Rates: Will be persisted for 30 minutes for the selected currency.
ex case:
1. User selects USD
2. Successfully fetched rate data, no cache for USD yet, save to cache
3. User selects another currency, fetch failed, nothing gets saved to the cache
4. User selects USD again
5. check whether it has been 30 minutes since the last fetch for USD. if no, then get the local cache, otherwise fetch and update cache

### Functional Requirements:
[x] Exchange rates must be fetched from: https://currencylayer.com/documentation
[x] Use free API Access Key for using the API
[x] User must be able to select a currency from a list of currencies provided by the API(for currencies that are not available, convert them on the app side. When converting, floating-point error is accpetable)
[x] User must be able to enter desired amount for selected currency
[x] User should then see a list of exchange rates for the selected currency
[x] Rates should be persisted locally and refreshed no more frequently than every 30 minutes (to limit bandwidth usage)

### UI Suggestion:
[x] Some way to select a currency
[x] Some text entry widget to enter the amount
[x] A list/grid of exchange rates
[x] It doesn’t need to be super pretty, but it shouldn’t be broken as well ;)
