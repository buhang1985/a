package iih.bd.pp.baseprisrv.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.DoUtils;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 停用基础价格服务
 * 
 * @author hao_wu 2019-8-20
 *
 */
public class DisableBasePriSrvBp {

	public PriSrvDO[] exec(PriSrvDO[] priSrvDos) throws BizException {
		String[] srvIds = DoUtils.getAttrValArr(priSrvDos, PriSrvDO.ID_SRV, String.class);
		if (ArrayUtils.isEmpty(srvIds)) {
			return priSrvDos;
		}
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medSrvDos = medsrvMDORService.findByIds(srvIds, FBoolean.FALSE);

		for (MedSrvDO medSrvDO : medSrvDos) {
			medSrvDO.setFg_active_bl(FBoolean.FALSE);
			medSrvDO.setStatus(DOStatus.UPDATED);
		}
		IMedsrvMDOCudService medsrvMDOCudService = ServiceFinder.find(IMedsrvMDOCudService.class);
		medSrvDos = medsrvMDOCudService.update(medSrvDos);

		for (int i = 0; i < priSrvDos.length; i++) {

			PriSrvDO priSrvDo = priSrvDos[i];
			MedSrvDO medSrvDo = medSrvDos[i];

			priSrvDo.setFg_active(medSrvDo.getFg_active_bl());
			priSrvDo.setModifiedby(medSrvDo.getModifiedby());
			priSrvDo.setModifiedtime(medSrvDo.getModifiedtime());
			priSrvDo.setSv(medSrvDo.getSv());
		}

		fireEvent(medSrvDos);

		return priSrvDos;
	}

	/**
	 * 发送事件
	 * 
	 * @param medSrvDos
	 * @throws BizException
	 */
	private void fireEvent(MedSrvDO[] medSrvDos) throws BizException {
		BasePriSrvEventHandler eventHandler = new BasePriSrvEventHandler();
		eventHandler.fireEvent(medSrvDos, IEventType.TYPE_DELETE_AFTER);
	}
}
