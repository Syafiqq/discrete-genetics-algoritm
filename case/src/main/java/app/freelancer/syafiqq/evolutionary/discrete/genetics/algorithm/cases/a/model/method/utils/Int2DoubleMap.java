package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 11 June 2017, 11:02 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class Int2DoubleMap extends LinkedHashMap<Integer, Double>
{
    public Int2DoubleMap(int initialCapacity, float loadFactor)
    {
        super(initialCapacity, loadFactor);
    }

    public Int2DoubleMap(int initialCapacity)
    {
        super(initialCapacity);
    }

    public Int2DoubleMap()
    {
    }

    public Int2DoubleMap(Map<? extends Integer, ? extends Double> m)
    {
        super(m);
    }

    public Int2DoubleMap(int initialCapacity, float loadFactor, boolean accessOrder)
    {
        super(initialCapacity, loadFactor, accessOrder);
    }

    public void plus(Integer k, Double v)
    {
        super.put(k, super.get(k) + v);
    }

    public void minus(Integer k, Double v)
    {
        super.put(k, super.get(k) - v);
    }

    public void multiply(Integer k, Double v)
    {
        super.put(k, super.get(k) * v);
    }

    public void divide(Integer k, Double v)
    {
        super.put(k, super.get(k) / v);
    }
}
