package iih.mr.mrm;

import java.util.List;
import iih.mr.mrconst.IMrParamConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院疾病性别及年龄构成
 */
public class SexAndAgeFromDiagService {

	/**
	 * 查询方法
	 * 
	 * @param begindate
	 * @param enddate
	 * @return
	 * @throws BizException
	 */
	public List<SexAndAgeFromDiagDTO> getReportList(String date, String date_1, String sexname) throws BizException {
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
		if (!StringUtil.isEmptyWithTrim(sexname)) {
			if (IMrParamConst.PARAM_NAME_MALE.equals(sexname))
				sql.append(" and ee.sd_sex_pat='1' ");
			if (IMrParamConst.PARAM_NAME_FEMALE.equals(sexname))
				sql.append(" and ee.sd_sex_pat='2' ");
		}
		@SuppressWarnings("unchecked")
		List<SexAndAgeFromDiagDTO> list = (List<SexAndAgeFromDiagDTO>) daf.execQuery(sql.toString(), sq,
				new BeanListHandler(SexAndAgeFromDiagDTO.class));
		if (list != null && list.size() > 0) {
			list = getDiseaseData(list, date, date_1, sexname);
			list = getSumData(list);
		}
		return list;
	}

	/**
	 * 获取其他数据
	 * 
	 * @param list
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public List<SexAndAgeFromDiagDTO> getDiseaseData(List<SexAndAgeFromDiagDTO> list, String date, String date_1,
			String sexname) throws BizException {
		DAFacade dafa = new DAFacade();
		List<SexAndAgeFromDiagDTO> data = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select count(ee.id_ent) as total, ");
		sql.append("count(case when pat.age_month is not null then 1   ");
		sql.append(
				"           when instr(pat.age, '岁') > 0 and 1<=to_number(Replace(pat.age,'岁','')) and to_number(Replace(pat.age,'岁',''))<5 then 1 else null end) as shu1,  ");
		sql.append(
				"count(case when instr(pat.age, '岁') > 0 and 5<=to_number(Replace(pat.age,'岁',''))  and to_number(Replace(pat.age,'岁',''))<15 then 1 else null end) as shu2,  ");
		sql.append(
				"count(case when instr(pat.age, '岁') > 0 and 15<=to_number(Replace(pat.age,'岁','')) and to_number(Replace(pat.age,'岁',''))<45 then 1 else null end) as shu3,  ");
		sql.append(
				"count(case when instr(pat.age, '岁') > 0 and 45<=to_number(Replace(pat.age,'岁','')) and to_number(Replace(pat.age,'岁',''))<60 then 1 else null end) as shu4,  ");
		sql.append(
				"count(case when instr(pat.age, '岁') > 0 and 60<=to_number(Replace(pat.age,'岁','')) then 1 else null end) as shu5  ");
		sql.append("from en_ent ee   ");
		sql.append("left join CI_MR_FP_PAT pat on pat.id_ent=ee.id_ent  ");
		sql.append("left join ci_mr_fp_di di on di.id_ent=ee.id_ent  ");
		sql.append("left join CI_MR_FP_XYDI xy on xy.id_mrfpdi=di.id_mrfpdi   ");
		sql.append("where ee.code_entp='10' and ee.fg_ip='N' and xy.fg_maindi='Y'  ");
		SqlParam sq = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(date)) {
			sql.append(" and ee.dt_end>=? ");
			sq.addParam(date);
		}
		if (!StringUtil.isEmptyWithTrim(date_1)) {
			sql.append(" and ee.dt_end<=? ");
			sq.addParam(date_1);
		}
		if (!StringUtil.isEmptyWithTrim(sexname)) {
			if (IMrParamConst.PARAM_NAME_MALE.equals(sexname))
				sql.append(" and ee.sd_sex_pat='1' ");
			if (IMrParamConst.PARAM_NAME_FEMALE.equals(sexname))
				sql.append(" and ee.sd_sex_pat='2' ");
		}
		String sqlStr = sql.toString();
		String str = null;
		for (SexAndAgeFromDiagDTO dto : list) {
			dto.setTotal("0");
			dto.setShu1("0");
			dto.setShu2("0");
			dto.setShu3("0");
			dto.setShu4("0");
			dto.setShu5("0");

			if (!StringUtil.isEmptyWithTrim(dto.getId_di())) {
				String diStr = "  and  xy.id_di='" + dto.getId_di() + "' ";
				str = sqlStr + diStr;
				data = (List<SexAndAgeFromDiagDTO>) dafa.execQuery(str, sq,
						new BeanListHandler(SexAndAgeFromDiagDTO.class));
				if (data != null && data.size() > 0) {
					if (!StringUtil.isEmptyWithTrim(data.get(0).getTotal()))
						dto.setTotal(data.get(0).getTotal());
					if (!StringUtil.isEmptyWithTrim(data.get(0).getShu1()))
						dto.setShu1(data.get(0).getShu1());
					if (!StringUtil.isEmptyWithTrim(data.get(0).getShu2()))
						dto.setShu2(data.get(0).getShu2());
					if (!StringUtil.isEmptyWithTrim(data.get(0).getShu3()))
						dto.setShu3(data.get(0).getShu3());
					if (!StringUtil.isEmptyWithTrim(data.get(0).getShu4()))
						dto.setShu4(data.get(0).getShu4());
					if (!StringUtil.isEmptyWithTrim(data.get(0).getShu5()))
						dto.setShu5(data.get(0).getShu5());

				}
			}
			str = null;
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
	public List<SexAndAgeFromDiagDTO> getSumData(List<SexAndAgeFromDiagDTO> list) throws BizException {
		SexAndAgeFromDiagDTO sum = new SexAndAgeFromDiagDTO();
		int shu = 0;
		int shu1 = 0;
		int shu2 = 0;
		int shu3 = 0;
		int shu4 = 0;
		int shu5 = 0;

		for (SexAndAgeFromDiagDTO dto : list) {
			if (!StringUtil.isEmptyWithTrim(dto.getTotal()))
				shu += Integer.parseInt(dto.getTotal());
			if (!StringUtil.isEmptyWithTrim(dto.getShu1()))
				shu1 += Integer.parseInt(dto.getShu1());
			if (!StringUtil.isEmptyWithTrim(dto.getShu2()))
				shu2 += Integer.parseInt(dto.getShu2());
			if (!StringUtil.isEmptyWithTrim(dto.getShu3()))
				shu3 += Integer.parseInt(dto.getShu3());
			if (!StringUtil.isEmptyWithTrim(dto.getShu4()))
				shu4 += Integer.parseInt(dto.getShu4());
			if (!StringUtil.isEmptyWithTrim(dto.getShu5()))
				shu5 += Integer.parseInt(dto.getShu5());
		}

		sum.setDisease("                      列总计");
		sum.setTotal(String.valueOf(shu));
		sum.setShu1(String.valueOf(shu1));
		sum.setShu2(String.valueOf(shu2));
		sum.setShu3(String.valueOf(shu3));
		sum.setShu4(String.valueOf(shu4));
		sum.setShu5(String.valueOf(shu5));

		list.add(0, sum);
		return list;
	}
}
