package iih.bl.cg.s.cglogic.validator;

import iih.bl.cg.dto.cglogic.d.BlCgAccountBizDTO;
import iih.bl.cg.s.cglogic.other.BlCgAccDataWarehouse;

import java.util.List;

import xap.mw.core.data.BizException;

/**
 * 记账关联非空数据校验器
 * @author ly 2018/07/25
 *
 */
public class BlCgNotNullDataValidator {

	/**
	 * 记账关联非空
	 * @param accBizList
	 * @param dataWh
	 * @throws BizException
	 */
	public void validate(List<BlCgAccountBizDTO> accBizList,BlCgAccDataWarehouse dataWh) throws BizException{
		
		//账单项空校验
		for (BlCgAccountBizDTO bizDto : accBizList) {
			if(!dataWh.getCaItmRelMap().containsKey(bizDto.getId_srv())){
				throw new BizException("未获取到服务对应账单项目,服务:" + bizDto.getName_srv());
			}
		}
		
		//二级核算项目空校验,标准版 TODO
		
	}
}
