package iih.bl.pay.s.bp.prepay;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blreservepat.d.BlReservePatDO;
import iih.bl.pay.blreservepat.i.IBlreservepatCudService;
import iih.bl.pay.blreservepat.i.IBlreservepatRService;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayTDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayTSubDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.bl.pay.s.bp.util.PrepayAssembleUtil;
import iih.bl.pay.s.bp.util.PrepayReceiptAssembleUtil;
import iih.bl.pay.s.ep.PrepayPatRcptEP;
import iih.en.pv.i.IEnOutCmdService;
import iih.pi.acc.account.i.IPatAccServiceExt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 预交金转移
 * @author 2018/07/19
 *
 */
public class BlPrepayTransferBP extends BlPrepayBaseBP{

	private List<BlPrePayPatDO> prepayList;//转入生成新预交金数据
	private List<BlPrepayPatRcptDO> rcptList;//所有待保存票据数据
	private FBoolean fgPrintTransfer;
	
	
	public BlPrepayTransferBP(BlPrepaySetDTO setDto) {
		super(setDto);

		this.prepayList = new ArrayList<BlPrePayPatDO>();
		this.rcptList = new ArrayList<BlPrepayPatRcptDO>();
		this.fgPrintTransfer = BlParams.BLPREPAY0011();
	}

	/**
	 * 预交金转移
	 * @param dto 结转数据
	 * @return 预交金DO 
	 * @throws BizException
	 */
	public BlPrePayPatDO[] exec(BlPrepayTDTO dto) throws BizException {
		
		this.validate(dto);
		
		this.analysisAccType(dto.getId_pat(), dto.getId_ent(), dto.getId_pecmpy());
		
		if(FBoolean.TRUE.equals(this.setDto.getFg_useinc())){
			super.judgeIncManage();//TODO
		}
		
		List<String> prepayIdList = new ArrayList<String>();
		List<String> prePrepayIdList = new ArrayList<String>();
		Map<String,FDouble> prepayIdAmtMap = new HashMap<String,FDouble>();//转移预交金id与转移金额关系,用于门诊转住院
		this.prepareId(prepayIdList, prePrepayIdList, prepayIdAmtMap, dto);
		
		//预交金转移
		if(prepayIdList.size() > 0){
			this.prepayTransfer(prepayIdList, prepayIdAmtMap, dto);
		}
		
		//准备金转移
		if(prePrepayIdList.size() > 0){
			this.prePrepayTransfer(prePrepayIdList, dto);
		}
		
		//生成票据数据
		if(FBoolean.TRUE.equals(this.fgPrintTransfer)){
			List<BlPrepayPatRcptDO> newRcptList = this.createNewRcptData(this.prepayList);
			this.rcptList.addAll(newRcptList);
		}
		
		//保存充值数据
		BlPrePayPatDO[] newPrepayDos = this.cudService.insert(this.prepayList.toArray(new BlPrePayPatDO[0]));
		
		//保存票据数据
		IPrepaypatrcptCudService rcptCudService = ServiceFinder.find(IPrepaypatrcptCudService.class);
		rcptCudService.save(this.rcptList.toArray(new BlPrepayPatRcptDO[0]));
		
		//更新账户
		if(FBoolean.TRUE.equals(this.setDto.getFg_accupdate())){
			
			FDouble amt = FDouble.ZERO_DBL;
			for (BlPrePayPatDO prepayDO : newPrepayDos) {
				amt = amt.add(prepayDO.getAmt().multiply(prepayDO.getEu_direct()));
			}
			this.chargeAcc(amt);
		}
		
		return newPrepayDos;
	}
	
	/**
	 * 参数校验
	 * @param dto
	 * @throws BizException
	 */
	private void validate(BlPrepayTDTO dto) throws BizException{
		
		if(dto == null){
			throw new ArgumentNullException("预交金转移", "充值数据");
		}
		
		if(StringUtil.isEmpty(dto.getId_pat()) 
				&& StringUtil.isEmpty(dto.getId_ent()) 
				&& StringUtil.isEmpty(dto.getId_pecmpy())){
			throw new BizException("预交金转移:确定类型的字段至少一个需要有值:患者id,就诊id,团检id");
		}
		
		if(StringUtil.isEmpty(dto.getId_pat()) && 
				StringUtil.isEmpty(dto.getId_ent())){
			throw new BizException("预交金转移:暂不支持团检预交金转移");
		}
		
		if((dto.getPrepaytranids() == null || dto.getPrepaytranids().size() == 0 ) &&
				(dto.getPreprepaytranids() == null || dto.getPreprepaytranids().size() == 0 )){
			throw new BizException("预交金转移:待转移数据为空");
		}
		
		if(StringUtil.isEmpty(dto.getId_ent()) && dto.getPreprepaytranids() != null 
				&& dto.getPreprepaytranids().size() > 0){
			throw new BizException("预交金转移:预住院预交金转移时，就诊id不能为空");
		}
	}

	/**
	 * 准备id
	 * @param prepayIdList
	 * @param prePrepayIdList
	 * @param dto
	 */
	@SuppressWarnings("unchecked")
	private void prepareId(List<String> prepayIdList,List<String> prePrepayIdList, Map<String,FDouble> prepayIdAmtMap, BlPrepayTDTO dto) {
		
		if(dto.getPrepaytranids() != null && dto.getPrepaytranids().size() > 0){
			for (int i = 0; i < dto.getPrepaytranids().size(); i++) {
				
				BlPrepayTSubDTO subDto = (BlPrepayTSubDTO)dto.getPrepaytranids().get(i);
				prepayIdList.add(subDto.getId_prepay());
				prepayIdAmtMap.put(subDto.getId_prepay(), subDto.getAmt());
			}
		}
		
		if(dto.getPreprepaytranids() != null && dto.getPreprepaytranids().size() > 0){
			prePrepayIdList.addAll(dto.getPreprepaytranids());
		}
	}

	/**
	 * 预交金转移
	 * @param prepayIdList
	 * @param prepayIdAmtMap
	 * @param dto
	 * @throws BizException
	 */
	private void prepayTransfer(List<String> prepayIdList, Map<String, FDouble> prepayIdAmtMap, BlPrepayTDTO dto) throws BizException {

		// 检索待转移预交金
		BlPrePayPatDO[] oldPrepayDos = this.rService.findByIds(prepayIdList.toArray(new String[0]), FBoolean.FALSE);
		Map<String, BlPrepayPatRcptDO> rcptMap = new PrepayPatRcptEP()
				.findLastRcptByPrepayIdsToMap(prepayIdList.toArray(new String[0]));

		List<BlPrePayPatDO> oldPrepayList = new ArrayList<BlPrePayPatDO>();

		// 可转移校验
		this.validateTransfer(oldPrepayDos, dto, prepayIdAmtMap);

		String[] newKeys = new DBUtil().getOIDs(oldPrepayDos.length);
		for (int i = 0; i < oldPrepayDos.length; i++) {
			BlPrePayPatDO oldPrepayDO = oldPrepayDos[i];
			BlPrepayPatRcptDO oldRcptDO = rcptMap.get(oldPrepayDO.getId_paypat());

			// 红冲原预交金数据
			BlPrePayPatDO redPrepayDO = PrepayAssembleUtil.reserveWhenVoid(oldPrepayDO, 
					accType, prepayIdAmtMap.get(oldPrepayDO.getId_paypat()), null,dto.getSd_pttp(),null,null,null);

			// 红冲票据
			BlPrepayPatRcptDO redRcptDO = PrepayReceiptAssembleUtil.reserveRcpt(oldRcptDO,null);

			// 修改原数据
			super.modifyPrepayWhenRedReserve(oldPrepayDO, null);

			// 修改票据数据
			super.modifyRcptWhenRedReserve(oldRcptDO);

			// 生成新充值数据
			BlPrePayPatDO newPrepayDO = PrepayAssembleUtil.assembleWhenTransfer(
					dto, oldPrepayDO, accType,prepayIdAmtMap.get(oldPrepayDO.getId_paypat()),null);
			newPrepayDO.setId_paypat(newKeys[i]);

			if(FBoolean.FALSE.equals(this.fgPrintTransfer)){
				
				BlPrepayPatRcptDO newRcpt = null;
				//同类型票据复制原票据
				if(super.isSameType(oldPrepayDO.getCode_enttp())){
					newRcpt = (BlPrepayPatRcptDO)oldRcptDO.clone();
					newRcpt.setFg_rep_return(FBoolean.FALSE);
					newRcpt.setId_paypat_rcpt(null);
					newRcpt.setId_paypat(newPrepayDO.getId_paypat());
					newRcpt.setStatus(DOStatus.NEW);
				}else{
					//不同类型票据建空票
					newRcpt = this.createNewBlankRcptData(newPrepayDO);
				}
				rcptList.add(newRcpt);
			}
			
			prepayList.add(newPrepayDO);
			oldPrepayList.add(oldPrepayDO);
			oldPrepayList.add(redPrepayDO);
			if(oldRcptDO!=null){
				rcptList.add(oldRcptDO);
			}
			if(redRcptDO!=null){
				rcptList.add(redRcptDO);
			}
			
		}

		// 保存转出数据
		this.cudService.save(oldPrepayList.toArray(new BlPrePayPatDO[0]));

		// 更新转出账户
		Map<String,FDouble> patAccMap = new HashMap<String,FDouble>();
		Map<String,FDouble> enAccMap = new HashMap<String,FDouble>();
		
		for (BlPrePayPatDO oldPrepayDO : oldPrepayList) {
			if(oldPrepayDO.getEu_direct() != BookRtnDirectEnum.RETURNS)
				continue;
			
			FDouble amt = oldPrepayDO.getAmt().multiply(oldPrepayDO.getEu_direct());
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(oldPrepayDO.getCode_enttp())) {
				FDouble oldAmt = patAccMap.get(oldPrepayDO.getId_pat());
				patAccMap.put(oldPrepayDO.getId_pat(), amt.add(
						oldAmt == null ? FDouble.ZERO_DBL : oldAmt));
				
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(oldPrepayDO.getCode_enttp())) {
				FDouble oldAmt = enAccMap.get(oldPrepayDO.getId_ent());
				enAccMap.put(oldPrepayDO.getId_ent(), amt.add(
						oldAmt == null ? FDouble.ZERO_DBL : oldAmt));
			}
		}
		
		IPatAccServiceExt opService = ServiceFinder.find(IPatAccServiceExt.class);
		IEnOutCmdService ipService = ServiceFinder.find(IEnOutCmdService.class);
		
		for (String key : patAccMap.keySet()) {
			opService.updatePatPrepay(key, patAccMap.get(key));
		}
		
		for (String key : enAccMap.keySet()) {
			ipService.recharge(key, enAccMap.get(key));
		}
	}
	
	/**
	 * 准备金转移
	 * @param prePrepayIdList
	 * @param dto
	 * @throws BizException
	 */
	private void prePrepayTransfer(List<String> prePrepayIdList,BlPrepayTDTO dto) throws BizException{
		//检索待转移准备金
		IBlreservepatRService rpRService = ServiceFinder.find(IBlreservepatRService.class);
		IBlreservepatCudService rpCService = ServiceFinder.find(IBlreservepatCudService.class);
		BlReservePatDO[] rpPrepayDos = rpRService.findByIds(
				prePrepayIdList.toArray(new String[0]), FBoolean.FALSE);
		
		//可转移校验
		this.validateTransfer(rpPrepayDos);
		
		String[] newKeys = new DBUtil().getOIDs(rpPrepayDos.length);
		for (int i = 0; i < rpPrepayDos.length; i++) {
			BlReservePatDO rpPrepayDO = rpPrepayDos[i];
			
			//修改预住院预交金数据
			rpPrepayDO.setFg_prepay(FBoolean.TRUE);
			rpPrepayDO.setId_paypat(newKeys[i]);
			rpPrepayDO.setStatus(DOStatus.UPDATED);
			
			//生成新充值记录
			BlPrePayPatDO prepayDO = PrepayAssembleUtil
					.assembleByPrePrepay(dto, rpPrepayDO, this.accType, null);
			prepayDO.setId_paypat(newKeys[i]);
			prepayList.add(prepayDO);
			
			if(FBoolean.FALSE.equals(this.fgPrintTransfer)){
				BlPrepayPatRcptDO blackRcpt = this.createNewBlankRcptData(prepayDO);
				rcptList.add(blackRcpt);
			}
		}
		
		//更新准备金数据
		rpCService.save(rpPrepayDos);
	}
	
	/**
	 * 可转移校验
	 * @param oldPrepayDos
	 * @throws BizException
	 */
	private void validateTransfer(BlPrePayPatDO[] oldPrepayDos, BlPrepayTDTO dto,Map<String,FDouble> prepayIdAmtMap) throws BizException {
		
		if(ArrayUtil.isEmpty(oldPrepayDos)){
			throw new BizException("预交金转移:未查询到待转移预交金数据");
		}
		
		for (BlPrePayPatDO prepayDO : oldPrepayDos) {
			if(FBoolean.TRUE.equals(prepayDO.getFg_canc())){
				throw new BizException("预交金转移:预交金已经作废无法转移,票据号:" + prepayDO.getCode_rep());
			}
		}
		
		//金额校验 TODO
	}
	
	/**
	 * 可转移校验
	 * @param rpPrepayDos
	 * @throws BizException
	 */
	private void validateTransfer(BlReservePatDO[] rpPrepayDos) throws BizException {
		
		if(ArrayUtil.isEmpty(rpPrepayDos)){
			throw new BizException("预交金转移:未查询到待转移预住院预交金数据");
		}
		
		for (BlReservePatDO rpPrepayDO : rpPrepayDos) {
			if(FBoolean.TRUE.equals(rpPrepayDO.getFg_prepay())){
				throw new BizException("预交金转移:预住院预交金已经转移,票据号:" + rpPrepayDO.getCode_rep());
			}
			
			if(FBoolean.TRUE.equals(rpPrepayDO.getFg_canc())){
				throw new BizException("预交金转移:预住院预交金已经作废,票据号:" + rpPrepayDO.getCode_rep());
			}
		}
	}

	/**
	 * 生成新票据数据,修改预交金数据
	 * @param prepayList
	 * @return
	 * @throws BizException
	 */
	private List<BlPrepayPatRcptDO> createNewRcptData(List<BlPrePayPatDO> prepayList) throws BizException {
		
		List<BlPrepayPatRcptDO> rcptList = new ArrayList<BlPrepayPatRcptDO>();
		//获取票据包信息
		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		BlIncIssDO incIssDO = incService.getCurInvoiceDO(Context.get().getStuffId(), Context.get().getClientHost(), prepayList.get(0).getId_incca());
		String[] incNos = new String[1];
		if(prepayList.size() > 1){
			incNos = incService.getCurInvoiceNoMany(Context.get().getStuffId(), Context.get().getClientHost(), prepayList.get(0).getId_incca(), prepayList.size());
		}else{
			incNos[0] = incIssDO.getIncno_cur();
		}
		
		for (int i = 0; i < prepayList.size(); i++) {
			BlPrepayPatRcptDO rcptDO = PrepayReceiptAssembleUtil.assemble(prepayList.get(i), 
					incIssDO.getCode_incpkg(), incNos[i], 1, null);
			rcptList.add(rcptDO);
			//回写预交金票据号
			prepayList.get(i).setCode_rep(incNos[i]);
		}
		
		//票据包过号
		incService.nextInvoiceNoByNo(incIssDO, incNos[incNos.length - 1]);
		return rcptList;
	}
	
	/**
	 * 创建无票号票据数据
	 * @param prepayDO
	 * @return
	 * @throws BizException
	 */
	private BlPrepayPatRcptDO createNewBlankRcptData(BlPrePayPatDO prepayDO) throws BizException{
		BlPrepayPatRcptDO rcptDO = PrepayReceiptAssembleUtil.assemble(prepayDO, 
				null, null, 0, null);
		return rcptDO;
	}
}
