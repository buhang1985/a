package iih.ci.mrqc.s;

import java.util.List;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.ci.mr.mrlogdto.d.MrLogDTO;
import iih.ci.mrqc.connonationqcdto.d.ConnonationQcItmDTO;
import iih.ci.mrqc.i.IMrqcMaintainService;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqc.qared.d.QaRecordDO;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;
import iih.ci.mrqc.s.bp.SaveRevNoticeBP;
import iih.ci.mrqc.s.bp.UpdateStatus;
import iih.ci.mrqc.s.bp.connonationqc.ConnoQcSaveBP;

@Service(serviceInterfaces={IMrqcMaintainService.class}, binding=Binding.JSONRPC)
public class MrqcMaintainServiceImpl implements IMrqcMaintainService {

	@Override
	public String SaveRevNotice(RevisionNoticeDO revnotice,QaFltDTO[] qaflt,QaRecordDO qarecord,String id_amr) throws BizException {
		SaveRevNoticeBP save = new SaveRevNoticeBP();
		 return save.SaveRevNotice(revnotice,qaflt,qarecord,id_amr);
	}

	@Override
	public FBoolean updateStatus(QaFltDTO[] qaflt) throws BizException {
		UpdateStatus update = new UpdateStatus();
		 return update.updateStatus(qaflt);
	}
	/**
	 * 获取患者的内涵质控项目
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public ConnonationQcItmDTO[] getConnonationQcItmDtos(String id_ent)
			throws BizException {
		DAFacade daf = new DAFacade();
    	StringBuilder sql = new StringBuilder();
				sql.append("select conno.* ");
				sql.append("       from ci_mr_qc_conno conno");
				sql.append("    left join ci_mr_qc_conno_itm mritm");
				sql.append("       on mritm.id_mr_qc_connotation = conno.id_mr_qc_connotation");
				sql.append("   where conno.id_ent='"+id_ent+"'");
				
				String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<ConnonationQcItmDTO> listMr = (List<ConnonationQcItmDTO>) daf.execQuery(sqlStr, new BeanListHandler(ConnonationQcItmDTO.class));
      
       return (ConnonationQcItmDTO[]) listMr.toArray(new ConnonationQcItmDTO[0]);
	}
	/**
	 * 获取基础数据下所有的内涵质控项目
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public ConnonationQcItmDTO[] getAllConnonationQcItmDtos(String id_ent)
			throws BizException {
		DAFacade daf = new DAFacade();
    	StringBuilder sql = new StringBuilder();
				sql.append("select bditm.req_conno, ");
				sql.append("       bditm.id_connonation_req Id_conno_req_item,");
				sql.append("       bditm.req_conno_txt,");
				sql.append("       mritm.id_req_assess,");
				sql.append("       mritm.sd_req_assess as sd_req_assess,");
				sql.append("       mritm.name_req_assess,");
				sql.append("       bditm.fg_none"); 
				sql.append("  from bd_qa_connonation_itm bditm"); 
				sql.append("  left join ci_mr_qc_conno_itm mritm"); 
				sql.append("    on mritm.id_conno_req_item = bditm.id_connonation_req and mritm.id_ent='"+id_ent+"'"); 
//				sql.append("  left join ci_mr_qc_conno mrcon"); 
//				sql.append("    on mrcon.id_mr_qc_connotation = mritm.id_mr_qc_connotation and mrcon.id_ent='"+id_ent+"'"); 
				sql.append(" where bditm.id_org='"+Context.get().getOrgId()+"' ");
				sql.append(" order by bditm.sortno asc"); 

				String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<ConnonationQcItmDTO> listMr = (List<ConnonationQcItmDTO>) daf.execQuery(sqlStr, new BeanListHandler(ConnonationQcItmDTO.class));
      
       return (ConnonationQcItmDTO[]) listMr.toArray(new ConnonationQcItmDTO[0]);
	}
	/**
	 * 保存内涵质控项目
	 * @param revnotice
	 * @throws BizException
	 */
	
	@Override
	public FBoolean saveConnonationMrQcItm(ConnonationQcItmDTO[] qcItmDtos,
			ConnonationQcItmDTO qcItmDto, QaPatListDTO patListDto)
			throws BizException {
		ConnoQcSaveBP saveBP= new ConnoQcSaveBP();
		return saveBP.saveConnonationMrQcItm(qcItmDtos, qcItmDto, patListDto);
	}
	/**
	 * 获取就诊的所有文书
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public MrLogDTO[] getMrFullLog(String id_ent) throws BizException {
		// TODO Auto-generated method stub
		DAFacade daf = new DAFacade();
    	StringBuilder sql = new StringBuilder();
				sql.append("select ci_mr.id_mr, ");
				sql.append("       ci_mr.id_mrtp ,");
				sql.append("       ci_mr.id_mrtpl,");
				sql.append("       ci_mr.id_su_mr,");
				sql.append("       ci_mr.dt_rd ,");
				sql.append("       ci_mr.sd_su_mr,");
				sql.append("       ci_mr.createdtime,");
				sql.append("       ci_mr.createdby,");
				sql.append("       ci_mr.name,");
				sql.append("       ci_mr.ds as isds,");
				sql.append("       ci_mr.id_emp_submit,");
				sql.append("       ci_mr.DATE_SUBMIT as dt_submit,");
				sql.append("       bu1.name as name_su_mr,");
				sql.append("       su.name as name_createdby,"); 
				sql.append("       su2.name as name_emp_submit");
				sql.append("  from ci_mr ci_mr"); 
				sql.append("  left join bd_mrca_ctm bd_mrca_ctm"); 
				sql.append("    on bd_mrca_ctm.id_mrcactm = ci_mr.id_mrcactm");
				sql.append("  left join sys_user su"); 
				sql.append("    on su.id_user = ci_mr.createdby");
				sql.append("  left join bd_udidoc bu1"); 
				sql.append("    on bu1.id_udidoc = ci_mr.id_su_mr");
				sql.append("  left join sys_user su2"); 
				sql.append("    on su2.id_user = ci_mr.id_emp_submit");
				sql.append("    where ci_mr.code_entp='10' ");
				sql.append("    and  bd_mrca_ctm.docornur<>'20' and ci_mr.id_ent='"+id_ent+"' " );
				sql.append(" order by ci_mr.dt_rd asc"); 

				String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<MrLogDTO> listMr = (List<MrLogDTO>) daf.execQuery(sqlStr, new BeanListHandler(MrLogDTO.class));
      
       return (MrLogDTO[]) listMr.toArray(new MrLogDTO[0]);
	}
}
