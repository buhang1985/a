package iih.ci.ord.s.ems.ip.order.copy;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.s.ems.op.order.copy.OrderTreatNutCopyBP;

/**
 * 复制操作工厂类
 * 
 * @author Young
 *
 */
public class OrderCopyFactory extends iih.ci.ord.s.ems.op.order.copy.OrderCopyFactory {

	/**
	 * 获取个服务类型医嘱的复制操作类
	 * 
	 * @param sdtp
	 * @return
	 */
	public iih.ci.ord.s.ems.op.order.copy.OrderBaseCopyBP getOrderCopyBP(String sdtp) {
		iih.ci.ord.s.ems.op.order.copy.OrderBaseCopyBP bp = null;
		switch (sdtp) {
		case IBdSrvDictCodeConst.SD_SRVTP_DRUG:
			bp = new OrderDrugsCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG:
			bp = new OrderHerbsCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_RIS:
			bp = new OrderRisCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI:
			bp = new OrderPathgyCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_LIS:
			bp = new OrderLisCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_OP:
			bp = new OrderOpCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_TREAT:
			bp = new OrderTreatCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_TREAT_NUT: // 膳食
			bp = new OrderTreatNutCopyBP();
			break;	
		case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS:
			bp = new OrderConsCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD:
			bp = new OrderApbuCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE:
			bp = new OrderApbtCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_NURSE:
		    bp = new OrderNurseCopyBP();
		   break;
		default:
			bp = new OrderTreatCopyBP();
				break;
		}

		return bp;
	}
}
