package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method;

import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method.utils.String2DoubleMap;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method.Setting;
import java.util.Objects;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 08 June 2017, 11:41 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings({"SameParameterValue"}) public class SettingImpl extends Setting
{
    private int individualWindow;
    private int generationCount;
    private int cutPoint;
    private String2DoubleMap factor;

    public SettingImpl()
    {
        this.factor = new String2DoubleMap();
        this.generateElement();
    }

    public SettingImpl(int individualWindow, int generationCount, int cutPoint, double nitrogenFactor, double phosphorusFactor, double potassiumFactor)
    {
        this.individualWindow = individualWindow;
        this.generationCount = generationCount;
        this.cutPoint = cutPoint;
        this.factor = new String2DoubleMap();
        this.generateElement();
        this.putFactor("nitrogen", nitrogenFactor);
        this.putFactor("phosphorus", phosphorusFactor);
        this.putFactor("potassium", potassiumFactor);
    }

    public SettingImpl(int populationSize, double crossoverRate, double mutationRate, int individualWindow, int generationCount, int cutPoint, double nitrogenFactor, double phosphorusFactor, double potassiumFactor)
    {
        super(populationSize, crossoverRate, mutationRate);
        this.individualWindow = individualWindow;
        this.generationCount = generationCount;
        this.cutPoint = cutPoint;
        this.factor = new String2DoubleMap();
        this.generateElement();
        this.putFactor("nitrogen", nitrogenFactor);
        this.putFactor("phosphorus", phosphorusFactor);
        this.putFactor("potassium", potassiumFactor);

    }

    private void generateElement()
    {
        this.putFactor("nitrogen", 0.0);
        this.putFactor("phosphorus", 0.0);
        this.putFactor("potassium", 0.0);
    }

    public int getIndividualWindow()
    {
        return this.individualWindow;
    }

    public void setIndividualWindow(int individualWindow)
    {
        this.individualWindow = individualWindow;
    }

    public String2DoubleMap getFactor()
    {
        return this.factor;
    }

    public void setFactor(String2DoubleMap factor)
    {
        this.factor = factor;
    }

    public Double getFactor(String key)
    {
        return getFactor().get(key);
    }

    public Double putFactor(String key, Double value)
    {
        return getFactor().put(key, value);
    }

    public int getGenerationCount()
    {
        return this.generationCount;
    }

    public void setGenerationCount(int generationCount)
    {
        this.generationCount = generationCount;
    }

    public int getCutPoint()
    {
        return this.cutPoint;
    }

    public void setCutPoint(int cutPoint)
    {
        this.cutPoint = cutPoint;
    }

    @Override public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof SettingImpl))
        {
            return false;
        }
        if(!super.equals(o))
        {
            return false;
        }
        SettingImpl setting = (SettingImpl) o;
        return getIndividualWindow() == setting.getIndividualWindow() &&
                getGenerationCount() == setting.getGenerationCount() &&
                getCutPoint() == setting.getCutPoint() &&
                Objects.equals(getFactor(), setting.getFactor());
    }

    @Override public int hashCode()
    {
        return Objects.hash(super.hashCode(), getIndividualWindow(), getGenerationCount(), getCutPoint(), getFactor());
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("SettingImpl{");
        sb.append("populationSize=").append(populationSize);
        sb.append(", crossoverSize=").append(crossoverSize);
        sb.append(", mutationSize=").append(mutationSize);
        sb.append(", crossoverRate=").append(crossoverRate);
        sb.append(", mutationRate=").append(mutationRate);
        sb.append(", individualWindow=").append(individualWindow);
        sb.append(", generationCount=").append(generationCount);
        sb.append(", cutPoint=").append(cutPoint);
        sb.append(", factor=").append(factor);
        sb.append('}');
        return sb.toString();
    }
}
