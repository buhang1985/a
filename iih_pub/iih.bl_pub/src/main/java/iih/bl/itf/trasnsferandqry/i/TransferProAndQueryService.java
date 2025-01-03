package iih.bl.itf.trasnsferandqry.i;

import iih.bl.itf.accountinformation.d.AccountInfomationDTO;
import iih.bl.itf.tasktransfered.d.TaskTransferedDTO;
import iih.bl.itf.transferdetails.d.TransferDetailsDTO;
import iih.bl.itf.transferqry.d.TransferInfoDTO;
import iih.bl.itf.trdtrans.d.BlThirdTransRcdDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface TransferProAndQueryService {

	/**
	 * 转账处理转账详细信息查询
	 * @param qryNode
	 * @return
	 * @throws BizException
	 */
	public abstract TransferInfoDTO[]  transferInfoQry(QryRootNodeDTO qryNode) throws BizException;
		
	/**
	 * 获取转账详细信息
	 * @param id_pat
	 * @return
	 * @throws BizException
	 * @author dongjiye
	 */
	public abstract TransferDetailsDTO[] transferDetailsQry(String code) throws BizException;
	
	/**
	 * 获取选中待转账任务数据时候该患者本次就诊下的账户信息 
	 * 数据来源 en_ent_bankAcc
	 * @param id_pat
	 * @return
	 * @throws BizException
	 * @author dongjiye
	 */
	public abstract AccountInfomationDTO[] getAccountInfo(String id_pat) throws BizException;

	
	
	//========================================转账查询节点接口================================================
	
	/**
	 * 获取待转账任务的数据
	 * @return
	 * @throws BizException
	 * @author dongjiye
	 */
	public abstract TaskTransferedDTO[]  taskTransferedQry(QryRootNodeDTO qryNode) throws BizException;

	/**
	 * 获取转账查询节点中的账户信息
	 * @param qryNode
	 * @return
	 * @throws BizException
	 */
	public abstract AccountInfomationDTO[] getAccountInfoqry(QryRootNodeDTO qryNode) throws BizException;

	
	/**
	 * 查询第三方交易记录
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlThirdTransRcdDO> findBlThirdTransByBizGroup(QryRootNodeDTO qryRootNodeDTO,String idEmpCurr,String orderStr,PaginationInfo pg) throws BizException;
}
