package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.element;

import java.util.Objects;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 08 June 2017, 11:08 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class CornElement
{
    private double nitrogen;
    private double phosphorus;
    private double potassium;

    public CornElement()
    {
    }

    public CornElement(double nitrogen, double phosphorus, double potassium)
    {
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
    }

    public double getNitrogen()
    {
        return this.nitrogen;
    }

    public void setNitrogen(double nitrogen)
    {
        this.nitrogen = nitrogen;
    }

    public double getPhosphorus()
    {
        return this.phosphorus;
    }

    public void setPhosphorus(double phosphorus)
    {
        this.phosphorus = phosphorus;
    }

    public double getPotassium()
    {
        return this.potassium;
    }

    public void setPotassium(double potassium)
    {
        this.potassium = potassium;
    }

    public double getMaximumElement()
    {
        return Math.max(this.getNitrogen(), Math.max(this.getPhosphorus(), this.getPotassium()));
    }

    public boolean isComposite()
    {
        return Math.signum(this.getNitrogen()) + Math.signum(this.getPhosphorus()) + Math.signum(this.getPotassium()) > 1;
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
        return Double.compare(that.getNitrogen(), getNitrogen()) == 0 &&
                Double.compare(that.getPhosphorus(), getPhosphorus()) == 0 &&
                Double.compare(that.getPotassium(), getPotassium()) == 0;
    }

    @Override public int hashCode()
    {
        return Objects.hash(getNitrogen(), getPhosphorus(), getPotassium());
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("CornElement{");
        sb.append("nitrogen=").append(nitrogen);
        sb.append(", phosphorus=").append(phosphorus);
        sb.append(", potassium=").append(potassium);
        sb.append('}');
        return sb.toString();
    }


}
