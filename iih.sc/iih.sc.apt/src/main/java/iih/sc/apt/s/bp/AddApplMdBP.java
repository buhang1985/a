package iih.sc.apt.s.bp;

import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.desc.ScAptApplDODesc;
import iih.sc.apt.scaptappl.i.IScaptapplMDOCudService;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

public class AddApplMdBP {
	/**
	 * @param applDO
	 * @return 申请单对象
	 * @throws BizException
	 */
	public ScAptApplDO exec(ScAptApplDO applDO)throws BizException {
		if(applDO == null){
			return null;
		}else{
			//生成申请单编码
			applDO.setCode(this.createScAptApplCode(applDO.getSd_sctp()));
			//查找排班分类 id_scca 
			String id_srv = applDO.getId_srv();
			String idSrv = String.format(" id_srv = '%s'", id_srv);
			IScbdsrvMDORService scBdSrvService  = ServiceFinder.find(IScbdsrvMDORService.class);
			ScBdsrvDO[] ScBdsrvDOs = scBdSrvService.find(idSrv, null, FBoolean.FALSE);
			if(ScBdsrvDOs.length < 1){
				throw new BizException("没有找到该诊疗项目的排班！");
			}else{
				String id_scca = ScBdsrvDOs[0].getId_scca();
				applDO.setId_scca(id_scca);
			}
			ScAptApplDO[]  array = {applDO};
			//添加
			IScaptapplMDOCudService insertApplService = ServiceFinder.find(IScaptapplMDOCudService.class);
			ScAptApplDO[] applDos = insertApplService.insert(array);
			return applDos[0];
		}
	}
	/**
	 * 创建预约申请编码
	 *
	 * @author zhengcm
	 * 
	 * @param sd_entp 就诊类型编码
	 * @return 编码
	 * @throws BizException
	 */
	private String createScAptApplCode(String sd_entp) throws BizException {
		String code = this.createCode(ScAptApplDODesc.CLASS_FULLNAME);
		if (!StringUtil.isEmptyWithTrim(sd_entp)) {
			code = code.substring(0, 3) + sd_entp + code.substring(3);
		}
		return code;
	}
	/**
	 * 生成编码
	 * 
	 * @param doDescFullName 实体元数据类全名
	 * @return 根据编码规则生成编码
	 * @throws BizException
	 */
	private String createCode(String doDescFullName) throws BizException {
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = codeManage.getPreBillCode_RequiresNew(doDescFullName);
		return code;
	}
}
