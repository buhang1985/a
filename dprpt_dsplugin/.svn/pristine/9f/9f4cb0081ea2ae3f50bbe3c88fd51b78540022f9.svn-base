package iih.nm.nom.wardprint;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.mp.nr.common.UdidocSearchUtils;
import iih.mp.nr.common.dto.UdidocDTO;
import iih.nm.nom.dto.NomQualityMonthDTO;
import iih.nm.nom.wardprint.qry.GetNomQualityChartsQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetNomQualityNumChartsBp {

	public List<NomQualityMonthDTO> exec(String id_dep_nurs, String dt_begin, String dt_end, String udidocCode, String is_Ward) throws BizException {

		// 1.基础参数校验

		// 2.获取档案数据
		UdidocDTO udidoc = UdidocSearchUtils.findByCode("NM.NOM.0035", udidocCode);

		// 3.获取参数
		String qry = udidoc.getCtrl1();// 获取执行Sql
		FBoolean isWard = new FBoolean(is_Ward);

		// 4.分解科室Id
		List<String> id_deps = splitDeps(id_dep_nurs);

		// 5.获取报表需展示数据
		List<NomQualityMonthDTO> monthDTOs = getNomQualityMonthDTOs(qry, id_deps, dt_begin, dt_end, isWard);

		return monthDTOs;
	}

	// 分解科室Id
	private List<String> splitDeps(String id_dep_nurs) {

		List<String> relist = new ArrayList<String>();
		if (StringUtils.isNotBlank(id_dep_nurs)) {
			String[] id_deps = id_dep_nurs.split(",");
			if (ArrayUtils.isNotEmpty(id_deps)) {
				CollectionUtils.addAll(relist, id_deps);
			}
		}
		return relist;
	}
	// 获取报表需展示数据
	private List<NomQualityMonthDTO> getNomQualityMonthDTOs(String sql, List<String> id_dep_nurs, String dt_begin, String dt_end, FBoolean isWard) throws DAException {

		GetNomQualityChartsQry qry = new GetNomQualityChartsQry(sql, id_dep_nurs, dt_begin, dt_end, isWard);
		@SuppressWarnings("unchecked")
		List<NomQualityMonthDTO> qualityMonthDTOs = (List<NomQualityMonthDTO>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(NomQualityMonthDTO.class));
		return qualityMonthDTOs;
	}
}
