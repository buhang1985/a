package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.preformat.d.MrPreFormatDO;
import iih.bd.srv.preformat.i.IPreformatCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 处方格式数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class MrPreFormatDataImptServiceImpl extends BDBaseDataImport<MrPreFormatDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MrPreFormatDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MrPreFormatDO.ID_GRP, MrPreFormatDO.ID_ORG, MrPreFormatDO.NU_SORT,
				MrPreFormatDO.ID_MRTPLSEC, MrPreFormatDO.ID_MEDSRVTYPE };
	}

	@Override
	protected void insertToDB(MrPreFormatDO[] importDatas) throws BizException {
		ServiceFinder.find(IPreformatCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MrPreFormatDO[] importDatas) throws BizException {
		ServiceFinder.find(IPreformatCudService.class).update(importDatas);
	}
}
