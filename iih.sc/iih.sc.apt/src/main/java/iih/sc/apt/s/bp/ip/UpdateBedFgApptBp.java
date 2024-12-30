package iih.sc.apt.s.bp.ip;

import org.apache.commons.lang.StringUtils;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.desc.BdbedDesc;
import iih.bd.res.bed.i.IBedMDOCudService;
import iih.bd.res.bed.i.IBedMDORService;
import iih.sc.comm.IScMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 床位预约标识修改
 * @author ccj
 *
 */
public class UpdateBedFgApptBp {
	
	/**
	 * 床位预约标识修改
	 * @param id_bed  床位id
	 * @param fg_refuse 操作是否为拒绝
	 * @throws BizException
	 */
	public void exec(String id_bed,FBoolean fg_refuse)throws BizException{
		if(StringUtils.isBlank(id_bed) || fg_refuse == null ) return;
		IBedMDORService mdorService = ServiceFinder.find(IBedMDORService.class);
		IBedMDOCudService bedMDOCudService = ServiceFinder.find(IBedMDOCudService.class);
		Bdbed[] bdbeds = mdorService.find(BdbedDesc.TABLE_ALIAS_NAME+".id_bed = '"+id_bed+"' and  "+BdbedDesc.TABLE_ALIAS_NAME+".fg_appt = '"+fg_refuse+"' ", "", FBoolean.TRUE);
		if(bdbeds == null || bdbeds.length == 0) throw new BizException(IScMsgConst.SC_APT_IP_BDBED_IS_MODIFIED);
		if(fg_refuse.booleanValue()){
			// 拒绝操作释放床位预约标识
			bdbeds[0].setFg_appt(FBoolean.FALSE);
		}else{
			// 取消拒绝
			bdbeds[0].setFg_appt(FBoolean.TRUE);
		}
		bdbeds[0].setStatus(DOStatus.UPDATED);
		bedMDOCudService.save(bdbeds);
	}
}
