package iih.ci.ord.i.external.common;

import java.util.List;
import java.util.Map;

import iih.ci.ord.i.external.common.meta.EffectiveOrSrvDTO;
import iih.ci.ord.i.external.common.meta.EffectiveOrderDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;

/**
 * 医嘱信息接口，注意该接口不对外提供服务，外部不允许直接调用该接口
 * 
 * @author HUMS
 *
 */
public interface ICIOrdRService {

	/**
	 * 根据传入的就诊类型和医嘱id集合获取有效医嘱<br>
	 * 已签署、未作废、未退费
	 * 
	 * @param idOrListMap key 值 就诊类型，value ：id_or的list集合
	 * @return
	 * @throws DAException
	 */
	public List<EffectiveOrderDTO> getEffectiveOrderListByIdors(Map<String, List<String>> idOrListMap) throws DAException;

	/**
	 * 根据传入的就诊类型和服务项目id集合获取有效服务项目对象<br>
	 * 已签署、未作废、未退费
	 * 
	 * @param idOrSrvListMap key 就诊类型 value id_orsrv 的list 集合
	 * @return 有效的服务项目
	 * @throws DAException
	 */
	public List<EffectiveOrSrvDTO> getEffectiveOrSrvListByIdOrsrvs(Map<String, List<String>> idOrSrvListMap) throws DAException;

	/**
	 * 获取医嘱状态
	 * @param code_entp 就诊类型
	 * @param sd_su_or 医嘱状态
	 * @param sd_su_mp 执行状态
	 * @param fg_stop 停止标志
	 * @return 用于医嘱列表显示的状态
	 */
	public String getOrderStatus(String code_entp, String sd_su_or, String sd_su_mp, FBoolean fg_stop);

	/**
	 * 根据就诊号获取医嘱最大排序号
	 * @param id_en 就诊id
	 * @return 医嘱最大排序号
	 * @throws BizException
	 */
	public Integer getOrdMaxSortno(String id_en) throws BizException;
}
