package iih.pi.reg.s.ws;

import iih.pi.reg.dto.ws.PatAccInfoBean;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;

/**
 * 查询患者账户信息
 * @author hehuan    2017/07/25
 *
 */
public class PatAccInfoQryWSBP {

	/**
	 * 查询患者账户信息
	 * @param patCode 患者编码
	 * @return
	 * @throws BizException
	 */
	public PatAccInfoBean exec(String patCode) throws BizException {
		if (StringUtil.isEmptyWithTrim(patCode)) return null;
		PatAccInfoBean bean = null;
		DAFacade da = new DAFacade();
		String query = this.getSql(patCode);
		try{
			bean = (PatAccInfoBean)da.execQuery(query, new BeanHandler(PatAccInfoBean.class));
		}
		catch (DAException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	private String getSql(String patCode) {
		StringBuilder sb = new StringBuilder();
		sb.append("select nvl(ppa.prepay, 0) prepay,nvl(ppa.acc_lock, 0) acclock,");
		sb.append("0 cred,nvl(ppa.prepay, 0) - nvl(ppa.acc_lock, 0) can_use ");
		sb.append("from pi_pat_acc ppa inner join pi_pat pp on ppa.id_pat = pp.id_pat ");
		sb.append("where pp.code = '" + patCode + "';");
		return sb.toString();
	}
}
