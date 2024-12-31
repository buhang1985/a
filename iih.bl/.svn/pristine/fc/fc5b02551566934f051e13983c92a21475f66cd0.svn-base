package iih.bl.cg.s.bp.ip;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.cg.dto.addfee.d.BlCgAddFeeQryCondDTO;
import iih.bl.cg.dto.addfee.d.BlCgAddFeeQryDTO;
import iih.bl.cg.s.bp.ip.qry.BlIpAddFeeQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 住院补费项目查询
 * @author ly 2018/05/11
 *
 */
public class BlIpGetAddFeeBP {

	/**
	 * 住院补费项目查询
	 * @param cond 查询条件
	 * @return
	 * @throws BizException
	 */
	public BlCgAddFeeQryDTO[] exec(BlCgAddFeeQryCondDTO cond)throws BizException{
		
		if(cond == null){
			throw new ArgumentNullException("住院补费项目查询","查询条件");
		}
		
		if(cond.getFg_containrefund() == null){
			cond.setFg_containrefund(FBoolean.FALSE);
		}
		
		BlIpAddFeeQry qry = new BlIpAddFeeQry(cond);
	    BlCgAddFeeQryDTO[] dtos = (BlCgAddFeeQryDTO[])AppFwUtil.getDORstWithDao(
	    		qry, BlCgAddFeeQryDTO.class);
	    return dtos;
	}
}
