package com.quantum.utils;



import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.quantum.utils.DeviceUtils;
public class QuantumCourseUtils extends WebDriverTestBase {

     public String platform = getDriver().getCapabilities().getCapability("platformName").toString();


    public boolean isAndroid () {

        return getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("Android");

    }
    public boolean isText(String text, int timeout) {

        Map<String, Object> params = new HashMap<>();
        params.put("content",text);
        params.put("timeout",timeout);
        String res = getDriver().executeScript("mobile:checkpoint:text", params).toString();

        if (res.equalsIgnoreCase("true")) {
            System.out.println("checkpoint is: " +res);
            return true;
        } else {
            System.out.println("checkpoint is: " +res);

            return false;
        }
    }


}
