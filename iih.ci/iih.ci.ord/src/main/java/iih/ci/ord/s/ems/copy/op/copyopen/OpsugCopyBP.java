package iih.ci.ord.s.ems.copy.op.copyopen;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.cior.d.OrdOpEmpDO;
import iih.ci.ord.cior.d.OrdOpMmDO;
import iih.ci.ord.cior.i.ICiorappsurgeryCudService;
import iih.ci.ord.cior.i.ICiorappsurgeryRService;
import iih.ci.ord.copy.dto.OpSugCopyDTO;
import iih.ci.ord.copy.dto.OrderCopyDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 手术复制开立逻辑
 * @author zhangwq
 *
 */
public class OpsugCopyBP extends BaseCopyOpenBP {
	
	/**
	 * 保存数据
	 */
	@Override
	protected void save() throws BizException {
		super.save();
		Set<String> keys = this.getOrdCopyMap().keySet();
		List<CiorappsurgeryAggDO> newdos = new ArrayList<CiorappsurgeryAggDO>();
		for (String sourceIdOr : keys) {
			OpSugCopyDTO lisCopyDTO  = (OpSugCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
			newdos.add(lisCopyDTO.getCiorappsurgeryAggDO());
		}
		ICiorappsurgeryCudService service = ServiceFinder.find(ICiorappsurgeryCudService.class);
		service.save(newdos.toArray(new CiorappsurgeryAggDO[0]));
	}
	/**
	 * 复制申请单数据
	 */
	@Override
	protected void copyApSheet() throws BizException {
		String[] id_ors = this.getOrdCopyMap().keySet().toArray(new String[0]);
		ICiorappsurgeryRService service = ServiceFinder.find(ICiorappsurgeryRService.class);
		CiorappsurgeryAggDO[] apdos = service.findByAttrValStrings(OrdApOpDO.ID_OR, id_ors);
		if(apdos == null || apdos.length ==0){
			return;
		}
		String[] id_sugs = new DBUtil().getOIDs(apdos.length);
		int index = 0;
		for (CiorappsurgeryAggDO agg : apdos) {
			CiorappsurgeryAggDO copyAggdo = (CiorappsurgeryAggDO)agg.clone();
			OpSugCopyDTO copydto  = (OpSugCopyDTO)this.getOrdCopyMap().get(agg.getParentDO().getId_or());
			
			copyAggdo.getParentDO().setStatus(DOStatus.NEW);
			copyAggdo.getParentDO().setId_or(copydto.getCiOrderDO().getId_or());
			copyAggdo.getParentDO().setId_apop(id_sugs[index++]);
			
			//手术人员
			OrdOpEmpDO[] ordOpEmps = copyAggdo.getOrdOpEmpDO();
			if(ordOpEmps != null &&ordOpEmps.length >0){
				for (OrdOpEmpDO ordOpEmpDO : ordOpEmps) {
					ordOpEmpDO.setStatus(DOStatus.NEW);
					ordOpEmpDO.setId_apop(copyAggdo.getParentDO().getId_apop());
					
					ordOpEmpDO.setId_apopemp(null);
				}
			}
			//动态指标
			OrdApSugViewItemDO[] viewItems = copyAggdo.getOrdApSugViewItemDO();
			if(viewItems != null &&viewItems.length >0){
				for (OrdApSugViewItemDO item : viewItems) {
					item.setStatus(DOStatus.NEW);
					item.setId_apop(copyAggdo.getParentDO().getId_apop());
					
					item.setId_apopobsindex(null);
				}
			}
			//卫材
			OrdOpMmDO[] ordOpMmDOs = copyAggdo.getOrdOpMmDO();
			if(ordOpMmDOs != null &&ordOpMmDOs.length >0){
				for (OrdOpMmDO opmm : ordOpMmDOs) {
					opmm.setStatus(DOStatus.NEW);
					opmm.setId_apop(copyAggdo.getParentDO().getId_apop());
					
					opmm.setId_apopmm(null);
				}
			}
			//二次手术申请
			copyAggdo.setOrdApOpAgainDO(null);
			
			copydto.setCiorappsurgeryAggDO(copyAggdo);
		}
	}
	@Override
	protected OrderCopyDTO createOrdCopyDTO() {
		return new OpSugCopyDTO();
	}

}
