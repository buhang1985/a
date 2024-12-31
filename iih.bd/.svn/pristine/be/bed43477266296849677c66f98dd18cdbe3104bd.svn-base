package iih.bd.srv.medsrv.s.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 停用医疗服务业务逻辑
 * 
 * @author hao_wu
 * @author hao_wu 2018-5-22 停用医疗服务调用基础服务，解决门诊医生站缓存不更新的bug
 *
 */
public class DisableMedSrvBp {

	public MedSrvDO[] exec(MedSrvDO[] medSrvArr) throws BizException {
		if (medSrvArr == null || medSrvArr.length <= 0) {
			return null;
		}

		MedSrvDO[] result = DisableMedSrv(medSrvArr);
		return result;
	}

	/**
	 * 停用医疗服务
	 * 
	 * @param medSrvDOs
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] DisableMedSrv(MedSrvDO[] medSrvArr) throws BizException {
		for (MedSrvDO medSrvDO : medSrvArr) {
			medSrvDO.setFg_active(FBoolean.FALSE);
			medSrvDO.setStatus(DOStatus.UPDATED);
		}
		IMedsrvMDOCudService medsrvMDOCudService = ServiceFinder.find(IMedsrvMDOCudService.class);
		MedSrvDO[] result = medsrvMDOCudService.update(medSrvArr);
		return result;
	}
}
