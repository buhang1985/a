package iih.en.doc.i;

import iih.en.doc.pregdoc.dto.d.PregDocDTO;
import iih.en.doc.pregdoc.dto.d.PregDocInfoDTO;
import iih.en.doc.pregdoc.dto.d.PregDocQryDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.jdbc.facade.DAException;

/**
 * 建档查询服务
 * @author renying
 *
 */
public interface IPregDocQryService {

	/**
	 * 根据患者id获取建档信息
	 * 
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	PregDocDTO getPregDoc(String patId) throws BizException;
	
	/**
	 * 根据条件查询建档信息
	 * @param d_begin 开始日期
	 * @param d_end 结束日期
	 * @param isTexted 是否发短信
	 * @return
	 * @throws BizException
	 */
	PregDocInfoDTO[] getPregDocInfo(FDateTime d_begin, FDateTime d_end, FBoolean isTexted) throws BizException;
	
	/**
	 * 建档管理：根据条件查询建档信息
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	PregDocInfoDTO[] getPregDocInfo4Mgr(PregDocQryDTO qryDTO) throws BizException;
	
	/**
	 * 建档查询：根据条件查询产科建档信息
	 * 
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	PregDocInfoDTO[] getPregDocInfos4Qry(PregDocQryDTO qryDTO, String idPat) throws BizException;
	

    /**
     * 根据指定月份 或 指定日期 查询预约数
     * @param time 日期
     * @param monthorday 是查询某个月 还是某一天的
     * @return
     * @throws DAException 
     */
    int getCountPregDocPreg(String[] time, String monthorday) throws DAException;
    
  

    /**
     * 根据指定日期获取建档预约数
     * @param time
     * @return
     * @throws BizException
     */
    int[] findCount(String[] times,String monthorday) throws BizException;
    
    /**
     * 建档查询：根据条件查询产科建档信息
     * 
     * @param qryDTO
     * @return
     * @throws BizException
     */
    PagingRtnData<PregDocInfoDTO> getPregDocPageQry(PregDocQryDTO qryDTO,PaginationInfo pageInfo) throws BizException;

   /**
    * 根据患者id 获取患者基本信息
    * 内部使用
    * @param patId
    * @return
    * @throws BizException 
    */
    PregDocDTO getPregDocInside(String patId) throws BizException;

    /**
     * 根据患者id 获取患者基本信息
     * @param patId
     * @return
     * @throws BizException
     */
    PregDocDTO getPatDoc(String patId) throws BizException;
  
}
