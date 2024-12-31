package iih.ci.ord.s.external.obtain;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bl.cg.i.IBlCgValidateService;
import iih.bl.cg.i.IBlOutQryService;
import iih.ci.ord.i.external.obtain.ICiOrdBlRService;
import iih.ci.ord.i.external.obtain.meta.bl.PrePaidAccAmt4CiDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPriceCalBP;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPricesCalBP;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPricesCalByPriModeBP;
import iih.ci.ord.s.external.obtain.bp.bl.GetPatAccJudgeBP;
import iih.ci.ord.s.external.obtain.bp.bl.GgetWaitingAccountOrdsBP;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 调用费用相关接口
 * 
 * @author HUMS
 *
 */
@Service(serviceInterfaces = { ICiOrdBlRService.class }, binding = Binding.JSONRPC)
public class CiOrdBlRServiceImpl implements ICiOrdBlRService {

	/**
	 * 判断是否可以使用预交金 (北京市医保不支持预交金，高端商保记账不支持预交金)
	 * 
	 * @param patId 患者ID
	 * @param entId 就诊ID
	 * @param bizType 业务场景类型，暂为空，（后续可参考：iih.bl.pay.prepay.d.EuPrepayBizType）
	 * @return FBoolean
	 * @throws BizException
	 */
	@Override
	public FBoolean isPatUsePrePay(String patId, String entId, String bizType) throws BizException {

		IBlOutQryService bllOutQryService = (IBlOutQryService) ServiceFinder.find(IBlOutQryService.class);
		return bllOutQryService.canUsePrepay(patId, entId, bizType);
	}
	
	/**
	 * 临床医嘱选择服务，服务价格计算 单服务价格计算
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public FDouble ciOrBdSrvPriceCal(BdSrvPriCalParamDTO param) throws BizException {
		CiOrBdSrvPriceCalBP bp = new CiOrBdSrvPriceCalBP();
		return bp.exec(param);
	}

	/**
	 * 临床医嘱服务价格计算 批量服务价格计算
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap ciOrBdSrvPricesCal(BdSrvPriCalParamDTO[] params) throws BizException {
		CiOrBdSrvPricesCalBP bp = new CiOrBdSrvPricesCalBP();
		return bp.execForMap(params);
	}

	/**
	 * 临床医嘱服务价格计算 患者价格模式
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public MedSrvPriceDO ciOrBdSrvPriceCalByPriMode(BdSrvPriCalParamDTO param, String id_pripat) throws BizException {
		CiOrBdSrvPricesCalByPriModeBP bp = new CiOrBdSrvPricesCalByPriModeBP();

		return bp.exec(param, id_pripat);
	}

	@Override
	public Map<String, HPSrvorcaDO> getHpSrvorcaByIdSrvs(String idHp, Map<String, String> idSrvIdmmMap)
			throws BizException {

		// 获取返回结果
		Map<String, HPSrvorcaDO> hpSrvOrcaMap = new HashMap<String, HPSrvorcaDO>();

		IHpsrvorcaRService hpsrvorcaRService = (IHpsrvorcaRService) ServiceFinder.find(IHpsrvorcaRService.class);

		if (idSrvIdmmMap == null || idSrvIdmmMap.size() == 0) {
			return new HashMap<String, HPSrvorcaDO>();
		}

		// id_srv集合，
		StringBuffer idSrvBuffer = new StringBuffer();
		// id_mm 集合
		StringBuffer idMmBuffer = new StringBuffer();

		for (String idSrv : idSrvIdmmMap.keySet()) {

			idSrvBuffer.append(",'" + idSrv + "'");

			String idMm = idSrvIdmmMap.get(idSrv);
			if (StringUtils.isNotBlank(idMm)) {
				idMmBuffer.append(",'" + idSrvIdmmMap.get(idSrv) + "'");
			}
		}

		// 拼接查询条件，查询指定服务，物品id对应的医保目录
		StringBuffer whereBuffer = new StringBuffer();
		whereBuffer.append("id_hp = '" + idHp + "' and id_srv in (" + idSrvBuffer.substring(1) + ")");
		if (idMmBuffer.length() > 0) {
			whereBuffer.append(" and id_mm in (" + idMmBuffer.substring(1) + ")");
		}

		// 遍历医保目录查询结果，根据传入的服务id和物品id过滤出返回结果，返回结果key值为服务id和物品id拼接值，如果物品id为空，key值为服务id
		HPSrvorcaDO[] hpSrvorcas = hpsrvorcaRService.find(whereBuffer.toString(), null, FBoolean.FALSE);
		for (HPSrvorcaDO hpSrvorca : hpSrvorcas) {

			String tempKey = hpSrvorca.getId_srv();
			if (!idSrvIdmmMap.containsKey(tempKey)) {
				continue;
			}

			String idMm = idSrvIdmmMap.get(tempKey);
			if (StringUtils.isNotBlank(idMm)) {
				tempKey += "," + idMm;
			}

			hpSrvOrcaMap.put(tempKey, setDefaultHpsrvtp(hpSrvorca));
		}

		return hpSrvOrcaMap;
	}

	@Override
	public HPSrvorcaDO getHpSrvorcaBySrvMm(String idHp, String idSrv, String idMm) throws BizException {

		IHpsrvorcaRService hpsrvorcaRService = (IHpsrvorcaRService) ServiceFinder.find(IHpsrvorcaRService.class);

		if (StringUtils.isEmpty(idHp) || StringUtils.isEmpty(idSrv)) {
			return null;
		}

		StringBuffer whereStr = new StringBuffer();
		whereStr.append(" id_hp = '" + idHp + "' and id_srv = '" + idSrv + "' ");

		if (StringUtils.isNotBlank(idMm)) {
			whereStr.append(" and id_mm = '" + idMm + "'");
		}

		HPSrvorcaDO[] hpSrvorcas = hpsrvorcaRService.find(whereStr.toString(), null, FBoolean.FALSE);
		if (hpSrvorcas != null && hpSrvorcas.length > 0) {
			return setDefaultHpsrvtp(hpSrvorcas[0]);
		}

		return null;

	}

	/**
	 * 设置医保计划目录类型等级<br>
	 * 根据医保目录是否在有效期设置医保目录等级，不在有效期内的为丙级
	 * 
	 * @param hpSrvorca 医保目录对照
	 * @return
	 */
	private HPSrvorcaDO setDefaultHpsrvtp(HPSrvorcaDO hpSrvorca) {

		FDateTime currentTime = CiOrdAppUtils.getServerDateTime();
		if (!HpStatusEnum.REVIEW.equals(hpSrvorca.getEu_status())
				|| (hpSrvorca.getDt_b() != null && currentTime.before(hpSrvorca.getDt_b()))
				|| (hpSrvorca.getDt_e() != null && currentTime.after(hpSrvorca.getDt_e()))) {

			hpSrvorca.setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);
			hpSrvorca.setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);
		}

		return hpSrvorca;
	}

	public Map<String, FBoolean> getOrSrvBlStatus(String[] idOrSrvs) throws BizException{
		
		IBlCgValidateService blCgValidateService = (IBlCgValidateService) ServiceFinder.find(IBlCgValidateService.class);
		return blCgValidateService.orsrvHasSettled2(idOrSrvs);
	}
	
	@Override
	public String[] getWaitingAccountIdOrSrv(String idEn , String codeEntp, String idDepMp) throws BizException{
		
		GgetWaitingAccountOrdsBP bp = new GgetWaitingAccountOrdsBP();
		return bp.getIdOrSrv(idEn, codeEntp, idDepMp);
	}

	@Override
	public PrePaidAccAmt4CiDTO GetPatAccJudge(String code_entp, String id_en, String id_pat,String id_patca) throws BizException {
		GetPatAccJudgeBP bp=new GetPatAccJudgeBP();
		return bp.exec(code_entp, id_en, id_pat,id_patca);
	}
}
