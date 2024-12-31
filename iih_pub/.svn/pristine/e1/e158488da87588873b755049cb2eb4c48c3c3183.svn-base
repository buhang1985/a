package iih.ci.mrqc.mrprocessqc.i;

import iih.bd.srv.dto.d.MrDTO;
import iih.ci.mrqc.itmdto.d.ItmDTO;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqc.qarecorddto.d.QaRecordDTO;
import xap.mw.core.data.BizException;

public interface IMrProcessQcMaintainService {

	/**
	 * 获取环节质控项目列表
	 * @param sd_qctype
	 * @return
	 * @throws BizException
	 */
    public abstract  ItmDTO[] getMrQcProcessItmList(QaPatListDTO qaPatDto) throws BizException;
    /**
     * 保存环节质控缺陷
     * @return
     * @throws BizException
     */
    public abstract  boolean saveMrQcProcessItmList(ItmDTO itmDto,QaPatListDTO qaPatListDto, MrDTO mrDto) throws BizException;
    /**
     * 获取患者环节待整改缺陷列表
     * @param id_ent
     * @param cqf_submit_user
     * @return
     * @throws BizException
     */
    public abstract QaFltDTO[] getMrProcessQcNeedDefectFltList( String id_ent, String cqf_submit_user )throws BizException;
    /**
     * 删除环节质控缺陷
     * @return
     * @throws BizException
     */
    public abstract  boolean deleteMrQcProcessDefectFlt(String id_qaflt) throws BizException;
    /**
     * 保存环节质控缺陷
     * @param qaPatListDto
     * @param qaFltDtos
     * @return
     * @throws BizException
     */
    public abstract  String saveMrProcessQcNoticeAndFlt(QaPatListDTO qaPatListDto, QaFltDTO[] qaFltDtos,int deadDays,String des) throws BizException;
    /**
     * 获取环节质控记录
     * @param qaPatListDto
     * @return
     * @throws BizException
     */
    public abstract QaRecordDTO[] getMrProcessQcQryRecordList(QaPatListDTO qaPatListDto)throws BizException;
    /**
     * 根据通知id 获取 缺陷
     * @param id_revision
     * @return
     * @throws BizException
     */
    public abstract QaFltDTO[] getMrProcessQcDefectFltListByIdRevision(String id_revision) throws BizException;
}
