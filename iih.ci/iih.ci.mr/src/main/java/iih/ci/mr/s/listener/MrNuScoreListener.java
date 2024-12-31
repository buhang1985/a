package iih.ci.mr.s.listener;

import java.util.ArrayList;
import java.util.List;
import iih.ci.mr.middle.nuscore.d.CiMrNuScoreMiddleDO;
import iih.ci.mr.middle.nuscore.i.ICimrnuscoremiddledoCudService;
import iih.ci.mr.middle.nuscore.i.ICimrnuscoremiddledoRService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 消费评分量监听
 * @author F
 *
 */
public class MrNuScoreListener implements IBusinessListener{
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		FArrayList2 bizUserObj = (FArrayList2) event.getUserObject();
		if (!"iih.ci.mr.middle.nuscore.d.CiMrNuScoreMiddleDO".equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			return;
		}
		CiMrNuScoreMiddleDO nuScoreDO = (CiMrNuScoreMiddleDO) bizUserObj.get(0);
		if(nuScoreDO==null)
		{
			return;
		}  		
		
		ICimrnuscoremiddledoCudService cudService = ServiceFinder.find(ICimrnuscoremiddledoCudService.class);
		ICimrnuscoremiddledoRService  rService = ServiceFinder.find(ICimrnuscoremiddledoRService.class);
		IInpatientRService inpatService=ServiceFinder.find(IInpatientRService.class);
		
		if("0".equals(nuScoreDO.getType_message())){
			List<CiMrNuScoreMiddleDO> list=new ArrayList<CiMrNuScoreMiddleDO>();
			CiMrNuScoreMiddleDO middleDo = new CiMrNuScoreMiddleDO();
			String code_ent = nuScoreDO.getCode_ent();
		    int times_ip= nuScoreDO.getTimes_ip();
			middleDo.setId_message(nuScoreDO.getId_message());
			middleDo.setTitle_message(nuScoreDO.getTitle_message());
			middleDo.setType_message(nuScoreDO.getType_message());		
			middleDo.setCode_ent(code_ent);
			middleDo.setCode_pat(nuScoreDO.getCode_pat());
			middleDo.setTimes_ip(times_ip);
			middleDo.setName_pat(nuScoreDO.getName_pat());
			middleDo.setCode_pat_dep(nuScoreDO.getCode_pat_dep());
			middleDo.setPat_dep(nuScoreDO.getPat_dep());
			middleDo.setCode_pat_nur(nuScoreDO.getCode_pat_nur());
			middleDo.setPat_nur(nuScoreDO.getPat_nur());
			middleDo.setCode_emp_operate(nuScoreDO.getCode_emp_operate());
			middleDo.setEmp_operate(nuScoreDO.getEmp_operate());
			middleDo.setDt_operate(nuScoreDO.getDt_operate());
			middleDo.setCode_nus_item(nuScoreDO.getCode_nus_item());
			middleDo.setName_nus_item(nuScoreDO.getName_nus_item());
			middleDo.setValue_vs_item(nuScoreDO.getValue_vs_item());
			InpatientDO[] inpatientDOs = inpatService.find("code_amr_ip='" + code_ent + "' and times_ip=" + times_ip, "", FBoolean.FALSE);
			String id_ent="";
			if(inpatientDOs.length>0 && inpatientDOs !=null){
				id_ent=inpatientDOs[0].getId_ent();
			}
			middleDo.setId_ent(id_ent);
			middleDo.setStatus(DOStatus.NEW);
			list.add(middleDo);
			cudService.save(list.toArray(new CiMrNuScoreMiddleDO[0]));
		}
		if("1".equals(nuScoreDO.getType_message())){			
			CiMrNuScoreMiddleDO[] middleDos=rService.findByAttrValString("Id_message", nuScoreDO.getId_message());
			if(middleDos!=null&&middleDos.length>0)
			{
				List<CiMrNuScoreMiddleDO> list=new ArrayList<CiMrNuScoreMiddleDO>();
				CiMrNuScoreMiddleDO middleDo = middleDos[0];
				middleDo.setTitle_message(nuScoreDO.getTitle_message());
				middleDo.setType_message(nuScoreDO.getType_message());		
				middleDo.setCode_ent(nuScoreDO.getCode_ent());
				middleDo.setCode_pat(nuScoreDO.getCode_pat());
				middleDo.setTimes_ip(nuScoreDO.getTimes_ip());
				middleDo.setName_pat(nuScoreDO.getName_pat());
				middleDo.setCode_pat_dep(nuScoreDO.getCode_pat_dep());
				middleDo.setPat_dep(nuScoreDO.getPat_dep());
				middleDo.setCode_pat_nur(nuScoreDO.getCode_pat_nur());
				middleDo.setPat_nur(nuScoreDO.getPat_nur());
				middleDo.setCode_emp_operate(nuScoreDO.getCode_emp_operate());
				middleDo.setEmp_operate(nuScoreDO.getEmp_operate());
				middleDo.setDt_operate(nuScoreDO.getDt_operate());
				middleDo.setCode_nus_item(nuScoreDO.getCode_nus_item());
				middleDo.setName_nus_item(nuScoreDO.getName_nus_item());
				middleDo.setValue_vs_item(nuScoreDO.getValue_vs_item());
				middleDo.setStatus(DOStatus.UPDATED);
				list.add(middleDo);
				cudService.save(list.toArray(new CiMrNuScoreMiddleDO[0]));
			}
		}		
		if("-1".equals(nuScoreDO.getType_message())){
			CiMrNuScoreMiddleDO[] middleDos=rService.findByAttrValString("Id_message", nuScoreDO.getId_message());
			if(middleDos!=null&&middleDos.length>0)
			{
				cudService.delete(middleDos);
			}
		}
	}
}
