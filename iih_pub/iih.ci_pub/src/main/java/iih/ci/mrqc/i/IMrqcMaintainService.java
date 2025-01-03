package iih.ci.mrqc.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.ci.mr.mrlogdto.d.MrLogDTO;
import iih.ci.mrqc.connonationqcdto.d.ConnonationQcItmDTO;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqc.qared.d.QaRecordDO;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;

public interface IMrqcMaintainService {
	/**
	 * 保存整改通知
	 * @param revnotice
	 * @throws BizException
	 */
	public String SaveRevNotice(RevisionNoticeDO revnotice,QaFltDTO[] qaflt,QaRecordDO qarecord,String id_amr) throws BizException;

	/**
	 * 更新缺陷状态
	 * @param revnotice
	 * @throws BizException
	 */
	public FBoolean updateStatus(QaFltDTO[] qaflt) throws BizException;
	/**
	 * 获取患者的内涵质控项目
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract ConnonationQcItmDTO[] getConnonationQcItmDtos(String id_ent) throws BizException;
	/**
	 * 获取基础数据下所有的内涵质控项目
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract ConnonationQcItmDTO[] getAllConnonationQcItmDtos(String id_ent) throws BizException;
	/**
	 * 保存内涵质控项目
	 * @param revnotice
	 * @throws BizException
	 */
	public abstract FBoolean saveConnonationMrQcItm(ConnonationQcItmDTO[] qcItmDtos,ConnonationQcItmDTO qcItmDto,QaPatListDTO patListDto) throws BizException;
	/**
	 * 获取就诊的所有文书
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract MrLogDTO[] getMrFullLog(String id_ent) throws BizException;
}
