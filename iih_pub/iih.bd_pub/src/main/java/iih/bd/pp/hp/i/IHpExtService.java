package iih.bd.pp.hp.i;

import iih.bd.pp.hp.d.HpAggDO;
import xap.mw.core.data.BizException;

/**
 * 医保计划扩展服务
 * 
 * @author hao_wu
 * @since 2017-06-16
 *
 */
public interface IHpExtService {

	/**
	 * 使用id查询Agg数据</br>
	 * 查询后会补全医保不限量药品中的医保编码
	 * 
	 * @param id_hp
	 * @return
	 */
	public abstract HpAggDO FindById(String id_hp) throws BizException;

	// /**
	//// * 获取服务在指定医保计划下的医保目录类型
	//// * @param hpCode 医保计划编码
	//// * @param idSrv 服务项目id
	//// * @return 医保计划对应的服务项目或者分类的DO
	//// */
	// HpSrvOrCaDO getHpSrvTpByCode(String hpCode,String idSrv) throws
	// BizException;
	// /**
	// * 获取服务在指定医保计划下的医保目录类型
	// * @param hpId 医保计划ID
	// * @param idSrv 服务项目id
	// * @return 医保计划对应的服务项目或者分类的DO
	// * @throws BizException
	// */
	// HpSrvOrCaDO getHpSrvTpById(String hpId,String idSrv) throws BizException;
	//
	//
	// /**
	// * 获取一批服务在指定的医保计划下的医保目录类型
	// * @param hpId 医保计划主键ID
	// * @param arrIdSrv 服务的主键ID集合
	// * @return 返回服务对应的医保计划医保目录类型DO
	// * @throws BizException 业务异常
	// */
	// Map<String,HpSrvOrCaDO> getHpSrvOrCaDOMap(String hpId,String[] arrIdSrv)
	// throws BizException;
}
