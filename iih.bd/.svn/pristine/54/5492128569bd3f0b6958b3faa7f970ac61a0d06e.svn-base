package iih.bd.pp.accountsubject.s.bp;

import com.mysql.jdbc.StringUtils;

import iih.bd.pp.accountsubject.d.AccountSubjectDO;
import iih.bd.pp.dto.d.AccountSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 可维护核算分类和服务项目对照数据查询
 * @author shao_yuan
 *
 */
public class AccountSubjectBp {
	/** 
	 * 可维护核算分类和服务项目对照数据查询
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param accSubDo
	 */
	public PagingRtnData<AccountSrvDTO> findAccAndSrvList(PaginationInfo pg,
			QryRootNodeDTO qryRootNodeDTO, AccountSubjectDO accSubDo) throws BizException {
		String sb = SetQryString(qryRootNodeDTO,accSubDo);
		
		PagingServiceImpl<AccountSrvDTO> pagingServiceImpl = new PagingServiceImpl<AccountSrvDTO>();
		return pagingServiceImpl.findByPageInfo(new AccountSrvDTO(), pg, sb, "ID_SRVCA", null);
	}
	/** 
	 * 组装查询sql
	 * @param qryRootNodeDTO
	 * @param accSubDo
	 */
	private String SetQryString(QryRootNodeDTO qryRootNodeDTO,
			AccountSubjectDO accSubDo) throws BizException {
		StringBuffer sb = new StringBuffer();
		sb.append(" select b.NAME         name_srv,");
		sb.append("   	b.CODE         code_srv,");
		sb.append("  	a.id_srv ,");
		sb.append("  	b.id_srvca, ");
		sb.append("  	a.id_accavssrv id_accsrv, ");
		sb.append("  	c.NAME         name_srvca,");
		sb.append("  	c.CODE         code_srvca,");
		sb.append(" 	a.id_accountca Id_acc_ca, ");
		sb.append(" 	a.id_account Id_acc, ");
		sb.append(" 	d.CODE         code_ca, ");
		sb.append(" 	d.NAME         name_ca ");
		sb.append(" from bd_account_ca_vs_srv a, ");
		sb.append("  	 bd_srv        b, ");
		sb.append(" 	 bd_srvca      c, ");
		sb.append(" 	 bd_account_ca d ");
		sb.append(" WHERE a.ID_SRV = b.ID_SRV ");
		sb.append(" 	AND b.ID_SRVCA = c.ID_SRVCA ");
		sb.append("  	AND a.id_accountca = d.id_accountca ");
		if(accSubDo !=null)
			sb.append(" and a.id_accountca = '"+accSubDo.getId_accountca()+"' ");
		sb.append("  	AND a.DS = 0");
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String qryCond="" ;
 		if (qryRootNodeDTO!=null){
 			qryCond = service.getQueryStringWithoutDesc(qryRootNodeDTO); 			 
 		}
 		if (!StringUtils.isNullOrEmpty(qryCond))
 			sb.append(" AND "+qryCond);
 			
		return sb.toString();
	}

}
