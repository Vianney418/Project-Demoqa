Feature:Test the Form

  Scenario: Test the form and verify personal data and file upload
    /* Given theuser visit Demoqa "https://demoqa.com/"
    /* When the user goes to Forms
    /* And




    Given user visits Demoqa page "https://demoqa.com/"
    When the user goes to Elements
    And the user clicks on Text Box
    And the user fills out the text box form with the following details:
      | Full Name          |   Email                |   Current Address      | Permanent Address     |
      | Vianney Perdomo    | medicenney13@gmail.com | Bombero Guillermo 355  |  Puerto Soberania 123 |
    And the user clicks on Submit
    Then user will see the following message "Name:Vianney Perdomo"