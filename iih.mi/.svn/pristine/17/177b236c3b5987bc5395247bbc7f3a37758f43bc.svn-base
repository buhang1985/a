package iih.mi.mibd.drug.s;

import iih.mi.mibd.drug.d.DrugDO;
import iih.mi.mibd.drug.i.IDrugExtRService;
import iih.mi.mibd.drug.s.bp.FindPagingByMisAndQCondBp;
import iih.mi.mibd.mis.d.MisDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/** 
 * @ClassName: DrugExtCrudServiceImpl 
 * @Description: 药品扩展服务
 * @author:  hexx
 * @date: 2018年2月6日 上午9:00:44  
 */
public class DrugExtCrudServiceImpl implements IDrugExtRService {

	@Override
	public PagingRtnData<DrugDO> FindPagingByMisAndQCond(MisDO mis, QryRootNodeDTO qryRootNodeDto, String orderStr,
			PaginationInfo pg) throws BizException {
		FindPagingByMisAndQCondBp bp = new FindPagingByMisAndQCondBp();
		PagingRtnData<DrugDO> result = bp.exec(mis, qryRootNodeDto, orderStr, pg);
		return result;
	}

}
