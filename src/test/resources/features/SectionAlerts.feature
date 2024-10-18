@AlertFrameWindowsDemoqa


Feature:Check the different elements of the Alert, Frame, and Windows sections.

  Scenario: Check the Browser Windows section, New Tap
    Given user visits Demoqa page "https://demoqa.com/"
    When the user goes to Elements
    And the user clicks on Browser Windows
    Then the user clicks on new tap and should see the text "This is a sample page"
    And the user closes window handle
    Then The user returns to the browser page and should see the following text "Browser Windows"

#
#  Scenario: Check the Browser Windows section, New Tap
#    Given user visits Demoqa page "https://demoqa.com/"
#    When the user goes to Elements
#    And the user clicks on Browser Windows
#    Then the user clicks on new window and the user should see a new window and the following text "This is a sample page"
#    And the user closes that Window
#    Then The user returns to the browser page and should see the following text "Browser Windows"


#  Scenario: Check the Browser Windows section, New Tap
#    Given user visits Demoqa Page "https://demoqa.com/"
#    When the user goes to elements
#    And the user clicks on Browser Windows
#    And the user clicks on new window Message
#    Then the user should see a new Window and the following text "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."
#    And the user Closes that Window
#    Then The user returns to the browser page and should see the following text "Browser Windows"