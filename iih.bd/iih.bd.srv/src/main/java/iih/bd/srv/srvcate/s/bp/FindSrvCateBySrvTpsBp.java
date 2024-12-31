package iih.bd.srv.srvcate.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.srv.srvcate.i.ISrvcateRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据服务类型编码组和数据权限查询服务分类业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindSrvCateBySrvTpsBp {

	public SrvCateDO[] exec(String[] sdSrvTps, String orderStr, FBoolean isLazy) throws BizException {
		String whereStr = getWhereStr(sdSrvTps);
		if (StringUtil.isEmptyWithTrim(whereStr)) {
			whereStr = getDefaultWhereStr();
		}
		SrvCateDO[] result = find(whereStr, orderStr, isLazy);
		return result;
	}

	/**
	 * 获取默认过滤条件
	 * 
	 * @return
	 */
	private String getDefaultWhereStr() {
		return String.format("(sd_srvtp like '%s%%' or sd_srvtp like '%s%%' or sd_srvtp like '%s%%')",
				IBdSrvDictCodeConst.SD_SRVTP_DRUG, IBdSrvDictCodeConst.SD_SRVTP_SANI,
				IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD);
	}

	/**
	 * 拼接Sql语句
	 * 
	 * @param sdSrvTps
	 * @return
	 */
	private String getWhereStr(String[] sdSrvTps) {
		if (sdSrvTps == null || sdSrvTps.length <= 0) {
			return null;
		}

		StringBuffer whereStr = new StringBuffer();
		whereStr.append("(");

		for (int i = 0; i < sdSrvTps.length; i++) {
			if (i != 0) {
				whereStr.append(" or ");
			}
			String temp = String.format("sd_srvtp like '%s%%'", sdSrvTps[i]);
			whereStr.append(temp);
		}
		whereStr.append(")");
		return whereStr.toString();
	}

	/**
	 * 根据查询条件和数据权限查询服务分类
	 * 
	 * @param whereStr
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	private SrvCateDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
		ISrvcateRService srvcateRService = ServiceFinder.find(ISrvcateRService.class);
		SrvCateDO[] result = srvcateRService.find(whereStr, orderStr, isLazy);
		return result;
	}

}
