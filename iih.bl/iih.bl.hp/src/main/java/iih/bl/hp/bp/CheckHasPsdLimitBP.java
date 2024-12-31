package iih.bl.hp.bp;

import iih.bd.base.validator.ParamValidator;
import iih.bd.pp.hp.d.BdHpLimitPsdDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 是否存在单方限制
 * @author yankan
 * @since 2017-09-05
 *
 */
public class CheckHasPsdLimitBP {
	/**
	 * 是否存在单方限制
	 * @param hpId 医保计划ID
	 * @param srvId 服务ID
	 * @return FBoolean
	 * @throws BizException
	 * @author yankan
	 */
	public FBoolean exec(String hpId,String srvId) throws BizException{
		//参数校验
		ParamValidator.validateNotNull("医保计划ID", hpId);
		ParamValidator.validateNotNull("服务ID", srvId);
		
		boolean isExist = this.isExistLimitPsn(hpId, srvId);
		return new FBoolean(isExist);		
	}
	/**
	 * 是否存在单方限制
	 * @param hpId 医保计划ID
	 * @param srvId 医疗服务ID
	 * @return
	 * @throws BizException
	 */
	private boolean isExistLimitPsn(String hpId,String srvId) throws BizException{
		String whereStr = "ID_HP=? AND ID_SRV=?";
		SqlParam param = new SqlParam();
		param.addParam(hpId);
		param.addParam(srvId);
		
		boolean isExist = new DAFacade().isExist(BdHpLimitPsdDO.class, whereStr, param);
		return isExist;
	}
}
