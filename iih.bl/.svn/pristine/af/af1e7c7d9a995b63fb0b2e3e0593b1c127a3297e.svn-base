package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.itf.pe.IBlPeChargeService;
import iih.bl.params.BlParams;
import iih.bl.st.dto.bloeppecustcharge.d.BlOepPeCustInputDTO;
import iih.pe.papi.i.his.IChargeService;
import iih.pe.papt.dto.peitfchargedto.d.PeItfChargeGroupDTO;
import iih.pi.reg.patcust.d.PiPatCustDO;
import iih.pi.reg.patcust.i.IPatcustRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取团检结算流水号
 * 
 * @author zhangxin
 * @date 2018年12月14日
 */
public class GetCustPeChargeCodeBP {
	public BlOepPeCustInputDTO[] exec(String id_cust) throws BizException {
		BlOepPeCustInputDTO[] inputDto = new BlOepPeCustInputDTO[] {};
		// 是否要调用第三方体检接口
		if (BlParams.BLITF0002().booleanValue()) {
			inputDto = this.getItfPeChargeService(id_cust);
		} else {
			inputDto = this.getPeChargeService(id_cust);
		}
		if (ArrayUtil.isEmpty(inputDto)) {
			throw new BizException("没有需要缴纳的体检费用");
		}
		return inputDto;
	}
    /***
     * 调用iih体检服务
     * @param id_cust
     * @return
     * @throws BizException
     */
	private BlOepPeCustInputDTO[] getPeChargeService(String id_cust) throws BizException {
		// 组装接口入参
		PeItfChargeGroupDTO groupDto = new PeItfChargeGroupDTO();
		// 客户id
		groupDto.setId_pat(id_cust);
		// 调用体检接口获取
		IChargeService service = ServiceFinder.find(IChargeService.class);
		PeItfChargeGroupDTO[] peChargeConnectBlGroup = service.peChargeConnectBlGroup(groupDto);
		// 返回值校验
		this.validator(peChargeConnectBlGroup);
		Map<String, String> idPatMap = this.idPatMap(peChargeConnectBlGroup);
		List<BlOepPeCustInputDTO> listblOepPeCustDto = new ArrayList<BlOepPeCustInputDTO>();
		for (PeItfChargeGroupDTO peCharge : peChargeConnectBlGroup) {
			BlOepPeCustInputDTO inputDto = new BlOepPeCustInputDTO();
			inputDto.setId_cust(peCharge.getId_pat());
			inputDto.setCust_pecode(peCharge.getPe_code());
			inputDto.setDt_reg(peCharge.getDt_or());
			inputDto.setId_pat(idPatMap.get(peCharge.getId_pat()));
			listblOepPeCustDto.add(inputDto);
		}
		return listblOepPeCustDto.toArray(new BlOepPeCustInputDTO[] {});
	}
    /**
     * 调用第三方体检服务
     * @param id_cust
     * @return
     * @throws BizException
     */
	private BlOepPeCustInputDTO[] getItfPeChargeService(String id_cust) throws BizException {
		IBlPeChargeService iblPeChargeService = ServiceFinder.find(IBlPeChargeService.class);
		if(iblPeChargeService==null){
			throw new BizException("未获取到第三方体检收费接口");
		}
		return iblPeChargeService.getCustPeChargeInput(id_cust);
	}

	// 查询团体对应的患者id
	private Map<String, String> idPatMap(PeItfChargeGroupDTO[] peChargeConnectBlGroup) throws BizException {
		Map<String, String> idpatMap = new HashMap<String, String>();
		List<String> id_custs = new ArrayList<String>();
		for (PeItfChargeGroupDTO peItfDto : peChargeConnectBlGroup) {
			id_custs.add(peItfDto.getId_pat());
		}
		IPatcustRService service = ServiceFinder.find(IPatcustRService.class);
		PiPatCustDO[] piPatCustDOs = service.findByAttrValStrings(PiPatCustDO.ID_CUST,
				id_custs.toArray(new String[] {}));
		if (ArrayUtil.isEmpty(piPatCustDOs)) {
			throw new BizException("该团体未维护团体患者关系");
		}
		for (PiPatCustDO piPatCustDO : piPatCustDOs) {
			if (idpatMap.get(piPatCustDO.getId_cust())==null) {
				idpatMap.put(piPatCustDO.getId_cust(), piPatCustDO.getId_pat());
			}
		}
		return idpatMap;

	}

	/**
	 * 返回值校验
	 * 
	 * @param peChargeConnectBlGroup
	 * @throws BizException
	 */
	private void validator(PeItfChargeGroupDTO[] peChargeConnectBlGroup) throws BizException {
		if (ArrayUtil.isEmpty(peChargeConnectBlGroup)) {
			throw new BizException("体检系统未返回 预约单号");
		}
		for (PeItfChargeGroupDTO peItfChargeGroupDTO : peChargeConnectBlGroup) {
			if (StringUtil.isEmpty(peItfChargeGroupDTO.getId_pat())) {
				throw new BizException("体检系统返回 团检id 为空");
			}
			if (StringUtil.isEmpty(peItfChargeGroupDTO.getPe_code())) {
				throw new BizException("体检系统返回 团检预约单号 为空");
			}
			if (StringUtil.isEmpty(peItfChargeGroupDTO.getDt_or())) {
				throw new BizException("体检系统返回 团检预约日期 为空");
			}
		}
	}
}
