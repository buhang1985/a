package iih.ci.ord.i.external.provide;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.i.external.provide.meta.mm.CiOrderPendingAccountDTO;
import iih.ci.ord.i.external.provide.meta.mm.CiOrderStatusDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * 提供给物品域接口
 * 
 * @author HUMS
 *
 */
public interface ICiOrdMmService {

	/**
	 * 根据执行科室、患者id获取对应未记账的医嘱id
	 * 
	 * @param id_dep_mp
	 * @return
	 */
	public abstract String[] getOrderInfosOfUnPay(String id_dep_mp, String id_pat) throws BizException;
	
	/**
	 * 根据医嘱id获取未记账医嘱属性集合
	 * @param id_ors 待判断的医嘱id集合
	 * @return id_or,code_or , name_or ,sd_su_bl
	 * @throws BizException
	 */
	public abstract CiOrderStatusDTO[] getOrderAccontStatus(String[] id_ors) throws BizException;
	public abstract String[] getPendingAccontOrdersByIds(String[] id_ors) throws BizException;
	
	/**
	 * 根据患者id，执行科室获取未记账的医嘱
	 * @param id_pat 患者id
	 * @param id_dep_mp 执行科室id
	 * @return 待记账医嘱集合
	 * @throws BizException
	 */
	public abstract CiOrderPendingAccountDTO[] getPendingAccontOrdersByPat(String id_pat , String id_dep_mp) throws BizException;
	
	/**
	 * 根据患者id，执行科室获取未记账的医嘱（不含物品）
	 * @param id_pat
	 * @param id_dep_mp
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderPendingAccountDTO[] getPendingAccontOrdersExcludeMmByPat(String id_pat , String id_dep_mp) throws BizException;

	/**
	 * 获取不可启用用医疗服务及提示信息
	 * 
	 * @param medSrvDOs
	 *            待判断服务对象数组
	 * @return Map<String,String> 非物品时 key：id_srv ; value：不可用提示信息，物品时
	 *         key：id_srv,id_mm ; value：不可用提示信息
	 * @throws BizException
	 */
	public abstract FMap2 ChangedSrvValidate(MedSrvDO[] medSrvDOs) throws BizException;
}
