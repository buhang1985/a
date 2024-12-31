package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.mrtplsec.d.MrTplSegFsDO;
import iih.bd.srv.mrtplsec.i.IMrtplsecCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗记录段落模板数据流数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class MrTplSegFsDataImptServiceImpl extends BDBaseDataImport<MrTplSegFsDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MrTplSegFsDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MrTplSegFsDO.ID_MRTPLSEC };
	}

	@Override
	protected void insertToDB(MrTplSegFsDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrtplsecCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MrTplSegFsDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrtplsecCudService.class).update(importDatas);
	}
}
