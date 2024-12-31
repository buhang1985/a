package iih.bd.srv.mrtplstream.s;

import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.mrtplstream.i.IMrTplStreamExtCudService;
import iih.bd.srv.mrtplstream.s.bp.CheckDataGroupBp;
import xap.mw.core.data.BizException;

/**
 * 医疗记录模板流数据数据维护扩展服务
 * 
 * @author hao_wu
 *
 */
public class MrTplStreamExtCrudServiceImpl implements IMrTplStreamExtCudService {

	@Override
	public void CheckDataGroup(EmrTplStreamDO emrTplStreamDO, String[] dataGrpCodeArr) throws BizException {
		CheckDataGroupBp bp = new CheckDataGroupBp();
		bp.exec(emrTplStreamDO, dataGrpCodeArr);
	}
}
