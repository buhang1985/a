/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.s.bp.outqc;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.randomqc.d.MrQcRandomItmDTO;

import java.util.List;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 〈扼要描述〉
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class OutMrQcQryBP {

	/**
	 * 根据门诊质控类型获取对应的缺陷
	 * @param id_ent
	 * @param id_qc_type
	 * @return
	 * @throws BizException
	 */
	public QaFltDTO[] getOutQcfltDtosByQcType(String id_ent, String id_qc_type)
			throws BizException {
		 /**
		 *  实现代码
		 */
	    	DAFacade daf = new DAFacade();
	    	StringBuilder sql = new StringBuilder();
					sql.append("SELECT cqt.id_flt_sta,\n");
					sql.append("	   cqif.id_fst          as id_fst,\n");
					sql.append("       cqif.name            as fst_name,\n");
					sql.append("       cqif.score           as score_fstmax,\n");
					sql.append("       bu.name           flt_sta_name,\n"); 
					sql.append("       cm.name           id_mr_name,\n"); 
					sql.append("       cqi.id_qa_itm,\n"); 
					sql.append("       cqi.once_drp_scr  once_drp_scr,\n"); 
					sql.append("       cqi.id_qa_drp_scr_tp   id_qa_drp_scr_tp,\n"); 
					sql.append("       cqi.max_drp_scr   max_drp_scr,\n");
					sql.append("       cqi.req           res,\n"); 
					sql.append("       cqi.deduct_des,\n"); 
					sql.append("       cqt.deduct_scr_times  deduct_scr_times,\n"); 
					sql.append("       cqt.id_qa_flt,\n"); 
					sql.append("       cqt.dt_sbmt,\n"); 
					sql.append("       cqt.id_sbmt_user,\n"); 
					sql.append("       su.name           sbmt_user_name,\n"); 
					sql.append("       cqt.rfm_des       rfm_req,\n"); 
					sql.append("       cm.id_emp_submit,\n"); 
					sql.append("       su3.name           emp_submit_name,\n"); 
					sql.append("       cm.id_submit_dept,\n"); 
					sql.append("       su2.name          submit_dept_name,\n"); 
					sql.append("       cqt.id_qa_flt     id_qaflt\n"); 
					sql.append("  FROM ci_qa_flt cqt\n"); 
					sql.append("  LEFT JOIN ci_qa_itm cqi\n"); 
					sql.append("    ON cqt.id_qa_itm = cqi.id_qa_itm\n"); 
					sql.append("  left JOIN ci_mr cm\n"); 
					sql.append("    ON cqt.id_mr = cm.id_mr\n"); 
					sql.append("  LEFT JOIN sys_user su\n"); 
					sql.append("    ON cqt.id_sbmt_user = su.id_user\n"); 
					sql.append("    LEFT JOIN sys_user su3\n"); 
					sql.append("    ON cm.id_emp_submit=su3.id_user\n"); 
					sql.append("  LEFT JOIN bd_dep su2\n"); 
					sql.append("    ON cm.id_submit_dept = su2.id_dep\n"); 
					sql.append("  LEFT JOIN bd_udidoc bu\n"); 
					sql.append("    ON bu.id_udidoc = cqt.id_flt_sta");
					sql.append("  left join ci_qa_itm_fst cqif\n");
					sql.append("    on cqif.id_fst = cqi.id_fst\n");
					sql.append(" WHERE id_flt_sta = '"+ICiMrDictCodeConst.ID_REFORM+"'\n"); 
					sql.append("   and id_qa_ty = '"+id_qc_type+"'\n"); 
					sql.append("   AND cqt.id_ent LIKE '%"+ id_ent + "%'\n"); 
					sql.append("   AND cqt.ds = '0'\n"); 
					sql.append("   order by cqt.dt_sbmt"); 
					String sqlStr=sql.toString();
	       @SuppressWarnings("unchecked")
	       List<QaFltDTO> listMr = (List<QaFltDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaFltDTO.class));
	      
	       return (QaFltDTO[]) listMr.toArray(new QaFltDTO[0]);
	}
	/**
	 * 获取门诊科室质控抽查记录明细
	 * @param id_random
	 * @return
	 * @throws BizException
	 */
	public MrQcRandomItmDTO[] getOutDepMrQcRandomItmDtos(String id_random_itm) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("select itm.id_random_check_itm as id_random_itm,\n");
		sql.append("       itm.id_check_status as id_check_status,\n");
		sql.append("       itm.sd_check_status as sd_check_status,\n");
		sql.append("       bu.name as name_check_status,\n");		
		sql.append("       ee.id_ent as id_ent,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ee.code as code_ent,\n");
		sql.append("       ee.name_pat as name_pat,\n");
		sql.append("       ee.dt_birth_pat as Dt_birth,\n");
		sql.append("       (CASE\n");
		sql.append("         WHEN ee.sd_sex_pat = '0' THEN\n");
		sql.append("          '未知的性别'\n");
		sql.append("         WHEN ee.sd_sex_pat = '1' THEN\n");
		sql.append("          '男'\n");
		sql.append("         WHEN ee.sd_sex_pat = '2' THEN\n");
		sql.append("          '女'\n");
		sql.append("         WHEN ee.sd_sex_pat = '9' THEN\n");
		sql.append("          '未说明性别'\n");
		sql.append("       end) as pat_sex,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       psn.name as name_emp_phy,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       dep.name as name_dep_phy,\n");
		sql.append("       ee.dt_entry as dt_entry,\n");
		sql.append("       itm.dt_check as dt_random,\n");
 		sql.append("(select count(1) from ci_qa_flt cqf where cqf.id_ent=itm.id_ent and cqf.sd_qa_ty='"+ICiMrDictCodeConst.SD_EXEC_OUTQC+"'  and cqf.ds='0') as flt_times,\n");
		sql.append("       amr.id_enhr as id_amr,\n");
		sql.append("       amr.fg_dept_qa as fg_mrqc,\n");
		sql.append("       amr.score_dept_qa as score,\n");
		sql.append("       amr.fg_terminal_qa as fg_mrqc_terminal,\n");
		sql.append("       amr.score_terminal_qa as score_terminal,\n");
		sql.append("       amr.code_amr_ip as hospital_code\n");
		sql.append("  from ci_mr_qc_record_itm itm\n");
		sql.append("  left join en_ent ee\n");
		sql.append("    on ee.id_ent = itm.id_ent\n");
		sql.append("  left join ci_amr amr\n");
		sql.append("    on amr.id_ent = itm.id_ent\n");
		sql.append("  left join bd_psndoc psn\n");
		sql.append("    on psn.id_psndoc = ee.id_emp_phy\n");
		sql.append("  left join bd_dep dep\n");
		sql.append("    on dep.id_dep = ee.id_dep_phy\n");
		sql.append("  left join bd_udidoc bu\n");
		sql.append("    on bu.id_udidoc = itm.id_check_status\n");
		sql.append(" where itm.id_random_record='"+id_random_itm+"'");
 		String sqlStr=sql.toString();
 		DAFacade daf = new DAFacade();
	    @SuppressWarnings("unchecked")
	    List<MrQcRandomItmDTO> listMr = (List<MrQcRandomItmDTO>) daf.execQuery(sqlStr, new BeanListHandler(MrQcRandomItmDTO.class));
	      
	    return (MrQcRandomItmDTO[]) listMr.toArray(new MrQcRandomItmDTO[0]);
	}
}
