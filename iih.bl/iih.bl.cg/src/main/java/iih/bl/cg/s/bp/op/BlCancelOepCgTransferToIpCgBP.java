package iih.bl.cg.s.bp.op;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfCudService;
import iih.bl.cg.bliptfin.d.BlCgIpTfInDO;
import iih.bl.cg.bliptfin.i.IBliptfinCudService;
import iih.bl.cg.bliptfin.i.IBliptfinRService;
import iih.bl.cg.dto.oeptoip.d.BlCgOepToIpCondDTO;
import iih.bl.cg.s.ep.BlCgItmOepTfRcdEP;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 撤销门诊转住院费用
 * @author ly 2019/03/12
 *
 */
public class BlCancelOepCgTransferToIpCgBP {

	/**
	 * 撤销门诊转住院费用
	 * @param condDto 转移条件
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void exec(BlCgOepToIpCondDTO condDto) throws BizException{
		
		this.validate(condDto);
		
		String[] cgIds = (String[])condDto.getOepcgids().toArray(new String[0]);
		
		//查询转移记录
		BlCgItmOepTfRcdEP ep = new BlCgItmOepTfRcdEP();
		BlCgItmOepTfRcdDO[] rcdDos = ep.getOepTfRcdByCgItmIds(cgIds);
		
		if(ArrayUtil.isEmpty(rcdDos) || rcdDos.length != cgIds.length){
			throw new BizException("撤销门诊转住院费用:未检索到转移记录或转移记录与传入id数量不一致");
		}
		
		List<String> ipCgIdList = new ArrayList<String>();
		for (BlCgItmOepTfRcdDO rcdDO : rcdDos) {
			ipCgIdList.add(rcdDO.getId_cgtfin());
		}
		
		//删除转移住院记账数据
		//FBoolean opFeeRtnAble = BlParams.BLSTOEP0042();
		//if(FBoolean.TRUE.equals(opFeeRtnAble)){
			for(BlCgItmOepTfRcdDO rcdDO : rcdDos){
				if (FBoolean.TRUE.equals(rcdDO.getFg_tl())) {
					throw new BizException("撤销的费用中包含真实转入住院记账费用，不可逆向操作！");
				}
			}
			
		//}
		
		this.deleteIpCg(ipCgIdList);

		//转移记录设成无效
		this.updateTfRcd(rcdDos);
	}

	/**
	 * 校验
	 * @param condDto
	 * @throws BizException
	 */
	private void validate(BlCgOepToIpCondDTO condDto) throws BizException{
		
		if(condDto == null){
			throw new BizException("撤销门诊转住院费用:入参为空");
		}
		
		if(StringUtil.isEmpty(condDto.getId_ent())){
			throw new BizException("撤销门诊转住院费用:入参就诊id为空");
		}
		
		if(condDto.getOepcgids() == null || condDto.getOepcgids().size() == 0){
			throw new BizException("撤销门诊转住院费用:入参费用明细id为空");
		}
	}

	/**
	 * 删除记账数据
	 * @param ipCgIdList
	 */
	private void deleteIpCg(List<String> ipCgIdList) throws BizException{
		
		IBliptfinRService rService = ServiceFinder.find(IBliptfinRService.class);
		IBliptfinCudService cudService = ServiceFinder.find(IBliptfinCudService.class);
		
		BlCgIpTfInDO[] tfInDos = rService.findByIds(ipCgIdList.toArray(new String[0]), FBoolean.FALSE);
		if(ArrayUtil.isEmpty(tfInDos))
			return;
		
		for (BlCgIpTfInDO tfInDO : tfInDos) {
			
			if(FBoolean.TRUE.equals(tfInDO.getFg_st_tf())){
				throw new BizException("撤销门诊转住院费用:费用已经结算无法撤销");
			}
			
			if(FBoolean.TRUE.equals(tfInDO.getFg_hp_tf())){
				throw new BizException("撤销门诊转住院费用:费用已经上传无法撤销");
			}
			
			tfInDO.setStatus(DOStatus.DELETED);
		}
		
		cudService.delete(tfInDos);
	}
	
	/**
	 * 更新转移记录
	 * @param rcdDos
	 * @throws BizException
	 */
	private void updateTfRcd(BlCgItmOepTfRcdDO[] rcdDos) throws BizException{
		
		for (BlCgItmOepTfRcdDO tfRcdDO : rcdDos) {
			
			tfRcdDO.setFg_active(FBoolean.FALSE);
			tfRcdDO.setDt_tf_canc(BlFlowContextUtil.getNowTime());
			tfRcdDO.setId_emp_tf_canc(Context.get().getStuffId());
			tfRcdDO.setId_dep_tf_canc(Context.get().getDeptId());
			tfRcdDO.setStatus(DOStatus.UPDATED);
		}
		
		IBlcgoeptfCudService cudService = ServiceFinder.find(IBlcgoeptfCudService.class);
		cudService.update(rcdDos);
	}
}
