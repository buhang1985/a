package iih.sc.apt.s.bp;

import java.util.List;

import iih.sc.apt.aptoptemp.d.ScAptOptEmpDO;
import iih.sc.apt.aptoptemp.i.IAptoptempRService;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.out.ci.d.ScAptOptEmpDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOptAptOperBP {
	public  ScAptOptEmpDO[] exec(MtAppDTO appDTO) throws BizException {

		StringBuilder sql = new StringBuilder();
		SqlParam param = new SqlParam();
		
		sql.append(" select  id_aptoptemp ,");
		sql.append(" id_aptappl ,");
		sql.append(" a.id_udidoc as id_role,");
		sql.append(" a.code as sd_role,");
		sql.append(" a.name as name_role,");
		sql.append(" id_emp ,");
		sql.append(" doc.code as code_emp,");
		sql.append(" doc.name as name_emp");
		sql.append(" from bd_udidoc a");
		sql.append(" inner join bd_udidoclist t");
		sql.append(" on a.id_udidoclist = t.id_udidoclist");
		sql.append(" and t.code = 'CI.OR.0635'");
		sql.append(" left join SC_APT_OPT_EMP emp");
		sql.append(" on emp.id_role = a.id_udidoc");
		sql.append(" and emp.id_aptappl = ?");
		sql.append(" left join bd_psndoc doc");
		sql.append(" on doc.id_psndoc = emp.id_emp");
		sql.append(" order by a.code");
		param.addParam(appDTO.getId_apt_appl());
		List<ScAptOptEmpDO> list =  (List<ScAptOptEmpDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(ScAptOptEmpDO.class));
		return list.toArray(new ScAptOptEmpDO[0]);
	}
}
