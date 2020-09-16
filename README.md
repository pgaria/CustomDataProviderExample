# CustomDataProviderExample
Skip Certain Test Iterations in TestNG DataProvider from the @Test, Provide the Start and End Index from the Test which cases you want to Run from DataProvider.

The number of tests is the number of rows returned by the @DataProvider method, So need to somehow pass how many rows we want from the dataprovider. Like Example our Data provider can have 100 rows.
But We would like to Run the First 10 only hen we need to pass the Index from Test.

The solution is then to return the correct number of test cases from the method annotated by @DataProvider.


