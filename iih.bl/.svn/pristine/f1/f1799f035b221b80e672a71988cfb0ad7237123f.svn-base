package iih.bl.cg.bp;

import iih.bl.cg.bp.qry.GetPayItmListByCgIdQry;
import iih.bl.cg.dto.d.OpPayItmDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取收付款明细集合
 * @author yankan
 * @author yanglu
 *
 */
public class GetPayItmListByCgIdBP {
	/**
	 * 获取收付款明细集合
	 * @param cgId
	 * @return
	 * @throws BizException
	 */
	public OpPayItmDTO[] exec(String cgId) throws BizException{
		OpPayItmDTO[] dTOs = (OpPayItmDTO[]) AppFwUtil.getDORstWithDao(new GetPayItmListByCgIdQry(cgId), OpPayItmDTO.class);
		return dTOs;
	}
}
