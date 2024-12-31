package iih.mi.mc.s.ctrlcore.mimcdiscopecheck.rule;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.mi.constant.IMiMcCheckConst;
import iih.mi.mc.dto.mimcdidependrule.d.MiMcDiDependOutParamDTO;
import iih.mi.mc.s.ctrlcore.rule.MiMcCheckRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 诊断范围判断
 * 
 * @author LIM
 * @since 2019-10-23
 */
public class MiMcDiScopeCheckRule  extends MiMcCheckRule{
	/**
	 * 诊断范围判断
	 * @param hpId 医保id
	 * @param entpCode 就诊code
	 * @param diIds 诊断id集合
	 * @return map:【key: 诊断ID，value: FBoolean】
	 * @throws BizException
	 */
	public FMap exec(String hpId, String entpCode, String[] diIds) throws BizException {
		FMap dimap = new FMap();
		//1.获取医保规则所对应策略
		HashMap<String,String> ruleMap=this.getCheckRule(hpId, entpCode, IMiMcCheckConst.ID_MIMC_TACTICS_DISCOPE);
		if(ruleMap==null ||!ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_DISCOPE_DISCOPE)){
			return dimap;
		}
		//2.先设置默认值
		for (String str_Id_di : diIds) {
			dimap.put(str_Id_di, FBoolean.FALSE);
		}
		//3.获取自费诊断信息
		List<String> diDOLst = this.getDiSelfList(hpId, entpCode, diIds);
		if (!ListUtil.isEmpty(diDOLst)) {
			for (String strId_di : diDOLst) {
				if (dimap.containsKey(strId_di)) {
					dimap.put(strId_di, FBoolean.TRUE);
				}
			}
		}
		return dimap;
	}

	/**
	 * 查询自费诊断信息
	 * 
	 * @param hpId
	 * @param entpCode
	 * @param diIds
	 * @return
	 * @throws DAException
	 */
	private List<String> getDiSelfList(String hpId, String entpCode, String[] diIds) throws DAException {
		String sql = this.getSql(entpCode, diIds);
		SqlParam param = new SqlParam();
		param.addParam(hpId);
		@SuppressWarnings("unchecked")
		List<String> diSelfList = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		return diSelfList;
	}

	/**
	 * 组织sql查询语句
	 * 
	 * @param entpCode
	 * @return
	 */
	private String getSql(String entpCode, String[] diIds) {
		StringBuilder sb = new StringBuilder();
		sb.append("select");
		sb.append(" diself.id_didef,diself.id_hp");
		sb.append(" from bd_hp_di_expense_self diself");
		sb.append(" where diself.id_hp=? ");
		sb.append(this.getWhere(entpCode));
		sb.append(SqlUtils.getInSqlByIds(" and diself.id_didef", diIds));
		return sb.toString();
	}

	/**
	 * 组织where条件
	 * 
	 * @param entpCode
	 *            就诊类型
	 * @return
	 */
	private String getWhere(String entpCode) {
		String strfg = "";
		// 1.住院就诊类型
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(entpCode)) {
			strfg = " and  diself.fg_entp_ip = 'Y' ";
		}
		// 门诊
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(entpCode)) {
			strfg = " and  diself.fg_entp_op = 'Y' ";
		}
		// 急诊流水
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(entpCode)) {
			strfg = " and  diself.fg_entp_er = 'Y' ";
		}
		// 体检
		if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(entpCode)) {
			strfg = " and  diself.fg_entp_pe = 'Y' ";
		}
		// 家庭病床
		if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(entpCode)) {
			strfg = " and  diself.fg_entp_fm = 'Y' ";
		}
		// 急诊抢救
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(entpCode)) {
			strfg = " and  diself.fg_use_er1 = 'Y' ";
		}
		// 急诊留观
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(entpCode)) {
			strfg = " and  diself.fg_use_er2 = 'Y' ";
		}
		return strfg;
	}
}
