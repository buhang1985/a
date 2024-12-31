package iih.bd.pp.hp.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
 * @author yankan,lipengying
 *
 */
public class CheckIsSelfPaidDiBP {
	/**
	 * 是否自费诊断
	 * @param hpId 医保计划ID
	 * @param entpCode 就诊类型编码
	 * @param diIds 诊断ID集合
	 * @return map，【key: 诊断ID，value: FBoolean】
	 * @throws BizException
	 * @author yankan,lipengying
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String,FBoolean> exec(String hpId,String entpCode,String[] diIds) throws BizException{
		//根据条件从BD_HP_DI_EXPENSE_SELF查询结果，如果存在则是自费诊断，否则不是
		String strfg = "";
		Map dimap = new HashMap<String,FBoolean>();
		
		for(String str_Id_di:diIds)
		{
		  dimap.put(str_Id_di, FBoolean.FALSE)	;
		}
		//1.住院就诊类型
		if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(entpCode))
		{
			strfg = " and  diself.fg_entp_ip = 'Y' ";
		}
		//门诊
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(entpCode))
		{
			strfg = " and  diself.fg_entp_op = 'Y' ";
		}
		//体检
		if(IBdFcDictCodeConst.ID_CODE_ENTP_PE.equals(entpCode))
		{
			strfg = " and  diself.fg_entp_pe = 'Y' ";
		}
		//家庭病床
		if(IBdFcDictCodeConst.ID_CODE_ENTP_FA.equals(entpCode))
		{
			strfg = " and  diself.fg_entp_fm = 'Y' ";
		}
		//急诊流水
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(entpCode))
		{
			strfg = " and  diself.fg_entp_er = 'Y' ";
		}
		//急诊抢救
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(entpCode))
		{
			strfg = " and  diself.fg_use_er1 = 'Y' ";
		}
		//急诊留观
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(entpCode))
		{
			strfg = " and  diself.fg_use_er2 = 'Y' ";
		}
		for(String strId_di:diIds)
		{
			String buff = "select  diself.id_didef,diself.id_hp  from  bd_hp_di_expense_self diself where diself.id_hp='" + hpId + "' and diself.id_didef='"+strId_di+"' " +strfg;
			DAFacade cade = new DAFacade();
			List<BdHpDiExpenseSelfDO> diDOLst = (List<BdHpDiExpenseSelfDO>) cade.execQuery(buff, new BeanListHandler(BdHpDiExpenseSelfDO.class));
			if (diDOLst != null && diDOLst.size() > 0)
			{
				if(dimap.containsKey(strId_di))
				{
					dimap.remove(strId_di);
					dimap.put(strId_di, FBoolean.TRUE)	;
				}
			}
		}
		
		return dimap;
	}
}
