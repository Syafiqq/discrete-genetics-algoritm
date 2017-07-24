package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao;

import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method.utils.String2DoubleMap;
import com.github.syafiqq.unit.conversion.core.unit.compound.AreaDensityUnit;
import java.util.Objects;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 09 June 2017, 4:57 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class CornPlantation
{
    private String2DoubleMap elements;
    private PlantationScale scale;

    public CornPlantation()
    {
        this(0.0, 0.0, 0.0, new PlantationScale(AreaDensityUnit.TONNE_PER_HECTARE, 1));
    }

    public CornPlantation(double nitrogen, double phosphorus, double potassium)
    {
        this(nitrogen, phosphorus, potassium, new PlantationScale(AreaDensityUnit.TONNE_PER_HECTARE, 1));
    }

    public CornPlantation(double nitrogen, double phosphorus, double potassium, PlantationScale scale)
    {
        this.elements = new String2DoubleMap(3);
        this.generateElement();
        this.put("nitrogen", nitrogen);
        this.put("phosphorus", phosphorus);
        this.put("potassium", potassium);
        this.scale = scale;
    }

    private void generateElement()
    {
        this.put("nitrogen", 0.0);
        this.put("phosphorus", 0.0);
        this.put("potassium", 0.0);
    }

    public String2DoubleMap getElements()
    {
        return this.elements;
    }

    public void setElements(String2DoubleMap elements)
    {
        this.elements = elements;
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
        return elements.get(k);
    }

    public Double put(String key, Double value)
    {
        return elements.put(key, value);
    }

    public PlantationScale getScale()
    {
        return this.scale;
    }

    public void setScale(PlantationScale scale)
    {
        this.scale = scale;
    }

    @Override public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof CornPlantation))
        {
            return false;
        }
        CornPlantation that = (CornPlantation) o;
        return Objects.equals(getElements(), that.getElements());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getElements());
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("CornPlantation{");
        sb.append("elements=").append(elements);
        sb.append('}');
        return sb.toString();
    }
}
