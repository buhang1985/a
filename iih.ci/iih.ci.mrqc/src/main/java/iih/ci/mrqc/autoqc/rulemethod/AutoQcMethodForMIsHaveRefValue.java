/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.autoqc.rulemethod;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.autoitm.d.AutoItmDO;
import iih.bd.srv.itm.d.ItmDO;
import iih.bd.srv.itm.i.IItmRService;
import iih.bd.srv.qcevent.d.QcEventDO;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qaflt.i.IQafltCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 〈扼要描述〉
 * 自动质控文书内容有无处理
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class AutoQcMethodForMIsHaveRefValue {
	public void exec(String id_ent, QcEventDO eventDo, AutoItmDO autoDo, Boolean isDocAutoQcSelf)
			throws BizException {
		String whereStrForMr = "a0.id_ent='" + id_ent + "' and a0.id_mrtp in ('"
				+ autoDo.getId_mr_types() + "')";
		ICiemrRService mrService = ServiceFinder.find(ICiemrRService.class);
		IQafltCudService qafltService=ServiceFinder.find(IQafltCudService.class);
		IItmRService itmService=ServiceFinder.find(IItmRService.class);
		IMrdocrefvalueRService refValueService=ServiceFinder.find(IMrdocrefvalueRService.class);
		CiMrDO[] mrDOs = mrService.find(whereStrForMr, "", FBoolean.FALSE);
		if (mrDOs.length <= 0) {
			return;
		}
		ArrayList<QaFltDO> fltlist = new ArrayList<QaFltDO>();
		for (int i = 0; i < mrDOs.length; i++) {
			MrDocRefValueDO[] refValueDoArr=refValueService.find(" id_ent='"+id_ent+"' and id_mr='"+mrDOs[i].getId_mr()+"' and code_element='"+autoDo.getSd_datagrp()+"'", "", FBoolean.FALSE);
			if (refValueDoArr.length<=0) {
				ItmDO itmDO=itmService.findById(autoDo.getId_qa_itm());
				QaFltDO qaFltDO = new QaFltDO();
				qaFltDO.setId_flt_sta(ICiMrDictCodeConst.ID_REFORM);
				qaFltDO.setSd_flt_sta(ICiMrDictCodeConst.SD_REFORM);
				qaFltDO.setId_ent(id_ent);
				qaFltDO.setId_qa_itm(autoDo.getId_qa_itm());
				qaFltDO.setDrp_des(itmDO.getReq());
				qaFltDO.setRfm_req(autoDo.getReq());
				qaFltDO.setId_sbmt_user(Context.get().getUserId());
				qaFltDO.setId_sbmt_dept(Context.get().getDeptId());
				qaFltDO.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_AUTOMATIC);
				qaFltDO.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_AUTOMATIC);
				qaFltDO.setReal_score(itmDO.getOnce_drp_scr());
				if (mrDOs[i].getCreatedby()!=null) {
					qaFltDO.setId_rfm_user(mrDOs[i].getCreatedby());
					qaFltDO.setId_rfm_dept(mrDOs[i].getId_dep());
				}
				qaFltDO.setId_mr(mrDOs[i].getId_mr());
				qaFltDO.setDeduct_scr_times(1);
				qaFltDO.setDt_sbmt(new FDateTime());
				if(isDocAutoQcSelf){
					qaFltDO.setId_revision("DOCTORAUTOQCSELF");
				}
				qaFltDO.setStatus(DOStatus.NEW);
				fltlist.add(qaFltDO);
			}
		}
	    QaFltDO[] fltArray = fltlist.toArray(new QaFltDO[0]);
	    qafltService.save(fltArray);
	}
}
