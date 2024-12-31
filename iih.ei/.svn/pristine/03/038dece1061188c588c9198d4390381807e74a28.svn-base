package iih.ei.std.bd.v1.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.ei.std.bd.v1.utils.BdStdLogUtils;

/**
 * 使用异常信息创建错误XML
 * 
 * @author hao_wu 2019-2-27
 *
 */
public class CreateErrXmlByExBp {

	public String exec(Throwable e) {
		BdStdLogUtils.logExAndTitle(e, "使用异常信息创建错误XML");
		CreateErrXmlByMsgBp bp = new CreateErrXmlByMsgBp();
		String msg = getExMsg(e);
		String errXmlMsg = bp.exec(msg);
		return errXmlMsg;
	}

	private String getExMsg(Throwable e) {
		String msg = e.getMessage();

		if (StringUtils.isNotBlank(msg)) {
			return msg;
		}

		if (e.getCause() != null) {
			msg = getExMsg(e.getCause());
		}
		if (StringUtils.isNotBlank(msg)) {
			return msg;
		}

		msg = e.toString();
		return msg;
	}
}
