package iih.ei.std.s.v1.bp.hr;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.hr.schedsiinfodto.d.AllSiInParamDTO;
import iih.ei.std.d.v1.hr.schedsiinfodto.d.SchedSiInfoDTO;
import iih.ei.std.d.v1.hr.schedsiinfodto.d.SchedSiInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.hr.qry.GetAllSchedSiInfoSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;

/**
 * 获取全院排班班次信息
 * is_all:TRUE/FALSE(全院包含科室内班次/全院不包含科室班次)
 * @author Lijm
 *
 */
public class GetAllSchedSiInfoBp extends IIHServiceBaseBP<AllSiInParamDTO, SchedSiInfoResultDTO> {

	@Override
	protected void checkParam(AllSiInParamDTO param) throws BizException {
		if (param == null) {
			throw new BizException("全院班次信息查询参数为空！");
		}	
	}

	@Override
	protected SchedSiInfoResultDTO process(AllSiInParamDTO param) throws BizException {
		SchedSiInfoResultDTO resultDTO = new SchedSiInfoResultDTO();
		GetAllSchedSiInfoSql sql = new GetAllSchedSiInfoSql(param.getIs_all());
		List<SchedSiInfoDTO> list = this.findDataList(sql.getQrySQLStr(), sql.getQryParameter(null), SchedSiInfoDTO.class);
		if (ListUtil.isEmpty(list)) {
			return resultDTO;
		}
		resultDTO.setSchedsiinfo(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
}
