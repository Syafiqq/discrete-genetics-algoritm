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
    protected int crossoverSize;
    protected int mutationSize;
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
        this.setCrossoverSize(this.getPopulationSize(), this.getCrossoverRate());
        this.setMutationSize(this.getPopulationSize(), this.getMutationRate());
    }

    public double getCrossoverRate()
    {
        return this.crossoverRate;
    }

    public void setCrossoverRate(double crossoverRate)
    {
        this.crossoverRate = crossoverRate;
        this.setCrossoverSize(this.getPopulationSize(), this.getCrossoverRate());
        this.setMutationSize(this.getPopulationSize(), this.getMutationRate());
    }

    public double getMutationRate()
    {
        return this.mutationRate;
    }

    public void setMutationRate(double mutationRate)
    {
        this.mutationRate = mutationRate;
        this.setCrossoverSize(this.getPopulationSize(), this.getCrossoverRate());
        this.setMutationSize(this.getPopulationSize(), this.getMutationRate());
    }

    public int getCrossoverSize()
    {
        return this.crossoverSize;
    }

    private void setCrossoverSize(int populationSize, double crossoverRate)
    {
        this.crossoverSize = (int) Math.round(populationSize * crossoverRate);
    }

    public int getMutationSize()
    {
        return this.mutationSize;
    }

    private void setMutationSize(int populationSize, double mutationRate)
    {
        this.mutationSize = (int) Math.round(populationSize * mutationRate);
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
                getCrossoverSize() == setting.getCrossoverSize() &&
                getMutationSize() == setting.getMutationSize() &&
                Double.compare(setting.getCrossoverRate(), getCrossoverRate()) == 0 &&
                Double.compare(setting.getMutationRate(), getMutationRate()) == 0;
    }

    @Override public int hashCode()
    {
        return Objects.hash(getPopulationSize(), getCrossoverSize(), getMutationSize(), getCrossoverRate(), getMutationRate());
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("Setting{");
        sb.append("populationSize=").append(populationSize);
        sb.append(", crossoverSize=").append(crossoverSize);
        sb.append(", mutationSize=").append(mutationSize);
        sb.append(", crossoverRate=").append(crossoverRate);
        sb.append(", mutationRate=").append(mutationRate);
        sb.append('}');
        return sb.toString();
    }
}
