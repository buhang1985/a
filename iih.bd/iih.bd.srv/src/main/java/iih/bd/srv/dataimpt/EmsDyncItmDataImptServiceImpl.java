package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.ems.d.EmsIndexDO;
import iih.bd.srv.ems.i.IEmsIndexDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗单动态指标数据导入服务实现
 * 
 * @author hao_wu 2019-12-18
 *
 */
public class EmsDyncItmDataImptServiceImpl extends BDBaseDataImport<EmsIndexDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new EmsIndexDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { EmsIndexDO.ID_SRVOF, EmsIndexDO.ID_SRV, EmsIndexDO.NAME_DISP, EmsIndexDO.SORTNO };
	}

	@Override
	protected void insertToDB(EmsIndexDO[] importDatas) throws BizException {
		ServiceFinder.find(IEmsIndexDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(EmsIndexDO[] importDatas) throws BizException {
		ServiceFinder.find(IEmsIndexDOCudService.class).update(importDatas);
	}
}
