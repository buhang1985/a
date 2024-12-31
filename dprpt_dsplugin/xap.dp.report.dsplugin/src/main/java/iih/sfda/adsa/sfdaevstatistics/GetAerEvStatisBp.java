package iih.sfda.adsa.sfdaevstatistics;

import iih.sfda.adsa.dto.sfdaevstatistics.StatisticsDTO;
import iih.sfda.adsa.s.ISfdaAdsaConst;
import iih.sfda.adsa.sfdaevstatistics.qry.GetAerEvStatisAllSql;
import iih.sfda.adsa.sfdaevstatistics.qry.GetAerEvStatisBigSql;
import iih.sfda.adsa.sfdaevstatistics.qry.GetAerEvStatisSingleSql;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 事件概况统计
 * 
 * @author lijm
 *
 */
public class GetAerEvStatisBp {
	public List<StatisticsDTO> exec(String qryNodeJson, String sd_genre, String sd_single, String id_org, String id_grp) throws BizException {
		// 1.参数校验
		paramIsLegal(id_org, id_grp);

		// 2.获取查询模板条件
		String wherePart = getWherePartByQryNode(qryNodeJson);

		// 3.查询数据
		List<StatisticsDTO> resData = qryData(wherePart, sd_genre, sd_single, id_org, id_grp);

		// 4.返回结果
		return resData;
	}

	private void paramIsLegal(String id_org, String id_grp) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_org) || StringUtil.isEmptyWithTrim(id_grp)) {
			throw new BizException(String.format("参数【组织】或【集团】为空，请检查后重试！"));
		}
	}

	/**
	 * 获取查询面板条件
	 * 
	 * @param qryNodeJson
	 * @return
	 * @throws BizException
	 */
	private String getWherePartByQryNode(String qryNodeJson) throws BizException {
		String wherePart = null;
		if (qryNodeJson != null) {
			QryRootNodeDTO rootNodeDTO = new QryRootNodeDTO();
			rootNodeDTO.deSerializeJson(qryNodeJson);
			IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
			wherePart = service.getQueryStringWithoutDesc(rootNodeDTO);
		}
		return wherePart;
	}

	@SuppressWarnings("unchecked")
	private List<StatisticsDTO> qryData(String wherePart, String sd_genre, String sd_single, String id_org, String id_grp) throws BizException {
		ITransQry qry = null;
		switch (sd_genre) {
		case ISfdaAdsaConst.SD_STATISTP_BIG:
			qry = new GetAerEvStatisBigSql(wherePart, id_org, id_grp);
			break;
		case ISfdaAdsaConst.SD_STATISTP_SINGLE:
			qry = new GetAerEvStatisSingleSql(sd_single, wherePart, id_org, id_grp);
			break;
		case ISfdaAdsaConst.SD_STATISTP_ALL:
			qry = new GetAerEvStatisAllSql(wherePart, id_org, id_grp);
			break;
		}
		if (qry == null)
			return null;
		String sql = qry.getQrySQLStr();
		List<StatisticsDTO> reList = (List<StatisticsDTO>) new DAFacade().execQuery(sql, qry.getQryParameter(null), new BeanListHandler(StatisticsDTO.class));
		return reList;
	}
}
