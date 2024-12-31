package iih.ci.ord.s.ems.copy.op.copyopen;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.copy.dto.OrderCopyDTO;
import iih.ci.ord.copy.dto.RisCopyDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检验复制开立逻辑
 * @author zhangwq
 *
 */
public class RisCopyBP extends BaseCopyOpenBP {
	
	/**
	 * 保存数据
	 */
	@Override
	protected void save() throws BizException {
		super.save();
		Set<String> keys = this.getOrdCopyMap().keySet();
		List<OrdApObsDO> newObsdos = new ArrayList<OrdApObsDO>();
		for (String sourceIdOr : keys) {
			RisCopyDTO lisCopyDTO  = (RisCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
			newObsdos.add(lisCopyDTO.getOrdApLabDO());
		}
		ICiorapprisCudService service = ServiceFinder.find(ICiorapprisCudService.class);
		service.save(newObsdos.toArray(new OrdApObsDO[0]));
	}
	/**
	 * 复制申请单数据
	 */
	@Override
	protected void copyApSheet() throws BizException {
		String[] id_ors = this.getOrdCopyMap().keySet().toArray(new String[0]);
		ICiorapprisRService service = ServiceFinder.find(ICiorapprisRService.class);
		OrdApObsDO[] ordApObss = service.findByAttrValStrings(OrdApObsDO.ID_OR, id_ors);
		if(ordApObss == null || ordApObss.length ==0){
			return;
		}
		for (OrdApObsDO ordApObsDO : ordApObss) {
			OrdApObsDO copydo = (OrdApObsDO)ordApObsDO.clone();
			RisCopyDTO lisCopyDTO  = (RisCopyDTO)this.getOrdCopyMap().get(ordApObsDO.getId_or());
			copydo.setStatus(DOStatus.NEW);
			copydo.setId_or(lisCopyDTO.getCiOrderDO().getId_or());
			copydo.setId_orobs(null);
			
			lisCopyDTO.setOrdApObsDO(copydo);
		}
	}
	@Override
	protected OrderCopyDTO createOrdCopyDTO() {
		return new RisCopyDTO();
	}

}
