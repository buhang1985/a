package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.srv.mrctmca.i.IMrctmcaMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗记录类型自定义分类数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class MrCtmCaDataImptServiceImpl extends BDBaseDataImport<MrCtmCaDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MrCtmCaDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MrCtmCaDO.ID_GRP, MrCtmCaDO.ID_ORG, MrCtmCaDO.NAME, MrCtmCaDO.CODE, MrCtmCaDO.ID_ENTP };
	}

	@Override
	protected void insertToDB(MrCtmCaDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrctmcaMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MrCtmCaDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrctmcaMDOCudService.class).update(importDatas);
	}
}
