package iih.bl.st.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.ci.ord.dto.thirdparam.ChargeForCiParamDTO;
import iih.ci.ord.i.third.ICiOrderThirdService;
import iih.ci.ord.i.third.ThirdRstDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 甘肃武威一体化划价改造，只生成处方，不预留，直接去收费处走正常收费
 * 
 * @author yangyang
 * @Date 2019-03-07
 */
public class DoSignCiOrderBp {
	public BlCgOepAggDTO exec(OpRegPatDTO regPat, BlOrderAppendBillParamDTO[] chargeItemArr, OperatorInfoDTO psnInfoDto)
			throws BizException {

		if (ArrayUtil.isEmpty(chargeItemArr)) {
			throw new BizException("请录入补费信息");
		}
		// 1、患者注册挂号
		IEnOutCmdService enOutService = ServiceFinder.find(IEnOutCmdService.class);
		PatiVisitDO entDo = enOutService.regPatAndOp(regPat);

		// 2、开立医嘱并签署
		ICiOrderThirdService ciService = ServiceFinder.find(ICiOrderThirdService.class);

		List<ChargeForCiParamDTO> chargeDtoList = new ArrayList<ChargeForCiParamDTO>();

		// 2.1 DTO转换
		for (BlOrderAppendBillParamDTO appendDto : chargeItemArr) {
			ChargeForCiParamDTO chargeDto = new ChargeForCiParamDTO();
			chargeDto.setId_ent(appendDto.getId_ent());
			chargeDto.setId_srv(appendDto.getId_srv());
			chargeDto.setId_mm(appendDto.getId_mm());
			chargeDto.setId_emp(psnInfoDto.getId_emp());
			chargeDto.setId_unit_pkg(appendDto.getPgku_cur());
			//chargeDto.setFg_mm(appendDto.getFg_mm().booleanValue() ? "Y" : "N");
			chargeDto.setFg_mm(FBoolean.TRUE.equals(appendDto.getFg_mm()) ? "Y" : "N");
			chargeDto.setPrice(appendDto.getPrice_ratio());
			chargeDto.setDt_b(AppUtils.getServerDateTime().toStdString());
			chargeDto.setQuan(appendDto.getQuan().toString());
			chargeDtoList.add(chargeDto);
		}

		// 医嘱生成
		ThirdRstDTO[] retDto = ciService.tidyFeeSave(entDo, chargeDtoList.toArray(new ChargeForCiParamDTO[] {}));
		if (ArrayUtil.isEmpty(retDto)) {
			throw new BizException("生成医嘱时返回值为空");
		}
		// 组装返回值

		BlCgOepAggDTO dto = new BlCgOepAggDTO();
		FArrayList list = new FArrayList();
		BlcgoepAggDO aggdo = new BlcgoepAggDO();
		BlCgOepDO cgOep = new BlCgOepDO();
		BlCgItmOepDO itmoep = new BlCgItmOepDO();
		// 设置就诊id 患者id
		if (StringUtils.isNotEmpty(entDo.getId_ent()) && StringUtils.isNotEmpty(entDo.getId_pat())) {
			itmoep.setId_ent(entDo.getId_ent());
			itmoep.setId_pat(entDo.getId_pat());
			aggdo.setBlCgItmOepDO(new BlCgItmOepDO[] { itmoep });
			aggdo.setParentDO(cgOep);
			list.add(aggdo);
			dto.setBlcgoepAggDO(list);
		} else {
			throw new BizException("保存患者信息失败");
		}

		return dto;
	}
}
