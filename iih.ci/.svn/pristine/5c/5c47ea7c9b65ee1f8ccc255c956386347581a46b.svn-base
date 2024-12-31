package iih.ci.mr.easyrules.samples.rulepriority;

import iih.ci.mr.easyrules.annotation.Action;
import iih.ci.mr.easyrules.annotation.Condition;
import iih.ci.mr.easyrules.annotation.Priority;
import iih.ci.mr.easyrules.annotation.Rule;

/**
 * Rule class that prohibits children from buying alcohol.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
@Rule(name = "alcoholRule", description = "Children are not allowed to buy alcohol.")
public class AlcoholRule {

    private Person person;

    public AlcoholRule(Person person) {
        this.person = person;
    }

    @Condition
    public boolean isChildren() {
        return !person.isAdult();
    }

    @Action
    public void denyAlcohol(){
        System.out.printf("Sorry %s, you are not allowed to buy alcohol.\n", person.getName());
    }

    @Priority
    public int getPriority() {
        return 2;
    }

}
