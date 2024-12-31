package iih.bd.srv.mrcamctmserviceext.i;

import iih.bd.srv.dto.d.MrCaCtmMrDTO;
import iih.bd.srv.dto.d.MrDTO;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.mrtpltreeitem.d.MrtplTreeItemDTO;
import xap.mw.core.data.BizException;
import xap.sys.orgfw.org.d.OrgDO;

/**
* 病历模板自定义操作操作接口方法服务
*/
public interface IMrcamctmServiceExt {

    /**
	*  获取医疗记录自定义分类
	*/
    public abstract  MrCaCtmMrDTO[] getMrcactm( String id_ent , String code_entp , Integer hasAll , String docornurse ) throws BizException;
    /**
     * 获取医疗记录自定义分类用于浏览。受参数控制
     * @param id_ent
     * @param code_entp
     * @param hasAll
     * @param docornur
     * @return
     * @throws BizException
     */
    public MrCaCtmMrDTO[] getMrcactmBrowseTree(String id_ent, String code_entp,
			Integer hasAll , String docornur ) throws BizException;
    /**
	 * 获取医疗记录自定义分类
	 * 查询过滤：
	 * 		1.若未完成书写，则查询已提交（或者是审签中和审签完成）的病历
	 * 		2.若已完成书写，则只按照完成书写标志查询，已完成书写则可以查看
	 * 此方法暂时为兰陵使用方法  - by Vampire
	 */
    public abstract  MrCaCtmMrDTO[] getSpecialMrcactm( String id_ent , String code_entp , String docornurse ) throws BizException;
    
    /**
	*  获取医疗记录模版自定义分类
	*/
    public abstract  MrCaCtmMrDTO[] getMrtplcactm( String id_ownorg , String id_dep , String id_user , String code_entp , String docornurse ) throws BizException;

    /**
	*  根据自定义分类获取模板
	*/
    public abstract  EmrTplDO[] GetMrtplByMrCa( String code_entp , String id_ownorg , String id_dep , String id_user , String id_mrcactm , String id_mrtp , String id_owngrp ) throws BizException;
    
    /**
	*  根据自定义分类获取模板
	*/
    public abstract  EmrTplDO[] GetMrtplByMrCa2( String code_entp , String id_ownorg , String id_dep , String id_user , String id_mrcactm , String id_mrtp , String id_owngrp ,String filter ) throws BizException;
    
    /**
     * 根据条件模糊查询模板  ryp
     * @param code_entp
     * @param id_ownorg
     * @param id_dep
     * @param id_user
     * @param id_mrcactm
     * @param id_mrtp
     * @param id_owngrp
     * @return
     */
    public abstract EmrTplDO[] GetMrtplByFilter(  String id_ownorg , String id_dep , String id_user ,  String id_owngrp ,String filter) throws BizException;

    /**
	*  获取医疗记录模板树结点
	*/
    public abstract  MrtplTreeItemDTO[] GetMrtplTreeItems( String code_entp , String id_ownorg , String id_dep , String id_user , String mrtp_name , String id_owngrp ) throws BizException;
    /**
	*  获取医疗记录模板树结点
	*/
    public abstract  MrtplTreeItemDTO[] GetMrtplTreeItems2( String code_entp , String id_ownorg , String id_dep , String id_user , String mrtp_name , String id_owngrp ) throws BizException;
    
    
    
    /**
	*  获取组织
	*/
    public abstract OrgDO[]  GetOrgs(String pk_group) throws BizException;
    
    /**
     * 获取医疗记录自定义分类  
     * 住院医生站使用
     * @param id_ent
     * @param code_entp
     * @param docornurse
     * @return
     * @throws BizException
     */
    public abstract MrCaCtmMrDTO[] getMrcactmForIP( String id_ent , String code_entp , String docornurse,String id_dept ) throws BizException;

    /**
     * 获取多媒体扫描对应的医疗记录自定义分类 
     * @param id_ent
     * @param code_entp
     * @param docornurse
     * @param id_dept
     * @return
     * @throws BizException
     */
    public abstract MrCaCtmMrDTO[] getMrcactmAndScans( String id_ent , String code_entp , String docornurse,String id_dept ) throws BizException;
    /**
     * 获取医疗记录自定义分类  
     * 门诊医生站使用
     * @param id_ent
     * @param code_entp
     * @param hasAll
     * @param docornurse
     * @return
     * @throws BizException
     */
    public abstract MrCaCtmMrDTO[] getMrcactmForOP( String id_ent , String code_entp,String id_dept ) throws BizException;
    /**
     * 获取医疗记录自定义分类  
     * 助手使用
     * @param id_ent
     * @param code_entp
     * @param hasAll
     * @param docornurse
     * @return
     * @throws BizException
     */
    public abstract MrCaCtmMrDTO[] getMrcactmForHelper( String id_ent , String code_entp , Integer hasAll , String docornurse ) throws BizException;
    /**
     * 获取医疗记录自定义分类  
     * 既往病例使用
     * @param id_ent
     * @param code_entp
     * @param hasAll
     * @param docornurse
     * @return
     * @throws BizException
     */
    public abstract MrCaCtmMrDTO[] getMrcactmForPast( String id_ent , String code_entp , Integer hasAll , String docornurse ) throws BizException;

    /**
     * 根据传入的id获取到医疗记录类型自定义分类
     * @param Id_mrcactm 自定义分类
     * @param Id_mrtp 二級分类
     * @return
     */
    MrDTO[] GetMrcactmByIdmrcactm(String Id_mrcactm,String Id_mrtp) throws BizException; 
    /**
     * 获取医疗记录自定义分类  
     * 门诊医生站使用
     * @param id_ent
     * @param code_entp
     * @param hasAll
     * @param docornurse
     * @return
     * @throws BizException
     */
    MrCaCtmMrDTO[] getMrcactmForNur( String id_ent , String code_entp ) throws BizException;
    /**
     * 获取首次病记录 
     * @param id_set
     * @return
     * @throws BizException
     */
    MrTpDO getMrtpForAddView( String id_set) throws BizException;
    
}