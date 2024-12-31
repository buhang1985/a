package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.orwf.d.WfCfgAttrDO;
import iih.bd.fc.orwf.i.IWfCfgAttrDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/** 
* @description:流向配置属性导入数据
* @author : hehaochen
* @version 创建时间：2019年12月16日 下午1:43:30 
* 
*/
public class BdWfCfgAttrDataImplServiceImpl extends BDBaseDataImport<WfCfgAttrDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new WfCfgAttrDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WfCfgAttrDO.ID_WF_CFG_ATTR, WfCfgAttrDO.ID_WF_CFG };
	}

	@Override
	protected void insertToDB(WfCfgAttrDO[] importDatas) throws BizException {
		ServiceFinder.find(IWfCfgAttrDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(WfCfgAttrDO[] importDatas) throws BizException {
		ServiceFinder.find(IWfCfgAttrDOCudService.class).update(importDatas);
	}

}
