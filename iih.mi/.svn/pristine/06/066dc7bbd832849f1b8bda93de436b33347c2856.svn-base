package iih.mi.mibd.didircomp.s.bp;

import org.apache.commons.lang.StringUtils;
import iih.mi.mibd.didircomp.d.DiDirCompDTO;
import iih.mi.mibd.didircomp.s.bp.sql.FindDiCompsql;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/** 
 * @ClassName: FindDiCompBp 
 * @Description: 病种对照查询
 * @author: dj.zhang
 * @date: 2018年2月6日 上午8:56:19  
 */
public class FindDiCompBp {

	public PagingRtnData<DiDirCompDTO> exec(QryRootNodeDTO qryRootNodeDTO, String misId, PaginationInfo pg)
	throws BizException{
		String wherePart = getWherePart(qryRootNodeDTO);
		FindDiCompsql sql = new FindDiCompsql(misId,wherePart);
		PagingServiceImpl<DiDirCompDTO> pagingServiceImpl = new PagingServiceImpl<>();
		PagingRtnData<DiDirCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new DiDirCompDTO(), pg, sql.getQrySQLStr(),"EU_STATUS DESC,CODE", sql.getQryParameter(null));
		return pagingRtnData;
	}

	/**  
	* @Title: getWherePart  
	* @Description: 生成查询方案
	* @param qryRootNodeDTO
	* @return
	* @throws BizException   
	*/  
	public String getWherePart(QryRootNodeDTO qryRootNodeDTO) throws BizException {

		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDTO);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append("AND");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

}
