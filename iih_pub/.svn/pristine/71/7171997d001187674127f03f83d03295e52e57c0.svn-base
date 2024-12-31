package iih.mbh.bl.i;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import iih.mbh.bl.bltpl.d.BlTplDTO;
import iih.mbh.bl.fee.d.AddedFeeDTO;
import iih.mbh.bl.fee.d.AllDayCostDTO;
import iih.mbh.bl.fee.d.DayFeeTypeDTO;
import iih.mbh.bl.fee.d.PrepayDTO;
import iih.mbh.bl.fee.d.ProFeeDetailInfoDTO;
import iih.mbh.bl.fee.d.ProFeeInfoDTO;
import xap.mw.core.data.BizException;

@WebService
public interface IMbhBlQueryService {
	/**
	 * 查询一日清单的
	 * @param currentDate
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract List<DayFeeTypeDTO> getDayFeeInfo(@WebParam(name="dt_currdate") String dt_currdate, @WebParam(name="id_ent") String id_ent) throws BizException;
	/**
	 * 查询预交金
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract List<PrepayDTO> getPrepayInfo(@WebParam(name="id_ent") String id_ent) throws BizException;
	/**
	 * 查询补费项目
	 * @param id_ent
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	public abstract List<AddedFeeDTO> getAddedFeeList(@WebParam(name="id_ent") String id_ent, @WebParam(name="id_dept") String id_dept) throws BizException;
	
	/**
	 * 查询补费服务（搜索框）
	 * @param term
	 * @return
	 * @throws BizException
	 */
	public abstract List<AddedFeeDTO> getFeeSrvList(@WebParam(name="term") String term,@WebParam(name="id_ent") String id_ent) throws BizException;
	
	/**
	 * 获取总费用清单
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract List<AllDayCostDTO> getAllDayFeeList(@WebParam(name="id_ent") String id_ent) throws BizException;

	/**
	 * 查询项目汇总费用信息
	 * @param term
	 * @return
	 * @throws BizException
	 */
	public abstract List<ProFeeInfoDTO> getProFeeInfos(@WebParam(name="id_ent") String id_ent) throws BizException;

	/**
	 * 查询项目费用明细
	 * @param id_srv
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract List<ProFeeDetailInfoDTO> getProFeeDetailInfos(@WebParam(name="id_srv") String id_srv, @WebParam(name="id_ent") String id_ent) throws BizException;
 
	/**
	 * 常用补费项目
	 * @return
	 * @throws BizException 
	 */
	public abstract List<BlTplDTO> getBlTplList(@WebParam(name="id_ent") String id_ent) throws BizException;

}
