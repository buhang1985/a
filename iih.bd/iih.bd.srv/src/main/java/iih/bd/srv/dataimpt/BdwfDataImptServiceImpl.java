package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.i.IWfMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 流程配置数据导入服务
 * 
 * @author xuxing_2016-11-17
 *
 */
public class BdwfDataImptServiceImpl extends BDBaseDataImport<WfDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new WfDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WfDO.ID_WF, WfDO.NAME, WfDO.CODE };
	}

	@Override
	protected void insertToDB(WfDO[] importDatas) throws BizException {
		ServiceFinder.find(IWfMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(WfDO[] importDatas) throws BizException {
		ServiceFinder.find(IWfMDOCudService.class).update(importDatas);
	}

}
