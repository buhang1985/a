package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.srv.mrtplseg.i.IMrtplsegCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗记录段落模板数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class MrTplSegDataImptServiceImpl extends BDBaseDataImport<MrTplSegmentDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MrTplSegmentDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MrTplSegmentDO.ID_GRP, MrTplSegmentDO.ID_ORG, MrTplSegmentDO.CODE, MrTplSegmentDO.NAME,
				MrTplSegmentDO.ID_MRED, MrTplSegmentDO.ID_DG };
	}

	@Override
	protected void insertToDB(MrTplSegmentDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrtplsegCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MrTplSegmentDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrtplsegCudService.class).update(importDatas);
	}
}
