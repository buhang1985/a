package iih.cssd.dfp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.cssd.dfp.dto.dfplable.d.DfpShortLabelDTO;
import iih.cssd.dfp.qry.GetShortLabelSql;
import xap.dp.report.data.reader.sqlqryutil.RptQryUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;

public class GetShortDfpLabelBp {

	/**
	 * 主入口
	 * 
	 * @param id_dfps
	 * @return
	 * @throws BizException
	 */
	public List<DfpShortLabelDTO> exec(String id_dfps) throws BizException {

		// 1、参数校验
		if (StringUtil.isEmptyWithTrim(id_dfps))
			return null;

		// 2、查询数据
		DfpShortLabelDTO[] datas = queryData(id_dfps);

		// 3、组装数据
		List<DfpShortLabelDTO> rtns = pkgData(datas);

		return rtns;
	}

	/**
	 * 查询数据
	 * 
	 * @param id_dfps
	 * @throws DAException
	 */
	private DfpShortLabelDTO[] queryData(String inParams) {
		String[] id_dfps = inParams.split("\\,");
		if (id_dfps == null || id_dfps.length < 1)
			return null;
		GetShortLabelSql sql = new GetShortLabelSql(id_dfps);
		DfpShortLabelDTO[] rtns = RptQryUtil.qryRptBeansArr(sql.getQrySql(), sql.getSqlParams(), DfpShortLabelDTO.class);
		return rtns;
	}

	/**
	 * 组装数据
	 * 
	 * @param dataList
	 */
	private List<DfpShortLabelDTO> pkgData(DfpShortLabelDTO[] rtns) {
		if (rtns == null || rtns.length < 1)
			return null;
		//有多次灭菌时，取最大灭菌的那次时间
		HashMap<String, DfpShortLabelDTO> reMap = new HashMap<String, DfpShortLabelDTO>();
		for (DfpShortLabelDTO rtn : rtns) {
			if (!reMap.containsKey(rtn.getId_dfp())) {
				reMap.put(rtn.getId_dfp(), rtn);
				continue;
			}
			if (StringUtil.isEmptyWithTrim(rtn.getDt_stz()))
				continue;
			DfpShortLabelDTO maxDfp = reMap.get(rtn.getId_dfp());
			if (StringUtil.isEmptyWithTrim(maxDfp.getDt_stz())) {
				reMap.put(rtn.getId_dfp(), rtn);
				continue;
			}
			FDateTime dt_max = new FDateTime(maxDfp.getDt_stz());
			FDateTime dt_rtn = new FDateTime(rtn.getDt_stz());
			if (dt_rtn.compareTo(dt_max) > 0) {
				reMap.put(rtn.getId_dfp(), rtn);
			}
		}

		List<DfpShortLabelDTO> reList = new ArrayList<DfpShortLabelDTO>();
		if (reMap.values().size() > 0) {
			for (DfpShortLabelDTO rtn : reMap.values()) {
				reList.add(rtn);
			}
		}
		return reList;
	}
}
