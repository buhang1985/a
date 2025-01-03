package iih.bl.st.s.bp.ip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.IBlConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayVDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.bl.prop.blproparip.d.BlPropArIpDO;
import iih.bl.prop.blproparip.d.BlproparipAggDO;
import iih.bl.prop.blpropip.d.BlPropIpDO;
import iih.bl.prop.i.IBlPropCmdService;
import iih.bl.prop.i.IBlPropQryService;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatip.bp.BlPayPatIpBp;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipCudService;
import iih.bl.st.blpaypatip.i.IBlpaypatipRService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.listrener.event.BlStIpEvent;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.MiFlowType;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院取消出纳
 * @author ly 2018/04/24
 *
 */
public class IpStCancelTradeBP {

	FDateTime now = null;
	
	/**
	 * 住院取消出纳
	 * @param stIpId 结算id
	 * @return 患者预交金患者记录
	 * @throws BizException
	 */
	public void exec(String idEnt, String stIpId, FBoolean isSaveProp ) throws BizException{
		
		if(StringUtil.isEmpty(stIpId)){
			throw new ArgumentNullException("住院取消出纳","结算id");
		}
		
		//获取结算信息
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO blstip = stRService.findById(stIpId);
		
		//根据就诊id查询PatiVisitDO
		IPativisitRService  patiRSer = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiVisitDos =  patiRSer.findByAttrValString("Id_ent", idEnt);
		if(ArrayUtil.isEmpty(patiVisitDos)){
			throw new BizException("做退款业务时，未查询到该患者的就诊信息！");
		}
		
		now = AppUtils.getServerDateTime();
		
		// TODO 以后再改，目前直接调用了
		BlPayPatIpBp refundBp = new BlPayPatIpBp();
		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();
		OperatorInfoDTO opreDto = new OperatorInfoDTO();
		opreDto.setId_grp(Context.get().getGroupId());
		opreDto.setId_org(Context.get().getOrgId());
		opreDto.setId_dep(Context.get().getDeptId());
		opreDto.setId_emp(Context.get().getStuffId());
		
		//红冲结算数据
		BlStIpDO redBlStIpDO = refundBp.setBlStIpRefund(opreDto, stIpId, now, blEventInfoDTO);
		blEventInfoDTO.setBlStIpRedDO(redBlStIpDO);
		
		//红冲分摊数据		
		if(isSaveProp.booleanValue()){
			InsureContext insureContext = new InsureContext();
			insureContext.setIdHp(patiVisitDos[0].getId_hp());
			saveBackPropData(stIpId,redBlStIpDO.getId_stip(),insureContext);
		}
		
		//红冲记账信息
		refundBp.setBlCgIpRefund(stIpId, redBlStIpDO, now, blEventInfoDTO);
		
		//红冲发票信息
		refundBp.setBlStIpIncRefund(opreDto, stIpId, redBlStIpDO, now, blEventInfoDTO);
		
		//构造红冲收付款信息 new
		BlpaypatipAggDO redPayAggDO = this.assembleRedPayData(stIpId, redBlStIpDO);
		
//		//结存预交金红冲 new
//		FDouble transAmt = this.refundTransferPrepay(stIpId);
//		
//		//原首付款信息中如果使用了预付费，则生成新的预付费充值数据
//		Map<String,String> prepayIdMap = this.restorePrepayData(redPayAggDO);
		
		// 2018/07/24 剥离预交金处理
		Map<String, String> prepayIdMap = this.dealPrepay(redPayAggDO, blstip);
				
		
		//保存红冲收付款信息
		redPayAggDO = this.saveRedPayInfo(redPayAggDO, prepayIdMap);
		blEventInfoDTO.setBlpaypatipRedAggDO(redPayAggDO);
		
//		//修改就诊账户数据,还原预交金金额
//		FDouble amt = new FDouble(0);
//		for (BlPayItmPatIpDO payItmDO : redPayAggDO.getBlPayItmPatIpDO()) {
//			if(IBlBizDataConst.SD_PRI_PM_PREPAY.equals(payItmDO.getSd_pm())){
//				amt = amt.add(payItmDO.getAmt());
//			}
//		}
//		
//		amt = amt.sub(transAmt);
		refundBp.setEntEntAccoutInfoByRefund(redBlStIpDO, FDouble.ZERO_DBL);
		
		//前置流程下结算+明细+分摊+前置分摊
		if (isSaveProp.booleanValue()) {			
			InsureContext insureContext = new InsureContext();
			insureContext.setIdHp(patiVisitDos[0].getId_hp());
			InsureFacade facade=new InsureFacade(insureContext);
			String flowType = facade.GetHpFlowType();
			if (flowType.equals(MiFlowType.PREFLOW)) {
				//前置流程下不修改就诊信息
				BackPayReDoStBp handlerBp=new BackPayReDoStBp();
				handlerBp.exec(stIpId,insureContext);
			}
			else{
				//正常医保流程
				refundBp.setEnEntInfoByIdStip(stIpId, blEventInfoDTO);
			}
		}
		else{
			//自费状态
			refundBp.setEnEntInfoByIdStip(stIpId, blEventInfoDTO);
		}
		if(StTypeEnum.ST_INP.equals(blstip.getEu_sttp())){
			refundBp.upEntFgPay(patiVisitDos[0]);
		}
		//发送事件
		BlStIpEvent blStIpEvent = new BlStIpEvent();
		blStIpEvent.invokeRefund(blEventInfoDTO);
	}

	/**
	 * 红冲首付款数据
	 * @param stIpId
	 * @param blStIpDO
	 * @param now
	 * @return
	 * @throws BizException
	 */
	private BlpaypatipAggDO assembleRedPayData(String stIpId,BlStIpDO blStIpDO) throws BizException{
		
		IBlpaypatipRService payRService = ServiceFinder.find(IBlpaypatipRService.class);
		BlpaypatipAggDO[] payAggDos = payRService.find(" a0.id_stip = '" + stIpId + "'", null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(payAggDos)){
			throw new BizException("住院取消出纳:未查询到收付款信息");
		}
		
		//全部红冲
		BlpaypatipAggDO oldPayAgg = payAggDos[0];
		BlpaypatipAggDO redPayAgg = new BlpaypatipAggDO();
		
		//主表红冲
		BlPayPatIpDO payDO = (BlPayPatIpDO)oldPayAgg.getParentDO().clone();
		payDO.setId_paypatip(null);
		payDO.setId_stip(blStIpDO.getId_stip());
		payDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_CANCELST);
		payDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_CANCELST);
		payDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		payDO.setDt_pay(now);
		payDO.setId_org_pay(Context.get().getOrgId());
		payDO.setId_dep_pay(Context.get().getDeptId());
		payDO.setId_emp_pay(Context.get().getStuffId());
		payDO.setId_cc(null);
		payDO.setFg_cc(FBoolean.FALSE);
		payDO.setNote(IBlConst.NOTE_CANCELSETTLEMENT);
		payDO.setCreatedby(null);
		payDO.setCreatedtime(null);
		payDO.setModifiedby(null);
		payDO.setModifiedtime(null);
		payDO.setStatus(DOStatus.NEW);
		redPayAgg.setParentDO(payDO);
		
		//子表全部红冲
		List<BlPayItmPatIpDO> redPayItmList = new ArrayList<BlPayItmPatIpDO>();
		for (BlPayItmPatIpDO oldPayItmDO : oldPayAgg.getBlPayItmPatIpDO()) {
			BlPayItmPatIpDO payItmDO = (BlPayItmPatIpDO)oldPayItmDO.clone();
			payItmDO.setId_payitmpatip(null);
			payItmDO.setId_paypatip(null);
			payItmDO.setEu_direct(payItmDO.getEu_direct() * BookRtnDirectEnum.RETURNS);
			payItmDO.setFg_realpay(FBoolean.TRUE);
			payItmDO.setId_bank(null);
			payItmDO.setBankno(null);
			payItmDO.setPaymodenode(null);
			payItmDO.setStatus(DOStatus.NEW);
			//预交金收付款保留原始，后续处理
			redPayItmList.add(payItmDO);
		}
		redPayAgg.setBlPayItmPatIpDO(redPayItmList.toArray(new BlPayItmPatIpDO[0]));
		
		return redPayAgg;
	}

	/**
	 * 红冲结存的预交金数据
	 * @param stIpId
	 * @throws BizException
	 */
	private FDouble refundTransferPrepay(String stIpId) throws BizException{
		IBlpaypatRService rService = ServiceFinder.find(IBlpaypatRService.class);
		
		String whereSql = "id_st_mid = '" + stIpId + "' and fg_rep_return = 'N'";
		BlPrePayPatDO[] prepayDos = rService.find(whereSql, "", FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(prepayDos))
			return FDouble.ZERO_DBL;
		
		FDouble amt = new FDouble(0);
		//红冲结转预付费信息
		List<BlPrePayPatDO> redPayList = new ArrayList<BlPrePayPatDO>();
		for (BlPrePayPatDO oldDO : prepayDos) {
			
			//计算原结转金额合
			amt = amt.add(oldDO.getAmt().multiply(oldDO.getEu_direct()));
			
			BlPrePayPatDO newDO = (BlPrePayPatDO)oldDO.clone();
			newDO.setId_paypat(null);
			newDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
			newDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
			newDO.setEu_direct(oldDO.getEu_direct()*BookRtnDirectEnum.RETURNS);
			newDO.setDt_pay(now);
			newDO.setFg_rep_return(FBoolean.FALSE);
			newDO.setId_rep_lost(null);
			newDO.setSd_rep_lost(null);
			newDO.setDt_return(null);
			newDO.setId_emp_return(null);
			newDO.setNote(IBlConst.NOTE_CANCELSETTLEMENT);
			newDO.setCreatedby(null);
			newDO.setCreatedtime(null);
			newDO.setModifiedby(null);
			newDO.setModifiedtime(null);
			newDO.setStatus(DOStatus.NEW);
			
			redPayList.add(newDO);
			
			oldDO.setFg_rep_return(FBoolean.TRUE);
			oldDO.setDt_return(now);
			oldDO.setId_emp_return(Context.get().getStuffId());
			oldDO.setStatus(DOStatus.UPDATED);
			
			redPayList.add(oldDO);
		}
		
		IBlpaypatCudService cudService = ServiceFinder.find(IBlpaypatCudService.class);
		cudService.save(redPayList.toArray(new BlPrePayPatDO[0]));
		
		return amt;
	}

	/**
	 * 还原上次付款使用过的预付费记录
	 * @param redPayAggDO
	 * @return key:原预付费id value:新预付费id
	 * @throws BizException
	 */
	private Map<String,String> restorePrepayData(BlpaypatipAggDO redPayAggDO)throws BizException{
		
		List<String> oldPrepayKeyList = new ArrayList<String>();
		for (BlPayItmPatIpDO payItm : redPayAggDO.getBlPayItmPatIpDO()) {
			
			if(!StringUtil.isEmpty(payItm.getId_paypat())){
				oldPrepayKeyList.add(payItm.getId_paypat());
			}
		}
		
		if(oldPrepayKeyList.size() == 0)
			return null;
		
		IBlpaypatRService rService = ServiceFinder.find(IBlpaypatRService.class);
		BlPrePayPatDO[] prepayDos = rService.findByIds(oldPrepayKeyList.toArray(new String[0]), FBoolean.FALSE);
		if(ArrayUtil.isEmpty(prepayDos)){
			throw new BizException("住院取消出纳:未查询到原收付款使用的预付费记录");
		}
		
		List<String> oldSortKeyList = new ArrayList<String>();//与检索记录顺序一致的key
		List<BlPrePayPatDO> prepayList = new ArrayList<BlPrePayPatDO>();
		for (BlPrePayPatDO oldPrepayDO : prepayDos) {
			oldSortKeyList.add(oldPrepayDO.getId_paypat());
			BlPrePayPatDO newDO = (BlPrePayPatDO)oldPrepayDO.clone();
			
			newDO.setId_paypat(null);
			newDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
			newDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
			newDO.setEu_direct(BookRtnDirectEnum.CHARGE);
			newDO.setDt_pay(now);
			newDO.setId_st_mid(null);
			newDO.setFg_rep_return(FBoolean.FALSE);
			newDO.setId_rep_lost(null);
			newDO.setSd_rep_lost(null);
			newDO.setDt_return(null);
			newDO.setId_emp_return(null);
			newDO.setNote(IBlConst.NOTE_CANCELSETTLEMENT);
			newDO.setCreatedby(null);
			newDO.setCreatedtime(null);
			newDO.setModifiedby(null);
			newDO.setModifiedtime(null);
			newDO.setStatus(DOStatus.NEW);
			
			prepayList.add(newDO);
		}
		
		IBlpaypatCudService cudService = ServiceFinder.find(IBlpaypatCudService.class);
		BlPrePayPatDO[] newDos = cudService.insert(prepayList.toArray(new BlPrePayPatDO[0]));
		
		Map<String,String> prepayIdMap = new HashMap<String,String>();
		for (int i = 0; i < newDos.length; i++) {
			prepayIdMap.put(oldSortKeyList.get(i), newDos[i].getId_paypat());
		}
		
		return prepayIdMap;
	}

	/**
	 * 保存红冲收付款数据
	 * @param payAggDO
	 * @param prepayIdMap
	 * @return
	 * @throws BizException
	 */
	private BlpaypatipAggDO saveRedPayInfo(BlpaypatipAggDO redPayAggDO,Map<String,String> prepayIdMap)throws BizException{

		if(prepayIdMap != null && prepayIdMap.size() > 0){
			for (BlPayItmPatIpDO payItm : redPayAggDO.getBlPayItmPatIpDO()) {
				if(!StringUtil.isEmpty(payItm.getId_paypat())){
					payItm.setId_paypat(prepayIdMap.get(payItm.getId_paypat()));
				}
			}
		}
		
		IBlpaypatipCudService cudService = ServiceFinder.find(IBlpaypatipCudService.class);
		return cudService.insert(new BlpaypatipAggDO[]{redPayAggDO})[0];
	}
	
	/**
	 * 保存退费红冲分摊数据
	 * @param strStId 退费结算id
	 * @param insureContext
	 * @throws BizException
	 */
	private void saveBackPropData(String strStIdOriginal,String strStIdBack,InsureContext insureContext) throws BizException
	{
		IBlPropQryService propQryService=ServiceFinder.find(IBlPropQryService.class);
		FMap2 map=propQryService.getIpHpPropAggDo(strStIdOriginal);
		BlPropIpDO ipPropDo=(BlPropIpDO)map.get("PropIp");
		BlproparipAggDO propArDo=(BlproparipAggDO)map.get("PropArIpAgg");
		
		//医保分摊数据
		BlPropIpDO propIpDoBack=(BlPropIpDO)ipPropDo.clone();
		propIpDoBack.setId_propip(null);
		//记录方向
		propIpDoBack.setEu_direct(BookRtnDirectEnum.RETURNS);
		ipPropDo.setId_propip(null);
		ipPropDo.setEu_direct(-1);
		ipPropDo.setId_stip(strStIdBack);
		ipPropDo.setStatus(DOStatus.NEW);
		//保存应收数据
		BlproparipAggDO aggDoBack=new BlproparipAggDO();
		BlPropArIpDO propAripDoBack=(BlPropArIpDO)propArDo.getParentDO().clone();
		propAripDoBack.setId_proparip(null);
		propAripDoBack.setEu_direct(-1);
		propAripDoBack.setStatus(DOStatus.NEW);
		aggDoBack.setParentDO(propAripDoBack);
		IBlPropCmdService propCmdService = ServiceFinder.find(IBlPropCmdService.class);
		FMap2 mapBackData=propCmdService.saveIpPropData(ipPropDo, aggDoBack);
		
		BlproparipAggDO[] arIpAggDoArr=(BlproparipAggDO[])mapBackData.get("proparip");
		//医保扩展表存储
		InsureFacade facade=new InsureFacade(insureContext);
		HisPropertyRefHpDTO propertyRefHpDto=new HisPropertyRefHpDTO();
		propertyRefHpDto.setId_ref(arIpAggDoArr[0].getParentDO().getId_proparip());
		propertyRefHpDto.setId_refold(propArDo.getParentDO().getId_proparip());
		facade.saveBackPayPropData(null,propertyRefHpDto);
	}
	/**
	 * 预交金处理
	 * @param redPayAggDO
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String,String> dealPrepay(BlpaypatipAggDO redPayAggDO,BlStIpDO blstip) throws BizException{
		
		Map<String,String> map = new HashMap<String,String>();
		List<String> prepayIdList = new ArrayList<String>();
		for (BlPayItmPatIpDO itmDO : redPayAggDO.getBlPayItmPatIpDO()) {
			
			if(!StringUtil.isEmpty(itmDO.getId_paypat())){
				prepayIdList.add(itmDO.getId_paypat());
			}
		}
		
		if(prepayIdList.size() == 0)
			return map;
		
		FArrayList keyList = new FArrayList();
		keyList.addAll(prepayIdList);
		BlPrepayVDTO vDto = new BlPrepayVDTO();
		vDto.setId_ent(blstip.getId_ent());
		vDto.setId_st(blstip.getId_stip());
		vDto.setPrepayids(keyList);
		
		BlPrepaySetDTO setDto = new BlPrepaySetDTO();
		setDto.setFg_accupdate(FBoolean.TRUE);
		setDto.setFg_print(FBoolean.TRUE);
		
		IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);
		Map<String,BlPrePayPatDO> prepayMap = prepayService.cancelTrade(vDto, setDto);
		
		for (String key : prepayMap.keySet()) {
			
			map.put(key, prepayMap.get(key).getId_paypat());
		}
		
		return map;
	}
}
