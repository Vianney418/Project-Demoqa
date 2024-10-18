@AlertsDemoqa

Feature:Validate the different buttons to generate alerts

  Scenario:Validate the different buttons to generate alerts
    Given user visits Demoqa page "https://demoqa.com/"
    When the user goes to Alerts, Frame & Windows
    And the user clicks on Alerts
    And the user click button to see alert and he clicks in aceptar
#    And the user clicks the button for 5 seconds and he clicks on aceptar
    And the user on button click, confirm box will appear and Aceptar
    Then the user should see "You selected Ok"
    And the user on button click, confirm box will appear and Cancelar
#    Then the user should see "You selected Cancel"
#    And the user On button click, prompt box will appear and write his name "Vianney Perdomo"
#    Then the user should see "You entered Vianney Perdomo"
