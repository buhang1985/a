package iih.bl.pay.s.provide.mbh;

import iih.bl.pay.dto.mb.prepayrcd.d.BlPrepayIpRecordDTO;
import iih.bl.pay.s.provide.mbh.qry.GetIpPrepayRecordQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 查询患者住院预交金记录
 * @author ly 2018/08/09
 *
 */
public class BlIpGetPrepayRecordBP {

	/**
	 * 查询患者住院预交金记录
	 * @param entId 就诊id
	 * @return 预交金冲退记录
	 * @throws BizException
	 */
	public BlPrepayIpRecordDTO[] exec(String entId) throws BizException {
		
		if(StringUtil.isEmpty(entId))
			return null;
		
		GetIpPrepayRecordQry qry = new GetIpPrepayRecordQry(entId);
		BlPrepayIpRecordDTO[] datas = (BlPrepayIpRecordDTO[]) AppFwUtil.
				getDORstWithDao(qry, BlPrepayIpRecordDTO.class);
		return datas;
	}
}
