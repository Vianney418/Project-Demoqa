@TableCycle

Feature:Extract data from a table and validate

  Scenario: Use loops to extract a country from the countries table
    Given the user visits W3School Page "https://www.w3schools.com/html/html_tables.asp"
    When the user look that country is in the table
   Then the user verifies that Germany is in the table