package iih.ci.mrqry.mrreport.bp;

import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mrqc.mroperrisklistdto.d.MrOperRiskListDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class MrOperRiskQryBP {

	/**
	 * 手术风险评估表统计
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public MrOperRiskListDTO[] getMrOperRiskList(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		DAFacade daf = new DAFacade();
 		StringBuilder sql = new StringBuilder();
 		sql.append("       SELECT * from (\n");
 		sql.append("       SELECT cm.date_submit as submit_time,\n");
 		sql.append("       cm.id_ent as id_ent,\n");
 		sql.append("       cm.id_pat as id_pat,\n");
 		sql.append("       eei.code_amr_ip as hosp_number,\n");
 		sql.append("       ee.name_pat as name,\n");
 		sql.append("       ee.dt_end,\n");
 		sql.append("       max(decode(t1.code_element,'"+ ICiMrDictCodeConst.SSQKQJD +"', dbms_lob.substr(t1.content,4000), null)) as ope_clean,\n");
 		sql.append("       max(decode(t1.code_element,'"+ ICiMrDictCodeConst.SSQKQJDFZ +"', dbms_lob.substr(t1.content,4000), null)) as ope_clean_number,\n");
 		sql.append("       max(decode(t1.code_element,'"+ ICiMrDictCodeConst.MZFJ +"', dbms_lob.substr(t1.content,4000), null)) as poison_level,\n");
 		sql.append("       max(decode(t1.code_element,'"+ ICiMrDictCodeConst.MZFJFZ +"', dbms_lob.substr(t1.content,4000), null)) as poison_level_number,\n");
 		sql.append("       max(decode(t1.code_element,'"+ ICiMrDictCodeConst.CXSJ +"', dbms_lob.substr(t1.content,4000), null)) as continue_time,\n");
 		sql.append("       max(decode(t1.code_element,'"+ ICiMrDictCodeConst.CXSJFZ +"', dbms_lob.substr(t1.content,4000), null)) as continue_time_number,\n");
 		sql.append("       max(decode(t1.code_element,'"+ ICiMrDictCodeConst.ZF +"', dbms_lob.substr(t1.content,4000), null)) as sum_number,\n");
 		sql.append("       max(decode(t1.code_element,'"+ ICiMrDictCodeConst.NNIS +"', dbms_lob.substr(t1.content,4000), null)) as nnis,\n");
 		sql.append("       max(decode(t1.code_element,'"+ ICiMrDictCodeConst.QKYH +"', dbms_lob.substr(t1.content,4000), null)) as incision_healing,\n");
 		sql.append("       max(decode(t1.code_element,'"+ ICiMrDictCodeConst.SSLB +"', dbms_lob.substr(t1.content,4000), null)) as ope_class,\n");
 		sql.append("       max(decode(t1.code_element,'"+ ICiMrDictCodeConst.SFJZ +"', dbms_lob.substr(t1.content,4000), null)) as whether_emergency,\n");
 		sql.append("       max(decode(t1.code_element,'"+ ICiMrDictCodeConst.SSRQ +"', dbms_lob.substr(t1.content,4000), null)) as ope_time,\n");
 		sql.append("       ee.dt_end as hosp_out_time,\n");
 		sql.append("       bd.name as depment_class,\n");
 		sql.append("       bd.id_dep\n");
 		sql.append("        from ci_mr cm ");
 		sql.append("      left join  ci_mr_doc_reference_value t1 " );
 		sql.append("       ON t1.id_ent=cm.id_ent " );
 		sql.append("       left join en_ent ee" );
 		sql.append("       ON ee.id_ent = t1.id_ent" );
 		sql.append("       left join en_ent_ip eei" );
 		sql.append("       ON eei.id_ent = t1.id_ent" );
 		sql.append("       left join bd_dep bd" );
 		sql.append("        ON bd.id_dep = eei.id_dep_phyadm" );
 		sql.append("       inner join bd_mrtp bm" );
 		sql.append("       ON bm.id_mrtp = cm.id_mrtp" );
 		sql.append("       where 1=1 and bm.cd_std = '"+ IMrPubConst.DS_SSFX +"'\n" );
 		sql.append("       and cm.ds=0 and cm.sd_su_mr not in ('"+ ICiMrDictCodeConst.SD_SU_MR_NEW +"', '"+ ICiMrDictCodeConst.SD_SU_MR_REJECT +"', '"+ ICiMrDictCodeConst.SD_SU_MR_RETRIEVE +"') \n" );
 		sql.append("        group by cm.date_submit,cm.id_ent, cm.id_pat,eei.code_amr_ip,ee.name_pat, ee.dt_end, bd.name,bd.id_dep\n" );
 		sql.append("       order by submit_time\n" );
 		sql.append("       ) x where "+sqlwhere+"\n" );
 		String sqlStr=sql.toString();
 		@SuppressWarnings("unchecked")
		List<MrOperRiskListDTO> qaFltDTOsList=(List<MrOperRiskListDTO>) daf.execQuery(sqlStr, new BeanListHandler(MrOperRiskListDTO.class));
			if(qaFltDTOsList==null){
				return null;
			}
		return (MrOperRiskListDTO[]) qaFltDTOsList.toArray(new MrOperRiskListDTO[qaFltDTOsList.size()]);
	}
}
