package com.ambTestLab;

import org.openqa.selenium.By;

public class userSIPCalculatorPage {

    // Form Fields
    public static By minimunAmount = By.xpath("//form[@id='sipForm']//following-sibling::input[@id='monthlyAmount']");
    public static By title = By.xpath("//h3[normalize-space(text())='SIP Calculator']");
    public static By years = By.xpath("//form[@id='sipForm']//following-sibling::input[@id='years']");
    public static By expectedAnnualReturn = By.xpath("//form[@id='sipForm']//following-sibling::input[@id='expectedReturn']");
    public static By submitButton = By.xpath("//button[@type='submit']");

    // Table Data
    public static By tableData = By.xpath("//table//tr//td[1]");
    public static By deleteBtn = By.xpath("//table//tr[%s]//td//button[contains(@onclick,'deleteCalculation')]");
    // use String.format(deleteBtn, rowIndex)

    // SIP Calculation Results
    public static By totalInvested = By.xpath("//div[@id='resultCard']//h3[@id='totalInvested']");
    public static By estFutureValue = By.xpath("//div[@id='resultCard']//h3[@id='futureValue']");
    public static By estReturns = By.xpath("//div[@id='resultCard']//h3[@id='estimatedReturns']");

    // Graphs
    public static By monthlyInvestmentDistribution = By.xpath("//h5[normalize-space(.)='Monthly Investment Distribution (Bar)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='rect']");
    public static By monthlyInvestmentDistributionColumn = By.xpath("//h5[normalize-space(.)='Monthly Investment Distribution (Column)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='rect']");
    public static By futureValueHistogram = By.xpath("//h5[normalize-space(.)='Future Value Histogram']//parent::div//*[name()='svg']//*[name()='g']//*[name()='rect']");
    public static By returnRateDistributionValues = By.xpath("//h5[normalize-space(.)='Return Rate Distribution (Pie)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='text']");
    public static By returnRateDistributionRange = By.xpath("//h5[normalize-space(.)='Return Rate Distribution (Pie)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='path']");
    public static By investmentDurationValues = By.xpath("//h5[normalize-space(.)='Investment Duration (Donut)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='text']");
    public static By investmentDurationRange = By.xpath("//h5[normalize-space(.)='Investment Duration (Donut)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='path']");
    public static By investmentJourneyFunnelValue = By.xpath("//h5[normalize-space(.)='Investment Journey Funnel']//parent::div//*[name()='svg']//*[name()='text']");
    public static By investmentJourneyFunnelRange = By.xpath("//h5[normalize-space(.)='Investment Journey Funnel']//parent::div//*[name()='svg']//*[name()='path']");
    public static By futureValueTrends = By.xpath("//h5[normalize-space(.)='Future Value Trends (Line)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='circle']");
    public static By returnsAnalysis = By.xpath("//h5[normalize-space(.)='Returns Analysis (Area)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='circle']");
    public static By returnsContribution = By.xpath("//h5[normalize-space(.)='Returns Contribution (Waterfall)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='rect']");
    public static By amountVsReturn = By.xpath("//h5[normalize-space(.)='Amount vs Return (Scatter)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='circle']");
    public static By tenureVsGrowth = By.xpath("//h5[normalize-space(.)='Tenure vs Growth (Bubble)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='circle']");
    public static By durationRadarProfile = By.xpath("//h5[normalize-space(.)='Duration Radar Profile']//parent::div//*[name()='svg']//*[name()='g']//*[name()='circle']");
    public static By futureValueTreemap = By.xpath("//h5[normalize-space(.)='Future Value Treemap']//parent::div//*[name()='svg']//*[name()='text']");
    public static By durationVsReturnHeatmap = By.xpath("//h5[normalize-space(.)='Duration vs Return Heatmap']//parent::div//*[name()='svg']//*[name()='g']//*[name()='rect']");
    public static By sipTimeline = By.xpath("//h5[normalize-space(.)='SIP Timeline (Gantt)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='rect']");
    public static By distributionOverview = By.xpath("//h5[normalize-space(.)='Distribution Overview (Box Plot)']//parent::div//*[name()='svg']//*[name()='g']//*[name()='rect']");

}
