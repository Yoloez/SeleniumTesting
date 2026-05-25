@login @regression
Feature: Login Functionality
  Sebagai pengguna, saya ingin bisa masuk ke dalam sistem
  sehingga saya bisa mengakses halaman dashboard.

  @positive @smoke
  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enters valid username and password
    And user clicks the login button
    Then user should be redirected to the dashboard

  @negative @smokes
  Scenario: Unsuccessful login with invalid credentials
    Given user is on the login page
    When user enters invalid username and password
    And user clicks the login button
    Then user should see an error message