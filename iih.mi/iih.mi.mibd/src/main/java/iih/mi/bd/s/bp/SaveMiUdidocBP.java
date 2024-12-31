package iih.mi.bd.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import iih.mi.bd.miudidocuse.d.MiUdidoclistUseDO;
import iih.mi.bd.miudidocuse.i.IMiudidocuseCudService;
import iih.mi.bd.miudidocuse.i.IMiudidocuseRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 维护该医保计划下的档案类型
 * 
 * @author wq.li
 *
 */
public class SaveMiUdidocBP {

	/**
	 * 维护该医保计划下的档案类型
	 * @param hpId
	 * @param udidocArr
	 * @throws BizException
	 */
	public void exec(String hpId, MiUdidoclistDO[] udidocArr) throws BizException {

		if (StringUtil.isEmpty(hpId)) {
			throw new BizException("医保计划不能为空");
		}

		// 查询该医保计划下已维护的档案类型
		IMiudidocuseRService useRService = ServiceFinder.find(IMiudidocuseRService.class);
		IMiudidocuseCudService useCudService = ServiceFinder.find(IMiudidocuseCudService.class);

		MiUdidoclistUseDO[] useArr = useRService.find("id_hp='" + hpId + "'", "", FBoolean.FALSE);

		if (ArrayUtil.isEmpty(udidocArr)) {

			if (!ArrayUtil.isEmpty(useArr)) {

				useCudService.delete(useArr);
			}
			return;
		}

		Map<String, MiUdidoclistDO> listMap = new HashMap<String, MiUdidoclistDO>();
		for (MiUdidoclistDO listDo : udidocArr) {
			listMap.put(listDo.getId_miudidoclist(), listDo);
		}

		Map<String, MiUdidoclistUseDO> useMap = new HashMap<String, MiUdidoclistUseDO>();
		for (MiUdidoclistUseDO miUdidoclistUseDO : useArr) {
			useMap.put(miUdidoclistUseDO.getId_miudidoclist(), miUdidoclistUseDO);
		}

		// 对比获取应删除的数据
		List<MiUdidoclistUseDO> delUseIdList = new ArrayList<MiUdidoclistUseDO>();
		for (String key : useMap.keySet()) {
			if (!listMap.containsKey(key)) {
				delUseIdList.add(useMap.get(key));
			}
		}

		if (!ListUtil.isEmpty(delUseIdList)) {
			useCudService.delete(delUseIdList.toArray(new MiUdidoclistUseDO[0]));
		}

		// 对比需要新增的数据
		List<MiUdidoclistUseDO> addList = new ArrayList<MiUdidoclistUseDO>();

		for (String key : listMap.keySet()) {
			if (!useMap.containsKey(key)) {
				MiUdidoclistUseDO useDo = new MiUdidoclistUseDO();
				useDo.setId_grp(Context.get().getGroupId());
				useDo.setId_org(Context.get().getOrgId());
				useDo.setId_hp(hpId);
				useDo.setId_miudidoclist(key);
				addList.add(useDo);
			}
		}

		if (!ListUtil.isEmpty(addList)) {
			useCudService.insert(addList.toArray(new MiUdidoclistUseDO[0]));
		}

	}

}
