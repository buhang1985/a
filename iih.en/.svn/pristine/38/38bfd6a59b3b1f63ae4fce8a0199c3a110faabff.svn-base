package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.PatientsDTO;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院医生站查询转科患者
 * 
 * @author lilei
 *
 */
public class GetTransPatsBP {

	// 转出患者
	public final static String TRANSOUTPATS = "TRANSOUTPATS";
	// 转入患者
	public final static String TRANSINPATS = "TRANSINPATS";

	/**
	 * 查询转出患者
	 * 
	 * @param deptId
	 *            科室ID
	 * @param begin
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return
	 * @throws BizException
	 */
	public PatientsDTO[] transOut(String deptId, String empId, FDate begin, FDate end,String code_entp) throws BizException {
		if (EnValidator.isEmpty(deptId) || EnValidator.isEmpty(begin) || EnValidator.isEmpty(end)) {
			return null;
		}
		return getTransPats(deptId, empId, begin, end, TRANSOUTPATS, code_entp);
	}

	/**
	 * 查询转入患者
	 * 
	 * @return
	 * @throws BizException
	 */
	public PatientsDTO[] transIn(String deptId, String empId, FDate begin, FDate end, String code_entp) throws BizException {
		if (EnValidator.isEmpty(deptId) || EnValidator.isEmpty(begin) || EnValidator.isEmpty(end)) {
			return null;
		}
		return getTransPats(deptId, empId, begin, end, TRANSINPATS, code_entp);
	}

	/**
	 * 获取转科患者集合
	 * 
	 * @param deptId
	 *            科室id
	 * @param begin
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @return
	 * @throws BizException
	 */
	private PatientsDTO[] getTransPats(String deptId, String empId, FDate begin, FDate end, String type, String code_entp)
			throws BizException {
		List<PatientsDTO> transPats = getTransBysql(deptId, begin, end, type, code_entp);
		PatientsDTO[] list = assembleDTO(transPats, empId);
		return list;
	}

	/**
	 * sql语句查出转科记录
	 * 
	 * @param deptId
	 * @param begin
	 * @param end
	 * @param type
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private List<PatientsDTO> getTransBysql(String deptId, FDate begin, FDate end, String type, String code_entp) throws DAException {
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT  EN.ID_ENT AS ID_ENT, ");
		builder.append(" DEPF.ID_DEP AS ID_DEP_FROM, ");// 原科室
		builder.append(" DEPF.NAME AS NAME_DEP_FROM, ");
		builder.append(" NURF.ID_DEP AS ID_DEP_NUR_FROM, ");// 原病区
		builder.append(" NURF.NAME AS NAME_DEP_NUR_FROM, ");
		builder.append(" DEPT.ID_DEP AS ID_DEP_TO, ");// 目标科室
		builder.append(" DEPT.NAME AS NAME_DEP_TO, ");
		builder.append(" NURT.ID_DEP AS ID_DEP_NUR_TO, ");// 目标病区
		builder.append(" NURT.NAME AS NAME_DEP_NUR_TO, ");
		builder.append(" TRANS.DT_ACPT AS DT_B ");// 转科时间
		builder.append(" FROM EN_ENT EN  ");
		builder.append(" INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT  ");
		builder.append(" INNER JOIN EN_DEP_TRANS TRANS ON EN.ID_ENT = TRANS.ID_ENT  ");
		builder.append(" LEFT JOIN BD_DEP DEPF ON DEPF.ID_DEP = TRANS.ID_DEP_FROM ");
		builder.append(" LEFT JOIN BD_DEP NURF ON NURF.ID_DEP = TRANS.ID_DEP_NUR_FROM ");
		builder.append(" LEFT JOIN BD_DEP DEPT ON DEPT.ID_DEP = TRANS.ID_DEP_TO ");
		builder.append(" LEFT JOIN BD_DEP NURT ON NURT.ID_DEP = TRANS.ID_DEP_NUR_TO ");
		builder.append("WHERE TRANS.EU_TRANS = '1' ");
		if (TRANSOUTPATS.equals(type)) {
			builder.append("AND TRANS.ID_DEP_FROM = ? ");
		} else if (TRANSINPATS.equals(type)) {
			builder.append("AND TRANS.ID_DEP_TO = ? ");
		}
		builder.append("AND TRANS.DT_ACPT >= ? ");
		builder.append("AND TRANS.DT_ACPT <= ? ");
		if (!EnParamUtils.getKeyEnIpOut()) {
			builder.append("AND EN.FG_DATA_TRANSF = 'N' ");
		}
		SqlParam param = new SqlParam();
		param.addParam(deptId);
		param.addParam(begin);
		Calendar cal = Calendar.getInstance();
		cal.setTime(end.toDate());
		cal.add(Calendar.DATE, 1);// 加1天
		param.addParam(new FDate(cal.getTime()));
		if(code_entp!=null){
			builder.append(" AND EN.CODE_ENTP = ?");
			param.addParam(code_entp);
		}
		builder.append(" ORDER BY EN.ID_DEP_NUR, ip.name_bed, IP.Code_Amr_Ip, TRANS.DT_ACPT ");
		String sql = builder.toString();
		return (List<PatientsDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(PatientsDTO.class));
	}

	/**
	 * 组装其他字段
	 * 
	 * @throws BizException
	 */
	private PatientsDTO[] assembleDTO(List<PatientsDTO> list, String empId) throws BizException {
		if (EnValidator.isEmpty(list)) {
			return null;
		}
		PatientsDTO[] transList = EnValidator.isEmpty(list) ? null : list.toArray(new PatientsDTO[0]);
		Set<String> setList = new HashSet<String>();
		for (PatientsDTO dto : transList) {
			setList.add(dto.getId_ent());
		}
		String[] arrayList = setList.toArray(new String[0]);
		if(EnValidator.isEmpty(arrayList)){
			return transList;
		}
		// 根据id_ent查公共字段
		PatientsDTO[] patsList = new GetIpDocStationPatsBP(true).exec(arrayList, empId);
		if(EnValidator.isEmpty(patsList)){
			return transList;
		}
		// 和已查出的dto拼接
		Map<String, PatientsDTO> patsMap = EnFMapUtils.getMap("Id_ent", patsList);
		for (int i = 0; i < transList.length; i++) {
			if(transList[i] == null || !patsMap.containsKey(transList[i].getId_ent())) continue;
			PatientsDTO patsDTO = (PatientsDTO) patsMap.get(transList[i].getId_ent()).clone();
			patsDTO.setId_dep_to(transList[i].getId_dep_to());
			patsDTO.setName_dep_to(transList[i].getName_dep_to());
			patsDTO.setId_dep_nur_to(transList[i].getId_dep_nur_to());
			patsDTO.setName_dep_nur_to(transList[i].getName_dep_nur_to());
			patsDTO.setId_dep_from(transList[i].getId_dep_from());
			patsDTO.setName_dep_from(transList[i].getName_dep_from());
			patsDTO.setId_dep_nur_from(transList[i].getId_dep_nur_from());
			patsDTO.setName_dep_nur_from(transList[i].getName_dep_nur_from());
			patsDTO.setDt_b(transList[i].getDt_b());
			transList[i] = patsDTO;
		}
		return transList;
	}
}
