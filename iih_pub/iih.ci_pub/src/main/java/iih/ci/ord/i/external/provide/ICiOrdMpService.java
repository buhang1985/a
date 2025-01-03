package iih.ci.ord.i.external.provide;

import java.util.List;
import java.util.Map;

import iih.ci.ord.dto.dtlastblcalparam.d.DtLastBlCalParamDTO;
import iih.ci.ord.i.external.common.meta.EffectiveOrderDTO;
import iih.ci.ord.iemsg.d.SugApplyInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;

/**
 * 临床提供给执行域的对外接口
 * 
 * @author HUMS
 *
 */
public interface ICiOrdMpService {
	
	/**
	 * 手术申请查询接口
	 * @throws BizException 
	 */
	public List<SugApplyInfoDTO> getIpSugApplyList(String id_pat, String id_ent, String dt_b, String dt_e, String id_dep_mp, 
			String code_entp, String fg_aptapp1, String fg_confirm) throws DAException, BizException;

	/**
	 * 根据传入的就诊类型和医嘱id集合获取有效医嘱<br/>
	 * 执行确认、医技补录项目节点使用
	 * 
	 * @param idOrListMap
	 *            医嘱Id集合，key: 就诊类型， value : id_or的list集合
	 * @return 有效医嘱集合，已签署、未作废、未退费的医嘱集合
	 * @throws DAException
	 */
	public List<EffectiveOrderDTO> getEffectiveOrderListByIdors(Map<String, List<String>> idOrListMap)
			throws DAException;

	/**
	 * 根据医嘱id集合获取门诊有效医嘱<br/>
	 * 执行确认、医技补录项目节点使用
	 * 
	 * @param idOrList
	 *            待获取有效医嘱的id_or集合
	 * @return 有效医嘱集合，已签署、未作废、未退费的医嘱集合
	 * @throws DAException
	 */
	public List<EffectiveOrderDTO> getOpEffectiveOrderListByIdors(List<String> idOrList) throws DAException;

	/**
	 * 根据医嘱id集合获取住院有效医嘱<br/>
	 * 执行确认、医技补录项目节点使用
	 * 
	 * @param idOrList
	 *            待获取有效医嘱的id_or集合
	 * @return 有效医嘱集合，已签署、未作废、未退费的医嘱集合
	 * @throws DAException
	 */
	public List<EffectiveOrderDTO> getIpEffectiveOrderListByIdors(List<String> idOrList) throws DAException;
	/**
	 * 根据手术申请单的主键，查询开立手术申请单时的诊断信息
	 * @param id_apops
	 * @return
	 */
	public FMap getSugDiagByIdapops(String[] id_apops) throws BizException;
	/**
	 * 计算首日执行次数
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public FDateTime getDtLastBl(DtLastBlCalParamDTO param) throws BizException;
	/**
	 * 根据申请单号获取标本费和采集费医嘱ids
	 * @param applynos
	 * @return
	 * @throws BizException
	 */
	public FMap getSampInfoByApplyno(String[] applynos) throws BizException;
	/**
	 * 根据申请单号返回检验合管可退费的标本费和采集费医嘱ids
	 * @param applynos
	 * @return
	 * @throws BizException
	 */
	public List<String> getLisMegeRefundOrdIds(String[] applynos)throws BizException;
}
