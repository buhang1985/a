package iih.ei.std.bd.v1.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.bs.stditf.d.BdStdItfDO;
import iih.bd.bs.stditf.i.IStditfRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据接口编码查询视图名称业务逻辑
 * 
 * @author hao_wu 2019-2-27
 *
 */
public class FindViewNameByItfCodeBp {

	public String exec(String itfCode) throws BizException {
		if (StringUtils.isBlank(itfCode)) {
			throw new BizException("接口编码不允许为空。");
		}

		IStditfRService viewRService = ServiceFinder.find(IStditfRService.class);
		BdStdItfDO[] stdViews = viewRService.findByAttrValString(BdStdItfDO.CODE, itfCode);
		if (stdViews == null || stdViews.length <= 0) {
			String msg = String.format("根据接口编码%s未查询到接口信息。", itfCode);
			throw new BizException(msg);
		}
		return stdViews[0].getName_view();
	}
}
