package iih.ci.mrqc.easyrules.samples.rulepriority;

import iih.ci.mrqc.easyrules.api.RulesEngine;
import static iih.ci.mrqc.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

/**
 * Launcher class for rule priority tutorial.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Launcher {

    public static void main(String[] args) {

        //create a person instance
        Person tom = new Person("Tom", 29);
        System.out.println("Tom: Hi! can I have some Vodka please?");

        //create a rules engine
        RulesEngine rulesEngine = aNewRulesEngine().build();

        //register rules
        rulesEngine.registerRule(new AgeRule(tom));
        rulesEngine.registerRule(new AlcoholRule(tom));

        //fire rules
        rulesEngine.fireRules();

    }

}
