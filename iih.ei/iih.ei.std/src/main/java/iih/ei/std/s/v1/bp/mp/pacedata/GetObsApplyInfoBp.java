package iih.ei.std.s.v1.bp.mp.pacedata;

import iih.ei.std.d.v1.mp.pacedata.d.ObsParamDTO;
import iih.ei.std.d.v1.mp.pacedata.d.ObsPatinfoDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
/**
 * 
* @ClassName: GetObsApplyInfoBp
* @Description: 获取检查申请单信息
* @author zhy
* @date 2019年9月25日
*
 */
public class GetObsApplyInfoBp extends IIHServiceBaseBP<ObsParamDTO, ObsPatinfoDTO>{

	/**
	 * 入参校验 
	 */
	@Override
	protected void checkParam(ObsParamDTO param) throws BizException {
		if (null == param) {
			throw new BizException("参数空异常 !");
		}
		if (StringUtil.isEmptyWithTrim(param.getCode()) && StringUtil.isEmptyWithTrim(param.getApplyno())) {
			throw new BizException("申请单号与患者唯一标识不能同时为空！");
		}
	}

	/**
	 * 核心业务
	 */
	@Override
	protected ObsPatinfoDTO process(ObsParamDTO param) throws BizException {
		return new QueryObsDataBp().exec(param);
	}
}
