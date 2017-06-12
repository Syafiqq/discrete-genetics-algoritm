package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 11 June 2017, 4:48 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings("unused") public class String2DoubleMap extends LinkedHashMap<String, Double>
{
    public String2DoubleMap(int initialCapacity, float loadFactor)
    {
        super(initialCapacity, loadFactor);
    }

    public String2DoubleMap(int initialCapacity)
    {
        super(initialCapacity);
    }

    public String2DoubleMap()
    {
    }

    public String2DoubleMap(Map<? extends String, ? extends Double> m)
    {
        super(m);
    }

    public String2DoubleMap(int initialCapacity, float loadFactor, boolean accessOrder)
    {
        super(initialCapacity, loadFactor, accessOrder);
    }

    public void plus(String k, Double v)
    {
        super.put(k, super.get(k) + v);
    }

    public void minus(String k, Double v)
    {
        super.put(k, super.get(k) - v);
    }

    public void multiply(String k, Double v)
    {
        super.put(k, super.get(k) * v);
    }

    public void divide(String k, Double v)
    {
        super.put(k, super.get(k) / v);
    }
}
