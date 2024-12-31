package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.wf.d.WfSrvtpDO;
import iih.bd.fc.wf.i.IWfSrvtpDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/** 
* @description:流程配置_服务类型导入数据
* @author : hehaochen
* @version 创建时间：2019年12月16日 下午1:37:21 
* 
*/
public class BdWfSrvtpDataImplServiceImpl extends BDBaseDataImport<WfSrvtpDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new WfSrvtpDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WfSrvtpDO.ID_WF, WfSrvtpDO.ID_WFSRVTP };
	}

	@Override
	protected void insertToDB(WfSrvtpDO[] importDatas) throws BizException {
		ServiceFinder.find(IWfSrvtpDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(WfSrvtpDO[] importDatas) throws BizException {
		ServiceFinder.find(IWfSrvtpDOCudService.class).update(importDatas);
	}

}
