package iih.ci.mrm.s.qmpareport.bp;

import iih.ci.mrfp.cimrfpdto.d.CiMrFpDTO;
import iih.ci.mrm.cimrmdirheareportdto.d.CiMrmDirHeaReportDTO;
import iih.ci.mrm.healthsystem.d.ValueContrastDetailDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class MrmGenerateDBFBp {

	/**
	 * 获取卫生部上报的病案首页数据
	 * 
	 * @param idEnts
	 * @return
	 * @throws BizException
	 */
	public List<CiMrmDirHeaReportDTO> getMrmDirHeaReportDTOList(String[] idEnts) throws BizException {
		// ICountryzoneRService servicecountry = ServiceFinder.find(ICountryzoneRService.class);
		List<CiMrmDirHeaReportDTO> lists = new ArrayList<CiMrmDirHeaReportDTO>();
		MrmGenerateCSVBp bp = new MrmGenerateCSVBp();
		lists = bp.getDataList(idEnts, 1);
		return lists;
	}

	/**
	 * 疾病编码转化
	 * 
	 * @param sd_di
	 * @return
	 */
	private String sd_diConvert(String sd_di) {
		String newSd_di = null;
		if (sd_di != null) {
			int len = sd_di.length();
			newSd_di = sd_di.substring(0, len < 7 ? len : 7);
		}
		return newSd_di;
	}

	/**
	 * 对照分类
	 * 
	 * @throws DAException
	 */
	private List<ValueContrastDetailDO> contrastClassify(CiMrFpDTO c) throws BizException {
		// 入院科别
		String rykb = c.getSd_dep_phyadm();
		// 转科科别
		String zkkb = c.getSd_dep_trans();
		// 出院科别
		String cykb = c.getSd_dep_phydisc();

		DAFacade daf = new DAFacade();
		StringBuilder sb = new StringBuilder();
		SqlParam sp = new SqlParam();
		// 卫统4对照编码
		String code = "cs001";

		sb.append(" select * ");
		sb.append(" from ci_mrm_value_contrast_detail cd ");
		sb.append(" left join ci_mrm_value_contrast cvc ");
		sb.append(" on cd.id_value_comparison=cvc.id_value_comparison ");
		sb.append(" left join ci_mrm_con_classify cc ");
		sb.append(" on cc.id_comparison=cvc.id_comparison ");
		sb.append(" where cc.code='" + code + "' and cvc.comparison_code_source='bd_dep' ");
		sb.append(" and cd.code_source in (?,?,?) ");

		sp.addParam(rykb);
		sp.addParam(zkkb);
		sp.addParam(cykb);
		@SuppressWarnings("unchecked")
		List<ValueContrastDetailDO> list = 
			(List<ValueContrastDetailDO>) daf.execQuery(sb.toString(), sp, new BeanListHandler(ValueContrastDetailDO.class));
		return list;
	}
}
