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
 * 住院医生站查询医疗组患者
 * 
 * @author liubin
 *
 */
public class GetWgPatsBP {

	/**
	 * 查询医疗组患者
	 * 
	 * @param deptId
	 * 		科室ID
	 * @param empId
	 * 		医生ID
	 * @return
	 * 		患者DTO集合
	 * @throws BizException 
	 */
	public PatientsDTO[] exec(String deptId,String empId, String code_entp) throws BizException{
		if(EnValidator.isEmpty(deptId)||EnValidator.isEmpty(empId)){
			return null;
		}
		List<String> list = getEntIdsList(deptId, empId, code_entp);
		if(!EnValidator.isEmpty(list)){
			return new GetIpDocStationPatsBP().exec(list, empId);
		}
		return null;
	}
	
	/**
	 * 得到本科室本医生的医疗组患者的就诊ID集合
	 * 
	 * @param deptId
	 * @param empId
	 * @return
	 * @throws DAException
	 */
	public List<String> getEntIdsList(String deptId,String empId, String code_entp) throws DAException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		sb.append("INNER JOIN BD_EMP_WG WG ON EN.ID_WG_PHY = WG.ID_WG ");
		sb.append("WHERE WG.ID_EMP = ? ");
		sb.append("AND EN.ID_DEP_PHY = ? ");
		sb.append("AND (CASE EN.FG_IP WHEN 'Y' THEN 'Y' END) = 'Y' ");
		//sb.append("AND WG.FG_ACTIVE = 'Y' ");TODO:表中没有此字段，加上再说
		SqlParam param=new SqlParam();
		param.addParam(empId);
		param.addParam(deptId);
		if(code_entp != null){
			sb.append(" AND EN.CODE_ENTP = ?");
			param.addParam(code_entp);
		}
		String sql=sb.toString();
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
}
