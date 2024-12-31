package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.wf.d.WfDepDO;
import iih.bd.fc.wf.i.IWfDepDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医嘱流向科室配置数据导入
 * 
 * @author hao_wu 2018-7-31
 *
 */
public class BdWfDepDataImport extends BDBaseDataImport<WfDepDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new WfDepDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WfDepDO.ID_WF };
	}

	@Override
	protected void insertToDB(WfDepDO[] importDatas) throws BizException {
		ServiceFinder.find(IWfDepDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(WfDepDO[] importDatas) throws BizException {
		ServiceFinder.find(IWfDepDOCudService.class).update(importDatas);
	}

}
