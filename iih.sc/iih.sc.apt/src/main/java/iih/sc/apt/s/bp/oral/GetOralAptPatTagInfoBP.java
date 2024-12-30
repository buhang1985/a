package iih.sc.apt.s.bp.oral;

import iih.pi.reg.pattag.d.PatTagDO;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 获取口腔科预约患者标签信息BP
 * 
 * @author zhengcm
 * @date 2016-10-10 13:31:53
 *
 */
public class GetOralAptPatTagInfoBP {

	/**
	 * 获取口腔科预约患者标签信息
	 *
	 * @param patId 患者id
	 * @return 患者标签信息字符串
	 * @throws BizException
	 * @author zhengcm
	 */
	public String exec(String patId) throws BizException {
		// 1、检查参数
		ScValidator.validateParam("patId", patId);

		// 2、返回患者标签主键字符串
		return this.getPatTagInfoStr(patId);
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
			dataInfo = dataInfo + "_" + patTagDOs[i].getId_pattagtp() + ","
					+ map.get(patTagDOs[i].getId_pattagtp());
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
