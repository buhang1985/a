package iih.bd.mm.materialnames.s.bp.savebp;

import java.util.ArrayList;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.adapter.MaterialNamesDOAdapter;
import iih.bd.mm.materialnames.s.bp.findbp.findMedSrvDrugDOByIdBp;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存医疗服务药品属性业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveMedSrvDrugDOBp {

	public MedSrvDrugDO[] exec(MaterialNamesDO[] dos) throws BizException {
		ArrayList<MedSrvDrugDO> list = new ArrayList<MedSrvDrugDO>();

		findMedSrvDrugDOByIdBp bp = new findMedSrvDrugDOByIdBp();
		MaterialNamesDOAdapter adapter = new MaterialNamesDOAdapter();
		for (MaterialNamesDO materialNamesDO : dos) {
			MedSrvDrugDO rtn = bp.exec(materialNamesDO.getId_materialname());
			if (null == rtn) {
				rtn = new MedSrvDrugDO();
				rtn.setStatus(DOStatus.NEW);
			}
			adapter.getMedSrvDrugDO(rtn, materialNamesDO);
			list.add(rtn);
		}

		IMedSrvDrugDOCudService medSrvDrugDOCudService = ServiceFinder.find(IMedSrvDrugDOCudService.class);
		MedSrvDrugDO[] rtnList = medSrvDrugDOCudService.save(list.toArray(new MedSrvDrugDO[0]));

		return rtnList;
	}
}
