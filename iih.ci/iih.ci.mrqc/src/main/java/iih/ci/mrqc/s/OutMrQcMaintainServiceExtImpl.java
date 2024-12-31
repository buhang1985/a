package iih.ci.mrqc.s;

import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.i.IOutMrQcMaintainServiceExt;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordDO;
import iih.ci.mrqc.randomqc.d.MrQcRandomItmDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 门诊科室质控记录查询记录主表
 * @author F
 *
 */
@Service(serviceInterfaces={IOutMrQcMaintainServiceExt.class}, binding=Binding.JSONRPC)
public class OutMrQcMaintainServiceExtImpl implements IOutMrQcMaintainServiceExt{

	/**
	 * 门诊科室质控记录查询记录主表
	 * @param qryRootNodeDTO
	 * @return
	 */
	@Override
	public  CiMrQcRandomRecordDO[] getOutDepQcRandomRecordQryList(QryRootNodeDTO qryRootNodeDTO) throws BizException{
		
		DAFacade daf = new DAFacade();
	    IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
    	StringBuilder sql = new StringBuilder();
				sql.append("SELECT\n");
				sql.append("	  	c.id_random_record,\n");
				sql.append("      	c.id_grp,\n");
				sql.append("      	c.id_org,\n");
				sql.append("      	c.code_entp,\n"); 
				sql.append("        c.name_random_record,\n");
				sql.append("   		c.id_emp_random_record,\n"); 
				sql.append("  		c.dt_random_record,\n"); 
				sql.append("      	c.dt_dead_random,\n"); 
				sql.append("      	c.id_dep_random_record,\n"); 
				sql.append("       	c.id_by_dep,\n"); 
				sql.append("       	c.times_random_record,\n");
				sql.append("  		c.id_emp_submit,\n"); 
				sql.append("  		c.dt_submit,\n"); 
				sql.append("  		c.id_random_status,\n"); 
				sql.append("  		c.sd_random_status,\n"); 
				sql.append("  		c.id_type_random,\n"); 
				sql.append("   		c.sd_type_random,\n"); 
				sql.append("  		c.createdby,\n"); 
				sql.append("   		c.modifiedby,\n"); 
				sql.append("  		c.createdtime,\n"); 
				sql.append("   		c.modifiedtime,\n");				
				sql.append("   		b.name as Dep_random_record_name\n");
				sql.append("FROM ci_mr_qc_record c\n"); 
				sql.append("LEFT JOIN bd_Dep b\n"); 
				sql.append("ON c.id_dep_random_record =b.id_dep\n"); 
				sql.append("WHERE\n"); 
				sql.append("  ((Sd_type_random='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_TYPE_OPD+"' and Sd_random_status<>'"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_MAIN_STATUS_YIFENPEI+"') or Sd_type_random='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_TYPE_DEP+"' )");
				if (qryRootNodeDTO!=null){
				     sql.append(" and "+service.getQueryStringWithoutDesc(qryRootNodeDTO));
				}
				sql.append(" and id_by_dep='"+Context.get().getDeptId()+"'");
				sql.append("   order by c.sd_type_random asc,c.sv desc,c.ID_RANDOM_RECORD"); 
			    
	   String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<CiMrQcRandomRecordDO> listMr = (List<CiMrQcRandomRecordDO>) daf.execQuery(sqlStr, new BeanListHandler(CiMrQcRandomRecordDO.class));
       return (CiMrQcRandomRecordDO[]) listMr.toArray(new CiMrQcRandomRecordDO[0]);	
	}
	
    
	/**
	 * 门诊部质控记录查询记录主表
	 * @param qryRootNodeDTO
	 * @return
	 */
	@Override
	public  CiMrQcRandomRecordDO[] getOutOpdQcRandomRecordQryList(QryRootNodeDTO qryRootNodeDTO) throws BizException{
		
		DAFacade daf = new DAFacade();
	    IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
    	StringBuilder sql = new StringBuilder();
				sql.append("SELECT\n");
				sql.append("	  	c.id_random_record,\n");
				sql.append("      	c.id_grp,\n");
				sql.append("      	c.id_org,\n");
				sql.append("      	c.code_entp,\n"); 
				sql.append("        c.name_random_record,\n");
				sql.append("   		c.id_emp_random_record,\n"); 
				sql.append("  		c.dt_random_record,\n"); 
				sql.append("      	c.dt_dead_random,\n"); 
				sql.append("      	c.id_dep_random_record,\n"); 
				sql.append("       	c.id_by_dep,\n"); 
				sql.append("       	c.times_random_record,\n");
				sql.append("  		c.id_emp_submit,\n"); 
				sql.append("  		c.dt_submit,\n"); 
				sql.append("  		c.id_random_status,\n"); 
				sql.append("  		c.sd_random_status,\n"); 
				sql.append("  		c.id_type_random,\n"); 
				sql.append("   		c.sd_type_random,\n"); 
				sql.append("  		c.createdby,\n"); 
				sql.append("   		c.modifiedby,\n"); 
				sql.append("  		c.createdtime,\n"); 
				sql.append("   		c.modifiedtime,\n");				
				sql.append("   		b.name as name_by_dep\n");
				sql.append("FROM ci_mr_qc_record c\n"); 
				sql.append("LEFT JOIN bd_Dep b\n"); 
				sql.append("ON c.id_by_dep=b.id_dep\n"); 
				sql.append("WHERE\n"); 
				sql.append(" Sd_type_random='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_TYPE_OPD+"'");
				if (qryRootNodeDTO!=null){
				     sql.append(" and "+service.getQueryStringWithoutDesc(qryRootNodeDTO));
				}
				sql.append("   order by c.sd_type_random asc,c.sv desc,c.ID_RANDOM_RECORD"); 
			    
	   String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<CiMrQcRandomRecordDO> listMr = (List<CiMrQcRandomRecordDO>) daf.execQuery(sqlStr, new BeanListHandler(CiMrQcRandomRecordDO.class));
       return (CiMrQcRandomRecordDO[]) listMr.toArray(new CiMrQcRandomRecordDO[0]);	
	}
	
    /**
	 * 门诊科室质控记录查询记录明细表
	 * @param qryRootNodeDTO
	 * @return
	 */
	@Override
	public MrQcRandomItmDTO[] getMrQcOutRandomItmList(String id_random_itm)throws BizException {
		DAFacade daf = new DAFacade();
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
 		sql.append("       amr.code_amr_ip as hospital_code,\n");
 		sql.append("       amr.fg_terminal_qa as fg_mrqc_terminal\n");
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
 		sql.append("    order by ee.code asc");
    	String sqlStr=sql.toString();
        @SuppressWarnings("unchecked")
        List<MrQcRandomItmDTO> listMr = (List<MrQcRandomItmDTO>) daf.execQuery(sqlStr, new BeanListHandler(MrQcRandomItmDTO.class));
        return (MrQcRandomItmDTO[]) listMr.toArray(new MrQcRandomItmDTO[0]);		
    	
	}
}