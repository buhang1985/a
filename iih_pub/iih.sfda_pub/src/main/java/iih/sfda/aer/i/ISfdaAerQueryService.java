package iih.sfda.aer.i;

import iih.sfda.aer.dto.sfdaaerinfodto.d.SfdaEvInfoDTO;
import iih.sfda.aer.dto.sfdapatentinfo.d.PatEntInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface ISfdaAerQueryService {

	/**
	 * 不良上报事件查询
	 * 
	 * @param id_aer_ev
	 * @return
	 * @throws BizException
	 * @author guo.xiao
	 */
	public abstract SfdaEvInfoDTO getAerEventReport(String id_aer_ev,
			String fullClassName) throws BizException;

	/**
	 * 获取患者及就诊信息
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract PatEntInfoDTO getPatEntInfo(String id_pat, String codetp)
			throws BizException;
	/**
	 * 获取患者及就诊信息列表
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<PatEntInfoDTO> getPatAndEntList(PaginationInfo pg, String text_cond) throws BizException;


}
