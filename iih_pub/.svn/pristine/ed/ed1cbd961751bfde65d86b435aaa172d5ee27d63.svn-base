package iih.mp.ne.i;

import iih.mp.ne.ntransfusiondto.d.TransfusionDTO;
import iih.mp.ne.transfusiondto.TransfusionRecordDTO;
import iih.mp.ne.transfusiondto.d.PatBannerDTO;
import iih.mp.ne.transfusiondto.d.SrvvtDTO;
import iih.mp.ne.transfusiondto.d.TransfusionBeginDTO;
import iih.mp.ne.transfusiondto.d.TransfusionFinishDTO;
import xap.mw.core.data.BizException;

public interface ITransfusionExtService {

	/**
	 * 获取输血历史记录树列表 Id_ent 就诊ID
	 * */
	public abstract TransfusionRecordDTO[] GetTransfusionRecoderList(String Id_ent) throws BizException;

	/**
	 * 获取体征列表数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract SrvvtDTO[] getSrvvtList() throws BizException;

	/**
	 * 获取输血结束DTO
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract TransfusionFinishDTO getTransfusionFinishDTO() throws BizException;

	/**
	 * 获取输血开始DTO
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract TransfusionBeginDTO getTransfusionBeginDTO() throws BizException;

	/**
	 * 获取患者血液信息
	 * 
	 * @param id_ent
	 * @param id_rptbttest
	 * @return
	 * @throws BizException
	 */
	public PatBannerDTO getPatBannerDTO(String id_ent, String id_rptbttest) throws BizException;

	/**
	 * 初始化输血执行主DTO
	 * @param Id_ent
	 * @return
	 * @throws BizException
	 */
	public TransfusionDTO transfusionInit(String Id_ent) throws BizException;
	
	/**
	 * 输血执行保存
	 * @param Id_ent 
	 * @return
	 * @throws BizException
	 */
	public TransfusionDTO transfusionSave(TransfusionDTO DTO) throws BizException;
	
	/**
	 * 获取输血执行记录
	 * @param Id_nebtr
	 * @return
	 * @throws BizException
	 */
	public TransfusionDTO getTransfusionRecord(String Id_nebtr) throws BizException;

}
