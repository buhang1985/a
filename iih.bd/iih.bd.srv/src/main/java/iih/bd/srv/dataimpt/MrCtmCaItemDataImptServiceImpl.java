package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.mrctmca.d.MrCaCtmItmDO;
import iih.bd.srv.mrctmca.i.IMrCaCtmItmDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗记录类型自定义分类项目数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class MrCtmCaItemDataImptServiceImpl extends BDBaseDataImport<MrCaCtmItmDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MrCaCtmItmDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MrCaCtmItmDO.ID_ORG, MrCaCtmItmDO.SORTNO, MrCaCtmItmDO.ID_MRTP, MrCaCtmItmDO.ID_MRCACTM };
	}

	@Override
	protected void insertToDB(MrCaCtmItmDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrCaCtmItmDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MrCaCtmItmDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrCaCtmItmDOCudService.class).update(importDatas);
	}
}
