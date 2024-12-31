package iih.bl.pay.s.bp.ip;

import iih.bd.utils.CommDAFacade;
import iih.bl.pay.s.bp.ip.qry.GetRePreCarryQry;
import iih.bl.st.payment.d.BlIpPrePayPatDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获取退结转预交金数据
 * 
 * @author LIM
 * @since 2019-11-05
 *
 */
public class GetRePreCarryBP {
	/**
	 * 获取是否存在退结转预交金数据
	 * @param idSt
	 * @throws BizException
	 */
	public FBoolean exec(String idSt) throws BizException {
		if (StringUtil.isEmpty(idSt)) {
			return FBoolean.FALSE;
		}
		BlIpPrePayPatDTO[] dtos = (BlIpPrePayPatDTO[]) CommDAFacade.execQuery(new GetRePreCarryQry(idSt), BlIpPrePayPatDTO.class);
		return ArrayUtil.isEmpty(dtos) ? FBoolean.FALSE : FBoolean.TRUE;
	}
}
