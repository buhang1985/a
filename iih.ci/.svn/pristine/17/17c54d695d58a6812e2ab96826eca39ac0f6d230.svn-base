package iih.ci.mr.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import iih.ci.mr.d.MrTplUsageRateDTO;
import iih.ci.mr.i.IMrTplUsageRateService;

@Service(serviceInterfaces = { IMrTplUsageRateService.class }, binding = Binding.JSONRPC)
public class IMrTplUsageRateServiceImpl extends PagingServiceImpl<MrTplUsageRateDTO> implements IMrTplUsageRateService {

	 /**
	  * 通过查询方案获取数据
	  */
    public PagingRtnData<MrTplUsageRateDTO> getMrTplUsageRateDTO(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException{
   	 
   		
   	 		String sqlwhere = getWhereSql(qryRootNodeDTO);//where条件
   	 		StringBuilder sql = new StringBuilder();
   	 	
   	 	sql.append("select Name_template,Count_usage, Count_total,");
   	 	sql.append("to_char(Rate_usage,'990.99')||'%' as Rate_usage,");
        sql.append("Name_entp, Name_doctype,Name_dep,Name_mrtp_create,id_owtp,id_entp,id_dep");	
   	    
        sql.append(" from (select Name_template,");
   	 	sql.append("Count_usage,");
   	    sql.append("Count_total,");
   	    sql.append("cast(cast(Count_usage as float) * 100 / Count_total as number(10, 2)) as Rate_usage,");
   	    sql.append("Name_entp,");//就诊类型
   	    sql.append("Name_doctype,");//模板分类
   	    sql.append("Name_dep, Name_mrtp_create,id_owtp,id_entp,id_dep");
   	    sql.append(" from (select tpl.name as Name_template,");
		sql.append(" count(mr2.id_mrtpl) as Count_usage,");
		sql.append(" (select count(mr0.id_mr) from ci_mr mr0 , bd_mrca_ctm ctm0");
		sql.append(" where ctm0.id_mrcactm = mr0.id_mrcactm and  ctm0.docornur in ('10', '30')");
		sql.append(" and mr0.code_entp = mr2.code_entp ) as Count_total,");
		sql.append(" entp.name as Name_entp,doc.name as Name_doctype,entp.id_entp as id_entp,");
		sql.append(" tpl.id_owtp as id_owtp,dep.name as Name_dep,tpl.createdby,");
		sql.append(" sys_user.name as Name_mrtp_create,tpl.id_dept as id_dep");
		sql.append(" from (select mr.id_mrtpl,mr.code_entp,ctm.docornur from ci_mr mr , bd_mrca_ctm ctm");
		sql.append(" where ctm.id_mrcactm = mr.id_mrcactm and  ctm.docornur in ('10', '30')) mr2");
		sql.append(" left join bd_mrtpl tpl on mr2.id_mrtpl = tpl.id_mrtpl");
		sql.append(" left join bd_entp entp on mr2.code_entp = entp.code");
		sql.append(" left join bd_udidoc doc on tpl.id_owtp = doc.id_udidoc");
		sql.append(" left join bd_dep dep on dep.id_dep = tpl.id_dept");
		sql.append(" left join sys_user sys_user on sys_user.id_user = tpl.createdby");
		
		sql.append(" where tpl.id_org = '" + Context.get().getOrgId() +"'");// 登录人（集团组织）身份过滤
		
		sql.append(" group by mr2.id_mrtpl,tpl.name,mr2.code_entp,entp.name,");
		sql.append(" doc.name,entp.id_entp,tpl.id_owtp,dep.name,tpl.createdby,");
		sql.append(" sys_user.name, tpl.id_dept,mr2.docornur ))");
   	 	sql.append(sqlwhere);
   	 	String sqlStr=sql.toString();
   		PagingRtnData<MrTplUsageRateDTO> pagingRtnData = super.findByPageInfo(new MrTplUsageRateDTO(), paginationInfo, sqlStr, "", null);

   		return pagingRtnData;
   	 
    }
    
    /**
     * 获得where条件
     */
    private String getWhereSql(QryRootNodeDTO qryRootNodeDTO) throws BizException {
    	
    	IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
    	
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append(" where 1=1 ");
    	
		if (qryRootNodeDTO!=null){
	 			sb.append(" and " + service.getQueryStringWithoutDesc(qryRootNodeDTO));
	 	}
		
		String sqlwhere = sb.toString();
		return sqlwhere;
		
    }

}
