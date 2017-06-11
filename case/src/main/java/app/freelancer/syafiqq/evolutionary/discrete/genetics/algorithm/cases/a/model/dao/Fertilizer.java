package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao;

import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.element.CornElement;
import java.util.Objects;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 08 June 2017, 10:57 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class Fertilizer
{
    private String name;
    private CornElement elements;
    private double cost;

    public Fertilizer()
    {
    }

    public Fertilizer(String name, CornElement elements, double cost)
    {
        this.name = name;
        this.elements = elements;
        this.cost = cost;
    }

    public Fertilizer(String name, double nitrogen, double phosphorus, double potassium, double cost)
    {
        this.name = name;
        this.elements = new CornElement(nitrogen, phosphorus, potassium);
        this.cost = cost;
    }


    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public CornElement getElements()
    {
        return this.elements;
    }

    public void setElements(CornElement elements)
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

    public double getCost()
    {
        return this.cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    @Override public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof Fertilizer))
        {
            return false;
        }
        Fertilizer that = (Fertilizer) o;
        return Double.compare(that.getCost(), getCost()) == 0 &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getElements(), that.getElements());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getName(), getElements(), getCost());
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("Fertilizer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", elements=").append(elements);
        sb.append(", cost=").append(cost);
        sb.append('}');
        return sb.toString();
    }
}
