package iih.pis.ivx.i;

import xap.mw.core.data.BizException;

public interface IPisivxApiService {

	/*
	 * 发送文本消息
	 * 参数说明：
	 * 传入参数 ：<?xml version="1.0" encoding="utf-8"?>
				<msg>
					<patient>
						<id_pat>患者ID</id_pat>
						<codepat>患者编码</codepat>
						<namepat>患者姓名</namepat>
						<cardcode>就诊卡</cardcode>
						<ipcode>住院号</ipcode>
					</patient>
					<info>
						<msgcontent>文本消息内容</msgcontent>
					</info>
				</msg>
 	 * 传出参数：<?xml version="1.0" encoding="utf-8"?>
				<result>
					<success>0-成功；1-失败</success>
					<message>
						返回消息内容
					</message>
				</result>

	 */
	public abstract String sentTextMsg(String msg) throws BizException;
	
	/*
	 * 发送模板消息
	 * 传入参数：<?xml version="1.0" encoding="utf-8"?>
				<msg>
					<patient>
						<tmplcode>消息模板编码[PisIvxSettingTemplateDO.code]</tmplcode>
						<id_pat>患者ID</id_pat>
						<codepat>患者编码</codepat>
						<namepat>患者姓名</namepat>
						<cardcode>就诊卡</cardcode>
						<ipcode>住院号</ipcode>
						<ids>
							<id>凭证ID1，用于消息链接</id>
							<id>凭证ID2，用于消息链接</id>
							...
							<id>凭证IDn，用于消息链接</id>
						</ids>
					</patient>
					<info>
						<param>模板消息参数1</param>
						<param>模板消息参数2</param>
						<param>模板消息参数3</param>
						...
						<param>模板消息参数n</param>
					</info>
				</msg>
 	 * 传出参数：<?xml version="1.0" encoding="utf-8"?>
				<result>
					<success>0-成功；1-失败</success>
					<message>
						返回消息内容
					</message>
				</result>

	 */
	public abstract String sentTmplMsg(String msg) throws BizException;

	/**
	 * 获取ip地址
	 * @param void
	 * @return
	 */
	public String getAddress();
	
	/**
	 * 获取域名
	 * @param void
	 * @return
	 * @throws BizException
	 */
	public String getDomain() throws BizException;
	
}
