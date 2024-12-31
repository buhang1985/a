package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.PatientsDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取关注患者
 * 
 * @author liubin
 *
 */
public class GetMarkPatsBP {
	/**
     * 获取关注患者集合
     * 
     * @param depId
     * @param empId
     * @return
     * @throws BizException
     */
	public PatientsDTO[] exec(String depId, String empId, String code_entp)
			throws BizException {
		if (EnValidator.isEmpty(depId) || EnValidator.isEmpty(empId)) {
			return null;
		}
		List<String> list = getEntIdsList(depId, empId, code_entp);
		if(!EnValidator.isEmpty(list)){
			return new GetIpDocStationPatsBP().exec(list, empId);
		}
		return null;
	}
	/**
	 * 得到关注患者的就诊ID集合
	 * 
	 * @param depId
	 * @param empId
	 * @return
	 * @throws BizException
	 */
	private List<String> getEntIdsList(String depId, String empId, String code_entp) throws BizException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT EN.ID_ENT AS ID_ENT ");
		sql.append("FROM EN_ENT EN " );
		sql.append("INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		sql.append("INNER JOIN EN_ENT_FLW FLW ON EN.ID_ENT = FLW.ID_ENT ");
		sql.append("WHERE EN.FG_IP = ? ");
		sql.append("AND EN.ID_DEP_PHY = ? ");
		sql.append("AND FLW.ID_EMP = ? ");
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.TRUE);
		param.addParam(depId);
		param.addParam(empId);
		if(code_entp != null){
			sql.append(" AND EN.CODE_ENTP = ?");
			param.addParam(code_entp);
		}
		return (List<String>) new DAFacade().execQuery(sql.toString(), param, new ColumnListHandler());
	}
}
