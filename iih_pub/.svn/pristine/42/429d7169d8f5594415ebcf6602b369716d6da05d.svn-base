package iih.bd.pp.i;

import java.util.Map;

import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.dto.accsrvrelat.d.AccSrvRelatDTO;
import iih.bd.pp.dto.itmnoline.d.BdItmNoOnlineHitDTO;
import iih.bd.pp.dto.prisrvcompratio.d.BdPriSrvCompRatioDTO;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.samppricnstdto.d.SampPricnstDTO;
import iih.bd.pp.srvspecround.d.SrvSpecRoundDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 付款策略查询服务接口
 * 
 * @author yankan
 * @since 2017-07-10
 *
 */
public interface IBdPpQryService {
	/**
	 * 获取患者价格分类map
	 * 
	 * @return 患者价格分类map【key:患者价格分类ID，value: 患者价格分类Agg】
	 * @throws BizException
	 * @author yankan
	 */
	public abstract Map<String, PripatAggDO> getAllPripat() throws BizException;

	/**
	 * 数量特殊取整
	 * 
	 * @param quan
	 *            数量
	 * @param specRoundDO
	 *            特殊取整DO
	 * @return
	 * @throws BizException
	 * @author yankan
	 */
	public abstract FDouble specRound(FDouble quan, SrvSpecRoundDO specRoundDO) throws BizException;

	/**
	 * 计算特殊取整数量
	 * 
	 * @param srvQuanMap，[key:服务ID，value:数量]
	 * @return map[key:服务ID，value:数量]
	 * @throws BizException
	 * @author yankan
	 */
	public abstract FMap batchSpecRound(FMap srvQuanMap) throws BizException;

	/**
	 * 获取核算分类医疗服务关系
	 * 
	 * @param srvIds
	 *            服务id数组
	 * @param codeEntp
	 *            就诊类型编码
	 * @throws BizException
	 * @author ly 2018/05/14
	 */
	public abstract AccSrvRelatDTO[] getAccSrvRelat(String[] srvIds, String codeEntp) throws BizException;

	/**
	 * 命中非线上支付服务项目
	 * 
	 * @param dtos
	 *            服务信息
	 * @return 命中的服务信息
	 * @throws BizException
	 * @author ly 2018/05/16
	 */
	public abstract BdItmNoOnlineHitDTO[] hitNoOnlineItm(BdItmNoOnlineHitDTO[] dtos) throws BizException;

	/**
	 * 获取预交金警告策略
	 * 
	 * @param depId
	 *            科室id
	 * @param patcaId
	 *            患者分类id
	 * @param codeEntp
	 *            就诊类型编码
	 * @return
	 * @throws BizException
	 * @author ly 2018/07/11
	 */
	public abstract BdPreWarnDO getPreWarnInfo(String depId, String patcaId, String codeEntp) throws BizException;

	/**
	 * 标本费用对照，查询标本类型
	 * 
	 * @return
	 * @throws BizException
	 */
	public UdidocDO[] getSamptpDoc() throws BizException;
	
	/**
	 * 儿童采集费用对照，查询医疗服务
	 * 
	 * @return
	 * @throws BizException
	 */
	public  PagingRtnData<SampPricnstDTO> GetSampPriChldCnstDOs(PaginationInfo pg, SampPricnstDTO sampPricnstDTO) throws BizException;

	/**
	 * 获取组合定价特殊比例
	 * @param srvIds 服务数组
	 * @return 特殊比例组合定价数据
	 * @throws BizException
	 * @author ly 2019/09/23
	 */
	public abstract BdPriSrvCompRatioDTO[] getSpecialSrvCompRatio(String[] srvIds) throws BizException;
}
