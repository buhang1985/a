package iih.nmr.common.i;

import iih.nmr.pkuf.regformfordeliver.d.RegformfordeliverAggDO;
import xap.mw.core.data.BizException;

public interface INmrMaintainService {
	
	/**
	 * 记录文书数据集采集记录(非标准文书新增操作)
	 * @param aggdos
	 * @param id_set
	 * @param fun_code
	 * @throws BizException
	 */
	public void addMedicalRecordSet(Object[] obj, String id_set, String fun_code) throws BizException;
	/**
	 * 文书删除后手动处理
	 * @param obj
	 * @throws BizException
	 */
	public abstract void deleteMedicalRecordSetByObj(Object[] obj) throws BizException;
	
	/***
	 * 分娩登记表 保存逻辑
	 * @param aggdo
	 * @return
	 * @throws BizException
	 */
	public RegformfordeliverAggDO saveRegformDB(RegformfordeliverAggDO aggdo) throws BizException;
}
