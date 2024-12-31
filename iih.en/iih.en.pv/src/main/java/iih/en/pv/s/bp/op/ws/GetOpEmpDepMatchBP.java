package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.sc.sch.dto.d.OpEmpDepDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门急诊医生出诊科室列表
 * 
 * @author fanliqin
 *
 */
public class GetOpEmpDepMatchBP {
	/**
	 * 门急诊医生出诊科室列表
	 * 
	 * @return
	 */
	public OpEmpDepDTO[] exec() throws BizException {
		StringBuilder builder = new StringBuilder();
		builder.append("select distinct psn.code code_emp,");
		builder.append("psn.name name_emp,");
		builder.append("dep.code code_dep,");
		builder.append("dep.name name_dep, ");
		builder.append("psn.des doc_special ");
		builder.append("from sc_pl pl ");
		builder.append("inner join bd_dep dep on pl.id_dep = dep.id_dep ");
		builder.append("inner join sc_res res on pl.id_scres = res.id_scres ");
		builder.append("inner join bd_psndoc psn on res.id_emp = psn.id_psndoc ");
		builder.append("where pl.sd_sctp in (?, ?) ");
		builder.append("and pl.fg_active = ? ");
		SqlParam param = new SqlParam();
		param.addParam(IScDictCodeConst.SD_SCTP_OP);// 门诊
		param.addParam(IScDictCodeConst.SD_SCTP_JZ);// 急诊
		param.addParam(FBoolean.TRUE);
		builder.append("order by psn.code,dep.code, dep.name ");
		@SuppressWarnings("unchecked")
		List<OpEmpDepDTO> empdepts = (List<OpEmpDepDTO>) new DAFacade().execQuery(builder.toString(), param, new BeanListHandler(OpEmpDepDTO.class));
		if (EnValidator.isEmpty(empdepts))
			return null;
		return empdepts.toArray(new OpEmpDepDTO[0]);
	}
}
