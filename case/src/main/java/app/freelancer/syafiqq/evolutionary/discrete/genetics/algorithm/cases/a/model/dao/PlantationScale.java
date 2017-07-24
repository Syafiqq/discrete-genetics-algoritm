package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao;

import com.github.syafiqq.unit.conversion.core.unit.compound.AreaDensityUnit;
import java.util.Objects;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 24 July 2017, 6:39 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class PlantationScale
{
    private AreaDensityUnit unit;
    private double scale;

    public PlantationScale()
    {
    }

    public PlantationScale(AreaDensityUnit unit, double scale)
    {
        this.unit = unit;
        this.scale = scale;
    }

    public AreaDensityUnit getUnit()
    {
        return this.unit;
    }

    public void setUnit(AreaDensityUnit unit)
    {
        this.unit = unit;
    }

    public double getScale()
    {
        return this.scale;
    }

    public void setScale(double scale)
    {
        this.scale = scale;
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
        return Double.compare(that.getScale(), getScale()) == 0 &&
                getUnit() == that.getUnit();
    }

    @Override public int hashCode()
    {
        return Objects.hash(getUnit(), getScale());
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("PlantationScale{");
        sb.append("unit=").append(unit);
        sb.append(", scale=").append(scale);
        sb.append('}');
        return sb.toString();
    }
}
