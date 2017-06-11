package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method;

import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method.utils.DoubleMap;
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
public class IndividualImpl extends Individual
{
    private Integer[] fertilizers;
    private Integer[] processedFertilizer;
    private DoubleMap supply;
    private double cost;
    private double fitness;
    private double penalty;

    public IndividualImpl()
    {
        this.supply = new DoubleMap();
        this.generateElement();
    }

    public IndividualImpl(@NotNull Integer[] fertilizers)
    {
        this.fertilizers = fertilizers;
        this.supply = new DoubleMap();
        this.generateElement();
    }

    private void generateElement()
    {
        this.supply.put("nitrogen", 0.0);
        this.supply.put("phosphorus", 0.0);
        this.supply.put("potassium", 0.0);
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

    public DoubleMap getElements()
    {
        return this.supply;
    }

    public void setElements(DoubleMap supply)
    {
        this.supply = supply;
    }

    public void plus(String k, Double v)
    {
        getElements().plus(k, v);
    }

    public void minus(String k, Double v)
    {
        getElements().minus(k, v);
    }

    public void multiply(String k, Double v)
    {
        getElements().multiply(k, v);
    }

    public void divide(String k, Double v)
    {
        getElements().divide(k, v);
    }

    public Double get(String k)
    {
        return supply.get(k);
    }

    public Double put(String key, Double value)
    {
        return supply.put(key, value);
    }

    public void syncProcessedFertilizer(int individualWindow)
    {
        System.arraycopy(this.fertilizers, 0, this.processedFertilizer, 0, individualWindow);
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
                Double.compare(that.penalty, penalty) == 0 &&
                Arrays.equals(getFertilizers(), that.getFertilizers()) &&
                Arrays.equals(getProcessedFertilizer(), that.getProcessedFertilizer()) &&
                Objects.equals(supply, that.supply);
    }

    @Override public int hashCode()
    {
        return Objects.hash(getFertilizers(), getProcessedFertilizer(), getCost(), getFitness(), penalty, supply);
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("IndividualImpl{");
        sb.append("fertilizers=").append(Arrays.toString(fertilizers));
        sb.append(", processedFertilizer=").append(Arrays.toString(processedFertilizer));
        sb.append(", cost=").append(cost);
        sb.append(", fitness=").append(fitness);
        sb.append(", penalty=").append(penalty);
        sb.append(", supply=").append(supply);
        sb.append('}');
        return sb.toString();
    }
}
