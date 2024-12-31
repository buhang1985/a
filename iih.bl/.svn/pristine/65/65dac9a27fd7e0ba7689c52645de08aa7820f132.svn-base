package iih.bl.itf.std.bp.opprepay;

import java.util.ArrayList;
import java.util.List;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.prepay.WsParamPrepay;
import iih.bl.itf.std.bean.input.prepay.sub.WsParamPrepayInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.prepay.WsResultInfoRechargeQry;
import iih.bl.itf.std.bean.output.prepay.WsResultRechargeQry;
import iih.bl.itf.std.bean.output.prepay.sub.WsResultInfoRechargeItmQry;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 充值记录查询新(门诊+住院)
 * 
 * @author shaokx 2019/02/10
 *
 */
public class GetRechargeInfoBP extends BlItfBaseBP<WsParamPrepay,WsResultRechargeQry>{

	@Override
	protected String getBusiness() {
		
		return "充值记录查询";
	}

	@Override
	protected void checkParam(WsParamPrepay param) throws BizException {
		
		if(param.getPrepay() == null){
			throw new BizException("充值记录查询入参数据为空");
		}
		
		WsParamPrepayInfo prepayInfo = param.getPrepay();
		if(StringUtil.isEmpty(prepayInfo.getEntpCode())){
			throw new BizException("充值记录查询入参就诊类型为空");
		}
		
		if(!IBlWsConst.ENTP_OP.equals(prepayInfo.getEntpCode()) && !IBlWsConst.ENTP_IP.equals(prepayInfo.getEntpCode())){
			throw new BizException("充值记录查询入参就诊类型值不正确");
		}
		
		if(IBlWsConst.ENTP_OP.equals(prepayInfo.getEntpCode())){
			if(StringUtil.isEmpty(prepayInfo.getPatCode()) && 
					StringUtil.isEmpty(prepayInfo.getCardCode()) && 
					StringUtil.isEmpty(prepayInfo.getSdCode())){
				throw new BizException("门诊充值记录查询入参关键信息全为空:患者编码,就诊卡号,身份证号");
			}
		}else{
			if(StringUtil.isEmpty(prepayInfo.getPatCode()) 
					&& StringUtil.isEmpty(prepayInfo.getCardCode())
					&& StringUtil.isEmpty(prepayInfo.getSdCode())
					&& StringUtil.isEmpty(prepayInfo.getIPCode())){
				throw new BizException("住院充值记录查询入参关键信息全为空:患者编码,就诊卡号,身份证号,住院登记流水号");
			}
		}
		
	}

	@Override
	protected WsResultRechargeQry doWork(WsParamPrepay param) throws BizException {
		//1 获取患者id
		WsParamPrepayInfo prepayInfo = param.getPrepay();
		String patId = this.findPat(prepayInfo);
		List<WsResultInfoRechargeItmQry> list = new ArrayList<WsResultInfoRechargeItmQry>();
		
		//2 查询预交金表
		if(IBlWsConst.ENTP_OP.equals(prepayInfo.getEntpCode())){
			//查门诊
			StringBuilder sql = new StringBuilder();
			sql.append(" select dt_pay payTime, ");
			sql.append(" sd_pm paymentMethod, ");
			sql.append(" paymodenode orderNumber, ");
			sql.append(" bankno documentNumber, ");
			sql.append(" code_rep incCode, ");
			sql.append(" amt payMoney, ");
			sql.append(" sd_pttp terminalType, ");
			sql.append(" eu_direct payStatus ");
			sql.append(" from bl_prepay_pat ");
			sql.append(" where id_pat = ? and sd_paytp = '11' and eu_direct = 1 ");

			SqlParam pa = new SqlParam();
			pa.addParam(patId);
			
			list = (List<WsResultInfoRechargeItmQry>) new DAFacade().execQuery(sql.toString(), pa,
					new BeanListHandler(WsResultInfoRechargeItmQry.class));
			
		}else{
			//查住院
			String entId = this.findEntInfoIp(patId, prepayInfo.getEnTimes());
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select dt_pay payTime, ");
			sql.append(" sd_pm paymentMethod, ");
			sql.append(" paymodenode orderNumber, ");
			sql.append(" bankno documentNumber, ");
			sql.append(" code_rep incCode, ");
			sql.append(" amt payMoney, ");
			sql.append(" sd_pttp terminalType, ");
			sql.append(" eu_direct payStatus ");
			sql.append(" from bl_prepay_pat ");
			sql.append(" where id_ent = ? and sd_paytp = '12' and eu_direct = 1 ");

			SqlParam pa = new SqlParam();
			pa.addParam(entId);
			
			list = (List<WsResultInfoRechargeItmQry>) new DAFacade().execQuery(sql.toString(), pa,
					new BeanListHandler(WsResultInfoRechargeItmQry.class));
		}
		
		//元转分
		for (WsResultInfoRechargeItmQry itm : list) {
			itm.setPayMoney(BlAmtConverUtil.toXmlString(new FDouble(itm.getPayMoney())));
		}
		
		//3 返回出参
		WsResultRechargeQry outparam = new WsResultRechargeQry();
		WsResultMsg rltMsg = new WsResultMsg();
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		WsResultInfoRechargeQry order = new WsResultInfoRechargeQry();
		order.setOrderInfo(list);
		
		outparam.setRltMsg(rltMsg);
		outparam.setRltInfo(order);
		return outparam;
	}
	
	/**
	 * 根据人员id和就诊次数查询就诊信息（住院）
	 * 
	 * @param patId
	 * @param enTimes
	 * @return
	 * @throws Exception 
	 */
	private String findEntInfoIp(String patId, String enTimes) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ent.id_ent from  ");
		sql.append(" en_ent ent ");
		sql.append(" INNER join en_ent_ip entip on ent.id_ent=entip.id_ent ");
		sql.append(" where ent.id_pat=? ");
		sql.append(" and entip.times_ip=? ");
		SqlParam param = new SqlParam();
		param.addParam(patId);
		if (!StringUtil.isEmpty(enTimes)) {
			param.addParam(enTimes);
		} else {
			// 查询这个患者当前的就诊次数
			String timesIp = this.getTimesIp(patId);
			param.addParam(timesIp);
		}

		@SuppressWarnings("unchecked")
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(PatiVisitDO.class));
		if (ListUtil.isEmpty(list)) {
			throw new BizException("未查询到患者就诊信息");
		}
		return list.get(0).getId_ent();
	}
	
	/**
	 * 根据患者id查询到患者当前的就诊次数（住院）
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
			return "0";
		}
		return list.get(0).getTimes_ip().toString();
	}

	
	/**
	 * 查询患者
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(WsParamPrepayInfo param) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(param.getPatCode());
		condDto.setId_code(param.getSdCode());
		condDto.setCard_code(param.getCardCode());
		condDto.setCode_amr_ip(param.getIPCode());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("未查询到患者信息");
		}

		return patiAggs[0].getParentDO().getId_pat();
	}

}
