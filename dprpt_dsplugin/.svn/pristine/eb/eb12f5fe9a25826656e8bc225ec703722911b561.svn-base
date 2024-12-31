package iih.ci.rcm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

public class CideathPtintService {
	public List<CideathPrintDTO> getCideathData(String cideathid)
			throws Exception {
		if (StringUtil.isEmptyWithTrim(cideathid)) {
			return null;
		}
		List<CideathPrintDTO> list = this.queryCideathData(cideathid);
		/*// 处理参照数据
		Map<String, LinkedHashMap<String, String>> map = new HashMap<String, LinkedHashMap<String, String>>();
		if (this.setUdidocParam() == null) {
			throw new BizException("没有查询到参照数据");
		} else {
			map = UdidocReferDataUtil.queryUdidoc(this.setUdidocParam());
		}

		for (CideathPrintDTO deathdto : list) {
			if (!map.isEmpty()) {

				// 处理<性别>参照--平铺
				String sexPk = ConstantsOfCideath.SEX;
				String udisexPk = deathdto.getSex_pat();
				if (!StringUtil.isEmptyWithTrim(sexPk)
						&& !StringUtil.isEmptyWithTrim(udisexPk)) {
					String str = this.handleData(sexPk, udisexPk, map);
					deathdto.setSex_pat(str);
				} else {
					throw new BizException("性别参照数据有误。");
				}

				// 处理<身份证件类型>参照--平铺
				String cardTypePk = ConstantsOfCideath.CARDTYPE;
				String udicardTypePk = deathdto.getIdcard_type();
				if (!StringUtil.isEmptyWithTrim(cardTypePk)
						&& !StringUtil.isEmptyWithTrim(udicardTypePk)) {
					String str = this
							.handleData(cardTypePk, udicardTypePk, map);
					deathdto.setIdcard_type(str);
				} else {
					throw new BizException("身份证件类型参照数据有误。");
				}

				// 处理<婚姻状况>参照--平铺
				String marryPk = ConstantsOfCideath.MARRIIAGESTATUS;
				String udiMarryPk = deathdto.getMarry_status();
				if (!StringUtil.isEmptyWithTrim(marryPk)
						&& !StringUtil.isEmptyWithTrim(udiMarryPk)) {
					String str = this.handleData(marryPk, udiMarryPk, map);
					deathdto.setMarry_status(str);
				} else {
					throw new BizException("婚姻状况参照数据有误。");
				}

				// 处理<文化程度>参照--平铺
				String degreePk = ConstantsOfCideath.CULTURELEVEL;
				String udiDegreePk = deathdto.getDegree_pat();
				if (!StringUtil.isEmptyWithTrim(degreePk)
						&& !StringUtil.isEmptyWithTrim(udiDegreePk)) {
					String str = this.handleData(degreePk, udiDegreePk, map);
					deathdto.setDegree_pat(str);
				} else {
					throw new BizException("文化程度参照数据有误。");
				}

				// 处理<个人身份>参照--平铺
				String identityPk = ConstantsOfCideath.PRESONTYPE;
				String udiIdentityPk = deathdto.getJob_pat();
				String identity = this.handleData(identityPk, udiIdentityPk,
						map);
				deathdto.setJob_pat(identity);

				// 处理<死亡地点>参照--平铺
				String deathsitePk = ConstantsOfCideath.DEATHSITE;
				String udiDeathsitePk = deathdto.getDeath_site();
				if (!StringUtil.isEmptyWithTrim(deathsitePk)
						&& !StringUtil.isEmptyWithTrim(udiDeathsitePk)) {
					String str = this.handleData(deathsitePk, udiDeathsitePk,
							map);
					deathdto.setDeath_site(str);
				} else {
					throw new BizException("死亡地点参照数据有误。");
				}

				// 处理<是否处于妊娠期>
				String isPregnant = deathdto.getIs_pregnant();
				if (!StringUtil.isEmptyWithTrim(isPregnant)) {
					if (isPregnant.equals("Y")) {
						isPregnant = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
						deathdto.setIs_pregnant(isPregnant);
					}
					if (isPregnant.equals("N")) {
						isPregnant = "{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}";
						deathdto.setIs_pregnant(isPregnant);
					}
				}

				// 处理<最高诊断单位>参照--平铺
				String highestUnitPk = ConstantsOfCideath.MOSTHIGHTSITE;
				String udiHighestUnitPk = deathdto.getDiag_hospital();
				if (!StringUtil.isEmptyWithTrim(highestUnitPk)
						&& !StringUtil.isEmptyWithTrim(udiHighestUnitPk)) {
					String str = this.handleData(highestUnitPk,
							udiHighestUnitPk, map);
					deathdto.setDiag_hospital(str);
				} else {
					throw new BizException("最高诊断单位参照数据有误。");
				}

				// 处理<最高诊断依据>参照--平铺
				String highestAcordPk = ConstantsOfCideath.MOSTHIGHT;
				String udiHighestAcordPk = deathdto.getDiag_basis();
				if (!StringUtil.isEmptyWithTrim(highestAcordPk)
						&& !StringUtil.isEmptyWithTrim(udiHighestAcordPk)) {
					String str = this.handleData(highestAcordPk,
							udiHighestAcordPk, map);
					deathdto.setDiag_basis(str);
				} else {
					throw new BizException("最高诊断依据参照数据有误。");
				}
			} else {
				throw new BizException("没有查询到参照数据");
			}

		}
*/
		return list;
	}

	/**
	 * 查询死亡证明书数据
	 * 
	 * @return
	 * @author tang.ws
	 * @throws Exception
	 */

	private List<CideathPrintDTO> queryCideathData(String cideathid)
			throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
        sql.append("cid.healthnumber as healthnumber,");
		sql.append("cid.address_pat_code as province,");
		sql.append("cid.address_pat_street as street,");
		sql.append("cid.address_code as address_code,");
		sql.append("cid.address_no as address_no,");

		sql.append("cid.name_pat as name_pat,");
		sql.append("cid.id_sex as sex_pat,");// 性别
		sql.append("cid.sex_pat as sex,");
		sql.append("cid.nation_pat as nation_pat,");
		sql.append("cid.country_pat as country_pat,");

		sql.append("cid.id_cardtype as idcard_type,");// 证件类型
		sql.append("cid.idcard_type as cardtype,");
		sql.append("cid.idcard_no as idcard_no,");
		sql.append("cid.age_pat as age_pat,");
		sql.append("cid.marry_status as marry_status,");// 婚姻状况	marry_status   id_marry

		sql.append("cid.birth_pat as birth_pat,");
		sql.append("cid.degree_pat as degree_pat,");// 文化程度		degree_pat		id_degree
		sql.append("cid.job_pat as job_pat,");// 个人身份		job_pat		id_job

		sql.append("cid.death_time as death_time,");
		sql.append("cid.death_site as death_site,");// 死亡地点
		sql.append("cid.death_site_name as deathplace,");
		sql.append("case cid.is_pregnant when 'Y' then '是' else '否' end as is_pregnant,");

		sql.append("cid.work_company as work_company,");
		sql.append("cid.birth_place as birth_place,");
		sql.append("cid.address_usual as address_usual,");
		sql.append("cid.birth_place_name as birth_place_fullname,");//户籍地址
		sql.append("cid.address_usual_name as address_usual_fullname,");//常住地址

		sql.append("cid.relation_name as relation_name,");
		sql.append("cid.relation_phone as relation_phone,");
		sql.append("cid.relation_address as relation_address,");

		sql.append("cid.death_a_diag as death_a_diag,");
		sql.append("cid.death_a_timespan as death_a_timespan,");
		sql.append("cid.death_b_diag as death_b_diag,");
		sql.append("cid.death_b_timespan as death_b_timespan,");
		sql.append("cid.death_c_diag as death_c_diag,");
		sql.append("cid.death_c_timespan as death_c_timespan,");
		sql.append("cid.death_d_diag as death_d_diag,");
		sql.append("cid.death_d_timespan as death_d_timespan,");

		sql.append("cid.death_other_diag as death_other_diag,");

		sql.append("cid.diag_basis_name as diag_basis,");// 最高诊断依据		diag_basis_name		diag_basis
		sql.append("bd_udidoc.name as diag_hospital,");// 最高诊断单位		diag_hospital_name		diag_hospital

		sql.append("cid.sign_doctor as sign_doctor,");
		sql.append("cid.inhos_no as inhos_no,");
		sql.append("cid.createdtime as createdtime,");

		sql.append("cid.death_reason as death_reason,");// 根本死亡原因
		sql.append("cid.diag_icdcode as diag_icdname,");

		sql.append("cid.symptom_sign as symptom_sign,");

		sql.append("cid.investigate_name as investigate_name,");
		sql.append("cid.investigate_relation as investigate_relation,");
		sql.append("cid.investigate_phone as investigate_phone,");
		sql.append("cid.investigate_address as investigate_address,");

		sql.append("cid.death_infer as death_infer,");
		sql.append("cid.investigate_date as investigate_date ");
		sql.append("from ci_mr_death_cert cid ");
		sql.append("left join bd_udidoc bd_udidoc ");
		sql.append("on cid.diag_hospital = bd_udidoc.id_udidoc ");
		sql.append("where cid.id_death_cert = '" + cideathid + "'");
		return this.getResultBySql(sql.toString());

	}

	/**
	 * 设置自定义档案参照常量参数
	 * 
	 * @return
	 * @author tang.ws
	 */
	private String[] setUdidocParam() {
		List<String> paramList = new ArrayList<String>();
		paramList.add(ConstantsOfCideath.SEX);
		paramList.add(ConstantsOfCideath.CARDTYPE);
		paramList.add(ConstantsOfCideath.CULTURELEVEL);
		paramList.add(ConstantsOfCideath.MARRIIAGESTATUS);
		paramList.add(ConstantsOfCideath.PRESONTYPE);
		paramList.add(ConstantsOfCideath.DEATHSITE);
		paramList.add(ConstantsOfCideath.MOSTHIGHT);
		paramList.add(ConstantsOfCideath.MOSTHIGHTSITE);
		String[] paramArr = paramList.toArray(new String[0]);
		return paramArr;
	}

	/**
	 * 执行主卡查询sql方法
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 * @author tang.ws
	 */
	@SuppressWarnings("unchecked")
	private List<CideathPrintDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(CideathPrintDTO.class);
		List<CideathPrintDTO> result = (List<CideathPrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	private String handleData(String refPk, String udiPk,
			Map<String, LinkedHashMap<String, String>> map) {

		LinkedHashMap<String, String> refMap = map.get(refPk);

		StringBuilder refjson = new StringBuilder();
		if (refMap == null) {
			return "数据有误";
		} else {
			refjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> refentries = refMap.entrySet().iterator();
			while (refentries.hasNext()) {
				Map.Entry<String, String> entry = refentries.next();
				String json = "{text:'" + entry.getValue() + "'";
				if (udiPk!=null && udiPk.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				refjson.append(json);
			}
			String refStr = refjson.toString().substring(0,refjson.length() - 1);
			StringBuilder refFormStr = new StringBuilder();
			refFormStr.append(refStr);
			refFormStr.append("]}");
			return refFormStr.toString();
		}
	}
}
