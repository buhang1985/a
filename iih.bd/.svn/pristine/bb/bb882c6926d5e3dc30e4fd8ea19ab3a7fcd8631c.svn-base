package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.medsrv.d.MedSrvVtDO;
import iih.bd.srv.medsrv.i.IMedSrvVtDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗服务生命体征数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class MedSrvVtDataImptServiceImpl extends BDBaseDataImport<MedSrvVtDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MedSrvVtDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MedSrvVtDO.ID_SRV, MedSrvVtDO.VALCOUNT };
	}

	@Override
	protected void insertToDB(MedSrvVtDO[] importDatas) throws BizException {
		ServiceFinder.find(IMedSrvVtDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MedSrvVtDO[] importDatas) throws BizException {
		ServiceFinder.find(IMedSrvVtDOCudService.class).update(importDatas);
	}
}
