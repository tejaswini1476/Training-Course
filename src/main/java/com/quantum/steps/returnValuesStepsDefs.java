package com.quantum.steps;


import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.QuantumCourseUtils;
import cucumber.api.java.en.When;

@QAFTestStepProvider

public class returnValuesStepsDefs extends QuantumCourseUtils {

    @When("I check chance of rain")
    public String checkRain() {


        String rain="22";
        return rain;
    }

    @When("Do i need an umbrella \"([^\"]*)\"$")
    public static void needUmbrella(String rainChance) {


        System.out.println(rainChance);






    }



}
