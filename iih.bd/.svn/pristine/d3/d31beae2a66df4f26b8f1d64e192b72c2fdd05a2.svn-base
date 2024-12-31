package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.wf.d.WfSrvtpDO;
import iih.bd.fc.wf.i.IWfSrvtpDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 流程配置，服务类型数据导入服务
 * 
 * @author xuxing_2016-11-17
 *
 */
public class BdwfSrvtpDataImptServiceImpl extends BDBaseDataImport<WfSrvtpDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new WfSrvtpDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[0];
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
