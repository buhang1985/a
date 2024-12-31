package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.orpltpstamsp.d.OrpltpStaMapDO;
import iih.bd.fc.orpltpstamsp.i.IOrpltpstamspCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/** 
* @description:医嘱执行闭环类型状态对照关系导入数据
* @author : hehaochen
* @version 创建时间：2019年12月16日 上午11:23:11 
* 
*/
public class BdOrpltpstaMapDataImptServiceImpl extends BDBaseDataImport<OrpltpStaMapDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new OrpltpStaMapDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { OrpltpStaMapDO.ID_ORPLTPSTA_MAP, OrpltpStaMapDO.ID_ORPLTPSTA };
	}

	@Override
	protected void insertToDB(OrpltpStaMapDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpstamspCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(OrpltpStaMapDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpstamspCudService.class).update(importDatas);
	}

}
