package iih.pi.dic.patcate.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.pi.dic.patcate.d.PatCateUIDTO;
import iih.pi.dic.patcate.s.bp.adapter.PiPatCaDOAdapter;
import iih.pi.dic.patcate.s.bp.adapter.PiPatCaHpDOAdapter;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpCudService;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryCudService;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author dj.zhang
 *
 */
public class SavePatCateUIDTOsBp {

	/**
	 * 执行
	 * 
	 * @param patCateUIDTO
	 * @return
	 * @throws BizException
	 */
	public PatCateUIDTO exec(PatCateUIDTO patCateUIDTO) throws BizException {
		if (patCateUIDTO == null) {
			throw new BizException("没有需要保存的数据。");
		}
		PatCateUIDTO result = save(patCateUIDTO);
		return result;
	}

	/**
	 * 保存逻辑
	 * 
	 * @param patCateUIDTO
	 * @return
	 * @throws BizException
	 */
	private PatCateUIDTO save(PatCateUIDTO patCateUIDTO) throws BizException {

		IPatientcategoryRService patientcategoryRService = ServiceFinder.find(IPatientcategoryRService.class);
		PiPatCaDO piPatCaDo = patientcategoryRService.findById(patCateUIDTO.getId_patca());
		PiPatCaDO piPatCaDO = ConvertDtoToPiPatCaDO(patCateUIDTO, piPatCaDo);
		PiPatCaDO savedPatca = savePiPatCaDO(piPatCaDO);

		IPatcatehpRService patcatehpRService = ServiceFinder.find(IPatcatehpRService.class);
		PiPatCaHpDO piPatCaHpDo = patcatehpRService.findById(patCateUIDTO.getId_patcahp());
		PiPatCaHpDO piPatCaHpDO = ConvertDtoToPiPatCaHpDO(patCateUIDTO, savedPatca, piPatCaHpDo);
		savePiPatCaHpDO(piPatCaHpDO);
		return patCateUIDTO;
	}

	/**
	 * 保存医保患者医保产品
	 * 
	 * @param piPatCaHpDO
	 * @throws BizException
	 */
	private void savePiPatCaHpDO(PiPatCaHpDO piPatCaHpDO) throws BizException {
		List<PiPatCaHpDO> piPatCaHpDOs = new ArrayList<PiPatCaHpDO>(0);
		piPatCaHpDOs.add(piPatCaHpDO);
		IPatcatehpCudService patcatehpCudService = ServiceFinder.find(IPatcatehpCudService.class);
		patcatehpCudService.save(piPatCaHpDOs.toArray(new PiPatCaHpDO[0]));

	}

	/**
	 * 保存医保患者
	 * 
	 * @param piPatCaDO
	 * @throws BizException
	 */
	private PiPatCaDO savePiPatCaDO(PiPatCaDO piPatCaDO) throws BizException {
		List<PiPatCaDO> piPatCaDOs = new ArrayList<PiPatCaDO>(0);
		piPatCaDOs.add(piPatCaDO);
		IPatientcategoryCudService patientcategoryCudService = ServiceFinder.find(IPatientcategoryCudService.class);
		PiPatCaDO[] result = patientcategoryCudService.save(piPatCaDOs.toArray(new PiPatCaDO[0]));
		return result[0];
	}

	/**
	 * 适配医保患者医保产品
	 * 
	 * @param patCateUIDTO
	 * @return
	 * @throws BizException
	 */
	private PiPatCaHpDO ConvertDtoToPiPatCaHpDO(PatCateUIDTO patCateUIDTO, PiPatCaDO patCaDO, PiPatCaHpDO piPatCaHpDo)
			throws BizException {
		PiPatCaHpDOAdapter adapter = new PiPatCaHpDOAdapter();
		PiPatCaHpDO piPatCaHpDO = adapter.getPiPatCaHpDO(patCateUIDTO, patCaDO, piPatCaHpDo);
		if (StringUtils.isNotEmpty(piPatCaHpDO.getId_patcahp())) {
			piPatCaHpDO.setStatus(DOStatus.UPDATED);
		} else {
			piPatCaHpDO.setStatus(DOStatus.NEW);
		}
		return piPatCaHpDO;
	}

	/**
	 * 适配医保患者
	 * 
	 * @param patCateUIDTO
	 * @return
	 * @throws BizException
	 */
	private PiPatCaDO ConvertDtoToPiPatCaDO(PatCateUIDTO patCateUIDTO, PiPatCaDO piPatCaDo) throws BizException {
		PiPatCaDOAdapter adapter = new PiPatCaDOAdapter();
		PiPatCaDO piPatCaDO = adapter.getPiPatCaDO(patCateUIDTO, piPatCaDo);
		if (StringUtils.isNotEmpty(piPatCaDO.getId_patca())) {
			piPatCaDO.setStatus(DOStatus.UPDATED);
		} else {
			piPatCaDO.setStatus(DOStatus.NEW);
		}
		return piPatCaDO;
	}

}
