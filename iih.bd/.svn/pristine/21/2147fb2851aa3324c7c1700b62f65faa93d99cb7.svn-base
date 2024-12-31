package iih.bd.mm.materialnames.s.bp.savebp;

import java.util.ArrayList;

import iih.bd.mm.materialnames.d.MnCodeSetDO;
import iih.bd.mm.materialnames.d.adapter.MnCodeSetDOAdapter;
import iih.bd.srv.medsrv.d.MedSrvCodeSetDO;
import iih.bd.srv.medsrv.i.IMedSrvCodeSetDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存药品通用名编码集业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveCodeSetDOsBp {

	public MnCodeSetDO[] exec(MnCodeSetDO[] mnCodeSetDOArray) throws BizException {
		if (null == mnCodeSetDOArray || mnCodeSetDOArray.length <= 0) {
			return null;
		}
		ArrayList<MedSrvCodeSetDO> list = new ArrayList<MedSrvCodeSetDO>();
		MnCodeSetDOAdapter adapter = new MnCodeSetDOAdapter();
		for (MnCodeSetDO mnCodeSetDO : mnCodeSetDOArray) {
			MedSrvCodeSetDO medSrvCodeSetDO = adapter.getMedSrvCodeSetDO(mnCodeSetDO);
			list.add(medSrvCodeSetDO);
		}

		IMedSrvCodeSetDOCudService medSrvCodeSetDOCudService = ServiceFinder.find(IMedSrvCodeSetDOCudService.class);
		MedSrvCodeSetDO[] rtn = medSrvCodeSetDOCudService.save(list.toArray(new MedSrvCodeSetDO[0]));

		MnCodeSetDO[] mnCodeSetDOList = adapter.getMnCodeSetDOs(rtn);
		return mnCodeSetDOList;
	}

}
