package org.uengine.processpublisher.bpmn.importer;

import org.omg.spec.bpmn._20100524.model.TCallActivity;
import org.omg.spec.bpmn._20100524.model.TSubProcess;
import org.uengine.kernel.Activity;
import org.uengine.kernel.bpmn.CallActivity;
import org.uengine.kernel.bpmn.SequenceFlow;
import org.uengine.kernel.bpmn.SubProcess;
import org.uengine.processpublisher.BPMNUtil;

import javax.xml.bind.JAXBElement;
import java.util.Hashtable;

public class TSubProcessAdapter extends TFlowNodeAdapter<TSubProcess, SubProcess>{
    @Override
    protected SubProcess create(TSubProcess src, Hashtable context) {
        SubProcess subProcess = new SubProcess();

        try {
            for(JAXBElement flowElement: src.getFlowElement()){
                Object childElement = BPMNUtil.adapt(flowElement.getValue(), context);

                if(childElement instanceof Activity){
                    subProcess.addChildActivity((Activity)childElement);
                }else if(childElement instanceof SequenceFlow){
                    subProcess.addSequenceFlow((SequenceFlow) childElement);

                }

            }

            return subProcess;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
