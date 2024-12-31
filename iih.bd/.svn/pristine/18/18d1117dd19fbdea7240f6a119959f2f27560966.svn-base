package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.mrelement.d.MrEleValDO;
import iih.bd.srv.mrelement.i.IMrEleValDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 病历元素值域数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class MrEleValDataImptServiceImpl extends BDBaseDataImport<MrEleValDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MrEleValDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MrEleValDO.ID_MR_DE, MrEleValDO.CODE, MrEleValDO.NAME };
	}

	@Override
	protected void insertToDB(MrEleValDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrEleValDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MrEleValDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrEleValDOCudService.class).update(importDatas);
	}
}
