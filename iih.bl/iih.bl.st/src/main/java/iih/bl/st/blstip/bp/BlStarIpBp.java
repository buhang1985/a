package iih.bl.st.blstip.bp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.utils.BdEnvContextUtil;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.i.IBlincipMDORService;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blauditip.bp.BlAuditIpBp;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blauditip.i.IBlauditipMDOCudService;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipMDORService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.dto.d.BlStIpBillDTO;
import iih.bl.st.dto.d.BlStIpCardInfoDTO;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.bl.st.dto.d.BlStIpPatEntInfoDTO;
import iih.bl.st.listrener.event.BlStIpEvent;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * *住院结算
 * 
 * @author weijia
 */
public class BlStarIpBp {

	/**
	 * 获取患者住院结算未付款的结算数
	 * 
	 * @throws BizException
	 * */
	public Integer getNoPayBlstipCountByIdEnt(String id_ent)
			throws BizException {
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		StringBuffer strQur = new StringBuffer();
		strQur.append(" a0.ID_ENT = '").append(id_ent).append("' ")
				.append(" and a0.fg_pay = 'N' ")
				.append(" and a0.FG_CANC = 'N'");
		BlStIpDO[] blStIpDOArr = stRService.find(strQur.toString(), null,
				FBoolean.FALSE);
		Integer num = 0;
		if (blStIpDOArr != null && blStIpDOArr.length > 0) {
			num = blStIpDOArr.length;
		}
		return num;
	}

	/**
	 * 根据患者id和就诊id获取患者住院预交金信息
	 * 
	 * @param id_ent
	 *            就诊id
	 * @return list 第一个值是患者预交金总额，第二个值是患者预交金账户总额
	 * @throws BizException
	 * */
	public BlStIpCardInfoDTO getBlStPayInfoByIdPat(String id_ent)
			throws BizException {
		BlStIpCardInfoDTO blStIpCardInfoDTO = new BlStIpCardInfoDTO();
		FDouble amt_sum = new FDouble(0);
		FDouble amt_yu = new FDouble(0);
		// 获取预交金账户余额
		StringBuffer qurStr = new StringBuffer();
		qurStr.append(" a0.id_ent = '").append(id_ent).append("' ");
		// IEnaccountMDORService accService =
		// ServiceFinder.find(IEnaccountMDORService.class);
		// EnAccountDO[] enAccountDOArr = accService.find(qurStr.toString(),
		// null, FBoolean.FALSE);
		// if(enAccountDOArr == null || enAccountDOArr.length == 0)
		// throw new BizException("患者就诊账户为空！");
		// amt_yu = enAccountDOArr[0].getAmt_prepay();

		IEnOutQryService inpPatAccImpls = ServiceFinder
				.find(IEnOutQryService.class);
		BalanceDTO balanceDTO = inpPatAccImpls.getBalanceDTO(id_ent);
		if (balanceDTO == null) {
			throw new BizException("就诊" + id_ent + "对应的就诊账户不存在！");
		}
		// amt_yu = balanceDTO.getAvailable();
		amt_yu = balanceDTO.getAmt_prepay().sub(balanceDTO.getAmt_uncg());
		amt_sum = balanceDTO.getAmt_prepay();

		blStIpCardInfoDTO.setAmt_pay_sur(amt_yu);
		// 获取结算类型
		IPativisitRService entService = ServiceFinder
				.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = entService.findById(id_ent);
		if (patiVisitDO.getFg_ip().booleanValue()) {// 在院
			blStIpCardInfoDTO.setName_st_type("中途结算");
		} else {// 出院
			blStIpCardInfoDTO.setName_st_type("出院结算");
		}

		// 获取预交金总额
		// IBlpaypatRService payService =
		// ServiceFinder.find(IBlpaypatRService.class);
		// BlPrePayPatDO[] blPrePayPatDOArr = payService.find(qurStr.toString(),
		// null, FBoolean.FALSE);
		// if(blPrePayPatDOArr == null){
		// blStIpCardInfoDTO.setAmt_pay_sum(amt_sum);
		// return blStIpCardInfoDTO;
		// }
		//
		// for(BlPrePayPatDO blPrePayPatDO : blPrePayPatDOArr){
		// if(!blPrePayPatDO.getFg_canc().booleanValue() &&
		// !blPrePayPatDO.getFg_rep_return().booleanValue()){
		// if(blPrePayPatDO.getEu_direct() == BookRtnDirectEnum.CHARGE){
		// amt_sum = amt_sum.add(blPrePayPatDO.getAmt());
		// }else{
		// amt_sum = amt_sum.sub(blPrePayPatDO.getAmt());
		// }
		// }
		// }
		blStIpCardInfoDTO.setAmt_pay_sum(amt_sum);
		return blStIpCardInfoDTO;
	}

	/**
	 * 对患者进行后台划价记账，根据诊断id、科室id和结束时间获取记账信息
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param id_dep
	 *            科室id
	 * @param dt_ent
	 *            结束时间
	 * @return BlCgIpDO[] 住院记账信息
	 * @throws BizException
	 * @author Liwq
	 * */
	public BlCgIpDO[] getBlCgIpInfo(String id_ent, String id_dep,
			FDateTime dt_end) throws BizException {
		// 获取BLSTIP0005 是否母婴合并结算参数 by liwq 2017-9-23 16:23:53
		// 查询合计金额
		StringBuilder sql = new StringBuilder();
		sql.append(" select sum(amt_pat*eu_direct) amt_pat,sum(amt_hp*eu_direct) amt_hp,sum(amt_std*eu_direct) amt_std, ");
		sql.append(" sum(amt*eu_direct) amt,sum(amt_ratio*eu_direct) amt_ratio from bl_cg_ip a0 where  ");
		sql.append(this.getSqlParam(id_ent, id_dep, dt_end));

		List<BlCgIpDO> list = (List<BlCgIpDO>) new DAFacade().execQuery(
				sql.toString(), new BeanListHandler(BlCgIpDO.class));

		if (list.get(0).getAmt() == null || list.get(0).getAmt_ratio() == null)
			return null;
		return list.toArray(new BlCgIpDO[] {});
	}

	public String getSqlParam(String id_ent, String id_dep, FDateTime dt_end)
			throws BizException {
		StringBuffer sqlQur = new StringBuffer();
		// 获取BLSTIP0005 是否母婴合并结算参数 by liwq 2017-9-23 16:23:53
		FBoolean isMerge =  BlParams.BLSTIP0005();
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO enNewBorn = enService.getNewbornDO(id_ent);
		if (FBoolean.TRUE.equals(isMerge)) {
			if (enNewBorn != null)
				sqlQur.append(" a0.FG_ST = 'N' ").append(" AND (a0.ID_ENT = '")
						.append(enNewBorn.getId_ent_mom())
						.append("' or a0.id_ent_mom = '")
						.append(enNewBorn.getId_ent_mom()).append("') ");
			else
				sqlQur.append(" a0.FG_ST = 'N' ").append(" AND (a0.ID_ENT = '")
						.append(id_ent).append("' or a0.id_ent_mom = '")
						.append(id_ent).append("') ");
		} else {
			sqlQur.append(" a0.FG_ST = 'N' ").append(" AND (a0.ID_ENT = '")
					.append(id_ent).append("') ");
		}

		// 判断如果id_dep为*则查找所有科室的就诊,否则查找单科室的就诊数据
		if (!StringUtils.isBlank(id_dep) && !"*".equals(id_dep)) {
			sqlQur.append(" AND a0.ID_DEP_OR = '").append(id_dep).append("' ");
		}
		String dt_end_str = dt_end.getDate().getDateAfter(1).toString()
				+ " 00:00:00";
		sqlQur.append(" AND a0.DT_CG < '").append(dt_end_str).append("' ");
		return sqlQur.toString();
	}
	
	/**
	 * 住院结算高级筛选
	 * @param map
	 * @return
	 * @throws BizException
	 */
	public BlCgIpDO[] getBlCgIpInfo(FMap map) throws BizException {
		// 获取BLSTIP0005 是否母婴合并结算参数 by liwq 2017-9-23 16:23:53
		// 查询合计金额
		StringBuilder sql = new StringBuilder();
		sql.append(" select sum(amt_pat*eu_direct) amt_pat,sum(amt_hp*eu_direct) amt_hp,sum(amt_std*eu_direct) amt_std, ");
		sql.append(" sum(amt*eu_direct) amt,sum(amt_ratio*eu_direct) amt_ratio from bl_cg_ip a0  ");
		
		SqlParam param = new SqlParam();
		this.setSqlAndParam(map, sql, param);

		List<BlCgIpDO> list = (List<BlCgIpDO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlCgIpDO.class));

		if (list.get(0).getAmt() == null || list.get(0).getAmt_ratio() == null)
			return null;
		return list.toArray(new BlCgIpDO[] {});
	}
	
	public BlCgIpDO[] findBlCgIpDOInfoByQur(String sqlQur) throws BizException {
		IBlcgqueryRService cgService = ServiceFinder
				.find(IBlcgqueryRService.class);
		BlCgIpDO[] blcgIpDOArr = cgService.find(sqlQur, null, FBoolean.FALSE);
		return blcgIpDOArr;
	}

	/**
	 * 住院结算-调入 记账费用明细（分页）
	 * 
	 * @param map
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 * @author Liwq
	 */
	public PagingRtnData<BlCgIpDO> getBlCgIpPageDos(FMap map,
			PaginationInfo pageInfo) throws BizException {
		PagingRtnData<BlCgIpDO> pageFeeDTO = new PagingRtnData<BlCgIpDO>();
		PagingServiceImpl<BlCgIpDO> service = new PagingServiceImpl<BlCgIpDO>();
		if (map.isEmpty()) {

			return pageFeeDTO;
		}
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select * from (");

		sql.append(" select a0.Amt*eu_direct  amt,         ");
		sql.append("     a0.Amt_hp*eu_direct amt_hp,         ");
		sql.append("     a0.Amt_pat*eu_direct amt_pat,        ");
		sql.append("     a0.Amt_ratio*eu_direct amt_ratio,      ");
		sql.append("     a0.Amt_std*eu_direct amt_std,        ");
		sql.append("     a0.Apprno,         ");
		sql.append("     a0.Cd_batch,       ");
		sql.append("     a0.Code_apply,     ");
		sql.append("     a0.Code_cg,        ");
		sql.append("     a0.Code_enttp,     ");
		sql.append("     a0.Code_inccaitm,  ");
		sql.append("     a0.Code_mm,        ");
		sql.append("     a0.Code_srv,       ");
		sql.append("     a0.Ds,             ");
		sql.append("     a0.Dt_cg,          ");
		sql.append("     a0.Dt_or,          ");
		sql.append("     a0.Dt_srv,         ");
		sql.append("     a0.Dt_st,          ");
		sql.append("     a0.Eu_direct,      ");
		sql.append("     a0.Eu_srctp,       ");
		sql.append("     a0.Factor,         ");
		sql.append("     a0.Fg_additm,      ");
		sql.append("     a0.Fg_free,        ");
		sql.append("     a0.Fg_hp,          ");
		sql.append("     a0.Fg_mm,          ");
		sql.append("     a0.Fg_pddisc,      ");
		sql.append("     a0.Fg_recg,        ");
		sql.append("     a0.Fg_refund,      ");
		sql.append("     a0.Fg_st,          ");
		sql.append("     a0.Fg_susp,        ");
		sql.append("     a0.Id_cgip,        ");
		sql.append("     a0.Id_dep_cg,      ");
		sql.append("     a0.Id_dep_mp,      ");
		sql.append("     a0.Id_dep_nur,     ");
		sql.append("     a0.Id_dep_or,      ");
		sql.append("     a0.Id_dep_wh,      ");
		sql.append("     a0.Id_emp_cg,      ");
		sql.append("     a0.Id_emp_or,      ");
		sql.append("     a0.Id_ent,         ");
		sql.append("     a0.Id_enttp,       ");
		sql.append("     a0.Id_grp,         ");
		sql.append("     a0.Id_hp,          ");
		sql.append("     a0.Id_mm,          ");
		sql.append("     a0.Id_mmtp,        ");
		sql.append("     a0.Id_or,          ");
		sql.append("     a0.Id_or_pr,       ");
		sql.append("     a0.Id_or_pr_srv,   ");
		sql.append("     a0.Id_org,         ");
		sql.append("     a0.Id_org_cg,      ");
		sql.append("     a0.Id_org_mp,      ");
		sql.append("     a0.Id_org_or,      ");
		sql.append("     a0.Id_orsrv,       ");
		sql.append("     a0.Id_par,         ");
		sql.append("     a0.Id_pat,         ");
		sql.append("     a0.Id_pres,        ");
		sql.append("     a0.Id_pripat,      ");
		sql.append("     a0.Id_recg_ip,     ");
		sql.append("     a0.Id_srv,         ");
		sql.append("     a0.Id_srvca,       ");
		sql.append("     a0.Id_srvtp,       ");
		sql.append("     a0.Id_stip,        ");
		sql.append("     a0.Id_wg_or,       ");
		sql.append("     a0.Name_inccaitm,  ");
		sql.append("     a0.Name_mm,        ");
		sql.append("     a0.Name_srv ,       ");
		sql.append("     a0.Note,           ");
		sql.append("     a0.Onlycode,       ");
		sql.append("     a0.Pgku_base,      ");
		sql.append("     a0.Pgku_cur,       ");
		sql.append("     a0.Pri_ss,         ");
		sql.append("     a0.Price,          ");
		sql.append("     a0.Price_ratio,    ");
		sql.append("     a0.Quan*eu_direct quan,           ");
		sql.append("     a0.Quan_base,      ");
		sql.append("     a0.Ratio_hp,       ");
		sql.append("     a0.Ratio_pripat,   ");
		sql.append("     a0.Sd_mmtp,        ");
		sql.append("     a0.Sd_srvtp,       ");
		sql.append("     a0.Spec,           ");
		sql.append("     a0.Srcfunc_des,    ");
		sql.append("     a0.Srvu,           ");
		sql.append("     depor.code Blcgdepcode,           ");
		sql.append("     depor.name Blcgdepname,           ");
		sql.append("     depmp.code Depmpcode,           ");
		sql.append("     depmp.name Depmpname,           ");
		sql.append("     b0.name unit       ");

		sql.append(" from bl_cg_ip a0 left join bd_measdoc b0 on a0.srvu = b0.id_measdoc  ");
		
		sql.append(" left join bd_dep depor on a0.id_dep_or = depor.id_dep  ");
		sql.append(" left join bd_dep depmp on a0.id_dep_mp = depmp.id_dep  ");
		
		
		
		
		SqlParam param = new SqlParam();
		this.setSqlAndParam(map, sql, param);
		
		//根据参数BLSTIP0039判断是否取门急诊转入的费用
		 if (FBoolean.TRUE.equals(BlParams.BLSTIP0039())) {
			this.setSqlAndParamET(map, sql, param);
		}
		 
		sql.append(" ) mytab  order by mytab.dt_cg ") ;
		pageFeeDTO = service.findByPageInfo(new BlCgIpDO(), pageInfo,
				sql.toString(), "", param);

		return pageFeeDTO;
	}
	
	/**
	 * 根据参数BLSTIP0039判断是否取门急诊转入的费用
	 * @author zhang.hw
	 * @date 2020年3月10日
	 * @param map
	 * @param sql
	 * @param param
	 */
	private void setSqlAndParamET(FMap map, StringBuilder sql, SqlParam param) {
		sql.append(" union all ");
		sql.append(" select  oep.amt  *  cgoep.eu_direct  amt, ");
		sql.append("               oep.amt_hp  *  cgoep.eu_direct  amt_hp, ");
		sql.append("               oep.amt_pat  *  cgoep.eu_direct  amt_pat, ");
		sql.append("               oep.amt_ratio  *  cgoep.eu_direct  amt_ratio, ");
		sql.append("               oep.amt_std  *  cgoep.eu_direct  amt_std, ");
		sql.append("               oep.apprno, ");
		sql.append("               oep.Cd_batch, ");
		sql.append("               oep.Code_apply, ");
		sql.append("               cgoep.code_cg  Code_cg, ");
		sql.append("               '10'  as  Code_enttp, ");
		sql.append("               oep.Code_inccaitm, ");
		sql.append("               oep.Code_mm, ");
		sql.append("               oep.Code_srv, ");
		sql.append("               oep.Ds, ");
		sql.append("               cgoep.dt_cg, ");
		sql.append("               oep.Dt_or, ");
		sql.append("               oep.Dt_srv, ");
		sql.append("               ''  as  Dt_st, ");
		sql.append("               cgoep.Eu_direct, ");
		sql.append("               oep.Eu_srctp, ");
		sql.append("               oep.Factor, ");
		sql.append("               oep.Fg_additm, ");
		sql.append("               oep.Fg_free, ");
		sql.append("               oep.Fg_hp, ");
		sql.append("               oep.Fg_mm, ");
		sql.append("               oep.Fg_pddisc, ");
		sql.append("               oep.Fg_recg, ");
		sql.append("               oep.Fg_refund, ");
		sql.append("               'N'  as  Fg_st, ");
		sql.append("               oep.Fg_susp, ");
		sql.append("               oep.id_cgitmoep  Id_cgip, ");
		sql.append("               oep.Id_dep_or  Id_dep_cg, ");
		sql.append("               oep.Id_dep_mp, ");
		sql.append("               oep.Id_dep_nur, ");
		sql.append("               oep.Id_dep_or, ");
		sql.append("               oep.Id_dep_wh, ");
		sql.append("               oep.Id_emp_or  Id_emp_cg, ");
		sql.append("               oep.Id_emp_or, ");
		sql.append("               oep.Id_ent, ");
		sql.append("               oep.Id_enttp, ");
		sql.append("               oep.Id_grp, ");
		sql.append("               oep.Id_hp, ");
		sql.append("               oep.Id_mm, ");
		sql.append("               oep.Id_mmtp, ");
		sql.append("               oep.Id_or, ");
		sql.append("               oep.Id_or_pr, ");
		sql.append("               oep.Id_or_pr_srv, ");
		sql.append("               oep.Id_org, ");
		sql.append("               oep.Id_org_or  Id_org_cg, ");
		sql.append("               oep.Id_org_mp, ");
		sql.append("               oep.Id_org_or, ");
		sql.append("               oep.Id_orsrv, ");
		sql.append("               oep.Id_par, ");
		sql.append("               oep.Id_pat, ");
		sql.append("               oep.Id_pres, ");
		sql.append("               oep.Id_pripat, ");
		sql.append("               oep.ID_RECG_OEP  ID_RECG_IP, ");
		sql.append("               oep.Id_srv, ");
		sql.append("               oep.Id_srvca, ");
		sql.append("               oep.Id_srvtp, ");
		sql.append("               '~'  Id_stip, ");
		sql.append("               '~'  Id_wg_or, ");
		sql.append("               oep.Name_inccaitm, ");
		sql.append("               oep.Name_mm, ");
		sql.append("               oep.Name_srv, ");
		sql.append("               oep.Note, ");
		sql.append("               oep.Onlycode, ");
		sql.append("               oep.Pgku_base, ");
		sql.append("               oep.Pgku_cur, ");
		sql.append("               oep.Pri_ss, ");
		sql.append("               oep.Price, ");
		sql.append("               oep.Price_ratio, ");
		sql.append("               oep.Quan  *  cgoep.eu_direct  quan, ");
		sql.append("               oep.Quan_base, ");
		sql.append("               oep.Ratio_hp, ");
		sql.append("               oep.Ratio_pripat, ");
		sql.append("               oep.Sd_mmtp, ");
		sql.append("               oep.Sd_srvtp, ");
		sql.append("               oep.Spec, ");
		sql.append("               oep.Srcfunc_des, ");
		sql.append("               oep.Srvu, ");
		sql.append("               depor.code  Blcgdepcode, ");
		sql.append("               depor.name  Blcgdepname, ");
		sql.append("               depmp.code  Depmpcode, ");
		sql.append("               depmp.name  Depmpname, ");
		sql.append("               b0.name  unit ");
		sql.append("     from  bl_cg_itm_oep_tfrcd  tfrcd ");
		sql.append("   inner  join  bl_cg_itm_oep  oep ");
		sql.append("         on  tfrcd.id_cgitmoep  =  oep.id_cgitmoep ");
		sql.append("     left  join  bl_cg_oep  cgoep ");
		sql.append("         on  cgoep.id_cgoep  =  oep.id_cgoep ");
		sql.append("     left  join  bd_measdoc  b0 ");
		sql.append("         on  oep.srvu  =  b0.id_measdoc ");
		sql.append("     left  join  bd_dep  depor ");
		sql.append("         on  oep.id_dep_or  =  depor.id_dep ");
		sql.append("     left  join  bd_dep  depmp ");
		sql.append("         on  oep.id_dep_mp  =  depmp.id_dep ");
		sql.append("   where  tfrcd.id_ent_tf=? and  tfrcd.fg_active  =  'Y' ");
		sql.append("       and  tfrcd.fg_realtf  =  'Y' and tfrcd.fg_tl='N' ");

		//拼加条件
		String id_ent = map.get("id_ent").toString();
		param.addParam(id_ent);
	}

	/**
	 * 设置参数和sql
	 * @param map
	 * @param sql
	 * @param param
	 * @throws BizException
	 */
	public void setSqlAndParam(FMap map,StringBuilder sql,SqlParam param)
			throws BizException {
		String id_ent = map.get("id_ent").toString();
		String id_dep = map.get("id_dep").toString();
		// 获取BLSTIP0005母婴是否合并结算参数 by liwq 2017-9-23 16:09:17
		FBoolean isMerge =  BlParams.BLSTIP0005();
		// 查询母婴关系
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO enNewBorn = enService.getNewbornDO(id_ent);
		// 需测试 母婴合并结算 禁止婴儿调用费用 ？？？？
		if (FBoolean.TRUE.equals(isMerge)) {
			if (enNewBorn != null) {
				sql.append(" where  ( a0.ID_ENT = ? or a0.id_ent = ? ) ");
				param.addParam(enNewBorn.getId_ent_mom());
			} else {
				sql.append(" where  ( a0.ID_ENT = ? or a0.id_ent_mom=? ) ");
				param.addParam(id_ent);
			}
		} else {
			sql.append(" where  ( a0.ID_ENT = ?  ) ");
		}
		param.addParam(id_ent);

		// 判断如果id_dep为*则查找所有科室的就诊,否则查找单科室的就诊数据
		if (!StringUtils.isBlank(id_dep) && !"*".equals(id_dep)) {
			sql.append(" AND a0.ID_DEP_OR = '").append(id_dep).append("' ");
		}

		String dt_end_str = "";
		if (!"".equals(map.get("dt_end").toString())) {
			FDateTime dt_end = new FDateTime(map.get("dt_end").toString());
			dt_end_str = dt_end.getDate().getDateAfter(1).toString()
					+ " 00:00:00";

		}
		sql.append(" AND a0.DT_CG < ?  ");
		param.addParam(dt_end_str);
		// 是否有结算数据
		FBoolean isSettled = new FBoolean(map.get("isSettled").toString());
		if (isSettled.booleanValue()) {
			StringBuilder sqlSt = new StringBuilder();
			sqlSt.append(
					"select id_stip from bl_st_ip where fg_canc = 'N' and id_ent = '")
					.append(id_ent).append("'  order by dt_end desc ");
			List<String> idstipList = (List<String>) new DAFacade().execQuery(
					sqlSt.toString(), new ColumnListHandler());
			String id_stip = idstipList.get(0);
			sql.append(" and a0.fg_st = 'Y' and a0.id_stip = ? ");
			param.addParam(id_stip);
		} else {
			sql.append(" and a0.fg_st = 'N' ");
		}
		
		//执行科室
		if(map.containsKey("id_dep_mp")){
			String id_dep_mp = map.get("id_dep_mp").toString();
			if(StringUtils.isNotBlank(id_dep_mp)){
				sql.append(" and a0.id_dep_mp = ? ");
				param.addParam(id_dep_mp);
			}
		}
		//记账开始日期
		if(map.containsKey("dt_cg_begin")){
			String dt_cg_begin = map.get("dt_cg_begin").toString();
			if(StringUtils.isNotBlank(dt_cg_begin)){
				sql.append(" and a0.dt_cg >= ? ");
				param.addParam(dt_cg_begin);
			}
		}
		//服务项目
		if(map.containsKey("id_srv")){
			String id_srv = map.get("id_srv").toString();
			if(StringUtils.isNotBlank(id_srv)){
				sql.append(" and a0.id_srv = ? ");
				param.addParam(id_srv);
			}
		}
		//账单
		if(map.containsKey("code_inccaitm")){
			String code_inccaitm = map.get("code_inccaitm").toString();
			if(StringUtils.isNotBlank(code_inccaitm)){
				sql.append(" and a0.code_inccaitm = ? ");
				param.addParam(code_inccaitm);
			}
		}
		//医嘱
		if(map.containsKey("id_or")){
			String id_or = map.get("id_or").toString();
			if(StringUtils.isNotBlank(id_or)){
				sql.append(" and a0.id_or = ? ");
				param.addParam(id_or);
			}
		}
		//婴儿标识
		if(map.containsKey("fg_bb")){
			String fg_bb = map.get("fg_bb").toString();
			if(StringUtils.isNotBlank(fg_bb)){
				sql.append(" and a0.fg_bb = ? ");
				param.addParam(fg_bb);
			}
		}
		//保内外标识
		if(map.containsKey("fg_selfpay")){
			String fg_selfpay = map.get("fg_selfpay").toString();
			if(StringUtils.isNotBlank(fg_selfpay)){
				sql.append(" and a0.fg_selfpay = ? ");
				param.addParam(fg_selfpay);
			}
		}
	}


	/**
	 * 结算
	 * 
	 * @param id_pat
	 *            患者id
	 * @param id_org
	 *            所属机构
	 * @param id_ent
	 *            就诊id
	 * @param id_dep
	 *            当前科室（操作员所属科室）
	 * @param id_emp
	 *            结算人员id（操作员id）
	 * @param blCgIpDOArr
	 *            记账明细
	 * @throws BizException
	 * */
	public FBoolean doSettlement(String id_pat, String id_org, String id_ent,
			String id_dep, String id_emp, FDateTime dt_end,
			BlCgIpDO[] blCgIpDOArr) throws BizException {

		// 就诊信息
		IPativisitRService entService = ServiceFinder
				.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = entService.findById(id_ent);
		if (patiVisitDO == null) {
			throw new BizException("就诊不存在！");
		}
		// 审核记录
		BlAuditIpBp blAuditIpBp = new BlAuditIpBp();
		// 判断是否封账
		FBoolean freezeFlag = blAuditIpBp.getPatiEntAccStatusInfo(id_ent);
		if (freezeFlag.booleanValue()) {
			throw new BizException("该患者就诊账户已被封帐，请先通知相关人员进行解封！");
		}
		// 判断是否审核
		BlAuditIp[] blAuditIpArr = blAuditIpBp.getPatiIpAuditInfo(id_ent);
		if (blAuditIpArr == null || blAuditIpArr.length <= 0) {
			throw new BizException("该患者还没有完成费用审核，请先通知费用审核人员执行费用审核操作！");
		} else {
			Boolean flag = this.exmineCheck(patiVisitDO, blAuditIpArr[0]);
			if (!flag) {
				throw new BizException("该患者还没有完成费用审核，请先通知费用审核人员执行费用审核操作！");
			}
		}
		String sqlQur = this.getSqlParam(id_ent, id_dep, dt_end);
		blCgIpDOArr = this.findBlCgIpDOInfoByQur(sqlQur);

		BlStIpDO blStIpDO = new BlStIpDO();
		blStIpDO.setId_org(id_org);
		blStIpDO.setId_grp(Context.get().getGroupId());
		blStIpDO.setId_pat(id_pat);
		blStIpDO.setId_ent(id_ent);

		blStIpDO.setId_enttp(patiVisitDO.getId_entp());// 就诊类型 (DO中不存在此字段)???
		blStIpDO.setCode_enttp(patiVisitDO.getCode_entp());
		if (patiVisitDO.getFg_ip().booleanValue()) {
			blStIpDO.setEu_sttp(StTypeEnum.ST_INP_MIDWAY);// 结算类型:10.
															// 出院结算（出院患者）11.
															// 中途结算（在院患者）
		} else {
			blStIpDO.setEu_sttp(StTypeEnum.ST_INP);// 结算类型:10. 出院结算（出院患者）11.
													// 中途结算（在院患者）
		}
		// IBillcodeManage
		// billService=ServiceFinder.find(IBillcodeManage.class);
		// blStIpDO.setCode_st(billService.getPreBillCode_RequiresNew(BlStIpDODesc.CLASS_FULLNAME));//结算号???
		GetCodeByCustomization code_ins = new GetCodeByCustomization();
		blStIpDO.setCode_st(code_ins.GetCodeStIp());// 结算号
		blStIpDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		blStIpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);// 结算结果分类

		FDouble amt_std = new FDouble(0);// 总金额_标准
		FDouble amt_hp = new FDouble(0);// 总金额_医保计划
		FDouble amt_pat = new FDouble(0);// 总金额_患者自付
		FDouble amt_ratio = new FDouble(0);// 金额_价格比例
		FDouble amt = new FDouble(0);// 总金额
		for (BlCgIpDO blCgIpDO : blCgIpDOArr) {
			// 因为前台展示时对其乘了个方向，此处需将其再乘方向处理
			// blCgIpDO.setQuan(blCgIpDO.getQuan().multiply(blCgIpDO.getEu_direct()));
			// blCgIpDO.setAmt_std(blCgIpDO.getAmt_std().multiply(blCgIpDO.getEu_direct()));
			// blCgIpDO.setAmt_ratio(blCgIpDO.getAmt_ratio().multiply(blCgIpDO.getEu_direct()));
			//
			amt_std = amt_std.add(blCgIpDO.getAmt_std().multiply(
					blCgIpDO.getEu_direct()));
			amt_hp = amt_hp.add(blCgIpDO.getAmt_hp().multiply(
					blCgIpDO.getEu_direct()));
			amt_pat = amt_pat.add(blCgIpDO.getAmt_pat().multiply(
					blCgIpDO.getEu_direct()));
			amt_ratio = amt_ratio.add(blCgIpDO.getAmt_ratio().multiply(
					blCgIpDO.getEu_direct()));// 金额_价格比例
			amt = amt.add(blCgIpDO.getAmt().multiply(blCgIpDO.getEu_direct()));
		}
		if (amt_std.doubleValue() >= 0) {
			blStIpDO.setEu_direct(BookRtnDirectEnum.CHARGE);// 结算方向
		} else {
			blStIpDO.setEu_direct(BookRtnDirectEnum.RETURNS);// 结算方向
		}
		blStIpDO.setAmt_std(amt_std.abs());// 总金额_标准
		blStIpDO.setAmt_hp(amt_hp.abs());// 总金额_医保计划
		blStIpDO.setAmt_pat(amt_pat.abs());// 总金额_患者自付
		blStIpDO.setAmt(amt.abs());// 总金额
		blStIpDO.setAmt_ratio(amt_ratio.abs());// 金额_价格比例
		// 获取当前服务器时间
		TimeService timeService = new TimeServiceImpl();
		blStIpDO.setDt_start(this.getBlStIpLastTimeByIdEnt(patiVisitDO));// 结算起始时间
		FDateTime dateTime = timeService.getUFDateTime();
		blStIpDO.setDt_st(dateTime);// 结算时间
		String dt_end_str = dt_end.getDate().getDateAfter(1).toString()
				+ " 00:00:00";
		FDateTime dt_stop = new FDateTime(dt_end_str);
		if (dt_stop.after(dateTime)) {
			blStIpDO.setDt_end(dateTime);// 结算截止时间
		} else {
			blStIpDO.setDt_end(dt_stop);// 结算截止时间
		}

		// blStIpDO.setId_dep_st(id_dep);//结算科室
		blStIpDO.setId_dep_st(Context.get().getDeptId());// 结算科室
		blStIpDO.setId_emp_st(id_emp);// 结算人员
		blStIpDO.setFg_cc(FBoolean.FALSE);// 结账标志
		blStIpDO.setFg_canc(FBoolean.FALSE);// 取消标志
		blStIpDO.setFg_arclear(FBoolean.TRUE);// 欠费结清标志
		blStIpDO.setFg_pay(FBoolean.FALSE);
		blStIpDO.setFg_baddebt(FBoolean.FALSE);// 坏账标志
		blStIpDO.setStatus(DOStatus.NEW);

		// 保存结算信息
		IBlstipCudService stService = ServiceFinder
				.find(IBlstipCudService.class);
		BlStIpDO[] blStIpDOArr = stService.save(new BlStIpDO[] { blStIpDO });
		if (blStIpDOArr == null || blStIpDOArr.length == 0)
			return FBoolean.FALSE;
		// 修改记账表中的结算标志
		// IBlcgqueryMDOCudService cgService =
		// ServiceFinder.find(IBlcgqueryMDOCudService.class);
		// for(BlCgIpDO blCgIpDO : blCgIpDOArr){
		// blCgIpDO.setFg_st(FBoolean.TRUE);
		// blCgIpDO.setId_stip(blStIpDOArr[0].getId_stip());
		// blCgIpDO.setDt_st(blStIpDOArr[0].getDt_st());
		// blCgIpDO.setStatus(DOStatus.UPDATED);
		// }
		// cgService.save(blCgIpDOArr);
		String udtSql = "update bl_cg_ip a0 set a0.fg_st = 'Y',a0.id_stip = '"
				+ blStIpDOArr[0].getId_stip() + "',dt_st = '"
				+ blStIpDOArr[0].getDt_st() + "'" + " where "
				+ this.getSqlParam(id_ent, id_dep, dt_end);
		new DAFacade().execUpdate(udtSql);

		// 如果是出院结算，修改就诊表信息
		if (!patiVisitDO.getFg_ip().booleanValue()) {
			IPativisitCudService entCService = ServiceFinder
					.find(IPativisitCudService.class);
			patiVisitDO.setFg_st(FBoolean.TRUE);
			patiVisitDO.setStatus(DOStatus.UPDATED);
			entCService.save(new PatiVisitDO[] { patiVisitDO });
		}

		// 修改审核记录
		BlAuditIp blAuditIp = blAuditIpArr[0];
		blAuditIp.setId_stip(blStIpDOArr[0].getId_stip());
		blAuditIp.setFg_active(FBoolean.FALSE);
		blAuditIp.setStatus(DOStatus.UPDATED);
		IBlauditipMDOCudService adCService = ServiceFinder
				.find(IBlauditipMDOCudService.class);
		adCService.save(new BlAuditIp[] { blAuditIp });

		this.invokeNewEvent(patiVisitDO, blStIpDO, blCgIpDOArr);

		return FBoolean.TRUE;
	}

	/**
	 * 判断是否审核通过
	 * */
	public boolean exmineCheck(PatiVisitDO patiVisitDO, BlAuditIp blAuditIp) {
		boolean examine = false;
		if ((StringUtils.isEmpty(patiVisitDO.getId_hp()) || "~"
				.equals(patiVisitDO.getId_hp()))) {
			if (blAuditIp.getFg_pass_clinic().booleanValue())
				examine = true;
		} else {
			if (blAuditIp.getFg_pass_clinic().booleanValue()
					&& blAuditIp.getFg_pass_hp().booleanValue())
				examine = true;
		}
		return examine;
	}

	/**
	 * 发送事件
	 * 
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	public void invokeNewEvent(PatiVisitDO patiVisitDO, BlStIpDO blStIpDO,
			BlCgIpDO[] blCgIpDOArr) throws BizException {
		// 发送事件
		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();
		blEventInfoDTO.setPatiVisitDO(patiVisitDO);
		FArrayList cgList = new FArrayList();
		Collections.addAll(cgList, blCgIpDOArr);
		blEventInfoDTO.setBlCgIpDOList(cgList);
		blEventInfoDTO.setBlStIpDO(blStIpDO);

		BlStIpEvent blStIpEvent = new BlStIpEvent();
		blStIpEvent.invokeNew(blEventInfoDTO);
	}

	/**
	 * 获取本次就诊最近一次结算结束时间
	 * 
	 * @throws BizException
	 * */
	public FDateTime getBlStIpLastTimeByIdEnt(PatiVisitDO patiVisitDO)
			throws BizException {
		FDateTime dt_start = null;
		IBlstipRService service = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO[] blStIpArr = service.find(
				" a0.id_ent = '" + patiVisitDO.getId_ent() + "' ",
				" a0.dt_end desc ", FBoolean.FALSE);
		if (blStIpArr == null || blStIpArr.length == 0) {
			dt_start = patiVisitDO.getDt_acpt();
		} else {
			dt_start = blStIpArr[0].getDt_end();
		}
		return dt_start;
	}

	/**
	 * 获取账单画面数据
	 * */
	@SuppressWarnings("unchecked")
	public BlStIpBillDTO getBlStIpBillDTOByIdStIp(String id_stip)
			throws BizException {
		BlStIpBillDTO blStIpBillDTO = new BlStIpBillDTO();
		BlStIpPatEntInfoDTO blStIpPatEntInfoDTO = this
				.getBlStIpPatEntInfoByIdStIp(id_stip);
		BlStIpInccaInfoDTO[] inccaArr = this.getBdInccaInfoByIdStIp(id_stip);
		FArrayList list = null;
		if (inccaArr != null) {
			list = new FArrayList();
			FDouble amt = new FDouble(0);
			for (BlStIpInccaInfoDTO blStIpInccaInfoDTO : inccaArr) {
				amt = amt.add(blStIpInccaInfoDTO.getAmt());
				list.add(blStIpInccaInfoDTO);
			}
			blStIpPatEntInfoDTO.setAmt(amt);// 费用合计
			// blStIpPatEntInfoDTO.setAmt_cp(CapitalFiguresUtil.digitUppercase(amt.doubleValue()));//费用合计（大写）
			// 调用接口
		}
		blStIpBillDTO.SetStPatEntInfoDTO(blStIpPatEntInfoDTO);
		blStIpBillDTO.setStInccaInfoDTOArr(list);
		return blStIpBillDTO;
	}

	/**
	 * 获取账单中结算相关患者、就诊、账目等信息
	 * 
	 * @param id_stip
	 *            结算id
	 * */
	public BlStIpPatEntInfoDTO getBlStIpPatEntInfoByIdStIp(String id_stip)
			throws BizException {
		BlStIpPatEntInfoDTO blStIpPatEntInfoDTO = new BlStIpPatEntInfoDTO();
		blStIpPatEntInfoDTO.setId_stip(id_stip);

		IBlstipRService stService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO blStIpDO = stService.findById(id_stip);// 结算信息
		blStIpPatEntInfoDTO.setCode_st(blStIpDO.getCode_st());// 结算编码
		blStIpPatEntInfoDTO.setDt_end(blStIpDO.getDt_end());// 结算截止时间
		blStIpPatEntInfoDTO.setDt_st(blStIpDO.getDt_st());// 结算时间

		IPativisitRService entService = ServiceFinder
				.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = entService.findById(blStIpDO.getId_ent());// 就诊信息
		blStIpPatEntInfoDTO.setName_dep_phy(patiVisitDO.getName_dep_phy());// 当前就诊科室
		blStIpPatEntInfoDTO.setName_dep__nur(patiVisitDO.getName_dep_nur());// 当前护理单位

		IPatiMDORService patService = ServiceFinder
				.find(IPatiMDORService.class);
		PatDO patDO = patService.findById(blStIpDO.getId_pat());// 患者信息
		blStIpPatEntInfoDTO.setName_pat(patDO.getName());// 患者名称

		IBlincipMDORService incService = ServiceFinder
				.find(IBlincipMDORService.class);
		BlIncIpDO[] blIncIpDOArr = incService.find(" a0.id_stip = '" + id_stip
				+ "' ", null, FBoolean.FALSE);
		if (blIncIpDOArr != null && blIncIpDOArr.length > 0) {
			blStIpPatEntInfoDTO.setIncno(blIncIpDOArr[0].getIncno());// 收据号
		}
		IBlpaypatipMDORService payService = ServiceFinder
				.find(IBlpaypatipMDORService.class);
		BlPayPatIpDO[] blPayPatIpDOArr = payService.find(" a0.id_stip = '"
				+ id_stip + "' ", null, FBoolean.FALSE);
		if (blPayPatIpDOArr != null && blPayPatIpDOArr.length > 0) {
			blStIpPatEntInfoDTO.setName_emp_pay(blPayPatIpDOArr[0]
					.getName_emp_pay());// 收款人
		}
		return blStIpPatEntInfoDTO;
	}

	/**
	 * 根据结算获取账单信息
	 * 
	 * @param id_stip
	 *            结算id
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	public BlStIpInccaInfoDTO[] getBdInccaInfoByIdStIp(String id_stip)
			throws BizException {
		StringBuffer sql = new StringBuffer();
		// 按新票据分类做的
		sql.append("  SELECT Z.ID_INCCAITM, ");
		sql.append("         Z.CODE_INCCAITM, ");
		sql.append("         NVL(Z.NAME_INCCAITM, '未知') as NAME_INCCAITM, ");
		sql.append("         SUM(X.EU_DIRECT * X.Quan) Quan, ");
		sql.append("         trim(to_char(SUM(X.EU_DIRECT * X.AMT),'9999990.00')) AS AMT, ");
		sql.append("         trim(to_char(SUM(X.EU_DIRECT * X.AMT_HP),'9999990.00')) AMT_HP, ");
		sql.append("         trim(to_char(SUM(X.EU_DIRECT * X.AMT_STD),'9999990.00')) AMT_STD, ");
		sql.append("         trim(to_char(SUM(X.EU_DIRECT * X.AMT_PAT),'9999990.00')) AMT_PAT, ");
		sql.append("         trim(to_char(SUM(X.EU_DIRECT * X.AMT_RATIO),'9999990.00')) AMT_RATIO ");
		sql.append("    FROM BL_CG_IP X ");
		sql.append("    LEFT JOIN (SELECT distinct B.ID_INCCAITM, ");
		sql.append("                               B.NAME        AS NAME_INCCAITM, ");
		sql.append("                               B.CODE        AS CODE_INCCAITM, ");
		sql.append("                               C.ID_SRV ");
		sql.append("                 FROM BD_INCCA_ITM B ");
		sql.append("                 JOIN BD_INCCA_ITM_REL C ");
		sql.append("                   ON B.ID_INCCAITM = C.ID_INCCAITM ");
		sql.append("                WHERE c.ID_INCCA = ?) Z ");
		sql.append("      ON X.ID_SRV = Z.ID_SRV  ");
		sql.append("   WHERE X.ID_STIP = ? ");
		sql.append("   GROUP BY Z.ID_INCCAITM, Z.CODE_INCCAITM, Z.NAME_INCCAITM ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(IBdInccaCodeConst.ID_INHOS_INVOICE);
		sqlp.addParam(id_stip);
		List<BlStIpInccaInfoDTO> list = (List<BlStIpInccaInfoDTO>) new DAFacade()
				.execQuery(sql.toString(), sqlp, new BeanListHandler(
						BlStIpInccaInfoDTO.class));
		return list.toArray(new BlStIpInccaInfoDTO[] {});
	}

	/**
	 * 根据结算获取账单信息
	 * 
	 * @param id_stip
	 *            结算id
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	public BlStIpInccaInfoDTO[] getBLIncInfoByIdStIp(String id_stip)
			throws BizException {
		StringBuffer sql = new StringBuffer();
		// 按新票据分类做的
		sql.append("  select NVL(T.name, '未知') as NAME_INCCAITM, ");
		sql.append("         trim(to_char(T.AMT,'9999990.00')) AS AMT, ");
		sql.append("         trim(to_char(T.AMT_HP,'9999990.00')) AMT_HP, ");
		sql.append("         trim(to_char(T.AMT_STD,'9999990.00')) AMT_STD, ");
		sql.append("         trim(to_char(T.AMT_PAT,'9999990.00')) AMT_PAT, ");
		sql.append("         trim(to_char(T.AMT_RATIO,'9999990.00')) AMT_RATIO ");
		sql.append("  from bl_inc_ip p,bl_inc_itm_ip t ");
		sql.append("  where p.id_stip = ? ");
		sql.append("             and t.id_incip = p.id_incip ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_stip);
		List<BlStIpInccaInfoDTO> list = (List<BlStIpInccaInfoDTO>) new DAFacade()
				.execQuery(sql.toString(), sqlp, new BeanListHandler(
						BlStIpInccaInfoDTO.class));
		return list.toArray(new BlStIpInccaInfoDTO[] {});
	}

	/**
	 * 获取结算细目
	 * */
	@SuppressWarnings("unchecked")
	public BlCgIpDO[] getBlStIpCgIpInfo(String id_stip) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select Z.id_srv,Z.eu_direct,Z.spec,m.name as UNIT,Z.name_srv,Z.name_mm,Z.amt,Z.amt_ratio,Z.quan ")
				.append("from (SELECT A.ID_SRV,A.Eu_Direct,A.ID_MM,A.SPEC,A.SRVU AS ID_UNIT,A.NAME_SRV,A.NAME_MM,SUM(A.AMT) AS AMT,SUM(A.Amt_Ratio) as AMT_RATIO,SUM(A.QUAN) AS QUAN ")
				.append("FROM BL_CG_IP A ")
				.append("WHERE A.ID_STIP = '")
				.append(id_stip)
				.append("' ")
				.append("GROUP BY A.ID_SRV,A.Eu_Direct,A.ID_MM,A.SPEC,A.SRVU,A.PGKU_CUR,A.NAME_SRV,A.NAME_MM) Z ")
				.append("left join bd_measdoc m on Z.ID_UNIT = m.id_measdoc");
		List<BlCgIpDO> list = (List<BlCgIpDO>) new DAFacade().execQuery(
				sql.toString(), new BeanListHandler(BlCgIpDO.class));
		return list.toArray(new BlCgIpDO[] {});
	}

	/**
	 * 取消结算
	 * */
	public FBoolean doCancelSettlement(BlStIpDO blStIpDO) throws BizException {
		// 删除结算数据
		IBlstipCudService stService = ServiceFinder
				.find(IBlstipCudService.class);
		blStIpDO.setStatus(DOStatus.DELETED);
		// stService.save(new BlStIpDO[]{blStIpDO});
		stService.delete(new BlStIpDO[] { blStIpDO });
		// 修改记账数据
		IBlcgqueryRService cgRService = ServiceFinder
				.find(IBlcgqueryRService.class);
		BlCgIpDO[] blCgIpDOArr = cgRService.find(
				" a0.id_stip = '" + blStIpDO.getId_stip() + "' ", null,
				FBoolean.FALSE);
		// if(blCgIpDOArr == null){
		// throw new BizException("记账数据为空！");
		// }
		// for(BlCgIpDO blCgIpDO : blCgIpDOArr){
		// blCgIpDO.setId_stip(null);
		// blCgIpDO.setFg_st(FBoolean.FALSE);
		// blCgIpDO.setDt_st(null);
		// blCgIpDO.setStatus(DOStatus.UPDATED);
		// }
		// IBlcgqueryMDOCudService cgDService =
		// ServiceFinder.find(IBlcgqueryMDOCudService.class);
		// cgDService.save(blCgIpDOArr);
		String udtSql = "update bl_cg_ip a0 set a0.fg_st = 'N',a0.id_stip = null,dt_st = null"
				+ " where id_stip = '" + blStIpDO.getId_stip() + "'";
		new DAFacade().execUpdate(udtSql);
		// 如果是出院结算，修改就诊表信息
		PatiVisitDO patiVisitDO = null;
		if (StTypeEnum.ST_INP.equals(blStIpDO.getEu_sttp())) {
			IPativisitRService entService = ServiceFinder
					.find(IPativisitRService.class);
			patiVisitDO = entService.findById(blStIpDO.getId_ent());
			IPativisitCudService entCService = ServiceFinder
					.find(IPativisitCudService.class);
			patiVisitDO.setFg_st(FBoolean.FALSE);
			patiVisitDO.setStatus(DOStatus.UPDATED);
			entCService.save(new PatiVisitDO[] { patiVisitDO });
		}

		// 发送事件
		this.invokeNewEvent(patiVisitDO, blStIpDO, blCgIpDOArr);

		return FBoolean.TRUE;
	}

	/**
	 * 根据banner中输入值查询相关患者就诊信息
	 * */
	@SuppressWarnings("unchecked")
	public BlBannerDTO[] getStIpBannerEnEntInfo(String inputValue,
			String[] selectCondition) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select distinct(t.id_ent),p.id_pat,p.name as name_pat,t.code as code_ent,t.dt_entry as dt_in,e.times_ip,r.id_pripat,r.name as name_pripat,h.id_hp,h.name as name_hp,t.fg_ip,e.code_amr_ip as code_amr,t.id_dep_nur ,dep.name name_dep_nur,e.name_bed  ")
				.append(" ,hpca.name_hppatca ,medkind.name as name_hpmedkind 	") 		
				.append("from en_ent t ")
				.append("left join pi_pat p on p.id_pat = t.id_pat ")
				.append("left join en_ent_ip e on e.id_ent = t.id_ent ")
				.append("left join bd_pri_pat r on r.id_pripat = t.id_pripat ")
				.append("left join en_ent_hp n on n.id_ent = t.id_ent and n.fg_maj = 'Y' ")
				.append("left join bd_hp h on h.id_hp = n.id_hp ")
				.append("left outer join bl_st_ip s on s.id_ent = t.id_ent ")
				.append("left outer join pi_pat_card c on c.id_pat = p.id_pat ")
				.append("left join bd_dep dep on dep.id_dep =t.id_dep_nur ")
				.append("left join  bd_hp_patca hpca on hpca.code_hppatca = n.code_hppatca and hpca.id_hp =h.id_hp ")
				.append("left join  bd_hp_med_kind_ah medkind on medkind.code = t.code_hpmedkind ")
				.append("where t.code_entp = 10 ")
				.append("and t.fg_canc = 'N' ")
				.append("and (t.fg_st = 'N' or (t.fg_st = 'Y' and s.fg_pay = 'N')) ");

		if (selectCondition != null && selectCondition.length > 0) {
			sql.append("and (");
			StringBuffer wheresql = new StringBuffer();
			for (String cond : selectCondition) {
				if ("code_ent".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("t.code like '%").append(inputValue)
							.append("%'");
				} else if ("id_pat".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.id_pat like '%").append(inputValue)
							.append("%'");
				} else if ("code_pat".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.code like '%").append(inputValue)
							.append("%'");
				} else if ("id_code".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.id_code like '%").append(inputValue)
							.append("%'");
				} else if ("barcode_chis".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.barcode_chis like '%")
							.append(inputValue).append("%'");
				} else if ("code_amr_ip".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.code_amr_ip like '%").append(inputValue)
							.append("%'");
				} else if ("patcode".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("c.code like '%").append(inputValue)
							.append("%'");
				} else if ("no_hp".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("n.no_hp like '%").append(inputValue)
							.append("%'");
				}else if("name_pat".equals(cond)){
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.name like '%").append(inputValue)
							.append("%'");
				}
			}
			sql.append(wheresql.toString());
			sql.append(") ");
		}
		String wherePart = BdEnvContextUtil.processEnvContext(
				new PatiVisitDO(), "t");
		if (StringUtils.isNotEmpty(wherePart)) {
			sql.append("and " );
			sql.append(wherePart);
		}
		sql.append("order by p.id_pat,e.times_ip desc");
		List<BlBannerDTO> list = (List<BlBannerDTO>) new DAFacade().execQuery(
				sql.toString(), new BeanListHandler(BlBannerDTO.class));
		return list.toArray(new BlBannerDTO[] {});
	}

	/**
	 * 根据就诊id获取未结算账单信息
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param fgSt
	 *            结算标志 Y-> 查询已结算 N->查询未结算 null->查询所有费用
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * @throws BizException
	 * @author liwq
	 * */
	@SuppressWarnings("unchecked")
	public BlStIpInccaInfoDTO[] getInccaInfoByIdEnt(String id_ent, String fgSt)
			throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("    SELECT ID_INCCAITM,                             ");
	    sql.append("    CODE_INCCAITM,                                  ");
	    sql.append("    NVL(NAME_INCCAITM, '未知') NAME_INCCAITM,       ");
	    sql.append("    SUM( QUAN) QUAN,                                ");
	    sql.append("    SUM( AMT) AMT,                                  ");
	    sql.append("    SUM( AMT_HP) AMT_HP,                            ");
	    sql.append("    SUM(AMT_STD) AMT_STD,                           ");
	    sql.append("    SUM( AMT_PAT) AMT_PAT,                          ");
	    sql.append("    SUM(AMT_RATIO) AMT_RATIO                        ");
	    sql.append("    FROM   (                                        ");    
		// 按新票据分类做的
		sql.append("  SELECT Z.ID_INCCAITM, ");
		sql.append("         Z.CODE_INCCAITM, ");
		sql.append("         NVL(Z.NAME_INCCAITM, '未知') as NAME_INCCAITM, ");
		sql.append("         SUM(X.EU_DIRECT * X.Quan) Quan, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT) AS AMT, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_HP) AMT_HP, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_STD) AMT_STD, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_PAT) AMT_PAT, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_RATIO) AMT_RATIO ");
		sql.append("    FROM BL_CG_IP X ");
		sql.append("    LEFT JOIN (SELECT distinct B.ID_INCCAITM, ");
		sql.append("                               B.NAME        AS NAME_INCCAITM, ");
		sql.append("                               B.CODE        AS CODE_INCCAITM, ");
		sql.append("                               C.ID_SRV ");
		sql.append("                 FROM BD_INCCA_ITM B ");
		sql.append("                 JOIN BD_INCCA_ITM_REL C ");
		sql.append("                   ON B.ID_INCCAITM = C.ID_INCCAITM ");
		sql.append("                WHERE c.ID_INCCA = ?) Z ");
		sql.append("      ON X.ID_SRV = Z.ID_SRV  ");
		sql.append("   WHERE X.ID_ENT = ?  ");
		if (fgSt.equals("Y"))
			sql.append(" AND X.FG_ST = 'Y' ");
		if (fgSt.equals("N"))
			sql.append(" AND X.FG_ST = 'N' ");
		sql.append("   GROUP BY Z.ID_INCCAITM, Z.CODE_INCCAITM, Z.NAME_INCCAITM ");
		//id_ent_mom 分开计算
		sql.append(" UNION ALL ");
		sql.append("  SELECT Z.ID_INCCAITM, ");
		sql.append("         Z.CODE_INCCAITM, ");
		sql.append("         NVL(Z.NAME_INCCAITM, '未知') as NAME_INCCAITM, ");
		sql.append("         SUM(X.EU_DIRECT * X.Quan) Quan, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT) AS AMT, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_HP) AMT_HP, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_STD) AMT_STD, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_PAT) AMT_PAT, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_RATIO) AMT_RATIO ");
		sql.append("    FROM BL_CG_IP X ");
		sql.append("    LEFT JOIN (SELECT distinct B.ID_INCCAITM, ");
		sql.append("                               B.NAME        AS NAME_INCCAITM, ");
		sql.append("                               B.CODE        AS CODE_INCCAITM, ");
		sql.append("                               C.ID_SRV ");
		sql.append("                 FROM BD_INCCA_ITM B ");
		sql.append("                 JOIN BD_INCCA_ITM_REL C ");
		sql.append("                   ON B.ID_INCCAITM = C.ID_INCCAITM ");
		sql.append("                WHERE c.ID_INCCA = ?) Z ");
		sql.append("      ON X.ID_SRV = Z.ID_SRV  ");
		sql.append("   INNER JOIN EN_ENT_NB NB ON NB.ID_ENT_MOM =X.ID_ENT ");
		sql.append("   WHERE NB.ID_ENT_MOM = ?  ");
		if (fgSt.equals("Y"))
			sql.append(" AND X.FG_ST = 'Y' ");
		if (fgSt.equals("N"))
			sql.append(" AND X.FG_ST = 'N' ");
		sql.append("   GROUP BY Z.ID_INCCAITM, Z.CODE_INCCAITM, Z.NAME_INCCAITM ");		
		sql.append(" ) GROUP BY ID_INCCAITM, CODE_INCCAITM, NAME_INCCAITM ");
		
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(IBdInccaCodeConst.ID_INHOS_INVOICE);
		sqlp.addParam(id_ent);
		sqlp.addParam(IBdInccaCodeConst.ID_INHOS_INVOICE);
		sqlp.addParam(id_ent);
		List<BlStIpInccaInfoDTO> list = (List<BlStIpInccaInfoDTO>) new DAFacade()
				.execQuery(sql.toString(), sqlp, new BeanListHandler(
						BlStIpInccaInfoDTO.class));
		return list.toArray(new BlStIpInccaInfoDTO[] {});
	}

	/**
	 * 住院审核节点banner过滤（只查询在院的患）
	 * 
	 * @author Liwq
	 * @param inputValue
	 * @param selectCondition
	 * @return
	 * @throws DAException
	 */
	public BlBannerDTO[] getStIpBannerEntInfo(String inputValue,
			String[] selectCondition) throws BizException {

		StringBuffer sql = new StringBuffer();
		sql.append(
				"select distinct(t.id_ent),p.id_pat,p.name as name_pat,t.code as code_ent,t.dt_entry as dt_in,e.times_ip,r.id_pripat,r.name as name_pripat,h.id_hp,h.name as name_hp,t.fg_ip ")
				.append("from en_ent t ")
				.append("left join pi_pat p on p.id_pat = t.id_pat ")
				.append("left join en_ent_ip e on e.id_ent = t.id_ent ")
				.append("left join bd_pri_pat r on r.id_pripat = t.id_pripat ")
				.append("left join en_ent_hp n on n.id_ent = t.id_ent and n.fg_maj = 'Y' ")
				.append("left join bd_hp h on h.id_hp = n.id_hp ")
				.append("left outer join bl_st_ip s on s.id_ent = t.id_ent ")
				.append("left outer join pi_pat_card c on c.id_pat = p.id_pat ")
				.append("where t.code_entp = 10 ")
				.append("and t.fg_canc = 'N' ").append("and t.fg_st = 'N'  ");
		if (selectCondition != null && selectCondition.length > 0) {
			sql.append("and (");
			StringBuffer wheresql = new StringBuffer();
			for (String cond : selectCondition) {
				if ("code_ent".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("t.code like '%").append(inputValue)
							.append("%'");
				} else if ("id_pat".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.id_pat like '%").append(inputValue)
							.append("%'");
				} else if ("code_pat".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.code like '%").append(inputValue)
							.append("%'");
				} else if ("id_code".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.id_code like '%").append(inputValue)
							.append("%'");
				} else if ("barcode_chis".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.barcode_chis like '%")
							.append(inputValue).append("%'");
				} else if ("code_amr_ip".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.code_amr_ip like '%").append(inputValue)
							.append("%'");
				} else if ("patcode".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("c.code like '%").append(inputValue)
							.append("%'");
				} else if ("name_pat".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.name like '%").append(inputValue)
							.append("%'");
				}
			}
			sql.append(wheresql.toString());
			sql.append(") ");
		}
		String sqlContext = " and "
				+ EnvContextUtil.processEnvContext("", new PatiVisitDO(), "t");// 增加组织隔离
		sql.append(sqlContext);
		sql.append(" order by p.id_pat,e.times_ip desc");
		List<BlBannerDTO> list = (List<BlBannerDTO>) new DAFacade().execQuery(
				sql.toString(), new BeanListHandler(BlBannerDTO.class));
		return list.toArray(new BlBannerDTO[] {});
	}

	/**
	 * 项目减免分页
	 * 
	 * @author Liwq
	 * @param map
	 *            （包含id_stip和检索框条件）
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlCgIpDO> findBlCgIpPageInfoData(FMap map,
			PaginationInfo pageInfo) throws BizException {
		PagingRtnData<BlCgIpDO> pageFeeDTO = new PagingRtnData<BlCgIpDO>();
		PagingServiceImpl<BlCgIpDO> service = new PagingServiceImpl();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT A.ID_SRV, A.Eu_Direct, A.ID_MM, A.SPEC, A.SRVU AS ID_UNIT, A.NAME_SRV, A.NAME_MM, ");
		sql.append(" A.AMT*a.eu_direct AS AMT, A.Amt_Ratio*a.eu_direct as AMT_RATIO, A.QUAN*a.eu_direct AS QUAN, a.code_inccaitm, a.name_inccaitm, a.id_cgip, a.price_ratio, ");
		sql.append(" a.price, a.fg_free, a.ratio_pripat FROM BL_CG_IP A ");
		if (!"".equals(map.get("searchKey")) || map.get("searchkey") != null)
			sql.append(" left join bd_srv b on a.id_srv = b.id_srv ");
		sql.append("WHERE  A.ID_STIP = ? ");
		if (!"".equals(map.get("searchKey")) || map.get("searchkey") != null) {
			sql.append(" and ( b.name like '%").append(map.get("searchKey"))
					.append("%' ");
			sql.append(" or b.wbcode like '%").append(map.get("searchKey"))
					.append("%' ");
			sql.append(" or b.pycode like '%").append(map.get("searchKey"))
					.append("%' ) ");
		}

		SqlParam param = new SqlParam();
		param.addParam(map.get("idStip"));

		pageFeeDTO = service.findByPageInfo(new BlCgIpDO(), pageInfo,
				sql.toString(), "", param);

		return pageFeeDTO;
	}

	/**
	 * 项目减免-分类服务项目合计
	 * 
	 * @author Liwq
	 */
	public BlCgIpDO[] findBlCgIpDOsByIdStip(String id_stip) throws BizException {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT  ");
		sql.append(" sum(A.AMT*a.eu_direct ) AS AMT, sum(A.Amt_Ratio*a.eu_direct) as AMT_RATIO, sum(A.QUAN*a.eu_direct) AS QUAN, a.code_inccaitm, a.name_inccaitm ");
		sql.append("  FROM BL_CG_IP A ");
		sql.append("WHERE  A.ID_STIP = ? ");
		sql.append("    group by a.code_inccaitm,a.name_inccaitm ");
		SqlParam param = new SqlParam();
		param.addParam(id_stip);
		List<BlCgIpDO> cgItemlist = new ArrayList<BlCgIpDO>();
		cgItemlist = (List<BlCgIpDO>) new DAFacade().execQuery(sql.toString(),
				param, new BeanListHandler(BlCgIpDO.class));
		return cgItemlist.toArray(new BlCgIpDO[] {});

	}
	
	/**
	 * 根据结算获取账单信息
	 * 
	 * @param id_st
	 *            结算id
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	public BlStIpInccaInfoDTO[] getBdInccaInfoByIdStET(String id_st)
			throws BizException {
		StringBuffer sql = new StringBuffer();
		SqlParam sqlp = new SqlParam();
		// 按新票据分类做的
		if (BlParams.BLST0002() == 1) {

			sql.append("  SELECT Z.ID_INCCAITM, ");
			sql.append("         Z.CODE_INCCAITM, ");
			sql.append("         NVL(Z.NAME_INCCAITM, '未知') NAME_INCCAITM, ");
			sql.append("         SUM(C.EU_DIRECT * X.Quan) Quan, ");
			sql.append("         trim(to_char(SUM(C.EU_DIRECT * X.AMT), '9999990.00')) AMT, ");
			sql.append("         trim(to_char(SUM(C.EU_DIRECT * X.AMT_HP), '9999990.00')) AMT_HP, ");
			sql.append("         trim(to_char(SUM(C.EU_DIRECT * X.AMT_STD), '9999990.00')) AMT_STD, ");
			sql.append("         trim(to_char(SUM(C.EU_DIRECT * X.AMT_PAT), '9999990.00')) AMT_PAT, ");
			sql.append("         trim(to_char(SUM(C.EU_DIRECT * X.AMT_RATIO), '9999990.00')) AMT_RATIO ");
			sql.append("    FROM Bl_Cg_Itm_Oep X  ");
			sql.append("    Inner join Bl_Cg_Oep C on x.id_cgoep = C.id_cgoep  ");
			sql.append("    LEFT outer JOIN (SELECT distinct B.ID_INCCAITM, ");
			sql.append("                                     B.NAME        NAME_INCCAITM, ");
			sql.append("                                     B.CODE        CODE_INCCAITM, ");
			sql.append("                                     C.ID_SRV ");
			sql.append("                       FROM BD_INCCA_ITM B ");
			sql.append("                      inner JOIN BD_INCCA_ITM_REL C ");
			sql.append("                         ON B.ID_INCCAITM = C.ID_INCCAITM ");
			sql.append("                      WHERE c.ID_INCCA = ?) Z ");
			sql.append("      ON X.ID_SRV = Z.ID_SRV ");
			sql.append("   WHERE X.Id_Stoep = ? ");
			sql.append("   GROUP BY Z.ID_INCCAITM, Z.CODE_INCCAITM, Z.NAME_INCCAITM ");

			sqlp.addParam(IBdInccaCodeConst.ID_ET_INVOICE);
			sqlp.addParam(id_st);
		}
		
		else if (BlParams.BLST0002() == 2) {
			sql.append("  SELECT Z.ID_INCCAITM, ");
			sql.append("         Z.CODE_INCCAITM, ");
			sql.append("         NVL(Z.NAME_INCCAITM, '未知') as NAME_INCCAITM, ");
			sql.append("         SUM(X.EU_DIRECT * X.Quan) Quan, ");
			sql.append("         trim(to_char(SUM(X.EU_DIRECT * X.AMT),'9999990.00')) AS AMT, ");
			sql.append("         trim(to_char(SUM(X.EU_DIRECT * X.AMT_HP),'9999990.00')) AMT_HP, ");
			sql.append("         trim(to_char(SUM(X.EU_DIRECT * X.AMT_STD),'9999990.00')) AMT_STD, ");
			sql.append("         trim(to_char(SUM(X.EU_DIRECT * X.AMT_PAT),'9999990.00')) AMT_PAT, ");
			sql.append("         trim(to_char(SUM(X.EU_DIRECT * X.AMT_RATIO),'9999990.00')) AMT_RATIO ");
			sql.append("    FROM BL_CG_IP X ");
			sql.append("    LEFT JOIN (SELECT distinct B.ID_INCCAITM, ");
			sql.append("                               B.NAME        AS NAME_INCCAITM, ");
			sql.append("                               B.CODE        AS CODE_INCCAITM, ");
			sql.append("                               C.ID_SRV ");
			sql.append("                 FROM BD_INCCA_ITM B ");
			sql.append("                 JOIN BD_INCCA_ITM_REL C ");
			sql.append("                   ON B.ID_INCCAITM = C.ID_INCCAITM ");
			sql.append("                WHERE c.ID_INCCA = ?) Z ");
			sql.append("      ON X.ID_SRV = Z.ID_SRV  ");
			sql.append("   WHERE X.ID_STIP = ? ");
			sql.append("   GROUP BY Z.ID_INCCAITM, Z.CODE_INCCAITM, Z.NAME_INCCAITM ");
			sqlp.addParam(IBdInccaCodeConst.ID_INHOS_INVOICE);
			sqlp.addParam(id_st);
		} 
		List<BlStIpInccaInfoDTO> list = (List<BlStIpInccaInfoDTO>) new DAFacade()
				.execQuery(sql.toString(), sqlp, new BeanListHandler(
						BlStIpInccaInfoDTO.class));
		return list.toArray(new BlStIpInccaInfoDTO[] {});
	}

	/**
	 * 急诊留观根据就诊id获取未结算账单信息
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param fgSt
	 *            结算标志 Y-> 查询已结算 N->查询未结算 null->查询所有费用
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * @throws BizException
	 * @author liwq
	 * */
	@SuppressWarnings("unchecked")
	public BlStIpInccaInfoDTO[] getInccaInfoByIdEntET(String id_ent, String fgSt)
			throws BizException {
		StringBuffer sql = new StringBuffer();
		
		// 按新票据分类做的
		if(BlParams.BLST0002() == 1)
		{
			sql.append("  SELECT ");
			sql.append("         X.CODE_INCCAITM, ");
			sql.append("         NVL(X.NAME_INCCAITM, '未知') NAME_INCCAITM, ");
			sql.append("         SUM(C.EU_DIRECT * X.Quan) Quan, ");
			sql.append("         SUM(C.EU_DIRECT * X.AMT) AMT, ");
			sql.append("         SUM(C.EU_DIRECT * X.AMT_HP) AMT_HP, ");
			sql.append("         SUM(C.EU_DIRECT * X.AMT_STD) AMT_STD, ");
			sql.append("         SUM(C.EU_DIRECT * X.AMT_PAT) AMT_PAT, ");
			sql.append("         SUM(C.EU_DIRECT * X.AMT_RATIO) AMT_RATIO ");
			sql.append("    FROM BL_CG_ITM_OEP X  ");
			sql.append("    Inner join Bl_Cg_Oep C on X.Id_Cgoep = C.Id_Cgoep  ");
			sql.append("   WHERE 1=1 ");
			sql.append("     and X.ID_ENT = ?  ");
		}
		else if(BlParams.BLST0002() == 2)
		{
			sql.append("  SELECT  ");
			sql.append("         X.CODE_INCCAITM, ");
			sql.append("         NVL(X.NAME_INCCAITM, '未知') as NAME_INCCAITM, ");
			sql.append("         SUM(X.EU_DIRECT * X.Quan) Quan, ");
			sql.append("         SUM(X.EU_DIRECT * X.AMT) AS AMT, ");
			sql.append("         SUM(X.EU_DIRECT * X.AMT_HP) AMT_HP, ");
			sql.append("         SUM(X.EU_DIRECT * X.AMT_STD) AMT_STD, ");
			sql.append("         SUM(X.EU_DIRECT * X.AMT_PAT) AMT_PAT, ");
			sql.append("         SUM(X.EU_DIRECT * X.AMT_RATIO) AMT_RATIO");
			sql.append("    FROM BL_CG_IP X ");			
			sql.append("   WHERE 1=1 and (X.ID_ENT = ? ");
			sql.append(")");
		}
		
		
		if (fgSt.equals("Y"))
			sql.append(" AND X.FG_ST = 'Y' ");
		if (fgSt.equals("N"))
			sql.append(" AND X.FG_ST = 'N' ");
		sql.append("   GROUP BY X.CODE_INCCAITM, X.NAME_INCCAITM ");
		SqlParam sqlp = new SqlParam();

		sqlp.addParam(id_ent);
	
		List<BlStIpInccaInfoDTO> list = (List<BlStIpInccaInfoDTO>) new DAFacade()
				.execQuery(sql.toString(), sqlp, new BeanListHandler(
						BlStIpInccaInfoDTO.class));
		return list.toArray(new BlStIpInccaInfoDTO[] {});
	}

}
