package iih.ci.ord.s.ems.third.ip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.thirdparam.ChargeForCiParamDTO;
import iih.ci.ord.i.IPsnAuthorityCertifyService;
import iih.ci.ord.i.third.ThirdRstDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.cache.BDPsnInfoCache;
import iih.ci.ord.s.ems.cache.BDSrvInfoCache;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.third.base.BaseSaveBP;
import iih.ci.ord.s.ems.third.base.OrderPakageInfo;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;

/**
 * 住院医技补录费用
 * 
 * @author zhangwanqing
 *
 */
public class IpEmsDrugsFeeSaveBP extends BaseSaveBP {
	public ThirdRstDTO save(ChargeForCiParamDTO[] params) throws BizException {
		if(null == params || params.length == 0){
			throw new BizException("费用补录请求数据为空");
		}
		
		ChargeForCiParamDTO cfcp = params[0];
		{
			if(StringUtils.isEmpty(cfcp.getId_emp())){
				// 如果补录费用没有处方权，则不允许
				throw new BizException(String.format("%s(%s) 操作人为空", 
						BDSrvInfoCache.GetNameOfBdSrvInfo(cfcp.getId_srv()),cfcp.getId_srv()));
			}
			IPsnAuthorityCertifyService service = ServiceFinder.find(IPsnAuthorityCertifyService.class);
	        FBoolean canOpreate =  service.CertifyPsnPresAuthority(cfcp.getId_emp());
	        if(!CiOrdUtils.isTrue(canOpreate)){
	        	throw new BizException(String.format("%s(%s) 操作人：%s 没有处方权", 
						BDSrvInfoCache.GetNameOfBdSrvInfo(cfcp.getId_srv()),cfcp.getId_srv(),BDPsnInfoCache.GetNameOfBdPsnInfo(cfcp.getId_emp())));
	        }
		}
		// 查询患者的信息
		PatiVisitDO pat = this.getParInfo(this.getId_ent(params));
		Map<String, DefaultCreateParam[]> defaultMap = this.defaultCreateParamFrom(params);
		OrderPakageInfo[] pakageInfo = this.assembleData(pat, params, defaultMap.get("drug"));
		this.handleUserParameter(pakageInfo, getTempChargeMap(params));
		return this.saveData(pakageInfo);
	}

	@Override
	protected Map<String, ChargeForCiParamDTO> getTempChargeMap(ChargeForCiParamDTO[] params) {
		Map<String, ChargeForCiParamDTO> tempChargeMap = new HashMap<String, ChargeForCiParamDTO>();
		int index = 0;
		for (ChargeForCiParamDTO param : params) {
			String key = param.getId_srv();
			if(!CiOrdUtils.isEmpty(param.getFg_mm())&&param.getFg_mm().equals("Y")){
				key+=param.getId_mm()+index++;
			}
			tempChargeMap.put(key, param);
		}
		return tempChargeMap;
	}

	/**
	 * 将药品设置为临时的医嘱
	 * 
	 * @throws BizException
	 */
	@Override
	protected void handleUserParameter(OrderPakageInfo[] szOrderPakageInfo,
			Map<String, ChargeForCiParamDTO> tempChargeMap) throws BizException {
		int index = 0;
		for (OrderPakageInfo opInfo : szOrderPakageInfo) {
			opInfo.getOrderAggInfo().getParentDO().setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);
			opInfo.getOrderAggInfo().getParentDO().setId_su_or(ICiDictCodeConst.SD_SU_ID_FINISH);
			opInfo.getOrderAggInfo().getParentDO().setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK);
			opInfo.getOrderAggInfo().getParentDO().setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK_ID);
			opInfo.getOrderAggInfo().getParentDO().setFg_chk(FBoolean.TRUE);
			opInfo.getOrderAggInfo().getParentDO().setId_emp_chk(Context.get().getStuffId());
			opInfo.getOrderAggInfo().getParentDO().setId_dep_chk(Context.get().getDeptId());
			opInfo.getOrderAggInfo().getParentDO().setDt_chk(now);
			opInfo.getOrderAggInfo().getParentDO().setDt_last_bl(now.addSeconds(1));
			opInfo.getOrderAggInfo().getParentDO().setFg_sign(FBoolean.TRUE);
			opInfo.getOrderAggInfo().getParentDO().setDt_sign(now);
			opInfo.getOrderAggInfo().getParentDO().setDt_effe(now);
			List<OrdSrvMmDO> mms = opInfo.getOrderSrvMmList();
			Map<String,OrdSrvMmDO> teamMM = new HashMap<String,OrdSrvMmDO>();
			if (!CiOrdUtils.isEmpty(mms)) {
				for (OrdSrvMmDO mm : mms) {
					String key = mm.getId_srv()+mm.getId_mm() + index;
					teamMM.put(key, mm);
					if (tempChargeMap.containsKey(key)) {
						mm.setFactor(getFactor(mm.getId_mm(),tempChargeMap.get(key).getId_unit_pkg(),opInfo.getOrderAggInfo().getParentDO().getCode_entp()));
						mm.setQuan_cur(new FDouble(tempChargeMap.get(key).getQuan()));
						mm.setPrice_pgku_cur(tempChargeMap.get(key).getPrice());
						mm.setId_pgku_cur(tempChargeMap.get(key).getId_unit_pkg());
					}
				}
			}
			OrdSrvDO[] results = opInfo.getOrderAggInfo().getOrdSrvDO();
			if (!CiOrdUtils.isEmpty(results)) {
				for (OrdSrvDO srv : results) {
					String key = srv.getId_srv()+(srv.getId_mm()==null?"":(srv.getId_mm()+index));
					if (tempChargeMap.containsKey(key)) {
						opInfo.getOrderAggInfo().getParentDO().setId_dep_or(tempChargeMap.get(key).getId_dep_ap());
						srv.setId_dep_srv(tempChargeMap.get(key).getId_dep_ap());
						srv.setQuan_total_medu(new FDouble(tempChargeMap.get(key).getQuan()));
						if(CiOrdUtils.isEmpty(srv.getQuan_medu())){
							if(!CiOrdUtils.isEmpty(srv.getId_mm())&&teamMM.containsKey(key))
							srv.setQuan_medu(this.getQuan_medu(srv.getQuan_total_medu(),teamMM.get(key).getFactor(), teamMM.get(key).getFactor_mb()));
						}
					}
				}
			}
		
			opInfo.getOrderAggInfo().getParentDO().setEu_orsrcmdtp(OrSourceFromEnum.IIHMEDTECHORDERS);
			opInfo.getOrderAggInfo().getParentDO().setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			opInfo.getOrderAggInfo().getParentDO().setFg_long(FBoolean.FALSE);
			opInfo.getOrderAggInfo().getParentDO().setDt_end(opInfo.getOrderAggInfo().getParentDO().getDt_effe());
			if (!CiOrdUtils.isEmpty(results)) {
				for (OrdSrvDO srv : results) {
					srv.setEu_sourcemd(OrSrvSourceFromEnum.MTEXECADD);
					if (tempChargeMap.containsKey(srv.getId_srv())) {
						ChargeForCiParamDTO param = tempChargeMap.get(srv.getId_srv());
						srv.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
						if(StringUtils.isNotEmpty(param.getId_dep_wh())){
							srv.setId_dep_wh(param.getId_dep_wh());
						}
						if(!StringUtils.isEmpty(tempChargeMap.get(srv.getId_srv()).getId_dep_mp())){
							srv.setId_dep_mp(tempChargeMap.get(srv.getId_srv()).getId_dep_mp());
							opInfo.getOrderAggInfo().getParentDO().setId_dep_mp(tempChargeMap.get(srv.getId_srv()).getId_dep_mp());
						}
					}
				}
			}
			index++;
		}
	}

}
