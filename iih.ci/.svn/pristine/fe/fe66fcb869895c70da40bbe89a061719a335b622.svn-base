package iih.ci.mr.s.listener;

import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import com.ymer.core.xml.StringUtils;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleMDORService;
import iih.ci.mr.s.bp.bewrittentip.BewrittenTipsReverseBp;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskCudService;
import iih.ci.mrqc.mrtask.i.IMrtaskRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class BewrittenTipsReverseListerner implements IBusinessListener{
	
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		List<String> pks=null;
		String sourceId=null; // 事件源id
		boolean flag=event instanceof BusinessEvent;
		boolean flag2=event instanceof BDCommonEvent;
		BewrittenTipsReverseBp bp=new BewrittenTipsReverseBp();
		if(flag){
			BusinessEvent busEvent=(BusinessEvent)event;
			BusinessUserObj userObject =(BusinessUserObj) event.getUserObject();
			Object userObj = userObject.getUserObj();
			sourceId=busEvent.getSourceID();
			pks=bp.getPks(new Object[] {userObj},sourceId);		
		}
		
		if(flag2){
		   BDCommonEvent dbevent=(BDCommonEvent)event;	
		   Object[] newObjs=dbevent.getNewObjs();
		   if(ArrayUtils.isEmpty(newObjs))return;
		   sourceId=dbevent.getSourceID();
		   pks=bp.getPks(newObjs,sourceId);
		  
		}	
		if (pks==null || pks.size()<=0 || StringUtils.isEmptyWithTrim(sourceId)) return;		
		
		// 业务事件
		IMrtaskruleMDORService service=ServiceFinder.find(IMrtaskruleMDORService.class);
		MrTaskRuleDO[] ruleDos=service.find("srcode_evt_cancel='"+sourceId+"' and fg_active='Y'", "sv desc", FBoolean.FALSE);
		if(ruleDos!=null && ruleDos.length<=0) return;	
		
		IMrtaskRService mrRservice=ServiceFinder.find(IMrtaskRService.class);
		IMrtaskCudService mrCudservice=ServiceFinder.find(IMrtaskCudService.class);
		for(String pk:pks){
			for (int i = 0; i < ruleDos.length; i++) {		
				String sqlWhereStr=" id_source='"+pk+"' and id_mr_task_rule='"+ruleDos[i].getPkVal()+"' ";
				MrTaskDO[] taskArr=mrRservice.find(sqlWhereStr, "", FBoolean.FALSE);
				if (taskArr.length>0) {
					mrCudservice.delete(taskArr);
				}
			}		
		}		
	}
}
