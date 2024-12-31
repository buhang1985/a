package iih.bd.fc.quesite.s.rule;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 检查错误数据规则</br>
 * 针对发药站点中队列id为空的情况进行检查并提示
 * 
 * @author hao_wu
 *
 */
public class CheckErrorDataRule implements IRule<QueSiteDO> {

	@Override
	public void process(QueSiteDO... queSites) throws BizException {
		if (queSites == null || queSites.length <= 0) {
			return;
		}
		CheckErrorData(queSites);
	}

	/**
	 * 检查错误站点
	 * 
	 * @param queSites
	 * @throws BizException
	 */
	private void CheckErrorData(QueSiteDO[] queSites) throws BizException {
		for (QueSiteDO queSiteDO : queSites) {
			CheckErrorData(queSiteDO);
		}
	}

	/**
	 * 检查错误站点
	 * 
	 * @param queSiteDO
	 * @throws BizException
	 */
	private void CheckErrorData(QueSiteDO queSiteDO) throws BizException {
		if (queSiteDO != null && IBdFcDictCodeConst.SD_QUESITETP_SENDM.equals(queSiteDO.getSd_quesitetp())
				&& StringUtils.isEmpty(queSiteDO.getId_que())) {
			String msg = String.format("发药站点\"%s\"数据异常，所属队列为空，请保留业务现场并联系基础数据域开发工程师，谢谢配合。", queSiteDO.getName());
			throw new BizException(msg);
		}
	}
}
