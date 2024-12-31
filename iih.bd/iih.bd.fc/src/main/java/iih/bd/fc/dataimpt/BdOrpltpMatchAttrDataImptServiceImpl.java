package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchAttrDO;
import iih.bd.fc.orpltpmatch.i.IOrpltpMatchAttrDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/** 
* @description:医嘱闭环匹配属性导入数据
* @author : hehaochen
* @version 创建时间：2019年12月16日 上午11:33:29 
* 
*/
public class BdOrpltpMatchAttrDataImptServiceImpl extends BDBaseDataImport<OrpltpMatchAttrDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new OrpltpMatchAttrDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { OrpltpMatchAttrDO.ID_ORPLTP_MATCH_ATTR, OrpltpMatchAttrDO.ID_ORPLTP_MATCH };
	}

	@Override
	protected void insertToDB(OrpltpMatchAttrDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpMatchAttrDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(OrpltpMatchAttrDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpMatchAttrDOCudService.class).update(importDatas);
	}

}
