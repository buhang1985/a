package iih.ci.mrm.mrquerydto.s;

import iih.ci.mrm.mrquerydto.d.MrQueryDTO;
import iih.ci.mrm.mrquerydto.i.IMrQueryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

public class IMrQueryServiceImpl extends PagingServiceImpl<MrQueryDTO> implements IMrQueryService{

	@Override
	public PagingRtnData<MrQueryDTO> getMedicalRecordData(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		//定义查询方案解析服务
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		//定义查询语句
		String sqlwhere=" where ee.code_entp='10' ";
		if (qryRootNodeDTO!=null){	
			String qryRoot=service.getQueryStringWithoutDesc(qryRootNodeDTO);
			if(qryRoot.contains("@@@@Z8100000000LPWZH")){
				String str=qryRoot.replace("= '@@@@Z8100000000LPWZH'", "is not null");
				if(!StringUtil.isEmptyWithTrim(str))
					sqlwhere += " and " + str;				
			}else if(qryRoot.contains("@@@@Z8100000000LPWZI")){
				String str=qryRoot.replace("= '@@@@Z8100000000LPWZI'", "is null");
				if(!StringUtil.isEmptyWithTrim(str))
					sqlwhere += " and " + str;
			}else{
				sqlwhere += " and " + qryRoot;
			}		
 		}
		
		StringBuilder sb=new StringBuilder();
		sb.append(" select distinct ee.id_ent,ip.code_amr_ip, ip.times_ip,  ");
		sb.append("  ee.name_pat, doc2.name as sex , patca.name as pat_type,  ");
		sb.append("  dep.name as out_dep,  ee.dt_end,   ");
		sb.append(" bd.name as out_dep_nurdisc , ");
		sb.append("  doc.name as mr_status , ot.name as mr_process_status ");
		sb.append(" from en_ent ee  ");
		sb.append(" left join en_ent_ip ip  ");
		sb.append(" on ee.id_ent=ip.id_ent  ");
		sb.append(" left join bd_dep dep  ");
		sb.append(" on dep.id_dep=ip.id_dep_phydisc  ");
		sb.append(" left join bd_dep bd ");
		sb.append(" on bd.id_dep = ip.id_dep_nurdisc ");
		sb.append(" left join ci_amr amr  ");
		sb.append(" on ee.id_ent=amr.id_ent  ");
		sb.append(" left join bd_udidoc doc  ");
		sb.append(" on doc.id_udidoc=amr.id_qa_doctor_part_sta  ");
		sb.append(" left join bd_udidoc doc2  ");
		sb.append(" on doc2.id_udidoc=ee.id_sex_pat  ");
		sb.append(" left join ci_mrm_op op  ");
		sb.append(" on op.id_amr=amr.id_enhr  ");
		sb.append(" left join bd_mrm_ot ot  ");
		sb.append(" on ot.id_bd_mrm_ot=op.id_bd_mrm_ot  ");
		sb.append(" left join pi_pat pat  ");
		sb.append(" on pat.id_pat=ee.id_pat  ");
		sb.append(" left join pi_pat_ca patca  ");
		sb.append(" on patca.id_patca=pat.id_paticate  ");
		sb.append(" left join ci_mr_fp fp  ");
		sb.append(" on fp.id_ent = ee.id_ent ");
		sb.append(sqlwhere);
		sb.append(" order by ee.dt_end desc  ");
		
		PagingRtnData<MrQueryDTO> pagingRtnData = super.findByPageInfo(new MrQueryDTO(), paginationInfo, sb.toString(), "", null);
		FArrayList pageData = pagingRtnData.getPageData();
		if(pageData!=null && pageData.size()>0){
			for(Object obj :pageData){
				MrQueryDTO mrquerydto = (MrQueryDTO)obj;
				String id_ent=mrquerydto.getId_ent();
				boolean flag=isHaveMrFp(id_ent);
				if(flag){
					mrquerydto.setIs_have_mrfp("有");
				}else{
					mrquerydto.setIs_have_mrfp("无");
				}
				boolean flag2=completeRecall(id_ent);
				if(flag2){
					mrquerydto.setComplete_write_recall("是");
				}else{
					mrquerydto.setComplete_write_recall("否");
				}
				boolean flag3=mrInhospitalRecall(id_ent);
				if(flag3){
					mrquerydto.setHospital_mr_recall("是");
				}else{
					mrquerydto.setHospital_mr_recall("否");
				}
			}
		}
		return pagingRtnData;
	}

	// 有无病案首页
	public boolean isHaveMrFp(String id_ent)  throws BizException{
		DAFacade da = new DAFacade();
		StringBuilder sb=new StringBuilder();
		sb.append("select count(1) from ci_mr_fp where id_ent='"+id_ent+"' and ds='0' ");
		int count = (int) da.execQuery(sb.toString(),new ColumnHandler() );
		if(count >=1) return true;
		else return false;
	}
	
	// 完成书写召回
	public boolean completeRecall(String id_ent)  throws BizException{
		DAFacade da = new DAFacade();
		StringBuilder sb=new StringBuilder();
		sb.append("select count(1) from ci_recall_apply where id_ent='"+id_ent+"' and ds='0' ");
		int count = (int) da.execQuery(sb.toString(),new ColumnHandler() );
		if(count >=1) return true;
		else return false;
	}
	
	// 住院病案召回
	public boolean mrInhospitalRecall(String id_ent)  throws BizException{
		DAFacade da = new DAFacade();
		StringBuilder sb=new StringBuilder();
		sb.append("select count(1) from ci_mr_recall where id_ent='"+id_ent+"' and ds='0' ");
		int count = (int) da.execQuery(sb.toString(),new ColumnHandler() );
		if(count >=1) return true;
		else return false;
	}
}
