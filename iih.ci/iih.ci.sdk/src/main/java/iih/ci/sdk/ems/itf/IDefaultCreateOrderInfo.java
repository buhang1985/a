package iih.ci.sdk.ems.itf;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.ems.meta.DefaultCreateParam;
import iih.ci.sdk.ems.meta.OrderPackageInfo;
import iih.ci.sdk.ems.meta.OrderSrvMmInfo;
import xap.mw.core.data.BizException;

/**
 * 默认医嘱生成接口
 * @author wangqingzhu
 *
 */
public interface IDefaultCreateOrderInfo {
	
	/**
	 * 创建通用医嘱信息
	 * @param id_srv
	 * @param id_mm
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	abstract public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException;
	
	/**
	 * 创建医嘱对象
	 * @param ctx
	 * @param medsrv
	 * @return
	 * @throws BizException
	 */
	abstract public CiOrderDO createOrderInfo(CiEnContextDTO ctx, MedSrvDO medsrv) throws BizException;
	
	/**
	 * 创建临床服务信息对象，如果该服务为物品服务，则默认选取一个物品信息
	 * @param ctx
	 * @param orderInfo
	 * @param srvInfo
	 * @param eu_sourcemd
	 * @param index
	 * @return
	 * @throws BizException
	 */
	abstract public OrderSrvMmInfo createOrderSrvMmInfo(CiEnContextDTO ctx,CiOrderDO orderInfo, MedSrvDO srvInfo, int eu_sourcemd) throws BizException;
	
	/**
	 * 
	 * @param ctx
	 * @param orderInfo
	 * @param id_srv
	 * @param id_mm
	 * @param eu_sourcemd
	 * @param index
	 * @return
	 * @throws BizException
	 */
	abstract public OrderSrvMmInfo createOrderSrvMmInfo(CiEnContextDTO ctx,CiOrderDO orderInfo, String id_srv, String id_mm, int eu_sourcemd) throws BizException;
	
}
