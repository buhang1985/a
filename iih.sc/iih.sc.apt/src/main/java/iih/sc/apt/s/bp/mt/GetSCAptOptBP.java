package iih.sc.apt.s.bp.mt;

import java.util.List;

import iih.en.que.dto.d.MedTechAppDTO;
import iih.sc.apt.out.ci.d.ScAptOptEmpDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取手术预约列表
 * 
 * @author maxy
 * @date 2018年7月11日18:08:12
 *
 */
public class GetSCAptOptBP {
	
	/**
	 * 获取手术预约列表
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public ScAptOptEmpDTO[]  exec(String id_or) throws BizException
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" select emp.id_apt,");
		sql.append(" emp.id_aptappl,");
		sql.append(" emp.id_role,");
		sql.append(" emp.sd_role,");
		sql.append(" bd.name as name_role,");
		sql.append(" emp.id_emp,");
		sql.append(" doc.code as code_emp,");
		sql.append(" doc.name as name_emp");
		sql.append(" from sc_apt_opt_emp emp");
		sql.append(" inner join sc_apt_appl appl");
		sql.append(" on emp.id_aptappl = appl.id_aptappl");
		sql.append(" inner join bd_udidoc bd");
		sql.append(" on bd.id_udidoc = emp.id_role");
		sql.append(" inner join bd_psndoc doc");
		sql.append(" on doc.id_psndoc = emp.id_emp");
		sql.append(" where appl.id_or = ?");
		sql.append(" and appl.fg_canc = 'N'");
		SqlParam param = new SqlParam();
		param.addParam(id_or);
		@SuppressWarnings("unchecked")
		List<ScAptOptEmpDTO> list = (List<ScAptOptEmpDTO>) new DAFacade().execQuery(sql.toString(), param,new BeanListHandler(ScAptOptEmpDTO.class));
		return list.toArray(new ScAptOptEmpDTO[0]);
	}
}
