package iih.bd.pp.accountsubject.s.bp;

import com.mysql.jdbc.StringUtils;

import iih.bd.pp.dto.d.UnComparSrvOnAccDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 核算分类查询医疗服务数据
 * @author shao_yuan
 *
 */
public class GetUnComparSrvOnAccListBp {
	/** 
	 * 查询医疗服务数据
	 * @param accountSubjectDO
	 * @param accountSrvDTO
	 */
	public PagingRtnData<MedSrvDO> exec(PaginationInfo pg, QryRootNodeDTO qryRootNodeDtoArr, UnComparSrvOnAccDTO srvOnaccSubDo) throws BizException {
		String sb = SetQryString(qryRootNodeDtoArr,srvOnaccSubDo);
		
		PagingServiceImpl<MedSrvDO> pagingServiceImpl = new PagingServiceImpl<MedSrvDO>();
		return pagingServiceImpl.findByPageInfo(new MedSrvDO(), pg, sb, "ID_SRVCA", null);
	}
	/** 
	 * 组装查询条件
	 * @param qryRootNodeDTO
	 * @param srvOnaccSubDo
	 */
	private String SetQryString(QryRootNodeDTO qryRootNodeDTO,
			UnComparSrvOnAccDTO srvOnaccSubDo) throws BizException {
		StringBuffer sb = new StringBuffer();
		sb.append(" select *  ");
		sb.append("  	from bd_srv a ");
		sb.append(" where  ");
		sb.append("   	a.id_srv not in (select a.id_srv from bd_account_ca_vs_srv a  ");
		sb.append(" where a.id_account = '"+srvOnaccSubDo.getId_account()+"'  ");
		sb.append(" )  ");
		sb.append("   AND a.id_srvca = '"+srvOnaccSubDo.getId_srvca()+"' ");
		sb.append(" and a.ds = 0  ");
		sb.append(" and a.sd_primd in ('00','04') ");//本服务定价和对应物品价格
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String qryCond="" ;
 		if (qryRootNodeDTO!=null){
 			qryCond = service.getQueryStringWithoutDesc(qryRootNodeDTO); 			 
 		}
 		if (!StringUtils.isNullOrEmpty(qryCond))
 			sb.append(" AND "+qryCond);
//		if(qryRootNodeDtoArr != null && qryRootNodeDtoArr.length > 0){
//			IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
//			for(int i = 0; i < qryRootNodeDtoArr.length; i++){
//				if(qryRootNodeDtoArr[i] == null)
//					break;
//				String whereStr = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDtoArr[i]);
//				if(!StringUtil.isEmptyWithTrim(whereStr)){
//					whereStr = whereStr.substring(0, whereStr.length());
//					if(whereStr.contains("id_srv"))
//						sb.append(" AND srv."+whereStr);
//				}
//			}
//		}	
		return sb.toString();
	}

}
