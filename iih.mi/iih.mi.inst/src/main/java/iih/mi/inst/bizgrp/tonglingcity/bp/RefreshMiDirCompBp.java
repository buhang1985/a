package iih.mi.inst.bizgrp.tonglingcity.bp;

import iih.mi.bd.d.HpDTO;
import iih.mi.biz.dto.d.MiSrvTp;
import xap.mw.core.data.BizException;

/**
 * 刷新医保目录对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class RefreshMiDirCompBp {

	public void exec(HpDTO hpDTO, String miSrvTp) throws BizException {
		switch (miSrvTp) {
		case MiSrvTp.DRUG:
			RefreshMiDrugDirComp(hpDTO);
			break;
		case MiSrvTp.TREAT:
			MiTreatDirAutoComp(hpDTO);
			break;
		case MiSrvTp.DI:
			// MiDiDirAutoComp();
			break;
		default:
			break;
		}
	}

	/**
	 * 刷新医保诊疗和服务设施目录对照
	 * 
	 * @param hpDTO
	 * @throws BizException
	 */
	private void MiTreatDirAutoComp(HpDTO hpDTO) throws BizException {
		RefreshTreatAndFwssCompBp bp = new RefreshTreatAndFwssCompBp();
		bp.exec(hpDTO);
	}

	/**
	 * 刷新医保药品目录对照
	 * 
	 * @param hpDTO
	 * @throws BizException
	 */
	private void RefreshMiDrugDirComp(HpDTO hpDTO) throws BizException {
		RefreshDrugCompBp bp = new RefreshDrugCompBp();
		bp.exec(hpDTO);
	}
}
