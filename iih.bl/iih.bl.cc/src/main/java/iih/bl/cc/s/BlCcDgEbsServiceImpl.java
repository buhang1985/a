package iih.bl.cc.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import iih.bl.cc.ebs.erp.bp.MpCombinOldHisDataToErpBP;
import iih.bl.cc.ebs.erp.bp.MpCreateMedAppliDataBP;
import iih.bl.cc.i.IBlCcDgEbsService;
import iih.bl.cc.ebs.st.bp.*;

/**
 * ebs药品测试服务
 * @author Administrator
 *
 */
@Service(serviceInterfaces={IBlCcDgEbsService.class}, binding=Binding.JSONRPC)
public class BlCcDgEbsServiceImpl implements IBlCcDgEbsService {

	@Override
	public void combinOldHisDataToErp(String selectDate) {
		MpCombinOldHisDataToErpBP bp = new MpCombinOldHisDataToErpBP();
		bp.exec(selectDate);
	}

	@Override
	public void createMedAppliData(String selectDate) {
		MpCreateMedAppliDataBP bp = new MpCreateMedAppliDataBP();
		bp.exec(selectDate);
	}

	/**
	 * EBS接口数据导入
	 */
	@Override
	public void stOutPatientAppDataBP(String bath_type, String selectDate) {
		STOutPatientAppDataBP bp = new STOutPatientAppDataBP();
		bp.exec(bath_type, selectDate);
	}

	/**
	 * 将J3、J4、JY、JO、JN导入到最终的中间库
	 */
	@Override
	public void stCombinHisIncomeToErpBP(String selectDate){
		
		STCombinHisToErpBP bp =new STCombinHisToErpBP();
		bp.exec(selectDate);
	}
}
