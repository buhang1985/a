package iih.mi.mc.s.ctrlcore.rule;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.mi.mc.mimctacticsrule.d.MiMcTacticsRuleDO;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医保计划下就诊类型对应的规则所包含的策略
 * @author LIM
 * @since 2019-10-17
 */
public class MiMcCheckRule {

	/**
	 * 获取医保规则下的医保策略
	 * 
	 * @param id_hp 医保id
	 * @param code_entp 就诊类型
	 * @param hptacticsType 策略类型
	 * @return HashMap<String, String> 医保策略id,控制类型
	 * @throws BizException
	 */
	public HashMap<String, String> getCheckRule(String id_hp, String code_entp, String hptacticsType) throws BizException {
		HashMap<String, String> ruleMap = new HashMap<String, String>();
		//1.参数校验
		FBoolean bValid=validData(id_hp,code_entp,hptacticsType);
		if(FBoolean.FALSE.equals(bValid))
			return null;
		//2.获取规则对应的策略
		List<MiMcTacticsRuleDO> ruleList = this.GetTacticsRule(id_hp,code_entp,hptacticsType);
		if (!ListUtil.isEmpty(ruleList)) {
			for (MiMcTacticsRuleDO ruleDO : ruleList) {
				if (!ruleMap.containsKey(ruleDO.getId_hptactics()))
					ruleMap.put(ruleDO.getId_hptactics(), ruleDO.getEu_ctrltp());
			}
		}
		return ruleMap;
	}

	/**
	 * 
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<MiMcTacticsRuleDO> GetTacticsRule(String id_hp, String code_entp, String hptacticsType) throws BizException {
		String qrySql = this.getQrySql(code_entp);
		SqlParam param = new SqlParam();
		param.addParam(id_hp);
		param.addParam(AppUtils.getServerDateTime());
		param.addParam(hptacticsType);
		List<MiMcTacticsRuleDO> ruleList = (List<MiMcTacticsRuleDO>) new DAFacade().execQuery(qrySql, param,
				new BeanListHandler(MiMcTacticsRuleDO.class));
		return ruleList;
	}

	/**
	 * 参数校验
	 * @param id_hp
	 * @param code_entp
	 * @param hptacticsType
	 * @return
	 */
	private FBoolean validData(String id_hp, String code_entp, String hptacticsType){
		if(StringUtil.isEmpty(id_hp)){
			return FBoolean.FALSE;
		}
		if(StringUtil.isEmpty(code_entp)){
			return FBoolean.FALSE;
		}
		if(StringUtil.isEmpty(hptacticsType)){
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}
	/**
	 * 组织查询语句
	 * @return
	 */
	private String getQrySql(String code_entp) {
		StringBuilder sb = new StringBuilder();
		sb.append("select rule.id_hptactics,rule.eu_ctrltp ");
		sb.append(" from mi_mc_tactics_rule rule ");
		sb.append(" inner join mi_mc_tactics tactics on rule.id_hptactics=tactics.id_hptactics");
		sb.append(" where ");
		sb.append(" rule.id_hp=? and rule.fg_active='Y' ");
		sb.append(" and ? between rule.dt_b and rule.dt_e ");
		sb.append(" and tactics.id_hptacticstp=? ");
		sb.append(getWhereStr(code_entp));
		return sb.toString();
	}

	/**
	 * 根据就诊类型组织where条件
	 * @return
	 */
	private String getWhereStr(String code_entp) {
		String sWhere = "";
		switch (code_entp) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:// 门诊
			sWhere = "fg_user_op";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:// 急诊流水
			sWhere = "fg_user_er";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:// 急诊抢救
			sWhere = "fg_user_er1";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:// 急诊留观
			sWhere = "fg_user_er2";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:// 住院
			sWhere = "fg_entp_ip";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:// 家庭病床
			sWhere = "fg_entp_fm";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:// 体检
			sWhere = "fg_entp_pe";
			break;
		}
		return !StringUtil.isEmpty(sWhere)? " and rule." + sWhere + "='Y'":" and 1=2 ";
	}
}
