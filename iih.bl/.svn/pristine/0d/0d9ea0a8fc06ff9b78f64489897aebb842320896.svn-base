package iih.bl.itf.std.bp.opcharge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.itf.dto.std.charge.d.BlBillClassificationDTO;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.charge.WsParamGetCostBill;
import iih.bl.itf.std.bean.input.charge.sub.WsParamBillPatInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.charge.WsResultInfoOpGetCostBill;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetCostBill;
import iih.bl.itf.std.bean.output.charge.sub.WsResultBillOrderInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultBillSrvInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultBillTypeInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultOpBill;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.bp.validator.WsParamGetCostBillValidator;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.en.pv.outpatient.d.OutpatientDO;
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
 * 门诊费用清单查询
 * @author ly 2018/7/20
 *
 */
public class GetOpCostBillBP extends BlItfBaseBP<WsParamGetCostBill,WsResultOpGetCostBill>{

	@Override
	protected String getBusiness() {
		// TODO Auto-generated method stub
		return "门诊费用清单查询";
	}

	@Override
	protected void checkParam(WsParamGetCostBill param) throws BizException {
		WsParamGetCostBillValidator validator=new WsParamGetCostBillValidator();
		validator.validate(param);
	}

	@Override
	protected WsResultOpGetCostBill doWork(WsParamGetCostBill param) throws BizException {
		//获取就诊信息
		WsParamBillPatInfo patInfo = param.getPatInfo();
		String patId = this.findPat(patInfo);
		PatiVisitDO entDO =this.findEntInfo(patId, patInfo.getEnTimes());
		
		//账单项
		BlBillClassificationDTO[] billTypeArr=this.findBillTypeInfo(entDO.getId_ent());

		//医嘱信息
		BlBillClassificationDTO[] orderArr=this.findporderDetailInfoArr(entDO.getId_ent());
	
		//服务信息
		BlBillClassificationDTO[] srvArr=this.findSrvInfo(entDO.getId_ent());
		Map<String, List<BlBillClassificationDTO>> srvMap=new HashMap<String, List<BlBillClassificationDTO>>();
		FDouble typeAmount=FDouble.ZERO_DBL;
		for (BlBillClassificationDTO blBillClassificationDTO : srvArr) {
			if(srvMap.containsKey(blBillClassificationDTO.getCode_or())){
				List<BlBillClassificationDTO> list=srvMap.get(blBillClassificationDTO.getCode_or());
				list.add(blBillClassificationDTO);
			}else{
				List<BlBillClassificationDTO> list=new ArrayList<BlBillClassificationDTO>();
				list.add(blBillClassificationDTO);
				srvMap.put(blBillClassificationDTO.getCode_or(), list);
			}
			//计算消费金额
			typeAmount=typeAmount.add(blBillClassificationDTO.getAmt());
		}	
		//组装数据
		WsResultOpGetCostBill rlt=new WsResultOpGetCostBill();
		WsResultInfoOpGetCostBill billRlt=new WsResultInfoOpGetCostBill();
		WsResultMsg msgRlt=new WsResultMsg();
		msgRlt.setCode(IBlWsConst.RLT_SUCCESS);
		
		WsResultOpBill bill=new WsResultOpBill();
		if(!StringUtil.isEmpty(patInfo.getEnTimes())){
			bill.setOpTimes(patInfo.getEnTimes());
		}else{
			bill.setOpTimes(this.getTimesOp(patId));
		}
		
		bill.setOepCost(BlAmtConverUtil.toXmlString(typeAmount));
		
		//账单项
		List<WsResultBillTypeInfo> billTypeList=new ArrayList<WsResultBillTypeInfo>();
		//组装账单项
		for (BlBillClassificationDTO billDTO : billTypeArr) {
			WsResultBillTypeInfo billType=new WsResultBillTypeInfo();
			billType.setTypeName(billDTO.getName_inccaitm());
			billType.setTypeCode(billDTO.getCode_inccaitm());
			billType.setTypeAmount(BlAmtConverUtil.toXmlString(billDTO.getAmt()));
			billTypeList.add(billType);
		}
		bill.setBillList(billTypeList);
		
		//组装医嘱项目
		List<WsResultBillOrderInfo> orderList=new ArrayList<WsResultBillOrderInfo>();
		for (BlBillClassificationDTO orInfo : orderArr) {
			WsResultBillOrderInfo order=new WsResultBillOrderInfo();
			order.setApplyCode(orInfo.getCode_or());
			order.setApplyTpCode(orInfo.getSd_srvtp());
			if(orInfo.getFg_st().isValue()){
				order.setStflag("Y");
			}else{
				order.setStflag("N");
			}
			order.setCgTime(orInfo.getDt_cg().toString());
			order.setOrDepName(orInfo.getName_dep());
			order.setOrEmpName(orInfo.getName_emp());
			order.setMpDepName(orInfo.getName_mpdep());
			//组装服务数据
			List<WsResultBillSrvInfo> srvList=new ArrayList<WsResultBillSrvInfo>();
			List<BlBillClassificationDTO> srvDTOList =srvMap.get(orInfo.getCode_or());
			for (BlBillClassificationDTO srv : srvDTOList) {
				WsResultBillSrvInfo srvInfo=new WsResultBillSrvInfo();
				srvInfo.setSrvCode(srv.getCode_srv());
				srvInfo.setSrvName(srv.getName_srv());
				srvInfo.setUnit(srv.getSrvu());
				srvInfo.setSepcification(srv.getSpec());
				srvInfo.setPrice(BlAmtConverUtil.toXmlString(srv.getPrice()));
				srvInfo.setQuan(new FDouble(srv.getQuan().toDouble(), 0).toString());
				srvInfo.setInccacode(srv.getCode_inccaitm());
				srvInfo.setInccaItm(srv.getName_inccaitm());
				srvInfo.setAmt(BlAmtConverUtil.toXmlString(srv.getAmt()));
				srvList.add(srvInfo);
			}
			
			order.setSrvList(srvList);
			orderList.add(order);
		}
		bill.setOrdList(orderList);
		
		billRlt.setOpBill(bill);
		rlt.setRltMsg(msgRlt);
		rlt.setRltInfo(billRlt);
		
		return rlt;
	}
	
	
	
	/**
	 * 获取服务数据
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private BlBillClassificationDTO[] findSrvInfo(String entId) throws BizException{
		StringBuilder sqlStr=new StringBuilder();
		sqlStr.append("select ");
		sqlStr.append(" ci.code_or code_or, ");
		sqlStr.append("(case when cgitm.fg_mm='Y' then mm.code else srv.code end) code_srv,");
		sqlStr.append("(case when cgitm.fg_mm='Y' then mm.name else srv.name end) name_srv,");
		sqlStr.append("measdoc.name srvu, ");
		sqlStr.append("cgitm.spec spec,  ");
		sqlStr.append("cgitm.price_ratio price, ");
		sqlStr.append("cgitm.quan quan, ");
		sqlStr.append("cgitm.code_inccaitm code_inccaitm, ");
		sqlStr.append("cgitm.name_inccaitm name_inccaitm, ");
		sqlStr.append("cgitm.quan*cgitm.price_ratio amt ");
		sqlStr.append("from bl_cg_itm_oep cgitm  ");
		sqlStr.append("inner join bl_cg_oep cg on cg.id_cgoep=cgitm.id_cgoep  ");
		sqlStr.append(" left join ci_order ci on cgitm.id_or=ci.id_or ");
		sqlStr.append("left join bd_mm mm on mm.id_mm=cgitm.id_mm  ");
		sqlStr.append("left join bd_measdoc measdoc on measdoc.id_measdoc=cgitm.srvu ");
		sqlStr.append("left join bd_srv srv on cgitm.id_srv=srv.id_srv ");
		sqlStr.append("where id_ent=?  ");
		sqlStr.append("and cg.eu_direct='1'  ");
		sqlStr.append("and cgitm.fg_refund='N' ");
		SqlParam param=new SqlParam();
		param.addParam(entId);
		
		@SuppressWarnings("unchecked")
		List<BlBillClassificationDTO> list = (List<BlBillClassificationDTO>)new DAFacade().execQuery(sqlStr.toString(), param, new BeanListHandler(BlBillClassificationDTO.class));
		if(ListUtil.isEmpty(list)){
			throw new BizException("门诊费用清单查询：未查询到该次记账数据");
		}
		return list.toArray(new BlBillClassificationDTO[0]);
		
	}
	
	/**
	 * 查询该次就诊的医嘱信息
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private BlBillClassificationDTO[] findporderDetailInfoArr(String entId) throws BizException{
		StringBuilder sqlStr=new StringBuilder();
		sqlStr.append("select DISTINCT ");
		sqlStr.append("ci.code_or Code_or, ");
		sqlStr.append("ci.sd_srvtp sd_srvtp, ");
		sqlStr.append("cgitm.fg_st fg_st, ");
		sqlStr.append("cg.dt_cg dt_cg, ");
		sqlStr.append("dep.name name_dep, ");
		sqlStr.append("depmp.name name_mpdep,");
		sqlStr.append("psndoc.name name_emp ");
		sqlStr.append("from bl_cg_itm_oep cgitm ");
		sqlStr.append("INNER join bl_cg_oep cg on cg.id_cgoep=cgitm.id_cgoep ");
		sqlStr.append("left join ci_order ci on ci.id_or=cgitm.id_or ");
		sqlStr.append("left join bd_dep dep on dep.id_dep = ci.id_dep_or ");
		sqlStr.append("left join bd_dep depmp on depmp.id_dep = cgitm.id_dep_mp ");
		sqlStr.append("left join bd_psndoc psndoc on psndoc.id_psndoc=ci.id_emp_or ");
		sqlStr.append("where cgitm.id_ent=?" );
		// 	0159078: 自助机----查询门诊费用明细提示找不到明细    ----服务信息查询与医嘱信息查询限制条件应该一致
		sqlStr.append("and cg.eu_direct='1'  ");
		sqlStr.append("and cgitm.fg_refund='N' ");
		SqlParam param=new SqlParam();
		param.addParam(entId);
		
		@SuppressWarnings("unchecked")
		List<BlBillClassificationDTO> list = (List<BlBillClassificationDTO>)new DAFacade().execQuery(sqlStr.toString(), param, new BeanListHandler(BlBillClassificationDTO.class));
		return list.toArray(new BlBillClassificationDTO[0]);
		
		
	}
	
	/**
	 * 查询本次就诊的账单项
	 * @return
	 * @throws BizException 
	 */
	private BlBillClassificationDTO[] findBillTypeInfo(String entId) throws BizException{
		StringBuilder sql=new StringBuilder();
		sql.append(" select  ");
		sql.append(" cgitm.name_inccaitm, ");
		sql.append(" cgitm.code_inccaitm, ");
		sql.append(" sum(cgitm.amt_ratio * cg.eu_direct) amt ");
		sql.append(" from bl_cg_itm_oep cgitm ");
		sql.append(" inner join bl_cg_oep cg on cg.id_cgoep=cgitm.id_cgoep ");
		sql.append(" where cgitm.id_ent=? ");
		sql.append(" GROUP BY  ");
		sql.append(" cgitm.name_inccaitm, ");
		sql.append(" cgitm.code_inccaitm ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		@SuppressWarnings("unchecked")
		List<BlBillClassificationDTO> list = (List<BlBillClassificationDTO>)new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(BlBillClassificationDTO.class));
		return list.toArray(new BlBillClassificationDTO[0]);
	}
	
	
	/**
	 * 根据人员id和就诊次数查询就诊信息
	 * @param patId
	 * @param enTimes
	 * @return
	 * @throws BizException 
	 */
	private PatiVisitDO findEntInfo(String patId,String enTimes) throws BizException{
		StringBuilder sql=new StringBuilder();
		sql.append(" select ent.id_ent from  ");
		sql.append(" en_ent ent ");
		sql.append(" INNER join en_ent_op entop on ent.id_ent=entop.id_ent ");
		sql.append(" where ent.id_pat=? ");
		sql.append(" and entop.times_op=? ");
		SqlParam param=new SqlParam();
		param.addParam(patId);
		if(!StringUtil.isEmpty(enTimes)){
			param.addParam(enTimes);
		}else{
			//查询这个患者当前的就诊次数
			String timesOp = this.getTimesOp(patId);
			param.addParam(timesOp);
		}
		
		@SuppressWarnings("unchecked")
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sql.toString(),param,
				new BeanListHandler(PatiVisitDO.class));
		if(list==null || list.size()==0){
			throw new BizException("门诊费用清单查询：未查询到该次就诊数据");
		}
		return list.get(0);
	}
	
	/**
	 * 根据患者id查询到患者当前的就诊次数
	 * @return
	 * @throws DAException 
	 */
	private String getTimesOp(String patId) throws BizException{
		StringBuilder sql=new StringBuilder();
		sql.append(" select entop.times_op ");
		sql.append(" from en_ent ent ");
		sql.append(" inner join en_ent_op entop ");
		sql.append(" on ent.id_ent = entop.id_ent ");
		sql.append(" where ent.id_pat = ? ");
		sql.append(" order by entop.sv desc ");
  
		SqlParam param=new SqlParam();
		param.addParam(patId);
		
		@SuppressWarnings("unchecked")
		List<OutpatientDO> list = (List<OutpatientDO>) new DAFacade().execQuery(sql.toString(),param,
				new BeanListHandler(OutpatientDO.class));
		
		if(list==null || list.size()==0){
			throw new BizException("门诊费用清单查询：未查询到该患者的当前就诊次数");
		}
		return list.get(0).getTimes_op().toString();
	}
	
	
	
	/**
	 * 查询患者
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(WsParamBillPatInfo prepayInfo)throws BizException {
	
		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(prepayInfo.getPatCode());
		condDto.setId_code(prepayInfo.getSdCode());
		condDto.setCard_code(prepayInfo.getCardCode());
		
		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if(ArrayUtil.isEmpty(patiAggs)){
			throw new BizException("门诊费用清单查询:未查询到患者信息");
		}
		
		return patiAggs[0].getParentDO().getId_pat();
	}
}
