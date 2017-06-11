package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method;

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
    private double nitrogenFactor;
    private double phosphorusFactor;
    private double potassiumFactor;

    public SettingImpl()
    {
    }

    public SettingImpl(int populationSize, double crossoverRate, double mutationRate)
    {
        super(populationSize, crossoverRate, mutationRate);
    }

    public SettingImpl(int populationSize, double crossoverRate, double mutationRate, int individualWindow, int generationCount, double nitrogenFactor, double phosphorusFactor, double potassiumFactor)
    {
        super(populationSize, crossoverRate, mutationRate);
        this.individualWindow = individualWindow;
        this.generationCount = generationCount;
        this.nitrogenFactor = nitrogenFactor;
        this.phosphorusFactor = phosphorusFactor;
        this.potassiumFactor = potassiumFactor;
    }

    public int getIndividualWindow()
    {
        return this.individualWindow;
    }

    public void setIndividualWindow(int individualWindow)
    {
        this.individualWindow = individualWindow;
    }

    public double getNitrogenFactor()
    {
        return this.nitrogenFactor;
    }

    public void setNitrogenFactor(double nitrogenFactor)
    {
        this.nitrogenFactor = nitrogenFactor;
    }

    public double getPhosphorusFactor()
    {
        return this.phosphorusFactor;
    }

    public void setPhosphorusFactor(double phosphorusFactor)
    {
        this.phosphorusFactor = phosphorusFactor;
    }

    public double getPotassiumFactor()
    {
        return this.potassiumFactor;
    }

    public void setPotassiumFactor(double potassiumFactor)
    {
        this.potassiumFactor = potassiumFactor;
    }

    public int getGenerationCount()
    {
        return this.generationCount;
    }

    public void setGenerationCount(int generationCount)
    {
        this.generationCount = generationCount;
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
                Double.compare(setting.getNitrogenFactor(), getNitrogenFactor()) == 0 &&
                Double.compare(setting.getPhosphorusFactor(), getPhosphorusFactor()) == 0 &&
                Double.compare(setting.getPotassiumFactor(), getPotassiumFactor()) == 0;
    }

    @Override public int hashCode()
    {
        return Objects.hash(super.hashCode(), getIndividualWindow(), getGenerationCount(), getNitrogenFactor(), getPhosphorusFactor(), getPotassiumFactor());
    }

    @Override public String toString()
    {
        return "SettingImpl{" + "populationSize=" + populationSize +
                ", crossoverRate=" + crossoverRate +
                ", mutationRate=" + mutationRate +
                ", individualWindow=" + individualWindow +
                ", generationCount=" + generationCount +
                ", nitrogenFactor=" + nitrogenFactor +
                ", phosphorusFactor=" + phosphorusFactor +
                ", potassiumFactor=" + potassiumFactor +
                '}';
    }
}
