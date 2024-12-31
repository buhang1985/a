package iih.ci.ord.s.external.provide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.dto.dtlastblcalparam.d.DtLastBlCalParamDTO;
import iih.ci.ord.i.external.common.ICIOrdRService;
import iih.ci.ord.i.external.common.meta.EffectiveOrderDTO;
import iih.ci.ord.i.external.provide.ICiOrdMpService;
import iih.ci.ord.iemsg.d.SugApplyInfoDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.save.ip.CiOrDtLastBlCal4OpenBP;
import iih.ci.ord.s.external.provide.bp.GetIpSugInfoBp;
import iih.ci.ord.s.external.provide.bp.samp.GetLisRefundInfoBP;
import iih.ci.ord.s.external.provide.bp.samp.GetSampInfoBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;

/**
 * 临床提供给执行域的对外接口
 * 
 * @author HUMS
 *
 */
@Service(serviceInterfaces = { ICiOrdMpService.class }, binding = Binding.JSONRPC)
public class CiOrdMpServiceImpl implements ICiOrdMpService {
	
	@Override
	public List<SugApplyInfoDTO> getIpSugApplyList(String id_pat, String id_ent, String dt_b, String dt_e,
			String id_dep_mp, String code_entp, String fg_aptapp1, String fg_confirm) throws BizException  {
	
		GetIpSugInfoBp bp = new GetIpSugInfoBp();
		return bp.exec(id_pat, id_ent, dt_b, dt_e, id_dep_mp, code_entp, fg_aptapp1, fg_confirm);
	
	}

	/**
	 * 根据传入的就诊类型和医嘱id集合获取有效医嘱<br/>
	 * 执行确认、医技补录项目节点使用
	 * 
	 * @param idOrListMap
	 *            医嘱Id集合，key: 就诊类型， value : id_or的list集合
	 * @return 有效医嘱集合，已签署、未作废、未退费的医嘱集合
	 * @throws DAException
	 */
	@Override
	public List<EffectiveOrderDTO> getEffectiveOrderListByIdors(Map<String, List<String>> idOrListMap)
			throws DAException {

		ICIOrdRService ciOrdRService = (ICIOrdRService)ServiceFinder.find(ICIOrdRService.class);
		return ciOrdRService.getEffectiveOrderListByIdors(idOrListMap);
	}

	@Override
	public List<EffectiveOrderDTO> getOpEffectiveOrderListByIdors(List<String> idOrList) throws DAException {
		
		Map<String, List<String>> idOrListMap = new HashMap<String,List<String>>();
		idOrListMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_OP, idOrList);
		return getEffectiveOrderListByIdors(idOrListMap);
	}

	@Override
	public List<EffectiveOrderDTO> getIpEffectiveOrderListByIdors(List<String> idOrList) throws DAException {
		Map<String, List<String>> idOrListMap = new HashMap<String,List<String>>();
		idOrListMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_IP, idOrList);
		return getEffectiveOrderListByIdors(idOrListMap);
	}

	@Override
	public FMap getSugDiagByIdapops(String[] id_apops) throws BizException {
		return CiOrdUtils.getSugDiagByIdapops(id_apops);
	}

	@Override
	public FDateTime getDtLastBl(DtLastBlCalParamDTO param) throws BizException {
		if(CiOrdUtils.isIpWf(param.getCode_entp())&&FBoolean.TRUE.equals(param.getFg_pres_outp())){
			return param.getDt_effe();
		}else{
			CiOrDtLastBlCal4OpenBP bp = new CiOrDtLastBlCal4OpenBP();
			return bp.exec(param.getId_freq(), param.getDt_effe(), param.getTimes_firday_mp(), param.getFg_long());
		}
	}
	/**
	 * 根据申请单号获取标本费和采集费医嘱ids
	 * @param applynos
	 * @return
	 * @throws BizException
	 */
	public FMap getSampInfoByApplyno(String[] applynos) throws BizException{
		GetSampInfoBP bp = new GetSampInfoBP(); 
		return bp.exec(applynos);
	}
	/**
	 * 根据申请单号返回检验合管可退费的标本费和采集费医嘱ids
	 */
	@Override
	public List<String> getLisMegeRefundOrdIds(String[] applynos) throws BizException {
		GetLisRefundInfoBP bp=new GetLisRefundInfoBP(); 
		return bp.exec(applynos);
	}
}
