@Perfecto
  Feature: Multiple Devices
    @twoDevicesSMS
  Scenario: Send SMS
  When I Launch application on Device "perfecto"
  And I Launch application on Device "perfectodevii"
  Then I send SMS from "perfecto" to "perfectodevii"
  #get phone number of device 1
  #store into ...
  #send message from device 2 to "phone number of 1"
  #validate message  on 1 received