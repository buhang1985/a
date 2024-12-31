package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.i.IWfMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/** 
* @description:医嘱流向导入数据
* @author : hehaochen
* @version 创建时间：2019年12月16日 下午1:33:32 
* 
*/
public class BdWfDataImplServiceImpl extends BDBaseDataImport<WfDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new WfDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WfDO.ID_WF };
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
