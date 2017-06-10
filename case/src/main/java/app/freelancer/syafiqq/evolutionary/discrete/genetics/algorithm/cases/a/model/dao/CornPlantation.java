package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao;

import java.util.Objects;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 09 June 2017, 4:57 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings({"WeakerAccess", "unused"}) public class CornPlantation
{
    private double nitrogen;
    private double phosphorus;
    private double potassium;

    public CornPlantation()
    {
    }

    public CornPlantation(double nitrogen, double phosphorus, double potassium)
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
        return "CornPlantation{" + "nitrogen=" + nitrogen +
                ", phosphorus=" + phosphorus +
                ", potassium=" + potassium +
                '}';
    }
}
