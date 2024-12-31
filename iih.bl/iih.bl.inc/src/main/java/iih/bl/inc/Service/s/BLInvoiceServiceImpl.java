package iih.bl.inc.Service.s;


import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.bp.BLInvoiceServiceBp;
import iih.bl.inc.dto.d.BlIncissOepDTO;
import iih.bl.inc.service.i.IBLInvoiceService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/** 文件头注释
* ==============================================================================
* @Filename: IBlincQryServiceImpl   
* @Date: 2016/06/30 10:37:15
* @Compiler: Eclipse luna 4.4.1 
* @author tcy
* @reviewer yangyang 做调整，明确接口函数定义以及使用范围，对于不再使用的接口，做废弃标注
* @Company: Copyright 2016 by PKU healthcare IT Co.,Ltd.
* @Description: 票据领用相关服务
* ==============================================================================
*/
@Service(serviceInterfaces={IBLInvoiceService.class}, binding=Binding.JSONRPC)
public class BLInvoiceServiceImpl  implements IBLInvoiceService {
	
	
	/**
	 * 新增空白作废票
	 * @param Id_emp_inc 用户ID
	 * @param code_incca 票据分类编码
	 * @param blIncCancDO
	 * @return
	 * @throws BizException
	 */
	public FBoolean AddBlIncCanc(String  Id_emp_inc,String code_incca,BlIncCancDO blIncCancDO)  throws BizException
	{
		BLInvoiceServiceBp bp = new BLInvoiceServiceBp();
		FBoolean bl=bp.AddBlIncCanc(Id_emp_inc, code_incca, blIncCancDO);
		return bl;
	}
	/**
	 * 删除空白作废票
	 * @param Id_emp_inc 用户ID
	 * @param code_incca 票据分类编码
	 * @param blIncCancDO
	 * @return
	 * @throws BizException
	 */
	public FBoolean DeleteBlIncCanc(String  Id_emp_inc,String code_incca,BlIncCancDO blIncCancDO)  throws BizException
	{
		BLInvoiceServiceBp bp = new BLInvoiceServiceBp();
		return bp.DeleteBlIncCanc(Id_emp_inc, code_incca, blIncCancDO);
	}
	
	/**
	 * 获得当前可以票据号
	 */
	@Override
	public String GetInvoiceNo(String Id_emp_inc, String code_incca) throws BizException {
		BLInvoiceServiceBp bp = new BLInvoiceServiceBp();
		return bp.GetInvoiceNo(Id_emp_inc, code_incca);
		
	}
	

	@Override
    public BlIncissOepDTO useReceipt(String strIdEmp, String strCodeIncca)
            throws BizException {
	    BLInvoiceServiceBp handlerBp=new BLInvoiceServiceBp();    
        return handlerBp.useReceipt(strIdEmp, strCodeIncca);
    }
	
    @Override
    public BlIncissOepDTO getIncissOepDtoByEmp(String strIdEmpIss,
            String strCodeIncca) throws BizException {
	    BLInvoiceServiceBp handlerBp=new BLInvoiceServiceBp();
	    return handlerBp.getIncissOepDtoByEmp(strIdEmpIss, strCodeIncca);
    }
    /**
	 * 获得当前票据包的结束号
	 * @param Id_emp_inc 用户ID
	 * @param code_incca 票据类型
	 * @return
	 * @throws BizException
	 */
	public String GetMaxInvoiceNo(String Id_emp_inc, String code_incca )  throws BizException {
		BLInvoiceServiceBp bp = new BLInvoiceServiceBp();	
		return bp.GetMaxInvoiceNo(Id_emp_inc, code_incca);
	}
	
	/**
	 * 用下一票号代替当前号
	 * @param Id_emp_inc
	 * @param code_incca
	 * @throws BizException
	 */
	/*@Override
	public void NextInvoiceNoUpdateCurNo(String Id_emp_inc, String code_incca)
			throws BizException {

		BLInvoiceServiceBp bp = new BLInvoiceServiceBp();
		bp.nextInvoiceNoUpdateCurNo(Id_emp_inc, code_incca);
	}*/
	@Override
	public String GetInvoiceNoAndNextInvoiceNoUpdateCurNo(String Id_emp_inc,
			String code_incca) throws BizException {
		BLInvoiceServiceBp bp = new BLInvoiceServiceBp();
		String no= bp.GetInvoiceNo(Id_emp_inc, code_incca);
		bp.nextInvoiceNoUpdateCurNo( Id_emp_inc,  code_incca);
		return no;
	}
	 /**
     * 后移票据号后获得当前可用发票号:先update再select
     * @param Id_emp_inc 操作员ID
     * @param code_incca 票据类型编码
     * @throws BizException
     */
	/*@Override
	public String NextInvoiceNoUpdateCurNoAndGetInvoiceNo(String Id_emp_inc,
			String code_incca) throws BizException {
		BLInvoiceServiceBp bp = new BLInvoiceServiceBp();
		bp.nextInvoiceNoUpdateCurNo( Id_emp_inc,  code_incca);
		return bp.GetInvoiceNo(Id_emp_inc, code_incca);
	}*/
	/**
	 * 用上一票号代替当前号，供删除的【作废票据号】使用
	 * @param Id_emp_inc
	 * @param incno
	 * @throws BizException
	 */
	@Override
	public void NextInvoiceNoUpdateCurNo_minus1( String incno,String code_incca,String code_incpkg)
			throws BizException {
		// TODO Auto-generated method stub
		BLInvoiceServiceBp bp = new BLInvoiceServiceBp();
		bp.nextInvoiceNoUpdateCurNo_minus1(incno,code_incca,code_incpkg);
	}

	/**
	 * 用下一票号代替当前号，供删除的【作废票据号】使用
	 * @param Id_emp_inc
	 * @param incno
	 * @throws BizException
	 */
	@Override
	public void NextInvoiceNoUpdateCurNo_add1( String incno,String code_incca,String code_incpkg)
			throws BizException {
		// TODO Auto-generated method stub
		BLInvoiceServiceBp bp = new BLInvoiceServiceBp();
		bp.nextInvoiceNoUpdateCurNo_add1(incno,code_incca,code_incpkg);
	}

	 /**
     * 将指定票据号设置为当前票据号，仅供门诊结算使用(划价成功——>取消划价使用；划价成功——>结算失败后使用)，其他业务领域慎用
     * @param Id_emp_inc 操作员ID
     * @param id_incca 票据类型
     * @param invoiceNo  指定票据号
     * @throws BizException
     */
	@Override
	public void SetCurNoByParamNo(String Id_emp_inc, String id_incca,
			String invoiceNo) throws BizException {
		// TODO Auto-generated method stub
		BLInvoiceServiceBp bp = new BLInvoiceServiceBp();
		bp.setCurNoByParamNo(Id_emp_inc, id_incca, invoiceNo);
		
	}

	/**
	 * 获得当前可以使用的  若干张票据号,顺序从小到大
	 */
	@Override
	public String[] GetManyInvoiceNo(String Id_emp_inc, String code_incca,int  num,String code_incpkg) throws BizException {
		
		BLInvoiceServiceBp bp = new BLInvoiceServiceBp();
		return bp.getManyInvoiceNo(Id_emp_inc, code_incca, num, code_incpkg);
		
	}
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
	@Override
	public FBoolean checkNoIsThePreviousOfCurno(String id_emp_inc,String curNo,String pre_no,String code_incca,String code_incpkg) throws BizException
	{
		BLInvoiceServiceBp bp = new BLInvoiceServiceBp();
		return bp.checkNoIsThePreviousOfCurno(id_emp_inc,curNo,pre_no,code_incca,code_incpkg);
	}

	
}
