package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchDO;
import iih.bd.fc.orpltpmatch.i.IOrpltpmatchMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/** 
* @description:医嘱闭环匹配导入数据
* @author : hehaochen
* @version 创建时间：2019年12月16日 上午11:30:10 
* 
*/
public class BdOrpltpMatchDataImptServiceImpl extends BDBaseDataImport<OrpltpMatchDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new OrpltpMatchDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { OrpltpMatchDO.ID_ORPLTP_MATCH, OrpltpMatchDO.ID_ORPLTP };
	}

	@Override
	protected void insertToDB(OrpltpMatchDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpmatchMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(OrpltpMatchDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpmatchMDOCudService.class).update(importDatas);
	}

}
