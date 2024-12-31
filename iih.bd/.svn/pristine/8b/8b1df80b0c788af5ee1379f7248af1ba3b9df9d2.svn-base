package iih.bd.srv.mrtplseg.s;

import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.srv.mrtplseg.i.IMrTplSegEnableService;
import iih.bd.srv.mrtplseg.s.bp.DisableMrTplSegmentBp;
import iih.bd.srv.mrtplseg.s.bp.EnableMrTplSegmentBp;
import xap.mw.core.data.BizException;

/**
 * 医疗记录段落模板启用服务
 * 
 * @author hao_wu
 *
 */
public class MrTplSegEnableServiceImpl implements IMrTplSegEnableService {

	@Override
	public MrTplSegmentDO[] Enable(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException {
		EnableMrTplSegmentBp bp = new EnableMrTplSegmentBp();
		MrTplSegmentDO[] result = bp.exec(mrTplSegmentDOs);
		return result;
	}

	@Override
	public MrTplSegmentDO[] Disable(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException {
		DisableMrTplSegmentBp bp = new DisableMrTplSegmentBp();
		MrTplSegmentDO[] result = bp.exec(mrTplSegmentDOs);
		return result;
	}

}
