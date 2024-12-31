package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.inpatient.dto.d.PatientsDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院医生站查询已出院患者
 * 
 * @author liubin
 */
public class GetLvHosPatsBP {
	/**
	 * 查询已出院患者
	 * 
	 * @param deptId
	 * 		科室ID
	 * @return
	 * 		患者DTO集合
	 * @throws BizException 
	 */
	public PatientsDTO[] exec(String deptId, String empId, EntQryModDTO entQryMod) throws BizException{
		if(EnValidator.isEmpty(deptId)){
			return null;
		}
		List<String> list = getEntIdsList(deptId, entQryMod);
		if(!EnValidator.isEmpty(list)){
			return new GetIpDocStationPatsBP(true).exec(list, empId);
		}
		return null;
	}
	
	/**
	 * 得到出院患者的就诊ID集合
	 * 
	 * @param deptId
	 * @return
	 * @throws DAException
	 */
	public List<String> getEntIdsList(String deptId, EntQryModDTO entQryMod) throws DAException{
		SqlParam param=new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		sb.append("WHERE IP.SD_STATUS = ? ");
		sb.append("AND EN.ID_DEP_PHY = ? ");
		sb.append("AND EN.FG_CANC = ? ");
		if(!EnParamUtils.getKeyEnIpOut()){
			sb.append("AND EN.FG_DATA_TRANSF = 'N' ");
		}
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);
		param.addParam(deptId);
		param.addParam(FBoolean.FALSE);
		if(entQryMod!=null){
			if(entQryMod.getDt_b()!=null){
				sb.append("AND EN.DT_END >= ? ");
				param.addParam(entQryMod.getDt_b());
			}
			if(entQryMod.getDt_e()!=null){
				sb.append("AND EN.DT_END <= ? ");
				param.addParam(entQryMod.getDt_e()+" 23:59:59");
			}
			if(!EnValidator.isEmpty(entQryMod.getId_emp())){
				sb.append("AND EN.ID_EMP_PHY = ? ");
				param.addParam(entQryMod.getId_emp());
			}
		}
		if(!EnValidator.isEmpty(entQryMod.getId_nur())){
			sb.append(" AND EN.ID_DEP_NUR = ? ");
			param.addParam(entQryMod.getId_nur());
		}
		if(!EnValidator.isEmpty(entQryMod.getCode_entp())){
			sb.append(" AND EN.CODE_ENTP = ? ");
			param.addParam(entQryMod.getCode_entp());
		}
		sb.append(" ORDER BY NAME_BED ");
		String sql = sb.toString();
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
}
