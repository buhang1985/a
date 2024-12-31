package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.PatientsDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院医生站查询待入科患者
 * 
 * @author liubin
 *
 */
public class GetWillEnDeptPatsBP {

	/**
	 * 查询待入科患者
	 * 
	 * @param deptId
	 * 		科室ID
	 * @return
	 * 		患者DTO集合
	 * @throws BizException 
	 */
	public PatientsDTO[] exec(String deptId, String empId, String code_entp) throws BizException{
		if(EnValidator.isEmpty(deptId)){
			return null;
		}
		List<String> list = getEntIdsList(deptId, code_entp);
		if(!EnValidator.isEmpty(list)){
			return new GetIpDocStationPatsBP().exec(list, empId);
		}
		return null;
	}
	
	/**
	 * 得到待入科患者集合，包括（1.入院未入科；2.转科未入科）
	 * 
	 * @param deptId
	 * @return
	 * @throws DAException 
	 */
	public List<String> getEntIdsList(String deptId, String code_entp) throws DAException{
		List<String> willEnHosEntIds = getEnHosWillEnDepEntIds(deptId, code_entp);
		List<String> applyTranDepEntIds = getApplyTranDepEntIds(deptId, code_entp);
		return merge(willEnHosEntIds, applyTranDepEntIds);
	}
	
	/**
	 * 得到入院待入科患者就诊ID集合
	 * 
	 * @param deptId
	 * @return
	 * @throws DAException 
	 */
	public List<String> getEnHosWillEnDepEntIds(String deptId, String code_entp) throws DAException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		sb.append("WHERE IP.SD_STATUS = ? AND EN.ID_DEP_PHY = ? ");
    	SqlParam param=new SqlParam();
    	param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);
    	param.addParam(deptId);
    	if(!EnValidator.isEmpty(code_entp)){
			sb.append(" AND EN.CODE_ENTP = ?");
			param.addParam(code_entp);
		}
    	String sql = sb.toString();
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
	
	/**
	 * 得到申请转科未入科患者的就诊ID集合
	 * 
	 * @param deptId
	 * @return
	 * @throws DAException 
	 */
	public List<String> getApplyTranDepEntIds(String deptId, String code_entp) throws DAException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT DISTINCT EN.ID_ENT ");
		builder.append("FROM EN_ENT EN ");
		builder.append("INNER JOIN EN_DEP_TRANS TRANS ON EN.ID_ENT = TRANS.ID_ENT ");
		builder.append("WHERE (CASE EN.FG_IP WHEN 'Y' THEN 'Y' END) = 'Y' AND TRANS.EU_TRANS = '0' AND TRANS.ID_DEP_TO = ? ");
		SqlParam param = new SqlParam();
		param.addParam(deptId);
		if(!EnValidator.isEmpty(code_entp)){
			builder.append(" AND EN.CODE_ENTP = ?");
			param.addParam(code_entp);
		}
		String sql = builder.toString();
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
	
	/**
	 * 两个List合并
	 * 
	 * @param xList
	 * @param yList
	 * @return
	 */
	private  List<String> merge(List<String> xList, List<String> yList){
		Set<String> set = new HashSet<>();
		if(!EnValidator.isEmpty(xList)){
			set.addAll(xList);
		}
		if(!EnValidator.isEmpty(yList)){
			set.addAll(yList);
		}
		return set.size()<=0 ? null : new ArrayList<String>(set);
	}
}
