package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method;

import java.util.Objects;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 07 June 2017, 3:17 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings({"WeakerAccess", "unused"}) public class Setting
{
    protected int populationSize;
    protected double crossoverRate;
    protected double mutationRate;

    public Setting()
    {
    }

    public Setting(int populationSize, double crossoverRate, double mutationRate)
    {
        this.populationSize = populationSize;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
    }

    public int getPopulationSize()
    {
        return this.populationSize;
    }

    public void setPopulationSize(int populationSize)
    {
        this.populationSize = populationSize;
    }

    public double getCrossoverRate()
    {
        return this.crossoverRate;
    }

    public void setCrossoverRate(double crossoverRate)
    {
        this.crossoverRate = crossoverRate;
    }

    public double getMutationRate()
    {
        return this.mutationRate;
    }

    public void setMutationRate(double mutationRate)
    {
        this.mutationRate = mutationRate;
    }

    @Override public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof Setting))
        {
            return false;
        }
        Setting setting = (Setting) o;
        return getPopulationSize() == setting.getPopulationSize() &&
                Double.compare(setting.getCrossoverRate(), getCrossoverRate()) == 0 &&
                Double.compare(setting.getMutationRate(), getMutationRate()) == 0;
    }

    @Override public int hashCode()
    {
        return Objects.hash(getPopulationSize(), getCrossoverRate(), getMutationRate());
    }

    @Override public String toString()
    {
        return "Setting{" + "populationSize=" + populationSize +
                ", crossoverRate=" + crossoverRate +
                ", mutationRate=" + mutationRate +
                '}';
    }
}
