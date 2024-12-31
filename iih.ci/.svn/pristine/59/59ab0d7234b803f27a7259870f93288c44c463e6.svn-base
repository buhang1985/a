package iih.ci.mr.s.listener;

import java.util.ArrayList;
import java.util.List; 
import iih.ci.mr.middle.cons.d.CiMrMiddleConsDO;
import iih.ci.mr.middle.cons.i.ICimrmiddleconsdoCudService;
import iih.ci.mr.middle.cons.i.ICimrmiddleconsdoRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 病历消费会诊记录监听
 * @author F
 *
 */
public class MrConsListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		FArrayList2 bizUserObj = (FArrayList2) event.getUserObject();
		if (!"iih.ci.mr.middle.cons.d.CiMrMiddleConsDO".equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			return;
		}
		CiMrMiddleConsDO consDO = (CiMrMiddleConsDO) bizUserObj.get(0);
		if(consDO==null)
		{
			return;
		}  		
		
		ICimrmiddleconsdoCudService cudService = ServiceFinder.find(ICimrmiddleconsdoCudService.class);
		ICimrmiddleconsdoRService  rService = ServiceFinder.find(ICimrmiddleconsdoRService.class);
		
		if("0".equals(consDO.getType_message())){
			List<CiMrMiddleConsDO> list=new ArrayList<CiMrMiddleConsDO>();
			CiMrMiddleConsDO middleDo = new CiMrMiddleConsDO();
			middleDo.setId_message(consDO.getId_message());
			middleDo.setTitle_message(consDO.getTitle_message());
			middleDo.setType_message(consDO.getType_message());		
			middleDo.setCode_ent(consDO.getCode_ent());
			middleDo.setCode_pat(consDO.getCode_pat());
			middleDo.setTimes_ip(consDO.getTimes_ip());
			middleDo.setName_pat(consDO.getName_pat());
			middleDo.setCode_pat_dep(consDO.getCode_pat_dep());
			middleDo.setPat_dep(consDO.getPat_dep());
			middleDo.setCode_pat_nur(consDO.getCode_pat_nur());
			middleDo.setPat_nur(consDO.getPat_nur());
			middleDo.setCode_emp_operate(consDO.getCode_emp_operate());
			middleDo.setEmp_operate(consDO.getEmp_operate());
			middleDo.setDt_operate(consDO.getDt_operate());
			middleDo.setValue_text(consDO.getValue_text());
			middleDo.setStatus(DOStatus.NEW);
			list.add(middleDo);
			cudService.save(list.toArray(new CiMrMiddleConsDO[0]));
		}
		if("1".equals(consDO.getType_message())){
			
			CiMrMiddleConsDO[] middleDos=rService.findByAttrValString("Id_message", consDO.getId_message());
			if(middleDos!=null&&middleDos.length>0)
			{
				List<CiMrMiddleConsDO> list=new ArrayList<CiMrMiddleConsDO>();
				CiMrMiddleConsDO middleDo = middleDos[0];
				middleDo.setTitle_message(consDO.getTitle_message());
				middleDo.setType_message(consDO.getType_message());		
				middleDo.setCode_ent(consDO.getCode_ent());
				middleDo.setCode_pat(consDO.getCode_pat());
				middleDo.setTimes_ip(consDO.getTimes_ip());
				middleDo.setName_pat(consDO.getName_pat());
				middleDo.setCode_pat_dep(consDO.getCode_pat_dep());
				middleDo.setPat_dep(consDO.getPat_dep());
				middleDo.setCode_pat_nur(consDO.getCode_pat_nur());
				middleDo.setPat_nur(consDO.getPat_nur());
				middleDo.setCode_emp_operate(consDO.getCode_emp_operate());
				middleDo.setEmp_operate(consDO.getEmp_operate());
				middleDo.setDt_operate(consDO.getDt_operate());
				middleDo.setValue_text(consDO.getValue_text());
				middleDo.setStatus(DOStatus.UPDATED);
				list.add(middleDo);
				cudService.save(list.toArray(new CiMrMiddleConsDO[0]));
			}
		}		
		if("-1".equals(consDO.getType_message())){
			CiMrMiddleConsDO[] middleDos=rService.findByAttrValString("Id_message", consDO.getId_message());
			if(middleDos!=null&&middleDos.length>0)
			{
				cudService.delete(middleDos);
			}
		}
	}
}
