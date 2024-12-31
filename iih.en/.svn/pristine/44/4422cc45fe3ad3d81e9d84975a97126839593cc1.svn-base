package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 获取患者挂号信息
 * @author yank
 *
 */
public class GetRegInfoByPatBP {
	/**
	 * 获取患者挂号信息
	 * @param patId 患者id 
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO[] exec(String patId) throws BizException{
		//挂号、就诊、续诊、诊毕
		String[] status = new String[]{ IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER,
										IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER,
										IEnDictCodeConst.SD_ENSTATUS_OP_CONTINUE,
										IEnDictCodeConst.SD_ENSTATUS_OP_FINISH
									};
		GetRegInfoListBP qryBP = new GetRegInfoListBP();
		return qryBP.exec(null,patId,status,FBoolean.TRUE);
	}
	/**
	 * 获取患者挂号信息
	 * 
	 * @param patId 患者ID
	 * @param bDate 挂号日期_开始时间
	 * @param eDate 挂号日期_结束时间
	 * @return
	 * @throws BizException 
	 */
	public RegInfoDTO[] exec(String patId, FDate bDate, FDate eDate) throws BizException{
		GetRegInfoListBP qryBP = new GetRegInfoListBP();
		return qryBP.exec(patId, bDate, eDate);
	}
}
