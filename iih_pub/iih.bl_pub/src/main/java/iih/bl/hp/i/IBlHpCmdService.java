package iih.bl.hp.i;

import iih.bl.hp.hpzeroreg.d.HpZeroRegDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 费用医保命令服务
 * @author yankan
 * @since 2017-06-15
 *
 */
public interface IBlHpCmdService {
	/**
	 * 签到
	 * @param empId 操作员ID
	 * @param businessCode 业务周期号
	 * @param mac mac地址
	 * @throws BizException
	 * @author 
	 */
	public abstract void signIn(String empId,String businessCode, String mac) throws BizException;
	/**
	 * 签退
	 * @param empId 操作员ID
	 * @throws BizException
	 * @author 
	 */
	public abstract void signOut(String empId) throws BizException;
	
	/**
	 * 医保登记撤销后，删除医保计划
	 * @author liwq
	 */
	public FBoolean deleteEntHpInfo(String idEnt) throws BizException;
	/**
	 * 保存零挂业务需要更新对应结算中的符合零挂记账标志FG_ZEROREG 为Y
	 * @param hzRegDos 零挂集合
	 * @return
	 * @throws BizException
	 * @author yang.lu
	 */
	public abstract HpZeroRegDO[] saveHpZeroDos(HpZeroRegDO[] hzRegDos) throws BizException;

	/**
	 * 保存默认医保上传明细数据
	 * @param stId 结算id
	 * @throws BizException
	 * @author ly 2018/11/24
	 */
	public abstract void saveDefaultHpIpCgItem(String stId) throws BizException;
	/**
	 * 删除所有贫困患者
	 * @throws BizException
	 */
	public abstract void  deleteHpPoor() throws BizException;
	
	/**
	 * 同步贫困患者标签
	 * @description:
	 * @author:hanjq  2020年7月16日
	 * @throws BizException
	 */
	public abstract void  synchroHpPoorTag(FBoolean delNotExist,FBoolean saveNewImport) throws BizException;
}
