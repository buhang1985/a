package iih.bd.pp.hpdivshisdto.s.bp;

import java.util.List;

import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 医保病种DTO分页查询
 * @author guoyang
 *
 */
public class HpDiVsHisPageQryBp {

	public HpDiVsHisDTO[] exec() throws BizException{
		return findByPageInfo();
	}
	
	private HpDiVsHisDTO[] findByPageInfo() throws BizException {
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT a.*, ");
		sb.append("        divshis.id_hpdivshis, ");
		sb.append("        decode(divshis.id_didef,null,decode(a.id_didef,null,'0','1'),divshis.eu_status) AS eu_status ");
		sb.append(" FROM ");
		sb.append(" 	(SELECT didef.id_didef, ");
		sb.append(" 			didef.code AS didef_code, ");
		sb.append(" 			didef.name AS didef_name, ");
		sb.append(" 			dict.id_hpdidict, ");
		sb.append(" 			di.id_hp, ");
		sb.append(" 			di.code AS hpdidict_code, ");
		sb.append(" 			di.name AS hpdidict_name, ");
		sb.append(" 			di.classific_di, ");
		sb.append(" 			di.str_di_spec, ");
		sb.append(" 			di.str_di_pay, ");
		sb.append(" 			di.classific_di_spec, ");
		sb.append(" 			di.str_treatment_plan, ");
		sb.append(" 			di.pay_max, ");
		sb.append(" 			di.tr_bind_deductible, ");
		sb.append(" 			di.pay_small_45_oep, ");
		sb.append(" 			di.pay_big_45_oep, ");
		sb.append(" 			di.pay_small_45_ip, ");
		sb.append(" 			di.pay_big_45_ip, ");
		sb.append(" 			di.pay_retire_oep, ");
		sb.append(" 			di.pay_retire_ip, ");
		sb.append(" 			di.amt_amount_disease, ");
		sb.append(" 			di.py_code, ");
		sb.append(" 			di.wb_code, ");
		sb.append(" 			di.zdy_code, ");
		sb.append(" 			di.str_effective, ");
		sb.append(" 			di.id_emp_handle, ");
		sb.append(" 			di.dt_handle, ");
		sb.append(" 			di.pay_mx_small_45oep, ");
		sb.append(" 			di.pay_mx_big_45oep ");
		sb.append(" 	FROM BD_HP_di_orginal di ");
		sb.append(" 	LEFT JOIN bd_di_def didef ");
		sb.append(" 	ON di.name = didef.name ");
		sb.append(" 	LEFT JOIN BD_HP_DI_dict dict ");
		sb.append(" 	ON di.code = dict.code ");
		sb.append(" 	WHERE di.str_effective = '1' ");
		sb.append(" 	) a ");
		sb.append(" LEFT JOIN BD_HP_DI_vs_his divshis ");
		sb.append(" ON a.id_hpdidict = divshis.id_hpdidict; ");
		List<HpDiVsHisDTO> hpDiVsHisDTOs =  (List<HpDiVsHisDTO>) new DAFacade().execQuery(sb.toString(),new BeanListHandler(HpDiVsHisDTO.class));
		if(!ListUtil.isEmpty(hpDiVsHisDTOs)){
			return hpDiVsHisDTOs.toArray(new HpDiVsHisDTO[hpDiVsHisDTOs.size()]);
		}
		return null;
	}
}
