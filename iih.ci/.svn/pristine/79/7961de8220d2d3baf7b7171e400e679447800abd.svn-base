package iih.ci.ord.s.bp.ciprn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.ems.d.AddMinusDirect;
import iih.bd.srv.ems.d.EmsPrnTmplDO;
import iih.bd.srv.ems.d.EmsPrnTmplRelSrvDO;
import iih.bd.srv.ems.d.EmsprntmplAggDO;
import iih.bd.srv.ems.i.IEmsprntmplRService;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiAppRisSheetOrDO;
import iih.ci.ord.app.d.CiapprissheetAggDO;
import iih.ci.ord.cfg.cirulecfg.d.RuleCheckPoint;
import iih.ci.ord.cfg.cirulecfg.d.RuleType;
import iih.ci.ord.cfg.cirulecfg.d.RuleUseScope;
import iih.ci.ord.cfg.dto.ris.d.RisDataMergeDTO;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.cfg.rulecfg.meta.RuleCfgParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.bp.cfg.rulecfg.AbstractRuleExecutor;
import iih.ci.ord.s.bp.cfg.rulecfg.RuleCfgChainFacory;
import iih.ci.ord.s.bp.orsms.ris.mergesheet.RisMergeSheetBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 保存检查打印数据
 * @author YANG
 * 
 *
 */

public class CiprnSaveAppRisDataBP {

	/**
	 * 保存检查打印数据
	 * @param ciors 医嘱集合
	 * @param session
	 * @return
	 * @throws BizException
	 */
	public List<CiOrderDO> exec(CiEnContextDTO ctx , CiOrderDO[] ciors, CiOrSessionDO session) throws BizException {
		
		if (ciors == null || ciors.length <= 0)
			return null;

		// 检查的医嘱集合
		List<CiOrderDO> ciOrdList = new ArrayList<CiOrderDO>();

		for (CiOrderDO cior : ciors) {
			if (!StringUtils.isNullOrEmpty(cior.getSd_srvtp()) 
					&& cior.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS) 
					&& !cior.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
				ciOrdList.add(cior);
			}
		}
		
		if(ciOrdList.size() ==0 ){
			return null;
		}
				
		// 获取检查分单的数据集合
		List<RisDataMergeDTO> risDataMergeList = this.getRisDataMergeList(ctx, ciOrdList);
		
		// 构造map结构数据用于执行规则，先保存一个默认key值
		Map<String, List<RisDataMergeDTO>> risDataMergeMap = new HashMap<String, List<RisDataMergeDTO>>();
		risDataMergeMap.put(RuleType.MERGE_RIS, risDataMergeList);

		RuleCfgParamDTO ruleCfgParam = new RuleCfgParamDTO();
		
		ruleCfgParam.setCode_entp(ctx.getCode_entp());
		ruleCfgParam.setCheck_point(RuleCheckPoint.SIGN);
		ruleCfgParam.setRule_type(RuleType.MERGE_RIS);
		
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ctx.getCode_entp())
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(ctx.getCode_entp())
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(ctx.getCode_entp())){
			ruleCfgParam.setUse_scope(RuleUseScope.RULE_USE_OP);
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ctx.getCode_entp())
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(ctx.getCode_entp())){
			ruleCfgParam.setUse_scope(RuleUseScope.RULE_USE_IP);
		}
		Long startTIme = System.currentTimeMillis();
		RuleCfgChainFacory<Map<String, List<RisDataMergeDTO>>> ruleCfgChainFacory = new RuleCfgChainFacory<Map<String, List<RisDataMergeDTO>>>();
		AbstractRuleExecutor<Map<String, List<RisDataMergeDTO>>> mergeRisExecutor = ruleCfgChainFacory.getRuleChain(ruleCfgParam);

		risDataMergeMap = mergeRisExecutor.startExecuteRule(risDataMergeMap);
		CiOrdUtils.getlogger()
		.info("CiLisOrSmsHandlerBP 检查生成图文报告, 合单耗时 .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		startTIme = System.currentTimeMillis();
		CiapprissheetAggDO[] risSheetAggs = this.saveCiAppRisSheetData(ctx, risDataMergeMap, ciOrdList,
				session == null ? "" : session.getId_ciorsession());
		CiOrdUtils.getlogger()
		.info("CiLisOrSmsHandlerBP 检查生成图文报告, 保存检查打印单耗时 .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		startTIme = System.currentTimeMillis();
		//执行图文报告生成逻辑
		RisMergeSheetBP mergeSheet = new RisMergeSheetBP();
		List<CiOrderDO> newOrders = mergeSheet.exec(ctx, risSheetAggs, ciOrdList);
		CiOrdUtils.getlogger()
		.info("CiLisOrSmsHandlerBP 检查生成图文报告, 生成图文报告单耗时 .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		return newOrders;
	}
	
	/**
	 * 保存检查医嘱打印单数据
	 * @param risDtaMergeMap 检查医嘱分组结果
	 * @param ciOrderList 检查一致
	 * @param session 
	 * @throws BizException 
	 */
	private CiapprissheetAggDO[] saveCiAppRisSheetData(CiEnContextDTO ctx, Map<String, List<RisDataMergeDTO>> risDataMergeMap,
			List<CiOrderDO> ciOrderList, String id_ciorsession) throws BizException {
		
		// 医嘱map集合，key为id_or
		Map<String,CiOrderDO> ciOrderMap = new HashMap<String,CiOrderDO>();
		// 检查申请单map集合，key为id_or
		Map<String, OrdApObsDO> ordApObsMap = new HashMap<String, OrdApObsDO>();
		// 医嘱id串，
		StringBuffer idOrBuffer = new StringBuffer();
		
		// 构造医嘱map集合
		for(CiOrderDO ciOrder : ciOrderList){
			idOrBuffer.append(","+ciOrder.getId_or());
			ciOrderMap.put(ciOrder.getId_or(), ciOrder);
		}
		
		// 构造检查申请单map集合
		OrdApObsDO[] ordApObsDOs = CiprnUtils.GetOrdApObsDOs(idOrBuffer.substring(1));
		for (OrdApObsDO ordApObsDO : ordApObsDOs) {
			ordApObsMap.put(ordApObsDO.getId_or(), ordApObsDO);
		}
		
		// 根据医嘱id获取医嘱临床项目价格集合
		Map<String,FDouble> ordPriceMap = CiprnUtils.getOrdPriceMap(idOrBuffer.substring(1));
		
		List<CiapprissheetAggDO> risSheetAggList = new ArrayList<CiapprissheetAggDO>();
		
		CiAppRisSheetDO ciAppRisSheet = new CiAppRisSheetDO();
		ciAppRisSheet.setId_en(ctx.getId_en());
		// 打印单号
		String[] code_apps = CiOrdUtils.generateNormNOs(risDataMergeMap.size(), ciAppRisSheet);		

		int i=0;
		for(String key : risDataMergeMap.keySet()){
			
			List<RisDataMergeDTO> risDataMergeList = risDataMergeMap.get(key);
			
			// 医嘱按医嘱号排序
			Collections.sort(risDataMergeList, new Comparator<RisDataMergeDTO>() {
				@Override
				public int compare(RisDataMergeDTO item1, RisDataMergeDTO item2) {
					
					if(item1.getSortno() == null ){
						return 1;
					}
					if(item2.getSortno() == null ){
						return 1;
					}
					return item2.getSortno() - item1.getSortno();
				}
			});
			
			CiapprissheetAggDO risSheetAgg = this.getRisSheetAgg(ctx,code_apps[i], risDataMergeList, ciOrderMap, ordApObsMap, ordPriceMap, id_ciorsession);
			i++;
			
			risSheetAggList.add(risSheetAgg);
		}
		
		return CiprnUtils.SaveCiAppRisSheetDOs(risSheetAggList.toArray(new CiapprissheetAggDO[risSheetAggList.size()]));
	}
	
	/**
	 * 构造检查打印单数据集合
	 * @param ctx 当前就诊环境
	 * @param code_app 打印申请单编码
	 * @param risDataMergeList 检查合单数据集合
	 * @param ciOrderMap 医嘱map集合 key: id_or; value:CiOrderDO
	 * @param ordApObsMap 检查申请单map集合 key: id_or value：OrdApObsDO
	 * @param id_ciorsession 对应 CiOrSessionDO中的id_ciorsession
	 * @return
	 * @throws BizException
	 */
	private CiapprissheetAggDO getRisSheetAgg(CiEnContextDTO ctx, String code_app, List<RisDataMergeDTO> risDataMergeList, Map<String, CiOrderDO> ciOrderMap,
			Map<String, OrdApObsDO> ordApObsMap,Map<String,FDouble> ordPriceMap, String id_ciorsession) throws BizException {
		
		// 检查打印单赋值，按符合规则的一组医嘱进行赋值，除服务名称，金额外，使用医嘱中排序号最大的一条进行赋值
		// 服务名称使用多条医嘱的name_or进行拼接，金额为多条医嘱的金额合计
		
		String id_or = risDataMergeList.get(0).getId_or();
		// 保留检查合单分组后的医嘱中，排序号最大的医嘱对象
		CiOrderDO ciOrder = ciOrderMap.get(id_or);
				
		// 根据明细获取名称串，总金额，加急标识
		StringBuffer nameOrBuffer = new StringBuffer();
		
		for(RisDataMergeDTO risDataMerge : risDataMergeList){
			
			CiOrderDO tempCiOrder = ciOrderMap.get(risDataMerge.getId_or());
			nameOrBuffer.append(","+tempCiOrder.getName_or());
		}
		
		// 获取检查打印单明细
		List<CiAppRisSheetOrDO> risSheetOrList = this.getCiAppRisSheetOrList(ctx, risDataMergeList, ciOrderMap,
				ordApObsMap, ordPriceMap);
		
		CiapprissheetAggDO risSheetAgg = new CiapprissheetAggDO();
		CiAppRisSheetDO risSheet = new CiAppRisSheetDO();
		
		risSheet.setId_grp(ctx.getId_grp());
		risSheet.setId_org(ctx.getId_org());
		
		risSheet.setId_pat(ctx.getId_pat());
		risSheet.setId_entp(ctx.getId_entp());		
		risSheet.setCode_entp(ctx.getCode_entp());
		risSheet.setId_en(ctx.getId_en());
		
		//risSheet.setFg_hp(ciOrder.getFg_orhp());
		risSheet.setFg_bb(ciOrder.getFg_bb());
		risSheet.setNo_bb(ciOrder.getNo_bb());
		
		risSheet.setFg_opspecial(CiprnUtils.GetFg_opspecial(ctx.getId_en())); // 门诊特需标识
		
		//risSheet.setId_or(ciOrder.getId_or());
		
		//risSheet.setId_orobs(ordApObs.getId_orobs());
		//risSheet.setId_srv(ciOrder.getId_srv());
		//risSheet.setFg_set(ciOrder.getFg_set());
		//risSheet.setNo_applyform(ordApObs.getNo_applyform());
		risSheet.setCode_app(code_app);
		risSheet.setName_app(nameOrBuffer.substring(1));
		//risSheet.setId_di(ordApObs.getId_di());
		//risSheet.setId_diitm(ordApObs.getId_diitm());
		//risSheet.setStr_id_diitm(ordApObs.getStr_id_diitm());
		//risSheet.setStr_code_di(ordApObs.getStr_code_di());
		//risSheet.setStr_name_di(ordApObs.getStr_name_di());
		//risSheet.setName_diag(ordApObs.getName_diag());
		
		//risSheet.setDt_plan(ordApObs.getDt_plan());
		//risSheet.setFg_urgent(fg_urgent); // 加急标识
		//risSheet.setId_org_app(ciOrder.getId_org_or());
		risSheet.setId_dep_app(Context.get().getDeptId());
		risSheet.setId_emp_app(Context.get().getStuffId());
		//risSheet.setDt_app(ciOrder.getDt_sign());
		risSheet.setId_dep_mp(ciOrder.getId_dep_mp());
		//risSheet.setBiopsy(ordApObs.getBiopsy());
		//risSheet.setDes_sympsign(ordApObs.getDes_sympsign());
		//risSheet.setClinicalzztz(ordApObs.getClinicalzztz());
		//risSheet.setAuximtexam(ordApObs.getAuximtexam());
		//risSheet.setPastillness(ordApObs.getPastillness());
		//risSheet.setId_pps(ordApObs.getId_pps());
		//risSheet.setSd_pps(ordApObs.getSd_pps());
		//risSheet.setDes_pps(ordApObs.getDes_pps());
//		risSheet.setId_body((ordApObs.getId_body()));
//		risSheet.setSd_body((ordApObs.getSd_body()));
//		risSheet.setId_pos((ordApObs.getId_pos()));
//		risSheet.setSd_pos((ordApObs.getSd_pos()));
//		risSheet.setFg_mp_bed((ordApObs.getFg_mp_bed()));
		//risSheet.setAnnouncements(ordApObs.getAnnouncements());
		
		// 如果是门急诊，判断是否为高端商保，高端商保需要设置高端商保信息串
		if(CiEnContextUtil.isHeComInsurPat(ctx.getId_hp(), ctx.getSd_hptp())){
			risSheet.setFg_hecominsur(FBoolean.TRUE);
			risSheet.setHecominsurinfo(ctx.getName_pat()+":"+CiOrdAppUtils.getServerDateTime());
		}else{
			risSheet.setFg_hecominsur(FBoolean.FALSE);
		}
		
		//risSheet.setFg_prepay(ciOrder.getFg_prepay());
		risSheet.setFg_vip(ciOrder.getFg_vip());
		risSheet.setFg_hpbirth(FBoolean.FALSE);
		//risSheet.setResearchinfo("");
		risSheet.setFg_blsettled(FBoolean.FALSE);
		//risSheet.setAmt_app(amt_app);// 多个检查单的合计金额
		risSheet.setFg_prn(FBoolean.FALSE);
		risSheet.setCnt_prn(0);
		risSheet.setId_session(id_ciorsession); // 医嘱签署的sessionId 对应 CiOrSessionDO中的id_ciorsession
//		risSheet.setDef1((ordApObs.getDef1()));
//		risSheet.setDef2((ordApObs.getDef2()));
//		risSheet.setDef3((ordApObs.getDef3()));
//		risSheet.setDef4((ordApObs.getDef4()));
//		risSheet.setDef5((ordApObs.getDef5()));
//		risSheet.setDef6((ordApObs.getDef6()));
//		risSheet.setDef7((ordApObs.getDef7()));
//		risSheet.setDef8((ordApObs.getDef8()));
//		risSheet.setDef9((ordApObs.getDef9()));
//		risSheet.setDef10((ordApObs.getDef10()));
//		risSheet.setDef11((ordApObs.getDef11()));
//		risSheet.setDef12((ordApObs.getDef12()));
//		risSheet.setDef13((ordApObs.getDef13()));
//		risSheet.setDef14((ordApObs.getDef14()));
//		risSheet.setDef15((ordApObs.getDef15()));
//		risSheet.setDef16((ordApObs.getDef16()));
//		risSheet.setDef17((ordApObs.getDef17()));
//		risSheet.setDef18((ordApObs.getDef18()));
//		risSheet.setDef19((ordApObs.getDef19()));
//		risSheet.setDef20((ordApObs.getDef20()));
//		risSheet.setDef21((ordApObs.getDef21()));
//		risSheet.setDef22((ordApObs.getDef22()));
//		risSheet.setDef23((ordApObs.getDef23()));
//		risSheet.setDef24((ordApObs.getDef24()));
//		risSheet.setDef25((ordApObs.getDef25()));
//		risSheet.setDef26((ordApObs.getDef26()));
//		risSheet.setDef27((ordApObs.getDef27()));
//		risSheet.setDef28((ordApObs.getDef28()));
//		risSheet.setDef29((ordApObs.getDef29()));
//		risSheet.setDef30((ordApObs.getDef30()));
//		risSheet.setDef31((ordApObs.getDef31()));
//		risSheet.setDef32((ordApObs.getDef32()));
//		risSheet.setDef33((ordApObs.getDef33()));
//		risSheet.setDef34((ordApObs.getDef34()));
//		risSheet.setDef35((ordApObs.getDef35()));
//		risSheet.setDef36((ordApObs.getDef36()));
//		risSheet.setDef37((ordApObs.getDef37()));
//		risSheet.setDef38((ordApObs.getDef38()));
//		risSheet.setDef39((ordApObs.getDef39()));
//		risSheet.setDef40((ordApObs.getDef40()));
//		risSheet.setDef41((ordApObs.getDef41()));
//		risSheet.setDef42((ordApObs.getDef42()));
//		risSheet.setDef43((ordApObs.getDef43()));
//		risSheet.setDef44((ordApObs.getDef44()));
//		risSheet.setDef45((ordApObs.getDef45()));
//		risSheet.setDef46((ordApObs.getDef46()));
//		risSheet.setDef47((ordApObs.getDef47()));
//		risSheet.setDef48((ordApObs.getDef48()));
//		risSheet.setDef49((ordApObs.getDef49()));
//		risSheet.setDef50((ordApObs.getDef50()));
		risSheet.setFg_specill(risDataMergeList.get(0).getFg_specill()); // 特殊病标识
		risSheet.setStatus(DOStatus.NEW);
		
		risSheetAgg.setParentDO(risSheet);
		risSheetAgg.setCiAppRisSheetOrDO(risSheetOrList.toArray(new CiAppRisSheetOrDO[risSheetOrList.size()]));
		return risSheetAgg;
	}
	
	
	private List<CiAppRisSheetOrDO> getCiAppRisSheetOrList(CiEnContextDTO ctx, List<RisDataMergeDTO> risDataMergeList, Map<String, CiOrderDO> ciOrderMap,
			Map<String, OrdApObsDO> ordApObsMap, Map<String,FDouble> ordPriceMap) throws BizException {
		
		// 检查打印单赋值，按符合规则的一组医嘱进行赋值，除服务名称，金额外，使用医嘱中排序号最大的一条进行赋值
		// 服务名称使用多条医嘱的name_or进行拼接，金额为多条医嘱的金额合计
		
		// 保留检查合单分组后的医嘱中，排序号最大的医嘱对象
		CiOrderDO ciOrder = null;
		// 保留检查合单分组后的医嘱中，排序号最大的医嘱对应的检查申请单
		OrdApObsDO ordApObs = null;
		
		List<CiAppRisSheetOrDO> risSheetOrList = new ArrayList<CiAppRisSheetOrDO>();
		
		for(RisDataMergeDTO risDataMerge : risDataMergeList){
			
			ciOrder = ciOrderMap.get(risDataMerge.getId_or()); 
			ordApObs = ordApObsMap.get(risDataMerge.getId_or());
			
			CiAppRisSheetOrDO risSheetOr = new CiAppRisSheetOrDO();
			
			risSheetOr.setId_grp(ciOrder.getId_grp()); // 所属组织
			risSheetOr.setId_org(ciOrder.getId_org()); // 所属集团
			
			risSheetOr.setId_or(risDataMerge.getId_or()); // 医嘱id
			risSheetOr.setName_or(ciOrder.getName_or()); // 医嘱名称
			
			risSheetOr.setId_srv(ciOrder.getId_srv()); // 服务ID
			risSheetOr.setId_orobs(ordApObs.getId_orobs()); // 检查申请单
			risSheetOr.setFg_set(ciOrder.getFg_set()); // 服务套标识
			
			risSheetOr.setId_org_app(ciOrder.getId_org_or()); // 申请机构
			risSheetOr.setId_dep_app(Context.get().getDeptId()); // 申请科室
			risSheetOr.setId_dep_mp(ciOrder.getId_dep_mp()); // 执行科室
			risSheetOr.setId_emp_app(Context.get().getStuffId()); // 申请医生
			
			risSheetOr.setFg_orhp(ciOrder.getFg_orhp()); // 临床项目医保标识
			risSheetOr.setFg_urgent(ordApObs.getFg_urgent()); // 加急标识
			risSheetOr.setFg_blsettled(FBoolean.FALSE); // 费用已结算标识
			risSheetOr.setOr_total_pri(ordPriceMap.get(risDataMerge.getId_or())); // 申请金额
			risSheetOr.setId_su_bl(ciOrder.getId_su_bl()); // 记账状态
			risSheetOr.setSd_su_bl(ciOrder.getSd_su_bl()); // 记账状态编码
			risSheetOr.setSortno(risDataMerge.getSortno()); // 医嘱排序号
			
			risSheetOr.setId_di(ordApObs.getId_di()); // 临床诊断
			risSheetOr.setName_diag(ordApObs.getName_diag()); // 诊断名称
			risSheetOr.setId_diitm(ordApObs.getId_diitm()); // 临床诊断子项
			risSheetOr.setStr_id_diitm(ordApObs.getStr_id_diitm()); // 临床诊断明细id拼接
			risSheetOr.setStr_code_di(ordApObs.getStr_code_di()); // 诊断编码拼接
			risSheetOr.setStr_name_di(ordApObs.getStr_name_di()); // 诊断名称拼接
			
			risSheetOr.setDt_plan(ordApObs.getDt_plan()); // 计划检查日期
			risSheetOr.setNo_applyform(ordApObs.getNo_applyform()); // 检查申请单号
			risSheetOr.setDt_app(CiOrdAppUtils.getServerDateTime()); // 申请时间
			
			risSheetOr.setResearchinfo("");
			risSheetOr.setBiopsy(ordApObs.getBiopsy()); //检查组织描述
			risSheetOr.setDes_sympsign(ordApObs.getDes_sympsign()); // 病情描述
			risSheetOr.setClinicalzztz(ordApObs.getClinicalzztz()); // 临床症状及体征
			risSheetOr.setAuximtexam(ordApObs.getAuximtexam()); // 其它检查所见
			risSheetOr.setPastillness(ordApObs.getPastillness()); // 既往病史
			risSheetOr.setAnnouncements(ordApObs.getAnnouncements()); // 注意事项
			
			risSheetOr.setId_pps(ordApObs.getId_pps()); // 检查目的
			risSheetOr.setSd_pps(ordApObs.getSd_pps()); // 检查目的编码
			risSheetOr.setDes_pps(ordApObs.getDes_pps()); // 检查目的描述
//			risSheetOr.setId_body((ordApObs.getId_body()));
//			risSheetOr.setSd_body((ordApObs.getSd_body()));
//			risSheetOr.setId_pos((ordApObs.getId_pos()));
//			risSheetOr.setSd_pos((ordApObs.getSd_pos()));
//			risSheetOr.setFg_mp_bed((ordApObs.getFg_mp_bed()));			
			risSheetOr.setName_body(ordApObs.getBiopsy());
			risSheetOr.setDef1((ordApObs.getDef1()));
			risSheetOr.setDef2((ordApObs.getDef2()));
			risSheetOr.setDef3((ordApObs.getDef3()));
			risSheetOr.setDef4((ordApObs.getDef4()));
			risSheetOr.setDef5((ordApObs.getDef5()));
			risSheetOr.setDef6((ordApObs.getDef6()));
			risSheetOr.setDef7((ordApObs.getDef7()));
			risSheetOr.setDef8((ordApObs.getDef8()));
			risSheetOr.setDef9((ordApObs.getDef9()));
			risSheetOr.setDef10((ordApObs.getDef10()));
			risSheetOr.setDef11((ordApObs.getDef11()));
			risSheetOr.setDef12((ordApObs.getDef12()));
			risSheetOr.setDef13((ordApObs.getDef13()));
			risSheetOr.setDef14((ordApObs.getDef14()));
			risSheetOr.setDef15((ordApObs.getDef15()));
			risSheetOr.setDef16((ordApObs.getDef16()));
			risSheetOr.setDef17((ordApObs.getDef17()));
			risSheetOr.setDef18((ordApObs.getDef18()));
			risSheetOr.setDef19((ordApObs.getDef19()));
			risSheetOr.setDef20((ordApObs.getDef20()));
			risSheetOr.setDef21((ordApObs.getDef21()));
			risSheetOr.setDef22((ordApObs.getDef22()));
			risSheetOr.setDef23((ordApObs.getDef23()));
			risSheetOr.setDef24((ordApObs.getDef24()));
			risSheetOr.setDef25((ordApObs.getDef25()));
			risSheetOr.setDef26((ordApObs.getDef26()));
			risSheetOr.setDef27((ordApObs.getDef27()));
			risSheetOr.setDef28((ordApObs.getDef28()));
			risSheetOr.setDef29((ordApObs.getDef29()));
			risSheetOr.setDef30((ordApObs.getDef30()));
			risSheetOr.setDef31((ordApObs.getDef31()));
			risSheetOr.setDef32((ordApObs.getDef32()));
			risSheetOr.setDef33((ordApObs.getDef33()));
			risSheetOr.setDef34((ordApObs.getDef34()));
			risSheetOr.setDef35((ordApObs.getDef35()));
			risSheetOr.setDef36((ordApObs.getDef36()));
			risSheetOr.setDef37((ordApObs.getDef37()));
			risSheetOr.setDef38((ordApObs.getDef38()));
			risSheetOr.setDef39((ordApObs.getDef39()));
			risSheetOr.setDef40((ordApObs.getDef40()));
			risSheetOr.setDef41((ordApObs.getDef41()));
			risSheetOr.setDef42((ordApObs.getDef42()));
			risSheetOr.setDef43((ordApObs.getDef43()));
			risSheetOr.setDef44((ordApObs.getDef44()));
			risSheetOr.setDef45((ordApObs.getDef45()));
			risSheetOr.setDef46((ordApObs.getDef46()));
			risSheetOr.setDef47((ordApObs.getDef47()));
			risSheetOr.setDef48((ordApObs.getDef48()));
			risSheetOr.setDef49((ordApObs.getDef49()));
			risSheetOr.setDef50((ordApObs.getDef50()));
			
			risSheetOr.setStatus(DOStatus.NEW);
			risSheetOrList.add(risSheetOr);
		}
		
		
		return risSheetOrList;
	}
	
	/**
	 * 获取检查分单规则数据
	 * @param ctx
	 * @param ciOrdList
	 * @return
	 * @throws BizException
	 */
	public List<RisDataMergeDTO> getRisDataMergeList(CiEnContextDTO ctx , List<CiOrderDO> ciOrdList) throws BizException{
		
		List<RisDataMergeDTO> risDataMergeList = new ArrayList<RisDataMergeDTO>();
		
		// 医嘱Id与服务idmap集合
		Map<String,String> orSrvMap = new HashMap<String,String>();
		for (CiOrderDO cior : ciOrdList) {

			orSrvMap.put(cior.getId_or(), cior.getId_srv());
		}
		
		// 获取医嘱id与打印模板匹配关系
		Map<String,String> prnTmplIdMap = this.getMatchPrnTmplIdMap(ctx,ciOrdList);
		// 获取医嘱id与检查属性表的检查分组属性map集合 key id_or,value ： 检查分组属性
		Map<String,String> obsGroupMap = this.getOrMatchObsgroup(ciOrdList);
		
		Map<String,FBoolean>  fgSpecillMap = this.getOrdFgSpecillMap(ciOrdList);

		// 将医嘱，打印模板id，检查属性表的分组属性 构造成分组的数据对象集合
		for(CiOrderDO cior : ciOrdList){
			
			RisDataMergeDTO risDataMerge = new RisDataMergeDTO();
			
			risDataMerge.setId_or(cior.getId_or());
			risDataMerge.setId_dep_mp(cior.getId_dep_mp());
			risDataMerge.setFg_orhp(cior.getFg_orhp());
			risDataMerge.setId_emsprntmpl(prnTmplIdMap.get(cior.getId_or()));
			risDataMerge.setObsgroup(obsGroupMap.get(cior.getId_or()));
			risDataMerge.setFg_urgent(cior.getFg_urgent());
			risDataMerge.setFg_specill(fgSpecillMap.get(cior.getId_or()));// 特殊病标识
			risDataMerge.setSortno(cior.getSortno());
			
			risDataMergeList.add(risDataMerge);
		}
		
		return risDataMergeList;
	}
	
	/**
	 * 根据医嘱对应的服务id获取检查属性表的分组属性集合
	 * @return key: id_or, value: 检查属性表的检查分组属性
	 * @throws BizException 
	 */
	private Map<String,String> getOrMatchObsgroup(List<CiOrderDO> ciOrdList) throws BizException{
		
		// 医嘱id与检查分组属性map 集合，key id_or ,value 通过id_srv获取对应的检查属性
		Map<String,String> ordObsGroupMap = new HashMap<String,String>();
		StringBuffer idSrvBuffer = new StringBuffer();
		
		for(CiOrderDO ciOrder : ciOrdList){
			idSrvBuffer.append(",'"+ciOrder.getId_srv()+"'");
		}
		
		String qrySql = "select id_srv,obsgroup from bd_srv_obs where id_srv in ("+idSrvBuffer.substring(1)+")";
		
		List<Map<String, Object>>  obsGroupMapList = CiOrdUtils.getRsMapList(qrySql);
		
		Map<String,String> obsGroupMap = new HashMap<String,String>();
		for(Map<String, Object> map : obsGroupMapList){
			String id_srv = map.get("id_srv").toString();
			String obsgroup = map.get("obsgroup") == null ? "": map.get("obsgroup").toString();
			obsGroupMap.put(id_srv, obsgroup);
		}
		
		for(CiOrderDO ciOrder : ciOrdList){
			
			String obsGroupStr = obsGroupMap.get(ciOrder.getId_srv());
			ordObsGroupMap.put(ciOrder.getId_or(), obsGroupStr);
		}
		
		return ordObsGroupMap;
	}
	
	/**
	 * 根据传入的医嘱集合，判断哪些子项
	 * 如果医嘱项目中有一条是特殊病，该医嘱为特殊病
	 * @param orderList
	 * @return Map<String,FBoolean> key：医嘱id value:是否为特殊病标识
	 * @throws DAException 
	 */
	private Map<String,FBoolean> getOrdFgSpecillMap(List<CiOrderDO> orderList) throws DAException{
		
		Map<String,FBoolean> ordFgSpecillMap = new HashMap<String,FBoolean>();

		StringBuffer idOrBuffer = new StringBuffer();
		for(CiOrderDO ciOrder : orderList){
			idOrBuffer.append(",'"+ciOrder.getId_or()+"'");
		}
		
		String sql = "select distinct id_or, fg_specill from ci_or_srv where fg_specill='Y' and id_or  in("+idOrBuffer.substring(1)+") ";
		List<Map<String, Object>> dataList = (List<Map<String, Object>>)new DAFacade().execQuery(sql, new MapListHandler());
		for(Map<String, Object> map: dataList){
			String id_or = map.get("id_or").toString();
			ordFgSpecillMap.put(id_or, FBoolean.TRUE);
		}
		
		for(CiOrderDO ciOrder :  orderList){
			if(!ordFgSpecillMap.containsKey(ciOrder.getId_or())){
				ordFgSpecillMap.put(ciOrder.getId_or(), FBoolean.FALSE);
			}
		}
		return ordFgSpecillMap;
	}
	
	/**
	 * 获取医嘱匹配的打印模板id集合
	 * @param ctx 当前就诊环境
	 * @param OrSrvMap 医嘱id与服务id的map集合 key 为id_or value 为id_srv
	 * @return 医嘱id与 打印模板id的map 集合  key 为id_or value 为id_emsprntmpl
	 * @throws BizException 
	 */
	private Map<String,String> getMatchPrnTmplIdMap(CiEnContextDTO ctx, List<CiOrderDO> ciOrdList) throws BizException{

		// 当前登录人
		String id_psndoc = ctx.getId_emp_or();
		// 当前登录人接诊科室
		String id_dep = ctx.getId_dep_en();
		
		Map<String,String> orPrnTmplMap = new HashMap<String,String>();
		
		StringBuffer idOrBuffer = new StringBuffer();
		for(CiOrderDO ciOrder : ciOrdList){
			idOrBuffer.append(",'"+ciOrder.getId_srv()+"'");
		}
		
		StringBuffer qryBuffer = new StringBuffer();
		FDateTime serverDataTime = CiOrdAppUtils.getServerDateTime();
		String fg_user = CiOrdUtils.getFgUseType("fg_entp_", ctx.getCode_entp());
		// 根据服务id查询匹配的打印单
		String sql1 = "select distinct A.id_emsprntmpl from bd_ems_prntmpl A , bd_ems_prntmpl_rel B "
				+ " where A.id_emsprntmpl = B.id_emsprntmpl and A.id_org='%s' and A.fg_active='Y' and (A.dt_effe is null or A.dt_effe<='%s') and (A.dt_disable is null or A.dt_disable>='%s') "
				+ " and B.id_srv in (%s) and eu_direct =1 and " + fg_user + " = 'Y'";
		sql1 = String.format(sql1, ctx.getId_org(),serverDataTime,serverDataTime,idOrBuffer.substring(1));
		// 根据服务类型查询匹配的打印单
		String sql2 = "select distinct A.id_emsprntmpl from bd_ems_prntmpl A , bd_ems_prntmpl_rel B "
				+ " where A.id_emsprntmpl = B.id_emsprntmpl and A.id_org='%s' and A.fg_active='Y' and (A.dt_effe is null or A.dt_effe<='%s') and (A.dt_disable is null or A.dt_disable>='%s') "
				+ " and B.sd_srvtp != '"
				+ IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI + "'  and eu_direct != -1 and " + fg_user + " = 'Y'";
		sql2 = String.format(sql2, ctx.getId_org(),serverDataTime,serverDataTime) + " and B.sd_srvtp like '"+IBdSrvDictCodeConst.SD_SRVTP_RIS+"%' ";

		qryBuffer.append(sql1).append(" union all ").append(sql2);
		
		IEmsprntmplRService  emsprntmplRService = (IEmsprntmplRService)ServiceFinder.find(IEmsprntmplRService.class);
		
		EmsprntmplAggDO[] prnTmplAggs = emsprntmplRService.find("id_emsprntmpl in ("+qryBuffer.toString()+")", null, FBoolean.FALSE);
		
		// 返回结果按使用范围的个人，科室，全院排序
		Arrays.sort(prnTmplAggs, new Comparator<EmsprntmplAggDO>() {
			@Override
			public int compare(EmsprntmplAggDO tmpl1, EmsprntmplAggDO tmpl2) {
				
				return tmpl2.getParentDO().getSd_srvorrt().compareTo(tmpl1.getParentDO().getSd_srvorrt());
			}
		});
		
		for(CiOrderDO ciOrder : ciOrdList){
			
			for(EmsprntmplAggDO prnTmplAgg : prnTmplAggs ){
				
				// 医嘱id,用于保存匹配医疗单的医嘱id
				String tempIdOr = null;
				EmsPrnTmplDO prnTmpl = prnTmplAgg.getParentDO();

				if(IBdSrvDictCodeConst.SD_OWTP_PERSONAL.equals(prnTmpl.getSd_srvorrt()) && id_psndoc.equals(prnTmpl.getId_dept())){				
				// 个人 模板中Id_dept 存储的人员id， 匹配当前登录人id				
					
					tempIdOr = this.getPrnTmplMatchIdOr(ciOrder, prnTmplAgg);
				}else if(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT.equals(prnTmpl.getSd_srvorrt()) && prnTmpl.getId_dept().indexOf(id_dep) >=0){				
				// 科室 模板中Id_dept 字段包含 当前登录人所在科室id 
					
					tempIdOr = this.getPrnTmplMatchIdOr(ciOrder, prnTmplAgg);
				}else if(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL.equals(prnTmpl.getSd_srvorrt())){				
					// 全院
					
					tempIdOr = this.getPrnTmplMatchIdOr(ciOrder, prnTmplAgg);
				}
				
				// 当前医嘱与医疗单不匹配，或者当前医嘱已匹配到医，不在处理，保证一个医嘱匹配到一个打印单 
				if(!StringUtils.isNullOrEmpty(tempIdOr) && !orPrnTmplMap.containsKey(tempIdOr)){
					orPrnTmplMap.put(tempIdOr, prnTmpl.getId_emsprntmpl());
				}
			}
		}
		
		return orPrnTmplMap ;
	}
		
	/**
	 * 获取打印单模板匹配的医嘱id
	 * @param ciOrdList
	 * @param prnTmplAgg
	 * @return 如果当前模板与
	 */
	private String getPrnTmplMatchIdOr(CiOrderDO ciOrder,EmsprntmplAggDO prnTmplAgg){
		
		EmsPrnTmplRelSrvDO[] prnTmplRelSrvs = prnTmplAgg.getEmsPrnTmplRelSrvDO();
		
		for(EmsPrnTmplRelSrvDO prnTmplRelSrv :  prnTmplRelSrvs){

			String tempSd_srvtp = prnTmplRelSrv.getSd_srvtp();
			// 如果当前关联明细为减项，并且匹配当前的服务或服务类型，则当前模板不服务当前医嘱对应的服务
			if(!AddMinusDirect.ADDITEM.equals( prnTmplRelSrv.getEu_direct()) && (ciOrder.getId_srv().equals(prnTmplRelSrv.getId_srv()) || tempSd_srvtp != null && (ciOrder.getSd_srvtp().startsWith(tempSd_srvtp)))){
				break;
			}
			
			// 如果是增项，匹配到结果后返回医嘱id
			if(AddMinusDirect.ADDITEM.equals( prnTmplRelSrv.getEu_direct()) && (ciOrder.getId_srv().equals(prnTmplRelSrv.getId_srv()) || tempSd_srvtp != null  && (ciOrder.getSd_srvtp().startsWith(tempSd_srvtp)))){
				return ciOrder.getId_or();
			}
		}
		
		return "";
	}	
}
