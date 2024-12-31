package iih.sfda.adsa.s.bp;

import java.util.List;

import iih.sfda.adsa.s.dto.DeepStatisticsDTO;
import iih.sfda.adsa.s.qry.QryOccurAdrSql;
import iih.sfda.adsa.s.qry.QryOccurDepSql;
import iih.sfda.adsa.s.qry.QryPatSexSql;
import iih.sfda.adsa.s.qry.QryReportDepSql;
import iih.sfda.adsa.s.qry.QrySeeDoctorSql;
import iih.sfda.adsa.yearsstatistics.ISfdaCodeConst;
import iih.sfda.adsa.s.qry.QryDataTypeSql;
import iih.sfda.adsa.s.qry.QryEevenTypeSql;
import iih.sfda.adsa.s.qry.QryEventLevelSql;
import iih.sfda.adsa.s.qry.QryHurtSeveritySql;
import iih.sfda.adsa.s.qry.QryInvolvePatSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取检验标签信息
 * 
 * @author 32797
 *
 */
public class StatisticLableInfoBp {

	/**
	 * 主入口
	 * 
	 * @param id_papt
	 * @return
	 * @throws BizException
	 *             QryRootNodeDTO quQryRootNodeDto,
	 */
	public List<DeepStatisticsDTO> exec(String quQryNodeJson, String sd_attribute, String id_org, String id_grp)
			throws BizException {

		// 1、基础校验
		if (!validation(sd_attribute, id_org, id_grp))
			return null;

		// 2、查询数据
		List<DeepStatisticsDTO> listDatas = queryData(quQryNodeJson, sd_attribute, id_org, id_grp);

		// 3、返回值
		return listDatas;
	}

	/**
	 * 基础校验
	 * 
	 * @return
	 */
	private boolean validation(String sd_attribute, String id_org, String id_grp) {
		if (StringUtil.isEmptyWithTrim(sd_attribute))
			return false;
		if (StringUtil.isEmptyWithTrim(id_org))
			return false;
		if (StringUtil.isEmptyWithTrim(id_grp))
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	private List<DeepStatisticsDTO> queryData(String quQryNodeJson, String sd_attribute, String id_org, String id_grp)
			throws BizException {
		// 查询模板解析
		if (quQryNodeJson != null) {
			// 当查询模板不为空的时候执行
			QryRootNodeDTO rootNodeDTO = new QryRootNodeDTO();
			rootNodeDTO.deSerializeJson(quQryNodeJson);
			IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
			String wherePart = service.getQueryStringWithoutDesc(rootNodeDTO);
			List<DeepStatisticsDTO> returnList = GetDifferentEvents(sd_attribute,id_org, id_grp, wherePart);
			return returnList;
		} else {
			// 当查询模板为空的时候执行
			String wherePart = null;
			List<DeepStatisticsDTO> returnList = GetDifferentEvents(sd_attribute,id_org, id_grp, wherePart);
			return returnList;
		}
	}

	// 判断是哪类事件
	@SuppressWarnings("unused")
	private List<DeepStatisticsDTO> GetDifferentEvents(String sd_attribute,String id_org, String id_grp, String wherePart) throws DAException {
		List<DeepStatisticsDTO> reList = null;
		SqlParam qryParameter = null;
		String qrySQLStr = null;
		switch (sd_attribute) {
		// 事件发生地点
		case ISfdaCodeConst.SD_OCCUR_ADR:
			QryOccurAdrSql adrSql = new QryOccurAdrSql(id_org, id_grp, wherePart);
			qryParameter = adrSql.getQryParameter(null);
			qrySQLStr = adrSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 发生部门
		case ISfdaCodeConst.SD_DEP_OCCUR:
			QryOccurDepSql OccDepSql = new QryOccurDepSql(id_org, id_grp, wherePart);
			qrySQLStr = OccDepSql.getQrySQLStr();
			qryParameter = OccDepSql.getQryParameter(null);
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 报告部门
		case ISfdaCodeConst.SD_DEP_REPORT:
			QryReportDepSql repDepSql = new QryReportDepSql(id_org, id_grp, wherePart);
			qryParameter = repDepSql.getQryParameter(null);
			qrySQLStr = repDepSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 就诊形式
		case ISfdaCodeConst.SD_BD_SRV:
			QrySeeDoctorSql seeDocSql = new QrySeeDoctorSql(id_org, id_grp, wherePart);
			qryParameter = seeDocSql.getQryParameter(null);
			qrySQLStr = seeDocSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 事件类别
		case ISfdaCodeConst.SD_EV_CA:
			QryEevenTypeSql typeSql = new QryEevenTypeSql(id_org, id_grp, wherePart);
			qryParameter = typeSql.getQryParameter(null);
			qrySQLStr = typeSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 是否涉及患者
		case ISfdaCodeConst.SD_SFDA_IMPRD:
			QryInvolvePatSql patSql = new QryInvolvePatSql(sd_attribute,id_org,id_grp, wherePart);
			qryParameter = patSql.getQryParameter(null);
			qrySQLStr = patSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 事件发生日期类型
		case ISfdaCodeConst.SD_OCCUR_DTTP:
			QryDataTypeSql dataTypeSql = new QryDataTypeSql(sd_attribute,id_org,id_grp, wherePart);
			qrySQLStr = dataTypeSql.getQrySQLStr();
			qryParameter = dataTypeSql.getQryParameter(null);
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 不良事件级别
		case ISfdaCodeConst.SD_EV_LVL:
			QryEventLevelSql levelSql = new QryEventLevelSql(sd_attribute,id_org,id_grp, wherePart);
			qryParameter = levelSql.getQryParameter(null);
			qrySQLStr = levelSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 伤害严重度
		case ISfdaCodeConst.SD_HURT_LVL:
			QryHurtSeveritySql hurtSql = new QryHurtSeveritySql(sd_attribute,id_org,id_grp, wherePart);
			qryParameter = hurtSql.getQryParameter(null);
			qrySQLStr = hurtSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		// 患者性别
		case ISfdaCodeConst.SD_PAT_SEX:
			QryPatSexSql sexSql = new QryPatSexSql(sd_attribute,id_org, id_grp,wherePart);
			qryParameter = sexSql.getQryParameter(null);
			qrySQLStr = sexSql.getQrySQLStr();
			reList = GetReturnList(qrySQLStr, qryParameter);
			break;
		}
		return reList;
	}

	@SuppressWarnings("unchecked")
	private List<DeepStatisticsDTO> GetReturnList(String qrySQLStr, SqlParam qryParameter) throws DAException {
		List<DeepStatisticsDTO> reList = (List<DeepStatisticsDTO>) new DAFacade().execQuery(qrySQLStr, qryParameter,
				new BeanListHandler(DeepStatisticsDTO.class));
		return reList;
	}
}
