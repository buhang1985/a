package iih.bl.itf.std.bp.ipcharge;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.ipsettle.WsParamIpSettle;
import iih.bl.itf.std.bean.input.ipsettle.sub.WsParamIpSettleInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.settle.WsResultIpSettle;
import iih.bl.itf.std.bean.output.settle.WsResultIpSettleInfo;
import iih.bl.itf.std.bean.output.settle.sub.WsResultIPPrepayInfo;
import iih.bl.itf.std.bean.output.settle.sub.WsResultIPTotalcostInfo;
import iih.bl.itf.std.bean.output.settle.sub.WsResultIPTypecostInfo;
import iih.bl.itf.std.bean.output.settle.sub.WsResultIPcost;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.bl.params.BlParams;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.i.IBlStCmdService;
import iih.bl.st.i.IBlStQryService;
import iih.bl.st.i.IBlStValidateService;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院自助结算功能完成类
 * @author hanjq 下午4:10:51
 */
public class SettlementBP extends BlItfBaseBP<WsParamIpSettle,WsResultIpSettle>{

	private InpatientDO inpatientDo;//住院信息
	private IEnOutQryService enOutQryService;
	private IBlStQryService blStQryService;
	private IBlStCmdService  blStCmdService ;
	private PatiVisitDO patiVisitDO;//就诊信息
	private Context ctx ;
	private PsnDocDO psndocDO;
	//判断患者是否在院或出院结算  true：已出院 false：未出院
	private FBoolean isSettled ;
	
	public SettlementBP() {
		enOutQryService = ServiceFinder.find(IEnOutQryService.class);
		blStQryService = ServiceFinder.find(IBlStQryService.class);
		blStCmdService = ServiceFinder.find(IBlStCmdService.class);
		ctx = Context.get();
	}

	@Override
	protected String getBusiness() {
		return "住院自助结算";
	}

	@Override
	protected void checkParam(WsParamIpSettle param) throws BizException {
		//1.验证患者是否是出院待结算状态
		//1.1找到患者住院信息
		psndocDO = super.getPsnInfo(param.getPrepay().getOperaCode());
		if (psndocDO == null) {
			throw new BizException("住院自助结算:未查询到人员信息");
		}
		ctx.setStuffId(psndocDO.getId_psndoc());
		ctx.setDeptId(psndocDO.getId_dep());
		
		inpatientDo = this.findPat(param.getPrepay());
		if(inpatientDo == null){
			throw new BizException("住院自助结算:未查询到患者住院信息");
		}
		patiVisitDO = ServiceFinder.find(IPativisitRService.class).findById(inpatientDo.getId_ent());
		if(StringUtils.isNotBlank(patiVisitDO.getId_hp())){
			throw new BizException("住院自助结算:不支持医保结算");
		}
		if(FBoolean.TRUE.equals(patiVisitDO.getFg_ip())){
			throw new BizException("住院自助结算:患者未出院");
		}
		if(FBoolean.TRUE.equals(patiVisitDO.getFg_canc())){
			throw new BizException("住院自助结算：该患者已退院，不能结算");
		}
		Boolean isRcByOutPay = this.canRcByOutPay(patiVisitDO.getId_ent(), patiVisitDO.getFg_ip());
		// 充值之前判断一下如果患者出院并且付款之后，则不让充值
		if (isRcByOutPay) {
			throw new BizException("住院自助结算:出院并且收付款完成后不可结算");
		}
		
		FBoolean isFreezed = blStQryService.getPatiEntAccStatusInfo(inpatientDo.getId_ent());
		if(FBoolean.TRUE.equals(isFreezed)){
			throw new BizException("住院自助结算:该患者费用已经封账冻结");
		}
		FBoolean BLSTIP0005 = BlParams.BLSTIP0005();//母婴合并模式
		if(FBoolean.TRUE.equals(BLSTIP0005) && enOutQryService.getNewbornDO(inpatientDo.getId_ent()) != null){
			throw new BizException("母婴合并结算模式，请用使用母亲患者编码或就诊号进行结算！");
		}
		
		isSettled = enOutQryService.hasSettled(inpatientDo.getId_ent());
		if(FBoolean.FALSE.equals(isSettled)){
			IBlStValidateService service = ServiceFinder.find(IBlStValidateService.class);
			String errorMsg = service.ipStLoadInValidate(inpatientDo.getId_ent());
			if(StringUtils.isNotBlank(errorMsg)){
				throw new BizException("住院自助结算:"+errorMsg);
			}
		}		
	}
	
	@Override
	protected WsResultIpSettle doWork(WsParamIpSettle param) throws BizException {
		//2.住院预交金金额大于等于消费金额		
		String idStIp = null;
		if(FBoolean.FALSE.equals(isSettled)){
			//1.审核
			dealIpAudit(patiVisitDO.getId_ent());
			//2.调入
			
			//3.结算
			idStIp = blStCmdService.doSettlement(patiVisitDO.getId_pat(), patiVisitDO.getId_ent(), "*", ctx.getStuffId(), new FDateTime());
		}
		//4.设置返回数据
		WsResultIpSettle rlt = new WsResultIpSettle();
		
		WsResultMsg rltMsg = new WsResultMsg();
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		
		WsResultIpSettleInfo rltInfo = new WsResultIpSettleInfo();
		rltInfo.setPayNO(getCodeSt(patiVisitDO.getId_ent(), idStIp));		
		WsResultIPcost IPcost = new WsResultIPcost();
		WsResultIPTotalcostInfo IPTotalcostInfo = getIPTotalcostInfo(patiVisitDO.getId_ent(),patiVisitDO.getId_pat());
		List<WsResultIPPrepayInfo> IPPrepayInfo = getIPPrepayInfo(patiVisitDO.getId_ent());
		List<WsResultIPTypecostInfo> IPTypecostInfo = getIPTypecostInfo(patiVisitDO.getId_ent());
		IPcost.setIPTotalcostInfo(IPTotalcostInfo);
		IPcost.setIPPrepayInfo(IPPrepayInfo);
		IPcost.setIPTypecostInfo(IPTypecostInfo);
		rltInfo.setIPcost(IPcost);
		
		rlt.setRltMsg(rltMsg);
		rlt.setRltInfo(rltInfo);
		return rlt;
	}
	/**
	 * 获取账单分类费用
	 * @author : hanjq 2019年10月24日 下午5:33:34
	 * @param idEnt
	 * @return
	 * @throws DAException 
	 */
	private List<WsResultIPTypecostInfo> getIPTypecostInfo(String idEnt) throws DAException {
		StringBuilder bd = new StringBuilder();
		bd.append("select code_inccaitm typeCode,		");
		bd.append("		name_inccaitm typeName,			");
		bd.append("		sum(amt * eu_direct * 100) typeAmount	");
		bd.append(" from bl_cg_ip	");
		bd.append("where id_ent = ?					");
		bd.append("group by code_inccaitm,name_inccaitm	");
		bd.append("order by code_inccaitm,name_inccaitm	");
		SqlParam par = new SqlParam();
		par.addParam(idEnt);
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<WsResultIPTypecostInfo> list = (List<WsResultIPTypecostInfo>) daf.execQuery(bd.toString(), par, new BeanListHandler(WsResultIPTypecostInfo.class));
		return list;
	}

	/**
	 * 住院预交金汇总
	 * @author : hanjq 2019年10月24日 下午5:23:55
	 * @param id_ent
	 * @return
	 * @throws DAException 
	 */
	private List<WsResultIPPrepayInfo> getIPPrepayInfo(String idEnt) throws DAException {
		StringBuilder bd = new StringBuilder();
		bd.append("select pre.code_rep prepayNO,	");
		bd.append("		pre.amt * 100 prepayment,	");
		bd.append("		pre.bankno documentNumber,	");
		bd.append(" 	pre.sd_pm paymentMethod,	");
		bd.append(" 	pre.paymodenode orderNumber,");
		bd.append(" 	pre.dt_pay payTime,			");
		bd.append(" 	psn.code operaCode			");
		bd.append("from bl_prepay_pat pre			");
		bd.append("join bd_psndoc psn on psn.id_psndoc = pre.id_emp_pay	");
		
		bd.append("where pre.id_ent	= ?				");
		bd.append("		and pre.Eu_direct = 1		");
		bd.append("		and pre.Fg_rep_return = 'N'	");
		bd.append("		and pre.Fg_canc = 'N'		");
		bd.append("		and pre.Sd_paytp in ('14', '15', '17', '18')	");
		bd.append("	order by pre.dt_pay				");
		SqlParam par = new SqlParam();
		par.addParam(idEnt);
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<WsResultIPPrepayInfo> list = (List<WsResultIPPrepayInfo>) daf.execQuery(bd.toString(), par, new BeanListHandler(WsResultIPPrepayInfo.class));
		return list;
	}

	/**
	 * 获取住院总费用汇总
	 * @author : hanjq 2019年10月24日 下午3:44:44
	 * @param id_ent
	 * @param enaccDO
	 * @return
	 * @throws BizException 
	 */
	private WsResultIPTotalcostInfo getIPTotalcostInfo(String idEnt, String idPat) throws BizException {
		EnAccountDO enaccDO = getEnAccountDO(idEnt, idPat);
		FDouble balance = enaccDO.getAmt_prepay().sub(enaccDO.getAmt_uncg());//预交金可用总额
		StringBuilder bd = new StringBuilder();
		String day = new FDate().toString()+"%";
		bd.append("select sum(totalAmt) * 100 totalAmt, ");
		bd.append("		sum(unsettled) * 100 unsettled,");
		bd.append("		sum(settled) * 100 settled,");
		bd.append(" 	sum(dayAmt)  * 100 dayAmt ");
		bd.append("from (select amt * eu_direct totalAmt,	");
		bd.append("		decode(fg_st, 'N', amt * eu_direct, 0) unsettled, ");
		bd.append("		decode(fg_st, 'Y', amt * eu_direct, 0) settled,   ");
		bd.append("		case when dt_cg like '").append(day).append("' then  ");
		bd.append("		amt * eu_direct else  0  end dayAmt  ");
		bd.append("		from bl_cg_ip where id_ent = ? ) ");
		SqlParam par = new SqlParam();
		par.addParam(idEnt);
		DAFacade daf = new DAFacade();		
		WsResultIPTotalcostInfo info = (WsResultIPTotalcostInfo) daf.execQuery(bd.toString(), par,new BeanHandler(WsResultIPTotalcostInfo.class));
		if(info == null){
			info = new WsResultIPTotalcostInfo();
		}
		info.setPrepayment(BlAmtConverUtil.toXmlString(enaccDO.getAmt_prepay()));
		if(balance.compareTo(FDouble.ZERO_DBL) >= 0){
			info.setBalance(BlAmtConverUtil.toXmlString(balance));
		}else{
			info.setBalance("0");
			info.setNote("欠费敬告：您的预交金已用完，请速到收费处补交"+balance+"元 预交金，才能自助结算");
		}		
		return info;
	}
	
	/**
	 * 查找住院信息
	 * @author : hanjq 2019年10月24日 下午4:30:04
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private InpatientDO findPat(WsParamIpSettleInfo prepayInfo) throws BizException {

		IInpatientRService service = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] entIpDos = service.findByAttrValString(InpatientDO.CODE_AMR_IP, prepayInfo.getIPCode());
		if (ArrayUtil.isEmpty(entIpDos)) {
			throw new BizException("住院自助结算:未查询到患者住院信息");
		}
		// 最大住院次数数据
		InpatientDO entIpDo = null;
		int ip_times = Integer.parseInt(prepayInfo.getEnTimes());
		for (InpatientDO inpatientDO : entIpDos) {
			if (inpatientDO.getTimes_ip() == ip_times) {
				entIpDo = inpatientDO;
			}
		}
		return entIpDo;
	}
	
	/**
	 * 查询患者账户
	 * @author : hanjq 2019年10月24日 下午1:16:30
	 * @param id_ent
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private EnAccountDO  getEnAccountDO(String id_ent,String id_pat)throws BizException{   // 住院账户（右侧余额）
        StringBuffer sb=new StringBuffer();
	  
	    sb.append("	SELECT  B.amt_cred,B.amt_owelimit,B.amt_prepay,B.amt_uncg,B.ds,B.dt_backcg,B.dt_backcglastact,B.id_ent,B.id_entacc,B.id_pat,B.sv ");
		sb.append("	FROM EN_ENT A");
	    sb.append("	JOIN EN_ENT_ACC B ON A.ID_ENT = B.ID_ENT  WHERE  A.ID_ENT =? AND A.ID_PAT =? ");
	    SqlParam sp=new SqlParam();
	    sp.addParam(id_ent);
		sp.addParam(id_pat);
	   
		@SuppressWarnings("unchecked")
		List<EnAccountDO> list= (List<EnAccountDO>)new DAFacade().execQuery(sb.toString(),sp,new BeanListHandler(EnAccountDO.class));
		 if(!(list.isEmpty())&&list.size()>0){
			 EnAccountDO[] bldos= list.toArray(new EnAccountDO[0]);
			 return bldos[0]; 
		 }else {
			  return null;
		 }
	}
	
	/**
	 * 判断一下如果患者出院并且付款之后，则不让结算
	 * 
	 * @return
	 * @throws BizException
	 */
	private Boolean canRcByOutPay(String entId, FBoolean fg_ip) throws BizException {
		// 最终返回值
		Boolean fg_final = false;
		// 是否收付款
		FBoolean fg_pay = FBoolean.FALSE;

		IBlstipRService iBlStIpService = ServiceFinder.find(IBlstipRService.class);
		//出院结算判断是否收付款 
		BlStIpDO[] blStDOs = iBlStIpService.find(" id_ent = '" + entId + "' and eu_sttp = '10' and fg_canc = 'N' ", "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(blStDOs)) {
			fg_pay = blStDOs[0].getFg_pay();
		}

		if (!fg_ip.booleanValue() && fg_pay.booleanValue()) {
			fg_final = true;
		}

		return fg_final;
	}
	
	/**
	 * 处理住院审核
	 * @author : hanjq 2019年10月24日 下午1:47:27
	 * @param idEnt
	 * @throws BizException 
	 */
	private void dealIpAudit(String idEnt) throws BizException{
		DAFacade daf = new DAFacade();
		String sql = "select * from bl_audit_ip where fg_active = 'Y' and id_ent =?";
		SqlParam par = new SqlParam();
		par.addParam(idEnt);
		@SuppressWarnings("unchecked")
		List<BlAuditIp> list = (List<BlAuditIp>) daf.execQuery(sql, par, new BeanListHandler(BlAuditIp.class));
		if(list == null || list.size() == 0 || FBoolean.FALSE.equals(list.get(0).getFg_pass_clinic())){
			OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
			operatorInfoDTO.setId_dep(ctx.getDeptId());
			operatorInfoDTO.setId_grp(ctx.getGroupId());
			operatorInfoDTO.setId_org(ctx.getOrgId());
			operatorInfoDTO.setId_org_emp(psndocDO.getId_org());
			operatorInfoDTO.setId_emp(ctx.getStuffId());
			blStCmdService.saveIpAudit(idEnt, operatorInfoDTO);
		}		
	}
	
	/**
	 * 查询结算号
	 * @author : hanjq 2019年10月24日 下午3:02:08
	 * @param idEnt
	 * @param idStIp
	 * @return
	 * @throws DAException 
	 */
	private String getCodeSt(String idEnt,String idStIp) throws DAException{
		StringBuilder bd = new StringBuilder();
		SqlParam par = new SqlParam();
		bd.append("select code_st from( ");
		bd.append("select code_st from bl_st_ip where  fg_pay = 'N' and fg_canc = 'N' and eu_sttp = '10' ");
		
		if(StringUtils.isNotBlank(idStIp)){
			bd.append(" and id_stip = ? ");
			par.addParam(idStIp);
		}else{
			bd.append(" and id_ent = ? order by sv desc");
			par.addParam(idEnt);
		}
		bd.append(") where rownum = 1 ");
		
		DAFacade daf = new DAFacade();
		String codeSt = (String) daf.execQuery(bd.toString(), par, new ColumnHandler());
		return codeSt;		
	}

}
