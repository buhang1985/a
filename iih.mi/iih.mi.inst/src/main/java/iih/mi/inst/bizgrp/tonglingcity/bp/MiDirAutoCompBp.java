package iih.mi.inst.bizgrp.tonglingcity.bp;

import iih.mi.bd.d.HpDTO;
import iih.mi.biz.dto.d.MiSrvTp;
import xap.mw.core.data.BizException;

/**
 * 铜陵医保目录自动对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MiDirAutoCompBp {

	public void exec(HpDTO hpDTO, String miSrvTp) throws BizException {
		switch (miSrvTp) {
		case MiSrvTp.DRUG:
			MiDrugDirAutoComp(hpDTO);
			break;
		case MiSrvTp.TREAT:
			MiTreatDirAutoComp(hpDTO);
			break;
		case MiSrvTp.SRVFAC:
			 MiSrvfacDirAutoComp(hpDTO);
			break;
		case MiSrvTp.DI:
			 MiDiDirAutoComp(hpDTO);
			break;
		default:
			break;
		}
	}

	private void MiTreatDirAutoComp(HpDTO hpDTO) throws BizException {
		AutoCompTreatBp bp = new AutoCompTreatBp();
		bp.exec(hpDTO.getId_hp());
	}

	private void MiSrvfacDirAutoComp(HpDTO hpDTO) throws BizException {
		AutoCompSrvfacBp bp = new AutoCompSrvfacBp();
		bp.exec(hpDTO.getId_hp());

	}

	private void MiDiDirAutoComp(HpDTO hpDTO) throws BizException {
		// TODO Auto-generated method stub

	}

	/**
	 * 医保药品目录自动对照
	 * 
	 * @param hpDTO
	 * @throws BizException
	 */
	private void MiDrugDirAutoComp(HpDTO hpDTO) throws BizException {
		AutoCompDrugBp bp = new AutoCompDrugBp();
		bp.exec(hpDTO.getId_hp());
	}
}
