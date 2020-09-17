# CustomDataProviderExample
Skip Certain Test Iterations in TestNG DataProvider from the @Test, Provide the Start and End Index from the Test which cases you want to Run from DataProvider.

The number of tests is the number of rows returned by the @DataProvider method, So need to somehow pass how many rows we want from the dataprovider. Like Example our Data provider can have 100 rows.
But We would like to Run the First 10 only hen we need to pass the Index from Test.

The solution is then to return the correct number of test cases from the method annotated by @DataProvider.

Same Data provider can be used as a Normal no Index defined and all the Test Data would Run.
```java
@Test(dataProvider = "getData", dataProviderClass = ReadAutoData.class)
public void normalTest(String userName, String password) {
        System.out.println("Running Normal Test for " + userName + " and " + password);
    }
```    
Example where we are passing the Index Start and End and only those Tests would Run from the Data Provider.
```java
@IndexAnnotation(startIndex = 0, endIndex = 4)
@Test(dataProvider = "getData", dataProviderClass = ReadAutoData.class)
public void withCustomIndex(String userName, String password) {
        System.out.println("Running Custom Test [0 -> 4 ] for " + userName + " and " + password);
    }
```    

You can cerate multiple Tests with the Custome Indexes and You can run the tests Parallel as well in the implementation. 
