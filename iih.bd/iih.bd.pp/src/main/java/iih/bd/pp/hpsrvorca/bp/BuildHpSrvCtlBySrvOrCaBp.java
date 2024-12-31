package iih.bd.pp.hpsrvorca.bp;

import java.util.HashMap;

import iih.bd.pp.bdhpsrvctr.d.BdHpSrvctrDO;
import iih.bd.pp.bdhpsrvctr.i.IBdhpsrvctrCudService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpIndicationRuleEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 生成医保计划_控制策略数据
 * 
 * @author hao_wu
 *
 */
public class BuildHpSrvCtlBySrvOrCaBp {
	public void exec(HPSrvorcaDO[] hpSrvOrCaArray) throws BizException {
		if (hpSrvOrCaArray == null || hpSrvOrCaArray.length <= 0) {
			return;
		}
		saveHpSrvCtrDOData(hpSrvOrCaArray);
	}

	/**
	 * 对保存的医保目录对照数据生成医保计划_控制策略数据，,一条医保目录对照数据生成一条控制策略数据
	 * 
	 * @param hpSrvorcas
	 *            新导入的医保目录对照的数据集
	 * @return BdHpSrvctrDO[]
	 * @author li_pengying
	 * @throws BizException
	 */
	public BdHpSrvctrDO[] saveHpSrvCtrDOData(HPSrvorcaDO[] hpSrvorcas) throws BizException {
		IBdhpsrvctrCudService ctrSer = ServiceFinder.find(IBdhpsrvctrCudService.class);

		// DeleteOldData(hpSrvorcas);

		HashMap<String, BdHpSrvctrDO> ctrmap = new HashMap<String, BdHpSrvctrDO>();

		for (HPSrvorcaDO hPSrvorcaDO : hpSrvorcas) {

			BdHpSrvctrDO srvctrDO = CreateBdHpSrvctrDO(hPSrvorcaDO);
			String mapKey=String.format("%s%s%s", srvctrDO.getId_hp() , srvctrDO.getId_srv() , srvctrDO.getEu_hpsrvtp());
			if (ctrmap.containsKey(mapKey)) {
				// 当id_srv+id_hp+eu_hpsrvtp一致，但是des有的为空有的不为空时ctr中eu_hpsrvctrtp以有值为准
				if ((ctrmap.get(mapKey)
						.getEu_hpsrvctrtp() == HpIndicationRuleEnum.NO_CONTROL && hPSrvorcaDO.getDes() != null)) {
					ctrmap.remove(mapKey);
				} else {
					continue;
				}
			}
			ctrmap.put(mapKey, srvctrDO);
		}
		BdHpSrvctrDO[] ctrDOArr = null;

		if (ctrmap.size() != 0)
			ctrDOArr = ctrSer.insert(ctrmap.values().toArray(new BdHpSrvctrDO[ctrmap.size()]));

		return ctrDOArr;
	}

	/**
	 * 创建控制策略数据
	 * 
	 * @param hPSrvorcaDO
	 * @return
	 */
	private BdHpSrvctrDO CreateBdHpSrvctrDO(HPSrvorcaDO hPSrvorcaDO) {
		BdHpSrvctrDO srvctrDO = new BdHpSrvctrDO();
		srvctrDO.setId_hp(hPSrvorcaDO.getId_hp());
		srvctrDO.setCode(hPSrvorcaDO.getCode());
		srvctrDO.setId_srv(hPSrvorcaDO.getId_srv());
		srvctrDO.setId_rule(hPSrvorcaDO.getId_rule());
		srvctrDO.setId_grp(Context.get().getGroupId());
		srvctrDO.setId_org(Context.get().getOrgId());
		srvctrDO.setEu_hpsrvtp(hPSrvorcaDO.getEu_hpsrvtp());
		srvctrDO.setEu_hpsrvctrtp(hPSrvorcaDO.getEu_hpsrvctrtp());
		srvctrDO.setHis_des(hPSrvorcaDO.getHis_des());
		return srvctrDO;
	}

	/**
	 * 删除旧的医保计划_控制策略数据
	 * 
	 * @param hpSrvorcas
	 * @throws BizException
	 */
	private void DeleteOldData(HPSrvorcaDO[] hpSrvorcas) throws BizException {
		HpSrvorcaDeleteBp hpSrvorcaDeleteBp = new HpSrvorcaDeleteBp();
		hpSrvorcaDeleteBp.exec(hpSrvorcas);
	}
}
