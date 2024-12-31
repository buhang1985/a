/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.serviceext.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 〈扼要描述〉
 * 获取质控缺陷DTO bp
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class MrQcGetFltDtoBP {

    /**
     * 获取对应类型以及自动质控的缺陷详情 包括各个状态
     * @param id_ent
     * @param sd_qctype
     * @return
     * @throws BizException
     */
	public QaFltDTO[] getQcfltAndAutoFltDtos(String id_ent, String sd_qctype)
			throws BizException {
		DAFacade daf = new DAFacade();  	
    	StringBuilder sql = new StringBuilder();
				sql.append("SELECT cqt.id_flt_sta,\n");
				sql.append("       cqt.sd_flt_sta,\n");
				sql.append("	   cqif.id_fst          as id_fst,\n");
				sql.append("       cqif.name            as fst_name,\n");
				sql.append("       cqif.score           as score_fstmax,\n");
				sql.append("       bu.name           flt_sta_name,\n"); 
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
				sql.append("       cqt.drp_des       drp_des,\n"); 
				sql.append("       bu1.name       name_qa_ty,\n"); 
				sql.append("       cqt.id_qa_flt     id_qaflt\n"); 
				sql.append("  FROM ci_qa_flt cqt\n"); 
				sql.append("  LEFT JOIN ci_qa_itm cqi\n"); 
				sql.append("    ON cqt.id_qa_itm = cqi.id_qa_itm\n"); 
				sql.append("  LEFT JOIN sys_user su\n"); 
				sql.append("    ON cqt.id_sbmt_user = su.id_user\n"); 
				sql.append("  LEFT JOIN bd_udidoc bu\n"); 
				sql.append("    ON bu.id_udidoc = cqt.id_flt_sta");
				sql.append("  LEFT JOIN bd_udidoc bu1\n"); 
				sql.append("    ON bu1.id_udidoc = cqt.id_qa_ty");
				sql.append("  left join ci_qa_itm_fst cqif\n");
				sql.append("    on cqif.id_fst = cqi.id_fst\n");
				sql.append("   where cqt.sd_qa_ty in ('"+ICiMrDictCodeConst.SD_EXEC_AUTOMATIC+"','"+sd_qctype+"')\n"); 
				sql.append("   AND cqt.id_ent = '"+ id_ent + "'\n"); 
				sql.append("   AND cqt.ds = '0'\n"); 
				sql.append("   order by cqt.sv desc,cqt.sd_flt_sta,cqt.sd_qa_ty"); 
				String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<QaFltDTO> listMr = (List<QaFltDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaFltDTO.class));
      
       return (QaFltDTO[]) listMr.toArray(new QaFltDTO[0]);
	}
}
