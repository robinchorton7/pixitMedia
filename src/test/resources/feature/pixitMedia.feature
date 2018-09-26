Feature: pixitmedia test test
  search, verify pdf download and complete contact us form

  Scenario Outline: login with error
    Given I navigate to "http://google.co.uk"
    When I search for "pixitmedia"
    And I select the "PRODUCTS" menu
    And I select the "PixStor" product link
    Then the "VIEW DATASHEET" button returns a pdf download
    And I select the "CONTACT US" menu
    And I complete the form with "<first>", "<last>">, "<email>", "<organisation>", "<contactNumber>","<subject>" and "<message>"
    Then I can submit the form
  Examples:
  | first | last  | email | organisation  | contactNumber | subject | message |
  | Robin | Horton  | robinnn16@hotmail.co.uk | test  | 07956897113 | Automated test  | This is a test for Jez |
