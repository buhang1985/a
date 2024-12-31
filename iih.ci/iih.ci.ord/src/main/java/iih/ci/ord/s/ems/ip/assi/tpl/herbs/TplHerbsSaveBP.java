package iih.ci.ord.s.ems.ip.assi.tpl.herbs;

import com.mysql.jdbc.StringUtils;

import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrtmplMDORService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsHerbsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.cache.BDFreqInfoCache;
import iih.ci.ord.s.ems.ip.assi.tpl.commondrugs.TplDrugsSaveBP;
import iih.ci.ord.s.ems.utils.OrderEmsQuanUtil;
import iih.ci.ord.s.ems.utils.ReflClassUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 草药模板保存
 * @author Young
 *
 */
public class TplHerbsSaveBP extends TplDrugsSaveBP {
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) 
			throws BizException {
		EmsSaveDTO tpl = szEms[0];
		FArrayList drugList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(drugList))
			return null;
		OrTplNItmDO ortplnitmdo = (OrTplNItmDO) drugList.get(0);
		OrTmplDO ortmpldo = ServiceFinder.find(IOrtmplMDORService.class).findById(ortplnitmdo.getId_ortmpl());
//		String code_or = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
		String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
		FArrayList docmuent = new FArrayList();
		int index = 1;
		for (Object object : drugList) {
			OrTplNItmDO tpItem = (OrTplNItmDO) object;
			// 获取主服务信息
			MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(tpItem.getId_srv());
			// 拼装医疗单ui
			EmsHerbsViewDTO herb = new EmsHerbsViewDTO();
			this.setEmsViewInfo(ctx, ortmpldo, tpItem, medSrvInfo, tpl.getDriverInfo(), herb, code_or, index);
			// 计算物资流向科室
			this.setOrWfDeptInfo(ctx, medSrvInfo, herb);
			
			herb.setDriverInfo(tpl.getDriverInfo());
			docmuent.append(herb);
			index++;
		}
		EmsSaveDTO save = super.getEmsSaveDTO(docmuent, tpl.getDriverInfo());
		// 反射调用医疗单加载方法
		return ReflClassUtils.ReflCallWith(save.getDriverInfo().getEmsBackendDriver(), "save", ctx, EmsSaveDTO[].class, new EmsSaveDTO[] { save });
	}
	
	@Override
	protected void setEmsViewInfo(CiEnContextDTO ctx, OrTmplDO ortmpldo, OrTplNItmDO ortplnitmdo, MedSrvDO medSrvInfo, 
			EmsDriverInfo driverinfo, OrderListViewDTO orderListViewDTO, String code_or, int index) throws BizException {
		super.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, driverinfo, orderListViewDTO, code_or, index);
		EmsHerbsViewDTO herb = (EmsHerbsViewDTO)orderListViewDTO;
		herb.setId_boil(ortplnitmdo.getId_boil());
		herb.setName_boil(ortplnitmdo.getOrtplnitm_boil_name());
		herb.setId_boildes(ortplnitmdo.getId_boildes());
		herb.setName_boildes(ortplnitmdo.getOrtplnitm_boildes_name());
		herb.setOrders(ortplnitmdo.getOrders() == null ? 7 : ortplnitmdo.getOrders());
		herb.setFg_boil(FBoolean.TRUE);//代煎标识
		herb.setOrders_boil(ortplnitmdo.getOrders());//代煎付数
		herb.setId_routedes(ortmpldo.getId_routedes());
		herb.setName_routedes(ortmpldo.getOrtmpl_routedes_name());
		herb.setQuan_cur(OrderEmsQuanUtil.getMMQuan_cur(herb.getSd_mupkgutp(),herb.getQuan_med(),herb.getFactor_mb(),herb.getFactor_cb(),herb.getOrders()));
		herb.setAmt_total(new FDouble(herb.getPri().getDouble() * herb.getQuan_cur().getDouble()));
		herb.setFg_nothingwithorders(ortplnitmdo.getFg_nothingwithorders());//付数无关标识
		this.setDesOr(herb);
	}
	
	/**
	 * 设置医嘱嘱托信息
	 * @param herb
	 * @throws BizException 
	 */
	private void setDesOr(EmsHerbsViewDTO herb) throws BizException{
//		StringBuffer sb = new StringBuffer();
//        sb.append(String.format("草药%s付", herb.getOrders()));//剂数
//        sb.append(String.format("每日%s付", 1));
//        sb.append(StringUtils.isNullOrEmpty(herb.getName_boil()) ? "" : String.format(",%s至400ml", herb.getName_boil()));
//        if(!StringUtils.isNullOrEmpty(herb.getId_freq())){
//        	FreqDefDO freqDo=BDFreqInfoCache.GetFreqInfo(herb.getId_freq());
//        	if(freqDo!=null)
//        	sb.append(StringUtils.isNullOrEmpty(freqDo.getCode_disp()) ? "" : String.format(",%s", freqDo.getCode_disp()));
//        }
//        sb.append(StringUtils.isNullOrEmpty(herb.getName_routedes()) ? "," : String.format(",%s", herb.getName_routedes()));
//        sb.append(StringUtils.isNullOrEmpty(herb.getName_route()) ? "" : herb.getName_route());
//        herb.setDes_or(sb.toString());
        herb.setDes_or(CiOrdUtils.genOrdDes(herb));

	}
}
