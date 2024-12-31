package iih.bd.mm.materialnames.s.bp.savebp;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.adapter.MaterialNamesDOAdapter;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.utils.UdidocUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 保存医疗服务主数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveMedSrvDOBp {

	public MedSrvDO[] exec(MaterialNamesDO[] dos) throws BizException {

		ArrayList<MedSrvDO> list = new ArrayList<MedSrvDO>();

		MaterialNamesDOAdapter adapter = new MaterialNamesDOAdapter();
		for (MaterialNamesDO materialNamesDO : dos) {
			MedSrvDO medSrvDO = adapter.getMedSrvDO(materialNamesDO);
			list.add(medSrvDO);
		}

		UpdateData(list);

		IMedsrvMDOCudService medsrvMDOCudService = ServiceFinder.find(IMedsrvMDOCudService.class);
		MedSrvDO[] rtn = medsrvMDOCudService.save(list.toArray(new MedSrvDO[0]));
		for (int i = 0; i < rtn.length; i++) {
			dos[i].setId_materialname(rtn[i].getId_srv());
		}

		saveIncCaItmRel(rtn);

		return rtn;
	}

	/**
	 * 保存发票分类项目对照
	 * 
	 * @param medSrvArray
	 * @throws BizException
	 */
	private void saveIncCaItmRel(MedSrvDO[] medSrvArray) throws BizException {
		SaveIncCaItmRelAfterSaveDrugNamesBp bp = new SaveIncCaItmRelAfterSaveDrugNamesBp();
		bp.exec(medSrvArray);
	}

	/**
	 * 更新数据
	 * 
	 * @param medSrvlist
	 * @throws BizException
	 */
	private void UpdateData(ArrayList<MedSrvDO> medSrvlist) throws BizException {
		if (medSrvlist == null || medSrvlist.size() <= 0) {
			return;
		}

		UdidocDO totalOpenMode = UdidocUtils.getUdidocByCode(IBdSrvDictCodeTypeConst.SD_TOTALOPENMODE,
				IBdSrvDictCodeConst.SD_TOTALOPENMODE_CYCLE);

		for (MedSrvDO medSrvDO : medSrvlist) {
			if (medSrvDO.getFg_or() != null && FBoolean.TRUE.equals(medSrvDO.getFg_or())) {
				// 药品通用名保存，fg_or设置为Y时，同时需要设置【是否多次执行ismulexec】=Y
				// ,【是否多剂量ismuldose】 =Y,【总量开单方式】=0 按周期开立
				medSrvDO.setIsmuldose(FBoolean.TRUE);
				medSrvDO.setIsmulexec(FBoolean.TRUE);
				medSrvDO.setId_totalopenmode(totalOpenMode.getId_udidoc());
				medSrvDO.setSd_totalopenmode(totalOpenMode.getCode());
				medSrvDO.setTotalopenmode_name(totalOpenMode.getName());
			}
		}
	}

}
