package iih.syn.common.i;

import iih.syn.common.dto.mdsyn.d.ReviewCondDTO;
import iih.syn.common.dto.mdsyn.d.SynParamDTO;
import iih.syn.common.dto.mdsyn.d.ThrCodeCompDTO;
import iih.syn.common.init.d.InitAggDO;
import iih.syn.common.init.d.SynInitDO;
import iih.syn.common.initca.d.InitCaDO;
import iih.syn.common.syninitapp.d.SyninitappAggDO;
import xap.dp.dmengine.d.PropertyDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface ISynQueryService {

	/**
	 * 获取指定实体下的全部属性
	 * @return
	 * @throws BizException
	 */
	public abstract PropertyDO[] getPropByClassID(String[] id_classs) throws BizException;
	
	/**
	 * 手动同步数据
	 * @return
	 * @throws BizException
	 */
	public abstract void execUnit(SynParamDTO[] inParams) throws BizException;
	
	/**
	 * 获取主数据第三方对照编码
	 * @param id_mdm_ca
	 * @param id_thrdrpt
	 * @return
	 * @throws BizException
	 */
	public abstract ThrCodeCompDTO[] getCopmareCode(String[] id_mdm_ca,String id_thrdrpt)throws BizException;
	
	/**
	 * 获取基础数据初始化列表
	 * @return
	 * @throws BizException
	 */
	public abstract InitAggDO[] getDataInitList()throws BizException;
	
	/**
	 * 获取初始化分类列表
	 * @return
	 * @throws BizException
	 */
	public abstract InitCaDO[] getDataInitCaList()throws BizException;
	
	/**
	 * 获取当前组织允许申请的初始化列表
	 * @return
	 * @throws BizException
	 */
	public abstract SynInitDO[] getOrgAppInits() throws BizException;
	
	/**
	 * 获取当前组织申请初始化信息列表
	 * @return
	 * @throws BizException
	 */
	public abstract SyninitappAggDO[] getOrgAppList() throws BizException;
	
	/**
	 * 获取下载子项信息
	 * @param id_init
	 * @return
	 * @throws BizException
	 */
    public abstract SynInitDO[] getOrgDownloadItms(String id_init,FBoolean fg_local)throws BizException;
    
    /**
     * 根据条件获取申请初始化信息列表
     * @param cond
     * @return
     * @throws BizException
     */
    public SyninitappAggDO[] getAppList(ReviewCondDTO cond) throws BizException;
    
    /**
     * 获取当前组织下允许新增的初始化申请
     * @param cond
     * @return
     * @throws BizException
     */
    public InitAggDO[] getOrgAddAppList() throws BizException;
}
