package iih.ci.mr.mrws.hosgetmr.i;

import java.io.IOException;

import javax.jws.WebService;

import xap.mw.core.data.BizException;

@WebService
public interface  IMrWsForHosSysService {

	/**
	 * ws上传病案文件(不推荐使用)
	 * @param code_pat
	 * @param times_inhos
	 * @param id_busy
	 * @param id_set
	 * @param name
	 * @param file
	 * @param idClear
	 * @param sortNo
	 * @return
	 * @throws IOException
	 * @throws BizException
	 */
	@Deprecated
	public abstract boolean AddMrmFileInfo(String code_pat,String times_inhos,String id_busy,String id_set,String name,
			String file,Boolean idClear,int sortNo) throws IOException , BizException;
	
	/**
	 * ws上传病案文件
	 * @param code_pat
	 * @param times_inhos
	 * @param code_ent
	 * @param id_busy
	 * @param id_set
	 * @param name
	 * @param file
	 * @param isClear
	 * @param sortNo
	 * @param tCount
	 * @return
	 * @throws IOException
	 * @throws BizException
	 */
	public abstract boolean UpLoadMrmFileInfo(String code_pat, String times_inhos,String code_ent, String id_busy, String id_set, String name,
			String file, Boolean isClear, int sortNo,int tCount) throws  IOException , BizException;
	/**
	 * 更新病案文件统计信息
	 * @param code_pat
	 * @param times_inhos
	 * @param code_ent
	 * @param id_set
	 * @param tCount
	 * @return
	 * @throws IOException
	 * @throws BizException
	 */
	public abstract boolean UpdateMrmStatisticsInfo(String code_pat, String times_inhos,String code_ent,String id_set, int tCount) throws  IOException , BizException;
}
