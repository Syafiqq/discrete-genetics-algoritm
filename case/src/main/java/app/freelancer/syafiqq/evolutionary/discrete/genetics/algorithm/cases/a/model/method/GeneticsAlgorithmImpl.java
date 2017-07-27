package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method;

import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao.CornPlantation;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao.Fertilizer;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao.PlantationScale;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.element.CornElement;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method.utils.String2DoubleMap;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method.GeneticsAlgorithm;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method.IndividualEvaluator;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method.Population;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method.Setting;
import com.github.syafiqq.unit.conversion.core.unit.compound.AreaDensityUnit;
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
public class GeneticsAlgorithmImpl extends GeneticsAlgorithm<IndividualImpl>
{
    @NotNull private List<Fertilizer> fertilizers;
    @NotNull private Integer[] fertilizerIndex;
    @NotNull private Random random;
    @NotNull private CornPlantation plantation;
    @NotNull private PlantationScale target;
    @NotNull private String[] registeredElement;
    private int counter;

    private String2DoubleMap nutrient;
    private String2DoubleMap content;

    private List<String> orderedNutrient;

    public GeneticsAlgorithmImpl(@NotNull SettingImpl impl, @NotNull CornPlantation plantation, @NotNull PlantationScale target)
    {
        super(impl);
        this.fertilizers = new ArrayList<>();
        this.fertilizerIndex = new Integer[0];
        this.random = ThreadLocalRandom.current();
        this.plantation = plantation;
        this.target = target;
        this.registeredElement = new String[] {"nitrogen", "phosphorus", "potassium"};
        this.nutrient = new String2DoubleMap();
        this.content = new String2DoubleMap();
        this.orderedNutrient = new ArrayList<>(Arrays.asList(this.registeredElement));
        this.generateElement(this.getNutrient());
        this.generateElement(this.getContent());
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

    private static <T extends Object> void swap(T[] offspring, int from, int to)
    {
        final T vTemp = offspring[to];
        offspring[to] = offspring[from];
        offspring[from] = vTemp;
    }

    private static <T> void swap(List<T> offspring, int from, int to)
    {
        final T vTemp = offspring.get(to);
        offspring.set(to, offspring.get(from));
        offspring.set(from, vTemp);
    }

    private void generateElement(String2DoubleMap map)
    {
        map.put("nitrogen", 0.0);
        map.put("phosphorus", 0.0);
        map.put("potassium", 0.0);
    }

    @NotNull @Override public List<IndividualImpl> initializeOffspring()
    {
        return Collections.emptyList();
    }

    @NotNull @Override public List<IndividualImpl> initializeParent()
    {
        @NotNull Setting setting = super.getSetting();
        return new ArrayList<>(setting.getPopulationSize() + setting.getCrossoverSize() + setting.getMutationSize());
    }

    private void initializeCounter()
    {
        this.counter = 0;
    }

    private void initializeNutrient(@NotNull CornPlantation plantation, @NotNull SettingImpl setting)
    {
        double scale = AreaDensityUnit.converse(this.target, this.plantation.getScale());
        for(@NotNull final String element : this.registeredElement)
        {
            this.putNutrient(element, plantation.get(element) * setting.getFactor(element) * scale);
        }
        this.reorderNutrient();
    }

    private void reorderNutrient()
    {
        Collections.sort(this.orderedNutrient, new Comparator<String>()
        {
            @Override public int compare(String o1, String o2)
            {
                return Double.compare(getNutrient(o2), getNutrient(o1));
            }
        });
    }

    private void initializeData()
    {
        super.getParent().clear();
        super.getOffspring().clear();

        @NotNull final SettingImpl setting = (SettingImpl) super.getSetting();
        @NotNull final List<IndividualImpl> parents = super.getParent();
        @SuppressWarnings("MismatchedReadAndWriteOfArray") @NotNull final Integer[] processedFertilizer = new Integer[setting.getIndividualWindow()];
        for(int i = -1, is = setting.getPopulationSize() + setting.getCrossoverSize() + setting.getMutationSize(); ++i < is; )
        {
            @NotNull final IndividualImpl individual = new IndividualImpl();
            individual.setFertilizers(Arrays.copyOf(this.fertilizerIndex, this.fertilizerIndex.length));
            individual.setProcessedFertilizer(Arrays.copyOf(processedFertilizer, processedFertilizer.length));
            individual.setCost(0.0);
            individual.setFitness(0.0);
            individual.setPenalty(0.0);
            parents.add(individual);
        }
    }

    @Override public void populate(@NotNull IndividualEvaluator<IndividualImpl> evaluator, @NotNull Population<IndividualImpl> population, @NotNull Setting setting)
    {
        this.initializeCounter();
        this.initializeNutrient(this.plantation, (SettingImpl) this.setting);
        this.initializeData();

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
        @NotNull final SettingImpl settingImpl = (SettingImpl) setting;
        @NotNull final Random random = this.random;
        final int populationSize = setting.getPopulationSize();

        //Crossover
        for(int offspring = setting.getPopulationSize() - 1, offspringSize = setting.getPopulationSize() + setting.getCrossoverSize(); ++offspring < offspringSize; )
        {
            int parent1 = random.nextInt(populationSize);
            int parent2;
            do
            {
                parent2 = random.nextInt(populationSize);
            }
            while(parent1 == parent2);
            this.crossover(population.getParent(offspring), population.getParent(parent1), population.getParent(parent2), settingImpl);
        }

        //Mutation
        for(int offspring = setting.getPopulationSize() + setting.getCrossoverSize() - 1, offspringSize = setting.getPopulationSize() + setting.getCrossoverSize() + setting.getMutationSize(); ++offspring < offspringSize; )
        {
            int parent = random.nextInt(populationSize);
            this.mutation(population.getParent(offspring), population.getParent(parent), settingImpl);
        }
    }

    private void mutation(IndividualImpl offspring, IndividualImpl parent, @NotNull SettingImpl setting)
    {
        @NotNull final Random random = this.random;
        @NotNull final Integer[] offspringD = offspring.getFertilizers();
        final int offspringLength = offspringD.length;
        int swapFrom = random.nextInt(offspringLength);
        int swapTo;
        do
        {
            swapTo = random.nextInt(offspringLength);
        }
        while(swapFrom == swapTo);

        System.arraycopy(parent.getFertilizers(), 0, offspringD, 0, offspringLength);

        GeneticsAlgorithmImpl.swap(offspringD, swapFrom, swapTo);
    }

    private void crossover(IndividualImpl offspring, IndividualImpl parentX, IndividualImpl parentY, @NotNull SettingImpl setting)
    {
        final int cutPoint = setting.getCutPoint();
        int o = cutPoint - 1;
        @NotNull final Integer[] offspringD = offspring.getFertilizers();
        @NotNull final Integer[] parentXD = parentX.getFertilizers();

        System.arraycopy(parentX.getFertilizers(), 0, offspringD, 0, cutPoint);

        y:
        for(int y : parentY.getFertilizers())
        {
            for(int x = -1; ++x < cutPoint; )
            {
                if(Integer.compare(y, parentXD[x]) == 0)
                {
                    continue y;
                }
            }
            offspringD[++o] = y;
        }
    }

    @Override public void evaluation(@NotNull IndividualEvaluator<IndividualImpl> evaluator, @NotNull Population<IndividualImpl> population, @NotNull Setting setting)
    {
        @NotNull List<IndividualImpl> parents = population.getParent();
        for(int i = setting.getPopulationSize() - 1, is = parents.size(); ++i < is; )
        {
            evaluator.evaluate(parents.get(i));
        }
    }

    @Override public void selection(@NotNull Population<IndividualImpl> population, @NotNull Setting setting)
    {
        @NotNull final Random random = this.random;
        final int populations = setting.getPopulationSize() + setting.getCrossoverSize() + setting.getMutationSize();
        for(int i = -1, is = setting.getPopulationSize(); ++i < is; )
        {
            int sideA = random.nextInt(populations);
            int sideB;
            do
            {
                sideB = random.nextInt(populations);
            }
            while(sideA == sideB);
            this.binaryTournament(population, setting, i, sideA, sideB);
        }
    }

    private void binaryTournament(@NotNull Population<IndividualImpl> population, @NotNull Setting setting, int placement, int sideA, int sideB)
    {
        GeneticsAlgorithmImpl.swap(population.getParent(), placement, population.getParent(sideA).getFitness() >= population.getParent(sideB).getFitness() ? sideA : sideB);
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
        @NotNull SettingImpl setting = (SettingImpl) super.getSetting();
        @NotNull IndividualImpl best = population.get(0);
        for(int i = 0, is = setting.getPopulationSize(); ++i < is; )
        {
            @NotNull final IndividualImpl candidate = population.get(i);
            if(Double.compare(best.getFitness(), candidate.getFitness()) < 0)
            {
                best = candidate;
            }
        }
        return best;
    }

    @Override public void evaluate(@NotNull IndividualImpl individual)
    {
        double totalCost = 0.0;
        @NotNull final SettingImpl settingImpl = (SettingImpl) super.getSetting();
        @NotNull final String2DoubleMap nutrient = this.getNutrient();
        @NotNull final String2DoubleMap content = this.getContent();
        @NotNull final List<String> orderedNutrient = this.orderedNutrient;
        for(@NotNull final String element : this.registeredElement)
        {
            content.put(element, settingImpl.getFactor(element));
        }

        individual.clearSupply();

        //Slice individual array
        individual.syncProcessedFertilizer(settingImpl.getIndividualWindow());

        //Sort based on its element
        Arrays.sort(individual.getProcessedFertilizer(), new Comparator<Integer>()
        {
            @Override public int compare(Integer o1, Integer o2)
            {
                return Long.compare(Math.round(GeneticsAlgorithmImpl.this.fertilizers.get(o2).getElements().getMaximumElement().getValue()),
                        Math.round(GeneticsAlgorithmImpl.this.fertilizers.get(o1).getElements().getMaximumElement().getValue()));
            }
        });

        for(int fertilizerID : individual.getProcessedFertilizer())
        {
            @NotNull final Fertilizer fertilizer = this.fertilizers.get(fertilizerID);
            @NotNull final CornElement element = fertilizer.getElements();

            for(@NotNull String kNutrient : orderedNutrient)
            {
                if((content.get(kNutrient) > 0.0) && (element.get(kNutrient) > 0.0))
                {
                    double total = Math.ceil((100.0 / element.get(kNutrient)) * nutrient.get(kNutrient));
                    totalCost += total * fertilizer.getCost();
                    content.minus(kNutrient, element.get(kNutrient) / 100.0);
                    for(@NotNull String ckNutrient : orderedNutrient)
                    {
                        if(!kNutrient.contentEquals(ckNutrient))
                        {
                            content.minus(ckNutrient, element.get(ckNutrient) / 100.0);
                        }
                    }
                    individual.putSupply(fertilizerID, total);
                    break;
                }
            }
        }

        final double penalty = Math.max(0, content.get("nitrogen")) + Math.max(0, content.get("phosphorus")) + Math.max(0, content.get("potassium"));
        for(final String key : individual.getContent().keySet())
        {
            individual.putContent(key, content.get(key));
        }
        individual.setCost(totalCost);
        individual.setPenalty(penalty);
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

    public String2DoubleMap getNutrient()
    {
        return this.nutrient;
    }

    public Double getNutrient(String key)
    {
        return getNutrient().get(key);
    }

    public Double putNutrient(String key, Double value)
    {
        return getNutrient().put(key, value);
    }

    public String2DoubleMap getContent()
    {
        return this.content;
    }

    public Double getContent(String key)
    {
        return getContent().get(key);
    }

    public Double putContent(String key, Double value)
    {
        return getContent().put(key, value);
    }

    @NotNull public PlantationScale getTarget()
    {
        return this.target;
    }

    public void setTarget(@NotNull PlantationScale target)
    {
        this.target = target;
    }
}
