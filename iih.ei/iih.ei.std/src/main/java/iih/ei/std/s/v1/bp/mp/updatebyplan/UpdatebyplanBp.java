package iih.ei.std.s.v1.bp.mp.updatebyplan;

import java.util.List;

import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.mp.updatebycodeor.d.UpdateStatusParams;
import iih.ei.std.d.v1.mp.updatebycodeor.d.WOrPlanDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;

/**
 * 修改医嘱状态
 * @author hjh
 *
 */
public class UpdatebyplanBp extends IIHServiceBaseBP<UpdateStatusParams, NoParamDTO>{

	@Override
	protected void checkParam(UpdateStatusParams param) throws BizException {
		if(param == null){
			throw new BizException("修改医嘱状态，参数为空");
		}
		@SuppressWarnings("unchecked")
		List<WOrPlanDTO> planDTOs = param.getOrplan();
		if(planDTOs == null || planDTOs.size()<1){
			throw new BizException("修改医嘱状态，参数为空");
		}
		
	}

	@Override
	protected NoParamDTO process(UpdateStatusParams param) throws BizException {
		UpdateOrStaBp bp = new UpdateOrStaBp();
		bp.exec(param);
		return new NoParamDTO();
	}

}
