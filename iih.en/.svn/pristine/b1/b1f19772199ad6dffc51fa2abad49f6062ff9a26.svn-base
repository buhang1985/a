package iih.en.pv.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.sc.sch.dto.d.DeptWithSchDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author fanliqin
 *
 */
public class GetOEPDepListBP {
	/**
	 * 门急诊出诊科室列表
	 * 
	 * @return
	 */
	public DeptWithSchDTO[] exec() throws BizException {

		StringBuilder builder = new StringBuilder();
		builder.append("select distinct dep.code code_dep, ");
		builder.append("dep.name name_dep ");
		builder.append("from sc_pl pl ");
		builder.append("inner join bd_dep dep on pl.id_dep = dep.id_dep ");
		builder.append("where pl.sd_sctp in (?, ?) ");
		builder.append("and pl.fg_active = ? ");
		SqlParam param = new SqlParam();
		param.addParam(IScDictCodeConst.SD_SCTP_OP);// 门诊
		param.addParam(IScDictCodeConst.SD_SCTP_JZ);// 急诊
		param.addParam(FBoolean.TRUE);
		builder.append("order by dep.code, dep.name ");
		List<DeptWithSchDTO> depts = (List<DeptWithSchDTO>) new DAFacade().execQuery(builder.toString(), param, new BeanListHandler(DeptWithSchDTO.class));
		if (EnValidator.isEmpty(depts))
			return null;
		return depts.toArray(new DeptWithSchDTO[0]);
	}
}
