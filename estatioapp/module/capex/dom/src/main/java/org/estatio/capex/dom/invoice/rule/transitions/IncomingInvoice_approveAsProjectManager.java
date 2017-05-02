package org.estatio.capex.dom.invoice.rule.transitions;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Mixin;

import org.estatio.capex.dom.invoice.IncomingInvoice;
import org.estatio.capex.dom.invoice.rule.IncomingInvoiceTransition;

@Mixin
public class IncomingInvoice_approveAsProjectManager extends IncomingInvoice_transitionAbstract {

    public IncomingInvoice_approveAsProjectManager(IncomingInvoice incomingInvoice) {
        super(incomingInvoice, IncomingInvoiceTransition.APPROVE_AS_PROJECT_MANAGER);
    }

    @Action()
    @MemberOrder(sequence = "2.2")
    public IncomingInvoice $$() {
        return super.$$();
    }

}