package iih.ei.std.s.v1.bp.mp.pathgydata;

import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyInfoResultDTO;
import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.mp.nr.iihtopathgy.d.PathgyApplyRequest;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
/**
 * 
* @ClassName: GetPathgyApplyInfoBp
* @Description: 获取病理申请单信息
* @author zhy
* @date 2019年9月27日
*
 */
public class GetPathgyApplyInfoBp extends IIHServiceBaseBP<PathgyApplyParamDTO, PathgyApplyInfoResultDTO>{
	
	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(PathgyApplyParamDTO param) throws BizException {
		
		if (param == null) {
			throw new BizException("参数空异常！ ");
		}
		if (StringUtil.isEmptyWithTrim(param.getCode_entp())) {
			throw new BizException("患者就诊类型不能为空！");
		}
		if (StringUtil.isEmptyWithTrim(param.getCode()) && StringUtil.isEmptyWithTrim(param.getNo_applyform())) {
			throw new BizException("患者编码和申请单号不能同时为空");
		}

		
	}

	/**
	 * 核心业务
	 */
	@Override
	protected PathgyApplyInfoResultDTO process(PathgyApplyParamDTO param) throws BizException {
		QueryPathgyDataBp bp = new QueryPathgyDataBp();
		return bp.exec(param);
	}

}
