package iih.bd.srv.empphydto.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.empphydto.d.EmpphyDTO;
import iih.bd.srv.empphydto.s.bp.qry.FindEmpPhyDtoQry;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.bdfw.bbd.d.PsnDocDO;

/**
 * 查询医师信息DTO业务逻辑FindByQCondAndPageInfo
 * 
 * @author guoyang
 *
 */
public class GetEmpPhyDtoByQCondAndPageInfoBp {

	public PagingRtnData<EmpphyDTO> exec(QryRootNodeDTO qryRootNodeDTO, String condition, String orderStr, PaginationInfo pg)
			throws BizException {
		String wherePart = GetWherePart(qryRootNodeDTO, condition);
		FindEmpPhyDtoQry qry = new FindEmpPhyDtoQry(wherePart);
		PagingServiceImpl<EmpphyDTO> pagingServiceImpl = new PagingServiceImpl<EmpphyDTO>();
		return pagingServiceImpl.findByPageInfo(new EmpphyDTO(), pg, qry.getQrySQLStr(), orderStr, null);
	}

	/**
	 * 查询方案生成条件语句
	 * @param qryRootNodeDTO
	 * @param condition 
	 * @return
	 * @throws BizException 
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDTO, String condition) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithDOName(qryRootNodeDTO, PsnDocDO.class.getName());
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		if(StringUtils.isNotEmpty(condition)){
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(condition);
		}
		return wherePartBuilder.toString();
	}

}
