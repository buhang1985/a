package iih.ci.mi.ord;

import iih.ci.mi.ord.bp.UpdateOrdMiInfoBP;
import iih.ci.mi.ord.i.ICiMiOrdCudService;
import iih.ci.mi.ord.i.meta.OrdMiRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱医保信息更新接口
 * @author HUMS
 *
 */
public class CiMiOrdCudServiceImpl implements ICiMiOrdCudService {

	@Override
	public OrdMiRstDTO[] updateOrdMiInfo(OrdMiRstDTO[] OrdMiRsts) throws BizException {
		
		UpdateOrdMiInfoBP bp = new UpdateOrdMiInfoBP();
		return bp.updateOrdMiInfo(OrdMiRsts);
	}

	@Override
	public OrdMiRstDTO[] updateOrdMiInfo2Selfpay(String[] orIdList, String[] orsrvIdList) throws BizException {
		UpdateOrdMiInfoBP bp = new UpdateOrdMiInfoBP();
		return bp.updateOrdMiInfo2Selfpay(orIdList, orsrvIdList);
	}

}
