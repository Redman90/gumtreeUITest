Feature: API Test

Scenario: Validate the response type, response code, headers and some of the data displayed

Given url 'https://ecg-api.gumtree.com.au/api/papi/ads/search?categoryId=0&categoryRedirected=1&includeTopAds=1&keyword=Table&locationId=3003435&page=1&size=20&sortType=DATE_DESCENDING'
When method GET
Then status 200
And match responseType == 'json'
And match responseHeaders['Server'][0] == 'rhino-core-shield'
And match responseHeaders['Content-Type'][0] == 'application/json;charset=UTF-8'
And print response.ads[0]
And match each response.ads contains {"id" : "#number"} 
And match each response.ads contains {"title" : "#string"}
 

