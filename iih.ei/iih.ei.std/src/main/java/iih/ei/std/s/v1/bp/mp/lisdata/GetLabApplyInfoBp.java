package iih.ei.std.s.v1.bp.mp.lisdata;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ei.std.d.v1.mp.lisdata.d.LabParamDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LabPatinfoDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LabPatinfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

public class GetLabApplyInfoBp extends IIHServiceBaseBP<LabParamDTO, LabPatinfoResultDTO>{
	
	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(LabParamDTO param) throws BizException {
		// TODO Auto-generated method stub
		if (null == param) {
			throw new BizException("参数空异常");
		}
		if(StringUtil.isEmptyWithTrim(param.getCode_entp())){
			throw new BizException("患者就诊类型不能为空！");
		}
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(param.getCode_entp()) && StringUtil.isEmptyWithTrim(param.getCode()) && StringUtil.isEmptyWithTrim(param.getNo_applyform()) && StringUtil.isEmptyWithTrim(param.getCode_ward())){
			throw new BizException("申请单号,患者唯一标识和病区编码不能同时为空不能同时为空！");
		}
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(param.getCode_entp()) && StringUtil.isEmptyWithTrim(param.getCode()) && StringUtil.isEmptyWithTrim(param.getNo_applyform())){
			throw new BizException("申请单号和患者唯一标识不能同时为空不能同时为空！");
		}
	}
	
	/**
	 * 核心业务
	 */
	@Override
	protected LabPatinfoResultDTO process(LabParamDTO param) throws BizException {
		QueryLabDataBp bp = new QueryLabDataBp();
		return bp.exec(param);
	}

}
