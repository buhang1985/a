package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.PatientsDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院医生站查询科室患者
 * 
 * @author liubin
 */
public class GetDeptPatsBP {

	/**
	 * 查询科室患者
	 * 
	 * @param deptId 
	 * 		科室ID
	 * @return
	 * 		患者DTO集合
	 * @throws BizException 
	 */
	public PatientsDTO[] getDepPats(String deptId, String empId, String code_entp) throws BizException{
		if(EnValidator.isEmpty(deptId)){
			return null;
		}
		//得到本科室的患者就诊ID集合
		List<String> deptEntIdsList = getEntIdsList(deptId, null, code_entp);
		if(!EnValidator.isEmpty(deptEntIdsList)){
			return new GetIpDocStationPatsBP().exec(deptEntIdsList, empId);
		}
		return null;
	}
	/**
	 * 查询科室患者
	 * 
	 * @param deptId 
	 * 		科室ID
	 * @param nurId
	 * 		病区ID，可以为空
	 * @return
	 * 		患者DTO集合
	 * @throws BizException 
	 */
	public PatientsDTO[] getNurPats(String deptId, String nurId, String empId, String code_entp) throws BizException{
		if(EnValidator.isEmpty(nurId)){
			return null;
		}
		if(!EnValidator.isEmpty(deptId)){
			if(EnParamUtils.isShareDep(deptId))
				deptId = null;
		}
		//得到本科室的患者就诊ID集合
		List<String> deptEntIdsList = getEntIdsList(deptId, nurId, code_entp);
		if(!EnValidator.isEmpty(deptEntIdsList)){
			if(!EnValidator.isEmpty(deptEntIdsList)){
				return new GetIpDocStationPatsBP().exec(deptEntIdsList, empId);
			}
		}
		return null;
	}
	
	/**
	 * 得到科室患者的就诊ID集合
	 * 
	 * @param deptId
	 * @param nurId
	 * @return
	 * @throws DAException 
	 */
	public List<String> getEntIdsList(String deptId,String nurId, String code_entp) throws DAException{
		SqlParam param=new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		sb.append("WHERE (CASE EN.FG_IP WHEN 'Y' THEN 'Y' END) = 'Y' AND EN.ID_DEP_PHY = ? ");
		param.addParam(deptId);
		if(!EnValidator.isEmpty(nurId)){
			sb.append("AND EN.ID_DEP_NUR = ? ");
			param.addParam(nurId);
		}
		if(!EnValidator.isEmpty(code_entp)){
			sb.append(" AND EN.CODE_ENTP = ?");
			param.addParam(code_entp);
		}
		String sql = sb.toString();
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
}
