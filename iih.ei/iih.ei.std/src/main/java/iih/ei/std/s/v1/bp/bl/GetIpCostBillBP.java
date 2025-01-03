package iih.ei.std.s.v1.bp.bl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.itf.dto.std.charge.d.BlBillClassificationDTO;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.charge.sub.WsResultBillIpTotalAmtInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultIpBill;
import iih.ei.std.d.v1.bl.ipcostbillqrydto.d.IpCostBillQryParamDTO;
import iih.ei.std.d.v1.bl.ipcostbillqrydto.d.IpCostBillQryResultDTO;
import iih.ei.std.d.v1.bl.ipcostbillqrydto.d.IpOrderDetailInfo;
import iih.ei.std.d.v1.bl.ipcostbillqrydto.d.IpTypeCostInfo;
import iih.ei.std.d.v1.bl.ipcostbillqrydto.d.SrvInfo;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.i.ICardRService;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 住院费用清单查询
 * 
 * @author shaokx
 * @date: 2019.09.26
 */
public class GetIpCostBillBP extends IIHServiceBaseBP<IpCostBillQryParamDTO, IpCostBillQryResultDTO> {

	private PatiVisitDO patiVisitDO = null;
	private InpatientDO InpatientDO = null;
	private String patId;

	@Override
	protected void checkParam(IpCostBillQryParamDTO param) throws BizException {

		if (param == null) {
			throw new BizException("入参为空");
		}

		if (StringUtil.isEmpty(param.getCode_hospital())) {
			throw new BizException("费用查询入参医院编码为空");
		}

		if (StringUtil.isEmpty(param.getCode_enttp())) {
			throw new BizException("费用查询入参就诊类型为空");
		}

		if (!IBlWsConst.ENTP_IP.equals(param.getCode_enttp())) {
			throw new BizException("就诊类型值不正确");
		}
		
		if(StringUtil.isEmpty(param.getDt_start())){
			throw new BizException("入参开始时间为空");
		}
		
		if(StringUtil.isEmpty(param.getDt_end())){
			throw new BizException("入参结束时间为空");
		}

		if (StringUtil.isEmpty(param.getCode_pat()) && StringUtil.isEmpty(param.getCode_card())
				&& StringUtil.isEmpty(param.getCode_idnum()) && StringUtil.isEmpty(param.getCode_amr_ip())) {
			throw new BizException("住院费用查询入参关键信息全为空:患者编码,就诊卡号,身份证号,住院号");
		}

		patId = this.findPat(param);

		if (!StringUtil.isEmpty(param.getCode_pat()) && !StringUtil.isEmpty(param.getTimes_ip())) {
			getPatiVisitDO("1", param.getCode_pat(), param.getTimes_ip());
			return;
		} else if (!StringUtil.isEmpty(param.getCode_amr_ip())) {
			getPatiVisitDO("2", param.getCode_amr_ip(), param.getTimes_ip());
			return;
		} else if (!StringUtil.isEmpty(param.getCode_card())) {
			getPatiVisitDO("3", param.getCode_card(), null);
			return;
		} else if (!StringUtil.isEmpty(param.getCode_idnum()) && !StringUtil.isEmpty(param.getTimes_ip())) {
			getPatiVisitDO("4", param.getCode_idnum(), param.getTimes_ip());
			return;
		}
		// else if(!StringUtil.isEmpty(param.getEn_code())){
		// getPatiVisitDO("5",param.getEn_code(),null);
		// return;
		// }
		else {
			throw new BizException("患者信息不存在");
		}

	}

	@Override
	protected IpCostBillQryResultDTO process(IpCostBillQryParamDTO param) throws BizException {

		if (this.InpatientDO == null) {
			throw new BizException("未能获取到本次就诊信息");
		}
		
		IpCostBillQryResultDTO rlt1 = new IpCostBillQryResultDTO();
		
		WsResultIpBill wsResultIpBill = new WsResultIpBill();
		// 住院汇总
		this.setBlIpSummary(param,rlt1);
		// 分类汇总
		List<IpTypeCostInfo> wsResultBillTypeInfos = setBlIpTaxonomy(param);
		FArrayList arr = new FArrayList();
		arr.addAll(wsResultBillTypeInfos);
		rlt1.setIptypecostinfo(arr);
		// 住院账单项目分类明细
		List<IpOrderDetailInfo> wsResultBillOrderInfos = setBillclassification(param);
		FArrayList arr1 = new FArrayList();
		arr1.addAll(wsResultBillOrderInfos);
		rlt1.setIporderdetailinfo(arr1);

		return rlt1;
	}

	/**
	 * 查询患者
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(IpCostBillQryParamDTO param) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(param.getCode_pat());
		condDto.setId_code(param.getCode_idnum());
		condDto.setCard_code(param.getCode_card());
		condDto.setCode_amr_ip(param.getCode_amr_ip());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("住院费用查询:未查询到患者信息");
		}

		return patiAggs[0].getParentDO().getId_pat();
	}

	/**
	 * 
	 * @Title: getPatiVisitDO @Description: 根据不同入参获取就诊信息 @param: @param
	 * attributeName @param: @param value @param: @return @return:
	 * PatiVisitDO @throws
	 */
	private void getPatiVisitDO(String attributeName, String value, String value2) throws BizException {
		// 如果就诊次数为空的话，取当前患者就诊次数
		if (StringUtil.isEmpty(value2)) {
			value2 = getTimesIp(patId);
		}

		IPativisitRService iPativisitRService = ServiceFinder.find(IPativisitRService.class);
		IInpatientRService inpatientRService = ServiceFinder.find(IInpatientRService.class);
		String whereStr = null;
		switch (attributeName) {
		case "1":
			whereStr = " id_pat='" + patId + "' ";
			PatiVisitDO[] patiVisitDOs = iPativisitRService.find(whereStr, null, FBoolean.FALSE);
			List<String> idEnts = new ArrayList<>();
			for (PatiVisitDO patiVisitDO : patiVisitDOs) {
				idEnts.add(patiVisitDO.getId_ent());
			}
			InpatientDO[] inpatientDOs = inpatientRService.findByAttrValStrings(InpatientDO.ID_ENT,
					idEnts.toArray(new String[] {}));
			if (!ArrayUtil.isEmpty(inpatientDOs)) {
				for (InpatientDO inpatientDO : inpatientDOs) {
					if (value2.equals(inpatientDO.getTimes_ip().toString())) {
						this.InpatientDO = inpatientDO;
					}
				}
			}
			break;
		case "2":
			whereStr = " code_amr_ip='" + value + "' and times_ip=" + value2;
			InpatientDO[] inpatientDOs2 = inpatientRService.find(whereStr, "", FBoolean.FALSE);
			if (!ArrayUtil.isEmpty(inpatientDOs2)) {
				this.InpatientDO = inpatientDOs2[0];
			}
			break;
		case "3":
			ICardRService iCardRService = ServiceFinder.find(ICardRService.class);
			PiCardDO[] piCardDOs = iCardRService.findByAttrValString(" code ", value);
			if (!ArrayUtil.isEmpty(piCardDOs)) {
				whereStr = " id_pat'" + piCardDOs[0].getId_pat() + "' and fg_ip='Y' ";
				PatiVisitDO[] patiVisitDOs2 = iPativisitRService.find(whereStr, "", FBoolean.FALSE);
				if (!ArrayUtil.isEmpty(patiVisitDOs2)) {
					InpatientDO[] inpatientDOs3 = inpatientRService.findByAttrValString("id_ent",
							patiVisitDOs2[0].getId_ent());
					if (!ArrayUtil.isEmpty(inpatientDOs3)) {
						this.InpatientDO = inpatientDOs3[0];
					}
				}
			}
			break;
		case "4":

			break;
		case "5":
			PatiVisitDO[] patiVisitDOs3 = iPativisitRService.findByAttrValString(PatiVisitDO.CODE, value);
			if (!ArrayUtil.isEmpty(patiVisitDOs3)) {
				InpatientDO[] inpatientDOs5 = inpatientRService.findByAttrValString(InpatientDO.ID_ENT,
						patiVisitDOs3[0].getId_ent());
				if (!ArrayUtil.isEmpty(inpatientDOs5)) {
					this.InpatientDO = inpatientDOs5[0];
				}
			}
			break;
		}
		return;
	}

	/**
	 * 根据患者id查询到患者当前的就诊次数
	 * 
	 * @return
	 * @throws DAException
	 */
	private String getTimesIp(String patId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select entip.times_ip ");
		sql.append(" from en_ent ent ");
		sql.append(" inner join en_ent_ip entip ");
		sql.append(" on ent.id_ent = entip.id_ent ");
		sql.append(" where ent.id_pat = ? ");
		sql.append(" order by entip.times_ip desc ");

		SqlParam param = new SqlParam();
		param.addParam(patId);

		@SuppressWarnings("unchecked")
		List<InpatientDO> list = (List<InpatientDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(InpatientDO.class));

		if (list == null || list.size() == 0) {
			throw new BizException("住院费用清单查询：未查询到该患者的当前就诊次数");
		}
		return list.get(0).getTimes_ip().toString();
	}

	/**
	 * 
	 * @Title: setResultMsg @Description: 返回resultmsg @param: @param
	 * resultCode @param: @return @return: WsResultMsg @throws
	 */
	private WsResultMsg setResultMsg(String resultCode) {
		WsResultMsg rltMsg = new WsResultMsg();
		if (resultCode.endsWith("0")) {
			rltMsg.setCode("0");
			rltMsg.setMessage("成功！");
		} else {
			rltMsg.setCode("1");
			rltMsg.setMessage("失败！");
		}
		return rltMsg;
	}

	/***
	 * 
	 * @Title: setBlIpSummary @Description: 获取住院费用汇总并赋值 @param: @return @return:
	 * WsResultInfoIpGetCostBill @throws
	 */
	private void setBlIpSummary(IpCostBillQryParamDTO param,IpCostBillQryResultDTO rlt1) throws BizException {
		// 获取就诊账户信息
		IEnOutQryService iEnOutQryService = ServiceFinder.find(IEnOutQryService.class);
		BalanceDTO balanceDTO = iEnOutQryService.getBalanceDTO(this.InpatientDO.getId_ent());
		if (balanceDTO == null) {
			throw new BizException("未获取到就诊账户信息");
		}
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(" select sum(amt.totalAmt) dayAmt ,sum(amt.settled) settled   from( ");
		sBuffer.append(" select sum(amt_ratio*eu_direct) totalAmt ,0 settled from bl_cg_ip " + "where id_ent='")
				.append(this.InpatientDO.getId_ent()).append("'");
		if (!StringUtil.isEmpty(param.getDt_start())) {
			sBuffer.append(" and dt_cg >= '" + param.getDt_start() + "' ");
		}
		if (!StringUtil.isEmpty(param.getDt_end())) {
			sBuffer.append(" and dt_cg <= '" + param.getDt_end() + "' ");
		}
		sBuffer.append(" union  ");
		sBuffer.append(" select  0 totalAmt ,sum(amt_ratio*eu_direct) settled ");
		sBuffer.append(" from bl_cg_ip where id_ent='").append(this.InpatientDO.getId_ent()).append("'");
		sBuffer.append(" and fg_st='Y' ");
		if (!StringUtil.isEmpty(param.getDt_start())) {
			sBuffer.append(" and dt_cg >= '" + param.getDt_start() + "' ");
		}
		if (!StringUtil.isEmpty(param.getDt_end())) {
			sBuffer.append(" and dt_cg <= '" + param.getDt_end() + "' ");
		}
		sBuffer.append(" ) amt ");
		// 获取住院总费用与已结算金额
		@SuppressWarnings("unchecked")
		List<WsResultBillIpTotalAmtInfo> result = (List<WsResultBillIpTotalAmtInfo>) new DAFacade()
				.execQuery(sBuffer.toString(), new BeanListHandler(WsResultBillIpTotalAmtInfo.class));
		if (ListUtil.isEmpty(result)) {
			return ;
		}
		WsResultBillIpTotalAmtInfo wsRltInfo = result.get(0);
		
		StringBuffer sql = new StringBuffer();
        sql.append(" select nvl(sum(amt*eu_direct),0) settled ");
        sql.append(" from bl_st_ip ");
        sql.append(" where id_ent = ? ");
        sql.append(" and fg_pay = 'Y' ");

        SqlParam param1 = new SqlParam();
        param1.addParam(this.InpatientDO.getId_ent());
        
        Number stAmt = (Number)new DAFacade().execQuery(sql.toString(),param1, new ColumnHandler());//结算金额
        
		rlt1.setAmt_prepay(BlAmtConverUtil.toXmlString(balanceDTO.getAmt_prepay()));// 预交金总额
		rlt1.setAmt_balance(BlAmtConverUtil.toXmlString(balanceDTO.getAvailable()));// 预交金余额
		
		rlt1.setAmt_unst(BlAmtConverUtil.toXmlString(balanceDTO.getAmt_uncg()));// 未结算金额
		rlt1.setAmt_st(BlAmtConverUtil.toXmlString(new FDouble(stAmt.doubleValue())));// 已结算金额
		rlt1.setAmt_total(this.addUtil(rlt1.getAmt_unst(), rlt1.getAmt_st()));// 住院总费用

		if (!StringUtil.isEmpty(param.getDt_start()) && !StringUtil.isEmpty(param.getDt_end())) {
			rlt1.setAmt_day(BlAmtConverUtil.toXmlString(new FDouble(wsRltInfo.getDayAmt())));// 日总金额
		} else {
			rlt1.setAmt_day(null);
		}

		if (balanceDTO.getAvailable().compareTo(new FDouble(0)) <= 0) {
			rlt1.setNote("欠费敬告：您的预交金已用完，请速到收费处补交预交金");
		}
	}

	/**
	 * 
	 * 两个string类型的减法方法，入参为string,返回结果为String
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	private String subUtil(String num1, String num2) {
		double num11 = new BigDecimal(num1).doubleValue();
		double num22 = new BigDecimal(num2).doubleValue();
		double doubleValue = new BigDecimal(num11 - num22).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

		DecimalFormat decimalFormat = new DecimalFormat("###################.###########");

		return decimalFormat.format(doubleValue);
		// return String.valueOf(doubleValue);//double转成string时，会在末尾加上一个0，如12
		// 会变为12.0
	}
	
	/**
	 * 
	 * 两个string类型的加法方法，入参为string,返回结果为String
	 * @param num1
	 * @param num2
	 * @return
	 */
	private String addUtil(String num1,String num2){
		double num11 = new BigDecimal(num1).doubleValue();
		double num22 = new BigDecimal(num2).doubleValue();
		double doubleValue = new BigDecimal(num11+num22).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		DecimalFormat decimalFormat = new DecimalFormat("###################.###########");

		return decimalFormat.format(doubleValue);
		//return String.valueOf(doubleValue);//double转成string时，会在末尾加上一个0，如12 会变为12.0
	}

	/**
	 * 
	 * @Title: setBlIpTaxonomy @Description:
	 * 获取住院汇总分类费用情况 @param: @return @param: @throws BizException @return:
	 * WsResultBillIPTypecostInfo @throws
	 */
	private List<IpTypeCostInfo> setBlIpTaxonomy(IpCostBillQryParamDTO param) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("   SELECT     Z.CODE_INCCAITM code_inccaitm, ");
		sql.append("         NVL(Z.NAME_INCCAITM, '未知')  name_inccaitm, ");
		sql.append("         trim(to_char(SUM(X.EU_DIRECT * X.AMT_RATIO),'9999990.00')) amt_inccaitm ");
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
		sql.append("   WHERE X.ID_ENT = ? ");
		if (!StringUtil.isEmpty(param.getDt_start())) {
			sql.append(" and X.dt_cg >= ?");
		}
		if (!StringUtil.isEmpty(param.getDt_end())) {
			sql.append(" and X.dt_cg <= ?");
		}
		sql.append("   GROUP BY Z.ID_INCCAITM, Z.CODE_INCCAITM, Z.NAME_INCCAITM ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(IBdInccaCodeConst.ID_INHOS_INVOICE);
		sqlp.addParam(this.InpatientDO.getId_ent());
		if (!StringUtil.isEmpty(param.getDt_start())) {
			sqlp.addParam(param.getDt_start());
		}
		if (!StringUtil.isEmpty(param.getDt_end())) {
			sqlp.addParam(param.getDt_end());
		}
		List<IpTypeCostInfo> list = (List<IpTypeCostInfo>) new DAFacade().execQuery(sql.toString(), sqlp,
				new BeanListHandler(IpTypeCostInfo.class));

		for (IpTypeCostInfo itm : list) {
			itm.setAmt_inccaitm(BlAmtConverUtil.toXmlString(new FDouble(itm.getAmt_inccaitm())));
		}

		return list;
	}

	/**
	 * 
	 * @Title: setBillclassification @Description:
	 * 获取到住院账单项目分类明细 @param: @return @param: @throws BizException @return:
	 * WsResultBillOrderInfo @throws
	 */
	private List<IpOrderDetailInfo> setBillclassification(IpCostBillQryParamDTO param) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				" select  cg.id_cgip,nvl(ord.code_or,-1) code_or,ord.sd_srvtp,cg.fg_st,cg.dt_cg,dep.name name_dep, ");
		sql.append(" psn.name name_emp,cg.code_srv,cg.name_srv,meas.name srvu,cg.price_ratio price,cg.eu_direct, ");
		sql.append(" cg.fg_mm,cg.spec,cg.code_inccaitm,cg.name_inccaitm,cg.quan,cg.amt_ratio amt ");
		sql.append(" from bl_cg_ip cg ");
		sql.append(" left join ci_order ord on ord.id_or=cg.id_or ");
		sql.append(" left join bd_dep dep on dep.id_dep=cg.id_dep_or ");
		sql.append(" left join bd_psndoc psn on psn.id_psndoc=cg.id_emp_or ");
		sql.append(" left join ci_or_srv srv on srv.id_orsrv=cg.id_srv ");
		sql.append(" left join bd_measdoc meas on cg.srvu = meas.id_measdoc");
		sql.append(" where id_ent=? ");
		if (!StringUtil.isEmpty(param.getDt_start())) {
			sql.append(" and cg.dt_cg >= ? ");
		}
		if (!StringUtil.isEmpty(param.getDt_end())) {
			sql.append(" and cg.dt_cg <= ? ");
		}

		SqlParam sqlp = new SqlParam();
		sqlp.addParam(this.InpatientDO.getId_ent());
		if (!StringUtil.isEmpty(param.getDt_start())) {
			sqlp.addParam(param.getDt_start());
		}
		if (!StringUtil.isEmpty(param.getDt_end())) {
			sqlp.addParam(param.getDt_end());
		}
		List<BlBillClassificationDTO> list = (List<BlBillClassificationDTO>) new DAFacade().execQuery(sql.toString(),
				sqlp, new BeanListHandler(BlBillClassificationDTO.class));
		Map<String, List<BlBillClassificationDTO>> IPDetailcostInfoMap = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			if (IPDetailcostInfoMap.containsKey(list.get(i).getCode_or())) {
				try {
					IPDetailcostInfoMap.get(list.get(i).getCode_or()).add(list.get(i));
				} catch (Exception e) {
					System.out.println(list.get(i));
				}
			} else {
				List<BlBillClassificationDTO> list2 = new ArrayList<>();
				list2.add(list.get(i));
				IPDetailcostInfoMap.put(list.get(i).getCode_or(), list2);
			}
		}
		// 最后返回的总集合
		List<IpOrderDetailInfo> billOrderInfos = new ArrayList<IpOrderDetailInfo>();
		for (String s : IPDetailcostInfoMap.keySet()) {
			List<BlBillClassificationDTO> list3 = IPDetailcostInfoMap.get(s);
			Map<String, List<BlBillClassificationDTO>> WsResultBillSrvInfoMap = new HashMap<>();
			for (int i = 0; i < list3.size(); i++) {
				// 有种情况：若存在5个服务，其中3个单价是3元，2个单价是5元，这种情况走下面的代码返回不对，所以要判断一下，按照单价进行分类,加个过滤条件
				if (WsResultBillSrvInfoMap.containsKey(list3.get(i).getCode_srv() + list3.get(i).getPrice())) {
					WsResultBillSrvInfoMap.get(list3.get(i).getCode_srv() + list3.get(i).getPrice()).add(list3.get(i));
				} else {
					List<BlBillClassificationDTO> list4 = new ArrayList<>();
					list4.add(list3.get(i));
					WsResultBillSrvInfoMap.put(list3.get(i).getCode_srv() + list3.get(i).getPrice(), list4);
				}
			}
			IpOrderDetailInfo wsorderInfo = setWsResultBillOrderInfo(list3.get(0));
			List<SrvInfo> wsResultBillSrvInfos = new ArrayList<SrvInfo>();
			for (String e : WsResultBillSrvInfoMap.keySet()) {
				// 相同服务的集合
				List<BlBillClassificationDTO> list5 = WsResultBillSrvInfoMap.get(e);

				// //有种情况：若存在5个服务，其中3个单价是3元，2个单价是5元，这种情况走下面的代码返回不对，所以要判断一下，按照单价进行分类
				// //1、定义一个集合，里面是循环加入list5集合中的元素，用于条件判断
				// List<FDouble> isContinue = new ArrayList<FDouble>();
				//
				// //2、定义一个集合，里面是按照单价进行分类出来的集合
				// List<List> all = new ArrayList<List>();
				//
				// //3、核心代码
				// for(int i = 0; i < list5.size(); i++){
				// if(!isContinue.contains(list5.get(i).getPrice())){
				// isContinue.add(list5.get(i).getPrice());
				// }else{
				// continue;
				// }
				// //定义一个集合，里面是相同服务按照单价进行分类的相同单价的服务
				// List<BlBillClassificationDTO> srvByPriceList = new
				// ArrayList<BlBillClassificationDTO>();
				// for(int j = i; j < list5.size(); j++){
				// if(list5.get(i).getPrice() == list5.get(j).getPrice()){
				// srvByPriceList.add(list5.get(i));
				// }else{
				// continue;
				// }
				// }
				// all.add(srvByPriceList);
				// }

				FDouble amt_all = new FDouble(0);
				FDouble quan_all = new FDouble(0);
				for (int i = 0; i < list5.size(); i++) {
					FDouble amt_bill = list5.get(i).getAmt().multiply(new FDouble(list5.get(i).getEu_direct()));
					FDouble add1 = amt_all.add(amt_bill);
					amt_all = add1;
					FDouble quan_bill = list5.get(i).getQuan().multiply(new FDouble(list5.get(i).getEu_direct()));
					FDouble add2 = quan_all.add(quan_bill);
					quan_all = add2;
				}
				SrvInfo resultBillSrvInfo = setWsResultBillSrvInfo(list5.get(0), amt_all, quan_all);
				wsResultBillSrvInfos.add(resultBillSrvInfo);
			}
			FArrayList arr = new FArrayList();
			arr.addAll(wsResultBillSrvInfos);
			wsorderInfo.setSrvinfo(arr);
			billOrderInfos.add(wsorderInfo);
		}
		return billOrderInfos;
	}

	/**
	 * 
	 * @Title: setWsResultBillSrvInfo @Description: 为医嘱项目明细赋值 @param: @param
	 * bDto @param: @param amt_all @param: @param
	 * quan_all @param: @return @return: WsResultBillSrvInfo @throws
	 */
	private SrvInfo setWsResultBillSrvInfo(BlBillClassificationDTO bDto, FDouble amt_all,
			FDouble quan_all) {
		SrvInfo wSrvInfo = new SrvInfo();
		wSrvInfo.setCode_srv(bDto.getCode_srv());
		wSrvInfo.setName_srv(bDto.getName_srv());
		wSrvInfo.setUnit(bDto.getSrvu());
		if (bDto.getFg_mm().booleanValue()) {
			wSrvInfo.setSpec(bDto.getSpec());
		}
		wSrvInfo.setPrice(BlAmtConverUtil.toXmlString(bDto.getPrice()));
		wSrvInfo.setCode_inccaitm(bDto.getCode_inccaitm());
		wSrvInfo.setName_inccaitm(bDto.getName_inccaitm());
		wSrvInfo.setQuan(Integer.toString((int) Math.ceil(quan_all.doubleValue())));
		wSrvInfo.setAmt(BlAmtConverUtil.toXmlString(amt_all));
		return wSrvInfo;
	}

	/**
	 * 
	 * @Title: setWsResultBillOrderInfo @Description: 为医嘱列表赋值 @param: @param
	 * bDto @param: @return @return: WsResultBillOrderInfo @throws
	 */
	private IpOrderDetailInfo setWsResultBillOrderInfo(BlBillClassificationDTO bDto) {
		IpOrderDetailInfo wsorderInfo = new IpOrderDetailInfo();
		if (!bDto.getCode_or().equals("-1")) {
			wsorderInfo.setCode_apply(bDto.getCode_or());
			wsorderInfo.setCode_applytp(bDto.getSd_srvtp());
		}
		wsorderInfo.setFg_st(bDto.getFg_st().toString());
		wsorderInfo.setDt_cg(bDto.getDt_cg().toString());
		wsorderInfo.setName_dep_or(bDto.getName_dep());
		wsorderInfo.setName_emp_or(bDto.getName_emp());
		return wsorderInfo;
	}

}
