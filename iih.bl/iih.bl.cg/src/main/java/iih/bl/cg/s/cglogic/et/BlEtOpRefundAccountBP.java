package iih.bl.cg.s.cglogic.et;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.s.cglogic.event.BlOepCgEvent;
import iih.bl.cg.s.cglogic.other.BlCgAccDataWarehouse;
import iih.bl.cg.s.cglogic.other.BlCgAccErrorCollector;
import iih.bl.cg.s.cglogic.util.BlCgAccSetInitUtil;
import iih.bl.cg.s.cglogic.util.BlCgDataUtil;
import iih.bl.cg.s.cglogic.validator.BlCgAccParamValidator;
import iih.bl.cg.s.cglogic.validator.BlCgRefundDataValidator;
import iih.bl.comm.util.BlMethodUtil;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.lock.PKLock;

/**
 * 急诊退记账(门诊表)
 * @author ly 2019/03/14
 *
 */
public class BlEtOpRefundAccountBP {

	// 记账配置
	private BlCgRefundAccountSetDTO accSet;
	
	// 记账数据仓库 
	private BlCgAccDataWarehouse dataWh;

	// 错误信息收集器
	private BlCgAccErrorCollector errClctor;
	
	// 患者id
	private List<String> patList = new ArrayList<String>();
	
	// 流程是否到了保存-->不抛异常模式下，如果保存发生异常，照样抛异常
	private boolean saveOper = false; 
	
	// 退记账DTO key -->用于减少判断
	private String accDtoKeyColumn = "";
	// 记账表key -->用于减少判断
	private String cgKeyColumn = "";
	// 剩余数量
	private static final String QUAN_REMAIN = "Quan_remain";
	
	// 需要更新医嘱服务id
	private List<String> updateOrsrvList = new ArrayList<String>();
		
	/**
	 * 记账
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	public BlCgAccountRltDTO exec(BlCgRefundAccountDTO[] refundDtos, BlCgRefundAccountSetDTO accSetDto) throws BizException{
		
		if(ArrayUtil.isEmpty(refundDtos)){
			throw new BizException("退记账数据为空");
		}
		
		// 初始化配置
		this.accSet = BlCgAccSetInitUtil.initRfd(accSetDto);
		if(StringUtil.isEmpty(this.accSet.getEu_rfdmode())){
			throw new BizException("退记账模式为空");
		}else if(!RefundModeEnum.CG_KEY.equals(this.accSet.getEu_rfdmode()) &&
				!RefundModeEnum.PRSRV_KEY.equals(this.accSet.getEu_rfdmode()) &&
				!RefundModeEnum.ORSRV_KEY.equals(this.accSet.getEu_rfdmode())){
			throw new BizException("退记账模式赋值错误");
		}
		
		// 初始化数据仓库
		this.dataWh = new BlCgAccDataWarehouse();
		// 初始化错误收集器
		this.errClctor = new BlCgAccErrorCollector(accSetDto.getFg_singlepat());
		// 初始化key
		this.initKey();	
		
		// 入参校验
		BlCgAccParamValidator validator = new BlCgAccParamValidator(this.accSet);
		for (int i = 0; i < refundDtos.length; i++) {
			validator.validateRefundOep(refundDtos[i], i);
		}
		
		BlCgAccountRltDTO rlt = new BlCgAccountRltDTO();
		if (FBoolean.TRUE.equals(accSetDto.getFg_exception())) {
			rlt = this.refundAccount(refundDtos);
		} else {
			rlt = this.refundAccountNoException(refundDtos);
		}

		return rlt;
	}
	
	/**
	 * 初始化数据key
	 */
	private void initKey(){
		if (RefundModeEnum.CG_KEY.equals(this.accSet.getEu_rfdmode())) {
			accDtoKeyColumn = "Id_cg";
			cgKeyColumn = BlCgItmOepDO.ID_CGITMOEP;
		} else if(RefundModeEnum.ORSRV_KEY.equals(this.accSet.getEu_rfdmode())){
			accDtoKeyColumn = "Id_orsrv";
			cgKeyColumn = BlCgItmOepDO.ID_ORSRV;
		} else {
			accDtoKeyColumn = "Id_or_prsrv";
			cgKeyColumn = BlCgItmOepDO.ID_OR_PR_SRV;
		}
	}

	/**
	 * 退记账
	 * @param refundDtos
	 * @return
	 */
	private BlCgAccountRltDTO refundAccount(BlCgRefundAccountDTO[] refundDtos) throws BizException {
		
		//查询原记账数据
		BlcgoepAggDO[] cgAggDos = this.prepareRefundCgData(refundDtos);
		
		//原记账子表数据
		BlCgItmOepDO[] cgDos = this.getItmCgData(cgAggDos);
		
		// 分组退记账数据
		Map<String,List<BlCgRefundAccountDTO>> patAccDtoMap = this.mapAccData(refundDtos);
		
		// 退记账数据校验
		boolean next = this.checkCgData(patAccDtoMap, cgDos);
		if (!next) {
			return this.errClctor.returnUnsuccessRlt();
		}
		refundDtos = this.errClctor.filterRefundBizData2(refundDtos);
		
		// 准备患者关联的数据
		this.preparePatRelatedData();
		
		//---> 以下开始做保存操作
		this.saveOper = true;
		
		// 组装,保存退记账数据
		BlcgoepAggDO[] newAggDos = this.assembleAndSaveData(refundDtos, cgAggDos);
		
		// 回写账户
		this.writebackAccount();
		
		if(FBoolean.TRUE.equals(this.accSet.getFg_updateor())){
			// 回写医嘱状态
			this.writebackOrBlState();
		}
	
		// 发送事件
		BlCgItmOepDO[] itmDos = getItmDos(newAggDos);
		this.invokeEtRefundEvent(itmDos);

		// 设置返回值
		BlCgAccountRltDTO rltDto = this.setRtnValue(newAggDos);

		return rltDto;
	}
	
	/**
	 * 将BlcgoepAggDO数组中的记账明细拿出来
	 * @param dos
	 * @param charge
	 * @throws BizException
	 */
	protected BlCgItmOepDO[] getItmDos(BlcgoepAggDO[] newAggDos) {
		List<BlCgItmOepDO> refundList = new ArrayList<BlCgItmOepDO>();
		for (int i = 0; i < newAggDos.length; i++) {
			BlcgoepAggDO AggDo = newAggDos[i];
			if (AggDo == null)
				continue;
			BlCgItmOepDO[] tempItmDos = AggDo.getBlCgItmOepDO();
			if (tempItmDos == null || tempItmDos.length == 0)
				continue;

			refundList.addAll(Arrays.asList(tempItmDos));
		}
		if (refundList.size() == 0)
			return new BlCgItmOepDO[0];
		return refundList.toArray(new BlCgItmOepDO[refundList.size()]);
	}
	
	/**
	 * 发送留观退费事件
	 * @param dos
	 * @param charge
	 * @throws BizException
	 */
	protected void invokeEtRefundEvent(BlCgItmOepDO[] dos) throws BizException {
		
		String eventType = IBlEventConst.EVENT_TYPE_ETCG_REFUND;
		BusinessEvent event = new BusinessEvent(
				IBlEventConst.EVENT_SOURCE_ET_REFUND, eventType, dos);		
		EventDispatcher.fireEvent(event);
	}
	
	/**
	 * 退记账(不抛异常)
	 * @param refundDtos
	 * @return
	 */
	private BlCgAccountRltDTO refundAccountNoException(BlCgRefundAccountDTO[] refundDtos) throws BizException {
		
		BlCgAccountRltDTO rlt = null;
		
		try {
			rlt = this.refundAccount(refundDtos);
		} catch (BizException e) {
			
			if(this.saveOper){
				//保存流程中发生异常，直接抛出
				throw e;
			}
			
			rlt = new BlCgAccountRltDTO();
			rlt.setFg_success(FBoolean.FALSE);
			rlt.setErr_msg(e.getMessage());
			rlt.setExcptionstack(BlMethodUtil.getStackInfo(e));
		}
		
		return rlt;
	}
	
	/**
	 * 查询原记账数据
	 * @param refundDtos
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlcgoepAggDO[] prepareRefundCgData(BlCgRefundAccountDTO[] refundDtos) throws BizException {
		
		List<String> keyList = new ArrayList<String>();

		for (BlCgRefundAccountDTO rfdDto : refundDtos) {
			if(!this.patList.contains(rfdDto.getId_pat())){
				this.patList.add(rfdDto.getId_pat());
			}
			keyList.add((String)rfdDto.getAttrVal(this.accDtoKeyColumn));
		}
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select distinct cgoep.id_cgoep ");
		sqlSb.append("from bl_cg_oep cgoep ");
		sqlSb.append("inner join bl_cg_itm_oep cgitm ");
		sqlSb.append("on cgoep.id_cgoep = cgitm.id_cgoep ");
		
		if (RefundModeEnum.CG_KEY.equals(this.accSet.getEu_rfdmode())) {
			sqlSb.append("where " + SqlUtils.getInSqlByIds("cgitm.id_cgitmoep ", keyList) + " ");
		} else if (RefundModeEnum.ORSRV_KEY.equals(this.accSet.getEu_rfdmode())) {
			sqlSb.append("where " + SqlUtils.getInSqlByIds("cgitm.id_orsrv ", keyList) + " ");
		}else{
			sqlSb.append("where " + SqlUtils.getInSqlByIds("cgitm.id_or_pr_srv ", keyList) + " ");
		}
		sqlSb.append("and cgitm.fg_refund = 'N' ");
		sqlSb.append("and cgoep.eu_direct = 1 ");
		
		DAFacade daf = new DAFacade();
		List<Object> cgIdList = (List<Object>)daf.execQuery(sqlSb.toString(), new ColumnListHandler());
		
		if(ListUtil.isEmpty(cgIdList))
			return null;
		
		String[] cgIds = new String[cgIdList.size()];
		for (int i = 0; i < cgIds.length; i++) {
			cgIds[i] = (String)cgIdList.get(i);
		}
		
		IBlcgoepRService opRService = ServiceFinder.find(IBlcgoepRService.class);
		BlcgoepAggDO[] aggDos = opRService.findByIds(cgIds, FBoolean.FALSE);
		
		return aggDos;
	}

	/**
	 * 剥离记账子表数据
	 * @param cgAggDos
	 * @return
	 */
	private BlCgItmOepDO[] getItmCgData(BlcgoepAggDO[] cgAggDos) {

		if (ArrayUtil.isEmpty(cgAggDos))
			return null;

		List<BlCgItmOepDO> cgItmList = new ArrayList<BlCgItmOepDO>();
		for (BlcgoepAggDO cgAggDO : cgAggDos) {

			cgItmList.addAll(Arrays.asList(cgAggDO.getBlCgItmOepDO()));
		}

		return cgItmList.toArray(new BlCgItmOepDO[0]);
	}

	/**
	 * 分组带退数据数据
	 * @param refundDtos
	 * @return
	 */
	private Map<String,List<BlCgRefundAccountDTO>> mapAccData(BlCgRefundAccountDTO[] refundDtos){
		
		Map<String, List<BlCgRefundAccountDTO>> patAccDtoMap = 
				new HashMap<String, List<BlCgRefundAccountDTO>>();

		for (BlCgRefundAccountDTO accDto : refundDtos) {

			List<BlCgRefundAccountDTO> cgList = null;
			if (patAccDtoMap.containsKey(accDto.getId_pat())) {
				cgList = patAccDtoMap.get(accDto.getId_pat());
			} else {
				cgList = new ArrayList<BlCgRefundAccountDTO>();
				patAccDtoMap.put(accDto.getId_pat(), cgList);
			}
			
			cgList.add(accDto);
		}
		
		return patAccDtoMap;
	}

	/**
	 * 原记账数据校验
	 * @return
	 * @throws BizException
	 */
	private boolean checkCgData(Map<String, List<BlCgRefundAccountDTO>> patAccDtoMap,BlCgItmOepDO[] cgDos) throws BizException {

		BlCgRefundDataValidator validator = new BlCgRefundDataValidator();
		for (String patId : patAccDtoMap.keySet()) {
			
			try {
				validator.validate(patAccDtoMap.get(patId), cgDos,
						this.accDtoKeyColumn, this.cgKeyColumn, this.accSet, this.dataWh);
			} catch (BizException e) {
				this.errClctor.collect(patId, true, e);
			}
			
		}
		this.errClctor.filterEnOrPatList(this.patList);
		return this.patList.size() > 0;
	}
	
	/**
	 * 准备患者关联数据
	 */
	private void preparePatRelatedData() throws BizException {
		
		//获取患者账户数据
		this.dataWh.setPatAccList(BlCgDataUtil.getPatAccData(this.patList.toArray(new String[0])));
	}
	
	/**
	 * 组装保存数据
	 * 半退时全部红冲，重收剩余部分
	 * @param refundDtos
	 * @param cgAggDos
	 * @return
	 */
	private BlcgoepAggDO[] assembleAndSaveData(BlCgRefundAccountDTO[] refundDtos, BlcgoepAggDO[] cgAggDos) throws BizException {
		
		List<BlcgoepAggDO> redAggList = new ArrayList<BlcgoepAggDO>();
		List<BlcgoepAggDO> updateAggList = new ArrayList<BlcgoepAggDO>();
		List<BlcgoepAggDO> recgAggList = new ArrayList<BlcgoepAggDO>();
		List<String> hintKeyList = new ArrayList<String>();//命中的主表主键
		List<BlcgoepAggDO> rntAggList = new ArrayList<BlcgoepAggDO>();//返回数据集
		
		//组装红冲数据
		for (BlCgRefundAccountDTO refundDto : refundDtos) {
			
			boolean has = false;
			for (BlcgoepAggDO aggDO : cgAggDos) {
				
				BlCgOepDO headDO = aggDO.getParentDO();
				for (BlCgItmOepDO itmDO : aggDO.getBlCgItmOepDO()) {
					
					if(refundDto.getAttrVal(accDtoKeyColumn).equals(itmDO.getAttrVal(cgKeyColumn))){
						
						//设置隐藏字段 剩余数量
						FDouble quanRemain = itmDO.getQuan().sub(refundDto.getQuan());
						itmDO.setAttrVal(QUAN_REMAIN, quanRemain);
						
						//统计预交金消费金额
						if(FBoolean.TRUE.equals(itmDO.getFg_acc())){
							// 退金额 = 总金额 - 剩余金额
							FDouble accAmt = itmDO.getAmt_acc().sub(itmDO.getPrice_ratio().multiply(quanRemain));
							this.dataWh.countConsume(headDO.getId_pat(), accAmt.multiply(-1), FBoolean.FALSE);// 门诊暂无团体支付
						}
						has = true;
						
						//统计退医嘱服务id
						if(!StringUtil.isEmpty(itmDO.getId_orsrv()) && !this.updateOrsrvList.contains(itmDO.getId_orsrv())){
							this.updateOrsrvList.add(itmDO.getId_orsrv());
						}
						break;
					}
				}
				
				if(has){
					if(!hintKeyList.contains(headDO.getId_cgoep())){
						updateAggList.add(aggDO);
						redAggList.add(BlCgDataUtil.buildRedCgData(aggDO, accSet, dataWh));
						hintKeyList.add(headDO.getId_cgoep());
					}
					break;
				}
			}
		}
		
		//组装重收数据
		for (BlcgoepAggDO aggDO : updateAggList) {
		
			//修改原数据状态
			aggDO.getParentDO().setStatus(DOStatus.UPDATED);
			
			List<BlCgItmOepDO> reCgItmList = new ArrayList<BlCgItmOepDO>();
			for (BlCgItmOepDO itmDO : aggDO.getBlCgItmOepDO()) {
				
				if(itmDO.getAttrVal(QUAN_REMAIN)==null){
					//设置默认剩余量
					itmDO.setAttrVal(QUAN_REMAIN, itmDO.getQuan());
				}
				
				if(!FDouble.ZERO_DBL.equals(itmDO.getAttrVal(QUAN_REMAIN))){
					
					BlCgItmOepDO reItmDO = BlCgDataUtil.buildReCgData(itmDO, 
							(FDouble)itmDO.getAttrVal(QUAN_REMAIN), this.accSet);
					
					reCgItmList.add(reItmDO);
				}
				
				itmDO.setFg_refund(FBoolean.TRUE);
				itmDO.setStatus(DOStatus.UPDATED);
			}
			
			if(reCgItmList.size() > 0){
				BlcgoepAggDO reCgAggDO = new BlcgoepAggDO();
				
				BlCgOepDO headDO = BlCgDataUtil.buildReHeadCgData(aggDO.getParentDO(), this.accSet);
				reCgAggDO.setParentDO(headDO);
				reCgAggDO.setBlCgItmOepDO(reCgItmList.toArray(new BlCgItmOepDO[0]));
				
				recgAggList.add(reCgAggDO);
			}
		}
		
		IBlcgoepCudService cgCudService = ServiceFinder.find(IBlcgoepCudService.class);
		
		//保存原记账数据修改
		cgCudService.update(updateAggList.toArray(new BlcgoepAggDO[0]));
		
		//保存红冲数据
		cgCudService.insert(redAggList.toArray(new BlcgoepAggDO[0]));
		
		//保存重收数据
		if(recgAggList.size() > 0){
			cgCudService.insert(recgAggList.toArray(new BlcgoepAggDO[0]));
		}
		
		// 添加原始记账数据
		rntAggList.addAll(updateAggList);
		// 添加返回红冲数据
		rntAggList.addAll(redAggList);
		// 添加返回重收数据
		rntAggList.addAll(recgAggList);
		// 返回值没啥用 --- 加上了 xb 2019年12月04日,参照zx修改的门诊退账
		return rntAggList.toArray(new BlcgoepAggDO[] {});

	}
	
	/**
	 * 回写账户金额
	 * 
	 * @throws BizException
	 */
	protected void writebackAccount() throws BizException {
		
		Set<PiPatAccDO> accList = new HashSet<PiPatAccDO>();
		Set<String> lockKeyList = new HashSet<String>();
		Set<String> accIdList = new HashSet<String>();
		
		for (String key : this.dataWh.getPersonalConsumeMap().keySet()) {
			PiPatAccDO acc = this.dataWh.getPatAccMap().get(key);
			String lockKey = acc.getId_pat() + acc.getId_patacc();
			lockKeyList.add(lockKey);
			accIdList.add(acc.getId_patacc());
		}
		
		boolean lock = PKLock.getInstance().addBatchDynamicLock(lockKeyList.toArray(new String[0]), 5 * 1000);
		if(!lock){
			throw new BizException("当前PI_PAT_ACC数据正在被他人修改，请刷新重试:" + accIdList.toArray(new String[0])[0]);
		}
		
		for (String key : this.dataWh.getPersonalConsumeMap().keySet()) {

			FDouble amt = this.dataWh.getPersonalConsumeMap().get(key);
			PiPatAccDO acc = this.dataWh.getPatAccMap().get(key);

			acc.setStatus(DOStatus.UPDATED);
			acc.setAcc_lock_emgstay(acc.getAcc_lock_emgstay().add(amt));

			if (!accList.contains(acc)) {
				accList.add(acc);
			}
		}
		
		if(accList.size() > 0){
			IAccountMDOCudService accService = ServiceFinder.find(IAccountMDOCudService.class);
			accService.update(accList.toArray(new PiPatAccDO[0]));
		}
	}
	
	/**
	 * 回写医嘱记账状态
	 * @param ipDos
	 * @throws BizException
	 */
	private void writebackOrBlState() throws BizException{
		
		if(this.updateOrsrvList.size() == 0)
			return;
		
		ICiOrdMaintainService orService = ServiceFinder.find(ICiOrdMaintainService.class);
//		orService.UpdateOrdChargeRelInfo2(this.updateOrsrvList.toArray(new String[0]),
//				ICiDictCodeConst.SD_SU_BL_REFOUND_ID, ICiDictCodeConst.SD_SU_BL_REFOUND, 
//				null, FeeReverseType.BLCGCANCEL);
		orService.UpdateOrdChargeRelInfo2(this.updateOrsrvList.toArray(new String[0]),
				ICiDictCodeConst.SD_SU_BL_NONE_ID, ICiDictCodeConst.SD_SU_BL_NONE, 
				null, FeeReverseType.BLCGCANCEL);
	}
	
	/**
	 * 设置返回值
	 * 
	 * @param dos
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected BlCgAccountRltDTO setRtnValue(BlcgoepAggDO[] newAggDos) throws BizException {

		BlCgAccountRltDTO rltDto = new BlCgAccountRltDTO();
		rltDto.setFg_success(FBoolean.TRUE);

		FArrayList cgList = new FArrayList();
		cgList.addAll(Arrays.asList(newAggDos));
		rltDto.setCglist(cgList);

		FArrayList errList = new FArrayList();
		errList.addAll(this.errClctor.getFailRltList());

		rltDto.setError_entlist(errList);

		return rltDto;
	}
}
