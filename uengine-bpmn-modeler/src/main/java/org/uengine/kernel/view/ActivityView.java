package org.uengine.kernel.view;

import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.Label;
import org.metaworks.widget.Popup;
import org.uengine.kernel.Activity;
import org.uengine.kernel.HumanActivity;
//import org.uengine.kernel.ReferenceActivity;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;
import org.uengine.modeling.modeler.palette.BPMNPalette;
import org.uengine.modeling.modeler.palette.TaskPalette;
import org.uengine.util.UEngineUtil;

public class ActivityView extends ElementView {

	public final static String SHAPE_ID = "OG.shape.bpmn.A_Task";
	
	public ActivityView() {
		setShapeId(SHAPE_ID);
	}
	
	public ActivityView(IElement element){
		super(element);
	}

	@Override
	public Symbol createSymbol() {
		Symbol symbol = new Symbol();

		symbol.setElementClassName(UEngineUtil.getDomainClassName(getClass(), "view"));

		try {
			Activity activityInstance = (Activity) Class.forName(symbol.getElementClassName()).newInstance();

			symbol.setName(activityInstance.getName());
			symbol.setShapeId(getShapeId());
			symbol.setHeight(100);
			symbol.setWidth(100);
			symbol.setShapeType("GEOM");

			return symbol;


		} catch (Exception e) {
			throw new RuntimeException("Failed to create symbol", e);
		}

	}
	
	public Activity getRealActivity(){
		Activity activity = null;
//		if(getElement() instanceof ReferenceActivity){
//			activity = ((ReferenceActivity)getElement()).getReferencedActivity();
//		} else {
			activity = (Activity)getElement();
//		}
		return activity;
	}

	@Override
	public void setElement(IElement element) {
		if(element!=null && element instanceof Activity){
			Activity activity = (Activity) element;
//			setLabel(activity.getName());
			//setId(activity.getTracingTag());
		}

		super.setElement(element);
	}

//	@ServiceMethod(target=ServiceMethod.TARGET_POPUP, mouseBinding = "click", inContextMenu = true)
//	public void popup() {
//		MetaworksRemoteService.wrapReturn(new Popup(new TaskPalette()));
//	}

}
