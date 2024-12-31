package iih.bd.res.bed.s;

import iih.bd.res.bed.i.IBedExtCudService;
import iih.bd.res.bed.i.IBedExtRService;
import iih.bd.res.bed.s.bp.FindBedPriMapByIdsBp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * 床位扩展查询服务
 * 
 * @author hao_wu
 *
 */
public class BedExtCrudServiceImpl implements IBedExtRService, IBedExtCudService {

	@Override
	public FMap2 findBedPriMapByIds(String[] bedIds) throws BizException {
		FindBedPriMapByIdsBp bp = new FindBedPriMapByIdsBp();
		FMap2 bedPriMap = bp.exec(bedIds);
		return bedPriMap;
	}
}
