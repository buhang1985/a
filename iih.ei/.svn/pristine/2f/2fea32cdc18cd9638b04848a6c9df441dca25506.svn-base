package iih.ei.std.s.v1.bp.mp.crisisvalue;

import java.util.ArrayList;
import java.util.List;

import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LisCrisisParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
/**
 * 
* @ClassName: CrisisValuePackageBp
* @Description: 危急值回写
* @author zhy
* @date 2019年9月29日
*
 */
public class CrisisValuePackageBp extends IIHServiceBaseBP<LisCrisisParamDTO, NoParamDTO>{
	
	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(LisCrisisParamDTO param) throws BizException {
		List<String> reList = new ArrayList<String>();
		if (param == null) {
			throw new BizException("参数空异常！");
		}

		if (StringUtil.isEmptyWithTrim(param.getNo_applyform())) {
			reList.add("申请单号空异常！");
		}

		if (StringUtil.isEmptyWithTrim(param.getId_alert())) {
			reList.add("上报ID为空！");
		}
		if (StringUtil.isEmptyWithTrim(param.getCode_emp_alert())) {
			reList.add("上报人编码为空！");
		}
		if (reList.size() > 0) {
			throw new BizException(reList.toString());
		}
	}
	
	/**
	 * 核心业务
	 */
	@Override
	protected NoParamDTO process(LisCrisisParamDTO param) throws BizException {
		UpdateCrisisValueBp bp = new UpdateCrisisValueBp();
		bp.exec(param);
		return new NoParamDTO();
	}

}
