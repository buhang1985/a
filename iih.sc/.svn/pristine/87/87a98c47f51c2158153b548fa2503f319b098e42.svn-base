package iih.sc.apt.s.bp.mt;

import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.s.ep.MtAptEP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 设置医技预约申请单就诊和患者数据BP
 * 
 * @author zhengcm
 * @date 2017-08-11 15:41:01
 *
 */
public class SetMtAppDTODatasBP {

	/**
	 * 设置医技预约申请单就诊和患者数据
	 *
	 * @author zhengcm
	 * 
	 * @param appDTOList
	 * @throws BizException
	 */
	public void exec(List<MtAppDTO> appDTOList) throws BizException {
		if (ListUtil.isEmpty(appDTOList)) {
			return;
		}
		// 设置就诊数据
		this.setEntData(appDTOList);
		// 计算患者年龄
		this.calcPatAge(appDTOList);
	}

	/**
	 * 计算患者年龄
	 *
	 * @param mtAppDTOList
	 * @throws BizException
	 * @author zhengcm
	 */
	private void calcPatAge(List<MtAppDTO> mtAppDTOList) throws BizException {
		if (ListUtil.isEmpty(mtAppDTOList)) {
			return;
		}
		for (MtAppDTO mtDTO : mtAppDTOList) {
			if (mtDTO.getDt_birth_pat() != null) {
				mtDTO.setAge(AgeCalcUtil.getAge(mtDTO.getDt_birth_pat()));
			}
		}
	}

	/**
	 * 补全就诊数据
	 *
	 * @param mtDTOs
	 * @throws BizException
	 * @author zhengcm
	 */
	private void setEntData(List<MtAppDTO> mtDTOs) throws BizException {
		if (ListUtil.isEmpty(mtDTOs)) {
			return;
		}
		List<String> ids = new ArrayList<String>();
		for (MtAppDTO mtDTO : mtDTOs) {
			if (!StringUtil.isEmptyWithTrim(mtDTO.getId_ent())) {
				ids.add(mtDTO.getId_ent());
			}
		}
		Map<String, PatiVisitDO> map = this.getEntInfo(ids);
		for (MtAppDTO mtDTO : mtDTOs) {
			String key = mtDTO.getId_ent();
			if (null != key && map != null && map.containsKey(key)) {
				PatiVisitDO entDO = map.get(key);
				mtDTO.setId_sex(entDO.getId_sex_pat());
				//mtDTO.setName_sex(entDO.getName_sex());
				//mtDTO.setName_enttp(entDO.getName_entp());
				mtDTO.setId_pat(entDO.getId_pat());
				mtDTO.setName_pat(entDO.getName_pat());
			}
		}
	}

	/**
	 * 获取就诊信息
	 *
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, PatiVisitDO> getEntInfo(List<String> entIds) throws BizException {
		if (ListUtil.isEmpty(entIds)) {
			return null;
		}
		PatiVisitDO[] entDOs = new MtAptEP().getEntByIds(entIds.toArray(new String[0]));
		if (ArrayUtil.isEmpty(entDOs)) {
			return null;
		}
		Map<String, PatiVisitDO> map = new HashMap<String, PatiVisitDO>();
		for (PatiVisitDO entDO : entDOs) {
			map.put(entDO.getId_ent(), entDO);
		}
		return map;
	}
}
