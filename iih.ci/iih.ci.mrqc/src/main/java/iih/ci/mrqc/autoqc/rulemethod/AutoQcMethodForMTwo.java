package iih.ci.mrqc.autoqc.rulemethod;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.autoitm.d.AutoItmDO;
import iih.bd.srv.itm.d.ItmDO;
import iih.bd.srv.itm.i.IItmRService;
import iih.bd.srv.qcevent.d.QcEventDO;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.cimrfs.i.ICimrfsRService;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qaflt.i.IQafltCudService;

import org.dom4j.Document;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class AutoQcMethodForMTwo {
	public void exec(String id_ent, QcEventDO eventDo, AutoItmDO autoDo)
			throws BizException {
		String whereStrForMr = "a0.id_ent='" + id_ent + "' and a0.id_mrtp in ('"
				+ autoDo.getId_mr_types() + "')";
		ICiemrRService mrService = ServiceFinder.find(ICiemrRService.class);
		IQafltCudService qafltService=ServiceFinder.find(IQafltCudService.class);
		IItmRService itmService=ServiceFinder.find(IItmRService.class);
		CiMrDO[] mrDOs = mrService.find(whereStrForMr, "", FBoolean.FALSE);
		if (mrDOs.length <= 0) {
			return;
		}
		ICimrfsRService mrFsService = ServiceFinder.find(ICimrfsRService.class);
		ArrayList<QaFltDO> fltlist = new ArrayList<QaFltDO>();
		for (int i = 0; i < mrDOs.length; i++) {
			CiMrFsDO[] fsDos = mrFsService.find("a0.id_mr='"+mrDOs[i].getId_mr()+"'", "",FBoolean.FALSE);
			if (fsDos.length <= 0)
				return;
			byte[] emrfs = fsDos[0].getEmrfs();// 因为一篇文书对应一个流 所以查出来要是有数据 就只有一条
			Document doc = MrXmlAnalysisUtil.parse(emrfs);
			boolean iszhusu = MrXmlAnalysisUtil.isZHUSU(doc,autoDo.getSd_datagrp());
			if(!iszhusu){
				ItmDO itmDO=itmService.findById(autoDo.getId_qa_itm());
				QaFltDO qaFltDO = new QaFltDO();
				qaFltDO.setId_flt_sta(ICiMrDictCodeConst.ID_REFORM);
				qaFltDO.setSd_flt_sta(ICiMrDictCodeConst.SD_REFORM);
				qaFltDO.setId_ent(id_ent);
				qaFltDO.setId_qa_itm(autoDo.getId_qa_itm());
				qaFltDO.setDrp_des(itmDO.getReq());
				qaFltDO.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_AUTOMATIC);
				qaFltDO.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_AUTOMATIC);
				qaFltDO.setDeduct_scr_times(1);
				qaFltDO.setDt_sbmt(new FDateTime());
				qaFltDO.setStatus(DOStatus.NEW);
				fltlist.add(qaFltDO);
			}
		}
	    QaFltDO[] fltArray = fltlist.toArray(new QaFltDO[0]);
	    qafltService.save(fltArray);
	}
}
