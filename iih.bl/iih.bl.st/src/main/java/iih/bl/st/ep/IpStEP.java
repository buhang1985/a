package iih.bl.st.ep;

import java.util.List;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blauditip.i.IBlauditipMDOCudService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院结算EP
 * @author yankan
 * @since 2017-06-19
 *
 */
public class IpStEP {

	/**
	 * 获取就诊信息
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO getPatiEntInfo(String id_ent) throws BizException {
		IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = entService.findById(id_ent);
		if (patiVisitDO == null) {
			throw new BizException("就诊不存在！");
		}
		return patiVisitDO;
	}
	
	/**
	 * 更新就诊出院结算标志
	 * 
	 * @param patiVisitDO
	 * @throws BizException
	 */
	public void updateEntStFlag(PatiVisitDO patiVisitDO) throws BizException {
		IPativisitCudService entCService = ServiceFinder.find(IPativisitCudService.class);
		patiVisitDO.setFg_st(FBoolean.TRUE);
		patiVisitDO.setStatus(DOStatus.UPDATED);
		entCService.save(new PatiVisitDO[] { patiVisitDO });
	}
	/**
	 * 更新审核流程结束标志
	 * @param id_stip
	 * @param auditIp
	 * @throws BizException
	 */
	public void updateAuditInfo(String id_stip,BlAuditIp auditIp) throws BizException {
		BlAuditIp blAuditIp = auditIp;
		blAuditIp.setId_stip(id_stip);
		blAuditIp.setFg_active(FBoolean.FALSE);
		blAuditIp.setStatus(DOStatus.UPDATED);
		IBlauditipMDOCudService adCService = ServiceFinder.find(IBlauditipMDOCudService.class);
		adCService.save(new BlAuditIp[] { blAuditIp });
	}
	/**
	 * 更新记账明细表结算相关的字段
	 * 
	 * @param stDO
	 * @param feeDep 费用开立部门（前台传入）
	 * @throws BizException 
	 */
	public void updateCgStFields(BlStIpDO stDO,String feeDep) throws BizException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("update bl_cg_ip set fg_st = 'Y' ,id_stip = ?,dt_st = ? where  ");
		sql.append(this.getSqlParam(stDO.getId_ent(), feeDep, stDO.getDt_end()));
		SqlParam param = new SqlParam();
		param.addParam(stDO.getId_stip());
		param.addParam(stDO.getDt_st());
				
		new DAFacade().execUpdate(sql.toString(),param);
	}
	
	/**
	 * 更新记账明细表结算相关的字段
	 * 
	 * @param stDO
	 * @param feeDep 费用开立部门（前台传入）
	 * @throws BizException 
	 */
	public void updateCgStFields(BlStIpDO stDO,BlCgIpDO[] cgIpDOArr) throws BizException {
		
		for(BlCgIpDO itm:cgIpDOArr){
			itm.setFg_st(FBoolean.TRUE);
			itm.setStatus(DOStatus.UPDATED);
			itm.setDt_st(stDO.getDt_st());
			itm.setId_stip(stDO.getId_stip());
		}
				
		new DAFacade().updateDOArray(cgIpDOArr, new String[] {BlCgIpDO.FG_ST, BlCgIpDO.DT_ST,BlCgIpDO.ID_STIP});
	}
	
	/**
	 * 保存本次结算信息
	 * 
	 * @param patiVisitDO
	 * @param cgIpDOArr
	 * @param dt_end
	 * @param id_emp
	 * @param id_dep 费用开立科室
	 * @return
	 * @throws BizException
	 */
	public BlStIpDO[] saveSettleDo(PatiVisitDO patiVisitDO,BlCgIpDO[] cgIpDOArr,FDateTime dt_end,String id_emp,String id_dep) throws BizException {
		BlStIpDO blStIpDO = new BlStIpDO();
		blStIpDO.setId_org(Context.get().getOrgId());
		blStIpDO.setId_grp(Context.get().getGroupId());
		blStIpDO.setId_pat(patiVisitDO.getId_pat());
		blStIpDO.setId_ent(patiVisitDO.getId_ent());
		
		blStIpDO.setId_hp(patiVisitDO.getId_hp());
		blStIpDO.setId_enttp(patiVisitDO.getId_entp());
		blStIpDO.setCode_enttp(patiVisitDO.getCode_entp());
		// 结算类型:10. 出院结算（出院患者）11. 中途结算（在院患者）
		if (patiVisitDO.getFg_ip().booleanValue()) {
			blStIpDO.setEu_sttp(StTypeEnum.ST_INP_MIDWAY);
		} else {
			blStIpDO.setEu_sttp(StTypeEnum.ST_INP);
		}
		// 获取结算号
		GetCodeByCustomization code_ins = new GetCodeByCustomization();
		blStIpDO.setCode_st(code_ins.GetCodeStIp());
		// 结算结果分类 结算时默认都是正常结算，付款时才区分
		blStIpDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		blStIpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);

		//获取本次结算的金额
		BlCgIpDO cgIpDO = this.getStAmt(patiVisitDO.getId_ent(), id_dep, dt_end);
		blStIpDO.setAmt_std(cgIpDO.getAmt_std().abs());// 总金额_标准 已废弃
		blStIpDO.setAmt_hp(cgIpDO.getAmt_hp().abs());// 总金额_医保计划
		blStIpDO.setAmt_pat(cgIpDO.getAmt_pat().abs());// 总金额_患者自付
		blStIpDO.setAmt(cgIpDO.getAmt().abs());// 总金额
		blStIpDO.setAmt_ratio(cgIpDO.getAmt_ratio().abs());// 金额_价格比例	
	
		blStIpDO.setEu_direct(BookRtnDirectEnum.CHARGE);// 结算方向
		
		// 本次结算起始时间
		blStIpDO.setDt_start(this.getLastTimeSettled(patiVisitDO));		
		
		FDateTime dateTime = AppUtils.getServerDateTime();
		blStIpDO.setDt_st(dateTime);
		FDate endDate = dt_end.getDate();
		FDate todayDate = dateTime.getDate();
		//如果结算日期小于当天日期，则使用结算日期23:59:59作为结算截止日期
		if (endDate.before(todayDate)) {
			blStIpDO.setDt_end(new FDateTime(endDate.toStdString()+" 23:59:59"));			
		} else {			
			blStIpDO.setDt_end(dateTime);			
		}		
		blStIpDO.setId_dep_st(Context.get().getDeptId());// 结算科室
		blStIpDO.setId_emp_st(id_emp);// 结算人员
		blStIpDO.setFg_cc(FBoolean.FALSE);// 结账标志
		blStIpDO.setFg_canc(FBoolean.FALSE);// 取消标志
		blStIpDO.setFg_arclear(FBoolean.TRUE);// 欠费结清标志
		blStIpDO.setFg_pay(FBoolean.FALSE);
		blStIpDO.setFg_baddebt(FBoolean.FALSE);// 坏账标志
		blStIpDO.setStatus(DOStatus.NEW);

		// 保存结算信息
		IBlstipCudService stService = ServiceFinder.find(IBlstipCudService.class);
		BlStIpDO[] blStIpDOArr = stService.save(new BlStIpDO[] { blStIpDO });
		return blStIpDOArr;
	}
	
	/**
	 * 保存本次结算信息-高级筛选
	 * 
	 * @param patiVisitDO
	 * @param cgIpDOArr
	 * @param dt_end
	 * @param id_emp
	 * @param id_dep 费用开立科室
	 * @return
	 * @throws BizException
	 */
	public BlStIpDO[] saveSettleDo(PatiVisitDO patiVisitDO,BlCgIpDO[] cgIpDOArr,String id_emp) throws BizException {
		BlStIpDO blStIpDO = new BlStIpDO();
		blStIpDO.setId_org(Context.get().getOrgId());
		blStIpDO.setId_grp(Context.get().getGroupId());
		blStIpDO.setId_pat(patiVisitDO.getId_pat());
		blStIpDO.setId_ent(patiVisitDO.getId_ent());
		
		blStIpDO.setId_hp(patiVisitDO.getId_hp());
		blStIpDO.setId_enttp(patiVisitDO.getId_entp());
		blStIpDO.setCode_enttp(patiVisitDO.getCode_entp());
		// 结算类型:10. 出院结算（出院患者）11. 中途结算（在院患者）
		if (patiVisitDO.getFg_ip().booleanValue()) {
			blStIpDO.setEu_sttp(StTypeEnum.ST_INP_MIDWAY);
		} else {
			blStIpDO.setEu_sttp(StTypeEnum.ST_INP);
		}
		// 获取结算号
		GetCodeByCustomization code_ins = new GetCodeByCustomization();
		blStIpDO.setCode_st(code_ins.GetCodeStIp());
		// 结算结果分类 结算时默认都是正常结算，付款时才区分
		blStIpDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		blStIpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);

		//获取本次结算的金额
		FDouble Amt_std = FDouble.ZERO_DBL;
		FDouble Amt_hp = FDouble.ZERO_DBL;
		FDouble Amt_pat = FDouble.ZERO_DBL;
		FDouble Amt = FDouble.ZERO_DBL;
		FDouble Amt_ratio = FDouble.ZERO_DBL;
		for(BlCgIpDO cgIpDO:cgIpDOArr){
			Integer eu_direct = cgIpDO.getEu_direct();
			if(cgIpDO.getAmt_std() != null){
				Amt_std = Amt_std.add(cgIpDO.getAmt_ratio().abs().multiply(eu_direct));
			}
			if(cgIpDO.getAmt_hp() != null){
				Amt_hp = Amt_hp.add(cgIpDO.getAmt_hp().abs().multiply(eu_direct));
			}
			if(cgIpDO.getAmt_pat() != null){
				Amt_pat = Amt_pat.add(cgIpDO.getAmt_pat().abs().multiply(eu_direct));
			}
			if(cgIpDO.getAmt() != null){
				Amt = Amt.add(cgIpDO.getAmt().abs().multiply(eu_direct));
			}
			if(cgIpDO.getAmt_ratio() != null){
				Amt_ratio = Amt_ratio.add(cgIpDO.getAmt_ratio().abs().multiply(eu_direct));
			}
			
		}
		blStIpDO.setAmt_std(Amt_std);// 总金额_标准 已废弃
		blStIpDO.setAmt_hp(Amt_hp);// 总金额_医保计划
		blStIpDO.setAmt_pat(Amt_pat);// 总金额_患者自付
		blStIpDO.setAmt(Amt);// 总金额
		blStIpDO.setAmt_ratio(Amt_ratio);// 金额_价格比例	
	
		blStIpDO.setEu_direct(BookRtnDirectEnum.CHARGE);// 结算方向
		
		// 本次结算起始时间
		blStIpDO.setDt_start(this.getLastTimeSettled(patiVisitDO));		
		
		FDateTime dateTime = AppUtils.getServerDateTime();
		blStIpDO.setDt_st(dateTime);
		FDate endDate = new FDate();
		FDate todayDate = dateTime.getDate();
		//如果结算日期小于当天日期，则使用结算日期23:59:59作为结算截止日期
		if (endDate.before(todayDate)) {
			blStIpDO.setDt_end(new FDateTime(endDate.toStdString()+" 23:59:59"));			
		} else {			
			blStIpDO.setDt_end(dateTime);			
		}		
		blStIpDO.setId_dep_st(Context.get().getDeptId());// 结算科室
		blStIpDO.setId_emp_st(id_emp);// 结算人员
		blStIpDO.setFg_cc(FBoolean.FALSE);// 结账标志
		blStIpDO.setFg_canc(FBoolean.FALSE);// 取消标志
		blStIpDO.setFg_arclear(FBoolean.TRUE);// 欠费结清标志
		blStIpDO.setFg_pay(FBoolean.FALSE);
		blStIpDO.setFg_baddebt(FBoolean.FALSE);// 坏账标志
		blStIpDO.setStatus(DOStatus.NEW);

		// 保存结算信息
		IBlstipCudService stService = ServiceFinder.find(IBlstipCudService.class);
		BlStIpDO[] blStIpDOArr = stService.save(new BlStIpDO[] { blStIpDO });
		return blStIpDOArr;
	}	

	/**
	 * 获取本次就诊最近一次结算结束时间
	 * 
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	private FDateTime getLastTimeSettled(PatiVisitDO patiVisitDO) throws BizException {
		FDateTime dt_start = null;
		String[] fields = {"dt_end"};
		String whereCond = "fg_canc = 'N' and eu_direct=1 and id_ent = '" + patiVisitDO.getId_ent() + "'";
		List<BlStIpDO> list = (List<BlStIpDO>) new DAFacade().findByCond(BlStIpDO.class, whereCond, "dt_end desc",fields);
		
		if(ListUtil.isEmpty(list)) {
			dt_start = patiVisitDO.getDt_acpt();
		} else {
			dt_start = list.get(0).getDt_end();
		}
		return dt_start;
	}
	/**
	 * 获取住院患者本次住院的最大记账时间
	 * 
	 * @return 如果空值 则返回 1900-01-01 00:00:00
	 * @throws BizException
	 * @author xuebei
	 * @time  2018-10-10
	 */
	@SuppressWarnings("unchecked")
	public FDateTime getMaxBlcgipTimeUnSettled(String strIdEnt, String fg_st) throws BizException {
		FDateTime maxTime = null;
		String[] fields = { "dt_cg"};
		String whereCond ="  nvl(fg_research,'N')='N' and id_ent = '" + strIdEnt + "'  ";
		if(!fg_st.equals("")){
			whereCond += " fg_st='"+ fg_st +"' ";
		}
		List<BlCgIpDO> list = (List<BlCgIpDO>) new DAFacade().findByCond(BlCgIpDO.class, whereCond, "dt_cg desc",
		fields);	
		if (ListUtil.isEmpty(list)) {
			maxTime = new FDateTime("1900-01-01 00:00:00");
		} else {
			maxTime = list.get(0).getDt_cg();
		}
		return maxTime;
	}
	
	/**
	 * 获取本次结算的金额
	 * @param id_ent
	 * @param id_dep
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlCgIpDO getStAmt(String id_ent,String id_dep, FDateTime dt_end) throws BizException {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select sum(amt*eu_direct) as amt,sum(amt_ratio*eu_direct) as amt_std,sum(amt_ratio*eu_direct) as amt_ratio, ");
		sql.append(" sum(amt_hp*eu_direct) as amt_hp,sum(amt_pat*eu_direct) as amt_pat ");
		sql.append(" from bl_cg_ip where ");
		sql.append(this.getSqlParam(id_ent, id_dep, dt_end));
		
		List<BlCgIpDO> list = (List<BlCgIpDO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlCgIpDO.class));
		/*不允许0元结算
		 * if(ListUtil.isEmpty(list)) {
			throw new BizException("获取结算金额失败！");
		}*/
		
		if(null == list) {//允许0元结算
			throw new BizException("获取结算金额失败！");
		}
		BlCgIpDO cgip=list.get(0);
		
		/*不允许0元结算
		 * if(cgip.getAmt()==null||FDouble.ZERO_DBL.equals(cgip.getAmt())){
			throw new BizException("获取结算金额失败！");
		}*/
		
		if(cgip.getAmt()==null){//允许0元结算
			throw new BizException("获取结算金额失败！");
		}
		
		return cgip;
	}
	/**
	 * 组合住院结算记账费用的查询条件
	 * 
	 * @param id_ent
	 * @param id_dep
	 * @param dt_end
	 * @return
	 * @throws BizException 
	 */
	public String getSqlParam(String id_ent, String id_dep, FDateTime dt_end) throws BizException {
		StringBuilder sqlQur = new StringBuilder();
		FBoolean isMerge =  BlParams.BLSTIP0005();
		IEnOutQryService inpPatAccImpls = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO entNewBorn = inpPatAccImpls.getNewbornDO(id_ent);
		if(FBoolean.TRUE.equals(isMerge)){
			
			if(entNewBorn != null){
				sqlQur.append(" FG_ST = 'N' ").append(" AND (ID_ENT = '").append(entNewBorn.getId_ent_mom()).append("' or id_ent_mom ='").append(entNewBorn.getId_ent_mom()).append("') ");
			} else {
				sqlQur.append(" FG_ST = 'N' ").append(" AND (ID_ENT = '").append(id_ent).append("' or id_ent_mom ='").append(id_ent).append("') ");
			}
		} else{
			sqlQur.append(" FG_ST = 'N' ").append(" AND ID_ENT = '").append(id_ent).append("' ");
		}
		
		// 判断如果id_dep为*则查找所有科室的就诊,否则查找单科室的就诊数据
		if (!StringUtil.isEmpty(id_dep) && !"*".equals(id_dep)) {
			sqlQur.append(" AND ID_DEP_OR = '").append(id_dep).append("' ");
		}
		String dt_end_str = dt_end.getDate().getDateAfter(1).toString()	+ " 00:00:00";
		sqlQur.append(" AND DT_CG < '").append(dt_end_str).append("' ");
		return sqlQur.toString();
	}
}
