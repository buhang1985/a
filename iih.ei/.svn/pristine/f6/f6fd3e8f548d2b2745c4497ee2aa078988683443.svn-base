package iih.ei.std.s.v1.bp.pe.pacsdata;

import java.util.ArrayList;
import java.util.List;

import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.mp.pacedata.d.RptObsItemDTO;
import iih.ei.std.d.v1.mp.pacedata.d.RptObsItemParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
/**
 * 
* @ClassName: SaveObsRptDataBp
* @Description: 保存检查报告
* @author zhy
* @date 2019年9月29日
*
 */
public class SavePeObsRptDataBp extends IIHServiceBaseBP<RptObsItemParamDTO, NoParamDTO>{
	
	/**
	 * 入参校验
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void checkParam(RptObsItemParamDTO param) throws BizException {
		List<RptObsItemDTO> params = new ArrayList<>(param.getRptobsitem());
		if (params == null || params.size() <1) {
			throw new BizException("参数空异常！");
		}
		for (RptObsItemDTO obsItemDTO : params) {
			if (StringUtil.isEmptyWithTrim(obsItemDTO.getNo_applyform())) {
				throw new BizException("报告回传：申请单号空异常！");
			}
		}
		
	}
	
	/**
	 * 核心业务
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected NoParamDTO process(RptObsItemParamDTO param) throws BizException {
		RptObsItemDTO[] params = (RptObsItemDTO[]) param.getRptobsitem().toArray(new RptObsItemDTO[0]);
		SavePeReportDataBp bp = new SavePeReportDataBp();
		bp.exec(params);
		return new NoParamDTO();
	}

}
