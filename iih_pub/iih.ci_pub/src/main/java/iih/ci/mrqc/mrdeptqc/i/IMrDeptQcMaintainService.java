package iih.ci.mrqc.mrdeptqc.i;

import iih.bd.srv.dto.d.MrDTO;
import iih.ci.mrqc.itmdto.d.ItmDTO;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqc.qarecorddto.d.QaRecordDTO;
import xap.mw.core.data.BizException;

public interface IMrDeptQcMaintainService {

	/**
	 * 获取科室质控项目列表
	 * @param sd_qctype
	 * @return
	 * @throws BizException
	 */
    public abstract  ItmDTO[] getMrQcDeptItmList(QaPatListDTO qaPatDto) throws BizException;
    /**
     * 保存科室质控缺陷
     * @return
     * @throws BizException
     */
    public abstract  boolean saveMrQcDeptItmList(ItmDTO itmDto,QaPatListDTO qaPatListDto, MrDTO mrDto) throws BizException;
    /**
     * 获取患者科室待整改缺陷列表
     * @param id_ent
     * @param cqf_submit_user
     * @return
     * @throws BizException
     */
    public abstract QaFltDTO[] getMrDeptQcNeedDefectFltList( String id_ent, String cqf_submit_user )throws BizException;
    /**
     * 删除科室质控缺陷
     * @return
     * @throws BizException
     */
    public abstract  boolean deleteMrQcDeptDefectFlt(String id_qaflt) throws BizException;
    /**
     * 保存科室质控缺陷
     * @param qaPatListDto
     * @param qaFltDtos
     * @return
     * @throws BizException
     */
    public abstract  String saveMrDeptQcNoticeAndFlt(QaPatListDTO qaPatListDto, QaFltDTO[] qaFltDtos,int deadDays,String des) throws BizException;
    /**
     * 获取科室质控记录
     * @param qaPatListDto
     * @return
     * @throws BizException
     */
    public abstract QaRecordDTO[] getMrDeptQcQryRecordList(QaPatListDTO qaPatListDto)throws BizException;
    /**
     * 根据通知id 获取 缺陷
     * @param id_revision
     * @return
     * @throws BizException
     */
    public abstract QaFltDTO[] getMrDeptQcDefectFltListByIdRevision(String id_revision) throws BizException;
}
