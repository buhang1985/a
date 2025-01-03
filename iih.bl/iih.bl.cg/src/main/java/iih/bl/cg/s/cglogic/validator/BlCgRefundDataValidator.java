package iih.bl.cg.s.cglogic.validator;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.s.cglogic.other.BlCgAccDataWarehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 住院记账退费数据校验器
 * @author ly 2018/08/13
 *
 */
public class BlCgRefundDataValidator {

	private static Map<String,String> modeColumNameMap;
	
	static{
		modeColumNameMap = new HashMap<String,String>();
		modeColumNameMap.put(RefundModeEnum.CG_KEY, "记账主键");
		modeColumNameMap.put(RefundModeEnum.PRSRV_KEY, "执行计划主键");
		modeColumNameMap.put(RefundModeEnum.ORSRV_KEY, "医嘱服务主键");
		modeColumNameMap.put(RefundModeEnum.SUSP_KEY, "挂起记账主键");
	}
	
	/**
	 * 退费数据校验
	 * @param rfdAccList
	 * @param cgDos
	 * @param dtoKey
	 * @param doKey
	 * @param accSet
	 * @param dataWh
	 * @throws BizException
	 */
	public void validate(List<BlCgRefundAccountDTO> rfdAccList,
			BlCgIpDO[] cgDos, String dtoKey, String doKey,
			BlCgRefundAccountSetDTO accSet,BlCgAccDataWarehouse dataWh) throws BizException {
		
		//匹配退记账数据
		if(ArrayUtil.isEmpty(cgDos)){
			throw new BizException("未查询到原记账信息或原记账已退费,"
					+ modeColumNameMap.get(accSet.getEu_rfdmode()) + ":"
					+ rfdAccList.get(0).getAttrVal(dtoKey));
		}
		
		for (BlCgRefundAccountDTO accDto : rfdAccList) {
			boolean has = false;
			for (BlCgIpDO cgDO : cgDos) {
				if(accDto.getAttrVal(dtoKey).equals(cgDO.getAttrVal(doKey))){
					
					if(FBoolean.TRUE.equals(cgDO.getFg_st())){
						throw new BizException("记账数据已经结算无法退费,记账数据编码:" + cgDO.getCode_cg()); 
					}
					
					FDouble canRfdQuan = cgDO.getQuan().sub(cgDO.getQuan_ret());
					if (accDto.getQuan().compareTo(canRfdQuan) > 0) {
						throw new BizException("退费数量大于可退数量,服务:" + cgDO.getName_srv()); 
					}
					has = true;
					break;
				}
			}
			
			if(!has){
				throw new BizException("未查询到原记账信息,"
						+ modeColumNameMap.get(accSet.getEu_rfdmode()) + ":"
						+ accDto.getAttrVal(dtoKey));
			}
		}
	}

	/**
	 * 退费数据校验
	 * @param rfdAccList
	 * @param cgDos
	 * @param dtoKey
	 * @param doKey
	 * @param accSet
	 * @param dataWh
	 * @throws BizException
	 */
	public void validate(List<BlCgRefundAccountDTO> rfdAccList,
			BlCgItmOepDO[] cgDos, String dtoKey, String doKey,
			BlCgRefundAccountSetDTO accSet,BlCgAccDataWarehouse dataWh) throws BizException {
		
		//匹配退记账数据
		if(ArrayUtil.isEmpty(cgDos)){
			throw new BizException("未查询到原记账信息或原记账已退费,"
					+ modeColumNameMap.get(accSet.getEu_rfdmode()) + ":"
					+ rfdAccList.get(0).getAttrVal(dtoKey));
		}
		
		for (BlCgRefundAccountDTO accDto : rfdAccList) {
			boolean has = false;
			for (BlCgItmOepDO cgDO : cgDos) {
				if(accDto.getAttrVal(dtoKey).equals(cgDO.getAttrVal(doKey))){
					
					if(!StringUtil.isEmpty(cgDO.getId_or_pr()) && !StringUtil.isEmpty(accDto.getId_or_pr()) && 
							!cgDO.getId_or_pr().equals(accDto.getId_or_pr()))
						continue;
					
					if(FBoolean.TRUE.equals(cgDO.getFg_refund())){
						throw new BizException("该记账已退,无法重复退记账,服务:" + cgDO.getName_srv()); 
					}
					//挂起记账数据 可能结算 去掉校验
					if(!RefundModeEnum.SUSP_KEY.equals(accSet.getEu_rfdmode())){
						if(FBoolean.TRUE.equals(cgDO.getFg_st())){
							throw new BizException("该记账已结算,无法退记账,服务:" + cgDO.getName_srv()); 
						}
					}
					if (accDto.getQuan().compareTo(cgDO.getQuan()) > 0) {
						throw new BizException("退费数量大于可退数量,服务:" + cgDO.getName_srv()); 
					}
					has = true;
					break;
				}
			}
			
			if(!has){
				throw new BizException("未查询到原记账信息,"
						+ modeColumNameMap.get(accSet.getEu_rfdmode()) + ":"
						+ rfdAccList.get(0).getAttrVal(dtoKey));
			}
		}
	}
}
