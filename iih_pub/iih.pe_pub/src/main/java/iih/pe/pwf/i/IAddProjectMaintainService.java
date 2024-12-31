package iih.pe.pwf.i;

import iih.pe.pitm.pesrvbcatlog.d.PeSrvbCatlogDO;
import iih.pe.pwf.perst.d.PeRstDO;
import xap.mw.core.data.BizException;

public interface IAddProjectMaintainService {
	public void AddProject(PeSrvbCatlogDO[] pe, String id_apt, String id_set, String fg_psn) throws BizException;
	/**
	 * 数据同步，录入检验结果，同步到pe_wf_perstlis, pe_wf_perstlisitm
	 */
	public void changeData(PeRstDO[] peRstDOs) throws BizException ;
}
