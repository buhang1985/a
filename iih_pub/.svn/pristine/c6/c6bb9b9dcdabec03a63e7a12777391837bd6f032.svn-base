package iih.mi.mibd.didircomp.i;

import iih.mi.mibd.didircomp.d.DiDirCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * @ClassName: IDidircompExtRService
 * @Description: 医保平台_病种对照扩展服务
 * @author: dj.zhang
 * @date: 2018年2月5日 下午6:05:28
 */
public interface IDidircompExtRService {

	/**
	 * @Title: findCompDataList
	 * @Description: 病种目录对照列表查询
	 * @param qryRootNodeDTO
	 * @param misId
	 * @param pg
	 * @return PagingRtnData<DidircompDTO>
	 * @throws BizException
	 */
	public abstract PagingRtnData<DiDirCompDTO> findCompDataList(QryRootNodeDTO qryRootNodeDTO, String misId,
			PaginationInfo pg) throws BizException;
}