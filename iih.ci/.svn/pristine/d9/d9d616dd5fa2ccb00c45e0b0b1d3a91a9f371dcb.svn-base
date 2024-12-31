package iih.ci.mrqc.qascoredto.s;


import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qascoredto.d.QaScoreDTO;
import iih.ci.mrqc.qascoredto.i.IQaScoreDtoQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces={IQaScoreDtoQryService.class}, binding=Binding.JSONRPC)
public class IQaScoreDtoQryServiceImpl implements IQaScoreDtoQryService{

	@Override
	public QaScoreDTO[] getQaScoreDtos(String id_ent, String id_qc_type)
			throws BizException {
		// TODO Auto-generated method stub
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
			sql.append("select cqif.id_fst          as id_fst,\n");
			sql.append("       cqif.name            as fst_name,\n");
			sql.append("       cqif.score           as score_fstmax,\n");
			sql.append("       cqi.req              as req,\n");
			sql.append("       cqi.id_qa_drp_scr_tp as id_qa_drp_scr_tp,\n");
			sql.append("       cqi.once_drp_scr     as once_drp_scr,\n");
			sql.append("       cqi.deduct_des       as deduct_des,\n");
			sql.append("       cqd.deduct_scr_times as deduct_scr_times,\n");
			sql.append("       cqd.drp_des          as drp_des,\n");
			sql.append("       cqd.id_sbmt_user     as id_sbmt_user,\n");
			sql.append("       su.name              as user_name,\n");
			sql.append("       cqd.id_qa_ty         as id_qa_ty,\n");
			sql.append("       cqd.id_ent           as id_ent,\n");
			sql.append("       bqaic.id_mrcactm     as id_mrcactm,\n");
			sql.append("       bmc.name             as mrcactm_name,\n");
			sql.append("       bqaic.id_mr_types    as id_mrtp,\n");
			sql.append("       bmt.name             as mrtp_name\n");
			sql.append("  from ci_qa_divide cqd\n");
			sql.append("  left join ci_qa_itm cqi\n");
			sql.append("    on cqi.id_qa_itm = cqd.id_qa_itm\n");
			sql.append("  left join bd_qa_auto_itm_config bqaic\n");
			sql.append("    on bqaic.id_qa_itm = cqi.id_qa_itm\n");
			sql.append("  left join ci_qa_itm_fst cqif\n");
			sql.append("    on cqif.id_fst = cqi.id_fst\n");
			sql.append("  left join sys_user su\n");
			sql.append("    on su.id_user = cqd.id_sbmt_user\n");
			sql.append("  left join bd_mrca_ctm bmc\n");
			sql.append("    on bmc.id_mrcactm = bqaic.id_mrcactm\n");
			sql.append("  left join bd_mr_tp bmt\n");
			sql.append("    on bmt.id_mrtp = bqaic.id_mr_types");
			sql.append("  where  cqd.id_ent = '" + id_ent + "' \n");
			sql.append("  and    cqd.id_qa_ty = '" + id_qc_type +"'  order by cqd.sv");
		
		String sqlStr=sql.toString();
		@SuppressWarnings("unchecked")
		List<QaScoreDTO> qaScoreDTOsList=(List<QaScoreDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaScoreDTO.class));
			if(qaScoreDTOsList==null){
				return null;
			}
			
		return (QaScoreDTO[]) qaScoreDTOsList.toArray(new QaScoreDTO[qaScoreDTOsList.size()]);
	}

	@Override
	public QaFltDTO[] getQaFltForScoreDtos(String id_ent, String id_qc_type)
			throws BizException {
		// TODO Auto-generated method stub
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
			sql.append("select cqif.id_fst          as id_fst,\n");
			sql.append("       cqif.name            as fst_name,\n");
			sql.append("       cqif.score           as score_fstmax,\n");
			sql.append("       cqi.req              as req,\n");
			sql.append("       cqi.id_qa_drp_scr_tp as id_qa_drp_scr_tp,\n");
			sql.append("       cqi.once_drp_scr     as once_drp_scr,\n");
			sql.append("       cqi.deduct_des       as deduct_des,\n");
			sql.append("       cqd.deduct_scr_times as deduct_scr_times,\n");
			sql.append("       cqd.drp_des          as res,\n");
			sql.append("       cqd.id_sbmt_user     as id_sbmt_user,\n");
			sql.append("       cqd.id_qa_ty         as id_qa_ty,\n");
			sql.append("       cqd.id_ent           as id_ent\n");
			sql.append("  from ci_qa_flt cqd\n");
			sql.append("  left join ci_qa_itm cqi\n");
			sql.append("    on cqi.id_qa_itm = cqd.id_qa_itm\n");
			sql.append("  left join ci_qa_itm_fst cqif\n");
			sql.append("    on cqif.id_fst = cqi.id_fst\n");
			sql.append("  where  cqd.id_ent = '" + id_ent + "' \n");
			sql.append("  and    cqd.id_qa_ty = '" + id_qc_type +"' ");
			sql.append("  and    cqd.ID_REVISION = '" + ICiMrDictCodeConst.ID_REVISION +"' ");
			sql.append("  and    cqd.id_flt_sta = '" + ICiMrDictCodeConst.ID_REFORM +"'    order by cqd.ID_QA_FLT");
		String sqlStr=sql.toString();
		@SuppressWarnings("unchecked")
		List<QaFltDTO> qaFltDTOsList=(List<QaFltDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaFltDTO.class));
			if(qaFltDTOsList==null){
				return null;
			}
			
		return (QaFltDTO[]) qaFltDTOsList.toArray(new QaFltDTO[qaFltDTOsList.size()]);
	}

}
