package iih.en.pv.s.bp.op;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 门诊预约取号-换患者，患者列表查询
 * 
 * @author fanlq 2017年11月1日 上午9:56:06
 *
 */
public class ChangePatQry4ApptBP {

	public OpRegPatDTO[] exec(String patId, FBoolean isSwingHpCad) throws BizException {

		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();

		sqlBuilder.append("select pat.id_pat,pat.code as Code_pat,pat.name as Name_pat,pat.dt_birth,pat.mob,");
		sqlBuilder.append("pat.id_sex,pat.sd_sex,ud.name as Name_sex,pat.id_idtp,");
		sqlBuilder.append("pat.sd_idtp,pat.id_code as Id,bd.name as Name_idtp ");
		sqlBuilder.append("from pi_pat pat ");
		sqlBuilder.append("left join bd_udidoc ud on ud.id_udidoc = pat.id_sex ");
		sqlBuilder.append("left join bd_udidoc bd on bd.id_udidoc = pat.id_idtp ");
		sqlBuilder.append("where pat.id_pat = ? ");
		param.addParam(patId);
		// 3.查询就诊信息
		List<OpRegPatDTO> list = (List<OpRegPatDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(OpRegPatDTO.class));
		if (!EnValidator.isEmpty(list)) {
			
			return list.toArray(new OpRegPatDTO[0]);
		}
		return null;
	}

}
