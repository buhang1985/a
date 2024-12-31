package iih.bd.mm.materialnames.d.adapter;

import java.util.ArrayList;

import iih.bd.mm.materialnames.d.MnCodeSetDO;
import iih.bd.srv.medsrv.d.MedSrvCodeSetDO;

/**
 * 药品通用名编码集适配器
 * 
 * @author hao_wu
 *
 */
public class MnCodeSetDOAdapter extends BaseAdapter {

	/**
	 * 医疗服务编码集列表适配
	 * 
	 * @param medSrvCodeSetDOs
	 * @return
	 */
	public MnCodeSetDO[] getMnCodeSetDOs(MedSrvCodeSetDO[] medSrvCodeSetDOs) {
		ArrayList<MnCodeSetDO> mnCodeSetDOList = new ArrayList<MnCodeSetDO>();
		if (medSrvCodeSetDOs != null) {
			for (MedSrvCodeSetDO medSrvCodeSetDO : medSrvCodeSetDOs) {
				MnCodeSetDO mnCodeSetDO = getMnCodeSetDO(medSrvCodeSetDO);
				mnCodeSetDOList.add(mnCodeSetDO);
			}
		}
		return mnCodeSetDOList.toArray(new MnCodeSetDO[0]);
	}

	/**
	 * 医疗服务编码集适配
	 * 
	 * @param medSrvCodeSetDO
	 * @return
	 */
	public MnCodeSetDO getMnCodeSetDO(MedSrvCodeSetDO medSrvCodeSetDO) {
		MnCodeSetDO mnCodeSetDO = new MnCodeSetDO();
		setDOCommonProp(mnCodeSetDO, medSrvCodeSetDO);
		mnCodeSetDO.setId_codeset(medSrvCodeSetDO.getId_srvcode());
		mnCodeSetDO.setId_materialname(medSrvCodeSetDO.getId_srv());
		mnCodeSetDO.setId_cdstd(medSrvCodeSetDO.getId_cdstd());
		mnCodeSetDO.setName_cdstd(medSrvCodeSetDO.getName_cdstd());
		mnCodeSetDO.setSd_cdstd(medSrvCodeSetDO.getSd_cdstd());
		mnCodeSetDO.setCode(medSrvCodeSetDO.getCode());
		return mnCodeSetDO;
	}

	/**
	 * 医疗服务编码集适配
	 * 
	 * @param medSrvCodeSetDO
	 * @return
	 */
	public MedSrvCodeSetDO getMedSrvCodeSetDO(MnCodeSetDO mnCodeSetDO) {
		MedSrvCodeSetDO medSrvCodeSetDO = new MedSrvCodeSetDO();
		setDOCommonProp(medSrvCodeSetDO, mnCodeSetDO);
		medSrvCodeSetDO.setId_srvcode(mnCodeSetDO.getId_codeset());
		medSrvCodeSetDO.setId_srv(mnCodeSetDO.getId_materialname());
		medSrvCodeSetDO.setId_cdstd(mnCodeSetDO.getId_cdstd());
		medSrvCodeSetDO.setSd_cdstd(mnCodeSetDO.getSd_cdstd());
		medSrvCodeSetDO.setName_cdstd(mnCodeSetDO.getName_cdstd());
		medSrvCodeSetDO.setCode(mnCodeSetDO.getCode());
		return medSrvCodeSetDO;
	}
}
