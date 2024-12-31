package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.PatientsDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院医生站——查询我的患者
 * @author liubin
 */
public class GetChargedPatsBP {

	/**
	 * 查询我的患者
	 * 
	 * @param depId
	 * 		科室ID
	 * @param empId 
	 * 		医生ID
	 * @return 
	 * 		患者DTO集合
	 * @throws BizException 
	 */
	public PatientsDTO[] exec(String depId, String empId, String code_entp) throws BizException{
		if(EnValidator.isEmpty(depId)||EnValidator.isEmpty(empId)){
			return null;
		}
		List<String> list = getEntIdsList(depId, empId, code_entp);
		if(!EnValidator.isEmpty(list)){
			return new GetIpDocStationPatsBP().exec(list, empId);
		}
		return null;

	}
	
	/**
	 * 得到我的患者的就诊ID集合
	 * 
	 * @param depId
	 * @param empId
	 * @return
	 * @throws DAException 
	 */
	public List<String> getEntIdsList(String depId, String empId, String code_entp) throws DAException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		sb.append("WHERE (CASE EN.FG_IP WHEN 'Y' THEN 'Y' END) = 'Y' AND EN.ID_EMP_PHY = ? AND EN.ID_DEP_PHY = ? ");
		SqlParam param=new SqlParam();
		param.addParam(empId);
		param.addParam(depId);
		if(code_entp != null){
			sb.append(" AND EN.CODE_ENTP = ?");
			param.addParam(code_entp);
		}
		String sql = sb.toString();
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	} 
}
