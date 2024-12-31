package iih.bl.hp.bp;

import iih.bl.hp.bp.Qry.CheckIsHpBlackPatQry;
import iih.bl.hp.dto.d.DiDependDTO;
import iih.bl.hp.hppatblacklist.d.HpPatBlackListDO;
import iih.bl.hp.viewmziihypshare.d.ViewMzIihYpShareDTO;

import java.util.List;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 是否医保黑名单患者
 * @author 
 *
 */
public class CheckIsHpBlackPatBP {
	/**
	 * 是否医保黑名单患者
	 * @param hpId 医保计划
	 * @param insurNo 医保卡号
	 * @return FBoolean
	 * @throws BizException
	 */
	public FBoolean exec(String hpId,String insurNo) throws BizException{
		//查询条件所对应的黑名单信息
		HpPatBlackListDO[] hpPatBlackListDOs = (HpPatBlackListDO[])AppFwUtil.getDORstWithDao(new CheckIsHpBlackPatQry(hpId,insurNo), HpPatBlackListDO.class);
		if(hpPatBlackListDOs==null || hpPatBlackListDOs.length==0){
			return FBoolean.FALSE;
		}else{
			return FBoolean.TRUE;
		}
		
		
	}
	
}
