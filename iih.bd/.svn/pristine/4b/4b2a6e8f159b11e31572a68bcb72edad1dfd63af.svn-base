package iih.bd.srv.mrctmca.s;

import iih.bd.srv.mrctmca.d.MrCaCtmItmDO;
import iih.bd.srv.mrctmca.i.IMrCaCtmItmDOExtCudService;
import iih.bd.srv.mrctmca.i.IMrCaCtmItmDOExtRService;
import iih.bd.srv.mrctmca.s.bp.GetErrorItemArrBySetCaBp;
import xap.mw.core.data.BizException;

/**
 * 医疗记录类型自定义分类项目扩展服务
 * 
 * @author hao_wu
 *
 */
public class MrCaCtmItmDOExtCrudServiceImpl implements IMrCaCtmItmDOExtCudService, IMrCaCtmItmDOExtRService {

	@Override
	public MrCaCtmItmDO[] GetErrorItemArrBySetCa(String setCaId, MrCaCtmItmDO[] mrCaCtmItmArr) throws BizException {
		GetErrorItemArrBySetCaBp bp = new GetErrorItemArrBySetCaBp();
		MrCaCtmItmDO[] result = bp.exec(setCaId, mrCaCtmItmArr);
		return result;
	}

}
