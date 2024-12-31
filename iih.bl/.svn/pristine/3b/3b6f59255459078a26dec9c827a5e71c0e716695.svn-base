package iih.bl.cc.ebs.params;

import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bl.cc.ebs.help.util.QueSiteAndStationUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.orgfw.org.i.IOrgConst;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 执行域中的参数
 * @author ChaoXiaoGang
 *
 */
public class Params {

	private Context ctx=Context.get();
	
	public String midTableParam_J ="CUX_GL_HIS_IIH_BATCH_IFACE,CUX_GL_HIS_IIH_CHARGE_IFACE";
	/**
	 * 执行药品ERP对接中间表
	 * @return
	 */
	public String MPDGIPOP0014(){
		try {
			WorkStationPcDO pc=QueSiteAndStationUtil.getStationPc(ctx.getClientHost());
			String idpc=pc.getId_pc();
			return ParamsetQryUtil.getParaStringByInstance(idpc, "MPDGIPOP0014");
		} catch (BizException e) {
			//BlCcLogUtil.getInstance().logError(e.getMessage());
		}
		return null;
	}
		
	/**
	 * ebs数据源
	 * @return
	 */
	public String EBSDATASOURCE(){
		try {
			return ParamsetQryUtil.getParaString(IOrgConst.GLOBEORG, "ebsdatasource");
		} catch (BizException e) {
			//BlCcLogUtil.getInstance().logError(e.getMessage());
		}
		return null;
	}
}
