package iih.bd.pp.service.s;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.service.bp.GetHpIdForHpCatalogBP;
import iih.bd.pp.service.bp.GetSrvorcaByMmBP;
import iih.bd.pp.service.bp.GetSrvorcaBySrvBP;
import iih.bd.pp.service.i.IPpQueService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;

/**
 * 医保计划、医保计划目录、诊断查询节点
 * @author tcy
 * 
 * 修改履历 ： 2017/05/26 ly 添加方法getHpIdForHpCatalog
 * 
 */
@Service(serviceInterfaces={IPpQueService.class}, binding=Binding.JSONRPC)
public class IPpQueServiceImpl implements IPpQueService {

	/**
	 * 查询指定医保计划下服务的医保计划目录
	 * @param id_hp 医保计划
	 * @param id_srvarr 服务ID数组
	 * @return 医保计划目录
	 * @throws BizException
	 */
	@Override
	public HPSrvorcaDO[] getHPSrvorcaDOByIdsrvIdHP(String id_hp,
			String[] id_srvarr) throws BizException {
		GetSrvorcaBySrvBP bp = new GetSrvorcaBySrvBP();
		return bp.exec(id_hp, id_srvarr);
	}

	/**
	 * 查询指定医保计划下物品的医保计划目录
	 * @param id_hp 医保计划
	 * @param id_mmarr 物品ID数组
	 * @return 医保计划目录
	 * @throws BizException
	 */
	@Override
	public HPSrvorcaDO[] getHPSrvorcaDOByIdmmIdHP(String id_hp,
			String[] id_mmarr) throws BizException {
		GetSrvorcaByMmBP bp = new GetSrvorcaByMmBP();
		return bp.exec(id_hp, id_mmarr);
	}
	
	/**
	 * 取得医保目录对照查询用医保计划
	 * @param entIds 就诊id数组
	 * @return map key:就诊id value:医保计划id
	 * @throws BizException
	 */
	@Override
	public FMap getHpIdForHpCatalog(String[] entIds) throws BizException{
		GetHpIdForHpCatalogBP bp = new GetHpIdForHpCatalogBP();
		return bp.exec(entIds);
	}
}
