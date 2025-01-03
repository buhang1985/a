package iih.bl.cg.s.bp.op;

import java.util.ArrayList;

import iih.bd.base.utils.StringUtils;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfCudService;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfRService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.s.bp.op.sql.AssembleCgIpSql;
import iih.bl.comm.log.BLBizLogger;
import iih.bl.params.BlParams;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.i.IEnaccountMDOCudService;
import iih.en.pv.enfee.i.IEnaccountMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 门诊费用转住院费用(真实转入) Title: oepCgTransferToIpCgRealBP.java
 * 
 * @author zhang.hw
 * @date 2020年3月11日
 * @version 1.0
 */
public class OepCgTransferToIpCgRealBP {

	public BlCgIpDO[] exec(String id_ent) throws BizException {
		// 1、检查入参
		if (!StringUtils.isNotEmpty(id_ent)) {
			throw new BizException("入参为空，请检查参数！");
		}
		//1.1、查询转移的数据
		IBlcgoeptfRService tfrService = ServiceFinder.find(IBlcgoeptfRService.class);
		BlCgItmOepTfRcdDO[] oepTfRcdDOs = tfrService.findByAttrValString("Id_ent_tf", id_ent);
		if (oepTfRcdDOs.length==0) {
			return null;
		}
		for(int i=0;i<oepTfRcdDOs.length;i++){
			if (FBoolean.FALSE.equals(oepTfRcdDOs[i].getFg_active()) 
					&& FBoolean.FALSE.equals(oepTfRcdDOs[i].getFg_realtf()) 
					&& FBoolean.TRUE.equals(oepTfRcdDOs[i].getFg_tl())) {
				return null;
			}
		}
		// 2、组装门诊中的数据到住院中,并保存
		Integer hour = BlParams.BLSTOEP0041();
		AssembleCgIpSql assembleSql = new AssembleCgIpSql(id_ent, hour);
		DAFacade daFacade = new DAFacade();
		ArrayList<BlCgIpDO> list = (ArrayList<BlCgIpDO>) daFacade.execQuery(assembleSql.getQrySQLStr(),
				assembleSql.getQryParameter(null), new BeanListHandler(BlCgIpDO.class));
		if (list.size()<=0) {
			//throw new BizException("未查询到该患者对应的门诊转住院费用，请检查后操作！");
			return null;
		}
		
		IBlcgqueryCudService cudService = ServiceFinder.find(IBlcgqueryCudService.class);
		BlCgIpDO[] relblCgIpDOs = cudService.insert(list.toArray(new BlCgIpDO[list.size()]));
		
		//3、修改门诊转入记录表中的状态
		//3.1、修改fg_tl值为Y
		for (int i = 0; i < oepTfRcdDOs.length; i++) {
			oepTfRcdDOs[i].setFg_tl(FBoolean.TRUE);
			oepTfRcdDOs[i].setStatus(DOStatus.UPDATED);
		}
		IBlcgoeptfCudService tfcudService = ServiceFinder.find(IBlcgoeptfCudService.class);
		tfcudService.save(oepTfRcdDOs);
		
		//4、修改就诊账户消费金额
		//4.1、查询患者对应的账户信息
		IEnaccountMDORService enaccountMDORService = ServiceFinder.find(IEnaccountMDORService.class);
		EnAccountDO[] enAccountDOs = enaccountMDORService.findByAttrValString(EnAccountDO.ID_ENT, id_ent);
		if (enAccountDOs==null || enAccountDOs.length<=0) {
			BLBizLogger.error("未查询到患者住院对应的账户信息！");
			return null;
		}
		double num = 0;
		for(BlCgIpDO blCgIpDO:list){
			num += blCgIpDO.getEu_direct()*blCgIpDO.getAmt_ratio().getDouble();
		}
		num += enAccountDOs[0].getAmt_uncg().getDouble();
		enAccountDOs[0].setAmt_uncg(new FDouble(num));
		enAccountDOs[0].setStatus(DOStatus.UPDATED);
		IEnaccountMDOCudService enaccountMDOCudService = ServiceFinder.find(IEnaccountMDOCudService.class);
		enaccountMDOCudService.update(new EnAccountDO[]{enAccountDOs[0]});
		return relblCgIpDOs;
	}

}
