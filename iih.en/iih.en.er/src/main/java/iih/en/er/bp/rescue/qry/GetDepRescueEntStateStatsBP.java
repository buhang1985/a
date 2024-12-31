package iih.en.er.bp.rescue.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.BedQryModDTO;
import iih.en.pv.inpatient.dto.d.DepEntStateDTO;
import iih.en.pv.s.bp.ip.GetDepEntStateStatsBP;
import iih.en.utils.EnContextUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取急诊抢救科室就诊状况统计信息
 * 
 * @author liubin
 *
 */
public class GetDepRescueEntStateStatsBP {
	/**
	 * 获取急诊抢救科室就诊状况统计信息
	 * 
	 * @param qryMod
	 * @return
	 * @throws BizException
	 */
	public DepEntStateDTO[] exec(BedQryModDTO qryMod) throws BizException {
		return new GetDepEntStateStatsBP().exec(EnContextUtils.getDeptId(), getInHosEntIds(qryMod));
	}	
	
	/**
	 * 获取在院患者id_ent
	 * 
	 * @param nurId
	 * @return
	 * @throws BizException
	 */
	private String[] getInHosEntIds(BedQryModDTO qryMod) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" select ent.id_ent ");
		sqlBuilder.append(" from en_ent ent ");
		sqlBuilder.append(" inner join en_ent_op op on ent.id_ent = op.id_ent ");
		SqlParam parm = new SqlParam();
		sqlBuilder.append(" where ent.code_entp = '0102' ");
		sqlBuilder.append(" and ent.fg_canc = 'N' ");
		sqlBuilder.append(" and op.sd_status = '05' ");
		if(!EnValidator.isEmpty(qryMod.getId_dep_nur())){
			sqlBuilder.append(" and ent.Id_dep_nur  =  ? ");
			parm.addParam(qryMod.getId_dep_nur());
		}
		if(!EnValidator.isEmpty(qryMod.getId_dep_phy())){
			sqlBuilder.append(" and ent.Id_dep_phy  =  ? ");
			parm.addParam(qryMod.getId_dep_phy());
		}
		List<String> list = (List<String>) new DAFacade().execQuery(sqlBuilder.toString(), parm, new ColumnListHandler());
		return EnValidator.isEmpty(list) ? null : list.toArray(new String[0]);
	}
}
