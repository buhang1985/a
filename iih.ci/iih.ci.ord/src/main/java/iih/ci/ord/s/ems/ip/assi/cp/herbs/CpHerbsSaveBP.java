package iih.ci.ord.s.ems.ip.assi.cp.herbs;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.utils.ParamUtils;
import iih.ci.ord.dws.ip.ems.d.EmsHerbsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.define.EmsConstEnum;
import iih.ci.ord.s.ems.ip.assi.cp.drugs.CpDrugsSaveBP;
import iih.ci.ord.s.ems.utils.OrderEmsQuanUtil;
import iih.hp.cp.docinfodto.d.DocSrvinfoDTO;
import iih.hp.cp.docinfodto.d.DocinfoDTO;
import iih.hp.cp.ele.d.HpCpElemOrderDO;
import iih.hp.cp.ele.i.IHpCpElemOrderDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 临床路径 - 草药保存逻辑
 *
 */
public class CpHerbsSaveBP  extends CpDrugsSaveBP {
	
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		EmsSaveDTO tpl = ems[0];
		FArrayList drugList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(drugList))
			return null;
		DocinfoDTO docinfo = (DocinfoDTO) drugList.get(0);
		FArrayList document = new FArrayList();
		String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
		FArrayList srvinfoList = docinfo.getRefeleitems();
			int index = 1;
			for (Object object : srvinfoList) {
				DocSrvinfoDTO srv=(DocSrvinfoDTO) object;
				HpCpElemOrderDO[] ords=ServiceFinder.find(IHpCpElemOrderDORService.class).find(" id_ele='"+srv.getId_ele()+"'","",FBoolean.FALSE);
				if(ords!=null&&ords.length>0) {
					// 获取主服务信息
					MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(srv.getId_srv());
					// 拼装医疗单ui
					EmsHerbsViewDTO herb = new EmsHerbsViewDTO();
					setEmsViewInfo( ctx,  medSrvInfo, tpl.getDriverInfo(),
							herb,  code_or,  index,  ords[0]);
					herb.setFg_skintest(srv.getFg_skin());
					herb.setDes_or(srv.getDes_or());	
					document.add(herb);
//					setEmsViewInfo(docinfo, (DocSrvinfoDTO) object, tpl.getDriverInfo(), ctx, document, code_or, index,ords[0]);
					index++;
				}
				
			}

		if(document.size()>0) {
			EmsSaveDTO save = super.getEmsSaveDTO(document, tpl.getDriverInfo());
			// 反射调用医疗单加载方法
//		    return ReflClassUtils.ReflCallWith(save.getDriverInfo().getEmsBackendDriver(), "save", ctx, EmsSaveDTO[].class, new EmsSaveDTO[] { save });
			EmsRstDTO[] rst=new EmsHerbsSave4CP().save(ctx, new EmsSaveDTO[] { save });
			return rst;
			
		}
		return null;
	}
	
	@Override
	protected void setEmsViewInfo(CiEnContextDTO ctx, MedSrvDO medSrvInfo, EmsDriverInfo driverinfo,
			OrderListViewDTO orderListViewDTO, String code_or, int index, HpCpElemOrderDO eleord) throws BizException {
		// TODO Auto-generated method stub
		
		super.setEmsViewInfo(ctx, medSrvInfo, driverinfo, orderListViewDTO, code_or, index,eleord);
		EmsHerbsViewDTO herb = (EmsHerbsViewDTO)orderListViewDTO;
//		herb.setId_boil(medSrvInfo.getId_boil());
//		herb.setName_boil(medSrvInfo.getBoil_name());
//		herb.setId_boildes(medSrvInfo.getId_boildes());
//		herb.setName_boildes(medSrvInfo.getBoildes_name());

        Integer orders = 1;
		try{
			orders = ParamUtils.GetOrgParamIntegerValue(ICiOrdCustomSysParamConst.LL_PARAM_HERB_EFAULT_ORDERS);
		}catch(Exception e){
			orders = Integer.valueOf(EmsConstEnum.HBORDERS);
		}
		herb.setOrders(orders);
		herb.setFg_boil(FBoolean.TRUE);//代煎标识
		herb.setOrders_boil(orders);//代煎付数
//		herb.setId_routedes(ortmpldo.getId_routedes());
//		herb.setName_routedes(ortmpldo.getOrtmpl_routedes_name());
		herb.setQuan_cur(OrderEmsQuanUtil.getMMQuan_cur(herb.getSd_mupkgutp(),herb.getQuan_med(),herb.getFactor_mb(),herb.getFactor_cb(),herb.getOrders()));
		herb.setAmt_total(new FDouble(herb.getPri().getDouble() * herb.getQuan_cur().getDouble()));
//		herb.setFg_nothingwithorders(ortplnitmdo.getFg_nothingwithorders());//付数无关标识
		herb.setFg_long(FBoolean.FALSE);
		herb.setQuan_firday_mp(1);
		this.setDesOr(herb);
		
	}
	
	/**
	 * 设置医嘱嘱托信息
	 * @param herb
	 * @throws BizException 
	 */
	private void setDesOr(EmsHerbsViewDTO herb) throws BizException{

        herb.setDes_or(CiOrdUtils.genOrdDes(herb));

	}

}
