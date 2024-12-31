package iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.mi.constant.IMiMcCheckConst;
import iih.mi.mc.dto.mimcdidependrule.d.MiMcCiOrdMmDTO;
import iih.mi.mc.dto.mimcdidependrule.d.MiMcDiDependOutParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 设置诊断依赖校验返回信息
 * 
 * @author LIM
 *
 */
public class SetDiDependDTOBP {
	/**
	 * 组织返回信息
	 * @param diagDefDO
	 * @param ordSrvDO
	 * @param ordSrvMmDO
	 * @param msg
	 * @return
	 * @throws BizException
	 */
	public MiMcDiDependOutParamDTO exec(DiagDefDO diagDefDO, MiMcCiOrdMmDTO dto , String msg)
			throws BizException {
		MiMcDiDependOutParamDTO diDependDTO = new MiMcDiDependOutParamDTO();
		if (diagDefDO != null) {
			diDependDTO.setCode_di(diagDefDO.getCode());
			diDependDTO.setName_di(diagDefDO.getName());
		}
		if (dto != null) {
			diDependDTO.setCode_srv(dto.getCode_srv());
			diDependDTO.setName_srv(dto.getName_srv());
			diDependDTO.setCode_mm(dto.getCode_mm());
			diDependDTO.setName_mm(dto.getName_mm());
		}
		diDependDTO.setFg_delete(FBoolean.FALSE);
		diDependDTO.setEu_dpndrsn(IMiMcCheckConst.MI_DE_SUPMED);
		diDependDTO.setDesc_dpndrsn(msg);
		return diDependDTO;
	}
}
