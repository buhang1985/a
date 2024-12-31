package iih.bl.hp.bp;

import iih.bl.hp.bp.Qry.CheckIsHpBlackPatByPatIdQry;
import iih.bl.hp.bp.Qry.CheckIsHpBlackPatQry;
import iih.bl.hp.hppatblacklist.d.HpPatBlackListDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 是否医保黑名单患者
 * @author 
 *
 */
public class CheckIsHpBlackPatByPatIdBP {
	/**
	 * 是否医保黑名单患者
	 * @param hpId 医保计划
	 * @param patId 患者ID
	 * @return FBoolean
	 * @throws BizException
	 */
	public FBoolean exec(String hpId,String patId) throws BizException{
		//查询条件所对应的黑名单信息
		HpPatBlackListDO[] hpPatBlackListDOs = (HpPatBlackListDO[])AppFwUtil.getDORstWithDao(new CheckIsHpBlackPatByPatIdQry(hpId,patId), HpPatBlackListDO.class);
		if(hpPatBlackListDOs==null || hpPatBlackListDOs.length==0){
			return FBoolean.FALSE;
		}else{
			return FBoolean.TRUE;
		}
	}
}
