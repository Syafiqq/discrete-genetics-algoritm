package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao;

import com.github.syafiqq.unit.conversion.core.unit.compound.AreaDensityUnit;
import com.github.syafiqq.unit.conversion.core.unit.single.AreaUnit;
import com.github.syafiqq.unit.conversion.core.unit.single.WeightUnit;
import java.util.Objects;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 24 July 2017, 6:39 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class PlantationScale implements AreaDensityUnit.AreaDensityWrapper<Double>
{
    private AreaDensityUnit unit;
    private double weight;
    private double area;

    public PlantationScale()
    {
    }

    public PlantationScale(AreaDensityUnit unit, double weight, double area)
    {
        this.unit = unit;
        this.weight = weight;
        this.area = area;
    }

    @Override public AreaDensityUnit getUnit()
    {
        return this.unit;
    }

    @Override public WeightUnit getWeightUnit()
    {
        return this.unit.getWeight();
    }

    @Override public AreaUnit getAreaUnit()
    {
        return this.unit.getArea();
    }

    @Override public Double getWeightValue()
    {
        return this.getWeight();
    }

    @Override public Double getAreaValue()
    {
        return this.getArea();
    }

    public void setUnit(AreaDensityUnit unit)
    {
        this.unit = unit;
    }

    public double getWeight()
    {
        return this.weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public double getArea()
    {
        return this.area;
    }

    public void setArea(double area)
    {
        this.area = area;
    }

    @Override public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof PlantationScale))
        {
            return false;
        }
        PlantationScale that = (PlantationScale) o;
        return Double.compare(that.getWeight(), getWeight()) == 0 &&
                Double.compare(that.getArea(), getArea()) == 0 &&
                getUnit() == that.getUnit();
    }

    @Override public int hashCode()
    {
        return Objects.hash(getUnit(), getWeight(), getArea());
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("PlantationScale{");
        sb.append("unit=").append(unit);
        sb.append(", weight=").append(weight);
        sb.append(", area=").append(area);
        sb.append('}');
        return sb.toString();
    }
}
