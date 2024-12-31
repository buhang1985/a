package iih.ci.mr.s.listener;

import java.util.ArrayList;
import java.util.List;

import iih.ci.mr.middle.nmr.d.CiMrMiddleNmrDO;
import iih.ci.mr.middle.nmr.i.ICimrmiddlenmrdoCudService;
import iih.ci.mr.middle.nmr.i.ICimrmiddlenmrdoRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 病历消费护理记录监听
 * @author F
 *
 */
public class MrNmrListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		FArrayList2 bizUserObj = (FArrayList2) event.getUserObject();
		if (!"iih.ci.mr.middle.nmr.d.CiMrMiddleNmrDO".equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			return;
		}
		CiMrMiddleNmrDO nmrDO = (CiMrMiddleNmrDO) bizUserObj.get(0);
		if(nmrDO==null)
		{
			return;
		}
		
		ICimrmiddlenmrdoCudService cudService =ServiceFinder.find(ICimrmiddlenmrdoCudService.class);
		ICimrmiddlenmrdoRService rService =ServiceFinder.find(ICimrmiddlenmrdoRService.class);
		
		if("0".equals(nmrDO.getType_message())){
			List<CiMrMiddleNmrDO> list=new ArrayList<CiMrMiddleNmrDO>();
			CiMrMiddleNmrDO middleDo = new CiMrMiddleNmrDO();
			middleDo.setId_message(nmrDO.getId_message());
			middleDo.setTitle_message(nmrDO.getTitle_message());
			middleDo.setType_message(nmrDO.getType_message());		
			middleDo.setCode_ent(nmrDO.getCode_ent());
			middleDo.setCode_pat(nmrDO.getCode_pat());
			middleDo.setTimes_ip(nmrDO.getTimes_ip());
			middleDo.setName_pat(nmrDO.getName_pat());
			middleDo.setCode_pat_dep(nmrDO.getCode_pat_dep());
			middleDo.setPat_dep(nmrDO.getPat_dep());
			middleDo.setCode_pat_nur(nmrDO.getCode_pat_nur());
			middleDo.setPat_nur(nmrDO.getPat_nur());
			middleDo.setCode_emp_operate(nmrDO.getCode_emp_operate());
			middleDo.setEmp_operate(nmrDO.getEmp_operate());
			middleDo.setDt_operate(nmrDO.getDt_operate());
			middleDo.setValue_text(nmrDO.getValue_text());
			middleDo.setStatus(DOStatus.NEW);
			list.add(middleDo);		
			cudService.save(list.toArray(new CiMrMiddleNmrDO[0]));	
		}
		if("1".equals(nmrDO.getType_message())){
			
			CiMrMiddleNmrDO[] middleDos=rService.findByAttrValString("Id_message", nmrDO.getId_message());
			if(middleDos!=null&&middleDos.length>0)
			{
				List<CiMrMiddleNmrDO> list=new ArrayList<CiMrMiddleNmrDO>();
				CiMrMiddleNmrDO middleDo = middleDos[0];
				middleDo.setTitle_message(nmrDO.getTitle_message());
				middleDo.setType_message(nmrDO.getType_message());		
				middleDo.setCode_ent(nmrDO.getCode_ent());
				middleDo.setCode_pat(nmrDO.getCode_pat());
				middleDo.setTimes_ip(nmrDO.getTimes_ip());
				middleDo.setName_pat(nmrDO.getName_pat());
				middleDo.setCode_pat_dep(nmrDO.getCode_pat_dep());
				middleDo.setPat_dep(nmrDO.getPat_dep());
				middleDo.setCode_pat_nur(nmrDO.getCode_pat_nur());
				middleDo.setPat_nur(nmrDO.getPat_nur());
				middleDo.setCode_emp_operate(nmrDO.getCode_emp_operate());
				middleDo.setEmp_operate(nmrDO.getEmp_operate());
				middleDo.setDt_operate(nmrDO.getDt_operate());
				middleDo.setValue_text(nmrDO.getValue_text());
				middleDo.setStatus(DOStatus.UPDATED);
				list.add(middleDo);
				cudService.save(list.toArray(new CiMrMiddleNmrDO[0]));
			}
		}
		if("-1".equals(nmrDO.getType_message())){
			CiMrMiddleNmrDO[] middleDos=rService.findByAttrValString("Id_message", nmrDO.getId_message());
			if(middleDos!=null&&middleDos.length>0)
			{
				cudService.delete(middleDos);
			}
		}
	}
}
