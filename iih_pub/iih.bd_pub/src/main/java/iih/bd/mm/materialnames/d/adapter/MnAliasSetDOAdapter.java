package iih.bd.mm.materialnames.d.adapter;

import java.util.ArrayList;

import iih.bd.mm.materialnames.d.MnAliasSetDO;
import iih.bd.srv.medsrv.d.MedSrvAliasDO;

/**
 * 药品通用名别名集适配器
 * 
 * @author hao_wu
 *
 */
public class MnAliasSetDOAdapter extends BaseAdapter {

	/**
	 * 医疗服务别名集列表适配
	 * 
	 * @param medSrvAliasDOs
	 * @return
	 */
	public MnAliasSetDO[] getMnAliasSetDOs(MedSrvAliasDO[] medSrvAliasDOs) {
		ArrayList<MnAliasSetDO> mnAliasSetDOList = new ArrayList<MnAliasSetDO>();
		if (medSrvAliasDOs != null) {
			for (MedSrvAliasDO medSrvAliasDO : medSrvAliasDOs) {
				MnAliasSetDO mnAliasSetDO = getMnAliasSetDO(medSrvAliasDO);
				mnAliasSetDOList.add(mnAliasSetDO);
			}
		}
		return mnAliasSetDOList.toArray(new MnAliasSetDO[0]);
	}

	/**
	 * 医疗服务别名集适配
	 * 
	 * @param medSrvAliasDOs
	 * @return
	 */
	public MnAliasSetDO getMnAliasSetDO(MedSrvAliasDO medSrvAliasDO) {
		MnAliasSetDO mnAliasSetDO = new MnAliasSetDO();
		setDOCommonProp(mnAliasSetDO, medSrvAliasDO);
		
		mnAliasSetDO.setId_aliasset(medSrvAliasDO.getId_srvals());
		mnAliasSetDO.setId_materialname(medSrvAliasDO.getId_srv());
		mnAliasSetDO.setAlias(medSrvAliasDO.getAlias());
		mnAliasSetDO.setPycode(medSrvAliasDO.getPycode());
		mnAliasSetDO.setWbcode(medSrvAliasDO.getWbcode());
		mnAliasSetDO.setMnecode(medSrvAliasDO.getMnecode());

		mnAliasSetDO.setCreatedby(medSrvAliasDO.getCreatedby());
		mnAliasSetDO.setCreatedtime(medSrvAliasDO.getCreatedtime());
		mnAliasSetDO.setModifiedby(medSrvAliasDO.getModifiedby());
		mnAliasSetDO.setModifiedtime(medSrvAliasDO.getModifiedtime());

		return mnAliasSetDO;
	}

	/**
	 * 获取医疗服务别名集
	 * 
	 * @param mnAliasSetDO
	 * @return
	 */
	public MedSrvAliasDO getMedSrvAliasDO(MnAliasSetDO mnAliasSetDO) {
		MedSrvAliasDO medSrvAliasDO = new MedSrvAliasDO();
		setDOCommonProp(medSrvAliasDO, mnAliasSetDO);
		medSrvAliasDO.setId_srvals(mnAliasSetDO.getId_aliasset());
		medSrvAliasDO.setId_srv(mnAliasSetDO.getId_materialname());
		medSrvAliasDO.setAlias(mnAliasSetDO.getAlias());
		medSrvAliasDO.setPycode(mnAliasSetDO.getPycode());
		medSrvAliasDO.setWbcode(mnAliasSetDO.getWbcode());
		medSrvAliasDO.setMnecode(mnAliasSetDO.getMnecode());

		medSrvAliasDO.setCreatedby(mnAliasSetDO.getCreatedby());
		medSrvAliasDO.setCreatedtime(mnAliasSetDO.getCreatedtime());
		medSrvAliasDO.setModifiedby(mnAliasSetDO.getModifiedby());
		medSrvAliasDO.setModifiedtime(mnAliasSetDO.getModifiedtime());
		return medSrvAliasDO;
	}

}
