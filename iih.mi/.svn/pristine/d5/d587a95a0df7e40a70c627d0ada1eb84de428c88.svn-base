package iih.mi.mibd.treat.s;

import iih.mi.mibd.mis.d.MisDO;
import iih.mi.mibd.treat.d.TreatDO;
import iih.mi.mibd.treat.i.ITreatExtRService;
import iih.mi.mibd.treat.s.bp.FindPagingByMisAndQCondBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * @ClassName: TreatExtCrudServiceImpl
 * @Description: 医保平台_诊疗项目AggDO数据扩展服务实现
 * @author: dj.zhang
 * @date: 2018年1月31日 上午11:00:41
 */
public class TreatExtCrudServiceImpl implements ITreatExtRService {

	@Override
	public PagingRtnData<TreatDO> FindPagingByMisAndQCond(MisDO mis, QryRootNodeDTO qryRootNodeDto, String orderStr,
			PaginationInfo pg) throws BizException {
		FindPagingByMisAndQCondBp bp = new FindPagingByMisAndQCondBp();
		PagingRtnData<TreatDO> result = bp.exec(mis, qryRootNodeDto, orderStr, pg);
		return result;
	}

}
