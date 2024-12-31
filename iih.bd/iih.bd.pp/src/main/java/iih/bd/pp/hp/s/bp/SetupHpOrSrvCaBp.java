package iih.bd.pp.hp.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hp.d.BdHpUnlimitDrugDO;
import iih.bd.pp.hp.d.HpAggDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 补全医保计划_医保不限量药品中的对照信息</br>
 * 因为这个参照太特殊
 * 
 * @author hao_wu
 *
 */
public class SetupHpOrSrvCaBp {

	public void exec(HpAggDO result) throws BizException {
		if (result == null) {
			return;
		}
		BdHpUnlimitDrugDO[] limitDrugArray = result.getBdHpUnlimitDrugDO();
		if (limitDrugArray != null) {
			Setup(limitDrugArray);
		}
	}

	/**
	 * 补全目录对照信息
	 * 
	 * @param limitDrugArray
	 * @throws BizException
	 */
	private void Setup(BdHpUnlimitDrugDO[] limitDrugArray) throws BizException {
		HashMap<String, HPSrvorcaDO> hpsrvOrCaMap = GetHpSrvOrCaMap(limitDrugArray);
		if (hpsrvOrCaMap == null || hpsrvOrCaMap.size() <= 0) {
			return;
		}
		for (BdHpUnlimitDrugDO bdHpUnlimitDrugDO : limitDrugArray) {
			if (bdHpUnlimitDrugDO != null && StringUtils.isNotBlank(bdHpUnlimitDrugDO.getCode_hp())) {
				String codeHp = bdHpUnlimitDrugDO.getCode_hp();
				if (hpsrvOrCaMap.containsKey(codeHp)) {
					HPSrvorcaDO hpSrvorcaDO = hpsrvOrCaMap.get(codeHp);
					bdHpUnlimitDrugDO.setName_hp(hpSrvorcaDO.getName());
				}
			}
		}
	}

	/**
	 * 获取医保目录对照字典
	 * 
	 * @param limitDrugArray
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, HPSrvorcaDO> GetHpSrvOrCaMap(BdHpUnlimitDrugDO[] limitDrugArray) throws BizException {
		String[] codeHpArray = GetCodeHpArray(limitDrugArray);
		if (codeHpArray == null || codeHpArray.length <= 0) {
			return null;
		}
		IHpsrvorcaRService hpsrvorcaRService = ServiceFinder.find(IHpsrvorcaRService.class);
		HPSrvorcaDO[] result = hpsrvorcaRService.findByAttrValStrings(HPSrvorcaDO.CODE, codeHpArray);
		HashMap<String, HPSrvorcaDO> map = GetHpSrvOrCaMap(result);
		return map;
	}

	/**
	 * 获取医保目录对照字典
	 * 
	 * @param result
	 * @return
	 */
	private HashMap<String, HPSrvorcaDO> GetHpSrvOrCaMap(HPSrvorcaDO[] result) {
		if (result == null || result.length <= 0) {
			return null;
		}
		HashMap<String, HPSrvorcaDO> map = new HashMap<String, HPSrvorcaDO>();
		for (HPSrvorcaDO hpSrvorcaDO : result) {
			map.put(hpSrvorcaDO.getCode(), hpSrvorcaDO);
		}
		return map;
	}

	/**
	 * 获取医保编码数组
	 * 
	 * @param limitDrugArray
	 * @return
	 */
	private String[] GetCodeHpArray(BdHpUnlimitDrugDO[] limitDrugArray) {
		ArrayList<String> codeHpList = new ArrayList<String>();
		for (BdHpUnlimitDrugDO bdHpUnlimitDrugDO : limitDrugArray) {
			if (bdHpUnlimitDrugDO != null && StringUtils.isNotBlank(bdHpUnlimitDrugDO.getCode_hp())) {
				codeHpList.add(bdHpUnlimitDrugDO.getCode_hp());
			}
		}
		return codeHpList.toArray(new String[0]);
	}

}
