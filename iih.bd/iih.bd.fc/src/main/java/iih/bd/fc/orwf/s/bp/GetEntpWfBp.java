package iih.bd.fc.orwf.s.bp;

import iih.bd.fc.orwf.d.EntpWfDTO;
import iih.bd.fc.orwf.s.qry.GetWfCfgTreeSql;
import iih.bd.utils.ParamUtils;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @Description:获取医嘱流向配置2.0树的数据源
 * @author: xu_xing@founder.com.cn
 * @version：2019年4月18日 下午1:26:36 创建
 */
public class GetEntpWfBp {

	/**
	 * 主入口
	 * @return
	 * @throws BizException
	 */
	public EntpWfDTO[] exec() throws BizException {

		//1、查询数据
		EntpWfDTO[] rtns = queryData();
		
		//2、获取组织参数值
		String BDFC0005 = ParamUtils.getOrgParamStringValue("BDFC0005");
		
		//3、组装数据
		pakageRtns(rtns, BDFC0005);
		
		return rtns;
	}

	/**
	 * 查询数据
	 * @return
	 * @throws BizException 
	 */
	private EntpWfDTO[] queryData() throws BizException {
		GetWfCfgTreeSql sql = new GetWfCfgTreeSql();
		return (EntpWfDTO[]) AppFwUtil.getDORstWithDao(sql, EntpWfDTO.class);
	}
	
	/**
	 * 组装数据
	 * @param rtns
	 * @param MPNR0173
	 */
	private void pakageRtns(EntpWfDTO[] rtns, String BDFC0005){
		if(BDFC0005 != null && rtns != null && rtns.length > 0){
			for (EntpWfDTO entpWfDTO : rtns) {
				entpWfDTO.setOrgparam(BDFC0005);
			}
		}
	}
}
