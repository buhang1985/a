package iih.hp.cp.hpcp.i;

import iih.bd.bc.udi.pub.IHPDictCodeConst;
import iih.hp.cp.hpcp.d.HpcpAggDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.dftimpl.DefaultProDefExt;
import xap.wf.af.runtime.TaskInstance;

public class HpcpProDefHanlder extends DefaultProDefExt {
	@Override
	public String getUrlByTask(TaskInstance task) {
		String billId = task.getId_frmins();
		IHpcpRService iHpcpRService = ServiceFinder.find(IHpcpRService.class);
		HpcpAggDO hpcpAggDO = null;
		try {
			hpcpAggDO = iHpcpRService.findById(billId);
		} catch (BizException e) {
			e.printStackTrace();
		}
		
		if(hpcpAggDO == null) {
			return null;
		}
		
		StringBuffer strUrl = new StringBuffer();
		if(hpcpAggDO.getParentDO().getSd_status().equals(IHPDictCodeConst.SD_HPCP_STATUS_REJECT)) {
			//打开诊疗计划定义节点 TODO
			strUrl.append("XAP:navigate?Funccode=49101005");
			strUrl.append("&FrmInsPk="+task.getId_frmins());
			strUrl.append("&TaskPk="+task.getId_task());
			strUrl.append("&Status="+hpcpAggDO.getParentDO().getSd_status());
		} else {
			//打开诊疗计划审核节点 TODO
			strUrl.append("XAP:navigate?Funccode=49101020");
			strUrl.append("&FrmInsPk="+task.getId_frmins());
			strUrl.append("&TaskPk="+task.getId_task());
			strUrl.append("&Status="+hpcpAggDO.getParentDO().getSd_status());
		}

		return  strUrl.toString();
	}
}
