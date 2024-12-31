package iih.ei.std.s.v1.bp.mp.updatebyplan;

import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.PlanStatusForLisParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;

/**
 * @Description: 检验合管插入的材料费和采血费单独改状态计费
 * @author: ma.meng@founder.com.cn
 * @version： 2019年12月9日 上午11:38:22 创建
 */
public class UpdatePlanStatusForLisBp extends IIHServiceBaseBP<PlanStatusForLisParamDTO, NoParamDTO>{

	@Override
	protected void checkParam(PlanStatusForLisParamDTO param) throws BizException {
		// TODO Auto-generated method stub
		if(param == null){
			throw new BizException("修改Lis合管状态，参数为空");
		}
	}

	@Override
	protected NoParamDTO process(PlanStatusForLisParamDTO param) throws BizException {
		// TODO Auto-generated method stub
		UpdatePlanStatusForLis2Bp bp = new UpdatePlanStatusForLis2Bp();
		bp.exec(param);
		return new NoParamDTO();
	}

}
