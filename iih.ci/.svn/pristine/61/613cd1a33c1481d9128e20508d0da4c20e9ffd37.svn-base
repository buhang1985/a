package iih.ci.rcm.coninfodto.s;

import iih.ci.rcm.coninfodto.d.ConInfoDTO;
import iih.ci.rcm.coninfodto.i.ConInfoService;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
 * @author tangws
 * @date 2017年4月27日 上午11:19:55
 *
 */
@Service(serviceInterfaces = { ConInfoService.class }, binding = Binding.JSONRPC)
public class ConInfoServiceImpl implements ConInfoService {

	@SuppressWarnings("unchecked")
	public ConInfoDTO[] GetContagions() throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct \n");
		sql.append("       ccc.eu_jlcrb_name || ccc.eu_ylcrb_name || ccc.eu_blcrb_name ||\n");
		sql.append("       ccc.name_other_diseases as card_name,\n");
		sql.append("       ccc.name as pat_name,\n");
		sql.append("       sexdoc.name as Pat_xex,\n");
		sql.append("	   (select listagg(name, ',') within group(order by name) as name ");
		sql.append(" 	   from (select distinct id_didef_name name,id_en ");
		sql.append("	   from ci_di cd ");
		sql.append("	    left join ci_di_itm cdi on cdi.id_di = cd.id_di ");
		sql.append("       ) where id_en = ccc.id_ent) as diagnose,");
		sql.append("       ccc.name_emp_entry as report_doctor,\n");
		sql.append("       ccc.dt_contagion as report_date,\n");
		sql.append("       ccc.delete_resion as delete_reason,\n");
		sql.append("       su.name as delete_person,\n");
		sql.append("       ccc.modifiedtime as Opreta_time,\n");
		sql.append("       ccc.id_ent as id_ent,\n");
		sql.append("       ccc.Id_contagion as Id_contagion \n");
		sql.append("  from ci_contagion_card ccc \n");
		sql.append(" left join bd_udidoc sexdoc \n");
		sql.append("    on sexdoc.id_udidoc = ccc.id_sex \n");
		sql.append(" left join bd_psndoc su \n");
		sql.append("    on su.id_psndoc = ccc.modifiedby \n");
		sql.append("       where ccc.ds=1 and ccc.delete_resion is not null order by ccc.modifiedtime desc");
		String sqlStr = sql.toString();
		DAFacade daf = new DAFacade();
		List<ConInfoDTO> listDto = (List<ConInfoDTO>) daf.execQuery(sqlStr,
				new BeanListHandler(ConInfoDTO.class));
		return listDto.toArray(new ConInfoDTO[0]);
	}

}
