package com.quantum.utils;



import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.quantum.utils.DeviceUtils;
public class QuantumCourseUtils extends WebDriverTestBase {

    public String platform = getDriver().getCapabilities().getCapability("os").toString();


    public boolean isAndroid () {

        return getDriver().getCapabilities().getCapability("os").toString().equalsIgnoreCase("Android");

    }
}
