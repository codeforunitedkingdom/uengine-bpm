package org.uengine.processpublisher.bpmn.importer;

import org.omg.spec.bpmn._20100524.model.TCallActivity;
import org.uengine.kernel.Activity;
import org.uengine.kernel.bpmn.CallActivity;

import java.util.Hashtable;

public class TCallActivityAdapter extends TFlowNodeAdapter<TCallActivity, CallActivity>{
    @Override
    protected Activity create(TCallActivity src, Hashtable keyedContext) {
        CallActivity callActivity = new CallActivity();

        String subProcessId = src.getCalledElement().getLocalPart();

        callActivity.setDefinitionId(subProcessId);

        return callActivity;
    }
}
