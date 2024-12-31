package iih.bl.st.s.bp.oepcharge.validate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.itf.pe.IBlPeChargeService;
import iih.bl.params.BlParams;
import iih.bl.st.dto.refundcheck.d.RefundCheckDTO;
import iih.pe.papi.i.his.IChargeService;
import iih.pe.papt.dto.peitfrefunddto.d.PeItfRefundDTO;
import iih.pe.papt.dto.peitfsvrsdto.d.PeItfSvrsDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 体检可退费校验器
 * 
 * @author wq.li 2018/12/12
 *
 */
public class PeReturnableValidator {

	/**
	 * 体检可退费校验器
	 * 
	 * @param cgDos
	 * @throws BizException
	 */
	public void validate(BlCgItmOepDO[] cgDos) throws BizException {

		if (ArrayUtil.isEmpty(cgDos)) {
			return;
		}

		FBoolean isCustom = BlParams.BLITF0002();
		if (FBoolean.TRUE.equals(isCustom)) {
			// 走第三方校验
			this.customValidate(cgDos);
		} else {
			// 系统体检模块进行校验
			this.peValidate(cgDos);
		}
	}

	/**
	 * 第三方可退性校验
	 * 
	 * @param cgDos
	 * @throws BizException 
	 */
	private void customValidate(BlCgItmOepDO[] cgDos) throws BizException {
		
		if(ArrayUtil.isEmpty(cgDos)){
			return;
		}
		
		List<RefundCheckDTO> checkList=new ArrayList<>();
		for (BlCgItmOepDO cgDo : cgDos) {
			RefundCheckDTO checkDto=new RefundCheckDTO();
			//未获取到 pat_code 时传入id_pat  zx 2018年12月31日
			if(StringUtil.isEmptyWithTrim(cgDo.getPat_code())){
				checkDto.setPatcode(cgDo.getId_pat());
			}else{
				checkDto.setPatcode(cgDo.getPat_code());
			}
			checkDto.setPecode(cgDo.getPecode());
			checkDto.setSrvcode(cgDo.getCode_srv());
			checkList.add(checkDto);
		}
		
		IBlPeChargeService chArgeService=ServiceFinder.find(IBlPeChargeService.class);
		
		RefundCheckDTO[] checkArr = chArgeService.peRefundCheck(checkList.toArray(new RefundCheckDTO[0]));
	
		if (ArrayUtil.isEmpty(checkArr)) {
			throw new BizException("体检结果未返回校验结果");
		}

		Map<String, RefundCheckDTO> rtnMap = new HashMap<>();
		for (RefundCheckDTO peItfRefundDTO : checkArr) {
			rtnMap.put(peItfRefundDTO.getPecode() + peItfRefundDTO.getSrvcode(), peItfRefundDTO);
		}
		// 查看记账明细的可退状态
		for (BlCgItmOepDO cgDo : cgDos) {
			RefundCheckDTO rtnDTO = rtnMap.get(cgDo.getPecode() + cgDo.getCode_srv());
			if (rtnDTO == null) {
				throw new BizException("体检未返回【" + cgDo.getName_srv() + "】的可退状态");
			}

			if (FBoolean.FALSE.equals(rtnDTO.getFg_canrefund())) {
				throw new BizException("【" + cgDo.getName_srv() + "】不可退");
			}
		}
	
	}

	/**
	 * 系统体检模块进行可退性校验
	 * 
	 * @param cgDos
	 * @throws BizException
	 */
	private void peValidate(BlCgItmOepDO[] cgDos) throws BizException {

		if (ArrayUtil.isEmpty(cgDos)) {
			return;
		}

		List<PeItfSvrsDTO> pesrvList = new ArrayList<>();
		for (BlCgItmOepDO blCgItmOepDO : cgDos) {
			PeItfSvrsDTO dto = new PeItfSvrsDTO();
			dto.setId_pepsnappt(blCgItmOepDO.getPecode());
			dto.setId_srv(blCgItmOepDO.getId_srv());
			pesrvList.add(dto);
		}

		// 调用体检可退校验接口
		IChargeService peService = ServiceFinder.find(IChargeService.class);
		PeItfRefundDTO[] retDtoArr = peService.peRefund(pesrvList.toArray(new PeItfSvrsDTO[0]));

		if (ArrayUtil.isEmpty(retDtoArr)) {
			throw new BizException("体检结果未返回校验结果");
		}

		Map<String, PeItfRefundDTO> rtnMap = new HashMap<>();
		for (PeItfRefundDTO peItfRefundDTO : retDtoArr) {
			rtnMap.put(peItfRefundDTO.getId_pepsnappt() + peItfRefundDTO.getId_srv(), peItfRefundDTO);
		}
		// 查看记账明细的可退状态
		for (BlCgItmOepDO cgDo : cgDos) {
			PeItfRefundDTO rtnDTO = rtnMap.get(cgDo.getPecode() + cgDo.getId_srv());
			if (rtnDTO == null) {
				throw new BizException("体检未返回【" + cgDo.getName_srv() + "】的可退状态");
			}

			if (FBoolean.FALSE.equals(rtnDTO.getFg_refund())) {
				throw new BizException("【" + cgDo.getName_srv() + "】不可退");
			}
		}
	}
}
