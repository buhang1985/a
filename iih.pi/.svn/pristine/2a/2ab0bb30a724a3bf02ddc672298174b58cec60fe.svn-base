package iih.pi.dic.patcate.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.pi.dic.patcate.d.PatCateUIDTO;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpCudService;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryCudService;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author dj.zhang
 *
 */
public class DeletePatCateUIDTOsBp {

	/**
	 * 执行
	 * 
	 * @param patCateUidto
	 * @throws BizException
	 */
	public void exec(PatCateUIDTO patCateUidto) throws BizException {
		if (patCateUidto == null) {
			throw new BizException("没有需要删除的数据。");
		}
		delete(patCateUidto);
	}

	/**
	 * 删除逻辑
	 * 
	 * @param patCateUidto
	 * @throws BizException
	 */
	private void delete(PatCateUIDTO patCateUidto) throws BizException {

		IPatientcategoryRService patientcategoryRService = ServiceFinder.find(IPatientcategoryRService.class);
		PiPatCaDO piPatCaDo = patientcategoryRService.findById(patCateUidto.getId_patca());
		if (piPatCaDo != null) {
			deletePiPatCaDO(piPatCaDo);
		}

		IPatcatehpRService patcatehpRService = ServiceFinder.find(IPatcatehpRService.class);
		PiPatCaHpDO piPatCaHpDo = patcatehpRService.findById(patCateUidto.getId_patcahp());
		if (piPatCaHpDo != null) {
			deletePiPatCaHpDO(piPatCaHpDo);
		}
	}

	/**
	 * 删除医保患者医保产品
	 * 
	 * @param piPatCaHpDO
	 * @throws BizException
	 */
	private void deletePiPatCaHpDO(PiPatCaHpDO piPatCaHpDO) throws BizException {
		List<PiPatCaHpDO> piPatCaHpDOs = new ArrayList<PiPatCaHpDO>(0);
		piPatCaHpDOs.add(piPatCaHpDO);
		IPatcatehpCudService patcatehpCudService = ServiceFinder.find(IPatcatehpCudService.class);
		patcatehpCudService.delete(piPatCaHpDOs.toArray(new PiPatCaHpDO[0]));
	}

	/**
	 * 删除医保患者
	 * 
	 * @param piPatCaDO
	 * @throws BizException
	 */
	private void deletePiPatCaDO(PiPatCaDO piPatCaDO) throws BizException {
		List<PiPatCaDO> piPatCaDOs = new ArrayList<PiPatCaDO>(0);
		piPatCaDOs.add(piPatCaDO);
		IPatientcategoryCudService patientcategoryCudService = ServiceFinder.find(IPatientcategoryCudService.class);
		patientcategoryCudService.delete(piPatCaDOs.toArray(new PiPatCaDO[0]));

	}

}
