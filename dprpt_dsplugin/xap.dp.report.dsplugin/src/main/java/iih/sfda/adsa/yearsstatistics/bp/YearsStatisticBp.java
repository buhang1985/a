package iih.sfda.adsa.yearsstatistics.bp;

import java.util.List;

import com.software.comm.util.StringUtil;
import com.software.vtreport.data.reader.sql.RptSqlParam;

import iih.sfda.adsa.yearsstatistics.GetConstant;
import iih.sfda.adsa.yearsstatistics.ISfdaCodeConst;
import iih.sfda.adsa.yearsstatistics.dto.YearsDTO;
import iih.sfda.adsa.yearsstatistics.dto.YearsStatisticsDTO;
import iih.sfda.adsa.yearsstatistics.qry.GetDataTypeSql;
import iih.sfda.adsa.yearsstatistics.qry.GetEventLevelSql;
import iih.sfda.adsa.yearsstatistics.qry.GetEventTypeSql;
import iih.sfda.adsa.yearsstatistics.qry.GetHurtSeveritySql;
import iih.sfda.adsa.yearsstatistics.qry.GetInvolvePatSql;
import iih.sfda.adsa.yearsstatistics.qry.GetOccurAdrSql;
import iih.sfda.adsa.yearsstatistics.qry.GetReportDepSql;
import iih.sfda.adsa.yearsstatistics.qry.GetSeeDoctorSql;
import iih.sfda.adsa.yearsstatistics.qry.GetOccurDepSql;
import iih.sfda.adsa.yearsstatistics.qry.GetPatSexSql;
import xap.dp.report.data.reader.sqlqryutil.RptQryUtil;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;

public class YearsStatisticBp {

	public List<YearsDTO> exec(String quQryNodeJson, String sd_attribute, String name_year_statis, String sd_coll_ref,
			String sd_coll_range, String grp_id, String org_id) throws BizException {

		// 1、基础校验
		validation(sd_attribute, name_year_statis, sd_coll_ref, sd_coll_range, grp_id, org_id);

		// 2、查询数据
		List<YearsDTO> listDatas = queryData(quQryNodeJson, sd_attribute, name_year_statis, sd_coll_ref, sd_coll_range,grp_id, org_id);

		// 3、返回值
		return listDatas;
	}

	/**
	 * 基础校验
	 * 
	 * @return
	 */
	private boolean validation(String sd_attribute, String name_year_statis, String sd_coll_ref, String sd_coll_range,
			String grp_id, String org_id) {
		if (StringUtil.isNullOrWhitespace(sd_attribute))
			return false;
		if (StringUtil.isNullOrWhitespace(name_year_statis))
			return false;
		if (StringUtil.isNullOrWhitespace(grp_id))
			return false;
		if (StringUtil.isNullOrWhitespace(org_id))
			return false;
		if (StringUtil.isNullOrWhitespace(sd_coll_ref))
			return false;
		if (StringUtil.isNullOrWhitespace(sd_coll_range))
			return false;
		return true;
	}

	/**
	 * 查询数据处理
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<YearsDTO> queryData(String quQryNodeJson, String sd_attribute, String name_year_statis,
			String sd_coll_ref, String sd_coll_range, String grp_id, String org_id) throws BizException {
		String id_org = org_id;
		String id_grp = grp_id;
		// 查询模板解析
		if (quQryNodeJson != null) {
			// 当查询模板不为空的时候执行
			QryRootNodeDTO rootNodeDTO = new QryRootNodeDTO();
			rootNodeDTO.deSerializeJson(quQryNodeJson);
			IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
			String wherePart = service.getQueryStringWithoutDesc(rootNodeDTO);
			List<YearsDTO> returnList = GetDifferentEvents(sd_attribute, name_year_statis, sd_coll_ref, sd_coll_range,
					id_org, id_grp, wherePart);
			return returnList;
		} else {
			// 当查询模板为空的时候执行
			String wherePart = null;
			List<YearsDTO> returnList = GetDifferentEvents(sd_attribute, name_year_statis, sd_coll_ref, sd_coll_range,
					id_org, id_grp, wherePart);
			return returnList;
		}
	}

	// 判断是哪类事件
	private List<YearsDTO> GetDifferentEvents(String sd_attribute, String name_year_statis, String sd_coll_ref,
			String sd_coll_range, String id_org, String id_grp, String wherePart) throws DAException {
		//一年的开始时间和结束时间
		//String[] year = name_year_statis.split("/");
		String year = name_year_statis.substring(0, 4);
		StringBuffer start = new StringBuffer(year);
		StringBuffer end = new StringBuffer(year);
		String startTime = start.append(GetConstant.getStartDate()).toString();
		String endTime = end.append(GetConstant.getEndDate()).toString();
		YearsStatisticsDTO[] reList = null;
		List<YearsDTO> returnList = null;
		RptSqlParam[] qryParameter = null;
		String qrySQLStr = null;
		switch (sd_attribute) {
		// 事件发生地点
		case ISfdaCodeConst.SD_OCCUR_ADR:
			GetOccurAdrSql adrSql = new GetOccurAdrSql(startTime, endTime, sd_coll_ref, id_org, id_grp, wherePart);
			qryParameter = adrSql.getSqlParams();
			qrySQLStr = adrSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 发生部门
		case ISfdaCodeConst.SD_DEP_OCCUR:
			GetOccurDepSql OccDepSql = new GetOccurDepSql(startTime, endTime, sd_coll_ref, id_org, id_grp, wherePart);
			qrySQLStr = OccDepSql.getQrySQLStr();
			qryParameter = OccDepSql.getSqlParams();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 报告部门
		case ISfdaCodeConst.SD_DEP_REPORT:
			GetReportDepSql repDepSql = new GetReportDepSql(startTime, endTime, sd_coll_ref, id_org, id_grp, wherePart);
			qryParameter = repDepSql.getSqlParams();
			qrySQLStr = repDepSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 就诊形式
		case ISfdaCodeConst.SD_BD_SRV:
			GetSeeDoctorSql seeDocSql = new GetSeeDoctorSql(startTime, endTime, sd_coll_ref, id_org, id_grp, wherePart);
			qryParameter = seeDocSql.getSqlParams();
			qrySQLStr = seeDocSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 事件类别
		case ISfdaCodeConst.SD_EV_CA:
			GetEventTypeSql typeSql = new GetEventTypeSql(startTime, endTime, sd_coll_ref, id_org, id_grp, wherePart);
			qryParameter = typeSql.getSqlParams();
			qrySQLStr = typeSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 是否涉及患者
		case ISfdaCodeConst.SD_SFDA_IMPRD:
			GetInvolvePatSql patSql = new GetInvolvePatSql(sd_attribute, startTime, endTime, sd_coll_ref, id_org,
					id_grp, wherePart);
			qryParameter = patSql.getSqlParams();
			qrySQLStr = patSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 事件发生日期类型
		case ISfdaCodeConst.SD_OCCUR_DTTP:
			GetDataTypeSql dataTypeSql = new GetDataTypeSql(sd_attribute, startTime, endTime, sd_coll_ref, id_org,
					id_grp, wherePart);
			qrySQLStr = dataTypeSql.getQrySQLStr();
			qryParameter = dataTypeSql.getSqlParams();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 不良事件级别
		case ISfdaCodeConst.SD_EV_LVL:
			GetEventLevelSql levelSql = new GetEventLevelSql(sd_attribute, startTime, endTime, sd_coll_ref, id_org,
					id_grp, wherePart);
			qryParameter = levelSql.getSqlParams();
			qrySQLStr = levelSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 伤害严重度
		case ISfdaCodeConst.SD_HURT_LVL:
			GetHurtSeveritySql hurtSql = new GetHurtSeveritySql(sd_attribute, startTime, endTime, sd_coll_ref, id_org,
					id_grp, wherePart);
			qryParameter = hurtSql.getSqlParams();
			qrySQLStr = hurtSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 患者性别
		case ISfdaCodeConst.SD_PAT_SEX:
			GetPatSexSql sexSql = new GetPatSexSql(sd_attribute, startTime, endTime, sd_coll_ref, id_org, id_grp,
					wherePart);
			qryParameter = sexSql.getSqlParams();
			qrySQLStr = sexSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		}
		StatisticBp ticBp = new StatisticBp();
		if (GetConstant.getSdCollRange().equals(sd_coll_range)) {
			// 按月份分
			returnList = ticBp.GetReturnListMonth(reList);
		} else {
			// 按季度分
			returnList = ticBp.GetReturnListQuart(reList);
		}
		return returnList;
	}

	@SuppressWarnings("unchecked")
	private YearsStatisticsDTO[] GetReturnList(String qrySQLStr, RptSqlParam[] qryParameter) throws DAException {
		YearsStatisticsDTO[] reList = RptQryUtil.qryRptBeansArr(qrySQLStr, qryParameter,YearsStatisticsDTO.class);
		return reList;
	}
}
