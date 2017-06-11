package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.element;

import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method.utils.DoubleMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 08 June 2017, 11:08 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class CornElement
{
    private DoubleMap elements;

    public CornElement()
    {
        this(0.0, 0.0, 0.0);
    }

    public CornElement(double nitrogen, double phosphorus, double potassium)
    {
        this.elements = new DoubleMap();
        this.generateElement();
        this.put("nitrogen", nitrogen);
        this.put("phosphorus", phosphorus);
        this.put("potassium", potassium);
    }

    private void generateElement()
    {
        this.put("nitrogen", 0.0);
        this.put("phosphorus", 0.0);
        this.put("potassium", 0.0);
    }

    public DoubleMap getElements()
    {
        return this.elements;
    }

    public void setElements(DoubleMap elements)
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

    public Map.Entry<String, Double> getMaximumElement()
    {
        return Collections.max(this.getElements().entrySet(), new Comparator<Map.Entry<String, Double>>()
        {
            @Override public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2)
            {
                return Double.compare(o2.getValue(), o1.getValue());
            }
        });
    }

    public boolean isComposite()
    {
        double composite = 0;
        for(@NotNull final Double value : this.getElements().values())
        {
            composite += Math.signum(value);
        }
        return composite > 1;
    }

    @Override public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof CornElement))
        {
            return false;
        }
        CornElement that = (CornElement) o;
        return Objects.equals(getElements(), that.getElements());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getElements());
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("CornElement{");
        sb.append("elements=").append(elements);
        sb.append('}');
        return sb.toString();
    }
}
