package app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.core.model.method;

/*
 * This <discrete-genetics-algoritm> created by : 
 * Name         : syafiq
 * Date / Time  : 09 June 2017, 3:35 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public interface IndividualEvaluator<TIndividual extends Individual>
{
    void evaluate(TIndividual individual);
}
