package iih.bl.inc.service.i;

import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.dto.d.BlIncissOepDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 发票接口
 * @author 唐婵懿
 *
 */
public interface IBLInvoiceService {
	/**
	 * 获得当前票据包的结束号
	 * @param Id_emp_inc 用户ID
	 * @param code_incca 票据类型
	 * @return
	 * @throws BizException
	 */
	public abstract String GetMaxInvoiceNo(String Id_emp_inc, String code_incca )  throws BizException ;

	
	/**
	 * 新增空白作废票
	 * @param Id_emp_inc 用户ID
	 * @param code_incca 票据分类编码
	 * @param blIncCancDO
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean AddBlIncCanc(String  Id_emp_inc,String code_incca,BlIncCancDO blIncCancDO)  throws BizException;
	/**
	 * 删除空白作废票
	 * @param Id_emp_inc 用户ID
	 * @param code_incca 票据分类编码
	 * @param blIncCancDO
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean DeleteBlIncCanc(String  Id_emp_inc,String code_incca,BlIncCancDO blIncCancDO)  throws BizException;

	
	/**
	 * 票据使用
	 * @param strIdEmp 票据领用人
	 * @param strCodeIncca 票据类型
	 * @return 所使用的发票号
	 * @throws BizException
	 */
	public abstract BlIncissOepDTO useReceipt(String strIdEmp,String strCodeIncca) throws BizException;
	/**
	 * 直接获取当前票据号（适用门诊收费结算，住院收费结算，门诊挂号结算）：select
	 * @param Id_emp_inc 操作员ID
	 * @param code_incca 票据类型编码
	 * @return 返回票据号
	 * @throws BizException
	 */
	 public abstract String GetInvoiceNo(String Id_emp_inc,String code_incca)throws BizException;
	 
	 /**
	  * 指定票据类型下，获取领取人名下可用的票据信息
	 * @param strIdEmpIss 领取人
	 * @param strCodeIncca 票据类型编码
	 * @return 票据信息
	 * @throws BizException
	 */
	public abstract BlIncissOepDTO getIncissOepDtoByEmp(String strIdEmpIss,String strCodeIncca) throws BizException;
	 /**
		 * 直接获取票据号然后后移票号：先select再update
		 * @param Id_emp_inc 操作员ID
		 * @param code_incca 票据类型编码
		 * @return 返回先select出的票据号
		 * @throws BizException
		 */
	 public abstract String GetInvoiceNoAndNextInvoiceNoUpdateCurNo(String Id_emp_inc,String code_incca)throws BizException;

	 /**
      * 将指定票据号设置为当前票据号，仅供门诊收费、门诊退费使用，其他业务领域慎用
      * @param Id_emp_inc 操作员ID
      * @param id_incca 票据类型
      * @param invoiceNo  指定票据号
      * @throws BizException
      */
	 public abstract void SetCurNoByParamNo(String Id_emp_inc,String id_incca,String invoiceNo)throws BizException;

	 /**
      * 后移一张票据号（适用挂号结算）:update
      * @param Id_emp_inc 操作员ID
      * @param code_incca 票据类型编码
      * @throws BizException
      */
	 //public abstract void NextInvoiceNoUpdateCurNo(String Id_emp_inc,String code_incca)throws BizException;

	 /**
      * 后移一张票据号后获得当前可用发票号（适用挂号结算）:先update再select
      * @param Id_emp_inc 操作员ID
      * @param code_incca 票据类型编码
      * @throws BizException
      */
	 //public abstract String NextInvoiceNoUpdateCurNoAndGetInvoiceNo(String Id_emp_inc,String code_incca)throws BizException;

	 
	 /**
      * 前移票据号：用上一票号代替当前号，供【作废票据号】使用
      * @param incno 当前作废票号
      * @param code_incca 票据类型编码
      * @param code_incpkg 票据包编码
      * @throws BizException
      */
	 public abstract void NextInvoiceNoUpdateCurNo_minus1(String incno,String code_incca,String code_incpkg)throws BizException;

	 /**
      * 后移票据号：用下一票号代替当前号，供【作废票据号】使用
      * @param incno 当前作废票号
      * @param code_incca 票据类型编码
      * @param code_incpkg 票据包编码
      * @throws BizException
      */
	 public abstract void NextInvoiceNoUpdateCurNo_add1(String incno,String code_incca,String code_incpkg)throws BizException;
	/**
	 * 获得指定数量可以使用的含当前票据号码及其以后的号码,但没有修改数据表中的当前号码，发票顺序从下到大（适用门诊结算，一次结算连续打印多张发票）
	 * @param Id_emp_inc  收款员ID
	 * @param code_incca  票据类型编码
	 * @param num 票据数量
	 * @param code_incpkg :票据包
	 * @return
	 * @throws BizException
	 */
	 public abstract String[] GetManyInvoiceNo(String Id_emp_inc, String code_incca,int  num,String code_incpkg) throws BizException ;
			
	 /**
	 * 判断是否是当前票号上一张票号
	 * @param id_emp_inc 票据开立人
	 * @param curNo 当前票号
	 * @param pre_no 待验证的上一票号
	 * @param code_incca 发票类型代码
	 * @param code_incpkg 票据包
	 * @return
	 * @throws BizException
	 */		
	public abstract FBoolean checkNoIsThePreviousOfCurno(String id_emp_inc,String curNo,String pre_no,String code_incca,String code_incpkg) throws BizException;

}

