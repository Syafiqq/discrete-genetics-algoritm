package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 09 June 2017, 7:39 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings({"unused", "WeakerAccess"}) public class Population<TIndividual extends Individual>
{
    @NotNull final private List<TIndividual> parent;
    @NotNull final private List<TIndividual> offspring;

    public Population()
    {
        this.parent = this.initializeParent();
        this.offspring = this.initializeOffspring();
    }

    @NotNull public List<TIndividual> initializeOffspring()
    {
        return new ArrayList<>();
    }

    @NotNull public List<TIndividual> initializeParent()
    {
        return new ArrayList<>();
    }

    public boolean addParent(TIndividual tIndividual)
    {
        return this.parent.add(tIndividual);
    }

    public boolean removeParent(TIndividual individual)
    {
        return this.parent.remove(individual);
    }

    public TIndividual removeParent(int index)
    {
        return this.parent.remove(index);
    }

    public TIndividual getParent(int index)
    {
        return this.parent.get(index);
    }

    public boolean addOffspring(TIndividual individual)
    {
        return this.offspring.add(individual);
    }

    public boolean removeOffspring(TIndividual individual)
    {
        return this.offspring.remove(individual);
    }

    public TIndividual removeOffspring(int index)
    {
        return this.offspring.remove(index);
    }

    public TIndividual getOffspring(int index)
    {
        return offspring.get(index);
    }

    @NotNull public List<TIndividual> getParent()
    {
        return this.parent;
    }

    @NotNull public List<TIndividual> getOffspring()
    {
        return this.offspring;
    }

    @Override public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof Population))
        {
            return false;
        }
        Population<?> that = (Population<?>) o;
        return Objects.equals(getParent(), that.getParent()) &&
                Objects.equals(getOffspring(), that.getOffspring());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getParent(), getOffspring());
    }

    @Override public String toString()
    {
        return "Population{" + "parent=" + parent +
                ", offspring=" + offspring +
                '}';
    }
}
