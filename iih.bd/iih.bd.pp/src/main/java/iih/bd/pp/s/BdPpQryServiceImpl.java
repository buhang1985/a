package iih.bd.pp.s;

import java.util.Map;

import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.bp.BatchSpecRoundBP;
import iih.bd.pp.bp.SpecRoundBP;
import iih.bd.pp.bp.pri.GetAllPriPatBP;
import iih.bd.pp.dto.accsrvrelat.d.AccSrvRelatDTO;
import iih.bd.pp.dto.itmnoline.d.BdItmNoOnlineHitDTO;
import iih.bd.pp.dto.prisrvcompratio.d.BdPriSrvCompRatioDTO;
import iih.bd.pp.i.IBdPpQryService;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.s.bp.BdHitNoOnlineItmBP;
import iih.bd.pp.s.bp.BdPpGetAccSrvRelatBP;
import iih.bd.pp.s.bp.GetPreWarnInfoBP;
import iih.bd.pp.s.bp.GetSampPriChldCnstBp;
import iih.bd.pp.s.bp.GetSpecialSrvCompRatioBP;
import iih.bd.pp.s.samppri.bp.GetSamptpDocBp;
import iih.bd.pp.samppricnstdto.d.SampPricnstDTO;
import iih.bd.pp.srvspecround.d.SrvSpecRoundDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 付款策略查询服务
 * 
 * @author yankan
 * @since 2017-07-10
 *
 */
@Service(serviceInterfaces = { IBdPpQryService.class }, binding = Binding.JSONRPC)
public class BdPpQryServiceImpl implements IBdPpQryService {
	/**
	 * 获取患者价格分类map
	 * 
	 * @return 患者价格分类map【key:患者价格分类ID，value: 患者价格分类Agg】
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public Map<String, PripatAggDO> getAllPripat() throws BizException {
		GetAllPriPatBP getBP = new GetAllPriPatBP();
		return getBP.exec();
	}

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
	public FDouble specRound(FDouble quan, SrvSpecRoundDO specRoundDO) throws BizException {
		SpecRoundBP roundBP = new SpecRoundBP();
		return roundBP.exec(quan, specRoundDO);
	}

	/**
	 * 计算特殊取整数量
	 * 
	 * @param srvQuanMap，[key:服务ID，value:数量]
	 * @return map[key:服务ID，value:数量]
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public FMap batchSpecRound(FMap srvQuanMap) throws BizException {
		BatchSpecRoundBP calcBP = new BatchSpecRoundBP();
		return calcBP.exec(srvQuanMap);
	}

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
	@Override
	public AccSrvRelatDTO[] getAccSrvRelat(String[] srvIds, String codeEntp) throws BizException {
		BdPpGetAccSrvRelatBP bp = new BdPpGetAccSrvRelatBP();
		return bp.exec(srvIds, codeEntp);
	}

	/**
	 * 命中非线上支付服务项目
	 * 
	 * @param dtos
	 *            服务信息
	 * @return 命中的服务信息
	 * @throws BizException
	 * @author ly 2018/05/16
	 */
	@Override
	public BdItmNoOnlineHitDTO[] hitNoOnlineItm(BdItmNoOnlineHitDTO[] dtos) throws BizException {
		BdHitNoOnlineItmBP bp = new BdHitNoOnlineItmBP();
		return bp.exec(dtos);
	}

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
	@Override
	public BdPreWarnDO getPreWarnInfo(String depId, String patcaId, String codeEntp) throws BizException {
		GetPreWarnInfoBP bp = new GetPreWarnInfoBP();
		return bp.exec(depId, patcaId, codeEntp);
	}

	/**
	 * 标本费用对照，查询标本类型
	 * 
	 * @throws BizException
	 */
	public UdidocDO[] getSamptpDoc() throws BizException {
		GetSamptpDocBp bp = new GetSamptpDocBp();
		return bp.exec();
	}

	/**
	 * 儿童采集费用对照，查询医疗服务
	 * 
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<SampPricnstDTO> GetSampPriChldCnstDOs(PaginationInfo pg, SampPricnstDTO sampPricnstDTO) throws BizException {
		GetSampPriChldCnstBp bp = new GetSampPriChldCnstBp();
		return bp.exec(pg, sampPricnstDTO);
	}
	
	/**
	 * 获取组合定价特殊比例
	 * @param srvIds 服务数组
	 * @return 特殊比例组合定价数据
	 * @throws BizException
	 * @author ly 2019/09/23
	 */
	public BdPriSrvCompRatioDTO[] getSpecialSrvCompRatio(String[] srvIds) throws BizException{
		GetSpecialSrvCompRatioBP bp = new GetSpecialSrvCompRatioBP();
		return bp.exec(srvIds);
	}
}
