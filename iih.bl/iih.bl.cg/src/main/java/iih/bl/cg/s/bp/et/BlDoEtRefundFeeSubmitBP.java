package iih.bl.cg.s.bp.et;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.comm.util.BlFlowContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
* @ClassName: BlDoEtRefundFeeSubmitBP  
* @Description: 退费确认 
* @author xy.zhou
* @date 2019年3月14日
 */
public class BlDoEtRefundFeeSubmitBP {

public FBoolean exec (NurseCompFeeItmDTO[] dtoArr) throws BizException {
		
		if(ArrayUtil.isEmpty(dtoArr)){
			return FBoolean.FALSE;
		}
		
		List<BlCgRefundAccountDTO> blCgAccountDTOs=new ArrayList<>();
		
		for (NurseCompFeeItmDTO itmDTO : dtoArr) {
			String id_ent = itmDTO.getId_ent();
			if (id_ent==null) {
				throw new BizException("退费时，就诊id不能为空！");
			}
			//组装记账数据
			BlCgRefundAccountDTO blCgAccountDTO = this.AssembleBookkeepingData(itmDTO);
			blCgAccountDTOs.add(blCgAccountDTO);
		}		
		FDateTime dateTime = BlFlowContextUtil.getNowTime();
		//获取记账配置
		BlCgRefundAccountSetDTO blCgAccountSetDTO = this.getBlCgAccountSetDTO(dateTime);	
		
		//调用新的退记账接口
		IBlCgAccountService iBlCgAccountService=ServiceFinder.find(IBlCgAccountService.class);
		BlCgAccountRltDTO rlt = iBlCgAccountService.refundAccountForEt(blCgAccountDTOs.toArray(new BlCgRefundAccountDTO[]{}), blCgAccountSetDTO);
		return FBoolean.TRUE;
	}
	/**
	 * 
	 * @Title: AssembleBookkeepingData   
	 * @Description: 组装记账数据  
	 * @param: @param itmDTO
	 * @param: @param vist
	 * @param: @param picPate
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: BlCgAccountDTO 
	 * @author: xy.zhou     
	 * @throws
	 */
	private BlCgRefundAccountDTO  AssembleBookkeepingData(NurseCompFeeItmDTO itmDTO)throws BizException{
		BlCgRefundAccountDTO blAccountDTO=new BlCgRefundAccountDTO();
		//就诊id
		blAccountDTO.setId_ent(itmDTO.getId_ent());
		//患者id
		blAccountDTO.setId_pat(itmDTO.getId_pat());
		//记账id
		blAccountDTO.setId_cg(itmDTO.getId_cgip());
		//医嘱服务执行计划
		blAccountDTO.setId_or_prsrv(itmDTO.getId_or_pr_srv());
		//医嘱服务
		blAccountDTO.setId_orsrv(itmDTO.getId_orsrv());
		//退数量
		blAccountDTO.setQuan(itmDTO.getQuan_mend());
		return blAccountDTO;
	}
	/**
	 * 
	 * @Title: getBlCgAccountSetDTO   
	 * @Description: 组装记账数据  
	 * @param: @param id_emp
	 * @param: @param id_dep
	 * @param: @param dt_cg
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: BlCgAccountSetDTO 
	 * @author: xy.zhou     
	 * @throws
	 */
	private BlCgRefundAccountSetDTO getBlCgAccountSetDTO(FDateTime fTime)throws BizException{
		BlCgRefundAccountSetDTO bRefundAccountSetDTO=new BlCgRefundAccountSetDTO();
		//记账机构
		bRefundAccountSetDTO.setId_org_cg(Context.get().getOrgId());
		//记账人员
		bRefundAccountSetDTO.setId_emp_cg(Context.get().getStuffId());
		//记账科室
		bRefundAccountSetDTO.setId_dep_cg(Context.get().getDeptId());
		//记账时间
		bRefundAccountSetDTO.setDt_cg(fTime);
		//是否单患者模式
		bRefundAccountSetDTO.setFg_singlepat(FBoolean.FALSE);
		//是否抛异常
		bRefundAccountSetDTO.setFg_exception(FBoolean.TRUE);
		//是否更新医嘱记账状态
		bRefundAccountSetDTO.setFg_updateor(FBoolean.FALSE);
		//退记账模式
		bRefundAccountSetDTO.setEu_rfdmode(RefundModeEnum.CG_KEY);
		//记账来源
		bRefundAccountSetDTO.setSrcfunc_des(IBlCgFuncConst.FUNC_IPBL_NURSE_ADDREFUNDCOST);
		return bRefundAccountSetDTO;
	}
	
}
