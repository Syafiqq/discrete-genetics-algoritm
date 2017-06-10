package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method;

import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao.CornPlantation;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao.Fertilizer;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.element.CornElement;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method.GeneticsAlgorithm;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method.IndividualEvaluator;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method.Population;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method.Setting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.jetbrains.annotations.NotNull;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 08 June 2017, 11:39 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings({"WeakerAccess", "unused"}) public class GeneticsAlgorithmImpl extends GeneticsAlgorithm<IndividualImpl>
{
    @NotNull private List<Fertilizer> fertilizers;
    @NotNull private Integer[] fertilizerIndex;
    @NotNull private Random random;
    @NotNull private CornPlantation plantation;
    private int counter;
    private double nitrogen;
    private double phosphorus;
    private double potassium;

    public GeneticsAlgorithmImpl(@NotNull SettingImpl impl, @NotNull CornPlantation plantation)
    {
        super(impl);
        this.fertilizers = new ArrayList<>();
        this.fertilizerIndex = new Integer[0];
        this.random = ThreadLocalRandom.current();
        this.plantation = plantation;
    }

    static void shuffleArray(@NotNull final Integer[] ar, @NotNull final Random random)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        for(int i = ar.length - 1; i > 0; i--)
        {
            int index = random.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    @NotNull @Override public List<IndividualImpl> initializeOffspring()
    {
        return Collections.emptyList();
    }

    @NotNull @Override public List<IndividualImpl> initializeParent()
    {
        return new ArrayList<>(super.getSetting().getPopulationSize() * 2);
    }

    private void initializeCounter()
    {
        this.counter = 0;
    }

    private void initializePlantation(@NotNull CornPlantation plantation, @NotNull SettingImpl setting)
    {
        this.nitrogen = plantation.getNitrogen() * setting.getNitrogenFactor();
        this.phosphorus = plantation.getPhosphorus() * setting.getPhosphorusFactor();
        this.potassium = plantation.getPotassium() * setting.getPotassiumFactor();
    }

    private void initializeData()
    {
        super.getParent().clear();
        super.getOffspring().clear();

        @NotNull final SettingImpl setting = (SettingImpl) super.getSetting();
        @NotNull final List<IndividualImpl> parents = super.getParent();
        @SuppressWarnings("MismatchedReadAndWriteOfArray") @NotNull final Integer[] processedFertilizer = new Integer[setting.getIndividualWindow()];
        for(int i = -1, is = setting.getPopulationSize() * 2; ++i < is; )
        {
            @NotNull final IndividualImpl individual = new IndividualImpl();
            individual.setFertilizers(Arrays.copyOf(this.fertilizerIndex, this.fertilizerIndex.length));
            individual.setProcessedFertilizer(Arrays.copyOf(processedFertilizer, processedFertilizer.length));
            individual.setCost(0.0);
            individual.setFitness(0.0);
            parents.add(individual);
        }
    }

    @Override public void populate(@NotNull IndividualEvaluator<IndividualImpl> evaluator, @NotNull Population<IndividualImpl> population, @NotNull Setting setting)
    {
        this.initializeData();
        this.initializePlantation(this.plantation, (SettingImpl) this.setting);
        this.initializeCounter();

        //Initialize Individual and calculate its fitness
        @NotNull final Random random = this.random;
        @NotNull final Iterator<IndividualImpl> parents = super.getParent().iterator();
        for(int i = -1, is = setting.getPopulationSize(); ++i < is; )
        {
            @NotNull final IndividualImpl individual = parents.next();
            shuffleArray(individual.getFertilizers(), random);
            evaluator.evaluate(individual);
        }
    }

    @Override public void reproduction(@NotNull Population<IndividualImpl> population, @NotNull Setting setting)
    {

    }

    @Override public void evaluation(@NotNull IndividualEvaluator<IndividualImpl> evaluator, @NotNull Population<IndividualImpl> population, @NotNull Setting setting)
    {
        @NotNull List<IndividualImpl> parents = population.getParent();
        for(int i = setting.getPopulationSize() - 1, is = parents.size(); ++i < is; )
        {
            evaluator.evaluate(parents.get(i));
        }
    }

    @Override public void selection(@NotNull Population<IndividualImpl> population)
    {

    }

    @Override public boolean isSatisfied()
    {
        return this.counter > ((SettingImpl) super.setting).getGenerationCount();
    }

    @Override public void updateSatisfaction()
    {
        ++this.counter;
    }

    @Override protected IndividualImpl getBestIndividual(@NotNull List<IndividualImpl> population)
    {
        return null;
    }

    @Override public void evaluate(@NotNull IndividualImpl individual)
    {
        double nitrogenNeed = this.getNitrogen();
        double phosphorusNeed = this.getPhosphorus();
        double potassiumNeed = this.getPotassium();

        @NotNull final SettingImpl settingImpl = (SettingImpl) super.getSetting();
        double totalCost = 0.0;

        //Slice individual array
        individual.syncProcessedFertilizer(settingImpl.getIndividualWindow());

        //Sort based on its element
        Arrays.sort(individual.getProcessedFertilizer(), new Comparator<Integer>()
        {
            @Override public int compare(Integer o1, Integer o2)
            {
                return Long.compare(Math.round(GeneticsAlgorithmImpl.this.fertilizers.get(o2).getElement().getMaximumElement()),
                        Math.round(GeneticsAlgorithmImpl.this.fertilizers.get(o1).getElement().getMaximumElement()));
            }
        });

        for(int fertilizerID : individual.getProcessedFertilizer())
        {
            double fertilizeTotal;
            @NotNull final Fertilizer fertilizer = this.fertilizers.get(fertilizerID);
            @NotNull final CornElement element = fertilizer.getElement();
            final double highest = element.getMaximumElement();
            final double highestNeed = Math.max(nitrogenNeed, Math.max(phosphorusNeed, potassiumNeed));
            boolean isComposite = element.isComposite();
            if((Double.compare(highest, element.getNitrogen()) == 0) && (isComposite ? (Double.compare(highestNeed, nitrogenNeed) == 0) : (nitrogenNeed > 0.0)))
            {
                fertilizeTotal = Math.ceil((100.0 / element.getNitrogen()) * nitrogenNeed);
                totalCost += fertilizeTotal * fertilizer.getCost();
                nitrogenNeed -= fertilizeTotal;
                if(element.getPotassium() > 0.0)
                {
                    potassiumNeed -= Math.floor((element.getPotassium() / 100.0) * fertilizeTotal);
                }
                if(element.getPhosphorus() > 0.0)
                {
                    phosphorusNeed -= Math.floor((element.getPhosphorus() / 100.0) * fertilizeTotal);
                }
            }

            if(isComposite)
            {
                continue;
            }

            if((Double.compare(highest, element.getPhosphorus()) == 0) && (isComposite ? (Double.compare(highestNeed, phosphorusNeed) == 0) : (phosphorusNeed > 0.0)))
            {
                fertilizeTotal = Math.ceil((100.0 / element.getPhosphorus()) * phosphorusNeed);
                totalCost += fertilizeTotal * fertilizer.getCost();
                phosphorusNeed -= fertilizeTotal;
                if(element.getNitrogen() > 0.0)
                {
                    nitrogenNeed -= Math.floor((element.getNitrogen() / 100.0) * fertilizeTotal);
                }
                if(element.getPotassium() > 0.0)
                {
                    potassiumNeed -= Math.floor((element.getPotassium() / 100.0) * fertilizeTotal);
                }
            }

            if(isComposite)
            {
                continue;
            }

            if((Double.compare(highest, element.getPotassium()) == 0) && (isComposite ? (Double.compare(highestNeed, potassiumNeed) == 0) : (potassiumNeed > 0.0)))
            {
                fertilizeTotal = Math.ceil((100.0 / element.getPotassium()) * potassiumNeed);
                totalCost += fertilizeTotal * fertilizer.getCost();
                potassiumNeed -= fertilizeTotal;
                if(element.getNitrogen() > 0.0)
                {
                    nitrogenNeed -= Math.floor((element.getNitrogen() / 100.0) * fertilizeTotal);
                }
                if(element.getPhosphorus() > 0.0)
                {
                    phosphorusNeed -= Math.floor((element.getPhosphorus() / 100.0) * fertilizeTotal);
                }
            }
        }

        final double penalty = Math.max(0, nitrogenNeed) + Math.max(0, phosphorusNeed) + Math.max(0, potassiumNeed);
        individual.setCost(totalCost);
        individual.setFitness(1000.0 / ((totalCost / 1000.0) + (1000 * penalty)));
    }

    @NotNull public List<Fertilizer> getFertilizers()
    {
        return this.fertilizers;
    }

    public void setFertilizers(@NotNull List<Fertilizer> fertilizers)
    {
        this.fertilizers.clear();
        this.fertilizers.addAll(fertilizers);
        this.setFertilizerIndex();
    }

    @NotNull public Integer[] getFertilizerIndex()
    {
        return this.fertilizerIndex;
    }

    private void setFertilizerIndex()
    {
        this.fertilizerIndex = new Integer[this.fertilizers.size()];
        for(int i = -1, is = this.fertilizers.size(); ++i < is; )
        {
            this.fertilizerIndex[i] = i;
        }
    }

    @NotNull public CornPlantation getPlantation()
    {
        return this.plantation;
    }

    public void setPlantation(@NotNull CornPlantation plantation)
    {
        this.plantation = plantation;
    }

    public double getNitrogen()
    {
        return this.nitrogen;
    }

    public double getPhosphorus()
    {
        return this.phosphorus;
    }

    public double getPotassium()
    {
        return this.potassium;
    }
}
