package iih.ei.std.s.v1.bp.pe.lisrpt;

import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.mp.lisreport.d.LisRptInfoDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 报告回写
 * @author hjh
 *
 */
public class LisPeRptBp extends IIHServiceBaseBP<LisRptInfoDTO, NoParamDTO>{

	@Override
	protected void checkParam(LisRptInfoDTO param) throws BizException {
		if(param ==null){
			throw new BizException("参数为空！");
		}
		if(StringUtil.isEmptyWithTrim(param.getNo_applyform())){
			throw new BizException("申请单号不能为空！");
		}
	}

	@Override
	protected NoParamDTO process(LisRptInfoDTO param) throws BizException {
	
		SavePeLisReportDataBp bp = new SavePeLisReportDataBp();
		
		bp.exec(param);
		return new NoParamDTO();
	}

}
