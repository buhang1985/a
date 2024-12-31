package iih.bd.srv.reportcardtpl.i;

import iih.bd.srv.reportcardtpldto.d.Reportcardtpldto;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;


/**
 * @author wang.yulong
 * 报卡模板Dto查询相关服务
 */
public interface IReportcardtpldtoCurdService {

	/**
	 * @param reportCardTplId 报卡模板Id
	 * @param pageInx 页号
	 * @return
	 * @throws BizException 
	 */
	Reportcardtpldto[] findTplDtos(String reportCardTplId, int pageInx) throws BizException;
	
	
	/**
	 * 适配框架，分页查询接口
	 * @param reportcardTypeId
	 * @param paginationInfo
	 * @return
	 * @throws BizException 
	 */
	PagingRtnData<Reportcardtpldto> findTplDtosByPageInfo(String reportcardTypeId,PaginationInfo paginationInfo) throws BizException;
}
