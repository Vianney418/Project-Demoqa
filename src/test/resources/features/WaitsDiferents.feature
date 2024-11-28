@Waits

Feature: Explorer with the different Waits

  Scenario: use the Implicit Wait
    Given user visits Dinamically Loaded Page Elements "https://the-internet.herokuapp.com/dynamic_loading/1"
    When the user on click in the button Star
    Then the user should see the following text "Hello World!"