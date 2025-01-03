package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.PatientsDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院医生站查询待出院患者
 * 
 * @author liubin
 *
 */
public class GetWillLvHosPatsBP {
	private static final String EXTRA_CONDITION = "EN.FG_IP = 'Y'";
	/**
	 * 查询待出院患者
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
			return new GetIpDocStationPatsBP().exec(list, empId, EXTRA_CONDITION);
		}
		return null;
	}
	
	/**
	 * 得到待出院患者的就诊ID集合
	 * 
	 * @param deptId
	 * @return
	 * @throws DAException 
	 */
	public List<String> getEntIdsList(String deptId, String code_entp) throws BizException{
		List<String> mList = this.getMomList(deptId, code_entp);
		if(EnValidator.isEmpty(mList))
			return null;
		List<String> bList = this.getBbList(mList);
		if(!EnValidator.isEmpty(bList))
			for(String idEnt :mList){
				if(bList.contains(idEnt)){
					bList.remove(idEnt);
				}
			}
			mList.addAll(bList);
			
		return mList;
	}
	/**
	 * 获取出院患者集合
	 * 
	 * @param deptId
	 * @return
	 * @throws DAException
	 */
	private List<String> getMomList(String deptId, String code_entp) throws DAException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT DISTINCT COR.ID_EN ");
		builder.append("FROM CI_AP_OUT AP ");
		builder.append("INNER JOIN CI_ORDER COR ON AP.ID_OR = COR.ID_OR AND COR.SD_SU_OR IN (?,?,?)  ");
		builder.append("INNER JOIN EN_ENT EN ON COR.ID_EN = EN.ID_ENT AND EN.ID_DEP_PHY = ? AND EN.FG_IP = 'Y' ");
		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		param.addParam(ICiDictCodeConst.SD_SU_CHECKSTOP);
		param.addParam(ICiDictCodeConst.SD_SU_FINISH);
		param.addParam(deptId);
		if(code_entp!=null){
			builder.append(" AND EN.CODE_ENTP = ?");
			param.addParam(code_entp);
		}
		String sql = builder.toString();
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
	/**
	 * 获取出院患者baby集合
	 * 
	 * @param mList
	 * @return
	 * @throws DAException 
	 */
	private List<String> getBbList(List<String> mList) throws DAException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT DISTINCT EN.ID_ENT FROM EN_ENT EN ");
		builder.append("INNER JOIN EN_ENT_NB NB ON EN.ID_ENT = NB.ID_ENT_BB ");
		builder.append("WHERE EN.FG_IP = ? ");
		builder.append("AND NB.FG_SEPA != 'Y' ");
		builder.append("AND ");
		builder.append(EnSqlUtils.getInSqlByIds(" NB.ID_ENT_MOM ", mList));
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.TRUE);
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
}
