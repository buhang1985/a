package iih.pi.acc.s;

import iih.pi.acc.dto.d.PiPrepayQryDTO;
import iih.pi.acc.i.IPIAccQryService;
import iih.pi.acc.s.bp.GetPrePayListBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 患者账户查询服务
 * @author zhangxin
 * @date 2019年4月30日
 *
 */
public class IPIAccQryServiceImpl implements IPIAccQryService {
    /**
     * 收取预交金记录
     * @throws BizException 
     */
	@Override
	public PagingRtnData<PiPrepayQryDTO> getPrePayList(QryRootNodeDTO qryRoot,PaginationInfo pg) throws BizException {
		GetPrePayListBP bp = new GetPrePayListBP();
		return bp.exec(qryRoot, pg);
	}

}
