package iih.ci.mr.i;

import java.io.IOException;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;

/**
 * 病历事务性操作服务
 * @author F
 *
 */
public interface IMrTransactionService {
	/**
	 * 保存病历记录和文件
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @return
	 */
	public abstract FArrayList2 saveMr(CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException, IOException; 
	
	/**
	 * 保存病历记录和文件
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @return
	 */
	public abstract FArrayList2 saveMrAndRef(MrDocRefValueDO[] mrDocRefValueDOs,CiMrDO ciMrDO, CiMrFsDO ciMrFsDO)throws BizException, IOException; 
	
	/**
	 * 门诊病历保存；
	 * 如果门诊病历提交，需要将其他相关病历一起提交
	 * @param mrDocRefValueDOs
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @return
	 * @throws BizException
	 * @throws IOException
	 */
	public FArrayList2 saveOPMrAndRef(MrDocRefValueDO[] mrDocRefValueDOs,
			CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException, IOException;
}
