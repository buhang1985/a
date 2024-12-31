package iih.bl.cg.s.bp;

import iih.bd.utils.ParamUtils;
import iih.bl.cg.dto.d.EntRecrodDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;

import com.mysql.jdbc.StringUtils;

/**
 * 门诊通用补费 获取患者就诊记录 参数：BLCG0006
 * @author liwq
 */
public class GetPatiEntRecrodInfoBp {

	public EntRecrodDTO[] exec (String id_pat) throws BizException {
		
		String orgSql = EnvContextUtil.processEnvContext("",new PatiVisitDO(), "en");
		String days = ParamUtils.GetOrgParamStringValue(Context.get().getOrgId(), "BLCG0006");
		if(StringUtils.isNullOrEmpty(days))
			days = "0";
		StringBuilder sb = new StringBuilder();

		sb.append(" select en.id_ent,en.id_pripat,pripat.name as name_pripat, en.dt_acpt dt_entry, en.id_dep_phy as id_ent_dep, dep.name as name_entdep,en.id_emp_phy as id_doctor,psn.name as name_doctor, di.code_didef_dis as code_dis_major,di.name_didef_dis as name_dis_major  ");
		sb.append(" from  en_ent en left join en_ent_di di on di.id_ent = en.id_ent left join bd_pri_pat pripat on pripat.id_pripat= en.id_pripat ");
		sb.append(" left join bd_dep dep on dep.id_dep = en.id_dep_phy left join bd_psndoc psn on psn.id_psndoc = en.id_emp_phy ");
		
		sb.append(" where  en.fg_canc = 'N' and en.code_entp = '00' and en.fg_acptvalid = 'Y' and en.id_pat =  '").append(id_pat+"' and ").append(orgSql);
		if(!StringUtils.isEmptyOrWhitespaceOnly(days))
			sb.append(" and substr(en.dt_acpt,0,10) > substr(to_char(sysdate - ").append(days).append(" ,'yyyy-MM-dd'),0,10) ");
		List<EntRecrodDTO> list = (List<EntRecrodDTO>)new DAFacade().execQuery(sb.toString(), new BeanListHandler(EntRecrodDTO.class));
		
		return list.toArray(new EntRecrodDTO[0]);
	}
}
