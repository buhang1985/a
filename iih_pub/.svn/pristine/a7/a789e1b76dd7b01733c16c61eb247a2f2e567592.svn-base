package iih.nm.nhr.psnshiftdto.listener;

import iih.bd.bc.udi.pub.INmNurDictCodeConst;
import iih.nm.nhr.nmpsnshift.d.NmNurTransDO;
import iih.nm.nhr.nmpsnshift.i.INmpsnshiftRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.dftimpl.DefaultProDefExt;
import xap.wf.af.runtime.TaskInstance;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年1月4日 下午7:58:42
 * 类说明：
 * Company: Copyright 2016 by PKU healthcare IT Co.Ltd.
 */
public class NmNurTransProDefHanlder extends DefaultProDefExt{

	@Override
	public String getUrlByTask(TaskInstance task) {
		String billId = task.getId_frmins();
		INmpsnshiftRService rService = ServiceFinder.find(INmpsnshiftRService.class);
		NmNurTransDO nmNurTransDO = null;
		try {
			nmNurTransDO = rService.findById(billId);
		} catch (BizException e) {
			e.printStackTrace();
		}
		
		if(nmNurTransDO == null) {
			return null;
		}
		
		StringBuffer strUrl = new StringBuffer();
		if(nmNurTransDO.getSd_applystatus().equals(INmNurDictCodeConst.SD_APPLY_STATUS_REJECT)) {
			//打开人员调动管理节点 TODO
			strUrl.append("XAP:navigate?Funccode=52100520");
			strUrl.append("&FrmInsPk="+task.getId_frmins());
			strUrl.append("&TaskPk="+task.getId_task());
			strUrl.append("&Status="+nmNurTransDO.getSd_applystatus());
		} else {
			//打开人员调动审核节点 TODO
			strUrl.append("XAP:navigate?Funccode=52100522");
			strUrl.append("&FrmInsPk="+task.getId_frmins());
			strUrl.append("&TaskPk="+task.getId_task());
			strUrl.append("&Status="+nmNurTransDO.getSd_applystatus());
		}

		return  strUrl.toString();
	}
}
