package iih.bl.pay.s.bp.op;

import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import iih.bl.pay.s.bp.op.qry.CardDepositRecordQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 查询已缴费卡押金记录(用于退卡押金)
 * @author ly 2018/05/21
 *
 */
public class GetCardDepositRecordBP {

	/**
	 * 查询已缴费卡押金记录
	 * @param patId 患者id
	 * @param patCardId 患者卡id
	 * @return
	 * @throws BizException
	 */
	public BlPrepayDTO exec(String patId, String patCardId) throws BizException{
		
		if(StringUtil.isEmpty(patId) || StringUtil.isEmpty(patCardId))
			return null;
		

		BlPrepayDTO[] dtos = (BlPrepayDTO[])AppFwUtil.getDORstWithDao(
				new CardDepositRecordQry(patId, patCardId), BlPrepayDTO.class);
		
		if(ArrayUtil.isEmpty(dtos))
			return null;
		
		return dtos[0];
	}
}
