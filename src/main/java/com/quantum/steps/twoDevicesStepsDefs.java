package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.utils.DeviceUtils;
import cucumber.api.java.en.When;
import org.testng.annotations.Test;
import com.quantum.utils.moreActions;

/**
 * Created by uzie on 1/23/17.
 */
@QAFTestStepProvider
public class twoDevicesStepsDefs extends WebDriverTestCase {


    /**
     *  Send SMS from one device (perfecto) to second device (perfectodevii)
     *
     */


    @When("I Launch application on Device \"([^\"]*)\"$")
    public void launch_app_device(String device) throws Throwable {
        moreActions.switchToDriver(device);
        openApp();

    }
    //  @Test(description="SendSMS", groups={"@twoDevicesSMS"})
    @When("I send SMS from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void SendSMS(String firstDevice, String secondDevice) {


        //String PhoneBNum = "13392344376";
        final String msg = "Test Message";

        moreActions.switchToDriver(firstDevice);
        //openApp();

        moreActions.switchToDriver(secondDevice);
        //openApp();
        String PhoneBNum = moreActions.getDevicePhoneNumber();

        //device A (send SMS)
        moreActions.switchToDriver(firstDevice);


        getDriver().findElement("newMessage.buton").click();
        getDriver().findElement("recipients.editor").sendKeys(PhoneBNum);
        getDriver().findElement("editorbody.text").sendKeys(msg);
        getDriver().findElement("send.button").click();


        //deviceB
        moreActions.switchToDriver(secondDevice);
        DeviceUtils.assertVisualText(msg);

    }


    private void openApp()
    {

      //  String appPackage = (String)getDriver().getCapabilities().getCapability("appPackage");
        try {
            DeviceUtils.closeApp("Messages", "name");

        }catch (Exception e)
        {
            //nothing
        }
        DeviceUtils.startApp("Messages", "name");
    }



    private void sleep(int ms)

    {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
