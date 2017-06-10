package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method;

import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method.Individual;
import java.util.Arrays;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 08 June 2017, 11:35 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings({"WeakerAccess", "unused"}) public class IndividualImpl extends Individual
{
    private Integer[] fertilizers;
    private Integer[] processedFertilizer;
    private double cost;
    private double fitness;

    public IndividualImpl()
    {
    }

    public IndividualImpl(@NotNull Integer[] fertilizers)
    {
        this.fertilizers = fertilizers;
    }

    public Integer[] getFertilizers()
    {
        return this.fertilizers;
    }

    public void setFertilizers(Integer[] fertilizers)
    {
        this.fertilizers = fertilizers;
    }

    public double getCost()
    {
        return this.cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public double getFitness()
    {
        return this.fitness;
    }

    public void setFitness(double fitness)
    {
        this.fitness = fitness;
    }

    public Integer[] getProcessedFertilizer()
    {
        return this.processedFertilizer;
    }

    public void setProcessedFertilizer(Integer[] processedFertilizer)
    {
        this.processedFertilizer = processedFertilizer;
    }

    @Override public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof IndividualImpl))
        {
            return false;
        }
        IndividualImpl that = (IndividualImpl) o;
        return Double.compare(that.getCost(), getCost()) == 0 &&
                Double.compare(that.getFitness(), getFitness()) == 0 &&
                Arrays.equals(getFertilizers(), that.getFertilizers()) &&
                Arrays.equals(getProcessedFertilizer(), that.getProcessedFertilizer());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getFertilizers(), getCost(), getFitness(), getProcessedFertilizer());
    }

    @Override public String toString()
    {
        return "IndividualImpl{" + "fertilizers=" + Arrays.toString(fertilizers) +
                ", cost=" + cost +
                ", fitness=" + fitness +
                ", processedFertilizer=" + Arrays.toString(processedFertilizer) +
                '}';
    }

    public void syncProcessedFertilizer(int individualWindow)
    {
        System.arraycopy(this.fertilizers, 0, this.processedFertilizer, 0, individualWindow);
    }
}
