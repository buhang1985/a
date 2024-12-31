package iih.mp.nr.vitalsigns.i;

import iih.mp.nr.dto.batchvs.d.VsHrzRowDTO;
import iih.mp.nr.dto.signshoriz.d.PatVtInfoDTO;
import iih.mp.nr.visgncollectsingle.d.VisgnsingleTreeDTO;
import iih.mp.nr.vitalsigns.dto.d.RowDTO;
import xap.mw.core.data.BizException;

public interface IVitalSignsSaveService {

	/**
	 * 保存
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract RowDTO[] save(RowDTO[] rows) throws BizException;

	/**
	 * 垂直体征控件保存
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract RowDTO[] saveVsForVertical(RowDTO[] rows) throws BizException;

	/**
	 * 水平体征控件保存
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract PatVtInfoDTO[] saveVsForHorizontal(PatVtInfoDTO[] patVtInfoDTOs) throws BizException;

	/**
	 * 体征主表信息保存
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract VisgnsingleTreeDTO[] singleVsSave(String id_mrtpl_vst, VisgnsingleTreeDTO param) throws BizException;

	/**
	 * 删除体征信息
	 * 
	 * @param id_mr_vs
	 * @throws BizException
	 */
	public abstract void deleteVsInfo(String[] id_mr_vs) throws BizException;

	/**
	 * 移动端调用体征保存逻辑
	 * 
	 * @param patInfoDTO
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean mobileSignSave(PatVtInfoDTO patInfoDTO) throws BizException;
	
	/**
	 * 保存（新）水平体征采集记录
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract VsHrzRowDTO[] saveHorizVs(VsHrzRowDTO[] params) throws BizException;
}
