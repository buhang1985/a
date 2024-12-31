package iih.bl.pay.s.bp.ip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepayCDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySTDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.event.IpRcvPayPatEvent;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.bl.pay.s.bp.util.PayAssembleUtil;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipCudService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.dto.blpayip.d.BlPayIpDTO;
import iih.bl.st.dto.blpayip.d.BlPayIpPmDTO;
import iih.bl.st.dto.blpayip.d.BlPayIpRltDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 住院收付款(新)
 * @author ly 2018/08/06
 *
 */
public class BlIpPaymentBP {

	/**
	 * 住院收付款(新)
	 * @param payIpDto 收付款信息
	 * @param payIpPmDtos 付款方式
	 * @param freeCgIds 减免项目
	 * @return 
	 * @throws BizException
	 * @author ly 2018/07/19
	 */
	@SuppressWarnings("unchecked")
	public BlPayIpRltDTO exec(BlPayIpDTO payIpDto, BlPayIpPmDTO[] payIpPmDtos, String[] freeCgIds) throws BizException {
		
		this.validate(payIpDto, payIpPmDtos, freeCgIds);
		
		if(FBoolean.TRUE.equals(payIpDto.getFg_print()) && FBoolean.TRUE.equals(payIpDto.getFg_arrears()) && FBoolean.FALSE.equals(BlParams.BLSTIP0037())){
			payIpDto.setFg_print(FBoolean.FALSE);
		}
		//查询并校验结算数据
		BlStIpDO stDO = this.getAndCheckStData(payIpDto.getId_st());
		
		//查询就诊数据
		PatiVisitDO entDO = ServiceFinder.find(IPativisitRService.class).findById(stDO.getId_ent());
		
		//查询记账明细数据
		BlCgIpDO[] cgDos = this.getCgData(payIpDto.getId_st());
		
		//更新减免
		this.setFreeItem(cgDos, freeCgIds);
		
		//核对各种金额
		this.checkAmt(payIpDto, payIpPmDtos, stDO, cgDos);
		
		//提前生成结转预交金主键
		this.createStPrepayPK(payIpPmDtos);
		
		//生成收付款数据
		BlpaypatipAggDO payAggDO = this.savePaymentInfo(stDO, payIpPmDtos, payIpDto);
		
		//生成发票数据
		BlincipAggDO[] incAggDos = this.saveIncInfo(cgDos, payIpPmDtos,stDO);
		
		//处理预交金消费，结转
		String[] transferIds = this.handlerPrepayInfo(payIpPmDtos, stDO, payIpDto);
		
		//更新记账数据
		this.updateCgData(cgDos);
		
		//更新结算数据
		this.updateStData(stDO, payIpDto, !ArrayUtil.isEmpty(transferIds), payIpPmDtos);
		
		//更新账户-->预交金处理里自动更新账户金额(处理锁定金额)
		this.updataUncg(stDO);
		
		if(FBoolean.TRUE.equals(payIpDto.getFg_print())){
			//更新发票数据
			IBlIncOutCmdService outIncCmdService=ServiceFinder.find(IBlIncOutCmdService.class);
			outIncCmdService.printIpInvoice(new String[]{payIpDto.getId_st()});
		}
		
		// 发送事件
		this.invokePayEvent(entDO, stDO, payAggDO, incAggDos[0]);
		
		//组织返回值
		BlPayIpRltDTO rltDto = new BlPayIpRltDTO();
		rltDto.setId_st(stDO.getId_stip());
		if(!ArrayUtil.isEmpty(transferIds)){
			FArrayList list = new FArrayList();
			list.addAll(Arrays.asList(transferIds));
			rltDto.setId_prepay(list);
		}
		if(!ArrayUtil.isEmpty(incAggDos)){
			FArrayList list = new FArrayList();
			for (BlincipAggDO aggDO : incAggDos) {
				list.add(aggDO.getParentDO().getId_incip());
			}
			rltDto.setId_incip(list);
		}
		
		return rltDto;
	}
	/***
	 * 修改账户的锁定金额
	 * @param cgDos
	 * @throws BizException
	 * @date 2018年9月20日
	 * @author wq.li
	 */
	private void updataUncg(BlStIpDO stDO) throws BizException{
		if(stDO==null){
			return;
		}
		//结算金额
		FDouble amt =FDouble.ZERO_DBL;
		amt=stDO.getAmt_ratio().multiply(stDO.getEu_direct());
		IEnOutCmdService inpPatAccImpls = ServiceFinder.find(IEnOutCmdService.class);
		// 修改消费金额
		inpPatAccImpls.consume(stDO.getId_ent(), amt.multiply(-1));
				
	}
	
	/**
	 * 参数校验
	 * @param payIpDto
	 * @param payIpPmDtos
	 * @param freeCgIds
	 * @throws BizException
	 */
	private void validate(BlPayIpDTO payIpDto,BlPayIpPmDTO[] payIpPmDtos, String[] freeCgIds) throws BizException {
		
		if(payIpDto == null){
			throw new ArgumentNullException("住院收付款", "收付款信息");
		}
		
		if(ArrayUtil.isEmpty(payIpPmDtos)){
			throw new ArgumentNullException("住院收付款", "付款方式");
		}
		
		if(StringUtil.isEmpty(payIpDto.getId_ent())){
			throw new ArgumentNullException("住院收付款", "就诊id");
		}
		
		if(StringUtil.isEmpty(payIpDto.getId_st())){
			throw new ArgumentNullException("住院收付款", "结算id");
		}
		
		if(StringUtil.isEmpty(payIpDto.getSd_pttp())){
			throw new ArgumentNullException("住院收付款", "付款终端");
		}
		
		if (payIpDto.getAmt() == null || payIpDto.getAmt_pay() == null
				|| payIpDto.getAmt_charge() == null) {
			throw new ArgumentNullException("住院收付款", "金额");
		}
		
		for (BlPayIpPmDTO pmDto : payIpPmDtos) {
			
			if(StringUtil.isEmpty(pmDto.getId_pm()) || StringUtil.isEmpty(pmDto.getSd_pm())){
				throw new ArgumentNullException("住院收付款", "付款方式");
			}
			
			if(pmDto.getAmt() == null){
				throw new ArgumentNullException("住院收付款", "金额");
			}
		}
	}
	
	/**
	 * 查询并校验结算数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	private BlStIpDO getAndCheckStData(String stId) throws BizException {
		
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO stDO = stRService.findById(stId);
		
		if(stDO == null){
			throw new BizException("住院收付款:未查询到结算信息，结算id:" + stId);
		}
		
		if(FBoolean.TRUE.equals(stDO.getFg_pay())){
			throw new BizException("住院收付款:该结算已经收款，结算号:" + stDO.getCode_st());
		}
		
		return stDO;
	}
	
	/**
	 * 查询记账数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlCgIpDO[] getCgData(String stId) throws BizException {
		
		DAFacade daf = new DAFacade();
		daf.setMaxRows(99999);
		List<BlCgIpDO> cgDoList = (List<BlCgIpDO>)daf.findByAttrValString(
				BlCgIpDO.class, BlCgIpDO.ID_STIP, stId, null);
		
		if(ListUtil.isEmpty(cgDoList)){
			throw new BizException("住院收付款:未查询到记账明细数据");
		}
		
		return cgDoList.toArray(new BlCgIpDO[0]);
	}
	
	/**
	 * 设置减免字段
	 * @param cgDos
	 * @param freeCgIds
	 * @throws BizException
	 */
	private void setFreeItem(BlCgIpDO[] cgDos,String[] freeCgIds) throws BizException {
		
		if(ArrayUtil.isEmpty(freeCgIds))
			return;
		
		for (String str : freeCgIds) {
			boolean has = false;
			for (BlCgIpDO cgDO : cgDos) {
				if(cgDO.getId_cgip().equals(str)){
					cgDO.setFg_free(FBoolean.TRUE);
					cgDO.setStatus(DOStatus.UPDATED);
					has = true;
					break;
				}
			}
			
			if(!has){
				throw new BizException("住院收付款:减免项目未匹配到记账数据，id:" + str);
			}
		}
	}
	
	/**
	 * 金额核对
	 * @param payIpDto
	 * @param payIpPmDtos
	 * @param stDO
	 * @param cgDos
	 * @throws BizException
	 */
	private void checkAmt(BlPayIpDTO payIpDto, BlPayIpPmDTO[] payIpPmDtos, BlStIpDO stDO, BlCgIpDO[] cgDos) throws BizException {

		//总金额=支付金额+找零金额=付款方式金额合计=结算总金额=明细项目金额合计
		//支付方式项目减免=减免项目金额合计
		//欠款结算时 付款方式金额合计<总金额
		//TODO
		
		
	}

	/**
	 * 生成结转预交金主键
	 * @param payIpPmDtos
	 * @throws BizException
	 */
	private void createStPrepayPK(BlPayIpPmDTO[] payIpPmDtos) throws BizException {
		
		for (BlPayIpPmDTO payIpPmDto : payIpPmDtos) {
			if(FBoolean.TRUE.equals(payIpPmDto.getFg_transfer())){
				payIpPmDto.setId_paypat( new DBUtil().getOIDs(1)[0]);
			}
		}
	}
	
	/**
	 * 保存收付款数据
	 * @param stDO
	 * @param payIpPmDtos
	 * @param payIpDto
	 * @return
	 * @throws BizException
	 */
	private BlpaypatipAggDO savePaymentInfo(BlStIpDO stDO, BlPayIpPmDTO[] payIpPmDtos, BlPayIpDTO payIpDto) throws BizException {

		BlpaypatipAggDO payAggDO = new BlpaypatipAggDO();
		BlPayPatIpDO payIpDO = PayAssembleUtil.assembleIpPayHeadData(stDO, payIpDto.getSd_pttp());
		BlPayItmPatIpDO[] payDetailDos = new BlPayItmPatIpDO[payIpPmDtos.length];
		
		for (int i = 0; i < payIpPmDtos.length; i++) {
			payDetailDos[i] = PayAssembleUtil.assembleIpPayDetailData(payIpPmDtos[i]);
		}
		
		payAggDO.setParentDO(payIpDO);
		payAggDO.setBlPayItmPatIpDO(payDetailDos);
		
		IBlpaypatipCudService payService = ServiceFinder.find(IBlpaypatipCudService.class);
		payAggDO = payService.insert(new BlpaypatipAggDO[]{payAggDO})[0];
		
		return payAggDO;
	}
	
	/**
	 * 保存发票数据
	 * @param cgDos
	 * @param payIpPmDtos
	 * @return
	 * @throws BizException
	 */
	private BlincipAggDO[] saveIncInfo(BlCgIpDO[] cgDos,BlPayIpPmDTO[] payIpPmDtos,BlStIpDO stDO) throws BizException {
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		FDouble freeAmt = null;
		for (BlPayIpPmDTO payIpPmDto : payIpPmDtos) {
			if(IBdPripmCodeConst.CODE_PRI_PM_MONEYDEDUCTION.equals(payIpPmDto.getSd_pm())){
				freeAmt = payIpPmDto.getAmt();
				break;
			}
		}
		
		BlincipAggDO[] aggDos = incService.saveIpInvoice(cgDos, freeAmt,stDO);
		return aggDos;
	}
	
	/**
	 * 处理预交金数据
	 * @param payIpPmDtos
	 * @return 结转预交金id
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private String[] handlerPrepayInfo(BlPayIpPmDTO[] payIpPmDtos,BlStIpDO stDO,BlPayIpDTO payIpDto) throws BizException {
		
		IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);
		
		List<String> consumeList = new ArrayList<String>(); //消费预交金id
		List<BlPrepaySTDTO> prepayStDtoList = new ArrayList<BlPrepaySTDTO>(); //结转 
		
		for (BlPayIpPmDTO payIpPmDto : payIpPmDtos) {
			if(FBoolean.TRUE.equals(payIpPmDto.getFg_transfer())){
				BlPrepaySTDTO stDto = new BlPrepaySTDTO();
				stDto.setId_ent(stDO.getId_ent());
				//stDto.setId_pecmpy(stDO.getId_pecmpy());
				stDto.setId_pm(payIpPmDto.getId_pm());
				stDto.setSd_pm(payIpPmDto.getSd_pm());
				stDto.setSd_pttp(payIpDto.getSd_pttp());
				stDto.setAmt(payIpPmDto.getAmt());
				stDto.setId_prepay_new(payIpPmDto.getId_paypat());
				stDto.setId_st(stDO.getId_stip());
				prepayStDtoList.add(stDto);
			}else if(IBdPripmCodeConst.CODE_PRI_PM_PAY.equals(payIpPmDto.getSd_pm())){
				consumeList.add(payIpPmDto.getId_paypat());
			}
		}

		if (consumeList.size() > 0) {
			BlPrepayCDTO cDto = new BlPrepayCDTO();
			cDto.setId_ent(stDO.getId_ent());
			//cDto.setId_pecmpy(stDO.getId_pecmpy());
			cDto.setSd_pttp(payIpDto.getSd_pttp());
			FArrayList idList = new FArrayList();
			idList.addAll(consumeList);
			cDto.setPrepayids(idList);
			
			BlPrepaySetDTO setDto = new BlPrepaySetDTO();
			setDto.setFg_accupdate(FBoolean.TRUE);
			setDto.setFg_print(FBoolean.FALSE);
			
			prepayService.consume(cDto, setDto);
		}

		if (prepayStDtoList.size() > 0) {

			BlPrepaySetDTO setDto = new BlPrepaySetDTO();
			setDto.setFg_accupdate(FBoolean.TRUE);
			setDto.setFg_print(FBoolean.TRUE);
			
			BlPrePayPatDO[] transferDtos = prepayService.stTransfer(
					prepayStDtoList.toArray(new BlPrepaySTDTO[0]), setDto);
			String[] tPrepayIds = new String[transferDtos.length];
			for (int i = 0; i < transferDtos.length; i++) {
				tPrepayIds[i] = transferDtos[i].getId_paypat();
			}
			
			return tPrepayIds;
		}
		
		return null;
	}

	/**
	 * 更新结算记账数据
	 * @param cgDos
	 * @param stDO
	 * @throws BizException
	 */
	private void updateCgData(BlCgIpDO[] cgDos) throws BizException {
		IBlcgqueryCudService cgService = ServiceFinder.find(IBlcgqueryCudService.class);
		cgService.save(cgDos);
	}
	
	/**
	 * 更新结算数据
	 * @param stDO
	 * @throws BizException
	 */
	private void updateStData(BlStIpDO stDO, BlPayIpDTO payIpDto, boolean hasTransfer, BlPayIpPmDTO[] payIpPmDtos) throws BizException {
		IBlstipCudService stService = ServiceFinder.find(IBlstipCudService.class);
		stDO.setFg_pay(FBoolean.TRUE);
		if (FBoolean.TRUE.equals(payIpDto.getFg_arrears())) {
			stDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_ARREARAGE);
			stDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_ARREARAGE);
		} else if (hasTransfer) {
			stDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_DEPOSIT);
			stDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_DEPOSIT);
		} else {
			stDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
			stDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		}	
		if (FBoolean.TRUE.equals(payIpDto.getFg_arrears())) {
			stDO.setFg_arclear(FBoolean.FALSE);
		} else {
			stDO.setFg_arclear(FBoolean.TRUE);
		}
		// du_peng 2019-02-22 -b mantis: 0144887
		// 将医保分摊结果回想写到结算表，（新农合分摊结果在多方付款“确认结算”时已回写结算表）
		for (BlPayIpPmDTO blPayIpPmDO : payIpPmDtos) {
			if (blPayIpPmDO.getSd_pm().equals(IBdPripmCodeConst.CODE_PRI_PM_INSUR)) {
				stDO.setAmt_hp(blPayIpPmDO.getAmt());
				stDO.setAmt_pat(stDO.getAmt_ratio().sub(blPayIpPmDO.getAmt()));
				break;
			}
		}
		// du_peng 2019-02-22 -e
		
		stService.update(new BlStIpDO[] { stDO });
	}
	
	/**
	 * 住院结算收付款发送事件
	 * 
	 * @throws BizException
	 * */
	private void invokePayEvent(PatiVisitDO patiVisitDO, BlStIpDO blStIpDO, BlpaypatipAggDO blPayPatIpAggDO, BlincipAggDO blincipAggDO) throws BizException {
		// 发送事件
		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();
		blEventInfoDTO.setPatiVisitDO(patiVisitDO);
		blEventInfoDTO.setBlpaypatipAggDO(blPayPatIpAggDO);
		blEventInfoDTO.setBlStIpDO(blStIpDO);
		blEventInfoDTO.setBlincipAggDO(blincipAggDO);

		IpRcvPayPatEvent ipRcvPayPatEvent = new IpRcvPayPatEvent();
		ipRcvPayPatEvent.invokePay(blEventInfoDTO);
	}
}
