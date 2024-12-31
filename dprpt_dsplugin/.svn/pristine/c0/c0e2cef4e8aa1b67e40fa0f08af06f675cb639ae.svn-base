package iih.nm.nom.wardprint;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.software.vtreport.data.reader.sql.RptSqlParam;

import iih.mp.nr.common.UdidocSearchUtils;
import iih.mp.nr.common.dto.UdidocDTO;
import iih.nm.nom.dto.NomQualityMonthDTO;
import iih.nm.nom.wardprint.qry.GetNomQualityChartsQry;
import test.qysh.demo.ReportInfoDTO;
import xap.dp.report.data.reader.sql.RptRsHanlderUtils;
import xap.dp.report.data.reader.sql.SqlExecutor;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @Description:获取护理质量图表数据
 * @author:zhongcl@founder.com.cn
 * @version:2019年1月9日 下午3:22:38 创建
 */
public class GetNomQualityChartsBp {

	public List<NomQualityMonthDTO> exec(String id_dep_nurs, String dt_begin, String dt_end, String udidocCode, String is_Ward) throws BizException {

		// 1.基础参数校验

		// 2.获取档案数据
		UdidocDTO udidoc = UdidocSearchUtils.findByCode("NM.NOM.0035", udidocCode);

		// 3.获取参数
		String qry = udidoc.getCtrl1();// 获取执行Sql
		FBoolean isWard = new FBoolean(is_Ward);

		// 4.分解科室
		List<String> id_deps = splitDeps(id_dep_nurs);

		// 5.获取报表需展示数据
		List<NomQualityMonthDTO> monthDTOs = getNomQualityMonthDTOs(qry, id_deps, dt_begin, dt_end, isWard);

		// 6.对小数位数进行特殊处理
		dealDeciNum(monthDTOs);

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
	@SuppressWarnings("unchecked")
	private List<NomQualityMonthDTO> getNomQualityMonthDTOs(String sql, List<String> id_dep_nurs, String dt_begin, String dt_end, FBoolean isWard) throws BizException {
		GetNomQualityChartsQry qry = new GetNomQualityChartsQry(sql, id_dep_nurs, dt_begin, dt_end, isWard);
		SqlExecutor sql_exe=new SqlExecutor();
		sql_exe.setSql(qry.getQrySQLStr());
		if(CollectionUtils.isNotEmpty(id_dep_nurs)){
			for(String id_dep_nur :id_dep_nurs){
			RptSqlParam param1 = new RptSqlParam(id_dep_nur, String.class);
			sql_exe.addParamSorted(param1);
			}
		}
		RptSqlParam param2 = new RptSqlParam(dt_begin, String.class);
		sql_exe.addParamSorted(param2);
		RptSqlParam param3 = new RptSqlParam(dt_end, String.class);
		sql_exe.addParamSorted(param3);
		List<NomQualityMonthDTO> beanlist = null;
		try {
			// 执行sql查询
			ResultSet rset = sql_exe.exeQuery();
			// 将查询结果集转换成JavaBean对象列表
			beanlist = (List<NomQualityMonthDTO>)RptRsHanlderUtils.toBeanList(rset, NomQualityMonthDTO.class);
			// 关闭结果集
			SqlExecutor.closeResultSet(rset);
		}
		catch(Exception ex) {
			throw new BizException(ex);
		}
		finally {
			sql_exe.destroy();
		}
		return beanlist;
	}

	// 格式化数据
	private void dealDeciNum(List<NomQualityMonthDTO> monthDTOs) {
		if (CollectionUtils.isEmpty(monthDTOs))
			return;
		for (NomQualityMonthDTO nomQualityMonthDTO : monthDTOs) {
			double warn_value = formateData(nomQualityMonthDTO.getWarn_value().doubleValue());
			nomQualityMonthDTO.setWarn_value(new FDouble(warn_value));
			double target_value = formateData(nomQualityMonthDTO.getTarget_value().doubleValue());
			nomQualityMonthDTO.setTarget_value(new FDouble(target_value));
			if(nomQualityMonthDTO.getActaul_value()==null){
				nomQualityMonthDTO.setActaul_value(new FDouble(0));
			}else{
				double actual_value = formateData(nomQualityMonthDTO.getActaul_value().doubleValue());
				nomQualityMonthDTO.setActaul_value(new FDouble(actual_value));
			}
		}
	}

	// 设置小数位数
	private double formateData(double data) {
		BigDecimal bigDecimal = new BigDecimal(data);
		double result = bigDecimal.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}
}
