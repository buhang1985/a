package iih.en.pv.s.bp.op;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 匹配就诊的Vip类型公共BP
 * 
 * @author zhengcm
 * @date 2017-04-20 13:40:39
 *
 */
public class MatchGcVipTpBP {

	/**
	 * 匹配价格分类
	 *
	 * @param entIds 就诊ID数组
	 * @return 价格分类匹配Map
	 * @throws BizException
	 * @author zhengcm
	 */
	public Map<String, Boolean> matchPrica(String[] entIds) throws BizException {

		// 初始化Map
		Map<String, Boolean> map = this.initMatchMap(entIds);

		// 获取绿色通道支持的患者价格分类参数
		String pricaIds = EnParamUtils.getEnGcvipPriccaIds();
		if (EnValidator.isEmpty(pricaIds)) {
			return map;
		}
		// 获取就诊DO
		PatiVisitDO[] entDOs = new PvEP().getPvByIds(entIds);
		if (EnValidator.isEmpty(entDOs)) {
			return map;
		}
		for (PatiVisitDO entDO : entDOs) {
			boolean isMatch = false;
			if (null != entDO && !EnValidator.isEmpty(entDO.getId_pripat())) {
				if (pricaIds.contains(entDO.getId_pripat())) {
					isMatch = true;
				}
			}
			map.put(entDO.getId_ent(), isMatch);
		}
		return map;
	}

	/**
	 * 
	 * 匹配排班服务
	 * 
	 * @param entIds 就诊ID数组
	 * @return 排班服务匹配Map
	 * @throws BizException
	 * @author zhengcm
	 */
	public Map<String, Boolean> matchScsrv(String[] entIds) throws BizException {
		// 初始化Map
		Map<String, Boolean> map = this.initMatchMap(entIds);

		// 获取绿色通道支持的排班服务
		String scsrvIds = EnParamUtils.getEnGcvipScsrvIds();
		// 如果为空，无需查询OP
		if (EnValidator.isEmpty(scsrvIds)) {
			return map;
		}
		// 获取就诊OpDO
		OutpatientDO[] opDOs = new OpEP().getOpByEntIds(entIds);
		if (EnValidator.isEmpty(opDOs)) {
			return map;
		}
		for (OutpatientDO opDO : opDOs) {
			boolean isMatch = false;
			if (null != opDO && !EnValidator.isEmpty(opDO.getId_scsrv())) {
				if (scsrvIds.contains(opDO.getId_scsrv())) {
					isMatch = true;
				}
			}
			map.put(opDO.getId_ent(), isMatch);
		}
		return map;
	}
	
	/**
	 * 匹配科室或病区
	 *
	 * @param entIds 就诊ID数组
	 * @return 价格分类匹配Map
	 * @throws BizException
	 * @author liubin
	 */
	public Map<String, Boolean> matchDept(String[] entIds) throws BizException {

		// 初始化Map
		Map<String, Boolean> map = this.initMatchMap(entIds);

		// 获取VIP科室或病区
		String depIds = EnParamUtils.getEnGcvipDepIds();
		if (StringUtil.isEmptyWithTrim(depIds)) {
			return map;
		}
		@SuppressWarnings("unchecked")
		List<PatiVisitDO> entDOs = (List<PatiVisitDO>) new DAFacade().findByPKs(PatiVisitDO.class, entIds, new String[]{PatiVisitDO.ID_ENT, PatiVisitDO.ID_DEP_PHY, PatiVisitDO.ID_DEP_NUR});
		// 获取就诊DO
		if (ListUtil.isEmpty(entDOs)) {
			return map;
		}
		for (PatiVisitDO entDO : entDOs) {
			boolean isMatch = false;
			if (!StringUtil.isEmptyWithTrim(entDO.getId_dep_phy())) {
				if (depIds.contains(entDO.getId_dep_phy())) {
					isMatch = true;
				}
			}
			if (!StringUtil.isEmptyWithTrim(entDO.getId_dep_nur())) {
				if (depIds.contains(entDO.getId_dep_nur())) {
					isMatch = true;
				}
			}
			map.put(entDO.getId_ent(), isMatch);
		}
		return map;
	}


	/**
	 * 匹配患者标签
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public Map<String, Boolean> matchPatTag(String[] entIds) throws BizException {
		// 初始化Map
		Map<String, Boolean> map = this.initMatchMap(entIds);
		StringBuilder sb = new  StringBuilder();
		SqlParam sp = new SqlParam();
		
		sb.append(" select  ent.id_ent ");
		sb.append(" from  en_ent ent ");
		sb.append(" inner join pi_pat_tag tag  ");
		sb.append(" on ent.id_pat = tag.id_pat ");
		sb.append(" where tag.sd_pattagtp =? ");
		sb.append(" and ").append(EnSqlUtils.getInSqlByIds("ent.id_ent", entIds));
		sp.addParam(IBdFcDictCodeConst.SD_PATTAG_VIP);
		List<String> list = (List<String>) new DAFacade().execQuery(sb.toString(), sp,new ColumnListHandler());
		for (String entId : entIds) {
			boolean isMatch = false;
			if (!EnValidator.isEmpty(entId) &&!EnValidator.isEmpty(list)&& list.contains(entId)) {				
					isMatch = true;
			}
			map.put(entId, isMatch);
		}
		
		return map;
	}
	
	/**
	 * 初始化匹配Map
	 *
	 * @param entIds
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, Boolean> initMatchMap(String[] entIds) throws BizException {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (String entId : entIds) {
			map.put(entId, false);
		}
		return map;
	}
	
	

}
