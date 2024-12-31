package iih.ei.std.s.v1.bp.pe.pathgydata;

import java.util.ArrayList;
import java.util.List;

import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.mp.pathgydata.d.RptPathgyDTO;
import iih.ei.std.d.v1.mp.pathgydata.d.RptPathgyParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
/**
 * 
* @ClassName: SavePathgyRptDataBp
* @Description: 回写病理报告
* @author zhy
* @date 2019年9月30日
*
 */
public class SavePePathgyRptDataBp extends IIHServiceBaseBP<RptPathgyParamDTO, NoParamDTO> {

	/**
	 * 入参校验
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void checkParam(RptPathgyParamDTO param) throws BizException {
		List<RptPathgyDTO> params = new ArrayList<>(param.getRptpathgy());
		List<String> reList = new ArrayList<String>();
		if (null == param || params == null || params.size() <1) {
			throw new BizException("参数空异常！");
		}
		for (RptPathgyDTO obsItemDTO : params) {
			if (StringUtil.isEmptyWithTrim(obsItemDTO.getNo_applyform())) {
				reList.add("报告回传：申请单号空异常！");
			}
		}
		
		if (reList.size() > 0 ) {
			throw new  BizException(reList.toString());
		}
	}

	/**
	 * 核心业务
	 */
	@Override
	protected NoParamDTO process(RptPathgyParamDTO param) throws BizException {
		SavePePathgyReportDataBp bp = new SavePePathgyReportDataBp();
        bp.exec(param);
		return new NoParamDTO();
	}

}
