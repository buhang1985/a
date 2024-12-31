package iih.bl.hp.bp;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bl.comm.IBlConst;
import iih.bl.hp.dto.d.DiDependDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
/**
 * 返回依赖性校验消息
 * @author LIM
 *
 */
public class SetDiDependDTOBP {
	public DiDependDTO exec(DiagDefDO diagDefDO,CiOrderDO ciOrderDO,OrdSrvDO ordSrvDO,OrdSrvMmDO ordSrvMmDO,String msg) throws BizException{
		DiDependDTO diDependDTO= new DiDependDTO();
		diDependDTO.setCode_di(diagDefDO.getCode());
		diDependDTO.setName_di(diagDefDO.getName());
		diDependDTO.setFg_delete(FBoolean.FALSE);
		diDependDTO.setEu_dpndrsn(IBlConst.BL_DE_SUPMED);
		diDependDTO.setDesc_dpndrsn(msg);
		diDependDTO.setId_or(ciOrderDO.getId_or());
		diDependDTO.setCode_or(ciOrderDO.getCode_or());
		diDependDTO.setId_orsrv(ordSrvDO.getId_orsrv());
		diDependDTO.setId_srv(ordSrvDO.getId_srv());
		diDependDTO.setName_srv(ordSrvDO.getName_srv());
		diDependDTO.setId_ormm(ordSrvMmDO.getId_orsrvmm());
		diDependDTO.setId_mm(ordSrvMmDO.getId_mm());
		diDependDTO.setName_mm(ordSrvMmDO.getName_mm());
		diDependDTO.setDays_bill(ciOrderDO.getDays_or());
		diDependDTO.setDays_hold(0);
		return diDependDTO;
	}
}
