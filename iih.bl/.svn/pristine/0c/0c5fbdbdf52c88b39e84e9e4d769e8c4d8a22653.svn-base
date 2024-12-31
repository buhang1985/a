package iih.bl.cg.ip.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.params.BlParams;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 护士冲账
 * @author yangyang
 * @Date 2017-10-20
 */
public class NurseRedBackFeeBp {
	public BlCgIpDO[] exec(BlCgIpDO[] mendIpDos, String id_ent) throws BizException
	{
		//护士冲账采用全额冲账
		//1、组装红冲数据
		if(ArrayUtil.isEmpty(mendIpDos))
			throw new BizException("请传入待退费数据！");
		IBlcgqueryRService cgIpRservice=ServiceFinder.find(IBlcgqueryRService.class);
		//原记账记录
		List<BlCgIpDO> cgIpDoOldLst=new ArrayList<BlCgIpDO>();
		//红冲记账记录
		List<BlCgIpDO> cgIpDoRedBackLst=new ArrayList<BlCgIpDO>();
		//新收记录
		List<BlCgIpDO> cgIpDoReChargeLst=new ArrayList<BlCgIpDO>();
		GetCodeByCustomization customBill=new GetCodeByCustomization();
		FDouble fdAmtRefund=new FDouble(0.00);
		for(BlCgIpDO cgIpDo:mendIpDos)
		{
			//判断是否退费数量大于原服务数量
			if(cgIpDo.getQuan_mend().compareTo(cgIpDo.getQuan())>0)
			{
				String strMsg=String.format("服务%s退费数量为%s大于开具数量%s",cgIpDo.getId_srv(),cgIpDo.getQuan_mend(),cgIpDo.getQuan());
				throw new BizException(strMsg);
			}
			//生成红冲数据
			BlCgIpDO cgIpDoRefund=(BlCgIpDO)cgIpDo.clone();
			//红冲金额
			cgIpDoRefund.setAmt(cgIpDoRefund.getQuan_mend().multiply(cgIpDoRefund.getPrice_ratio()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			cgIpDoRefund.setAmt_hp(new FDouble(0.00));
			cgIpDoRefund.setAmt_pat(cgIpDoRefund.getQuan_mend().multiply(cgIpDoRefund.getPrice_ratio()).setScale(-2,  BigDecimal.ROUND_HALF_UP));
			cgIpDoRefund.setAmt_ratio(cgIpDoRefund.getQuan_mend().multiply(cgIpDoRefund.getPrice_ratio()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			cgIpDoRefund.setAmt_std(cgIpDoRefund.getQuan_mend().multiply(cgIpDoRefund.getPrice_ratio()).setScale(-2, BigDecimal.ROUND_HALF_UP));			
			cgIpDoRefund.setId_par(cgIpDo.getId_cgip());
			cgIpDoRefund.setId_emp_cg(Context.get().getStuffId());
			cgIpDoRefund.setId_dep_cg(Context.get().getDeptId());
			cgIpDoRefund.setDt_cg(AppUtils.getServerDateTime());
			//获取记账编码
//			cgIpDoRefund.setCode_cg(customBill.getIpCgCode());
			cgIpDoRefund.setEu_direct(-1);
			cgIpDoRefund.setNote("冲账数据");
			cgIpDoRefund.setQuan(cgIpDoRefund.getQuan_mend());
			//重置记账主键
			cgIpDoRefund.setId_cgip(null);
			cgIpDoRefund.setStatus(DOStatus.NEW);
			fdAmtRefund=fdAmtRefund.add(cgIpDoRefund.getAmt_ratio());
			cgIpDoRedBackLst.add(cgIpDoRefund);
			
			//review by yangyang 2017-10-23 本来为了实现全额红冲，在实际的住院业务流程中有问题
			
//			if(cgIpDo.getQuan_mend().compareTo(cgIpDo.getQuan())<0)
//			{
//				// 生成新收记录
//				// 重收的数量
//				FDouble fdChargeQuan = cgIpDo.getQuan().sub(
//						cgIpDo.getQuan_mend());
//				BlCgIpDO cgIpDoNew = (BlCgIpDO) cgIpDo.clone();
//				cgIpDoNew.setAmt(fdChargeQuan.multiply(cgIpDo.getPrice_ratio())
//						.setScale(-2, BigDecimal.ROUND_HALF_UP));
//				cgIpDoNew.setAmt_hp(new FDouble(0.00));
//				cgIpDoNew.setAmt_pat(new FDouble(0.00));
//				cgIpDoNew.setAmt_ratio(fdChargeQuan.multiply(
//						cgIpDo.getPrice_ratio()).setScale(-2,
//						BigDecimal.ROUND_HALF_UP));
//				cgIpDoNew.setAmt_std(fdChargeQuan.multiply(
//						cgIpDo.getPrice_ratio()).setScale(-2,
//						BigDecimal.ROUND_HALF_UP));
//				cgIpDoNew.setCode_cg(customBill.getIpCgCode());
//				cgIpDoNew.setQuan(fdChargeQuan);
//				cgIpDoNew.setEu_direct(1);
//				cgIpDoNew.setNote("重收记录");
//				cgIpDoNew.setId_emp_cg(Context.get().getStuffId());
//				cgIpDoNew.setDt_cg(Tools.getServerTime());
//				cgIpDoNew.setStatus(DOStatus.NEW);
//				cgIpDoNew.setId_cgip(null);
//				cgIpDoReChargeLst.add(cgIpDoNew);
//			}
			BlCgIpDO cgipAggdo=cgIpRservice.findById(cgIpDo.getId_cgip());
			if(cgipAggdo==null)
				throw new BizException("未找到原计费记录！");
			BlCgIpDO cgIpOldDo=cgipAggdo;
			//原记录修改
			cgIpOldDo.setFg_refund(FBoolean.TRUE);
			cgIpOldDo.setId_dep_cg(Context.get().getDeptId());
//			cgIpDo.setCode_cg(customBill.getIpCgCode());
			cgIpOldDo.setStatus(DOStatus.UPDATED);
			cgIpDoOldLst.add(cgIpOldDo);
		}
		BlCgIpDO[] cgIpDoRefundArr=null;
		BlCgIpDO[] cgIpDoReChargeArr=null;
		BlCgIpDO[] cgIpDoOldArr=null;
		IBlcgqueryCudService cgCudService=ServiceFinder.find(IBlcgqueryCudService.class);
		if(!ListUtil.isEmpty(cgIpDoRedBackLst))
			cgIpDoRefundArr=cgCudService.save(cgIpDoRedBackLst.toArray(new BlCgIpDO[cgIpDoRedBackLst.size()]));
		if(!ListUtil.isEmpty(cgIpDoReChargeLst))
			cgIpDoReChargeArr=cgCudService.save(cgIpDoReChargeLst.toArray(new BlCgIpDO[cgIpDoReChargeLst.size()]));
		if(!ListUtil.isEmpty(cgIpDoOldLst))
			cgIpDoOldArr=cgCudService.save(cgIpDoOldLst.toArray(new BlCgIpDO[cgIpDoOldLst.size()]));
		
		//回写预交金记录
		IEnOutQryService inpPatAccImpls = ServiceFinder.find(IEnOutQryService.class);
		IEnOutCmdService enAccService = ServiceFinder.find(IEnOutCmdService.class);
		//母婴是否合并
		FBoolean isMerge =BlParams.BLSTIP0005();
		NewbornDO entNewBorn = inpPatAccImpls.getNewbornDO(mendIpDos[0].getId_ent());
		//2、母婴关系判断
		//预交金持有人，如果是新生儿，则用母亲账户
		String strIdEntAcc=null;
		if(entNewBorn!=null && FBoolean.TRUE.equals(isMerge))
		{
			strIdEntAcc = entNewBorn.getId_ent_mom();
		}
		else
		{
			strIdEntAcc=mendIpDos[0].getId_ent();
		}
		//6、预交金账户处理,这里是退费
		enAccService.consume(strIdEntAcc,fdAmtRefund.multiply(-1));
		return cgIpDoReChargeArr;
	}
}
