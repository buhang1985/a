package iih.bd.srv.i;

import iih.bd.srv.dto.d.MedSrvPriDTO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.oth.d.BizCntDTO;
import iih.bd.srv.oth.d.MedSrvWordFreqDO;
import iih.bd.srv.srvreact.d.SrvreactAggDO;
import iih.bd.srv.srvrtctl.d.SrvrtctlAggDO;
import xap.mw.core.data.BizException;

public interface IBdSrvMaintainService {

	/**
	 * 更新模板状态
	 * @param fg_active
	 * @param Id
	 * @return
	 * @throws BizException
	 */
	 public abstract int updateFgActive(String fg_active,String Id)throws BizException;
	 
		/**
		 * 更新频次状态
		 * @param fg_active
		 * @param Id
		 * @return
		 * @throws BizException
		 */
		 public abstract int updateFreqFgActive(String fg_active,String Id)throws BizException;
	 
	 /**
	  * 更新医疗服务定价模式信息
	  * @param srvprimddto
	  * @return
	  * @throws BizException
	  */
	 public abstract boolean updateSrvPriMdInfo(MedSrvPriDTO[] srvprimddto) throws BizException;
	 

	 /**
		  * 更新了服务开立权限后，需要更新服务主表的fg_rt字段
		  * @param srvrtctlAggDO
		  * @throws BizException
		  */
	public abstract SrvrtctlAggDO[] UpdateSrvFgrt(SrvrtctlAggDO srvrtctlAggDO) throws BizException;
		
	 
	 /**
	  * 保存组排斥
	  */
	 public abstract void saveGroupReact(SrvreactAggDO aggDo) throws BizException;
	 /**
	  * 删除组排斥
	  */
	 public abstract void delGroupReact(SrvreactAggDO aggDo) throws BizException;
	 /**
	  * 医疗服务保存
	  * @param srvAggDO
	  * @return
	  * @throws BizException
	  */
	 public boolean SaveMedSrv(MedsrvAggDO srvAggDO) throws BizException;
	 /**
	  * 词频使用统计信息数据保存更新
	  * @param wfpkdata
	  * @param bizcnts
	  * @throws BizException
	  */
	 public void wordFreqStatisticInfoUpdate(MedSrvWordFreqDO wfpkdata,BizCntDTO[] bizcnts) throws BizException;
}
