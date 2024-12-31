package iih.mp.ne.i;

import iih.mp.ne.bedsidespeccollect.d.CondDTO;
import iih.mp.ne.bedsidespeccollect.d.SpecCollectionDTO;
import iih.mp.ne.collect.d.PatDTO;
import iih.mp.ne.collect.d.SampleListDTO;
import iih.mp.nr.mpcharge.d.MpChargeRltDTO;
import iih.mp.nr.mpnelabsamp.d.LabSampDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface ISampleCollectionExtService {

	/*
	 * 获取标签列表 Id_ent 就诊ID BeginDate 开始时间 EndDate 结束时间
	 */
	public abstract SampleListDTO[] GetSampleList(String Id_ent, String BeginDate, String EndDate) throws BizException;

	/*
	 * 获取患者列表 Id_ent 就诊ID BeginDate 开始时间 EndDate 结束时间
	 */
	public abstract PatDTO[] GetPatList(String Code_entp, String Sd_status, String Id_dep_nur, String WhereType, String Key) throws BizException;

	/*
	 * 床旁采集保存 Id_ent 就诊ID BeginDate 开始时间 EndDate 结束时间
	 */
	public abstract LabSampDO[] SampCollectSave(LabSampDO[] SampDOS) throws BizException;
	
	/**
	 * 根据条码获取检验标本
	 * @param np_bar
	 * @return
	 * @throws BizException
	 */
	public SpecCollectionDTO GetSpecListByNobar(String no_bar) throws BizException;

	/**
	 * 获取检验标本2.0（分页）
	 * 
	 * @param condDTO
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<SpecCollectionDTO> GetSpecList(PaginationInfo pg, CondDTO condDTO) throws BizException;

	/**
	 * 床旁标本采集保存2.0
	 * 
	 * @param id_samples
	 * @param fg_postpaid
	 * @return
	 * @throws BizException
	 */
	public abstract MpChargeRltDTO[] SpecCollectSave(String[] id_samples, FBoolean fg_postpaid, String fun_code, Integer mp_tp, String sd_skip_reason) throws BizException;

}
