package iih.ci.ord.s.ems.copy.op.copyopen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.i.ICiorapplisCudService;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.copy.dto.DrugCopyDTO;
import iih.ci.ord.copy.dto.LisCopyDTO;
import iih.ci.ord.copy.dto.OrderCopyDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检验复制开立逻辑
 * @author zhangwq
 *
 */
public class LisCopyBP extends BaseCopyOpenBP {
	
	/**
	 * 保存数据
	 */
	@Override
	protected void save() throws BizException {
		super.save();
		Set<String> keys = this.getOrdCopyMap().keySet();
		List<OrdApLabDO> newLabdos = new ArrayList<OrdApLabDO>();
		for (String sourceIdOr : keys) {
			LisCopyDTO lisCopyDTO  = (LisCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
			newLabdos.add(lisCopyDTO.getOrdApLabDO());
		}
		ICiorapplisCudService service = ServiceFinder.find(ICiorapplisCudService.class);
		service.save(newLabdos.toArray(new OrdApLabDO[0]));
	}
	/**
	 * 复制申请单数据
	 */
	@Override
	protected void copyApSheet() throws BizException {
		String[] id_ors = this.getOrdCopyMap().keySet().toArray(new String[0]);
		ICiorapplisRService service = ServiceFinder.find(ICiorapplisRService.class);
		OrdApLabDO[] ordApLabs = service.findByAttrValStrings(OrdApLabDO.ID_OR, id_ors);
		if(ordApLabs == null || ordApLabs.length ==0){
			return;
		}
		for (OrdApLabDO ordApLabDO : ordApLabs) {
			OrdApLabDO copydo = (OrdApLabDO)ordApLabDO.clone();
			LisCopyDTO lisCopyDTO  = (LisCopyDTO)this.getOrdCopyMap().get(ordApLabDO.getId_or());
			copydo.setStatus(DOStatus.NEW);
			copydo.setId_or(lisCopyDTO.getCiOrderDO().getId_or());
			copydo.setId_orlab(null);
			
			lisCopyDTO.setOrdApLabDO(copydo);
		}
	}
	@Override
	protected OrderCopyDTO createOrdCopyDTO() {
		return new LisCopyDTO();
	}

}
