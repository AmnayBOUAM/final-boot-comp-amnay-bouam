package org.amnay.reporting;

import com.relevantcodes.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.Reporter;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    private static ITestContext context;

    public synchronized static ExtentReports getInstance(){
        if(extent == null){
            File outputDirectory = new File(context.getOutputDirectory());
            File resultDirectory = new File(outputDirectory.getParentFile(),"html");
            extent = new ExtentReports(System.getProperty("user.dir")+"/extent-report/extent-report.html", true);
            Reporter.log("Extent Report Directory"+ resultDirectory, true);
            extent.addSystemInfo("Host Name", "Amnay").addSystemInfo("Environment","QA")
                    .addSystemInfo("User Name", "Amnay BOUAM");
            extent.loadConfig(new File(System.getProperty("user.dir")+ "/report-config.xml"));
        }
        return extent;
    }

    public static void setOutputDirectory(ITestContext context){
        ExtentManager.context = context;

    }
}
