package com.quantum.steps;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.quantum.utils.DeviceUtils;
import cucumber.api.java.en.*;

import com.quantum.utils.QuantumCourseUtils;
import java.util.HashMap;
import java.util.Map;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;

/**
 * Created by yaronw on 08/10/2017.
 */
@QAFTestStepProvider
public class ContactStepsDefs extends QuantumCourseUtils  {


    @When("I launch Contacts application")
    public void I_launch_contacts() throws Throwable {

        System.out.println("platform:" + platform);

        switch (platform) {
            case "Android":
                try {DeviceUtils.closeApp("Contacts", "name");}catch (Exception e){};
                DeviceUtils.startApp("Contacts", "name");
                break;
            case "iOS":
                try{DeviceUtils.closeApp("Phone", "name");} catch (Exception e){};
                DeviceUtils.startApp("Phone", "name");
                break;

            default:
                throw new IllegalArgumentException("Invalid Platform: " + platform);
        }
         DeviceUtils.waitForPresentTextVisual("contacts", 20);



    }

    @When("I Add Contact with name \"([^\"]*)\" and number  \"([^\"]*)\"$")
    public void I_add_contact_with_name(String contactName, String phoneNumber) throws Throwable {
        DeviceUtils.switchToContext("NATIVE");

        if (!isAndroid()) {
            System.out.println("this is an iOS");
            getDriver().findElement("contacts.page").click();
        }

        //Add contact
        click("add.contact.btn");
        // in some Android devices, after clicking on add contact, a popup appears asking which account to save the contact under
        //we will look for this and if it appears select the device option
        if (isAndroid()) {

            if(isText("Save contacts to",20)) {
                getDriver().findElement("save.phone").click();
            }

            //Insert name and number

        }
        DeviceUtils.waitForPresentTextVisual("Phone", 20);
        //Insert name and number
        getDriver().findElement("add.name").sendKeys(contactName);
        Thread.sleep(2000);
        getDriver().findElement("phone.field").click();
        Thread.sleep(2000);
        getDriver().findElement("add.phone").sendKeys(phoneNumber);
        DeviceUtils.waitForPresentTextVisual(phoneNumber, 20);
        //Save contact

        getDriver().findElement("save.contact").click();

        if (isAndroid()) {
            DeviceUtils.waitForPresentTextVisual("connected via", 20);
            //return to main screen
            getDriver().findElement("back").click();
            DeviceUtils.waitForPresentTextVisual("contacts groups more", 20);
        }


    }

    @When("I Delete Contact \"([^\"]*)\"$")
    public void I_delete_contact(String searchKey) throws Throwable {

    }

    @When("I Check if Contact \"([^\"]*)\" and delete$")
    public void check_contact_exist_delete(String searchKey) throws Throwable {

        getDriver().findElement("search.contact").sendKeys(searchKey);
        //trying to look for the no contacts found object. if it is NOT found when we will assume the contact exists and delete
        try {
             getDriver().findElement("no.contacts").getText();
        }catch(Exception e) {
            //The  catch is executed when the "no contacs found is not present, so we assume the contact exists.
        }


    }
}


