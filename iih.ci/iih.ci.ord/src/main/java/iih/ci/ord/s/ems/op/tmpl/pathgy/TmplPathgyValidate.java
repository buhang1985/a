package iih.ci.ord.s.ems.op.tmpl.pathgy;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.ciordems.d.EmsItemInPathgy;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.op.base.OpBaseEmsValidate;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 病理医疗单有效性检查
 * 
 * @author wangqingzhu
 *
 */
public class TmplPathgyValidate extends OpBaseEmsValidate {
	public ErrorEmsList viewModelValidate(Object objEms, CiEnContextDTO ctx) throws BizException {
		ErrorEmsList errorList = new ErrorEmsList();
		
		return errorList;
	}

	public ErrorEmsList beforeSaveValidate(Object objEms) throws BizException {
		return null;
	}

	/**
	 * 校验病理标本信息
	 * @param samplist
	 * @param errorList
	 */
	private void checkSampInfo(FArrayList samplist, FArrayList errorList) {
		for (Object obj : samplist) {
			EmsItemInPathgy sampDO = (EmsItemInPathgy) obj;
			if (sampDO.getSortno() == null || StringUtils.isNullOrEmpty(sampDO.getSortno().toString())) {
				errorList.append("标本序号不完整，请重新检查！");
			}

			if (StringUtils.isNullOrEmpty(sampDO.getName_labsamp())) {
				errorList.append("标本名称不完整，请重新检查！");
			}

			if (StringUtils.isNullOrEmpty(sampDO.getBody_coll())) {
				errorList.append("标本采集部位不完整，请重新检查！");
			}

			if (StringUtils.isNullOrEmpty(sampDO.getFixative())) {
				errorList.append("标本固定液不完整，请重新检查！");
			}
			if (sampDO.getQuan_coll() <= 0) {
				errorList.append("标本数量不能为零，请重新检查！");
			}
		}
	}
}
