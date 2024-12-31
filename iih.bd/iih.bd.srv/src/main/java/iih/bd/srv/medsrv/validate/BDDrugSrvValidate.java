package iih.bd.srv.medsrv.validate;

import java.util.ArrayList;
import java.util.List;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.routedosage.d.RouteDosageRefDO;
import iih.bd.srv.routedosage.i.IRoutedosageRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/// <summary>
/// <para>描    述 :  药品基础数据检查                   			</para>
/// <para>说    明 :                     			</para>
/// <para>项目名称 :  iih.bd.srv.medsrv.validate    </para>    
/// <para>类 名 称 :  BDDrugInfoValidate					</para> 
/// <para>版 本 号 :  v1.0.0.0           			</para> 
/// <para>作    者 :  qzwang         				</para> 
/// <para>修 改 人 :  qzwang         				</para> 
/// <para>创建时间 :  10/19/2016 8:58:53 PM             </para>
/// <para>更新时间 :  10/19/2016 8:58:53 PM             </para> 
/// <para>Copyright @ 北大医信（IIH项目组） 2016. all rights reserved.</para> 
/// </summary>
public class BDDrugSrvValidate extends BDSetSrvValidate {

	public Boolean CheckValidate( MedSrvDO medsrv, List<BDErrorInfo> errorList) throws BizException {
		BDErrorInfo info = new BDErrorInfo(medsrv.getId_srv(), medsrv.getName());
		if (!super.CheckValidate(medsrv, errorList))
			info = errorList.get(errorList.size() - 1);

		MedSrvDrugDO[] szMedSrvDrugDO = ServiceFinder.find(IMedSrvDrugDORService.class).find(String.format(" id_srv='%s' ",medsrv.getId_srv()), "", FBoolean.FALSE);
		if(szMedSrvDrugDO==null || szMedSrvDrugDO.length<=0){
			info.getDescList().add("药品属性表为空");
		}
		else{
			CheckDrugRouteInfo(medsrv,szMedSrvDrugDO,info.getDescList());//药品剂型与用法校验
			CheckDrugBaseInfo(szMedSrvDrugDO[0], info.getDescList());
		}
		
		if(medsrv.getFg_ctm()==FBoolean.FALSE ){
			IMeterialMDORService iCiemrRService = ServiceFinder.find(IMeterialMDORService.class);
			MeterialDO[] mmDos=iCiemrRService.find(" a0.id_srv='"+ medsrv.getId_srv()+"'", null, FBoolean.FALSE);
			if(mmDos == null || mmDos.length<=0){
				info.getDescList().add("服务关联物品为空");
				
			}else{
				List<MeterialDO> activemms=new ArrayList<MeterialDO>();

				for(MeterialDO mm : mmDos){
					if(mm.getFg_active() != null && mm.getFg_active()==FBoolean.TRUE){
						activemms.add(mm);
					}
				}

				if(activemms.size()<=0){
					info.getDescList().add("服务关联物品中不存在启用的物品");
					if (!errorList.contains(info))
						errorList.add(info);
					return false;
				}else{
					for(MeterialDO acmm : activemms){
						BDErrorInfo mminfo = new BDErrorInfo(acmm.getId_mm(),acmm.getName());
						CheckDrugMmDesInfo(acmm,mminfo.getDescList());
						if (mminfo.getDescList().size()>0||mminfo.getSubItems().size() > 0)
							info.getSubItems().add(mminfo);
					}
				}
			}
		}
		

		if ((info.getDescList().size() > 0||info.getSubItems().size()>0)&&!errorList.contains(info)){
			errorList.add(info);
		}

		return info.getDescList().size() == 0&&info.getSubItems().size() == 0;
	}

	protected  void CheckDrugBaseInfo(MedSrvDrugDO s, List<String> e)
	{

		if (StringUtil.isEmpty(s.getId_dosage()))
		{
			e.add("药品剂型为空");
		}
		if (StringUtil.isEmpty(s.getSd_dosage()))
		{
			e.add("药品剂型编码为空");
		}
		if (StringUtil.isEmpty(s.getId_pois()))
		{
			e.add("毒麻分类为空");
		}
		if (StringUtil.isEmpty(s.getSd_pois()))
		{
			e.add("毒麻分类编码为空");
		}
		if (StringUtil.isEmpty(s.getId_anti()))
		{
			e.add("抗菌药分类为空");
		}
		if (StringUtil.isEmpty(s.getSd_anti()))
		{
			e.add("抗菌药分类编码为空");
		}
	}

	protected  void CheckDrugMmDesInfo(MeterialDO s, List<String> e)
	{
		if (StringUtil.isEmpty(s.getSpec()))
		{
			e.add("关联物品规格为空");
		}
		if (StringUtil.isEmpty(s.getId_unit_pkgbase()))
		{
			e.add("关联物品基本包装单位为空");
		}
		if (StringUtil.isEmpty(s.getName_unit_pkgbase()))
		{
			e.add("关联物品基本包装单位名称为空");
		}
		if (StringUtil.isEmpty(s.getId_unit_pkgsp()))
		{
			e.add("关联物品零售包装单位为空");
		}
		if (StringUtil.isEmpty(s.getName_unit_pkgsp()))
		{
			e.add("关联物品零售包装单位名称为空");
		}
		if (s.getFactor_sb()==null || s.getFactor_sb().toDouble()<=0)
		{
			e.add("关联物品换算系数（零基）为空");
		}
		if (s.getFactor_mb()==null||s.getFactor_mb().toDouble()<=0)
		{
			e.add("关联物品换算系数（医基）为空");
		}
		if (StringUtil.isEmpty(s.getSrv_id_unit_med()))
		{
			e.add("关联物品医学单位为空");
		}
		if (StringUtil.isEmpty(s.getId_mupkgutp()))
		{
			e.add("关联物品包装单位住院取整模式为空");
		}
		if (StringUtil.isEmpty(s.getSd_mupkgutp()))
		{
			e.add("关联物品包装单位住院取整模式编码为空");
		}
		if (StringUtil.isEmpty(s.getId_opmutp()))
		{
			e.add("关联物品包装单位门诊取整模式为空");
		}
		if (StringUtil.isEmpty(s.getSd_opmutp()))
		{
			e.add("关联物品包装单位门诊取整模式编码为空");
		}
		if (StringUtil.isEmpty(s.getId_unit_weight()))
		{
			if (StringUtil.isEmpty(s.getId_unit_volbase()))
			{
				// e.add("关联物品重量和体积不能同时为空"); // -- 暂时屏蔽规则（保证医学单位、零售单位、基本包装单位以及转换系数不为空即可）

			}
			else
			{
				if (s.getFactor_vb()==null||s.getFactor_vb().toDouble()<=0)
				{
					e.add("关联物品换算系数（体基）为空");
				}
			}
		}
		else
		{
			if (s.getFactor_wb()==null || s.getFactor_wb().toDouble()<=0)
			{
				e.add("关联物品换算系数（重量）为空");
			}
		}
		if (s.getFg_skin()==null)
		{
			e.add("关联物品皮试标志为空");
		}
		else
		{
			if (s.getFg_skin()!=null&&s.getFg_skin()==FBoolean.TRUE)
			{
				if (StringUtil.isEmpty(s.getId_skinca()))
				{
					e.add("关联物品皮试类型为空");
				}
				if (StringUtil.isEmpty(s.getSd_skinca()))
				{
					e.add("关联物品皮试类型编码为空");
				}
				if (StringUtil.isEmpty(s.getId_srvskin()))
				{
					e.add("关联物品皮试项目为空");
				}
			}
		}

	}

	protected  void CheckDrugRouteInfo(MedSrvDO medSrv, MedSrvDrugDO[] szMedSrvDrugDO, List<String> e) throws BizException
	{
		if (medSrv == null
				|| szMedSrvDrugDO.length == 0 
				|| StringUtil.isEmpty(szMedSrvDrugDO[0].getId_dosage()) 
				|| StringUtil.isEmpty(medSrv.getId_route())) 
			return;
		
		IRoutedosageRService routedosageService = ServiceFinder.find(IRoutedosageRService.class);
		RouteDosageRefDO[] routeDosagelist = routedosageService.find(" a0.id_dosage='" + szMedSrvDrugDO[0].getId_dosage() + "'", null, FBoolean.FALSE);
		if (routeDosagelist == null || routeDosagelist.length == 0) return;
		List<RouteDosageRefDO> refsDo=new ArrayList<RouteDosageRefDO>();
		for(RouteDosageRefDO refdo:routeDosagelist){
			if(refdo.getId_route().equals(medSrv.getId_route())){
				refsDo.add(refdo);
			}
		}
		if (refsDo.size() == 0)
		{
			e.add("当前服务用法与药品剂型不匹配");
		}
	}
}
