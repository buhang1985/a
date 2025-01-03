package iih.ci.ord.s.ems.ip.assi.cp.pathgy;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.dws.ip.ems.d.EmsPathgyViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseCpSaveBP;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
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
 * 临床路径 - 病理保存
 *
 */
public class CpPathgySaveBP extends BaseCpSaveBP {
	
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		EmsSaveDTO tpl = ems[0];
		FArrayList pathgylist = tpl.getDocument();
		if (CiOrdUtils.isEmpty(pathgylist))
			return null;
		DocinfoDTO docinfo = (DocinfoDTO) pathgylist.get(0);		
		FArrayList srvinfoList = docinfo.getRefeleitems();
		for (Object object : srvinfoList) {
			FArrayList document = new FArrayList();
			String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
			DocSrvinfoDTO srv=(DocSrvinfoDTO) object;
			HpCpElemOrderDO[] ords=ServiceFinder.find(IHpCpElemOrderDORService.class).find(" id_ele='"+srv.getId_ele()+"'","",FBoolean.FALSE);
			if(ords!=null&&ords.length>0) {
				// 获取主服务信息
				MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(srv.getId_srv());
				// 拼装医疗单ui
				EmsPathgyViewDTO pathgy = new EmsPathgyViewDTO();
				setEmsViewInfo( ctx,  medSrvInfo, tpl.getDriverInfo(),
						pathgy,  code_or,  1,  ords[0]);
				// 计算物资流向科室
				this.setOrWfDeptInfo(ctx, medSrvInfo, pathgy);
				document.add(pathgy);
				EmsSaveDTO save = super.getEmsSaveDTO(document, tpl.getDriverInfo());
				return new EmsPathgySave4CP().save(ctx, new EmsSaveDTO[] {save});
			}				
		}
		return null;
	}
	
	@Override
	protected void setEmsViewInfo(CiEnContextDTO ctx, MedSrvDO medSrvInfo, EmsDriverInfo driverinfo,
			OrderListViewDTO orderListViewDTO, String code_or, int index, HpCpElemOrderDO eleord) throws BizException {
		// TODO Auto-generated method stub		
		super.setEmsViewInfo(ctx, medSrvInfo, driverinfo, orderListViewDTO, code_or, index,eleord);
		MedSrvLisDO[] medSrvLisDOs = ServiceFinder.find(IMedSrvLisDORService.class).find(String.format("a1.id_srv='%s'", medSrvInfo.getId_srv()), "", FBoolean.FALSE);
		if (null == medSrvLisDOs || medSrvLisDOs.length == 0) {
			return;
		}
		EmsPathgyViewDTO pathgy = (EmsPathgyViewDTO) orderListViewDTO;
		pathgy.setId_samptp(medSrvLisDOs[0].getId_samptp());//标本类型ID
		pathgy.setSd_samptp(medSrvLisDOs[0].getSd_samptp());//标本类型编码
		pathgy.setName_samptp(medSrvLisDOs[0].getSamptp_name());//标本类型
		pathgy.setDes_sympsign(OrderUtils.getClinicalzztzInfo(ctx.getId_en()));//病情描述
		pathgy.setFg_outer(FBoolean.FALSE);//是否外院
		pathgy.setOrg_pathgy_old(ctx.getName_grp());//既往医院
		pathgy.setId_emp(ctx.getId_emp_or());//采集者ID
		pathgy.setName_emp(ctx.getName_emp_or());//采集者
		pathgy.setDt_coll(CiOrdAppUtils.getServerDateTime());//采集时间
		pathgy.setNo_applyform(CiOrdUtils.getApplyNo(medSrvInfo.getSd_srvtp()));
		pathgy.setQuan_med((CiOrdUtils.isTrue(medSrvInfo.getIsmuldose()) ? eleord.getDosage() : new FDouble(1)));// 剂量
		pathgy.setDays_or(1);
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
		if (diagOutlineInfo != null) {
			pathgy.setId_di(diagOutlineInfo.getId_di());// 主诊断的主项目id
			pathgy.setId_diitm(diagOutlineInfo.getId_diitm());// 主诊断id
			pathgy.setName_diitm(diagOutlineInfo.getName_diag());// 主诊断名称
		}
		}

}
