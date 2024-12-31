package iih.bd.srv.upgrade;

import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.listener.IUpdate;

/**
 * BDSRV升级监听器
 * 
 * @author hao_wu
 *
 */
public class bdsrvUpgradeListener implements IUpdate {

	@Override
	public void doAfterUpdateData() throws Exception {

		// 2017.7.24 医疗服务类型增加字段，设置默认值
//		DAFacade daFacade = new DAFacade();
//		String sql = "update bd_mrtp set id_mr_entp = ?, sd_mr_entp = ?";
//		SqlParam param = new SqlParam();
//		param.addParam("@@@@Z8100000000PTTSX");
//		param.addParam("01");
//		daFacade.execUpdate(sql, param);
		
		// 2017.8.22  更新医疗计划_医疗机构集团和机构id  原因为原来是反的
		DAFacade daFacade = new DAFacade();
		String sql = "update bd_hp_org set id_grp = ?, id_org = ?";
		SqlParam param = new SqlParam();
		param.addParam("0001HH100000000001OE");
		param.addParam("0001HY1000000000OH85");
		daFacade.execUpdate(sql, param);
	}
}
