package iih.bd.pp.service.bp;

import iih.bd.pp.anhuisrvorca.d.SrvCompDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

public class GetHpSrvCompBp {

	/**获取服务对照信息
	 * @param strIdHp 医保计划
	 * @param strIdSrvArr 服务编码
	 * @return 服务对照信息
	 * @throws BizException
	 */
	public SrvCompDTO[] exec(String strIdHp,String[] strIdSrvArr) throws BizException
	{
		if(StringUtil.isEmpty(strIdHp))
			throw new BizException("医保计划为空！");
		String strParam=new String();
		for(String item:strIdSrvArr)
		{
			strParam="'"+item+"',";
		}
//		strParam="("+strParam.substring(0,strParam.length()-1)+")";
//		StringBuilder sb=new StringBuilder();
//		sb.append("SELECT DECODE(SRVORCA.EU_HPSRVTP )
		return null;
	}
}
