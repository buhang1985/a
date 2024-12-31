package iih.bl.cg.s.bp.op;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.comm.IBlCgFuncConst;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * 挂号费退记账
 * @author ly 2018/08/26
 *
 */
public class BlRefundForOpRegisterBP {

	/**
	 * 挂号费退记账
	 * @param entId 就诊id
	 * @throws BizException
	 */
	public void exec(String entId) throws BizException{
		
		if(StringUtil.isEmpty(entId)){
			throw new ArgumentNullException("挂号费退记账", "就诊id");
		}
		
		List<BlCgItmOepDO> cgItmList = this.getRegisterCgInfo(entId);
		if(ListUtil.isEmpty(cgItmList)){
			throw new BizException("未查询到可退记账挂号记账数据");
		}
		
		IBlCgAccountService accService = ServiceFinder.find(IBlCgAccountService.class);
		List<BlCgRefundAccountDTO> cgAccDtoList = new ArrayList<BlCgRefundAccountDTO>();
		//挂起的数据集合
		List<BlCgRefundAccountDTO> cgFgSuspDtoList = new ArrayList<BlCgRefundAccountDTO>();
		for (BlCgItmOepDO cgItmDO : cgItmList) {
			
			BlCgRefundAccountDTO cgAccDto = new BlCgRefundAccountDTO();
			cgAccDto.setId_cg(cgItmDO.getId_cgitmoep());
			cgAccDto.setId_pat(cgItmDO.getId_pat());
			cgAccDto.setQuan(cgItmDO.getQuan());
			
			if(cgItmDO.getFg_susp().booleanValue()){
				cgFgSuspDtoList.add(cgAccDto);
			}else {
				cgAccDtoList.add(cgAccDto);
			}
		}
		BlCgRefundAccountSetDTO setDto = new BlCgRefundAccountSetDTO();
		//退挂起数据
		if(!ListUtil.isEmpty(cgFgSuspDtoList)){
			setDto.setSrcfunc_des(IBlCgFuncConst.FUNC_OPEN_OPREGISTER);
			setDto.setEu_rfdmode(RefundModeEnum.SUSP_KEY);
			accService.refundAccountForOp(cgFgSuspDtoList.toArray(new BlCgRefundAccountDTO[0]), setDto);
		}else {
			setDto.setSrcfunc_des(IBlCgFuncConst.FUNC_OPEN_OPREGISTER);
			setDto.setEu_rfdmode(RefundModeEnum.CG_KEY);
			accService.refundAccountForOp(cgAccDtoList.toArray(new BlCgRefundAccountDTO[0]), setDto);
		}
	}
	
	/**
	 * 查询挂号记账费用
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<BlCgItmOepDO> getRegisterCgInfo(String entId) throws BizException{
		
		//查询挂号费记账数据
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select itmoep.id_cgitmoep,");
		sqlSb.append("itmoep.id_pat,");
		sqlSb.append("itmoep.quan, ");
		//添加挂起 字段
		sqlSb.append("itmoep.fg_susp ");
		sqlSb.append("from bl_cg_itm_oep itmoep ");
		sqlSb.append("inner join bl_cg_oep cgoep ");
		sqlSb.append("on itmoep.id_cgoep = cgoep.id_cgoep ");
		sqlSb.append("and cgoep.eu_direct = 1 ");
		sqlSb.append("where itmoep.fg_refund = 'N' ");
		//放开结算限制
		//sqlSb.append("and itmoep.fg_st = 'N' ");
		sqlSb.append("and itmoep.eu_srctp = ? ");
		sqlSb.append("and itmoep.id_ent = ? ");
		
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(FeeOriginEnum.ENCOUNTER_FEE);
		param.addParam(entId);
		
		List<BlCgItmOepDO> rlt = (List<BlCgItmOepDO>)daf.execQuery(sqlSb.toString(), param, new BeanListHandler(BlCgItmOepDO.class));
		
		return rlt;
	}
}
