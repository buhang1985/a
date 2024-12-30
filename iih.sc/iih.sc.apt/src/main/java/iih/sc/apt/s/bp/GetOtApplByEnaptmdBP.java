package iih.sc.apt.s.bp;

import iih.sc.apt.dto.d.OpAptDetailDTO;
import iih.sc.apt.dto.d.OtAppDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOtApplByEnaptmdBP {

	/**
	 * 手术预约   查询手工预约记录
	 * @param id_pi
	 * @return
	 * @throws BizException 
	 */
	public PagingRtnData<OtAppDTO> exec(String id_pi, PaginationInfo pg) throws BizException
	{
		PagingServiceImpl<OtAppDTO> pageQryService = new PagingServiceImpl<OtAppDTO>();
		SqlParam param = new SqlParam();
		param.addParam(id_pi);
		String sql = this.getQrySQLStr();
		PagingRtnData<OtAppDTO> datas = pageQryService.findByPageInfo(new OtAppDTO(), pg, sql,
				" appl.dt_appl desc ", param);
		return datas;
	}
	
	private String getQrySQLStr()
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" select appl.id_aptappl,");
		sql.append(" appl.dt_appl,");
		sql.append(" appl.name as name_or,");
		sql.append(" doc.id_psndoc as id_emp_appl,");
		sql.append(" doc.code as code_emp_appl,");
		sql.append(" doc.name as name_emp_appl,");
		sql.append(" appl.fg_urgent,");
		sql.append(" appl.des,");
		sql.append(" opt.sd_anestp as code_anestp,");
		sql.append(" anestp.name as name_anestp,");
		sql.append(" opt.specialreq,");
		sql.append(" opt.specialinstrument,");
		sql.append(" opt.specialdes,");
		sql.append(" opt.id_di,");
		sql.append(" opt.code_di,");
		sql.append(" opt.name_di,");
		sql.append(" opt.sug_require,");
		sql.append(" opt.announcements,");
		sql.append(" depappl.name as name_appl_dep,");
		sql.append(" appl.fg_comfirm,");
		sql.append(" appl.id_dep_appl as Id_appl_dep,");
		sql.append(" opt.id_anestp,");
		sql.append(" appl.id_entp as id_enttp,");
		sql.append(" appl.code_entp as code_enttp,");
		sql.append(" decode(appl.code_entp,'00','门诊','10','住院') as name_enttp, ");
		sql.append(" '手工登记' eu_aptmd,");
		sql.append(" decode(appl.modifiedby,'~',appl.createdtime,appl.modifiedtime) as dt_oper,");
		sql.append(" decode(appl.modifiedby,'~',createdoc.name,moddoc.name) as name_oper");
		sql.append(" from sc_apt_appl appl");
		sql.append(" left join bd_dep depappl on depappl.id_dep = appl.id_dep_appl");
		sql.append(" left join bd_psndoc doc on doc.id_psndoc = appl.id_emp_appl");
		sql.append(" left join sc_apt_appl_opt opt on opt.id_aptappl = appl.id_aptappl");
		sql.append(" left join bd_udidoc anestp on anestp.id_udidoc = opt.id_anestp");
		sql.append(" left join sys_user createdoc on createdoc.id_user = appl.createdby");
		sql.append(" left join sys_user moddoc on moddoc.id_user = appl.modifiedby");
		sql.append(" where appl.eu_aptmd = 1 ");
		sql.append(" and appl.id_pi = ? ");
		return sql.toString();
	}
}
