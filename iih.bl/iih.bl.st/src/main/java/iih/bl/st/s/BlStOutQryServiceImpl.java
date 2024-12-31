package iih.bl.st.s;

import iih.bl.st.dto.blipauditstatus.d.BlIpAuditStatusDTO;
import iih.bl.st.i.IBlStOutQryService;
import iih.bl.st.s.bp.out.GetIpAuditStatusBP;
import xap.mw.core.data.BizException;

/**
 * 
 * 结算对外查询接口
 * @author ly 2020/01/02
 *
 */
public class BlStOutQryServiceImpl implements IBlStOutQryService {

	/**
	 * 获取患者住院费用审核状态
	 * @param entIds 就诊id数组
	 * @return 审核状态
	 * @throws BizException
	 * @author ly 2020/01/02
	 */
	@Override
	public BlIpAuditStatusDTO[] getIpAuditStatus(String[] entIds) throws BizException {
		GetIpAuditStatusBP bp = new GetIpAuditStatusBP();
		return bp.exec(entIds);
	}
}
