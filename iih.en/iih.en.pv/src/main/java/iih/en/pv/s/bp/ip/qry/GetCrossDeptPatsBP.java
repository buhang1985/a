package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.PatientsDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院医生站查询跨科处置患者
 * 
 * @author Liubin
 *
 */
public class GetCrossDeptPatsBP {
	/**
	 * 查询跨科处置患者
	 * 
	 * @param deptId
	 *            科室ID
	 * @return 患者DTO集合
	 * @throws BizException
	 */
	public PatientsDTO[] exec(String deptId, String empId, String code_entp) throws BizException {
		if (EnValidator.isEmpty(deptId)) {
			return null;
		}
		List<String> list = getEntIdsList(deptId, code_entp);
		if (!EnValidator.isEmpty(list)) {
			return new GetIpDocStationPatsBP().exec(list, empId);
		}
		return null;
	}
	
	/**
	 * 得到跨科处患者的就诊ID集合
	 * 
	 * @param deptId
	 * @return
	 * @throws DAException
	 */
	public List<String> getEntIdsList(String deptId, String code_entp) throws DAException{
		FDateTime curTime = EnAppUtils.getServerDateTime();
		StringBuilder sb = new StringBuilder();
    	sb.append("SELECT DISTINCT EN.ID_ENT ");
    	sb.append("FROM EN_ENT_DEP DEP ");
    	sb.append("INNER JOIN EN_ENT EN ON DEP.ID_ENT = EN.ID_ENT ");
    	sb.append("INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
    	sb.append("WHERE DEP.SD_ENTDEPROLE = ? ");
    	sb.append("AND DEP.SD_STATUS = ? ");
    	sb.append("AND DEP.DT_B <= ? ");
    	sb.append("AND ISNULL(DEP.DT_E, ?) > ? ");
    	sb.append("AND DEP.ID_DEP = ? ");
    	sb.append("AND EN.FG_IP = ? ");
    	sb.append("AND DEP.FG_CANC = ? ");
    	SqlParam param=new SqlParam();
    	param.addParam(IEnDictCodeConst.SD_ENTDEPROLE_MT);
    	param.addParam(IEnDictCodeConst.SD_ENTDEP_STATUS_SUC);
    	param.addParam(curTime);
    	param.addParam(curTime);
    	param.addParam(curTime);
    	param.addParam(deptId);
    	param.addParam(FBoolean.TRUE);
    	param.addParam(FBoolean.FALSE);
    	if(code_entp!=null){
    		sb.append(" AND EN.CODE_ENTP = ?");
			param.addParam(code_entp);
		}
		String sql = sb.toString();
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
}
