package iih.ci.mrqc.autoqc.rulemethod.TerminalAutoQc;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.autoitm.d.AutoItmDO;
import iih.bd.srv.qcevent.d.QcEventDO;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.divide.i.IDivideCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class TerminalAutoQcForTwoUtil {
	public DivideDO[] exec(String id_ent, QcEventDO eventDo, AutoItmDO autoDo)
			throws BizException {
		String whereStrForMr = "a0.id_ent='" + id_ent + "' and a0.id_mrtp in ('"
				+ autoDo.getId_mr_types() + "')";
		ICiemrRService mrService = ServiceFinder.find(ICiemrRService.class);
		IDivideCudService qafltService=ServiceFinder.find(IDivideCudService.class);
		IMrdocrefvalueRService refValueService=ServiceFinder.find(IMrdocrefvalueRService.class);
		CiMrDO[] mrDOs = mrService.find(whereStrForMr, "", FBoolean.FALSE);
		if (mrDOs.length <= 0) {
			return null;
		}
		ArrayList<DivideDO> fltlist = new ArrayList<DivideDO>();
		for (int i = 0; i < mrDOs.length; i++) {
			MrDocRefValueDO[] refValueDoArr=refValueService.find(" id_ent='"+id_ent+"' and id_mr='"+mrDOs[i].getId_mr()+"' and code_element='"+autoDo.getSd_datagrp()+"'", "", FBoolean.FALSE);
			if (refValueDoArr.length<=0) {
				DivideDO qaFltDO = new DivideDO();
				qaFltDO.setId_ent(id_ent);
				qaFltDO.setId_qa_itm(autoDo.getId_qa_itm());
				//qaFltDO.setDrp_des(itmDO.getReq()+"("+eventDo.getName()+" ： 时间："+autoQcDTO.getDt_acpt()+")");
				qaFltDO.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_AUTOMATIC);
				qaFltDO.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_AUTOMATIC);
				qaFltDO.setDeduct_scr_times(1);
				qaFltDO.setSbmt_time(new FDateTime());
				qaFltDO.setStatus(DOStatus.NEW);
				fltlist.add(qaFltDO);
			}
		}
		DivideDO[] fltArray = fltlist.toArray(new DivideDO[0]);
		return qafltService.save(fltArray);
	}
}
