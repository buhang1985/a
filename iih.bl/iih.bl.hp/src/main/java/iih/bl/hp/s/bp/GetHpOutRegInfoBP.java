package iih.bl.hp.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.hp.dto.d.OutHospitalRegDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医保出院登记就诊信息 
 * @author liwq
 * @since 2017-7-27 8:46:21
 */
public class GetHpOutRegInfoBP {

	@SuppressWarnings("unchecked")
	public OutHospitalRegDTO[] exec(String id_ent) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select en.code,                    ");
		sql.append("      bed.name_bed,                 ");
		sql.append("      en.id_emp_phy,                ");
		sql.append("      psn.name empname,             ");
		sql.append("      diitm.id_didef_code,          ");
		sql.append("      diitm.id_didef_name,          ");
		sql.append("      en.dt_end                     ");
		sql.append(" from en_ent en                     ");
		sql.append(" left join en_ent_bed bed           ");
		sql.append("   on en.id_ent = bed.id_ent        ");
		sql.append(" left join bd_psndoc psn            ");
		sql.append("   on en.id_emp_phy = psn.id_psndoc ");
		sql.append(" left join ci_di di                 ");
		sql.append("   on di.id_en = en.id_ent          ");
		sql.append(" left join ci_di_itm diitm          ");
		sql.append("   on di.id_di = diitm.id_di        ");
		sql.append(" where en.code_entp = '10'          ");
		sql.append("  and di.id_ditp = ?                ");
		sql.append("  and en.dt_end is not null         ");
		sql.append("  and en.fg_st = 'Y'                ");
		
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(ICiDictCodeConst.ID_OUTHOSPITAL);
		if (!StringUtil.isEmptyWithTrim(id_ent)) {
			sql.append("  and en.id_ent = ?                 ");
			sqlp.addParam(id_ent);
		}	
		List<OutHospitalRegDTO> list = (List<OutHospitalRegDTO>)new DAFacade().execQuery(sql.toString(), sqlp,new BeanListHandler(OutHospitalRegDTO.class));
		return list.toArray(new OutHospitalRegDTO[]{});
	}
}
