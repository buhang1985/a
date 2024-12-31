package iih.bd.srv.srvpricetable.i;

import xap.mw.core.data.BizException;

/**
 * 
 * 服务价格更新服务接口
 * 
 * @author hao_wu
 * @date 2020年4月23日
 *
 */
public interface IBdSrvPriceTableUpdateService {

	/**
	 * 服务价格更新条件类型_重建
	 */
	public static final String SrvPriceUpdateCondType_ReBuild = "00";
	/**
	 * 服务价格更新条件类型_医疗服务
	 */
	public static final String SrvPriceUpdateCondType_Srv = "01";
	/**
	 * 服务价格更新条件类型_医疗物品
	 */
	public static final String SrvPriceUpdateCondType_Mm = "02";
	/**
	 * 服务价格更新条件类型_患者价格分类
	 */
	public static final String SrvPriceUpdateCondType_PriPat = "03";

	/**
	 * 更新服务价格
	 * 
	 * @param condType   条件类型
	 * @param condValues 条件值集合
	 * @throws BizException
	 */
	public void updateSrvPriceTable(String condType, String[] condValues) throws BizException;

}
