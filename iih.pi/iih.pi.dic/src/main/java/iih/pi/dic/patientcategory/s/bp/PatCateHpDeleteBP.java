package iih.pi.dic.patientcategory.s.bp;

import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpCudService;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者分类医保计划删除逻辑类
 * @author ly 2017/06/25
 *
 */
public class PatCateHpDeleteBP {

	/**
	 * 患者分类医保计划删除
	 * @param patCaDo
	 * @throws BizException
	 */
	public void exec(PiPatCaDO patCaDo) throws BizException{
		
		IPatcatehpCudService cudService = ServiceFinder.find(IPatcatehpCudService.class);
		IPatcatehpRService rService = ServiceFinder.find(IPatcatehpRService.class);
		
		PiPatCaHpDO caHpDo = rService.findById(patCaDo.getId_patcahp());
		if(caHpDo == null)
			return;
		
		caHpDo.setStatus(DOStatus.DELETED);
		cudService.delete(new PiPatCaHpDO[]{caHpDo});
	}
}
