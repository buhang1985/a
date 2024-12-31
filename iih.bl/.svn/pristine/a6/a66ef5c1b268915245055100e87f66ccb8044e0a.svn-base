package iih.bl.hp.s.bp;

import iih.bl.hp.dto.d.HpPatiEntDTO;

import java.util.List;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 查询医保患者在院就诊信息
 * @author liwq
 */
public class GetInHospHpPatiEntInfoBp {

	public HpPatiEntDTO[] exec(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		IQrySQLGeneratorService ser = (IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereSql = ser.getQueryStringWithoutDesc(qryRootNodeDTO);	
		
		StringBuilder sqlb = new StringBuilder();
		sqlb.append(" select sum(prepay.amt*prepay.eu_direct) amt_pre,y.* from ( ");
        sqlb.append(" select sum(cg.amt*cg.eu_direct) amt_all_unsettled, x.id_ent,x.hp_ent_serialno,x.code_ent, ");
        sqlb.append(" x.name_pat,x.sex, x.dt_entry,x.age,x.name_dep,x.name_bed,name_medkind,x.ip_status from  ( ");
		sqlb.append(" select hpcode.id_ent, hpcode.hp_ent_serial_no as hp_ent_serialno,en.code code_ent,en.name_pat,case en.sd_sex_pat when '1' then '男' when '2' then '女' else '未知' end sex,en.dt_entry , ");
		sqlb.append(" Trunc(MONTHS_BETWEEN(to_date(to_char(sysdate, 'yyyy-MM-dd'),'yyyy-MM-dd'),to_date(en.dt_birth_pat, 'yyyy-MM-dd')) / 12) as age, ");
		sqlb.append(" dep.name name_dep,enip.name_bed,medkind.name name_medkind,case when en.fg_ip = 'Y' then '在病区' when (en.fg_ip = 'N' and en.fg_st = 'N') then '出院未结算' end as ip_status ");
		sqlb.append("  from  bl_hp_entcode_ah hpcode left join  en_ent en on hpcode.id_ent = en.id_ent ");
		sqlb.append(" left join en_ent_hp enthp on enthp.id_ent = en.id_ent " );
		sqlb.append("  left join bd_hp_patca patca on enthp.code_hppatca = patca.code_hppatca ");
		sqlb.append(" left join bd_dep dep on dep.id_dep = en.id_dep_phy ");
		sqlb.append(" left join en_ent_ip enip on enip.id_ent = hpcode.id_ent ");
		sqlb.append(" left join bd_hp_med_kind_ah medkind on medkind.code = en.code_hpmedkind ");		
		sqlb.append(" where hpcode.fg_active = 'Y'  ");
		if(!StringUtils.isEmpty(whereSql)) {
			sqlb.append(" and ").append(whereSql);
		}	
		sqlb.append(" ) x left join bl_cg_ip cg on  cg.id_ent = x.id_ent ");
		sqlb.append("  group by x.id_ent,x.hp_ent_serialno,x.code_ent,x.name_pat,x.sex, x.dt_entry,x.age,x.name_dep,x.name_bed,name_medkind,x.ip_status  ");
		sqlb.append(" ) y left join bl_prepay_pat prepay  on prepay.id_ent = y.id_ent ");
		sqlb.append("  group by y.id_ent,y.hp_ent_serialno,y.code_ent,y.name_pat,y.sex, y.dt_entry,y.age,y.name_dep,y.name_bed,y.name_medkind,y.ip_status,y.amt_all_unsettled ");
		sqlb.append(" order by code_ent ");
		
		List<HpPatiEntDTO> list = (List<HpPatiEntDTO>)new DAFacade().execQuery(sqlb.toString(),new BeanListHandler(HpPatiEntDTO.class));
		if(list != null && !list.isEmpty() && list.size() > 0)
			return list.toArray(new HpPatiEntDTO[list.size()]);
		else
			return null;
	}
}
