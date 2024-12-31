/*
 * The MIT License
 *
 *  Copyright (c) 2015, Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package iih.ci.mrqc.easyrules.core;

import iih.ci.mrqc.easyrules.api.Rule;
import iih.ci.mrqc.easyrules.api.RuleListener;
import iih.ci.mrqc.easyrules.api.RulesEngine;
import iih.ci.mrqc.easyrules.util.Utils;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Default {@link iih.ci.mrqc.easyrules.api.RulesEngine} implementation.
 *
 * This implementation handles a set of rules with unique name.
 *
 * Rules are fired according to their natural order which is priority by default.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
class DefaultRulesEngine implements RulesEngine {

    private static final Logger LOGGER = Logger.getLogger(RulesEngine.class.getName());

    /**
     * The engine name.
     */
    protected String name;

    /**
     * The rules set.
     */
    protected Set<Rule> rules;

    /**
     * Parameter to skip next applicable rules when a rule is applied.
     */
    protected boolean skipOnFirstAppliedRule;

    /**
     * Parameter to skip next applicable rules when a rule has failed.
     */
    protected boolean skipOnFirstFailedRule;

    /**
     * Parameter to skip next rules if priority exceeds a user defined threshold.
     */
    protected int rulePriorityThreshold;

    /**
     * The registered rule listeners.
     */
    private List<RuleListener> ruleListeners;

    DefaultRulesEngine(final String name, final boolean skipOnFirstAppliedRule, final boolean skipOnFirstFailedRule,
                       final int rulePriorityThreshold, final List<RuleListener> ruleListeners, final boolean silentMode) {
        this.name = name;
        rules = new TreeSet<Rule>();
        this.skipOnFirstAppliedRule = skipOnFirstAppliedRule;
        this.skipOnFirstFailedRule = skipOnFirstFailedRule;
        this.rulePriorityThreshold = rulePriorityThreshold;
        this.ruleListeners = ruleListeners;
        if (silentMode) {
            Utils.muteLoggers();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void registerRule(final Object rule) {
        rules.add(asRule(rule));
    }

    @Override
    public void unregisterRule(final Object rule) {
        rules.remove(asRule(rule));
    }

    @Override
    public void clearRules() {
        rules.clear();
        LOGGER.info("Rules cleared.");
    }

    @Override
    public void fireRules() {

        if (rules.isEmpty()) {
            LOGGER.warning("No rules registered! Nothing to apply.");
            return;
        }

        logEngineParameters();
        sortRules();
        applyRules();

    }

    private void sortRules() {
        rules = new TreeSet<Rule>(rules);
    }

    private void applyRules() {

        for (Rule rule : rules) {

            final String ruleName = rule.getName();
            final int rulePriority = rule.getPriority();

            if (rulePriority > rulePriorityThreshold) {
                LOGGER.log(Level.INFO,
                        "Rule priority threshold ({0}) exceeded at rule ''{1}'' (priority={2}), next rules will be skipped.",
                        new Object[] {rulePriorityThreshold, ruleName, rulePriority});
                break;
            }

            if (rule.evaluate()) {
                LOGGER.log(Level.INFO, "Rule ''{0}'' triggered.", ruleName);
                try {
                    triggerListenersBeforeExecute(rule);
                    rule.execute();
                    LOGGER.log(Level.INFO, "Rule ''{0}'' performed successfully.", ruleName);
                    triggerListenersOnSuccess(rule);

                    if (skipOnFirstAppliedRule) {
                        LOGGER.info("Next rules will be skipped since parameter skipOnFirstAppliedRule is set to true");
                        break;
                    }
                } catch (Exception exception) {
                    LOGGER.log(Level.SEVERE, String.format("Rule '%s' performed with error.", ruleName), exception);
                    triggerListenersOnFailure(rule, exception);
                    if (skipOnFirstFailedRule) {
                        LOGGER.info("Next rules will be skipped since parameter skipOnFirstFailedRule is set to true");
                        break;
                    }
                }
            } else {
                LOGGER.log(Level.INFO, "Rule ''{0}'' has been evaluated to false, it has not been executed.", ruleName);
            }

        }

    }

    private void triggerListenersOnFailure(final Rule rule, final Exception exception) {
        for (RuleListener ruleListener : ruleListeners) {
            ruleListener.onFailure(rule, exception);
        }
    }

    private void triggerListenersOnSuccess(final Rule rule) {
        for (RuleListener ruleListener : ruleListeners) {
            ruleListener.onSuccess(rule);
        }
    }

    private void triggerListenersBeforeExecute(final Rule rule) {
        for (RuleListener ruleListener : ruleListeners) {
            ruleListener.beforeExecute(rule);
        }
    }

    private void logEngineParameters() {
        LOGGER.log(Level.INFO, "Rule priority threshold: {0}", rulePriorityThreshold);
        LOGGER.log(Level.INFO, "Skip on first applied rule: {0}", skipOnFirstAppliedRule);
        LOGGER.log(Level.INFO, "Skip on first failed rule: {0}", skipOnFirstFailedRule);
    }

    private Rule asRule(final Object rule) {
        Rule result;
        if (Utils.getInterfaces(rule).contains(Rule.class)) {
            result = (Rule) rule;
        } else {
            result = RuleProxy.asRule(rule);
        }
        return result;
    }

    @Override
    public String toString() {
        return name;
    }

}
