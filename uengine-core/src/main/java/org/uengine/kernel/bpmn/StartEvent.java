package org.uengine.kernel.bpmn;

import org.uengine.kernel.DefaultActivity;
import org.uengine.kernel.ProcessInstance;
import org.uengine.modeling.ElementView;

public class StartEvent extends Event {
	public StartEvent() {
		setName("Start");
	}
			
	@Override
	protected void executeActivity(ProcessInstance instance) throws Exception {
		fireComplete(instance);
	}
	

}
