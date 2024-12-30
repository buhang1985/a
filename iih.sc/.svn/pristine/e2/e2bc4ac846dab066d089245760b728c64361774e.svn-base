package iih.sc.apt.s.bp.oral;

import iih.pi.reg.patbbr.d.PiPatBbrDO;
import iih.pi.reg.patbbr.i.IPatbbrRService;
import iih.pi.reg.pattag.d.PatTagDO;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 获取口腔预约患者标签和不良记录数据BP
 * 
 * @author zhengcm
 * @date 2016-11-29 13:38:25
 *
 */
public class GetOralAptPatTagDatasBP {

	/**
	 * 获取口腔预约患者标签和不良记录数据
	 *
	 * @param patId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public FMap exec(String patId) throws BizException {
		// 1、检查参数
		ScValidator.validateParam("patId", patId);
		FMap fmap = new FMap();
		fmap.put("fg_bbr", String.valueOf(this.isPatHasBbr(patId)));
		fmap.put("tags", this.getPatTagInfoStr(patId));
		return fmap;
	}

	/**
	 * 查询患者是否有不良记录
	 *
	 * @param patId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private boolean isPatHasBbr(String patId) throws BizException {
		// 患者不良行为查询服务
		IPatbbrRService qryService = ServiceFinder.find(IPatbbrRService.class);
		PiPatBbrDO[] bbrDOs = qryService.find(String.format("id_pat = '%s'", patId), null,
				FBoolean.FALSE);
		if (ArrayUtil.isEmpty(bbrDOs)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 查询患者标签信息并组装成指定的格式
	 *
	 * @param patId 患者id
	 * @return 患者标签信息字符串
	 * @throws BizException
	 * @author zhengcm
	 */
	private String getPatTagInfoStr(String patId) throws BizException {
		if (StringUtil.isEmptyWithTrim(patId)) {
			return null;
		}
		OralAptEP oralAptEP = new OralAptEP();
		String where = String.format("id_pat = '%s'", patId);
		PatTagDO[] patTagDOs = oralAptEP.getPatTagByWhere(where);
		if (ArrayUtil.isEmpty(patTagDOs)) {
			return null;
		}
		List<String> tagIds = new ArrayList<String>();
		for (PatTagDO tagDO : patTagDOs) {
			tagIds.add(tagDO.getId_pattagtp());
		}
		Map<String, String> map = this.getPatTagTP(tagIds);

		String dataInfo = "";
		for (int i = 0; i < patTagDOs.length; i++) {
			dataInfo = dataInfo + map.get(patTagDOs[i].getId_pattagtp());
			if (i != patTagDOs.length - 1) {
				dataInfo = dataInfo + ",";
			}
		}
		return dataInfo;
	}

	/**
	 * 根据患者标签类型id获取标签类型名称
	 *
	 * @param tagIdList 患者标签类型Id列表
	 * @return 患者标签类型Id和Code的Map
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, String> getPatTagTP(List<String> tagIdList) throws BizException {
		if (ListUtil.isEmpty(tagIdList)) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		String where = "id_udidoc in (" + ScSqlUtils.buildIdStr(tagIdList) + ")";
		// 自定义档案查询服务
		IUdidocRService qryService = ServiceFinder.find(IUdidocRService.class);
		UdidocDO[] docDOs = qryService.find(where, null, FBoolean.FALSE);
		for (UdidocDO docDO : docDOs) {
			map.put(docDO.getId_udidoc(), docDO.getName());
		}
		return map;
	}
}
