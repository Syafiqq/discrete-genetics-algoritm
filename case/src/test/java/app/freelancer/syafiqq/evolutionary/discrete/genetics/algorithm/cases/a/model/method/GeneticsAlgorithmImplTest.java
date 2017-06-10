package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method;

import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao.CornPlantation;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao.Fertilizer;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.element.CornElement;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 08 June 2017, 4:14 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class GeneticsAlgorithmImplTest
{
    private List<Fertilizer> getFertilizer()
    {
        Object[][] rawFertilizer = new Object[][]
                {
                        new Object[] {"Za", 45, 0, 0, 1400},
                        new Object[] {"SP-36", 0, 36, 0, 2000},
                        new Object[] {"ZK", 0, 0, 49, 18000},
                        new Object[] {"KCL-80", 0, 0, 52, 2200},
                        new Object[] {"Pa", 0, 0, 21, 10000},
                        new Object[] {"Urea", 45, 0, 0, 2100},
                        new Object[] {"Phonska", 15, 15, 15, 2300},
                        new Object[] {"KCI", 0, 0, 60, 2200},
                        new Object[] {"NPK Mutiara", 16, 16, 16, 9000},
                };

        @NotNull final List<Fertilizer> fertilizerList = new ArrayList<>();
        for(Object[] fertilizer : rawFertilizer)
        {
            fertilizerList.add(new Fertilizer((String) fertilizer[0], new CornElement((Integer) fertilizer[1], (Integer) fertilizer[2], (Integer) fertilizer[3]), (Integer) fertilizer[4]));
        }
        return fertilizerList;
    }

    @Test
    public void test()
    {
        @NotNull final List<Fertilizer> fertilizerList = this.getFertilizer();

        @NotNull final SettingImpl setting = new SettingImpl();
        setting.setIndividualWindow(5);
        setting.setCrossoverRate(.5);
        setting.setMutationRate(.5);
        setting.setPopulationSize(5);
        setting.setCrossoverRate(.6);
        setting.setMutationRate(.6);
        setting.setPopulationSize(6);
        setting.setCrossoverRate(.5);
        setting.setMutationRate(.5);
        setting.setPopulationSize(5);
        setting.setNitrogenFactor(0.45);
        setting.setPhosphorusFactor(0.36);
        setting.setPotassiumFactor(0.60);
        @NotNull final CornPlantation plantation = new CornPlantation(300.0, 75.0, 100.0);
        @NotNull final GeneticsAlgorithmImpl ga = new GeneticsAlgorithmImpl(setting, plantation);
        ga.setFertilizers(fertilizerList);
        ga.run();
        for(@NotNull final IndividualImpl individual : ga.getParent())
        {
            System.out.println(individual);
        }
        System.out.printf("%f, %f, %f\n", ga.getNitrogen(), ga.getPhosphorus(), ga.getPotassium());
    }
}