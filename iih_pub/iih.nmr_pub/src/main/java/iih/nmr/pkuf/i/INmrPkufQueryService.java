package iih.nmr.pkuf.i;

import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.mkr.std.deset.d.DeDataSetDO;
import iih.nmr.common.dto.nurcatim.d.NurCaItmDTO;
import iih.nmr.common.dto.nurmacro.d.NurMacroDTO;
import iih.nmr.pkuf.dto.batchentry.d.BatchEntryPatInfoDTO;
import iih.nmr.pkuf.dto.batchentry.d.BatchFuncDTO;
import iih.nmr.pkuf.dto.batchentry.d.InStruPreTreeDTO;
import iih.nmr.pkuf.dto.fivecolorpats.d.FcPatCondDTO;
import iih.nmr.pkuf.dto.fivecolorpats.d.FivecolorpatsDTO;
import iih.nmr.pkuf.dto.nmrlist.d.NmrListDTO;
import iih.nmr.pkuf.dto.property.d.DmproPeryDTO;
import iih.nmr.pkuf.dto.wksnmr.d.WksNmrTreeDTO;
import iih.nmr.pkuf.fivecolor.d.FCCMBdDataDO;
import iih.nmr.pkuf.healthedu.d.Healthedu1AggDO;
import iih.nmr.pkuf.heduplan.d.HeduPlanItemDO;
import iih.nmr.pkuf.iototal.d.InOutTotalDO;
import iih.nmr.pkuf.nmrarchiv.d.NmrarchivDO;
import iih.nmr.pkuf.nmrcoll.d.NmrCollDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface INmrPkufQueryService {

	/**
	 * 获取文书批量录入患者信息列表
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract BatchEntryPatInfoDTO[] getBatchEntryPatInfo() throws BizException;

	/**
	 * 获取文书批量采集树结构数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract NmrCollDO[] getBatchEntryTreeInfo(String[] id_ents, String view_type) throws BizException;

	/**
	 * 获取文书批量预览树数据
	 */
	public abstract InStruPreTreeDTO[] getBatchPreviewTreeInfo(String[] id_ents) throws BizException;

	/**
	 * 获取个人文书预览数据源
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract InStruPreTreeDTO[] getSinglePreviewTree(String id_ent) throws BizException;

	/**
	 * 获取当前用户对应的全部文书数据集集合
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract DeDataSetDO[] getDeptDeSets() throws BizException;

	/**
	 * 获取节点下对应的护理文书参数
	 * 
	 * @param fun_code
	 * @return
	 */
	public abstract BatchFuncDTO[] getFuncParam(String fun_code) throws BizException;

	/**
	 * 实例化患者Banner对象
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public Ent4BannerDTO getBannerEntInfo(String id_ent) throws BizException;

	/**
	 * 获取护理分类数据集
	 * 
	 * @param aggdos
	 * @return
	 * @throws BizException
	 */
	public abstract NurCaItmDTO[] getNurCaitmDTO(String id_own) throws BizException;

	/**
	 * 获取护理文书告知单宏元素数据
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract NurMacroDTO[] getNurMacroData(String id_ent) throws BizException;

	/**
	 * 获取护士站文书列表
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract WksNmrTreeDTO[] getWksNmrTree(String id_ent) throws BizException;
	
	/**
	 * 获取护士站文书新增列表
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract WksNmrTreeDTO[] getEntAddNmrTree(String id_ent,String[] id_nmr_docs) throws BizException;
	
	/**
	 * 获取文书录入的所有信息
	 * @param nmrListDTO
	 * @return
	 * @throws BizException
	 */
	public abstract NmrListDTO[] getNmrListInfo(NmrListDTO nmrListDTO) throws BizException;
	
	/**
	 * 获取病区下的所有住院患者列表
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public abstract NmrListDTO[] getInHosPats(String id_dep_nur) throws BizException;
	
	/**
	 * 获取需要风险提醒的患者的就诊id
	 * @param Ents
	 * @return
	 * @throws BizException
	 */
	public abstract BatchEntryPatInfoDTO[] getRemindEnts(String[] Ents,String RemindCode) throws BizException;
	
	/**
	 * 获取文书护理任务文书风险提醒消息
	 * @param id_ents
	 * @return
	 * @throws BizException
	 */
    public abstract NmrCollDO[] getNmrMsgInfo(String[] id_ents) throws BizException;
    
    /**
	 * 获取需要风险提醒树结构数据
	 * @param id_ents
	 * @param RemindCode
	 * @return
	 * @throws BizException
	 */
	public abstract NmrCollDO[] getBatchEntryTreeRiskmindInfo(String[] id_ents,String RemindCode) throws BizException;
	
	/**
     * 孕产妇五色卡信息采集基础数据过滤
     * @param id_ents
     * @return
     * @throws BizException
     */
	public abstract FCCMBdDataDO[] getFCCMBdDataInfo(String id_ent, Integer eu_color, String name) throws BizException;

    /**
     * 护理文书归档患者数据筛选
     * @param 
     * @return
     * @throws BizException
     */
    public abstract BatchEntryPatInfoDTO[] getNmrarchivpat() throws BizException;

	/**
     * 护理文书归档数据筛选
     * @param id_ent
     * @return
     * @throws BizException
     */
    public abstract NmrarchivDO[] getNmrarchiv(String id_ent) throws BizException;
    
    /**
     * 获取组件属性信息
     * @param id_property
     * @return
     */
    public abstract DmproPeryDTO getProPery(String id_property) throws BizException;
    
    /**
     * 获取组件属性信息
     * @param id_property
     * @return
     */
    public abstract DmproPeryDTO[] getProPeryByIdclass(String id_class) throws BizException;

    
    /**
	 * 获取住院患者及健康教育评价单
	 * 
	 * @param Id_ent就诊
	 *            ID
	 * @param code_udi自定义档案编码
	 * @return
	 * @throws BizException
	 * @author tang.ws
	 */
	public abstract Healthedu1AggDO getEvaluation(String Id_ent, String code_udi) throws BizException;
	
	/**
	 * 出入液量统计查询
	 * @param tableName
	 * @param s
	 * @param params
	 * @param wherePart
	 * @return
	 * @throws DAException
	 */
	public abstract InOutTotalDO getIOInfo(InOutTotalDO inOutTotalDO) throws InstantiationException, IllegalAccessException, BizException;
    
	/**
	 * 获取五色卡患者列表
	 * @param pg
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<FivecolorpatsDTO> getFivecolorpatsDTOs(PaginationInfo pg, FcPatCondDTO cond) throws BizException;

	/**
	 * 实例化功能节点的健康教育计划内容
	 * @param funcode
	 * @return
	 * @throws BizException
	 */
	public abstract HeduPlanItemDO[] initPlanItemDOs(String funcode) throws BizException;
}
