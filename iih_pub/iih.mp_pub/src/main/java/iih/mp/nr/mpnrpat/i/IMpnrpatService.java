package iih.mp.nr.mpnrpat.i;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.mp.nr.batchskintest.d.BatchPatDTO;
import iih.mp.nr.euprint.d.Euprintdto;
import iih.mp.nr.exenur.d.ExecNurCondDTO;
import iih.mp.nr.fivecolorpats.d.FivecolorpatsDTO;
import iih.mp.nr.mpnrpat.d.Mpnrpatdto;

public interface IMpnrpatService {
	/**
	 * 
	 * @param name
	 * @return Mpnrpatdto[]
	 * @throws BizException
	 */
	public abstract Mpnrpatdto[] GetMpnrpatdtos(String depnur,String type,String key) throws BizException;
	
	public abstract Euprintdto[] GetEuprintdtos(String depnur,String type,String key) throws BizException;
	
	//批量皮试患者列表
	public abstract BatchPatDTO[] GetBatchpatdtos(String depnur,String type,String key) throws BizException;

	/**
	 * 患者列表分页
	 * @param pg
	 * @param depnur
	 * @param type
	 * @param key
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<Euprintdto> GetPatinfoByPage(PaginationInfo pg, String depnur, String type, String key,ExecNurCondDTO condDto) throws BizException;
    
	/**
	 * 
	* @Title: getFivecolorpatsDTOs 
	* @Description: 获取孕产妇五色卡患者列表(因GetEuprintdtos中返回Euprintdto[]的dt_birth字段是FDATE类型,婴儿无法展示准确的小时,所以新增方法)
	* @date 2019年7月15日 上午10:36:56 
	* @param @param depnur
	* @param @param type
	* @param @param key
	* @param @return
	* @param @throws BizException 设定文件 
	* @return FivecolorpatsDTO[] 返回类型 
	* @throws
	 */
    public abstract FivecolorpatsDTO[] getFivecolorpatsDTOs(String depnur,String type,String key) throws BizException;
    /**
	 * 批量医嘱查看患者列表
	 * 
	 * @param depnur
	 * @param type
	 * @param key
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<Euprintdto> GetPageOrPatInfo(PaginationInfo pg,String depnur, String type, String key) throws BizException;
}
