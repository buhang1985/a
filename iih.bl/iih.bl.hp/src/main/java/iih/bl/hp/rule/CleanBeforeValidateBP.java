package iih.bl.hp.rule;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;

/**
 * 
 * @author 
 *
 */
public class CleanBeforeValidateBP {
	/**
	 * 返回的内容中不包括不限量药品
	 * 
	 * @param ciHpCheckDTO 原始保存的医嘱
	 * @return
	 * @throws BizException
	 */
	public CiHpCheckDTO exec(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		// if(ciHpCheckDTO.getEntdo().getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP))
		if (ciHpCheckDTO != null && ciHpCheckDTO.getEntdo() != null
				&& IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ciHpCheckDTO.getEntdo().getCode_entp())) {
			FArrayList2 HpQryCiorderDTOF_save = ciHpCheckDTO.getSavecidto();
			for (Object hpQryCiorderDTO1 : HpQryCiorderDTOF_save) {
				HpQryCiorderDTO hpQryCiorderDTO = (HpQryCiorderDTO) hpQryCiorderDTO1;
				FArrayList2 ordsrvs = hpQryCiorderDTO.getOrdsrvs();

				FArrayList2 ordsrvmms = hpQryCiorderDTO.getOrdsrvmms();
				List<String> id_mmLst = ciHpCheckDTO.getId_mmLst();
				if (id_mmLst == null || id_mmLst.size() == 0) {
					return ciHpCheckDTO;
				}
				for (Object ordSrvMmDO1 : ordsrvmms) {
					OrdSrvMmDO ordSrvMmDO = (OrdSrvMmDO) ordSrvMmDO1;
					if (id_mmLst.contains(ordSrvMmDO.getId_mm())) {
						FArrayList2 new_ordsrvs = new FArrayList2();
						for (Object ordSrvDO1 : ordsrvs) {
							OrdSrvDO ordSrvDO = (OrdSrvDO) ordSrvDO1;
							//review by yangyang 2017-06-14 医嘱服务对应服务物品属性
							if (ordSrvMmDO.getId_srv().compareTo(ordSrvDO.getId_srv()) != 0) {
								//	                         if (!ordSrvMmDO.getId_srv().equals(ordSrvDO.getId_srv())) {
								new_ordsrvs.add(ordSrvDO);
							}
						}
						hpQryCiorderDTO.setOrdsrvs(new_ordsrvs);
					}
				}
			}
		}
		return ciHpCheckDTO;
	}
}
