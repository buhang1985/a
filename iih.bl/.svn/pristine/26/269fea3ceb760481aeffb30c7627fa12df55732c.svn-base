package iih.bl.hp.s;

import iih.bl.hp.hpzeroreg.d.HpZeroRegDO;
import iih.bl.hp.i.IBlHpCmdService;
import iih.bl.hp.s.bp.BlHpDeletePoorBP;
import iih.bl.hp.s.bp.BlHpSaveDefaultHpIpCgItemBP;
import iih.bl.hp.s.bp.DeleteEntHpInfoBp;
import iih.bl.hp.s.bp.SaveHpZeroDosBP;
import iih.bl.hp.s.bp.SignInBP;
import iih.bl.hp.s.bp.SignOutBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;

/**
 * 医保命令服务
 * 
 * @author yankan
 * @since 2017-06-15
 *
 */
@Service(serviceInterfaces = { IBlHpCmdService.class }, binding = Binding.JSONRPC)
public class BlHpCmdServiceImpl implements IBlHpCmdService {
	/**
	 * 签到
	 * 
	 * @param empId
	 *            操作员ID
	 * @param businessCode
	 *            业务周期号
	 * @param mac
	 *            mac地址
	 * @throws BizException
	 * @author yang.lu
	 */
	@Override
	public void signIn(String empId, String businessCode, String mac) throws BizException {
		SignInBP signInBP = new SignInBP();
		signInBP.exec(empId, businessCode, mac);
	}

	/**
	 * 签退
	 * 
	 * @param empId
	 *            操作员ID
	 * @throws BizException
	 * @author yang.lu
	 */
	@Override
	public void signOut(String empId) throws BizException {
		SignOutBP signOutBP = new SignOutBP();
		signOutBP.exec(empId);
	}
	
	/**
	 * 医保登记撤销后，删除医保计划 且修改登记流水表有效标志
	 * @author liwq
	 */
	public FBoolean deleteEntHpInfo(String idEnt) throws BizException {
		DeleteEntHpInfoBp bp = new DeleteEntHpInfoBp();
		return bp.exec(idEnt);
	}
	/**
	 * 保存零挂业务需要更新对应结算中的符合零挂记账标志FG_ZEROREG 为Y
	 * @param hzRegDos 零挂集合
	 * @return
	 * @throws BizException
	 * @author yang.lu
	 */
	@Override
	public HpZeroRegDO[] saveHpZeroDos(HpZeroRegDO[] hzRegDos) throws BizException {
		SaveHpZeroDosBP bp = new SaveHpZeroDosBP();
		return bp.exec(hzRegDos);
	}
	
	/**
	 * 保存默认医保上传明细数据
	 * @param stId 结算id
	 * @throws BizException
	 * @author ly 2018/11/24
	 */
	@Override
	public void saveDefaultHpIpCgItem(String stId) throws BizException{
		BlHpSaveDefaultHpIpCgItemBP bp = new BlHpSaveDefaultHpIpCgItemBP();
		bp.exec(stId);
	}
	/**
	 * 删除所有的贫困患者
	 * @throws BizException
	 */
	public void deleteHpPoor() throws BizException{
		BlHpDeletePoorBP bp = new BlHpDeletePoorBP();
		bp.exec();
	}
	
	/**
	 * 处理贫困患者标签
	 */
	@Override
	public void synchroHpPoorTag(FBoolean delNotExist, FBoolean saveNewImport) throws BizException {
		BlHpDeletePoorBP bp = new BlHpDeletePoorBP();
		bp.exec(delNotExist,saveNewImport);		
	}
	
}
