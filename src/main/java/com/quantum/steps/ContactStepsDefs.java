package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.quantum.utils.DeviceUtils;
import cucumber.api.java.en.*;

import java.util.HashMap;
import java.util.Map;

import static com.qmetry.qaf.automation.step.CommonStep.click;

/**
 * Created by yaronw on 08/10/2017.
 */
@QAFTestStepProvider
public class ContactStepsDefs extends WebDriverTestBase  {

    public String Platform = getDriver().getCapabilities().getCapability("os").toString();

    @When("I launch Contacts application")
    public void I_launch_contacts() throws Throwable {
        System.out.println("platform" + Platform);
        switch (Platform) {
            case "Android":
                try {DeviceUtils.closeApp("com.android.contacts", "identifier");}catch (Exception e){};
                DeviceUtils.startApp("com.android.contacts", "identifier");
                break;
            case "iOS":
                try{DeviceUtils.closeApp("Phone", "name");} catch (Exception e){};
                DeviceUtils.startApp("Phone", "name");
                break;

            default:
                throw new IllegalArgumentException("Invalid Platform: " + Platform);
        }
         DeviceUtils.waitForPresentTextVisual("contacts", 20);
    }

    @When("I Add Contact with name \"([^\"]*)\" and number  \"([^\"]*)\"$")
    public void I_add_contact_with_name(String contactName, String phoneNumber) throws Throwable {
        DeviceUtils.switchToContext("NATIVE");
        if (!isAndroid()) {
            System.out.println("this is an iOS");
            click("contacts.page");
          /*  click("add.contact.btn");
            getDriver().findElement("add.name").sendKeys(contactName);
            Thread.sleep(2000);
            getDriver().findElement("phone.field").click();
            Thread.sleep(2000);
            getDriver().findElement("add.phone").sendKeys(phoneNumber);
*/

          //  return;
        }



        //Add contact
        click("add.contact.btn");
       // DeviceUtils.waitForPresentTextVisual("Phone Number", 20);
        //Insert name and number
        getDriver().findElement("add.name").sendKeys(contactName);
        Thread.sleep(2000);
        getDriver().findElement("phone.field").click();
        Thread.sleep(2000);
        getDriver().findElement("add.phone").sendKeys(phoneNumber);
        DeviceUtils.waitForPresentTextVisual(phoneNumber, 20);
        //Save contact
        click("save.contact");
        return;
       // DeviceUtils.waitForPresentTextVisual("to view recent events", 20);
        //return to main screen
      //  click("back");
       // DeviceUtils.waitForPresentTextVisual("contacts groups more", 20);
    }

    @When("I Delete Contact \"([^\"]*)\"$")
    public void I_delete_contact(String searchKey) throws Throwable {
        //go to contact
        Map<String, Object> params = new HashMap<>();
        params.put("label", searchKey);
        getDriver().executeScript("mobile:button-text:click", params);
        click("more");
        Thread.sleep(2000);
        click("delete");
        Thread.sleep(2000);
        click("delete.confirm");
    }

    private boolean isAndroid () {

        return getDriver().getCapabilities().getCapability("platform").toString().equalsIgnoreCase("Android");

    }











}


