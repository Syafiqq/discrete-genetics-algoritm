package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 07 June 2017, 1:46 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings({"unused", "WeakerAccess"}) public abstract class GeneticsAlgorithm<TIndividual extends Individual> implements IndividualEvaluator<TIndividual>
{
    @NotNull protected Population<TIndividual> population;
    @NotNull protected Setting setting;
    @Nullable private TIndividual best;

    public GeneticsAlgorithm()
    {
        this(new Setting());
    }

    public GeneticsAlgorithm(@NotNull final Setting setting)
    {
        this.setting = setting;
        this.population = new Population<TIndividual>()
        {
            @NotNull @Override public List<TIndividual> initializeOffspring()
            {
                return GeneticsAlgorithm.this.initializeOffspring();
            }

            @NotNull @Override public List<TIndividual> initializeParent()
            {
                return GeneticsAlgorithm.this.initializeParent();
            }
        };
        this.best = null;
    }

    @NotNull public List<TIndividual> initializeOffspring()
    {
        return new ArrayList<>();
    }

    @NotNull public List<TIndividual> initializeParent()
    {
        return new ArrayList<>();
    }

    public abstract void populate(@NotNull IndividualEvaluator<TIndividual> evaluator, @NotNull Population<TIndividual> population, @NotNull Setting setting);

    public abstract void reproduction(@NotNull Population<TIndividual> population, @NotNull Setting setting);

    public abstract void evaluation(@NotNull IndividualEvaluator<TIndividual> evaluator, @NotNull Population<TIndividual> population, @NotNull Setting setting);

    public abstract void selection(@NotNull Population<TIndividual> population, @NotNull Setting setting);

    public abstract boolean isSatisfied();

    public abstract void updateSatisfaction();

    protected abstract TIndividual getBestIndividual(@NotNull List<TIndividual> population);

    public void run()
    {
        this.populate(this, this.getPopulation(), this.getSetting());
        while(!this.isSatisfied())
        {
            this.reproduction(this.getPopulation(), this.getSetting());
            this.evaluation(this, this.getPopulation(), this.getSetting());
            this.selection(this.getPopulation(), this.getSetting());
            this.updateSatisfaction();
        }
        this.best = this.getBestIndividual(this.getParent());
    }

    @NotNull public Setting getSetting()
    {
        return this.setting;
    }

    public void setSetting(@NotNull Setting setting)
    {
        this.setting = setting;
    }

    public boolean addParent(TIndividual individual)
    {
        return this.population.addParent(individual);
    }

    public boolean removeParent(TIndividual individual)
    {
        return this.population.removeParent(individual);
    }

    public TIndividual removeParent(int index)
    {
        return this.population.removeParent(index);
    }

    public TIndividual getParent(int index)
    {
        return this.population.getParent(index);
    }

    public boolean addOffspring(TIndividual individual)
    {
        return this.population.addOffspring(individual);
    }

    public boolean removeOffspring(TIndividual individual)
    {
        return this.population.removeOffspring(individual);
    }

    public TIndividual removeOffspring(int index)
    {
        return this.population.removeOffspring(index);
    }

    public TIndividual getOffspring(int index)
    {
        return this.population.getOffspring(index);
    }

    @NotNull public List<TIndividual> getParent()
    {
        return this.population.getParent();
    }

    @NotNull public List<TIndividual> getOffspring()
    {
        return this.population.getOffspring();
    }

    @NotNull public Population<TIndividual> getPopulation()
    {
        return this.population;
    }

    @Nullable public TIndividual getBest()
    {
        return this.best;
    }

    @Override public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof GeneticsAlgorithm))
        {
            return false;
        }
        GeneticsAlgorithm<?> that = (GeneticsAlgorithm<?>) o;
        return Objects.equals(getPopulation(), that.getPopulation()) &&
                Objects.equals(getSetting(), that.getSetting()) &&
                Objects.equals(getBest(), that.getBest());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getPopulation(), getSetting(), getBest());
    }

    @Override public String toString()
    {
        return "GeneticsAlgorithm{" + "population=" + population +
                ", setting=" + setting +
                ", best=" + best +
                '}';
    }
}
