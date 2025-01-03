package iih.ci.ord.s.bp.validate.skintest;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.s.bp.ems.save.op.CiOrSkinTestOrBuildBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 诊疗皮试医嘱保存逻辑
 * @author zhangwq
 *
 */
public class SaveTreatSkinBP implements ISaveSkinBP{
	private CiEnContextDTO ciEnContextDTO;
	public SaveTreatSkinBP(){
		ciEnContextDTO = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
	}
	public CiOrderDO save(CiOrderDO orderDO ,String id_srvskin) throws BizException{
		CiEmsDTO ciEmsDTO = transToCiEmsDTO8CiOrderDO(orderDO);
		CiOrSkinTestOrBuildBP bp = new CiOrSkinTestOrBuildBP();
		CiEmsDTO skinems = bp.exec(id_srvskin, ciEmsDTO);
		CiOrderDO[] skinTestOrders = this.saveOrder(skinems, ciEnContextDTO);
		if(skinTestOrders !=null && skinTestOrders.length>0){
			return skinTestOrders[0];
		}else{
			throw new BizException("皮试医嘱保存失败");
		}
	}
	/**
	 * 将药品医嘱的CiOrderDO转换为CiEmsDTO,用于复用之前的的逻辑
	 * 
	 * @param orderDO
	 * @return
	 */
	private CiEmsDTO transToCiEmsDTO8CiOrderDO(CiOrderDO orderDO) {
		CiEmsDTO ciEmsDTO = new CiEmsDTO();
		ciEmsDTO.setId_pat(orderDO.getId_pat());
		ciEmsDTO.setId_en(orderDO.getId_en());
		ciEmsDTO.setId_entp(orderDO.getId_entp());
		ciEmsDTO.setCode_entp(orderDO.getCode_entp());
		ciEmsDTO.setId_emp_phy(orderDO.getId_emp_or());
		ciEmsDTO.setId_dep_phy(orderDO.getId_dep_or());
		ciEmsDTO.setId_dept_en(orderDO.getId_dep_ns());
		ciEmsDTO.setId_dept_ns(orderDO.getId_dep_nur());
		ciEmsDTO.setId_wg_or(orderDO.getId_wg_or());
		ciEmsDTO.setDt_invalid(orderDO.getDt_invalid());
		ciEmsDTO.setFg_bb(orderDO.getFg_bb());
		ciEmsDTO.setNo_bb(orderDO.getNo_bb());
		ciEmsDTO.setFg_pmor(orderDO.getFg_pmor());
		ciEmsDTO.setDes_pmor(orderDO.getDes_pmor());
		ciEmsDTO.setFg_active_pm(orderDO.getFg_active_pm());
		ciEmsDTO.setDt_begin(orderDO.getDt_effe());
		ciEmsDTO.setCode_entp(orderDO.getCode_entp());
		ciEmsDTO.setFg_long(orderDO.getFg_long());
		ciEmsDTO.setId_freq(orderDO.getId_freq());
		ciEmsDTO.setTimes_firday_mp(orderDO.getQuan_firday_mp());
		ciEmsDTO.setId_srvof(orderDO.getId_srvof());
		ciEmsDTO.setFg_mp_bed(orderDO.getFg_mp_bed());
		ciEmsDTO.setFg_pres_outp(orderDO.getFg_pres_outp());
		return ciEmsDTO;
	}
	@Override
	public CiOrderDO[] saveOrder(CiEmsDTO skinems, CiEnContextDTO ciEnContextDTO) throws BizException {
		ICiOrdMaintainService ordMaintainService = ServiceFinder.find(ICiOrdMaintainService.class);
		CiOrderDO skinTestOrder = ordMaintainService.SaveCiEmsDTO(skinems, ciEnContextDTO);
		return new CiOrderDO[]{skinTestOrder};
	}
	
}
