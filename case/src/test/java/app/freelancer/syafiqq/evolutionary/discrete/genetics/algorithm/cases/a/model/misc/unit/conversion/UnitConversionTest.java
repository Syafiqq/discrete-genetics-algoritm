package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.misc.unit.conversion;

import com.github.syafiqq.unit.conversion.core.unit.compound.AreaDensityUnit;
import org.junit.Assert;
import org.junit.Test;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 24 July 2017, 5:55 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class UnitConversionTest
{
    @Test public void it_converse_10_tonne_hectare_to_kilogram_meter()
    {
        double source = 10;
        AreaDensityUnit sourceUnit = AreaDensityUnit.TONNE_PER_HECTARE;
        AreaDensityUnit resultUnit = AreaDensityUnit.KILOGRAM_PER_SQUARE_METER;
        double result = sourceUnit.to(resultUnit, 10);
        Assert.assertEquals(1.0, result, 0.0);
    }

    @Test public void it_converse_nutrient()
    {
        //10 kg/ha
        double multiplication, result, need;
        AreaDensityUnit needUnit;


        double source = 10;
        AreaDensityUnit sourceUnit = AreaDensityUnit.TONNE_PER_HECTARE;

        double nutrient = 300;

        need = 100;
        needUnit = AreaDensityUnit.TONNE_PER_HECTARE;
        multiplication = (needUnit.to(sourceUnit, need, source));
        result = nutrient * multiplication;
        Assert.assertEquals(1E1, multiplication, 0.0);
        Assert.assertEquals(3000.0, result, 0.0);

        need = 10;
        needUnit = AreaDensityUnit.TONNE_PER_HECTARE;
        multiplication = (needUnit.to(sourceUnit, need, source));
        result = nutrient * multiplication;
        Assert.assertEquals(1E0, multiplication, 0.0);
        Assert.assertEquals(300.0, result, 0.0);

        need = 1;
        needUnit = AreaDensityUnit.TONNE_PER_HECTARE;
        multiplication = (needUnit.to(sourceUnit, need, source));
        result = nutrient * multiplication;
        Assert.assertEquals(1E-1, multiplication, 0.0);
        Assert.assertEquals(30.0, result, 0.0);

        need = 1;
        needUnit = AreaDensityUnit.KILOGRAM_PER_SQUARE_METER;
        multiplication = (needUnit.to(sourceUnit, need, source));
        result = nutrient * multiplication;
        Assert.assertEquals(1E0, multiplication, 0.0);
        Assert.assertEquals(300.0, result, 0.0);
    }


}
