package iih.bd.mm.materialnames.s.bp.deletebp;

import java.util.ArrayList;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.adapter.MaterialNamesDOAdapter;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据主Do删除Agg业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DeleteMaterialnamesAggDOByParentDOBp {

	public void exec(MaterialNamesDO[] arg0) throws BizException {
		ArrayList<MedSrvDO> medSrvList = new ArrayList<MedSrvDO>();
		MaterialNamesDOAdapter adapter = new MaterialNamesDOAdapter();
		for (MaterialNamesDO materialNamesDO : arg0) {
			MedSrvDO medSrvDO = adapter.getMedSrvDO(materialNamesDO);
			medSrvList.add(medSrvDO);
		}
		IMedsrvCudService medsrvCudService = ServiceFinder.find(IMedsrvCudService.class);
		medsrvCudService.deleteByParentDO(medSrvList.toArray(new MedSrvDO[0]));
	}
}
