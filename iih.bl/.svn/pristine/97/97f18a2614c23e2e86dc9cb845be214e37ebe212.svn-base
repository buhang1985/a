package iih.bl.st.blstiparrears.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipCudService;
import iih.bl.st.blpaypatip.i.IBlpaypatipMDORService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.dto.d.DebtPayBackDTO;
import iih.bl.st.listrener.event.BlStIpEvent;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 欠款补交结算
 * @author weijia
 * */
public class BlStIpArrearsBp {
	
	/**
	 * 获取就诊欠款结算信息
	 * @throws BizException 
	 * */
	public DebtPayBackDTO[] getBlStIpArrearsByIdEnt(String id_ent) throws BizException{
		IBlstipRService service = ServiceFinder.find(IBlstipRService.class);
		StringBuffer sqlQur = new StringBuffer();
		sqlQur.append(" a0.id_ent = '").append(id_ent).append("'")
		      .append(" and a0.fg_pay = 'Y' and a0.fg_arclear = 'N' and a0.fg_canc = 'N'");
		BlStIpDO[] blStIpDOArr = service.find(sqlQur.toString(), null, FBoolean.FALSE);
		List<DebtPayBackDTO> debtPayBackDTOList = new ArrayList<DebtPayBackDTO>();
		if(blStIpDOArr != null){
			Map<String,BlPayPatIpDO> map = this.getBlStPayPatMapByIdEnt(id_ent);
			for(BlStIpDO blStIpDO : blStIpDOArr){
				DebtPayBackDTO debtPayBackDTO = new DebtPayBackDTO();
				debtPayBackDTO.setId_stip(blStIpDO.getId_stip());
				debtPayBackDTO.setCode_st(blStIpDO.getCode_st());
				BlPayPatIpDO blPayPatIpDO = map.get(blStIpDO.getId_stip());
				if(blPayPatIpDO != null){
					debtPayBackDTO.setAmt_debt(blStIpDO.getAmt().sub(blPayPatIpDO.getAmt()));
				}else{
					debtPayBackDTO.setAmt_debt(blStIpDO.getAmt());
				}
				debtPayBackDTO.setDt_st(blStIpDO.getDt_st());
				debtPayBackDTOList.add(debtPayBackDTO);
			}
		}
		return debtPayBackDTOList.toArray(new DebtPayBackDTO[]{});
	}
	
	/**
	 * 住院结算欠费补交
	 * */
	public FBoolean doStArrearsStPayment(OperatorInfoDTO operatorInfoDTO, BlPayPatIpDO blPayPatIpDO, BlPayItmPatIpDO[] blPayItmPatIpDOArr) throws BizException{
		//获取结算信息
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO blStIpDO = stRService.findById(blPayPatIpDO.getId_stip());
		
		//获取当前服务器时间
		TimeService timeService = new TimeServiceImpl();
		FDateTime dateTime = timeService.getUFDateTime();
		
		//修改结算数据
		blStIpDO = this.updateBlStIpInfo(blStIpDO);
		
		//结算收付款记录
		BlpaypatipAggDO blpaypatipAggDO = this.setBlStIpPayInfo(operatorInfoDTO, blStIpDO, blPayPatIpDO, blPayItmPatIpDOArr, dateTime);
		
		//发送事件
		this.invokeArrearsEvent(blStIpDO, blpaypatipAggDO);
		
		return FBoolean.TRUE;
	}
	
	/**
	 * 住院结算欠款补交发送事件
	 * @throws BizException 
	 * */
	public void invokeArrearsEvent(BlStIpDO blStIpDO,BlpaypatipAggDO blPayPatIpAggDO) throws BizException{
		//发送事件
		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();
		blEventInfoDTO.setBlpaypatipAggDO(blPayPatIpAggDO);
		blEventInfoDTO.setBlStIpDO(blStIpDO);
		
		BlStIpEvent blStIpEvent = new BlStIpEvent();
		blStIpEvent.invokeArrears(blEventInfoDTO);
	}
	
	/**
	 * 获取就诊相关收付款信息
	 * */
	public Map<String,BlPayPatIpDO> getBlStPayPatMapByIdEnt(String id_ent) throws BizException{
		Map<String,BlPayPatIpDO> map = new HashMap<String,BlPayPatIpDO>();
		IBlpaypatipMDORService service = ServiceFinder.find(IBlpaypatipMDORService.class);
		StringBuffer sqlQur = new StringBuffer();
		sqlQur.append(" a0.id_ent = '").append(id_ent).append("'");
		BlPayPatIpDO[] blPayPatIpDOArr = service.find(sqlQur.toString(), null, FBoolean.FALSE);
		if(blPayPatIpDOArr != null){
			for(BlPayPatIpDO blPayPatIpDO : blPayPatIpDOArr){
				map.put(blPayPatIpDO.getId_stip(), blPayPatIpDO);
			}
		}
		return map;
	}
	
	/**
	 * 修改结算信息
	 * */
	public BlStIpDO updateBlStIpInfo(BlStIpDO blStIpDO) throws BizException{
		IBlstipCudService service = ServiceFinder.find(IBlstipCudService.class);
		blStIpDO.setFg_arclear(FBoolean.TRUE);
		blStIpDO.setStatus(DOStatus.UPDATED);
		BlStIpDO[] blStIpDOArr = service.save(new BlStIpDO[]{blStIpDO});
		if(blStIpDOArr == null || blStIpDOArr.length == 0){
			throw new BizException("修改结算信息失败！");
		}
		return blStIpDOArr[0];
	}
	
	/**
	 * 结算收付款记录
	 * */
	public BlpaypatipAggDO setBlStIpPayInfo(OperatorInfoDTO operatorInfoDTO, BlStIpDO blStIpDO, BlPayPatIpDO blPayPatIpDO, BlPayItmPatIpDO[] blPayItmPatIpDOArr,FDateTime dateTime)
		throws BizException{
		IBlpaypatipCudService payCService = ServiceFinder.find(IBlpaypatipCudService.class);
		BlpaypatipAggDO blPayPatIpAggDO = new BlpaypatipAggDO();
		//主
		blPayPatIpDO.setId_org(operatorInfoDTO.getId_org());
		blPayPatIpDO.setId_grp(operatorInfoDTO.getId_grp());
		blPayPatIpDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ARREARSPAY);
		blPayPatIpDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ARREARSPAY);
		blPayPatIpDO.setId_enttp(blStIpDO.getId_enttp());
		blPayPatIpDO.setCode_enttp(blStIpDO.getCode_enttp());
		blPayPatIpDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		blPayPatIpDO.setDt_pay(dateTime);
		blPayPatIpDO.setId_org_pay(operatorInfoDTO.getId_org());
		blPayPatIpDO.setId_dep_pay(operatorInfoDTO.getId_dep());
		blPayPatIpDO.setId_emp_pay(operatorInfoDTO.getId_emp());
		blPayPatIpDO.setId_cc(null);
		blPayPatIpDO.setFg_cc(FBoolean.FALSE);
		blPayPatIpDO.setStatus(DOStatus.NEW);
		
		//子
		for(BlPayItmPatIpDO blPayItmPatIpDO : blPayItmPatIpDOArr){
			blPayItmPatIpDO.setId_org(operatorInfoDTO.getId_org());
			if(blPayItmPatIpDO.getId_pm() == null){
				if(IBdPripmCodeConst.CODE_PRI_PM_CASH.equals(blPayItmPatIpDO.getPm_code())){//现金
					blPayItmPatIpDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CASH);
					blPayItmPatIpDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
				}else if(IBdPripmCodeConst.CODE_PRI_PM_CREDIT.equals(blPayItmPatIpDO.getPm_code())){//信用卡
					blPayItmPatIpDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CREDIT);
					blPayItmPatIpDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CREDIT);
				}else if(IBdPripmCodeConst.CODE_PRI_PM_CHECK.equals(blPayItmPatIpDO.getPm_code())){//支票
					blPayItmPatIpDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CHECK);
					blPayItmPatIpDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CHECK);
				}else if(IBdPripmCodeConst.CODE_PRI_PM_DEAFT.equals(blPayItmPatIpDO.getPm_code())){//汇票
					blPayItmPatIpDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_DEAFT);
					blPayItmPatIpDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_DEAFT);
				}else if(IBdPripmCodeConst.CODE_PRI_PM_PAY.equals(blPayItmPatIpDO.getPm_code())){//预交金
					blPayItmPatIpDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
					blPayItmPatIpDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
				}
			}
			if(blPayPatIpDO.getAmt() == null){
				blPayPatIpDO.setAmt(new FDouble(0));
			}
			blPayPatIpDO.setAmt(blPayPatIpDO.getAmt().add(blPayItmPatIpDO.getAmt().multiply(blPayItmPatIpDO.getEu_direct())));
			blPayItmPatIpDO.setFg_realpay(FBoolean.TRUE);//新加字段
			blPayItmPatIpDO.setStatus(DOStatus.NEW);
		}

		blPayPatIpAggDO.setParentDO(blPayPatIpDO);
		blPayPatIpAggDO.setBlPayItmPatIpDO(blPayItmPatIpDOArr);
		
		BlpaypatipAggDO[] blpaypatipAggDOArr = payCService.save(new BlpaypatipAggDO[]{blPayPatIpAggDO});
		if(blpaypatipAggDOArr == null || blpaypatipAggDOArr.length == 0){
			throw new BizException("结算收付款记录保存失败！");
		}
		blPayPatIpAggDO = blpaypatipAggDOArr[0];
		return blPayPatIpAggDO;
	}
	
	/**
	 * 修改就诊账户
	 * */
	public void updateEnAccountInfo(String id_ent, BlpaypatipAggDO blPayPatIpAggDO) throws BizException{
//		IEnaccountMDOCudService enCService = ServiceFinder.find(IEnaccountMDOCudService.class);
//		IEnaccountMDORService enRService = ServiceFinder.find(IEnaccountMDORService.class);
//		EnAccountDO[] enAccountDOArr = enRService.find(" a0.id_ent = '" + id_ent + "' ", null, FBoolean.FALSE);
//		if(enAccountDOArr == null || enAccountDOArr.length == 0){
//			throw new BizException("就诊账户不存在！");
//		}
//		EnAccountDO enAccountDO = enAccountDOArr[0];
//		enAccountDO.setAmt_uncg(enAccountDO.getAmt_uncg().sub(blPayPatIpAggDO.getParentDO().getAmt()));//就诊未结算费用(原数值减去本次MIN(实收金额，应收金额))
//		enAccountDO.setStatus(DOStatus.UPDATED);
//		enCService.save(enAccountDOArr);
		
		IEnOutCmdService service = ServiceFinder.find(IEnOutCmdService.class);
		service.consume(id_ent, blPayPatIpAggDO.getParentDO().getAmt());
	}
	
	/**
	 * 获取欠款补交结算节点就诊信息（已结算，已付款，欠款）
	 * */
	@SuppressWarnings("unchecked")
	public PatiVisitDO[] getBlStIpArrearsBanner(String id_pat) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct t.id_ent,t.code,t.name_pat ")
			  .append("from en_ent t ")
			  .append("inner join bl_st_ip s on s.id_ent = t.id_ent ")
			  .append("where t.id_pat = '").append(id_pat).append("' ")
			  .append("and t.code_entp = 10 ")
			  .append("and t.fg_canc = 'N' ")
			  //.append("and t.fg_st = 'Y' ")
			  .append("and s.fg_pay = 'Y' ")
			  .append("and s.fg_arclear = 'N' ");
		List<PatiVisitDO> list = (List<PatiVisitDO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(PatiVisitDO.class));
		return list.toArray(new PatiVisitDO[]{});
	}
	
	/**
	 * 根据banner中输入值查询相关患者就诊信息(欠款补交结算节点，已结算，已付款，欠款)
	 * */
	@SuppressWarnings("unchecked")
	public BlBannerDTO[] getArrearsIpBannerEnEntInfo(String inputValue,String[] selectCondition) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct(t.id_ent),p.id_pat,p.name as name_pat,t.code as code_ent,t.dt_entry as dt_in,e.times_ip,r.id_pripat,r.name as name_pripat,h.id_hp,h.name as name_hp,t.fg_ip ")
		    .append("from en_ent t ")
		    .append("left join pi_pat p on p.id_pat = t.id_pat ")
		    .append("left join en_ent_ip e on e.id_ent = t.id_ent ")
		    .append("left join bd_pri_pat r on r.id_pripat = t.id_pripat ")
		    .append("left join en_ent_hp n on n.id_ent = t.id_ent and n.fg_maj = 'Y' ")
		    .append("left join bd_hp h on h.id_hp = n.id_hp ")
		    //.append("left join bl_st_ip s on s.id_ent = t.id_ent ")
			 .append("left outer join pi_pat_card c on c.id_pat = p.id_pat ")
			.append("where t.code_entp = 10 ")
			.append("and t.fg_canc = 'N'");
			//.append(" and s.fg_pay = 'Y' and s.fg_arclear = 'N' ");
		if(selectCondition != null && selectCondition.length > 0){
			sql.append("and (");
			StringBuffer wheresql = new StringBuffer();
			for(String cond : selectCondition){
				if("code_ent".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("t.code like '%").append(inputValue).append("%'");
				}else if("id_pat".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.id_pat like '%").append(inputValue).append("%'");
				}else if("code_pat".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.code like '%").append(inputValue).append("%'");
				}else if("id_code".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.id_code like '%").append(inputValue).append("%'");
				}else if("barcode_chis".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.barcode_chis like '%").append(inputValue).append("%'");
				}else if("code_amr_ip".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.code_amr_ip like '%").append(inputValue).append("%'");
				}else if("patcode".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("c.code like '%").append(inputValue).append("%'");
				}
			}
			sql.append(wheresql.toString());
			sql.append(") ");
		}
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new PatiVisitDO(), "t");//增加组织隔离
		sql.append(sqlContext);
		sql.append("order by p.id_pat,e.times_ip desc");
		List<BlBannerDTO> list = (List<BlBannerDTO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlBannerDTO.class));
		return list.toArray(new BlBannerDTO[]{});
	}
}
