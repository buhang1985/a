package iih.mp.nr.vitalsigns.i;

import iih.mp.mpbd.dto.vshorizgrid.d.VsHrzSrcDTO;
import iih.mp.nr.dto.batchvs.d.BatchVsPatDTO;
import iih.mp.nr.dto.batchvs.d.VsHrzRowDTO;
import iih.mp.nr.dto.signshoriz.d.MeasureInfoDTO;
import iih.mp.nr.dto.signshoriz.d.PatVtInfoDTO;
import iih.mp.nr.dto.vsshortcoll.d.VsShortCollTabDTO;
import iih.mp.nr.vitalsigns.dto.d.HeadDTO;
import iih.mp.nr.vitalsigns.dto.d.RowDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

public interface IVitalSignsService {

	/**
	 * 获取表头结构
	 * 
	 * @return
	 */
	public abstract HeadDTO[] getHeadStruct(String code) throws BizException;

	/**
	 * 获取体征表体结构
	 * 
	 * @return
	 */
	public abstract RowDTO[] getVitalSignBodyStruct(String id_mrtplvt) throws BizException;

	/**
	 * 获取自定义体征表体结构
	 * 
	 * @return
	 */
	public abstract RowDTO[] getVitalSignCustomBodyStruct(String[] id_srvs) throws BizException;

	/**
	 * 获取事件表体结构
	 * 
	 * @return
	 */
	public abstract RowDTO getEventStruct() throws BizException;

	/**
	 * 取体征数据(含结构)
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract RowDTO[] getVitalSignsData(String id_mrtplvt, String[] id_ents, FDateTime dt_measure) throws BizException;

	/**
	 * 取事件数据(含结构)
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract RowDTO[] getEventData(String[] id_ents, FDateTime dt_measure) throws BizException;

	/**
	 * 获取垂直体征事件结构和数据
	 * 
	 * @param id_mrtpl_vst
	 * @param id_ents
	 * @param dt_measure
	 * @return
	 * @throws BizException
	 */
	public abstract RowDTO[] getVerticalEventStructAndData(String[] id_ents, String dt_measure) throws BizException;

	/**
	 * 获取垂直录入的体征控件结构和数据
	 * 
	 * @param id_mrtpl_vst
	 * @param id_ents
	 * @param dt_measure
	 * @return
	 * @throws BizException
	 */
	public abstract RowDTO[] getVerticalStructAndData(String id_mrtpl_vst, String[] id_ents, String dt_measure) throws BizException;
	
	/**
	 * 批量获取垂直录入的体征控件结构和数据
	 * 
	 * @param id_mrtpl_vst
	 * @param id_ents
	 * @param dt_measure
	 * @return
	 * @throws BizException
	 */
	public abstract RowDTO[] getBatchVerticalStructAndData(String id_mrtpl_vst, String[] id_ents, String[] dt_measures) throws BizException;

	/**
	 * 获取垂直体征控自定义项目结构
	 * 
	 * @param id_srvs
	 * @return
	 * @throws BizException
	 */
	public abstract RowDTO[] GetDefVitalsignsBaseStruct(String[] id_srvs, String[] id_ents, String dt_measure) throws BizException;

	/**
	 * 获取体征测量项目列表
	 * 
	 * @param id_mrtpl_vst体征模板id
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public abstract MeasureInfoDTO[] getHorizontalStruct(String id_mrtpl_vst) throws BizException;

	/**
	 * 获取体征测量记录数据
	 * 
	 * @param id_ents
	 *            就诊id
	 * @param dt_vt
	 *            测量时间
	 * @return
	 * @throws BizException
	 */
	public abstract PatVtInfoDTO[] getHorizontalPatVtInfos(String[] id_ents, String[] dt_vts) throws BizException;
	
	/**
	 * 获取（新）水平采集体征模板项目结构
	 * 
	 * @param id_mrtpl_vst
	 * @return
	 * @throws BizException
	 */
	public abstract VsHrzSrcDTO[] getHorizStruct(String id_mrtpl_vst) throws BizException;
	
	/**
	 * 获取（新）水平采集体征测量记录
	 * 
	 * @param id_ents
	 * @param dt_vts
	 * @param fg_dt_point 是否查询时间点
	 * @return
	 * @throws BizException
	 */
	public abstract VsHrzRowDTO[] getHorizStructRecord(BatchVsPatDTO[] ents, String[] dt_vts, boolean fg_dt_point) throws BizException;

	/**
	 * 获取患者体征采集时刻点的体征数据
	 * @return
	 * @throws BizException
	 */
	public abstract VsShortCollTabDTO[] getPatVsCollPoint(String id_mrtpl_vst,String id_ent,String dt_date) throws BizException;
}
