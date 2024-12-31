package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.mrelement.d.MrElementDO;
import iih.bd.srv.mrelement.i.IBdmrdeMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 病历元素数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class MrEleDataImptServiceImpl extends BDBaseDataImport<MrElementDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MrElementDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MrElementDO.ID_GRP, MrElementDO.ID_ORG, MrElementDO.CODE, MrElementDO.NAME,
				MrElementDO.ID_MRDETP, MrElementDO.SD_MRDETP };
	}

	@Override
	protected void insertToDB(MrElementDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdmrdeMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MrElementDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdmrdeMDOCudService.class).update(importDatas);
	}
}
