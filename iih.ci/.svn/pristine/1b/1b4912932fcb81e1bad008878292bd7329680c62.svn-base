package iih.ci.ord.s.ems.copy.op.copyopen;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.cior.i.ICiorappbtCudService;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.copy.dto.BtCopyDTO;
import iih.ci.ord.copy.dto.OrderCopyDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 检验复制开立逻辑
 * @author zhangwq
 *
 */
public class BtCopyBP extends BaseCopyOpenBP {
	
	/**
	 * 保存数据
	 */
	@Override
	protected void save() throws BizException {
		super.save();
		Set<String> keys = this.getOrdCopyMap().keySet();
		List<CiorappbtAggDO> newdos = new ArrayList<CiorappbtAggDO>();
		for (String sourceIdOr : keys) {
			BtCopyDTO copydto  = (BtCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
			newdos.add(copydto.getCiorappbtAggDO());
		}
		ICiorappbtCudService service = ServiceFinder.find(ICiorappbtCudService.class);
		service.save(newdos.toArray(new CiorappbtAggDO[0]));
	}
	/**
	 * 复制申请单数据
	 */
	@Override
	protected void copyApSheet() throws BizException {
		String[] id_ors = this.getOrdCopyMap().keySet().toArray(new String[0]);
		ICiorappbtRService service = ServiceFinder.find(ICiorappbtRService.class);
		CiorappbtAggDO[] aggs = service.findByAttrValStrings(OrdApBtDO.ID_OR, id_ors);
		if(aggs == null || aggs.length ==0){
			return;
		}
		String[] id_bts = new DBUtil().getOIDs(aggs.length);
		int index = 0;

		for (CiorappbtAggDO agg : aggs) {
			CiorappbtAggDO copyAggdo = (CiorappbtAggDO)agg.clone();
			BtCopyDTO btCopyDTO  = (BtCopyDTO)this.getOrdCopyMap().get(agg.getParentDO().getId_or());
			copyAggdo.getParentDO().setStatus(DOStatus.NEW);
			copyAggdo.getParentDO().setId_or(btCopyDTO.getCiOrderDO().getId_or());
			copyAggdo.getParentDO().setId_apbt(id_bts[index++]);
			
			OrdApBtViewItemDO[] items  = copyAggdo.getOrdApBtViewItemDO();
			if(items != null && items.length >0){
				for (OrdApBtViewItemDO ordApBtViewItemDO : items) {
					ordApBtViewItemDO.setStatus(DOStatus.NEW);
					ordApBtViewItemDO.setId_apbt(copyAggdo.getParentDO().getId_or());
					
					ordApBtViewItemDO.setId_apbtobsindex(null);
					
				}
			}
			btCopyDTO.setCiorappbtAggDO(copyAggdo);
		}
	}
	@Override
	protected OrderCopyDTO createOrdCopyDTO() {
		return new BtCopyDTO();
	}

}
