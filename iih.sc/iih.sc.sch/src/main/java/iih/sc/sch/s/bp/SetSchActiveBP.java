package iih.sc.sch.s.bp;

import iih.sc.sch.dto.d.MtSchMgrDTO;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 停用或者启用排班数据
 * 
 * @author
 * 
 */
public class SetSchActiveBP {

	/**
	 * 停用或者启用排班数据
	 * 
	 * @param mtschMgrDTO
	 * @throws BizException
	 */
	public void exec(MtSchMgrDTO mtschMgrDTO) throws BizException {
		SchEP sep = new SchEP();
		ScSchDO scSchDO = sep.getById(mtschMgrDTO.getId_sch());
		if (scSchDO != null) {
			scSchDO.setFg_active(mtschMgrDTO.getFg_active());
			IScschMDOCudService cudService = ServiceFinder.find(IScschMDOCudService.class);
			scSchDO.setStatus(DOStatus.UPDATED);
			cudService.save(new ScSchDO[] { scSchDO });
		}

	}

}
