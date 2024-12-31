package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.emrtype.i.IEmrtypeCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗记录类型数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class MrTpDataImptServiceImpl extends BDBaseDataImport<MrTpDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MrTpDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MrTpDO.ID_GRP, MrTpDO.ID_ORG, MrTpDO.CODE, MrTpDO.CD_STD, MrTpDO.MR_SIGN_LVL_CD };
	}

	@Override
	protected void insertToDB(MrTpDO[] importDatas) throws BizException {
		ServiceFinder.find(IEmrtypeCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MrTpDO[] importDatas) throws BizException {
		ServiceFinder.find(IEmrtypeCudService.class).update(importDatas);
	}
}
