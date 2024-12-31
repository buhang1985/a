package iih.bl.cg.s.cglogic.ip;

import iih.bd.base.utils.FDoubleUtils;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.s.cglogic.other.BlCgAccDataWarehouse;
import iih.bl.cg.s.cglogic.other.BlCgAccErrorCollector;
import iih.bl.cg.s.cglogic.util.BlCgAccSetInitUtil;
import iih.bl.cg.s.cglogic.util.BlCgDataUtil;
import iih.bl.cg.s.cglogic.validator.BlCgAccParamValidator;
import iih.bl.cg.s.cglogic.validator.BlCgRefundDataValidator;
import iih.bl.comm.IBlConst;
import iih.bl.comm.util.BlMethodUtil;
import iih.bl.params.BlParamValueConst;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.i.ICiOrdMaintainService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院退记账逻辑类
 * @author ly 2018/08/07
 *
 */
public class BlIpRefundAccountBP extends BlIpKeepAccountBaseBP{

	// 记账配置
	private BlCgRefundAccountSetDTO accSet;
	
	// 退记账DTO key -->用于减少判断
	private String accDtoKeyColumn = "";
	// 记账表key -->用于减少判断
	private String cgKeyColumn = "";
	
	/**
	 * 住院退记账
	 * @param refundDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	public BlCgAccountRltDTO exec(BlCgRefundAccountDTO[] refundDtos, BlCgRefundAccountSetDTO accSetDto) throws BizException {
		
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
		this.dataWh.loadIpParam();
		// 初始化错误收集器
		this.errClctor = new BlCgAccErrorCollector(this.accSet.getFg_singlepat());
		// 初始化key
		this.initKey();
		
		// 入参校验
		BlCgAccParamValidator validator = new BlCgAccParamValidator(this.accSet);
		for (int i = 0; i < refundDtos.length; i++) {
			validator.validateRefund(refundDtos[i], i);
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
	 * 退记账
	 * @param refundDtos
	 * @return
	 */
	private BlCgAccountRltDTO refundAccount(BlCgRefundAccountDTO[] refundDtos) throws BizException {
		
		// 查询待退记账数据
		BlCgIpDO[] cgDos = this.prepareRefundCgData(refundDtos);
		
		// 已经退数查询 -->添加了退费数量，可以直接判断
		//this.qryRefundedQuan(cgDos);
		
		// 分组退记账数据
		Map<String,List<BlCgRefundAccountDTO>> entAccDtoMap = this.mapAccData(refundDtos);
		
		// 退记账数据校验
		boolean next = this.checkCgData(entAccDtoMap, cgDos);
		if (!next) {
			return this.errClctor.returnUnsuccessRlt();
		}
		refundDtos = this.errClctor.filterRefundBizData(refundDtos);
		
		// 准备就诊关联的数据
		this.prepareEnRelatedData();
		
		// 处理母婴
		//this.dataWh.handleMomBabyAcc();
		
		// 可退校验
		next = super.checkAccAble();
		if (!next) {
			return this.errClctor.returnUnsuccessRlt();
		}
		refundDtos = this.errClctor.filterRefundBizData(refundDtos);
		
		//---> 以下开始做保存操作
		super.saveOper = true;
		
		// 组装,保存退记账数据
		BlCgIpDO[] ipDos = this.assembleAndSaveData(refundDtos, cgDos);
		
		// 回写账户
		super.writebackAccount();
		
		if(FBoolean.TRUE.equals(this.accSet.getFg_updateor())){
			// 回写医嘱状态
			this.writebackOrBlState(ipDos);
		}
		
		// 发送事件
		super.invokeEvent(ipDos, false);
		
		// 设置返回值
		BlCgAccountRltDTO rltDto = this.setRtnValue(ipDos);

		return rltDto;
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
			
			if(super.saveOper){
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
	 * 初始化数据key
	 */
	private void initKey(){
		if (RefundModeEnum.CG_KEY.equals(this.accSet.getEu_rfdmode())) {
			accDtoKeyColumn = "Id_cg";
			cgKeyColumn = BlCgIpDO.ID_CGIP;
		} else if (RefundModeEnum.PRSRV_KEY.equals(this.accSet.getEu_rfdmode())) {
			accDtoKeyColumn = "Id_or_prsrv";
			cgKeyColumn = BlCgIpDO.ID_OR_PR_SRV;
		}else{
			accDtoKeyColumn = "Id_orsrv";
			cgKeyColumn = BlCgIpDO.ID_ORSRV;
		}
	}
	
	/**
	 * 准备原记账数据
	 * @param refundDtos
	 * @throws BizException
	 */
	private BlCgIpDO[] prepareRefundCgData(BlCgRefundAccountDTO[] refundDtos) throws BizException {
		
		List<String> keyList = new ArrayList<String>();

		for (BlCgRefundAccountDTO rfdDto : refundDtos) {
			
			if(!this.enList.contains(rfdDto.getId_ent())){
				this.enList.add(rfdDto.getId_ent());
			}
			keyList.add((String)rfdDto.getAttrVal(this.accDtoKeyColumn));
		}
		
		IBlcgqueryRService rService = ServiceFinder.find(IBlcgqueryRService.class);
		BlCgIpDO[] cgIpDos = rService.findByAttrValStrings(this.cgKeyColumn, keyList.toArray(new String[0]));
		
		if(ArrayUtil.isEmpty(cgIpDos))
			return null;
		
		List<BlCgIpDO> filter = new ArrayList<BlCgIpDO>();
		for (BlCgIpDO cgDO : cgIpDos) {
			
			if(BookRtnDirectEnum.REFUND.equals(cgDO.getEu_direct()))
				continue;
			
			if(FBoolean.TRUE.equals(cgDO.getFg_refund()))
				continue;
			
			filter.add(cgDO);
		}
		
		return filter.toArray(new BlCgIpDO[0]);
	}
	
	/**
	 * 分组带退数据数据
	 * @param refundDtos
	 * @return
	 */
	private Map<String,List<BlCgRefundAccountDTO>> mapAccData(BlCgRefundAccountDTO[] refundDtos){
		
		Map<String, List<BlCgRefundAccountDTO>> entAccDtoMap = 
				new HashMap<String, List<BlCgRefundAccountDTO>>();

		for (BlCgRefundAccountDTO accDto : refundDtos) {

			List<BlCgRefundAccountDTO> cgList = null;
			if (entAccDtoMap.containsKey(accDto.getId_ent())) {
				cgList = entAccDtoMap.get(accDto.getId_ent());
			} else {
				cgList = new ArrayList<BlCgRefundAccountDTO>();
				entAccDtoMap.put(accDto.getId_ent(), cgList);
			}
			
			cgList.add(accDto);
		}
		
		return entAccDtoMap;
	}
	
	/**
	 * 准备就诊关联的数据
	 * @throws BizException
	 */
	private void prepareEnRelatedData() throws BizException {
		
		//查询就诊关联数据
		super.queryEnRelatedData();
	}
	
	/**
	 * 原记账数据校验
	 * @return
	 * @throws BizException
	 */
	private boolean checkCgData(Map<String, List<BlCgRefundAccountDTO>> entAccDtoMap,BlCgIpDO[] cgDos) throws BizException {

		BlCgRefundDataValidator validator = new BlCgRefundDataValidator();
		for (String entId : entAccDtoMap.keySet()) {
			
			try {
				validator.validate(entAccDtoMap.get(entId), cgDos,
						this.accDtoKeyColumn, this.cgKeyColumn, this.accSet, this.dataWh);
			} catch (BizException e) {
				this.errClctor.collect(entId, false, e);
			}
			
		}
		this.errClctor.filterEnOrPatList(this.enList);
		return this.enList.size() > 0;
	}

	/**
	 * 组装保存记账数据
	 * @param refundDtos
	 * @param cgDos
	 * @return
	 */
	private BlCgIpDO[] assembleAndSaveData(BlCgRefundAccountDTO[] refundDtos, BlCgIpDO[] cgDos) throws BizException {
		
		BlCgIpDO[] dos = new BlCgIpDO[refundDtos.length];
		
		List<BlCgIpDO> updateList = new ArrayList<BlCgIpDO>();
		List<BlCgIpDO> insertList = new ArrayList<BlCgIpDO>();
		for (int i = 0; i < dos.length; i++) {
			
			BlCgIpDO oldCgDO = this.hintOldData((String)refundDtos[i].getAttrVal(this.accDtoKeyColumn), cgDos);
			dos[i] = BlCgDataUtil.buildRfdCgData(refundDtos[i], oldCgDO, this.accSet, this.dataWh);
			
			//科研不统计消费
			if(!FBoolean.TRUE.equals(dos[i].getFg_research())){
				if(BlParamValueConst.BLCG0029_NEGATIVE.equals(this.dataWh.getRefundMode())){
					//统计消费金额
					this.dataWh.countConsume(dos[i].getId_ent(), 
							dos[i].getAmt_ratio().multiply(dos[i].getEu_direct()), dos[i].getFg_pay_unit());
				}else{
					FDouble amt = refundDtos[i].getQuan().multiply(dos[i].getPrice_ratio(),
									IBlConst.PRECISION_AMOUNT).multiply(dos[i].getEu_direct());
					this.dataWh.countConsume(dos[i].getId_ent(), amt, dos[i].getFg_pay_unit());
				}
			}
			
			if(BlParamValueConst.BLCG0029_NEGATIVE.equals(this.dataWh.getRefundMode())){
				//记录负账模式
				oldCgDO.setQuan_ret(oldCgDO.getQuan_ret().add(refundDtos[i].getQuan()));
				if(FDoubleUtils.isEqualWithTwoFDouble(oldCgDO.getQuan(),oldCgDO.getQuan_ret())){
					oldCgDO.setFg_refund(FBoolean.TRUE);
				}
				oldCgDO.setStatus(DOStatus.UPDATED);
				updateList.add(oldCgDO);
			}else{
				//红冲模式
				FDouble quanDiv =oldCgDO.getQuan().sub(refundDtos[i].getQuan());
				if(!FDoubleUtils.isEqualWithTwoFDouble(quanDiv,FDouble.ZERO_DBL)){
					BlCgIpDO reIpDO = BlCgDataUtil.buildReCgData(oldCgDO, quanDiv, this.accSet);
					insertList.add(reIpDO);
				}
				
				oldCgDO.setQuan_ret(oldCgDO.getQuan());
				oldCgDO.setFg_refund(FBoolean.TRUE);
				oldCgDO.setStatus(DOStatus.UPDATED);
				updateList.add(oldCgDO);
			}
		}
		
		IBlcgqueryCudService cudService = ServiceFinder.find(IBlcgqueryCudService.class);
		dos = cudService.insert(dos);

		BlCgIpDO[] oldDos = cudService.update(updateList.toArray(new BlCgIpDO[0]));
		if(insertList.size() > 0){
			cudService.insert(insertList.toArray(new BlCgIpDO[0]));
		}
		
		List<BlCgIpDO> rltList = new ArrayList<BlCgIpDO>();
		rltList.addAll(Arrays.asList(dos));
		rltList.addAll(Arrays.asList(oldDos));
		
		return rltList.toArray(new BlCgIpDO[0]);
	}
	
	/**
	 * 命中需要退记账的数据
	 * @param key
	 * @param cgDos
	 * @return
	 */
	private BlCgIpDO hintOldData(String key,BlCgIpDO[] cgDos){
		
		for (BlCgIpDO cgDO : cgDos) {
			if(key.equals(cgDO.getAttrVal(this.cgKeyColumn))){
				return cgDO;
			}
		}
		// 前面会校验
		return null;
	}
	
	/**
	 * 回写医嘱记账状态
	 * @param ipDos
	 * @throws BizException
	 */
	private void writebackOrBlState(BlCgIpDO[] ipDos) throws BizException{
		
		List<String> orsrvList = new ArrayList<String>();
		for (BlCgIpDO cgDO : ipDos) {
			
			if(!StringUtil.isEmpty(cgDO.getId_orsrv()) && !orsrvList.contains(cgDO.getId_orsrv())){
				orsrvList.add(cgDO.getId_orsrv());
			}
		}
		
		if(orsrvList.size() == 0)
			return;
		
		ICiOrdMaintainService orService = ServiceFinder.find(ICiOrdMaintainService.class);
		orService.UpdateOrdChargeRelInfo2(orsrvList.toArray(new String[0]),
				ICiDictCodeConst.SD_SU_BL_NONE_ID, ICiDictCodeConst.SD_SU_BL_NONE, 
				null, FeeReverseType.BLCGCANCEL);
	}
}
