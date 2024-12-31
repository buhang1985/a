package iih.ei.std.s.v1.bp.pe.pacsdata;

import java.util.ArrayList;
import java.util.List;

import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.mp.pacedata.d.RptObsCrisisDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
/**
 * 
* @ClassName: ObsCrisisBp
* @Description: 检查危急值回写
* @author zhy
* @date 2019年9月30日
*
 */
public class ObsPeCrisisBp extends IIHServiceBaseBP<RptObsCrisisDTO, NoParamDTO>{
	
	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(RptObsCrisisDTO param) throws BizException {
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
	protected NoParamDTO process(RptObsCrisisDTO param) throws BizException {
		UpdatePeObsCrisisBp bp = new UpdatePeObsCrisisBp();
		bp.exec(param);
		return new NoParamDTO();
	}

}
