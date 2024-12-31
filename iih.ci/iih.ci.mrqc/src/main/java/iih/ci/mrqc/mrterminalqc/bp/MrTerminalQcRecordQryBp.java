package iih.ci.mrqc.mrterminalqc.bp;

import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqc.qarecorddto.d.QaRecordDTO;
import iih.ci.mrqc.qared.d.QaRecordDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;

public class MrTerminalQcRecordQryBp {
	 /**
     * 获取终末质控记录
     * @param qaPatListDto
     * @return
     * @throws BizException
     */
	public QaRecordDTO[] getMrQcTerminalScoreQryRecordList(QaPatListDTO qaPatListDto) throws BizException {
		DAFacade daf = new DAFacade();  	
    	StringBuilder sql = new StringBuilder();
    	sql.append("       select ci_qa_record.dt_plan as dt_plan,\n" );
		sql.append("       ci_amr.code_amr_ip as code_hospital,\n" );
		sql.append("       ci_qa_record.id_qa as id_recorddto,\n" );
		sql.append("       ee.name_pat as name_pat,\n" );
		sql.append("       eed.name_didef_dis as name_di,\n");
		sql.append("       cqrn.id_revision as id_revision,\n");
		sql.append("       cqrn.id_status as id_status,\n" );
		sql.append("       cqrn.des as res,\n"); 
		sql.append("       bu.name as status_name,\n" );
		sql.append("       (select count(*) from ci_qa_divide cqd where cqd.id_qa = ci_qa_record.id_qa ) as deduct_times,\n" );
		sql.append("       ci_qa_record.id_exec_user as id_exec_user,\n" );
		sql.append("       su.name as exec_user_name,\n");
		sql.append("       ci_qa_record.id_exec_dept as id_exec_dept,\n" );
		sql.append("       bd.name as exec_dept_name,\n" ); 
		sql.append("       ci_qa_record.id_ent as id_ent,\n" ); 
		sql.append("       ee.id_pat as id_pat,\n" );
		sql.append("       ee.code as ent_code,\n" );
		sql.append("       ci_qa_record.Score_Qa_Ty  as score,\n" );
		sql.append("       ee.code_entp as code_entp,\n" );
		sql.append("       ci_qa_record.id_qa as id_recorddto\n" );
		sql.append("       from ci_qa_record ci_qa_record\n");
		sql.append("       inner join ci_amr ci_amr\n" );
		sql.append("       on ci_qa_record.id_ent=ci_amr.id_ent\n");
		sql.append("       left join ci_qa_revision_notice cqrn\n" );
		sql.append("       on ci_qa_record.id_revision=cqrn.id_revision\n");
		sql.append("       left join en_ent ee\n" );
		sql.append("       on ci_qa_record.id_ent = ee.id_ent\n" );
		sql.append("       left join en_ent_di eed\n" );
		sql.append("       on ci_qa_record.id_ent = eed.id_ent\n" );
		sql.append("       AND eed.fg_maj = 'Y'\n" );
		sql.append("       left join sys_user su\n" );
		sql.append("       on su.id_user=ci_qa_record.id_exec_user\n" );
		sql.append("       left join bd_dep bd\n" );
		sql.append("       on bd.id_dep=ci_qa_record.id_exec_dept\n" );
		sql.append("       left join bd_udidoc bu\n"  );
		sql.append("       on bu.id_udidoc = cqrn.id_status" );
		sql.append("       left join en_ent ee\n"  );
		sql.append("       on ee.id_ent = ci_qa_record.id_ent" );
		sql.append("        where "+EnvContextUtil.processEnvContext("",new QaRecordDO(),false)+" and ee.code_entp='10'  and ee.fg_canc = 'N'  and ci_qa_record.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_END+"' and ci_qa_record.id_revision='~'  and ee.id_ent = '"+ qaPatListDto.getId_ent() +"' ");//and ci_amr.fg_terminal_qa = 'Y'
		sql.append("       order by ci_qa_record.dt_plan desc" );
		String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<QaRecordDTO> listMr = (List<QaRecordDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaRecordDTO.class));
       return (QaRecordDTO[]) listMr.toArray(new QaRecordDTO[0]);
	}
}
