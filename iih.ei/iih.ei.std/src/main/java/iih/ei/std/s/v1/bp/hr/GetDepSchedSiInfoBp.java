package iih.ei.std.s.v1.bp.hr;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.hr.schedsiinfodto.d.DepSiInParamDTO;
import iih.ei.std.d.v1.hr.schedsiinfodto.d.SchedSiInfoDTO;
import iih.ei.std.d.v1.hr.schedsiinfodto.d.SchedSiInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.hr.qry.GetDepSchedSiInfoSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;

/**
 * 获取科室排班班次信息 Is_onlydep：true/false(只获取当前科室下班次/获取当前科室下班次+全院类型班次)
 * 
 * @author Lijm
 *
 */
public class GetDepSchedSiInfoBp extends IIHServiceBaseBP<DepSiInParamDTO, SchedSiInfoResultDTO> {

	@Override
	protected void checkParam(DepSiInParamDTO param) throws BizException {
		if (param == null) {
			throw new BizException("给定科室班次信息查询参数为空！");
		}
	}

	@Override
	protected SchedSiInfoResultDTO process(DepSiInParamDTO param) throws BizException {
		SchedSiInfoResultDTO resultDTO = new SchedSiInfoResultDTO();
		GetDepSchedSiInfoSql sql = new GetDepSchedSiInfoSql(param.getId_dep(), param.getIs_onlydep());
		List<SchedSiInfoDTO> list = this.findDataList(sql.getQrySQLStr(), sql.getQryParameter(null), SchedSiInfoDTO.class);
		if (ListUtil.isEmpty(list)) {
			return resultDTO;
		}
		resultDTO.setSchedsiinfo(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
}
