package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method;

import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method.utils.Int2DoubleMap;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method.utils.String2DoubleMap;
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
    private String2DoubleMap content;
    private Int2DoubleMap supply;
    private double cost;
    private double fitness;
    private double penalty;

    public IndividualImpl()
    {
        this.content = new String2DoubleMap();
        this.supply = new Int2DoubleMap();
        this.generateElement();
    }

    public IndividualImpl(@NotNull Integer[] fertilizers)
    {
        this.fertilizers = fertilizers;
        this.content = new String2DoubleMap();
        this.supply = new Int2DoubleMap();
        this.generateElement();
    }

    private void generateElement()
    {
        this.content.put("nitrogen", 0.0);
        this.content.put("phosphorus", 0.0);
        this.content.put("potassium", 0.0);
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

    public String2DoubleMap getContent()
    {
        return this.content;
    }

    public void setContent(String2DoubleMap supply)
    {
        this.content = supply;
    }

    public Int2DoubleMap getSupply()
    {
        return this.supply;
    }

    public void setSupply(Int2DoubleMap supply)
    {
        this.supply = supply;
    }

    public void plusContent(String k, Double v)
    {
        getContent().plus(k, v);
    }

    public void minusContent(String k, Double v)
    {
        getContent().minus(k, v);
    }

    public void multiplyContent(String k, Double v)
    {
        getContent().multiply(k, v);
    }

    public void divideContent(String k, Double v)
    {
        getContent().divide(k, v);
    }

    public Double getContent(String k)
    {
        return content.get(k);
    }

    public Double putContent(String key, Double value)
    {
        return content.put(key, value);
    }

    public Double getSupply(Integer key)
    {
        return getSupply().get(key);
    }

    public void clearSupply()
    {
        getSupply().clear();
    }

    public Double putSupply(Integer key, Double value)
    {
        return getSupply().put(key, value);
    }

    public double getPenalty()
    {
        return this.penalty;
    }

    public void setPenalty(double penalty)
    {
        this.penalty = penalty;
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
                Double.compare(that.getPenalty(), getPenalty()) == 0 &&
                Arrays.equals(getFertilizers(), that.getFertilizers()) &&
                Arrays.equals(getProcessedFertilizer(), that.getProcessedFertilizer()) &&
                Objects.equals(getContent(), that.getContent()) &&
                Objects.equals(getSupply(), that.getSupply());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getFertilizers(), getProcessedFertilizer(), getContent(), getSupply(), getCost(), getFitness(), getPenalty());
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("IndividualImpl{");
        sb.append("fertilizers=").append(Arrays.toString(fertilizers));
        sb.append(", processedFertilizer=").append(Arrays.toString(processedFertilizer));
        sb.append(", content=").append(content);
        sb.append(", supply=").append(supply);
        sb.append(", cost=").append(cost);
        sb.append(", fitness=").append(fitness);
        sb.append(", penalty=").append(penalty);
        sb.append('}');
        return sb.toString();
    }
}
