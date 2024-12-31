package iih.mr.mrm;

import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 出院病人疾病转归情况
 */
public class TreatmentOutComeService {

	/**
	 * 查询方法
	 * 
	 * @param begindate
	 * @param enddate
	 * @return
	 * @throws BizException
	 */
	public List<TreatmentOutComeDTO> getReportList(String date, String date_1) throws BizException {
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct xy.id_di as id_di, ");
		sql.append("                xy.name_di as disease ");
		sql.append("from CI_MR_FP_XYDI xy  ");
		sql.append("left join ci_mr_fp_di di on di.id_mrfpdi=xy.id_mrfpdi  ");
		sql.append("left join en_ent ee on ee.id_ent=di.id_ent  ");
		sql.append("where xy.fg_maindi='Y' and ee.code_entp='10' and ee.fg_ip='N' ");
		SqlParam sq = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(date)) {
			sql.append(" and ee.dt_end>=? ");
			sq.addParam(date);
		}
		if (!StringUtil.isEmptyWithTrim(date_1)) {
			sql.append(" and ee.dt_end<=? ");
			sq.addParam(date_1);
		}
		@SuppressWarnings("unchecked")
		List<TreatmentOutComeDTO> list = (List<TreatmentOutComeDTO>) daf.execQuery(sql.toString(), sq,
				new BeanListHandler(TreatmentOutComeDTO.class));
		if (list != null && list.size() > 0) {
			list = getDiseaseData(list, date, date_1);
			list = getSumData(list);
		}
		return list;
	}

	/**
	 * 获取其他数据
	 * 
	 * @param list
	 * @return
	 * @throws DAException
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public List<TreatmentOutComeDTO> getDiseaseData(List<TreatmentOutComeDTO> list, String date, String date_1)
			throws DAException {
		DAFacade dafa = new DAFacade();
		List<TreatmentOutComeDTO> data = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select count(ee.id_ent) as total, ");
		sql.append("count(case when xy.sd_treatment_outcome='1' then 1 else null end) as cure,  ");
		sql.append("count(case when xy.sd_treatment_outcome='2' then 1 else null end) as become_better,  ");
		sql.append("count(case when xy.sd_treatment_outcome='3' then 1 else null end) as healed,  ");
		sql.append("count(case when xy.sd_treatment_outcome='4' then 1 else null end) as death,  ");
		sql.append("count(case when xy.sd_treatment_outcome='5' then 1 else null end) as other,  ");
		sql.append("sum(pat.hosdays) as in_hospital_day  ");
		sql.append("from en_ent ee   ");
		sql.append("left join CI_MR_FP_PAT pat on pat.id_ent=ee.id_ent  ");
		sql.append("left join ci_mr_fp_di di on di.id_ent=ee.id_ent  ");
		sql.append("left join CI_MR_FP_XYDI xy on xy.id_mrfpdi=di.id_mrfpdi   ");
		sql.append("where ee.code_entp='10' and ee.fg_ip='N' and xy.fg_maindi='Y' ");
		SqlParam sq = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(date)) {
			sql.append(" and ee.dt_end>=? ");
			sq.addParam(date);
		}
		if (!StringUtil.isEmptyWithTrim(date_1)) {
			sql.append(" and ee.dt_end<=? ");
			sq.addParam(date_1);
		}
		String sqlStr=sql.toString();
		String str=null;
		for (TreatmentOutComeDTO dto : list) {
			dto.setTotal("0");
			dto.setCure("0");
			dto.setBecome_better("0");
			dto.setHealed("0");
			dto.setDeath("0");
			dto.setOther("0");
			dto.setIn_hospital_day("0");

			if (!StringUtil.isEmptyWithTrim(dto.getId_di())) {
				String diStr="  and  xy.id_di='" + dto.getId_di() + "' ";
				str=sqlStr+diStr;
				data = (List<TreatmentOutComeDTO>) dafa.execQuery(str, sq,
						new BeanListHandler(TreatmentOutComeDTO.class));
				if (data != null && data.size() > 0) {
					if (!StringUtil.isEmptyWithTrim(data.get(0).getTotal()))
						dto.setTotal(data.get(0).getTotal());
					if (!StringUtil.isEmptyWithTrim(data.get(0).getCure()))
						dto.setCure(data.get(0).getCure());
					if (!StringUtil.isEmptyWithTrim(data.get(0).getBecome_better()))
						dto.setBecome_better(data.get(0).getBecome_better());
					if (!StringUtil.isEmptyWithTrim(data.get(0).getHealed()))
						dto.setHealed(data.get(0).getHealed());
					if (!StringUtil.isEmptyWithTrim(data.get(0).getDeath()))
						dto.setDeath(data.get(0).getDeath());
					if (!StringUtil.isEmptyWithTrim(data.get(0).getOther()))
						dto.setOther(data.get(0).getOther());
					if (!StringUtil.isEmptyWithTrim(data.get(0).getIn_hospital_day()))
						dto.setIn_hospital_day(data.get(0).getIn_hospital_day());
				}
			}
			str=null;
			data = null;
		}
		return list;
	}

	/**
	 * 获取列总和数据
	 * 
	 * @param list
	 * @return
	 * @throws BizException
	 */
	public List<TreatmentOutComeDTO> getSumData(List<TreatmentOutComeDTO> list) throws BizException {
		TreatmentOutComeDTO sum = new TreatmentOutComeDTO();
		int shu = 0;
		int shu1 = 0;
		int shu2 = 0;
		int shu3 = 0;
		int shu4 = 0;
		int shu5 = 0;
		int shu6 = 0;
		for (TreatmentOutComeDTO dto : list) {
			if (!StringUtil.isEmptyWithTrim(dto.getTotal()))
				shu += Integer.parseInt(dto.getTotal());
			if (!StringUtil.isEmptyWithTrim(dto.getCure()))
				shu1 += Integer.parseInt(dto.getCure());
			if (!StringUtil.isEmptyWithTrim(dto.getBecome_better()))
				shu2 += Integer.parseInt(dto.getBecome_better());
			if (!StringUtil.isEmptyWithTrim(dto.getHealed()))
				shu3 += Integer.parseInt(dto.getHealed());
			if (!StringUtil.isEmptyWithTrim(dto.getDeath()))
				shu4 += Integer.parseInt(dto.getDeath());
			if (!StringUtil.isEmptyWithTrim(dto.getOther()))
				shu5 += Integer.parseInt(dto.getOther());
			if (!StringUtil.isEmptyWithTrim(dto.getIn_hospital_day()))
				shu6 += Integer.parseInt(dto.getIn_hospital_day());
		}

		sum.setDisease("               列总计");
		sum.setTotal(String.valueOf(shu));
		sum.setCure(String.valueOf(shu1));
		sum.setBecome_better(String.valueOf(shu2));
		sum.setHealed(String.valueOf(shu3));
		sum.setDeath(String.valueOf(shu4));
		sum.setOther(String.valueOf(shu5));
		sum.setIn_hospital_day(String.valueOf(shu6));

		list.add(0, sum);
		return list;
	}
}
