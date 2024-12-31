package iih.bl.st.s.bp;

import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class HasUnpaidDataBP {

	/**
	 * 患者是否存在住院结算未付款的结算数据
	 * 
	 * @throws BizException
	 * */
	public FBoolean exec(String id_ent) throws BizException {
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		StringBuilder strQur = new StringBuilder();
		strQur.append(" a0.ID_ENT = '").append(id_ent).append("' ")
				.append(" and a0.fg_pay = 'N' ")
				.append(" and a0.FG_CANC = 'N'");
		BlStIpDO[] blStIpDOArr = stRService.find(strQur.toString(), null,
				FBoolean.FALSE);
		if (ArrayUtil.isEmptyNoNull(blStIpDOArr)) {
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}
}
