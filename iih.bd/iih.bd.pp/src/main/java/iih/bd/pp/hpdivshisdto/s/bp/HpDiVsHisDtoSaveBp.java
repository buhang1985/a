package iih.bd.pp.hpdivshisdto.s.bp;

import iih.bd.pp.hpdidict.d.HpDiDictDO;
import iih.bd.pp.hpdidictah.d.HpDiDictAhDO;
import iih.bd.pp.hpdivshis.d.HpDiVsHisDO;
import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * HpDiVsHisDto保存Bp
 * @author guoyang
 *
 */
public class HpDiVsHisDtoSaveBp {
	
	public HpDiVsHisDTO[] exec(HpDiVsHisDTO[] hpDiVsHisDTOs) throws DAException{
		if(hpDiVsHisDTOs != null && hpDiVsHisDTOs.length > 0){
			HpDiDictDO[] hpDiDictDOs = new HpDiDictDO[hpDiVsHisDTOs.length];
			HpDiDictAhDO[] hpDiDictAhDOs = new HpDiDictAhDO[hpDiVsHisDTOs.length];
			HpDiVsHisDO[] hpDiVsHisDOs = new HpDiVsHisDO[hpDiVsHisDTOs.length];
			for (int i = 0; i < hpDiVsHisDTOs.length; i++) {
				String id_hpdict = new DBUtil().getOIDs(1)[0];
				hpDiDictDOs[i] = setHpDiDictDO(hpDiVsHisDTOs[i], id_hpdict);
				hpDiDictAhDOs[i] = setHpDiDictAhDO(hpDiVsHisDTOs[i], id_hpdict);
				hpDiVsHisDOs[i] = setHpDiVsHisDO(hpDiVsHisDTOs[i], id_hpdict);
			}
			HpDiVsHisDtoDeleteBp bp = new HpDiVsHisDtoDeleteBp();
			bp.exec(hpDiVsHisDTOs);
			String[] hpDiDictArr = new DAFacade().insertDOArrayWithPK(hpDiDictDOs);
			new DAFacade().insertDOArrayWithPK(hpDiDictAhDOs);
			String[] divshisArr = new DAFacade().insertDOs(hpDiVsHisDOs);
			for (int i = 0; i < hpDiVsHisDTOs.length; i++) {
				hpDiVsHisDTOs[i].setId_hpdivshis(divshisArr[i]);
				hpDiVsHisDTOs[i].setId_hpdidict(hpDiDictArr[i]);
				hpDiVsHisDTOs[i].setEu_status(HpStatusEnum.REVIEW);
			}
		}
		return hpDiVsHisDTOs;
	}
	
	/**
	 * 给HpDiDictDO赋值
	 * @param hpDiVsHisDTO
	 * @param id_hpdict
	 * @return
	 */
	private HpDiDictDO setHpDiDictDO(HpDiVsHisDTO hpDiVsHisDTO, String id_hpdict) {
		HpDiDictDO hpDiDictDO = new HpDiDictDO();
		hpDiDictDO.setId_hpdidict(id_hpdict);
		hpDiDictDO.setId_grp(Context.get().getGroupId());
		hpDiDictDO.setId_org(Context.get().getOrgId());
		hpDiDictDO.setId_hp(hpDiVsHisDTO.getId_hp());
		hpDiDictDO.setCode(hpDiVsHisDTO.getHpdidict_code());
		hpDiDictDO.setName(hpDiVsHisDTO.getHpdidict_name());
		return hpDiDictDO;
	}
	
	
	/**
	 * 给HpDiDictAhDO赋值
	 * @param hpDiVsHisDTO
	 * @param id_hpdict
	 * @return
	 */
	private HpDiDictAhDO setHpDiDictAhDO(HpDiVsHisDTO hpDiVsHisDTO, String id_hpdict) {
		HpDiDictAhDO hpDiDictAhDO = new HpDiDictAhDO();
		hpDiDictAhDO.setId_hpdidict(id_hpdict);
		hpDiDictAhDO.setId_grp(Context.get().getGroupId());
		hpDiDictAhDO.setId_org(Context.get().getOrgId());
		hpDiDictAhDO.setClassific_di(hpDiVsHisDTO.getClassific_di());
		hpDiDictAhDO.setStr_di_spec(hpDiVsHisDTO.getStr_di_spec());
		hpDiDictAhDO.setStr_di_pay(hpDiVsHisDTO.getStr_di_pay());
		hpDiDictAhDO.setClassific_di_spec(hpDiVsHisDTO.getClassific_di_spec());
		hpDiDictAhDO.setStr_treatment_plan(hpDiVsHisDTO.getStr_treatment_plan());
		hpDiDictAhDO.setPay_max(hpDiVsHisDTO.getPay_max());
		hpDiDictAhDO.setTr_bind_deductible(hpDiVsHisDTO.getTr_bind_deductible());
		hpDiDictAhDO.setPay_small_45_oep(hpDiVsHisDTO.getPay_small_45_oep());
		hpDiDictAhDO.setPay_big_45_oep(hpDiVsHisDTO.getPay_big_45_oep());
		hpDiDictAhDO.setPay_small_45_ip(hpDiVsHisDTO.getPay_small_45_ip());
		hpDiDictAhDO.setPay_big_45_ip(hpDiVsHisDTO.getPay_big_45_ip());
		hpDiDictAhDO.setPay_retire_oep(hpDiVsHisDTO.getPay_retire_oep());
		hpDiDictAhDO.setPay_retire_ip(hpDiVsHisDTO.getPay_retire_ip());
		hpDiDictAhDO.setAmt_amount_disease(hpDiVsHisDTO.getAmt_amount_disease());
		hpDiDictAhDO.setPy_code(hpDiVsHisDTO.getPy_code());
		hpDiDictAhDO.setWb_code(hpDiVsHisDTO.getWb_code());
		hpDiDictAhDO.setZdy_code(hpDiVsHisDTO.getZdy_code());
		hpDiDictAhDO.setStr_effective(hpDiVsHisDTO.getStr_effective());
		hpDiDictAhDO.setId_emp_handle(hpDiVsHisDTO.getId_emp_handle());
		hpDiDictAhDO.setDt_handle(hpDiVsHisDTO.getDt_handle());
		hpDiDictAhDO.setPay_mx_small_45oep(hpDiVsHisDTO.getPay_mx_small_45oep());
		hpDiDictAhDO.setPay_mx_big_45oep(hpDiVsHisDTO.getPay_mx_big_45oep());
		hpDiDictAhDO.setDes(hpDiVsHisDTO.getDes());
		return hpDiDictAhDO;
	}
	
	/**
	 * 给HpDiVsHisDO赋值
	 * @param hpDiVsHisDTO
	 * @param id_hpdict
	 * @return
	 */
	private HpDiVsHisDO setHpDiVsHisDO(HpDiVsHisDTO hpDiVsHisDTO, String id_hpdict) {
		HpDiVsHisDO hpDiVsHisDO = new HpDiVsHisDO();
		hpDiVsHisDO.setId_grp(Context.get().getGroupId());
		hpDiVsHisDO.setId_org(Context.get().getOrgId());
		hpDiVsHisDO.setId_hp(hpDiVsHisDTO.getId_hp());
		hpDiVsHisDO.setId_hpdidict(hpDiVsHisDTO.getId_hpdidict());
		hpDiVsHisDO.setId_didef(hpDiVsHisDTO.getId_didef());
		hpDiVsHisDO.setId_hpdidict(id_hpdict);
		hpDiVsHisDO.setEu_status(HpStatusEnum.REVIEW);
		return hpDiVsHisDO;
	}
}
