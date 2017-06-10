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
@SuppressWarnings({"unused", "WeakerAccess"}) public class Fertilizer
{
    private String name;
    private CornElement element;
    private double cost;

    public Fertilizer()
    {
    }

    public Fertilizer(String name, CornElement element, double cost)
    {
        this.name = name;
        this.element = element;
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

    public CornElement getElement()
    {
        return this.element;
    }

    public void setCaseElement(CornElement element)
    {
        this.element = element;
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
                Objects.equals(getElement(), that.getElement());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getName(), getElement(), getCost());
    }

    @Override public String toString()
    {
        return "Fertilizer{" + "name='" + name + '\'' +
                ", element=" + element +
                ", cost=" + cost +
                '}';
    }
}
