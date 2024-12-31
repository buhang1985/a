package iih.ci.mrqc.mrterminalqc.i;

import iih.bd.srv.dto.d.MrDTO;
import iih.ci.mrqc.itmdto.d.ItmDTO;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqc.qarecorddto.d.QaRecordDTO;
import xap.mw.core.data.BizException;

public interface IMrTerminalQcMaintainService {

	/**
	 * 获取终末评分项目列表
	 * @param sd_qctype
	 * @return
	 * @throws BizException
	 */
    public abstract  ItmDTO[] getMrQcTerminalScoreItmList(QaPatListDTO qaPatDto) throws BizException;
    /**
     * 保存终末评分
     * @return
     * @throws BizException
     */
    public abstract  boolean saveMrQcTerminalScoreItmList(ItmDTO[] itmDtoArr,QaPatListDTO qaPatListDto) throws BizException;
    /**
     * 获取终末评分记录
     * @param qaPatListDto
     * @return
     * @throws BizException
     */
    public abstract QaRecordDTO[] getMrQcTerminalScoreQryRecordList(QaPatListDTO qaPatListDto)throws BizException;
    
    
    
    /**
	 * 获取终末质控项目列表
	 * @param sd_qctype
	 * @return
	 * @throws BizException
	 */
    public abstract  ItmDTO[] getMrQcTerminalItmList(QaPatListDTO qaPatDto) throws BizException;
    /**
     * 保存终末质控缺陷
     * @return
     * @throws BizException
     */
    public abstract  boolean saveMrQcTerminalItmList(ItmDTO itmDto,QaPatListDTO qaPatListDto, MrDTO mrDto) throws BizException;
    /**
     * 获取患者终末待整改缺陷列表
     * @param id_ent
     * @param cqf_submit_user
     * @return
     * @throws BizException
     */
    public abstract QaFltDTO[] getMrTerminalQcNeedDefectFltList( String id_ent, String cqf_submit_user )throws BizException;
    /**
     * 删除终末质控缺陷
     * @return
     * @throws BizException
     */
    public abstract  boolean deleteMrQcTerminalDefectFlt(String id_qaflt) throws BizException;
    /**
     * 保存终末质控缺陷
     * @param qaPatListDto
     * @param qaFltDtos
     * @return
     * @throws BizException
     */
    public abstract  String saveMrTerminalQcNoticeAndFlt(QaPatListDTO qaPatListDto, QaFltDTO[] qaFltDtos,int deadDays,String des) throws BizException;
    /**
     * 获取终末质控记录
     * @param qaPatListDto
     * @return
     * @throws BizException
     */
    public abstract QaRecordDTO[] getMrTerminalQcQryRecordList(QaPatListDTO qaPatListDto)throws BizException;
    /**
     * 根据通知id 获取 缺陷
     * @param id_revision
     * @return
     * @throws BizException
     */
    public abstract QaFltDTO[] getMrTerminalQcDefectFltListByIdRevision(String id_revision) throws BizException;
}
