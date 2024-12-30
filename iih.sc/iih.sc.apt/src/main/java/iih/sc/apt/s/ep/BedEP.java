package iih.sc.apt.s.ep;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDOCudService;
import iih.bd.res.bed.i.IBedMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 床位EP
 * @author fanlq
 *
 */
public class BedEP {

	/***
	 * 获取床位DO
	 * @param id_bed 床位id
	 * @return
	 * @throws BizException
	 */
	public Bdbed findBed(String id_bed) throws BizException {
		IBedMDORService bedservice = ServiceFinder.find(IBedMDORService.class);
		return bedservice.findById(id_bed);
	}
	/**
	 * 保存床位信息
	 * 
	 * @param beds 床位数组
	 * @return
	 * @throws BizException
	 */
	public Bdbed[] saveBed(Bdbed[] beds) throws BizException {
		IBedMDOCudService bedCudService = ServiceFinder.find(IBedMDOCudService.class);
		beds = bedCudService.save(beds);
		return beds;
	}
}
