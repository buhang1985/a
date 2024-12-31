package iih.pi.acc.i;

import iih.pi.acc.dto.d.PiPrepayQryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 患者账户查询服务
 * @author zhangxin
 * @date 2019年4月30日
 */
public interface IPIAccQryService {
	/**
	 * 收取预交金记录
	 * @param qryRoot
	 * @return
	 */
    public  PagingRtnData<PiPrepayQryDTO> getPrePayList(QryRootNodeDTO qryRoot,PaginationInfo pg)  throws BizException;
}
