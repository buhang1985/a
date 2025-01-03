package iih.bl.itf.std.bp.ipcharge;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.ippay.WsParamIpPay;
import iih.bl.itf.std.bean.input.ippay.sub.WsParamIpChange;
import iih.bl.itf.std.bean.input.ippay.sub.WsParamIpPayInfo;
import iih.bl.itf.std.bean.input.ippay.sub.WsParamIpPayment;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.ippay.WsResultIpPay;
import iih.bl.itf.std.bean.output.ippay.WsResultIpPayInfo;
import iih.bl.itf.std.bean.output.ippay.sub.WsResultIPPayInc;
import iih.bl.itf.std.bean.output.ippay.sub.WsResultIpPayStInfo;
import iih.bl.itf.std.bean.output.settle.sub.WsResultIPTypecostInfo;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.i.IBlPayCmdService;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.dto.blpayip.d.BlPayIpDTO;
import iih.bl.st.dto.blpayip.d.BlPayIpPmDTO;
import iih.bl.st.dto.blpayip.d.BlPayIpRltDTO;
import iih.bl.st.i.IBlStCmdService;
import iih.bl.st.i.IBlStQryService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院自助支付功能完成类
 * @author hanjq 2019-10-25 下午4:10:51
 */
public class PaymentBP extends BlItfBaseBP<WsParamIpPay,WsResultIpPay>{

		
	private InpatientDO inpatientDo;//住院信息
	private BlStIpDO blStIpDo;//结算信息
//	private OperatorInfoDTO operatorInfo;//操作人员信息
	private BlPayPatIpDO blPayPatIpDo;//住院患者结算收付款 DO数据
	
	private BlPayIpDTO payIpDto;//支付汇总
	private BlPayIpPmDTO[] payIpPmDtos;//支付明细
	private HashMap<String, PriPmDO> priPmMap;//支付方式
	private IBlPayCmdService BlPayCmdService;
	private IEnOutQryService enOutQryService;
	private IBlStQryService blStQryService;
	private IBlStCmdService  blStCmdService ;
	private PatiVisitDO patiVisitDO;//就诊信息
	private Context ctx ;
	private PsnDocDO psndocDO;
	
	private WsParamIpPayInfo prepay;//入参
	
	public PaymentBP() throws BizException {
		BlPayCmdService = ServiceFinder.find(IBlPayCmdService.class);
		
		enOutQryService = ServiceFinder.find(IEnOutQryService.class);
		blStQryService = ServiceFinder.find(IBlStQryService.class);
		blStCmdService = ServiceFinder.find(IBlStCmdService.class);
		payIpDto = new BlPayIpDTO();
		ctx = Context.get();
		SetPriPmMap();
	}

	@Override
	protected String getBusiness() {
		return "住院结算";
	}

	@Override
	protected void checkParam(WsParamIpPay param) throws BizException {
		//1.设置上下文
		prepay = param.getPrepay();
		if(prepay == null){
			throw new BizException("住院自助支付:入参为空");
		}
		if(!"02".equals(prepay.getEntpCode())){
			throw new BizException("住院自助支付:不支持门诊业务");
		}
		if(!"02".equals(prepay.getTerminalType())){
			throw new BizException("住院自助支付:只支持自助机");
		}
		psndocDO = super.getPsnInfo(prepay.getOperaCode());
		if (psndocDO == null) {
			throw new BizException("住院自助支付:未查询到人员信息");
		}
		ctx.setStuffId(psndocDO.getId_psndoc());
		ctx.setDeptId(psndocDO.getId_dep());
		//2.找到住院信息
		
		inpatientDo = findPat(prepay);
		if(inpatientDo == null){
			throw new BizException("住院自助支付:未查询到住院信息");
		}
		patiVisitDO = ServiceFinder.find(IPativisitRService.class).findById(inpatientDo.getId_ent());
		if(StringUtils.isNotBlank(patiVisitDO.getId_hp())){
			throw new BizException("住院自助支付:不支持医保结算");
		}
		if(FBoolean.TRUE.equals(patiVisitDO.getFg_ip())){
			throw new BizException("住院自助支付:患者未出院");
		}
		if(FBoolean.TRUE.equals(patiVisitDO.getFg_canc())){
			throw new BizException("住院自助支付：该患者已退院");
		}
		FBoolean isFreezed = blStQryService.getPatiEntAccStatusInfo(inpatientDo.getId_ent());
		if(FBoolean.TRUE.equals(isFreezed)){
			throw new BizException("住院自助结算:该患者费用已经封账冻结");
		}
		FBoolean BLSTIP0005 = BlParams.BLSTIP0005();//母婴合并模式
		if(FBoolean.TRUE.equals(BLSTIP0005) && enOutQryService.getNewbornDO(inpatientDo.getId_ent()) != null){
			throw new BizException("母婴合并结算模式，请用使用母亲患者编码或就诊号进行结算！");
		}
		
		//3.找到结算信息
		blStIpDo = getBlStIpDO(prepay.getPayNO());
		if(blStIpDo == null){
			throw new BizException("住院自助支付:未查询到未支付的结算信息");
		}
		if (FBoolean.TRUE.equals(blStIpDo.getFg_pay())) {
			throw new BizException("住院自助支付:出院并且收付款完成后不可再次支付");
		}
		//5.拼装收付款信息
		payIpDto.setAmt(blStIpDo.getAmt());
		payIpDto.setId_ent(blStIpDo.getId_ent());
		payIpDto.setId_st(blStIpDo.getId_stip());
		payIpDto.setFg_arrears(FBoolean.FALSE);
//		payIpDto.setReceiptno(Receiptno);
		payIpDto.setSd_pttp(prepay.getTerminalType());
		payIpDto.setFg_print(FBoolean.FALSE);
		
		FDouble Amt_pay = FDouble.ZERO_DBL;//支付金额
		FDouble Amt_charge = FDouble.ZERO_DBL;//找零金额	
		List<WsParamIpPayment> payments = prepay.getPaymentList();
		List<BlPayIpPmDTO> prePays = getIPPrepayPmDTOs(blStIpDo.getId_ent());
		if(prePays == null){
			prePays = new ArrayList<>();
		}
		if(prePays.size()> 0){
			for(BlPayIpPmDTO itm: prePays){
				Amt_pay = Amt_pay.add(itm.getAmt());
			}
		}
		
		if(payments != null && payments.size() > 0){
			for(WsParamIpPayment itm:payments){
				BlPayIpPmDTO payIpPm = new BlPayIpPmDTO();
				if(!BlAmtConverUtil.isNumeric(itm.getPayMoney())){
					throw new BizException("住院自助支付:支付金额“"+itm.getPayMoney()+"”非数字格式");
				}
				PriPmDO pmDo = priPmMap.get(itm.getPaymentMethod());
				if(pmDo == null){
					throw new BizException("住院自助支付:不支持的支付方式“"+itm.getPaymentMethod()+"”");
				}
				payIpPm.setId_pm(pmDo.getId_pm());
				payIpPm.setSd_pm(itm.getPaymentMethod());
				payIpPm.setAmt(BlAmtConverUtil.toFDouble(itm.getPayMoney()));
				payIpPm.setBankno(itm.getDocumentNumber());
				payIpPm.setPaymodenode(itm.getOrderNumber());
				payIpPm.setEu_direct(1);
				payIpPm.setFg_charge(FBoolean.FALSE);
				payIpPm.setFg_transfer(FBoolean.FALSE);
				payIpPm.setFg_refund_manual(FBoolean.FALSE);
				prePays.add(payIpPm);
				Amt_pay = Amt_pay.add(payIpPm.getAmt());
			}
			
		}
		//增加一条找零数据
		Amt_charge = Amt_pay.sub(blStIpDo.getAmt_ratio());
		if(!StringUtil.isEmpty(prepay.getFgChangeTf()) && "N".equals(prepay.getFgChangeTf())){
			if(Amt_charge.compareTo(FDouble.ZERO_DBL) > 0){
				//找零不结转，第三方原路返回
				if(ListUtil.isEmpty(prepay.getChangeList())){
					throw new BizException("住院收付款：入参找零信息为空");
				}
				this.noCarryOverChange(prepay.getChangeList(),Amt_charge,blStIpDo.getId_ent(),prePays);
			}else if(Amt_charge.compareTo(FDouble.ZERO_DBL) < 0){
				throw new BizException("住院收付款:支付金额还差“"+Amt_charge.multiply(-1).setScale(2,BigDecimal.ROUND_HALF_UP)+"”元");
			}
		}else{
			//找零现金结转
			if(Amt_charge.compareTo(FDouble.ZERO_DBL) > 0){
				BlPayIpPmDTO payIpPm = new BlPayIpPmDTO();
				PriPmDO pmDo = priPmMap.get("01");
				payIpPm.setId_pm(pmDo.getId_pm());
				payIpPm.setSd_pm(pmDo.getCode());
				payIpPm.setAmt(Amt_charge);
				payIpPm.setEu_direct(-1);
				payIpPm.setFg_charge(FBoolean.TRUE);
				payIpPm.setFg_transfer(FBoolean.TRUE);
				payIpPm.setFg_refund_manual(FBoolean.FALSE);
				prePays.add(payIpPm);
			}
			else if(Amt_charge.compareTo(FDouble.ZERO_DBL) < 0){
				throw new BizException("住院自助支付:支付金额还差“"+Amt_charge.multiply(-1).setScale(2,BigDecimal.ROUND_HALF_UP)+"”元");
			}
		}

		payIpPmDtos = prePays.toArray(new BlPayIpPmDTO[0]);
		payIpDto.setAmt_pay(Amt_pay);
		payIpDto.setAmt_charge(Amt_charge);
		
		blPayPatIpDo = new BlPayPatIpDO();
		blPayPatIpDo.setId_stip(blStIpDo.getId_stip());
		blPayPatIpDo.setAmt(Amt_pay);
		blPayPatIpDo.setId_pat(blStIpDo.getId_pat());
		blPayPatIpDo.setId_ent(blStIpDo.getId_ent());		
		blPayPatIpDo.setSd_pttp(prepay.getTerminalType());
		
	}
	
	@Override
	protected WsResultIpPay doWork(WsParamIpPay param) throws BizException {
		//1 付款
		BlPayIpRltDTO rlt = BlPayCmdService.ipPayment(payIpDto, payIpPmDtos, null);
		WsResultIpPay result = new WsResultIpPay();
		WsResultMsg rltMsg = new WsResultMsg();
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		List<WsResultIPPayInc> incList = getIncInfo(rlt.getId_incip());
		WsResultIpPayStInfo stinfo2 = getIpPayStInfo(blStIpDo.getId_stip());
		
		String mlType = getMlType(stinfo2.getMlType());
		
		WsResultIpPayStInfo stinfo = new WsResultIpPayStInfo(blStIpDo.getCode_st(), mlType, stinfo2.getHpType(), stinfo2.getHpNO(), stinfo2.getMlName(), psndocDO.getCode(), blStIpDo.getDt_st().toString(), stinfo2.getPrepayment(),
				BlAmtConverUtil.toXmlString(payIpDto.getAmt()), stinfo2.getEntselfAmout(), stinfo2.getEnthpcardAmout(), stinfo2.getEnthpAmout(), BlAmtConverUtil.toXmlString(payIpDto.getAmt_charge()), incList);
		WsResultIpPayInfo rstinfo = new WsResultIpPayInfo(psndocDO.getCode(), prepay.getTerminalType(), prepay.getTerminalNO(),
				prepay.getInctype(), stinfo, "");
		
		result.setRltMsg(rltMsg);
		result.setRstinfo(rstinfo);
		return result;
	}
	private String getMlType(String mlType){
		if(StringUtils.isBlank(mlType)){
			return "未维护医卫组织";
		}
		int key = Integer.parseInt(mlType);
		switch (key) {
		case 11:
			mlType = "一级丙等";
			break;
		case 12:
			mlType = "一级乙等";
			break;
		case 13:
			mlType = "一级甲等";
			break;
		case 14:
			mlType = "一级未定等";
			break;
			
		case 21:
			mlType = "二级丙等";
			break;
		case 22:
			mlType = "二级乙等";
			break;
		case 23:
			mlType = "二级甲等";
			break;
		case 24:
			mlType = "二级未定等";
			break;
		case 31:
			mlType = "三级丙等";
			break;
		case 32:
			mlType = "三级乙等";
			break;
		case 33:
			mlType = "三级甲等";
			break;
		case 34:
			mlType = "三级未定等";
			break;
		default:
			mlType = "未测定";
			break;
		}
		return mlType;
	}
	/**
	 * 获取医保等其他信息
	 * @author : hanjq 2019年10月25日 下午4:06:47
	 * @param id_stip
	 * @return
	 * @throws DAException 
	 */
	private WsResultIpPayStInfo getIpPayStInfo(String idStip) throws DAException {
		SqlParam par = new SqlParam();
		par.addParam(idStip);
		DAFacade daf = new DAFacade();
		
		StringBuilder bd = new StringBuilder();
		bd.append("select hisorg.medorglevel mlType,patca.name hpType, hpent.no_hp hpNO,					");
		bd.append("	org.name mlName , to_char(acc.amt_prepay * 100) prepayment ,							");
		bd.append(" to_char((st.amt_ratio - nvl(PROPAR.Amt_Hp,0) - nvl(PROPAR.Amt_Psnacc,0))*100) entselfAmout,");
		bd.append("	to_char(nvl(PROPAR.Amt_Psnacc,0)*100) enthpcardAmout , to_char(nvl(PROPAR.Amt_Hp,0)*100) enthpAmout	");
		
		bd.append("	from bl_st_ip st							");
		bd.append("	join bd_org org on org.id_org = st.id_org							");
		bd.append("	left join bd_hisorg hisorg on hisorg.code = org.code				");
		bd.append("	join en_ent ent on ent.id_ent = st.id_ent							");
		bd.append("	join EN_ENT_ACC acc ON acc.ID_ENT = ent.ID_ENT						");
		bd.append("	left join bl_hp_entcode hpent on hpent.id_ent = st.id_ent and hpent.no_hp is not null	");
		bd.append("	left JOIN BL_PROP_IP PROP ON PROP.ID_STIP = st.ID_STIP				");
		bd.append("	left JOIN BL_PROP_AR_IP PROPAR ON PROPAR.ID_PROPIP = PROP.ID_PROPIP and PROPAR.Eu_Direct = 1		");
		bd.append("	left join pi_pat_ca patca on patca.id_patca = decode(st.id_patca,'~',ent.id_patca,st.id_patca)		");
		
		bd.append("	where st.id_stip = ?							");
		WsResultIpPayStInfo info = (WsResultIpPayStInfo) daf.execQuery(bd.toString(), par, new BeanHandler(WsResultIpPayStInfo.class));
		if(info == null){
			info = new WsResultIpPayStInfo();
		}
		return info;
	}

	/**
	 * 获取发票账单分类费用
	 * @author : hanjq 2019年10月24日 下午5:33:34
	 * @param fArrayList
	 * @return
	 * @throws DAException 
	 */
	private List<WsResultIPPayInc> getIncInfo(FArrayList idIncs) throws DAException {
		if(idIncs != null && idIncs.size() > 0){
			StringBuilder bd = new StringBuilder();
			bd.append("select    inc.incno name_account,cg.code_inccaitm,			");
			bd.append("		cg.name_inccaitm,sum(cg.amt * cg.eu_direct) amt	");
			bd.append("	from bl_cg_ip  cg											");
			bd.append(" join bd_incca_itm caitm on caitm.code = cg.code_inccaitm	");
			bd.append("	join bl_inc_ip inc on inc.id_incca = caitm.id_incca			");
			bd.append("where inc.id_incip in 										(");
			for(int i = 0 , size = idIncs.size() ; i < size;i++){
				String idInc = (String) idIncs.get(i);
				if(i > 0){
					bd.append(",");
				}
				bd.append("'").append(idInc).append("'");
			}
			bd.append(") and inc.incno is not null									");
			bd.append("group by inc.incno,cg.code_inccaitm,cg.name_inccaitm			");
			bd.append("order by inc.incno,cg.code_inccaitm,cg.name_inccaitm			");
			DAFacade daf = new DAFacade();
			@SuppressWarnings("unchecked")
			List<BlCgIpDO> list = (List<BlCgIpDO>) daf.execQuery(bd.toString(), new BeanListHandler(BlCgIpDO.class));
			if(list != null && list.size() > 0){
				ArrayList<WsResultIPPayInc> result = new ArrayList<>();
				HashSet<String> incnos = new HashSet<>();
				WsResultIPPayInc payInc = null;
				ArrayList<WsResultIPTypecostInfo> iPTypecostInfo = null;
				for(BlCgIpDO cgIp : list){
					WsResultIPTypecostInfo info = new WsResultIPTypecostInfo(cgIp.getCode_inccaitm(), cgIp.getName_inccaitm(), BlAmtConverUtil.toXmlString(cgIp.getAmt()));
					if(!incnos.contains(cgIp.getName_account())){
						incnos.add(cgIp.getName_account());
						if(payInc == null){
							//新增发票1
							payInc = new WsResultIPPayInc();
							iPTypecostInfo = new ArrayList<>();
							payInc.setIncNo(cgIp.getName_account());
						}else{
							//设置发票1明细
							payInc.setIPTypecostInfo(iPTypecostInfo);
							result.add(payInc);
							//新增发票2
							payInc = new WsResultIPPayInc();
							payInc.setIncNo(cgIp.getName_account());
							iPTypecostInfo = new ArrayList<>();
						}						
					}
					iPTypecostInfo.add(info);
				}
				
				//设置发票2明细
				payInc.setIPTypecostInfo(iPTypecostInfo);
				result.add(payInc);
				return result;
			}
		}		
		return null;
	}

	/**
	 * 查找住院信息
	 * @author : hanjq 2019年10月24日 下午4:30:04
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private InpatientDO findPat(WsParamIpPayInfo prepayInfo) throws BizException {

		IInpatientRService service = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] entIpDos = service.findByAttrValString(InpatientDO.CODE_AMR_IP, prepayInfo.getIPCode());
		if (ArrayUtil.isEmpty(entIpDos)) {
			throw new BizException("住院结算:未查询到患者住院信息");
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
	 * 查询住院结算信息
	 * @author : hanjq 2019年10月25日 上午11:01:05
	 * @param codeSt
	 * @return
	 * @throws DAException
	 */
	private BlStIpDO getBlStIpDO(String codeSt) throws DAException{
		StringBuilder bd = new StringBuilder();
		SqlParam par = new SqlParam();
		bd.append("select * from bl_st_ip where code_st = ? and fg_pay = 'N' and fg_canc = 'N' and eu_sttp = '10' ");
		par.addParam(codeSt);
		DAFacade daf = new DAFacade();
		BlStIpDO blStIpDO = (BlStIpDO) daf.execQuery(bd.toString(), par, new BeanHandler(BlStIpDO.class));
		return blStIpDO;		
	}
	
	/**
	 * 设置支付方式map
	 * @author : hanjq 2019年10月25日 上午11:41:42
	 * @throws BizException
	 */
	private void SetPriPmMap() throws BizException{
		priPmMap = new HashMap<>();
		IPripmRService service = ServiceFinder.find(IPripmRService.class);
		PriPmDO[] priPms = service.find("1=1", "", FBoolean.FALSE);
		for(PriPmDO pm:priPms){
			priPmMap.put(pm.getCode(), pm);
		}
	}
	
	private List<BlPayIpPmDTO> getIPPrepayPmDTOs(String idEnt) throws DAException {
		PriPmDO pmDo = priPmMap.get("05");
		StringBuilder bd = new StringBuilder();
		
		bd.append("select pre.Id_paypat Id_paypat,	");
		bd.append("'").append(pmDo.getId_pm()).append("' Id_pm,		");
		bd.append("'").append(pmDo.getCode()).append("' Sd_pm,		");
		bd.append("		pre.amt  Amt,				");
		bd.append("		pre.bankno Bankno,			");
		bd.append(" 	pre.paymodenode Paymodenode,");
		bd.append(" 	1 Eu_direct,				");
		bd.append(" 	'N' Fg_charge,			");
		bd.append(" 	'N' Fg_refund_manual,			");
		bd.append(" 	'N' Fg_transfer			");
		bd.append("from bl_prepay_pat pre			");
		
		bd.append("where pre.id_ent	= ?				");
		bd.append("		and pre.Eu_direct = 1		");
		bd.append("		and pre.Fg_rep_return = 'N'	");
		bd.append("		and pre.Fg_canc = 'N'		");
		bd.append("		and pre.Sd_paytp in ('12','14', '15', '17', '18')	");
		bd.append("	order by pre.dt_pay				");
		SqlParam par = new SqlParam();
		par.addParam(idEnt);
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<BlPayIpPmDTO> list = (List<BlPayIpPmDTO>) daf.execQuery(bd.toString(), par, new BeanListHandler(BlPayIpPmDTO.class));
		return list;
	}
	
	/**
	 * 校验入参找零信息
	 * @param changeInfo
	 * @throws BizException 
	 */
	private void noCarryOverChange(List<WsParamIpChange> changeInfo,FDouble Amt_charge,String entId,List<BlPayIpPmDTO> prePays) throws BizException{
		
		FDouble inputChangeAmt = FDouble.ZERO_DBL;//入参找零金额总和（单位元）
		for (WsParamIpChange itm : changeInfo) {
			if(StringUtil.isEmpty(itm.getDocumentNumber()) && StringUtil.isEmpty(itm.getOrderNumber())){
				throw new BizException("住院收付款：入参找零信息订单号和流水号不能全为空");
			}
			if(StringUtil.isEmpty(itm.getChangeMethod())){
				throw new BizException("住院收付款：入参找零信息找零支付方式不能为空");
			}
			if(StringUtil.isEmpty(itm.getChangeMoney())){
				throw new BizException("住院收付款：入参找零信息找零金额不能为空");
			}
			if(!BlAmtConverUtil.isNumeric(itm.getChangeMoney())){
				throw new BizException("住院收付款：入参找零信息找零金额值不正确");
			}
			inputChangeAmt = inputChangeAmt.add(BlAmtConverUtil.toFDouble(itm.getChangeMoney()));
		}
		
		if(inputChangeAmt.compareTo(Amt_charge) != 0){
			throw new BizException("住院收付款：入参找零信息总金额值与需要找零总金额值不一致，需要找零总金额："+Amt_charge+"元");
		}
		
		//获取本次就诊患者住院可使用预交金集合
		List<BlPrePayPatDO> canUsePrepayList = getCanUsePrepay(entId);
		Map<String,BlPrePayPatDO> map = new HashMap<String,BlPrePayPatDO>();//通过订单号和凭证号唯一确定一条原可使用预交金数据，原预交金数据的订单号和凭证号为key，DO为value，用于校验数据
		
		for (BlPrePayPatDO pre : canUsePrepayList) {
			if(!StringUtil.isEmpty(pre.getPaymodenode()) || !StringUtil.isEmpty(pre.getBankno())){
				map.put(pre.getPaymodenode()+pre.getBankno(), pre);
			}
		}
		
		//对每一个找零信息进行校验
		for (WsParamIpChange itm : changeInfo) {
			if("01".equals(itm.getChangeMethod())){
				throw new BizException("住院收付款：入参找零信息支付方式不能为现金");
			}
						
			//对每个找零信息的数据进行校验
			String key = (StringUtil.isEmpty(itm.getOrderNumber()) ? null : itm.getOrderNumber())+(StringUtil.isEmpty(itm.getDocumentNumber()) ? null : itm.getDocumentNumber());
			if(!map.containsKey(key)){
				throw new BizException("住院收付款：未找到流水号是"+itm.getOrderNumber()+",凭证号是"+itm.getDocumentNumber()+"的原预交金数据");
			}else{
				//对金额进行校验
				if(BlAmtConverUtil.toFDouble(itm.getChangeMoney()).compareTo(FDouble.ZERO_DBL) <= 0){
					throw new BizException("住院收付款：入参找零信息"+itm.getChangeMethod()+"支付方式金额不能小于等于0");
				}
				FDouble amt_Source = map.get(key).getAmt();//原预交金数据的金额
				if(BlAmtConverUtil.toFDouble(itm.getChangeMoney()).compareTo(amt_Source) > 0){
					throw new BizException("住院收付款：入参找零信息"+itm.getChangeMethod()+"支付方式金额不能大于原预交金数据的金额");
				}
				
				//对支付方式进行校验
				String pm_Source = map.get(key).getSd_pm();
				if(!itm.getChangeMethod().equals(pm_Source)){
					throw new BizException("住院收付款：入参找零信息"+itm.getChangeMethod()+"支付方式和原预交金数据支付方式不一致");
				}
			}
			
			//组装找零数据
			BlPayIpPmDTO payIpPm = new BlPayIpPmDTO();
			PriPmDO pmDo = priPmMap.get(itm.getChangeMethod());
			payIpPm.setId_pm(pmDo.getId_pm());
			payIpPm.setSd_pm(pmDo.getCode());
			payIpPm.setAmt(BlAmtConverUtil.toFDouble(itm.getChangeMoney()));
			payIpPm.setEu_direct(-1);
			payIpPm.setFg_charge(FBoolean.TRUE);
			payIpPm.setFg_transfer(FBoolean.FALSE);
			payIpPm.setFg_refund_manual(FBoolean.FALSE);
			payIpPm.setId_paypat(map.get(key).getId_paypat());//预交金主键
			payIpPm.setBankno(itm.getDocumentNumber());
			payIpPm.setPaymodenode(itm.getOrderNumber());
			prePays.add(payIpPm);
		}
		
	}
	
	/**
	 * 获取本次就诊患者住院可使用预交金集合
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	private List<BlPrePayPatDO> getCanUsePrepay(String entId) throws BizException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select pre.id_paypat, ");
		sql.append(" pre.sd_pm, ");
		sql.append(" pre.sd_pttp, ");
		sql.append(" pre.amt, ");
		sql.append(" pre.amt_ret, ");
		sql.append(" pre.eu_direct, ");
		sql.append(" pre.bankno, ");
		sql.append(" pre.paymodenode ");
		sql.append(" from bl_prepay_pat pre ");
		sql.append(" where pre.id_ent = ? ");
		sql.append(" and pre.Eu_direct = 1 ");
		sql.append(" and pre.Fg_rep_return = 'N' ");
		sql.append(" and pre.Fg_canc = 'N' ");
		sql.append(" and pre.Sd_paytp in ('12', '14', '15', '17', '18') ");
		sql.append(" order by pre.dt_pay ");

		SqlParam param = new SqlParam();
		param.addParam(entId);
		
		List<BlPrePayPatDO> list = (List<BlPrePayPatDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(BlPrePayPatDO.class));
		
		return list;
	}

}
