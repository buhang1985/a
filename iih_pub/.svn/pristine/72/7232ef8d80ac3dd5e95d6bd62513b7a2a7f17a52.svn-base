package iih.hp.cp.i.external.obtain;

import iih.hp.cp.app.qry.d.HpCpAppPatientDTO;
import iih.hp.cp.app.qry.d.QueryParamsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 
 * @ClassName:  IHpCpEnRService   
 * @description 临床路径获取就诊域相关信息
 * @author      chenxiang
 * @date        2020年4月29日 
 * @version:    1.0
 */
public interface IHpCpEnRService {

	/**
	 * 查询临床路径应用患者集合
	 * 
	 * @param nameType		查询类型
	 * @param searchText	查询文本
	 * @param queryParams	在院标识、就诊科室、入径时间
	 * @return
	 * @throws BizException
	 */
	public HpCpAppPatientDTO[] getHpCpAppPatients(String nameType, String searchText, QueryParamsDTO queryParams) throws BizException;
	
	/**
	 * 查询临床路径应用患者集合(分页)
	 * 
	 * @param nameType		查询类型
	 * @param searchText	查询文本
	 * @param queryParams	在院标识、就诊科室、入径时间
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HpCpAppPatientDTO> getHpCpAppPatientList(PaginationInfo pg, String nameType, String searchText, QueryParamsDTO queryParams) throws BizException; 
}
