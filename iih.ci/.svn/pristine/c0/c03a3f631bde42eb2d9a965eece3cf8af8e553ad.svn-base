package iih.ci.ord.s.ems.copy.op.copyopen;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.d.OrdApPathgySampDO;
import iih.ci.ord.cior.i.ICiorapppathgyCudService;
import iih.ci.ord.cior.i.ICiorapppathgyRService;
import iih.ci.ord.copy.dto.OrderCopyDTO;
import iih.ci.ord.copy.dto.PathgyCopyDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 病理复制开立逻辑
 * @author zhangwq
 *
 */
public class PathgyCopyBP extends BaseCopyOpenBP {
	
	/**
	 * 保存数据
	 */
	@Override
	protected void save() throws BizException {
		super.save();
		Set<String> keys = this.getOrdCopyMap().keySet();
		List<CiorapppathgyAggDO> newdos = new ArrayList<CiorapppathgyAggDO>();
		for (String sourceIdOr : keys) {
			PathgyCopyDTO lisCopyDTO  = (PathgyCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
			newdos.add(lisCopyDTO.getCiorapppathgyAggDO());
		}
		ICiorapppathgyCudService service = ServiceFinder.find(ICiorapppathgyCudService.class);
		service.save(newdos.toArray(new CiorapppathgyAggDO[0]));
	}
	/**
	 * 复制申请单数据
	 */
	@Override
	protected void copyApSheet() throws BizException {
		String[] id_ors = this.getOrdCopyMap().keySet().toArray(new String[0]);
		ICiorapppathgyRService service = ServiceFinder.find(ICiorapppathgyRService.class);
		CiorapppathgyAggDO[] pathgyAggs = service.findByAttrValStrings(OrdApPathgyDO.ID_OR, id_ors);
		if(pathgyAggs == null || pathgyAggs.length ==0){
			return;
		}
		String[] id_appathgys = new DBUtil().getOIDs(pathgyAggs.length);
		int index = 0;
		for (CiorapppathgyAggDO pathgyAggDO : pathgyAggs) {
			CiorapppathgyAggDO copydo = (CiorapppathgyAggDO)pathgyAggDO.clone();
			PathgyCopyDTO pathgyCopyDTO  = (PathgyCopyDTO)this.getOrdCopyMap().get(pathgyAggDO.getParentDO().getId_or());
			copydo.getParentDO().setStatus(DOStatus.NEW);
			copydo.getParentDO().setId_or(pathgyCopyDTO.getCiOrderDO().getId_or());
			copydo.getParentDO().setId_appathgy(id_appathgys[index++]);
			
			OrdApPathgySampDO[] copySampDOs =  copydo.getOrdApPathgySampDO();
			if(copySampDOs != null && copySampDOs.length > 0){
				for (OrdApPathgySampDO ordApPathgySampDO : copySampDOs) {
					ordApPathgySampDO.setStatus(DOStatus.NEW);
					ordApPathgySampDO.setId_appathgy(copydo.getParentDO().getId_appathgy());
					ordApPathgySampDO.setId_appathgysamp(null);
				}
			}
			
			pathgyCopyDTO.setCiorapppathgyAggDO(copydo);
		}
	}
	@Override
	protected OrderCopyDTO createOrdCopyDTO() {
		return new PathgyCopyDTO();
	}

}
