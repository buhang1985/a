package iih.syn.sen.i;

import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.BedQryModDTO;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import iih.en.pv.inpatient.dto.d.IpRegQrySchmDTO;
import iih.mp.nr.dto.batchvs.d.BatchVsPatDTO;
import iih.nmr.pkuf.dto.batchentry.d.BatchEntryPatInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * @Description:临床数据同步基础维护服务
 * @author: yy.zhao @version：2018年6月7日09:04:42
 */
public interface ISynSenQueryService {

	/**
	 * 获取护士工作站患者信息视图
	 * 
	 * @param qryMod
	 * @return
	 * @throws BizException
	 */
	public abstract BedBigCardDTO[] getBedList(BedQryModDTO qryMod) throws BizException;

	/**
	 * 获取出科患者列表
	 * 
	 * @param qrySchm
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<IpRegInfoDTO> getOutDeptList(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo) throws BizException;

	/**
	 * 获取体征批量采集患者列表
	 * 
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public abstract BatchVsPatDTO[] getBatchEntryEntInfo(String id_dep_nur) throws BizException;

	/**
	 * 批量文书患者列表
	 * @param pg
	 * @param id_dep_nur
	 * @param sd_ststus
	 * @param key
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<BatchEntryPatInfoDTO> getPatInfoByPagingInfo(PaginationInfo pg, String id_dep_nur, String sd_ststus, String key) throws BizException;
}
