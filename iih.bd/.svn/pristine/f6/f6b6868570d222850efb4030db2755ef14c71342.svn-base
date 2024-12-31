package iih.bd.pp.hpdivshisdto.s.bp;

import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class HpdivshisdtoBp {
	
	public PagingRtnData<HpDiVsHisDTO> exec(QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg) throws BizException {
		
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereStr = qrySQLGeneratorService.getQueryStringWithDOName(qryRootNodeDTO, HpDiVsHisDTO.class.getName());

		StringBuffer sql = new StringBuffer();

		sql.append(" select dihis.Id_hpdict, dihis.id_hp, dihis.id_di, dihis.note, didef.code as di_code, didef.name as di_name,dict.name as hpdict_name, dict.code as hpdict_code, ");
		sql.append(" 		ah.classific_di,ah.str_di_spec,ah.str_di_reimbursement,ah.classific_di_spec,ah.str_treatment_plan,ah.pay_max,ah.tr_bind_deductible, ");
		sql.append(" 	    ah.deductible_less_than_45_oep,ah.deductible_greater_than_45_oep,ah.deductible_less_than_45_ip,ah.deductible_greater_than_45_ip, ");
		sql.append("        ah.deductible_retire_oep,ah.deductible_retire_ip,ah.amt_multiple_disease,ah.py_code,ah.wb_code,ah.zdy_code,ah.str_effective, ");
		sql.append("        ah.id_emp_handle,ah.ded_chr_less_than_45_oep,ah.dt_handle,ah.ded_chr_greater_than_45_oep,ah.des ");
		sql.append(" from bd_hp_di_vs_his dihis ");
		sql.append(" left join bd_di_def didef ");
		sql.append(" on dihis.id_di = didef.id_didef ");
		sql.append(" left join bd_hp_di_dict dict ");
		sql.append(" on dihis.id_hpdict = dict.id_hpdidict ");
		sql.append(" left join bd_hp_di_dict_neusoft_ah ah ");
		sql.append(" on dict.id_hpdidict = ah.id_hpdidict ");
		if (whereStr == null) {
			sql.append("     where  ");
			sql.append("1=1");
		} else {
			sql.append("     where  ");
			sql.append(whereStr);
		}
		
		return new PagingServiceImpl<HpDiVsHisDTO>().findByPageInfo(new HpDiVsHisDTO(), pg, sql.toString(), orderStr, null);

	}
}
