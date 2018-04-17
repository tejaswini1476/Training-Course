@Perfecto
  Feature: Multiple Devices
    @twoDevicesSMS
  Scenario: Send SMS
      And I Launch application on Device "perfectodevii"
      When I Launch application on Device "perfecto"
      Then I send SMS from "perfecto" to "perfectodevii"

