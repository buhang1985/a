package iih.bl.cc.ebs.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDate;
import iih.bl.cc.ebs.bp.ExecEBSDBBP;
import iih.bl.cc.ebs.i.IBLCcEBSCmdService;
import iih.bl.cc.ebs.i.IBLCcEBSQryService;

/**
 * EBS数据导入执行类
 * 
 * @author lu.yang
 * 
 */
@Service(serviceInterfaces = { IBLCcEBSCmdService.class }, binding = Binding.JSONRPC)
public class BLCcEBSCmdServiceImpl implements IBLCcEBSCmdService {

	/**
	 * 执行导入默认为当前日期的前一天
	 */
	@Override
	public void execEBSDB() throws BizException {
		ExecEBSDBBP bp = new ExecEBSDBBP();
		bp.exec();

	}

	/**
	 * 根据日期执行导入
	 */
	@Override
	public void execEBSDBByDate(FDate fDate) throws BizException {
		ExecEBSDBBP bp = new ExecEBSDBBP();
		bp.exec(fDate);
	}

}
