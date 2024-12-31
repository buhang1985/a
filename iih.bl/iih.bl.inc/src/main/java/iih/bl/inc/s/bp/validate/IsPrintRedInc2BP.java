package iih.bl.inc.s.bp.validate;

import iih.bd.pp.hp.d.HPDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 是否打印红冲发票
 * @author ly 2018/12/13
 *
 */
public class IsPrintRedInc2BP {
	
	/**
	 * 是否打印红冲发票
	 * @param hpId 医保产品id
	 * @param fgPrintInc 是否打印发票
	 * @return 判断结果
	 * @throws BizException
	 */
	public FBoolean exec(String hpId, FBoolean fgEnt) throws BizException{
		
		if(StringUtil.isEmpty(hpId))
			return FBoolean.FALSE;
		
		DAFacade daf = new DAFacade();
		HPDO hpDO = (HPDO) daf.findByPK(HPDO.class, hpId, new String[] { HPDO.FG_SABINC, HPDO.FG_SABINC_ENT});
		if(hpDO == null)
			return FBoolean.FALSE;
		
		if(FBoolean.TRUE.equals(fgEnt)){
			if(FBoolean.TRUE.equals(hpDO.getFg_sabinc_ent())){
				return FBoolean.TRUE;
			}
		}else if (FBoolean.TRUE.equals(hpDO.getFg_sabinc())){
			return FBoolean.TRUE;
		}
		
		return FBoolean.FALSE;
	}
}
