package iih.bd.mm.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.mm.meterial.d.MMAliasDO;
import iih.bd.mm.meterial.i.IMMAliasDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 物品别名数据导入服务实现
 * 
 * @author Administrator
 *
 */
public class MmNameDataImptServiceImpl extends BDBaseDataImport<MMAliasDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MMAliasDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MMAliasDO.ID_MMNAME, MMAliasDO.ID_MM, MMAliasDO.NAME };
	}

	@Override
	protected void insertToDB(MMAliasDO[] importDatas) throws BizException {
		ServiceFinder.find(IMMAliasDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MMAliasDO[] importDatas) throws BizException {
		ServiceFinder.find(IMMAliasDOCudService.class).update(importDatas);
	}
}
