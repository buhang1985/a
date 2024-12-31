package iih.bl.st.i;

import iih.bl.st.dto.blipauditstatus.d.BlIpAuditStatusDTO;
import xap.mw.core.data.BizException;

/**
 * 
 * 结算对外查询接口
 * @author ly 2020/01/02
 *
 */
public interface IBlStOutQryService {

	/**
	 * 获取患者住院费用审核状态
	 * @param entIds 就诊id数组
	 * @return 审核状态
	 * @throws BizException
	 * @author ly 2020/01/02
	 */
	public abstract BlIpAuditStatusDTO[] getIpAuditStatus(String[] entIds) throws BizException;
}
